package godzhell;

import java.net.InetSocketAddress;
import java.text.SimpleDateFormat;
import java.util.Objects;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import godzhell.event.impl.BonusXPEvent;
import godzhell.model.content.bxp;
import godzhell.model.players.Player;
import org.jboss.netty.bootstrap.ServerBootstrap;
import org.jboss.netty.channel.socket.nio.NioServerSocketChannelFactory;
import org.jboss.netty.util.HashedWheelTimer;

import godzhell.cache.Cache;
import godzhell.cache.object.GameObjectData;
import godzhell.cache.object.ObjectLoader;
import godzhell.clip.ObjectDef;
import godzhell.clip.Region;
import godzhell.clip.doors.DoorDefinition;
import godzhell.definitions.AnimationDefinition;
import godzhell.definitions.ItemCacheDefinition;
import godzhell.definitions.NPCCacheDefinition;
import godzhell.event.CycleEventHandler;
import godzhell.event.EventHandler;
import godzhell.event.impl.BonusApplianceEvent;
import godzhell.event.impl.SkeletalMysticEvent;
import godzhell.event.impl.WheatPortalEvent;
import godzhell.model.content.godwars.GodwarsEquipment;
import godzhell.model.content.godwars.GodwarsNPCs;
import godzhell.model.content.music.MusicLoader;
import godzhell.model.content.tradingpost.Listing;
import godzhell.model.content.trails.CasketRewards;
import godzhell.model.content.wogw.Wogw;
import godzhell.model.holiday.HolidayController;
import godzhell.model.items.ItemDefinition;
import godzhell.model.minigames.FightPits;
import godzhell.model.minigames.pk_arena.Highpkarena;
import godzhell.model.minigames.pk_arena.Lowpkarena;
import godzhell.model.multiplayer_session.MultiplayerSessionListener;
import godzhell.model.npcs.NPCHandler;
import godzhell.model.npcs.NPCSpawns;
import godzhell.model.npcs.drops.DropManager;
import godzhell.model.objects.Doors;
import godzhell.model.objects.DoubleDoors;
import godzhell.model.players.PlayerHandler;
import godzhell.model.players.PlayerSave;
import godzhell.model.players.combat.monsterhunt.MonsterHunt;
import godzhell.model.players.packets.Commands;
import godzhell.net.PipelineFactory;
import godzhell.punishments.PunishmentCycleEvent;
import godzhell.punishments.Punishments;
import godzhell.server.data.ServerData;
import godzhell.util.ControlPanel;
import godzhell.util.date.GameCalendar;
import godzhell.util.json.EquipmentRequirementLoader;
import godzhell.util.log.Logger;
import godzhell.world.ClanManager;
import godzhell.world.GlobalDropsHandler;
import godzhell.world.ItemHandler;
import godzhell.world.ObjectHandler;
import godzhell.world.ObjectManager;
import godzhell.world.ShopHandler;
import godzhell.world.objects.GlobalObjects;

/**
 * The main class needed to start the server.
 * 
 * @author Sanity
 * @author Graham
 * @author Blake
 * @author Ryan Lmctruck30 Revised by Shawn Notes by Shawn
 */
public class Server {

	private static final Punishments PUNISHMENTS = new Punishments();

	private static final DropManager dropManager = new DropManager();

	/**
	 * A class that will manage game events
	 */
	private static final EventHandler events = new EventHandler();

	/**
	 * Represents our calendar with a given delay using the TimeUnit class
	 */
	private static GameCalendar calendar = new godzhell.util.date.GameCalendar(
			new SimpleDateFormat("yyyy/MM/dd HH:mm:ss"), "GMT-3:00");

	private static HolidayController holidayController = new HolidayController();

	private static MultiplayerSessionListener multiplayerSessionListener = new MultiplayerSessionListener();

	public static GlobalObjects globalObjects = new GlobalObjects();

	/**
	 * ClanChat Added by Valiant
	 */
	public static ClanManager clanManager = new ClanManager();

	public static ControlPanel panel = new ControlPanel(true); // false if you want it off
	/**
	 * Sleep mode of the server.
	 */
	public static boolean sleeping;
	/**
	 * The test thingy
	 */
	public static boolean canGiveReward;

	public static long lastReward = 0;
	/**
	 * Calls the rate in which an event cycles.
	 */
	public static final int cycleRate;

	/**
	 * Server updating.
	 */
	public static boolean UpdateServer = false;

	/**
	 * Calls in which the server was last saved.
	 */
	public static long lastMassSave = System.currentTimeMillis();

	private static long sleepTime;

	/**
	 * Forced shutdowns.
	 */
	public static boolean shutdownServer = false;
	public static boolean shutdownClientHandler;

	public static boolean canLoadObjects = false;

	/**
	 * Used to identify the server port.
	 */
	public static int serverlistenerPort;

	/**
	 * Contains data which is saved between sessions.
	 */
	public static ServerData serverData = new ServerData();

	/**
	 * Calls the usage of player items.
	 */
	public static ItemHandler itemHandler = new ItemHandler();

	/**
	 * Handles logged in players.
	 */
	public static PlayerHandler playerHandler = new PlayerHandler();

	/**
	 * Handles global NPCs.
	 */
	public static NPCHandler npcHandler = new NPCHandler();

	public static ObjectManager objectManager = new ObjectManager();
	/**
	 * Handles global shops.
	 */
	public static ShopHandler shopHandler = new ShopHandler();

	public static ObjectHandler objectHandler = new ObjectHandler();
	/**
	 * 
	 * Handles the fightpits minigame.
	 */
	public static FightPits fightPits = new FightPits();

	/**
	 * Handles the main game processing.
	 */
	private static final ScheduledExecutorService GAME_THREAD = Executors.newSingleThreadScheduledExecutor();

	private static final ScheduledExecutorService IO_THREAD = Executors.newSingleThreadScheduledExecutor();

	static {
		serverlistenerPort = Config.SERVER_STATE.getPort();
		cycleRate = 600;
		shutdownServer = false;
		sleepTime = 0;
	}

	private static final Runnable SERVER_TASKS = () -> {
		try {
			itemHandler.process();
			playerHandler.process();
			npcHandler.process();
			shopHandler.process();
			Highpkarena.process();
			Lowpkarena.process();
			globalObjects.pulse();
			CycleEventHandler.getSingleton().process();
			events.process();
			serverData.processQueue();
			objectManager.process();
		} catch (Throwable t) {
			t.printStackTrace();
			t.getCause();
			t.getMessage();
			t.fillInStackTrace();
			System.out.println("Server tasks - Check for error");
			PlayerHandler.stream().filter(Objects::nonNull).forEach(PlayerSave::save);
		}
	};

	private static final Runnable IO_TASKS = () -> {
		try {
			// TODO tasks(players online, etc)
		} catch (Throwable t) {
			t.printStackTrace();
		}
	};
	public static void main(java.lang.String args[]) {
		com.everythingrs.service.Service.scheduledService.scheduleAtFixedRate(new Runnable() {
			@Override
			public void run() {
			}
		}, 0, 5, java.util.concurrent.TimeUnit.SECONDS);
		try {
			long startTime = System.currentTimeMillis();
			//System.setOut(extracted());

			PUNISHMENTS.initialize();
			// events.submit(new DidYouKnowEvent());
			events.submit(new WheatPortalEvent());
			events.submit(new BonusApplianceEvent());
			events.submit(new SkeletalMysticEvent());
			events.submit(new PunishmentCycleEvent(PUNISHMENTS, 50));
			events.submit(new BonusXPEvent());
            //Cache.load();
			Listing.loadNextSale();
			//Wogw.init();
			//bxp.init();
			ItemDefinition.load();
			DoorDefinition.load();
			GodwarsEquipment.load();
			GodwarsNPCs.load();
			try {
				new MusicLoader().load();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			dropManager.read();
			ItemCacheDefinition.unpackConfig();
			NPCCacheDefinition.unpackConfig();
			AnimationDefinition.unpackConfig();
			CasketRewards.read();
			ObjectDef.loadConfig();
			NPCSpawns.loadNPCSpawns();
			globalObjects.loadGlobalObjectFile();
			GlobalDropsHandler.initialize();
			new EquipmentRequirementLoader().load();
			//Doors.getSingleton().load();

			 //Load objects
			//ObjectLoader objectLoader = new ObjectLoader();
			//objectLoader.load();

			//GameObjectData.init();
			Doors.getSingleton().load();
			DoubleDoors.getSingleton().load();
			Region.load();
			bindPorts();
			MonsterHunt.spawnNPC();
			NPCHandler.loadDefs();
			holidayController.initialize();
			Runtime.getRuntime().addShutdownHook(new ShutdownHook());
			Commands.initializeCommands();
			long endTime = System.currentTimeMillis();
			long elapsed = endTime - startTime;
			System.out.println(Config.SERVER_NAME + " has successfully started up in " + elapsed + " milliseconds. On port " + serverlistenerPort);
			GAME_THREAD.scheduleAtFixedRate(SERVER_TASKS, 0, 600, TimeUnit.MILLISECONDS);
			IO_THREAD.scheduleAtFixedRate(IO_TASKS, 0, 30, TimeUnit.SECONDS);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static Logger extracted() {
		return new Logger(System.out);
	}

	/**
	 * Gets the sleep mode timer and puts the server into sleep mode.
	 */
	public static long getSleepTimer() {
		return sleepTime;
	}

	public static MultiplayerSessionListener getMultiplayerSessionListener() {
		return multiplayerSessionListener;
	}

	/**
	 * Java connection. Ports.
	 */
	private static void bindPorts() {
		ServerBootstrap serverBootstrap = new ServerBootstrap(
				new NioServerSocketChannelFactory(Executors.newCachedThreadPool(), Executors.newCachedThreadPool()));
		serverBootstrap.setPipelineFactory(new PipelineFactory(new HashedWheelTimer()));
		serverBootstrap.bind(new InetSocketAddress(serverlistenerPort));
	}

	public static GameCalendar getCalendar() {
		return calendar;
	}

	public static HolidayController getHolidayController() {
		return holidayController;
	}

	public static ServerData getServerData() {
		return serverData;
	}

	public static GlobalObjects getGlobalObjects() {
		return globalObjects;
	}

	public static EventHandler getEventHandler() {
		return events;
	}

	public static DropManager getDropManager() {
		return dropManager;
	}

	public static Punishments getPunishments() {
		return PUNISHMENTS;
	}

	public static String getStatus() {
		return "IO_THREAD\n" + "\tShutdown? " + IO_THREAD.isShutdown() + "\n" + "\tTerminated? "
				+ IO_THREAD.isTerminated();
	}
}