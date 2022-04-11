package godzhell.model.content.skills.fletching;

import godzhell.Config;
import godzhell.event.Event;
import godzhell.model.content.achievement_diary.kandarin.KandarinDiaryEntry;
import godzhell.model.content.achievement_diary.western_provinces.WesternDiaryEntry;
import godzhell.model.content.dailytasks.DailyTasks;
import godzhell.model.content.dailytasks.DailyTasks.PossibleTasks;
import godzhell.model.players.Boundary;
import godzhell.model.players.Player;
import godzhell.model.players.mode.ModeType;
import godzhell.model.content.skills.Skill;

public class StringBowEvent extends Event<Player> {

	private FletchableBow bow;

	public StringBowEvent(FletchableBow bow, Player attachment, int ticks) {
		super("skilling", attachment, ticks);
		this.bow = bow;
	}

	@Override
	public void execute() {
		if (attachment == null || attachment.disconnected || attachment.getSession() == null) {
			stop();
			return;
		}
		if (!attachment.getItems().playerHasItem(bow.getItem()) || !attachment.getItems().playerHasItem(1777)) {
			stop();
			return;
		}
		switch (bow.getProduct()) {
		case 853:
			if (Boundary.isIn(attachment, Boundary.SEERS_BOUNDARY)) {
				attachment.getDiaryManager().getKandarinDiary().progress(KandarinDiaryEntry.STRING_MAPLE_SHORT);
			}
			break;
		
		case 857:
			DailyTasks.increase(attachment, PossibleTasks.YEW_SHORTBOWS);
			break;
			
		case 859:
			if (Boundary.isIn(attachment, Boundary.LLETYA_BOUNDARY)) {
				attachment.getDiaryManager().getWesternDiary().progress(WesternDiaryEntry.STRING_MAGE_LONG);
			}
			break;
		}
		attachment.startAnimation(bow.getAnimation());
		attachment.getItems().deleteItem2(bow.getItem(), 1);
		attachment.getItems().deleteItem2(1777, 1);
		attachment.getItems().addItem(bow.getProduct(), 1);
		attachment.getPA().addSkillXP((int) bow.getExperience() * (attachment.getMode().getType().equals(ModeType.OSRS) ? 4 : Config.FLETCHING_EXPERIENCE), Skill.FLETCHING.getId(), true);
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
