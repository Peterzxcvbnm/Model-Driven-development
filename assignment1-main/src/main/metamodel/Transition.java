package main.metamodel;

public class Transition {

	private String eventName;
	private String targetName;
	private State target;
	private OperationType operationType = OperationType.None;
	private String operationVariableName;
	private int operationValue;
	private String conditionalVariableName;
	private int conditionComparedValue;
	private ConditionType conditionType;

	public Transition(String eventName) {
		this.eventName = eventName;
	}

	public String getEvent() {
		return eventName;
	}

	public void setTargetName(String target) {
		this.targetName = target;
	}

	public String getTargetName() {
		return targetName;
	}

	public void setTarget(State target) {
		this.target = target;
	}

	public State getTarget() {
		return target;
	}

	public void setOperationType(OperationType operationType) {
		this.operationType = operationType;
	}

	public boolean hasSetOperation() {
		return operationType.equals(OperationType.Set);
	}

	public boolean hasIncrementOperation() {
		return operationType.equals(OperationType.Increment);
	}

	public boolean hasDecrementOperation() {
		return operationType.equals(OperationType.Decrement);
	}

	public void setOperationVariableName(String operationVariableName) {
		this.operationVariableName = operationVariableName;
	}

	public String getOperationVariableName() {
		return operationVariableName;
	}

	public int getOperationValue() {
		return operationValue;
	}

	public void setOperationValue(int operationValue) {
		this.operationValue = operationValue;
	}

	public void setConditionalVariableName(String conditionalVariableName) {
		this.conditionalVariableName = conditionalVariableName;
	}

	public void setConditionComparedValue(int conditionComparedValue) {
		this.conditionComparedValue = conditionComparedValue;
	}

	public void setConditionType(ConditionType conditionType) {
		this.conditionType = conditionType;
	}

	public boolean isConditional() {
		return conditionalVariableName != null;
	}

	public String getConditionVariableName() {
		return conditionalVariableName;
	}

	public int getConditionComparedValue() {
		return conditionComparedValue;
	}

	public boolean isConditionEqual() {
		return conditionType == ConditionType.Equal;
	}

	public boolean isConditionGreaterThan() {
		return conditionType == ConditionType.GreaterThan;
	}

	public boolean isConditionLessThan() {
		return conditionType == ConditionType.LessThan;
	}

	public boolean hasOperation() {
		return operationType != null;
	}

	public OperationType getOperationType() {
		return operationType;
	}

	public boolean mayHappen(int variableValue){
		switch (conditionType){
			case Equal: return variableValue == conditionComparedValue;
			case GreaterThan: return variableValue > conditionComparedValue;
			case LessThan: return variableValue < conditionComparedValue;
		}
		throw new RuntimeException("Somehow the value is not equal to, greater than or less than O.o");
	}

	public enum OperationType{
		None,
		Set,
		Increment,
		Decrement
	}

	public enum ConditionType{
		Equal,
		GreaterThan,
		LessThan
	}
}
