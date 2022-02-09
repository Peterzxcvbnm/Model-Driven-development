package main;

import main.metamodel.Machine;
import main.metamodel.State;
import main.metamodel.Transition;

public class StateMachine {

	private final Machine machine = new Machine();
	private State currentState;
	private Transition currentTransition;

	public Machine build() {
		return machine;
	}

	public StateMachine state(String name) {
		currentState = new State(name, machine);
		machine.getStates().add(currentState);
		return this;
	}

	public StateMachine initial() {
		machine.setInitialState(currentState);
		return this;
	}

	public StateMachine when(String eventName) {
		currentTransition = new Transition(eventName);
		currentState.getTransitions().add(currentTransition);
		return this;
	}

	public StateMachine to(String stateName) {
		currentTransition.setTarget(machine.getState(stateName));
		return this;
	}

	public StateMachine integer(String name) {
		machine.addInteger(name);
		return this;
	}

	public StateMachine set(String variableName, int value) {
		currentTransition.setOperationType(Transition.OperationType.Set);
		currentTransition.setOperationVariableName(variableName);
		currentTransition.setOperationValue(value);
		return this;
	}

	public StateMachine increment(String variableName) {
		currentTransition.setOperationType(Transition.OperationType.Increment);
		currentTransition.setOperationVariableName(variableName);
		currentTransition.setOperationValue(1);
		return this;
	}

	public StateMachine decrement(String variableName) {
		currentTransition.setOperationType(Transition.OperationType.Decrement);
		currentTransition.setOperationVariableName(variableName);
		currentTransition.setOperationValue(1);
		return this;
	}

	public StateMachine ifEquals(String variableName, int value) {
		currentTransition.setConditionType(Transition.ConditionType.Equal);
		currentTransition.setConditionalVariableName(variableName);
		currentTransition.setConditionComparedValue(value);
		return this;
	}

	public StateMachine ifGreaterThan(String variableName, int value) {
		currentTransition.setConditionType(Transition.ConditionType.GreaterThan);
		currentTransition.setConditionalVariableName(variableName);
		currentTransition.setConditionComparedValue(value);
		return this;
	}

	public StateMachine ifLessThan(String variableName, int value) {
		currentTransition.setConditionType(Transition.ConditionType.LessThan);
		currentTransition.setConditionalVariableName(variableName);
		currentTransition.setConditionComparedValue(value);
		return this;
	}

}
