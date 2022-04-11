package godzhell.model.players.packets.commands.all;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Optional;

import godzhell.model.content.bxp;
import godzhell.model.players.Player;
import godzhell.model.players.packets.commands.Command;

/**
 * Opens the vote page in the default web browser.
 *
 * @author Emiel
 */
public class Claimvotes extends Command {

	
	public static final String HOST = "162.252.9.68";
	public static final String USER = "playang1_forumadmin";
	public static final String PASS = "FCc4QfvZuy#FV}T?~O";
	public static final String DATABASE = "playang1_kingfoxvote";

	private Connection conn;
	private Statement stmt;
	private Player player;

	public void FoxVote(Player player) {
		this.player = player;
	}

	@Override

	public void execute(Player player, String input) {
		try {
			if (!connect(HOST, DATABASE, USER, PASS)) {
				return;
			}

			String name = player.playerName.replace(" ", "_");
			ResultSet rs = executeQuery("SELECT * FROM fx_votes WHERE username='"+name+"' AND claimed=0 AND callback_date IS NOT NULL");

			while (rs.next()) {
				String timestamp = rs.getTimestamp("callback_date").toString();
				String ipAddress = rs.getString("ip_address");
				int siteId = rs.getInt("site_id");


				// -- ADD CODE HERE TO GIVE TOKENS OR WHATEVER


				System.out.println("Vote claimed by "+name+". (sid: "+siteId+", ip: "+ipAddress+", time: "+timestamp+")");

				rs.updateInt("claimed", 1); // do not delete otherwise they can reclaim!
				//add reward system here
				//bxp.addTime(reward[0].give_amount + 2);
                //player.getItems().addItemUnderAnyCircumstance(reward[0].reward_id, reward[0].give_amount);
                //player.sendMessage("@cr10@Thank you for voting! You have been given " + reward[0].give_amount + " vote points.");
				rs.updateRow();
			}

			destroy();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	public boolean connect(String host, String database, String user, String pass) {
		try {
			this.conn = DriverManager.getConnection("jdbc:mysql://"+host+":3306/"+database, user, pass);
			System.out.print("GOT CONNECTED BISH");
			return true;
		} catch (SQLException e) {
			System.out.print("Failing connecting to database! jdbc:mysql://"+host+":3306/"+database);
			return false;
		}
	}

	public void destroy() {
        try {
    		conn.close();
        	conn = null;
        	if (stmt != null) {
    			stmt.close();
        		stmt = null;
        	}
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

	public int executeUpdate(String query) {
        try {
        	this.stmt = this.conn.createStatement(1005, 1008);
            int results = stmt.executeUpdate(query);
            return results;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return -1;
    }

	public ResultSet executeQuery(String query) {
        try {
        	this.stmt = this.conn.createStatement(1005, 1008);
            ResultSet results = stmt.executeQuery(query);
            return results;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
	


        /*String[] args = input.split(" ");
        if (args.length == 1) {
            player.sendMessage("Please use [::claimvotes 1 amount], or [::claimvotes 1 all].");
            player.sendMessage("1 Vote ticket is 1 Vote point.");
            return;
        }
        final String playerName = player.playerName;
        final String id = args[0];
        final String amount = args[1];
        com.everythingrs.vote.Vote.service.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    com.everythingrs.vote.Vote[] reward = com.everythingrs.vote.Vote.reward("1yas9sbywkw3j71agw4iiicnmi251x4tx8auv1vcz8c2d0io1orma598wc2jvhvgxtmhu4k7qfr",
                            playerName, id, amount);
                    if (reward[0].message != null) {
                        player.sendMessage(reward[0].message);
                        return;
                    }
                    bxp.addTime(reward[0].give_amount + 2);
                    player.getItems().addItemUnderAnyCircumstance(reward[0].reward_id, reward[0].give_amount);
                    player.sendMessage(
                            "@cr10@Thank you for voting! You have been given " + reward[0].give_amount + " vote points.");
                } catch (Exception e) {
                    player.sendMessage("Api Services are currently offline. Please check back shortly");
                    e.printStackTrace();
                }
            }

        });
    }

    @Override
    public Optional<String> getDescription() {
        return Optional.of("Claims your vote from ::vote");
    }

    @Override
    public Optional<String> getParameter() {
        return Optional.of("id# amount#");
    }*/
}

