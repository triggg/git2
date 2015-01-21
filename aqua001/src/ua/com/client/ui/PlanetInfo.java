package ua.com.client.ui;

import ua.com.client.dto.Planet;

import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.Label;

public class PlanetInfo extends FlexTable {

	private Label nameLabel = new Label();
	private Label param0Label = new Label();
	private Label param1Label = new Label();
	private Label param2Label = new Label();
	private Label param3Label = new Label();
	private Label param4Label = new Label();
	private Label param5Label = new Label();
	private Label param6Label = new Label();
	private Label param7Label = new Label();
	private Label param8Label = new Label();
	private Label param9Label = new Label();

	public PlanetInfo() {
		super();

		setWidth("100%");

		addRowName(0, "name", nameLabel);

		addRowName(1, "param0", param0Label);
		addRowName(2, "param1", param1Label);
		addRowName(3, "param2", param2Label);
		addRowName(4, "param3", param3Label);
		addRowName(5, "param4", param4Label);
		addRowName(6, "param5", param5Label);
		addRowName(7, "param6", param6Label);
		addRowName(8, "param7", param7Label);
		addRowName(9, "param8", param8Label);
		addRowName(10, "param9", param9Label);
	}

	private void addRowName(int row, String text, final Label valueLabel) {
		Label tempLabel = new Label(text);
		tempLabel.getElement().setId("captionLabel");
		setWidget(row, 0, tempLabel);
		valueLabel.getElement().setId("valueLabel");
		setWidget(row, 1, valueLabel);
		getCellFormatter().setHorizontalAlignment(row, 1,
				HasHorizontalAlignment.ALIGN_RIGHT);

	}

	public void setDto(Planet planet) {
		nameLabel.setText(planet.getName());
		param0Label.setText(planet.getParam0().toString());
		param1Label.setText(planet.getParam1().toString());
		param2Label.setText(planet.getParam2().toString());
		param3Label.setText(planet.getParam3().toString());
		param4Label.setText(planet.getParam4().toString());
		param5Label.setText(planet.getParam5().toString());
		param6Label.setText(planet.getParam6().toString());
		param7Label.setText(planet.getParam7().toString());
		param8Label.setText(planet.getParam8().toString());
		param9Label.setText(planet.getParam9().toString());
	}

}
