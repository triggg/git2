package ua.com.client;

import ua.com.client.dto.Plant;
import ua.com.client.ui.PlantProgresDialog;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
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

	private static final String BUT_WIDTH = "100%";
	private static final String BUT_HEIGHT = "40px";

	private final GreetingServiceAsync greetingService = GWT
			.create(GreetingService.class);
	
	PlantProgresDialog  plantDialog = new PlantProgresDialog();
	
	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		initPlant();
		DockLayoutPanel mainDockPanel = new DockLayoutPanel(Unit.PX);
		mainDockPanel.setWidth("100%");
		mainDockPanel.setHeight("870px");

		mainDockPanel.addNorth(getNorthPanel(), 40);

		mainDockPanel.addSouth(getSouthPanel(), 200);

		mainDockPanel.add(getCenterPanel());

		RootPanel.get().add(mainDockPanel);
	}

	private void initPlant(){
		
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
		
	}
	
	private Widget getCenterPanel() {
		
		
		DockLayoutPanel dockPanel = new DockLayoutPanel(Unit.PX);
		dockPanel.getElement().setId("fullBackground");
		dockPanel.setWidth("800px");
		dockPanel.setHeight("600px");

		dockPanel.addWest(getButtonPanel(), 100);

		return dockPanel;
	}

	private Widget getButtonPanel() {
		VerticalPanel verticalPanel = new VerticalPanel();
		verticalPanel.setWidth("100%");

		verticalPanel.setSpacing(5);
		

		Button growButton = new Button(GROW_BUT);
		Button sendButton = new Button(SEND_BUT);
		Button plantButton = new Button(PLAN_BUT);

		growButton.setWidth(BUT_WIDTH);
		growButton.setHeight(BUT_HEIGHT);

		sendButton.setWidth(BUT_WIDTH);
		sendButton.setHeight(BUT_HEIGHT);
		
		plantButton.setWidth(BUT_WIDTH);
		plantButton.setHeight(BUT_HEIGHT);

		verticalPanel.add(growButton);
		verticalPanel.add(sendButton);
		verticalPanel.add(plantButton);
		
		plantButton.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				plantDialog.center();
				
			}
		});
		//
		VerticalPanel returnPanel = new VerticalPanel();
		returnPanel.setHeight("100%");
		returnPanel.setWidth("100%");
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
