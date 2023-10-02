package task1;

import task1.Action;
import task1.AgentProgram;
import task1.NoOpAction;
import task1.Percept;

public class Agent {
	private AgentProgram program;

	public Agent() {
	}

	public Agent(AgentProgram aProgram) {
		program = aProgram;
	}

	public Action execute(Percept p) {
		if (program != null) {
			return program.execute(p);
		}
		return NoOpAction.NO_OP;
	}
}
