package godzhell.event.impl;

import godzhell.event.Event;
import godzhell.model.entity.Entity;
import godzhell.model.entity.Health;
import godzhell.model.entity.HealthStatus;

public class VenomResistanceEvent extends Event<Entity> {

	public VenomResistanceEvent(Entity attachment, int ticks) {
		super("venom_resistance_event", attachment, ticks);
	}

	@Override
	public void execute() {
		super.stop();
		if (attachment == null) {
			return;
		}
		Health health = attachment.getHealth();
		health.removeNonsusceptible(HealthStatus.VENOM);
	}

}
