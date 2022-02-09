package main.metamodel;

import java.util.ArrayList;
import java.util.List;

public class State {

	private final String name;
	private final Machine machine;
	private final ArrayList<Transition> transitions;

	public State(String name, Machine machine) {
		this.name = name;
		this.machine = machine;
		this.transitions = new ArrayList<>();
	}

	public String getName() {
		return name;
	}

	public List<Transition> getTransitions() {
		return transitions;
	}

	public Transition getTransitionByEvent(String string) {
		return transitions
				.stream()
				.filter(x -> x.getEvent().equals(string) &&
							 x.mayHappen(machine.getIntegers().get(x.getConditionVariableName())))
				.findAny()
				.orElse(null);
	}


}
