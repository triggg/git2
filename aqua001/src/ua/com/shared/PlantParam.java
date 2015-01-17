package ua.com.shared;

public enum PlantParam {

	PARAM_0(0), PARAM_1(1), PARAM_2(2), PARAM_3(3), PARAM_4(4), PARAM_5(5), PARAM_6(6), 
	PARAM_7(7), PARAM_8(8), PARAM_9(9);

	private int value;

	private PlantParam(int value) {
		this.setValue(value);
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

}
