package task2;

import task2.Action;
import task2.NoOpAction;

public class NoOpAction extends Action {
	public static final NoOpAction NO_OP = new NoOpAction();

	public boolean isNoOp() {
		return true;
	}
}