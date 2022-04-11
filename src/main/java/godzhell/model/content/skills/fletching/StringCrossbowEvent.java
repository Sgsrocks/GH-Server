package godzhell.model.content.skills.fletching;

import godzhell.Config;
import godzhell.event.Event;
import godzhell.model.players.Player;
import godzhell.model.players.mode.ModeType;
import godzhell.model.content.skills.Skill;

public class StringCrossbowEvent extends Event<Player> {

	private FletchableCrossbow crossbow;

	public StringCrossbowEvent(FletchableCrossbow b, Player attachment, int ticks) {
		super("skilling", attachment, ticks);
		this.crossbow = b;
	}

	@Override
	public void execute() {
		if (attachment == null || attachment.disconnected || attachment.getSession() == null) {
			stop();
			return;
		}
		if (!attachment.getItems().playerHasItem(crossbow.getItem()) || !attachment.getItems().playerHasItem(9438)) {
			stop();
			return;
		}
		attachment.startAnimation(crossbow.getAnimation());
		attachment.getItems().deleteItem2(crossbow.getItem(), 1);
		attachment.getItems().deleteItem2(9438, 1);
		attachment.getItems().addItem(crossbow.getProduct(), 1);
		attachment.getPA().addSkillXP((int) crossbow.getExperience() * (attachment.getMode().getType().equals(ModeType.OSRS) ? 4 : Config.FLETCHING_EXPERIENCE), Skill.FLETCHING.getId(), true);
	}

	@Override
	public void stop() {
		super.stop();
		if (attachment == null || attachment.disconnected || attachment.getSession() == null) {
			return;
		}
		attachment.stopAnimation();
	}

}
