package main.metamodel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Machine {

	private List<State> states = new ArrayList<>();
	private State initialState;
	private HashMap<String, Integer> integers = new HashMap<>();

	public List<State> getStates() {
		return states;
	}

	public void setInitialState(State initialState) {
		this.initialState = initialState;
	}

	public State getInitialState() {
		return initialState;
	}

	public State getState(String name) {
		return states.stream().filter(x -> x.getName().equals(name)).findAny().orElse(null);
	}

	public void addInteger(String name){
		integers.put(name, 0);
	}

	public int numberOfIntegers() {
		return integers.size();
	}

	public boolean hasInteger(String name) {
		return integers.containsKey(name);
	}

	public HashMap<String, Integer> getIntegers(){
		return integers;
	}


}
