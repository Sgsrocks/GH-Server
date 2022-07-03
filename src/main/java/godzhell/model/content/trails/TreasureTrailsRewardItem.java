package godzhell.model.content.trails;

import com.google.common.collect.Lists;
import godzhell.model.items.GameItem;
import godzhell.util.Misc;

import java.util.List;
import java.util.Optional;

public class TreasureTrailsRewardItem extends GameItem {
	public static List<GameItem> toGameItems(List<TreasureTrailsRewardItem> list) {
		List<GameItem> items = Lists.newArrayList();
		for (TreasureTrailsRewardItem reward : list) {
			Optional<GameItem> existing = items.stream().filter(it -> it.getId() == reward.getItemId()).findFirst();
			if (existing.isPresent()) {
				GameItem gameItem = existing.get();
				gameItem.setAmount(gameItem.getAmount() + reward.getRandomAmount());
				continue;
			}

			items.add(reward.toGameItem());
		}

		return items;
	}
	public GameItem toGameItem() {
		return new GameItem(itemId, getRandomAmount());
	}


	private final int itemId;
	private int minAmount;
	private int maxAmount;
	private int amount = -1;

	public TreasureTrailsRewardItem(int id, int minAmount, int maxAmount) {
		super(id);
		this.itemId = id;
		this.minAmount = minAmount;
		this.maxAmount = maxAmount;
	}

	@Override
	public int getAmount() {
		if (amount < 0) {
			amount = Misc.random(maxAmount - minAmount) + minAmount;
		}
		return amount;
	}

	public int getItemId() {
		return itemId;
	}

	public int getMinAmount() {
		return minAmount;
	}

	public void setMinAmount(int minAmount) {
		this.minAmount = minAmount;
	}

	public int getMaxAmount() {
		return maxAmount;
	}
	public int getRandomAmount() {
		return Misc.random(getMinAmount(), getMaxAmount());
	}

	public void setMaxAmount(int maxAmount) {
		this.maxAmount = maxAmount;
	}

	@Override
	public String toString() {
		return "RewardItem [id=" + super.getId() + ", minAmount=" + minAmount + ", maxAmount=" + maxAmount + "]";
	}

}
