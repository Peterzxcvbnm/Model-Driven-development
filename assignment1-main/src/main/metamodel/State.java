package main.metamodel;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
				.filter(x -> x.getEvent().equals(string))
				.filter(x -> !x.isConditional() ||
						x.mayHappen(machine.getIntegers().get(x.getConditionVariableName())))
				.findAny()
				.orElse(null);

	}


}
