package ua.com.client.ui;

import ua.com.client.dto.Plant;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

public class PlantProgresDialog extends DialogBox {

	private static final String BUT_P = "30px";

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

	public PlantProgresDialog() {
		this.setText("Прокачай цветок");
		this.setModal(false);
		setAnimationEnabled(true);
		setGlassEnabled(true);

		VerticalPanel verPanel = new VerticalPanel();
		verPanel.add(getMainTable());
		HorizontalPanel horPanel = new HorizontalPanel();
		verPanel.add(horPanel);
		Button closeButton = new Button("Close");
		horPanel.add(closeButton);

		closeButton.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				hide();

			}
		});

		this.add(verPanel);
	}

	private Widget getMainTable() {
		FlexTable table = new FlexTable();
		table.setHeight("100%");
		table.setWidth("480px");
		table.setCellSpacing(5);

		addRowName(table, 0, "name", nameLabel);
		//
		addRow(table, 1, "param0", param0Label);
		addRow(table, 2, "param1", param1Label);
		addRow(table, 3, "param2", param2Label);
		addRow(table, 4, "param3", param3Label);
		addRow(table, 5, "param4", param4Label);
		addRow(table, 6, "param5", param5Label);
		addRow(table, 7, "param6", param6Label);
		addRow(table, 8, "param7", param7Label);
		addRow(table, 9, "param8", param8Label);
		addRow(table, 10, "param9", param9Label);

		return table;
	}

	private void addRowName(FlexTable table, int row, String text,
			final Label valueLabel) {
		Label tempLabel = new Label(text);
		tempLabel.getElement().setId("captionLabel");
		table.setWidget(row, 0, tempLabel);
		valueLabel.getElement().setId("valueLabel");
		table.setWidget(row, 1, valueLabel);
	}

	private void addRow(FlexTable table, int row, String text,
			final Label valueLabel) {
		addRowName(table, row, text, valueLabel);
		// Button
		Button up = new Button("+");
		Button down = new Button("-");

		up.setWidth(BUT_P);
		up.setHeight(BUT_P);

		down.setWidth(BUT_P);
		down.setHeight(BUT_P);

		up.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				int temp = Integer.parseInt(valueLabel.getText());
				if (temp < 100) {
					temp += 10;
				}
				if (temp > 100) {
					temp = 100;
				}
				valueLabel.setText(Integer.toString(temp));
			}
		});

		down.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				int temp = Integer.parseInt(valueLabel.getText());
				if (temp > 0) {
					temp -= 10;
				}
				if (temp < 0) {
					temp = 0;
				}
				valueLabel.setText(Integer.toString(temp));

			}
		});

		table.setWidget(row, 2, up);
		table.setWidget(row, 3, down);
	}

	public void setDto(Plant plant) {
		nameLabel.setText(plant.getName());
		param0Label.setText(plant.getParam0().toString());
		param1Label.setText(plant.getParam1().toString());
		param2Label.setText(plant.getParam2().toString());
		param3Label.setText(plant.getParam3().toString());
		param4Label.setText(plant.getParam4().toString());
		param5Label.setText(plant.getParam5().toString());
		param6Label.setText(plant.getParam6().toString());
		param7Label.setText(plant.getParam7().toString());
		param8Label.setText(plant.getParam8().toString());
		param9Label.setText(plant.getParam9().toString());
	}

}
