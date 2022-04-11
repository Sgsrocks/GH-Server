package godzhell.model.content.skills.construction;

import godzhell.model.content.dialogue.Dialogue;
import godzhell.model.content.dialogue.DialogueConstants;
import godzhell.model.content.dialogue.DialogueManager;

public class RoomDialogue extends Dialogue {

	@Override
	public void execute() {
		switch(getNext()) {
		case 0:
			DialogueManager.sendOption(getPlayer(), "North", "East", "South", "West");
			break;
		}
		// TODO Auto-generated method stub

	}
	@Override
	public boolean clickButton(int id) {
		switch(id) {
		case DialogueConstants.OPTIONS_4_1:
			if (getPlayer().replaceWith == null) {
				try {
					getPlayer().replaceWith = (Room) Class.forName(getPlayer().toReplace.getClassName()).newInstance();
				} catch (Exception e) {
					e.printStackTrace();
					return false;
				}
			}
			getPlayer().replaceWith.setRotation(0);
			getPlayer().getHouse().buildRoom(getPlayer());
			end();
			break;
		case DialogueConstants.OPTIONS_4_2:
				if (getPlayer().replaceWith == null) {
					try {
						getPlayer().replaceWith = (Room) Class.forName(getPlayer().toReplace.getClassName()).newInstance();
					} catch (Exception e) {
						e.printStackTrace();
						return false;
					}
				}
				getPlayer().replaceWith.setRotation(1);
				getPlayer().getHouse().buildRoom(getPlayer());
				end();
			break;
		case DialogueConstants.OPTIONS_4_3:
				if (getPlayer().replaceWith == null) {
					try {
						getPlayer().replaceWith = (Room) Class.forName(getPlayer().toReplace.getClassName()).newInstance();
					} catch (Exception e) {
						e.printStackTrace();
						return false;
					}
				}
				getPlayer().replaceWith.setRotation(2);
				getPlayer().getHouse().buildRoom(getPlayer());
				end();
			break;
		case DialogueConstants.OPTIONS_4_4:
			if (getPlayer().replaceWith == null) {
				try {
					getPlayer().replaceWith = (Room) Class.forName(getPlayer().toReplace.getClassName()).newInstance();
				} catch (Exception e) {
					e.printStackTrace();
					return false;
				}
			}
			getPlayer().replaceWith.setRotation(3);
			getPlayer().getHouse().buildRoom(getPlayer());
			end();
			break;
		}
		return false;
	}
}
