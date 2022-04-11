package godzhell.model.players.combat.specials;

import godzhell.model.entity.Entity;
import godzhell.model.players.Player;
import godzhell.model.players.combat.Damage;
import godzhell.model.players.combat.Special;
import godzhell.model.content.skills.Skill;

public class DragonHarpoon extends Special {
	public DragonHarpoon() {
		super(10.0, 2.0, 2.0, new int[] { 21028 });
	}

	@Override
	public void activate(Player player, Entity target, Damage damage) {
		player.specAmount = 0.0;
		player.usingSpecial = false;
		player.getItems().updateSpecialBar();
		player.getItems().addSpecialBar(player.playerEquipment[player.playerWeapon]);
		player.forcedChat("Here fishy fishies!");
		player.startAnimation(7393);
		player.gfx0(246);
		player.playerLevel[Skill.FISHING.getId()] += 3;
		player.getPA().refreshSkill(Skill.FISHING.getId());
	}


	@Override
	public void hit(Player player, Entity target, Damage damage) {

	}
}
