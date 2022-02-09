package main;

import main.metamodel.Machine;
import main.metamodel.State;

public class MachineInterpreter {

	private Machine machine;
	private State currentState;

	public void run(Machine m) {
		machine = m;
		currentState = m.getInitialState();
	}

	public State getCurrentState() {
		return currentState;
	}

	public void processEvent(String event) {
		var transition = currentState.getTransitionByEvent(event);
		if(transition == null) return;
		currentState = machine.getState(transition.getTarget().getName());
		var integers = machine.getIntegers();
		var key = transition.getOperationVariableName();
		switch (transition.getOperationType()){
			case Set: integers.put(key, transition.getOperationValue());
			case Increment: integers.put(key, integers.get(key) + 1);
			case Decrement: integers.put(key, integers.get(key) - 1);
		}
	}

	public int getInteger(String variableName) {
		return machine.getIntegers().get(variableName);
	}

}
