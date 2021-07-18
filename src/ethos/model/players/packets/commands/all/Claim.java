package ethos.model.players.packets.commands.all;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import ethos.model.content.bxp;
import ethos.model.items.ItemAssistant;
import ethos.model.players.Player;
import ethos.model.players.PlayerHandler;
import ethos.model.players.packets.commands.Command;


import ethos.model.players.Player;
import ethos.model.players.packets.commands.Command;

/**
 * Auto Donation System / https://EverythingRS.com
 * @author Genesis
 *
 */

public class Claim extends Command {

	public static final String HOST = "162.252.9.68";
	public static final String USER = "playang1_forumadmin";
	public static final String PASS = "FCc4QfvZuy#FV}T?~O";
	public static final String DATABASE = "playang1_donate";
	
	private Player player;
	private Connection conn;
	private Statement stmt;
	
	/**
	 * The constructor
	 * @param player
	 * @return 
	 */
	public void Donation(Player player) {
		this.player = player;
	}
	
	@Override
	public void execute(Player player, String input) {
		try {
			if (!connect(HOST, DATABASE, USER, PASS)) {
				return;
			}

			String name = player.getName().replace("_", " ");
			
			//String name = player.getUsername().replace("_", " ");
			ResultSet rs = executeQuery("SELECT * FROM payments WHERE player_name='"+name+"' AND status='Completed' AND claimed=0");

			while (rs.next()) {
				int item_number = rs.getInt("item_number");
				double paid = rs.getDouble("amount");
				int quantity = rs.getInt("quantity");

				switch (item_number) {// add products according to their ID in the ACP

				case 1: //gold
					player.getItems().addItem(995, quantity);
					player.sendMessage("@yel@You successfully claimed your @blu@" + quantity + " " + ItemAssistant.getItemName(995) + "@bla@. @yel@Thank you for supporting Anguish!");
					break;
				case 2://mbox
					player.getItems().addItem(13346, quantity);
					player.sendMessage("@yel@You successfully claimed your @blu@" + quantity + " " + ItemAssistant.getItemName(13346) + "@bla@. @yel@Thank you for supporting Anguish!");
					break;
				}

				rs.updateInt("claimed", 1); // do not delete otherwise they can reclaim!
				rs.updateRow();
				
			}

			destroy();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 *
	 * @param host the host ip address or url
	 * @param database the name of the database
	 * @param user the user attached to the database
	 * @param pass the users password
	 * @return true if connected
	 */
	public boolean connect(String host, String database, String user, String pass) {
		try {
			this.conn = DriverManager.getConnection("jdbc:mysql://"+host+":3306/"+database, user, pass);
			return true;
		} catch (SQLException e) {
			System.out.println("Failing connecting to database!");
			return false;
		}
	}

	/**
	 * Disconnects from the MySQL server and destroy the connection
	 * and statement instances
	 */
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

	/**
	 * Executes an update query on the database
	 * @param query
	 * @see {@link Statement#executeUpdate}
	 */
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

	/**
	 * Executres a query on the database
	 * @param query
	 * @see {@link Statement#executeQuery(String)}
	 * @return the results, never null
	 */
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
}
