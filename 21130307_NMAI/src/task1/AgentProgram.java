package task1;

import task1.Action;
import task1.Environment;
import task1.NoOpAction;
import task1.Percept;
import task1.Environment.LocationState;

public class AgentProgram {

	public Action execute(Percept p) {// location, status
		// TODO
		if (p.getLocationState() == Environment.LocationState.DIRTY) {
			return Environment.SUCK_DIRT;
		} else if (p.getAgentLocation() == Environment.LOCATION_A) {
			return Environment.MOVE_RIGHT;
		} else if (p.getAgentLocation() == Environment.LOCATION_B) {
			return Environment.MOVE_LEFT;
		}

		return NoOpAction.NO_OP;

	}
}