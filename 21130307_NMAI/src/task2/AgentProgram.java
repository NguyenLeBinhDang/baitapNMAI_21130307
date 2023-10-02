package task2;

import java.util.Random;

import task2.Action;
import task2.Environment;
import task2.NoOpAction;
import task2.Percept;
import task2.Environment.LocationState;

public class AgentProgram {

	public Action execute(Percept p) {// location, status
		// TODO
//		Random rd = new Random(2);
//		if (p.getLocationState() == Environment.LocationState.DIRTY) {
//			return Environment.SUCK_DIRT;
//		} else if (p.getAgentLocation() == Environment.LOCATION_A) {
//			if (rd.equals(0)) {
//				return Environment.MOVE_RIGHT;
//			} else if (rd.equals(1)) {
//				return Environment.MOVE_DOWN;
//			}
//		} else if (p.getAgentLocation() == Environment.LOCATION_B) {
//			if (rd.equals(0)) {
//				return Environment.MOVE_LEFT;
//			} else if (rd.equals(1)) {
//				return Environment.MOVE_DOWN;
//			}
//		} else if (p.getAgentLocation() == Environment.LOCATION_C) {
//			if (rd.equals(0)) {
//				return Environment.MOVE_LEFT;
//			} else if (rd.equals(1)) {
//				return Environment.MOVE_UP;
//			}
//		} else if (p.getAgentLocation() == Environment.LOCATION_D) {
//			if (rd.equals(0)) {
//				return Environment.MOVE_RIGHT;
//			} else if (rd.equals(1)) {
//				return Environment.MOVE_UP;
//			}
//		}

		Random rd = new Random();
		int dir = rd.nextInt(4);
		if (p.getLocationState() == Environment.LocationState.DIRTY) {
			return Environment.SUCK_DIRT;
		} else {
			switch (dir) {
			case 0:
//				System.out.println("up");
				return Environment.MOVE_UP;
			case 1:
//				System.out.println("down");
				return Environment.MOVE_DOWN;
			case 2:
//				System.out.println("left");
				return Environment.MOVE_LEFT;
			case 3:
//				System.out.println("right");
				return Environment.MOVE_RIGHT;

			}
		}
		return NoOpAction.NO_OP;
	}
}
