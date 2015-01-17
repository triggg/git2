package ua.com.client;

import ua.com.client.dto.Planet;
import ua.com.client.dto.EveryDayBonus;
import ua.com.client.dto.Plant;
import ua.com.client.ui.PlantProgresDialog;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.DockLayoutPanel;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Aqua001 implements EntryPoint {

	private static final String GROW_BUT = "Рости";
	private static final String SEND_BUT = "Лети";
	private static final String PLAN_BUT = "Растение";
	private static final String BONUS_BUT = "Бонус";

	private static final String WIDTH_100 = "100%";
	private static final String BUT_HEIGHT = "40px";

	private final GreetingServiceAsync greetingService = GWT
			.create(GreetingService.class);

	private Label bonusLabel = new Label();

	PlantProgresDialog plantDialog = new PlantProgresDialog();

	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		initPlant();
		initPlanet();
		DockLayoutPanel mainDockPanel = new DockLayoutPanel(Unit.PX);
		mainDockPanel.setWidth("100%");
		mainDockPanel.setHeight("870px");

		mainDockPanel.addNorth(getNorthPanel(), 40);

		mainDockPanel.addSouth(getSouthPanel(), 200);

		mainDockPanel.add(getCenterPanel());

		RootPanel.get().add(mainDockPanel);
	}

		private void initPlanet() {
			greetingService.getPlanet(new AsyncCallback<Planet>() {
			@Override
			public void onSuccess(Planet result) {				
				Window.alert(toStringCustom(result));
				
			}
			
			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				
			}
		});
		
	}
	
	private String toStringCustom(Planet planet) {
		String resultStr = 
			planet.getName() + "\n\n" +
			planet.getParam0().toString() +"\n" + 
			planet.getParam1().toString() +"\n" + 
			planet.getParam2().toString() +"\n" + 
			planet.getParam3().toString() +"\n" + 
			planet.getParam4().toString() +"\n" + 
			planet.getParam5().toString() +"\n" + 
			planet.getParam6().toString() +"\n" + 
			planet.getParam7().toString() +"\n" + 
			planet.getParam8().toString() +"\n" + 
			planet.getParam9().toString();
		return resultStr;
	}

		private void initPlant() {
			greetingService.getPlant(new AsyncCallback<Plant>() {

			@Override
			public void onSuccess(Plant result) {
				plantDialog.setDto(result);

			}

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub

			}
		});
		
		
		greetingService.getBonus(new AsyncCallback<EveryDayBonus>() {
			
			@Override
			public void onSuccess(EveryDayBonus result) {
				bonusLabel.setText(result.getGoldBonus().toString());
			}
			
			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				
			}
		});

	}

	private Widget getCenterPanel() {

		DockLayoutPanel dockPanel = new DockLayoutPanel(Unit.PX);
		dockPanel.getElement().setId("fullBackground");
		dockPanel.setWidth("800px");
		dockPanel.setHeight("600px");

		dockPanel.addWest(getButtonPanel(), 100);
		dockPanel.addNorth(getBonusPanel(), 40);

		return dockPanel;
	}

	private Widget getBonusPanel() {
		HorizontalPanel hPanel = new HorizontalPanel();
		hPanel.setSpacing(5);
		bonusLabel.getElement().setId("valueLabel");

		Label tempLabel = new Label(BONUS_BUT);
		tempLabel.getElement().setId("captionLabel");
		hPanel.add(tempLabel);
		hPanel.add(bonusLabel);
		hPanel.getElement().setId("eastPanel");
		return hPanel;
	}

	private Widget getButtonPanel() {
		VerticalPanel verticalPanel = new VerticalPanel();
		verticalPanel.setWidth("100%");

		verticalPanel.setSpacing(5);

		Button growButton = new Button(GROW_BUT);
		Button sendButton = new Button(SEND_BUT);
		Button plantButton = new Button(PLAN_BUT);
		//Button bonusButton = new Button(BONUS_BUT);

		growButton.setWidth(WIDTH_100);
		growButton.setHeight(BUT_HEIGHT);

		sendButton.setWidth(WIDTH_100);
		sendButton.setHeight(BUT_HEIGHT);

		plantButton.setWidth(WIDTH_100);
		plantButton.setHeight(BUT_HEIGHT);

		//bonusButton.setWidth(WIDTH_100);
		//bonusButton.setHeight(BUT_HEIGHT);

		verticalPanel.add(growButton);
		verticalPanel.add(sendButton);
		verticalPanel.add(plantButton);
		//verticalPanel.add(bonusButton);

		plantButton.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				plantDialog.center();

			}
		});

		growButton.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				Window.alert("Plant grow succesfully!!!");
			}
		});

		// bonusButton.addClickHandler(new ClickHandler() {
		//
		// @Override
		// public void onClick(ClickEvent event) {
		//
		// }
		// });

		//
		VerticalPanel returnPanel = new VerticalPanel();
		returnPanel.setHeight(WIDTH_100);
		returnPanel.setWidth(WIDTH_100);
		returnPanel.getElement().setId("eastPanel");
		returnPanel.setSpacing(1);
		returnPanel.add(verticalPanel);
		return returnPanel;
	}

	private HorizontalPanel getNorthPanel() {
		HorizontalPanel horPanel = new HorizontalPanel();

		horPanel.add(new Label("AquaFerma"));

		return horPanel;
	}

	private Widget getSouthPanel() {
		HorizontalPanel horPanel = new HorizontalPanel();

		horPanel.add(new Label("AquaFerma"));

		return horPanel;
	}

}
