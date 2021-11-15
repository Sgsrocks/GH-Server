package ethos.model.content.skills.construction;

import ethos.model.players.Player;
import ethos.model.content.skills.Skill;
import ethos.model.content.skills.construction.rooms.*;


public class Rooms {
	
	public static final Room DEFAULT = new Default();
	public static final Room GARDEN = new Garden();
	public static final Room THRONE = new Throne();
	public static final Room GAME = new Game();
	public static final Room COSTUME_ROOM = new CostumeRoom();
	
	public static final Room PARLOUR = new Parlour();
	public static final Room KITCHEN = new Kitchen();
	public static final Room DINING = new Dining();
	public static final Room WORKSHOP = new Workshop();
	public static final Room BEDROOM = new Bedroom();
	public static final Room SKILLHALL = new SkillHall();
	public static final Room COMBAT = new Combat();
	public static final Room QUEST_HALL = new QuestHall();
	public static final Room STUDY = new Study();
	public static final Room CHAPEL = new Chapel();
	public static final Room PORTAL_CHAMBER = new PortalChamber();
	public static final Room FORMAL_GARDEN = new FormalGarden();
	public static final Room OUBILIETTE = new Oubiliette();
	public static final Room CORRIDOR_DUNGEON = new CorridorDungeon();
	public static final Room JUNCTION_DUNGEON = new JunctionDungeon();
	public static final Room STAIRS_DUNGEON = new StairsDungeon();
	public static final Room TREASURE_ROOM = new TreasureRoom();

	private final static Object[][] CON_ROOMS = new Object[][] { 
		{1, GARDEN},
		{1, PARLOUR},
		{5, KITCHEN},
		{10, DINING},
		{15, THRONE},
		{15, WORKSHOP},
		{15, BEDROOM},
		{25, SKILLHALL},
		{30, GAME},
		{32, COMBAT},
		{35, QUEST_HALL},
		{40, STUDY},
		{42, COSTUME_ROOM},
		{45, CHAPEL},
		{50, PORTAL_CHAMBER},
		{55, FORMAL_GARDEN},
		{60, THRONE},
		{65, OUBILIETTE},
		{70, CORRIDOR_DUNGEON},
		{70, JUNCTION_DUNGEON},
		{70, STAIRS_DUNGEON},
		{75, TREASURE_ROOM}
		};
	
	public static Room Build(Player c) {		
		if (c.playerLevel[22] >= (int) CON_ROOMS[c.RoomClicked][0]) {
			return (Room) CON_ROOMS[c.RoomClicked][1];
		}
		return DEFAULT;
	}

}
