package ua.com.client;

import ua.com.client.dto.EveryDayBonus;
import ua.com.client.dto.Planet;
import ua.com.client.dto.Plant;
import ua.com.client.dto.UserDTO;
import ua.com.client.ui.PlanetInfo;
import ua.com.client.ui.PlantProgresDialog;
import ua.com.client.ui.timer.TimerPanel;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DockLayoutPanel;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.ScrollPanel;
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
	private static final String TIMER_BUT = "Тест таймер";
	private static final String GOLD_LABEL = "Монетки";
	private static final String ACTION_LABEL = "Действия";

	private static final String WIDTH_100 = "100%";
	private static final String BUT_HEIGHT = "40px";

	private final GreetingServiceAsync greetingService = GWT
			.create(GreetingService.class);

	private Label goldLabel = new Label();
	private Label actionLabel = new Label();
	private FlowPanel timerPanel = new FlowPanel();
	private PlanetInfo planetInfo = new PlanetInfo();

	PlantProgresDialog plantDialog = new PlantProgresDialog();

	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		initUser();
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

	private void initUser() {
		greetingService.getUserDTO(new AsyncCallback<UserDTO>() {

			@Override
			public void onSuccess(UserDTO result) {
				goldLabel.setText(result.getGold().toString());
				actionLabel.setText(result.getActionPoints().toString());
			}

			@Override
			public void onFailure(Throwable caught) {
				Window.alert("aaa user problem");
			}
		});

	}

	private void initPlanet() {
		greetingService.getPlanet(new AsyncCallback<Planet>() {
			@Override
			public void onSuccess(Planet result) {
				// Window.alert(toStringCustom(result));
				planetInfo.setDto(result);
			}

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub

			}
		});

	}

	private String toStringCustom(Planet planet) {
		String resultStr = planet.getName() + "\n\n"
				+ planet.getParam0().toString() + "\n"
				+ planet.getParam1().toString() + "\n"
				+ planet.getParam2().toString() + "\n"
				+ planet.getParam3().toString() + "\n"
				+ planet.getParam4().toString() + "\n"
				+ planet.getParam5().toString() + "\n"
				+ planet.getParam6().toString() + "\n"
				+ planet.getParam7().toString() + "\n"
				+ planet.getParam8().toString() + "\n"
				+ planet.getParam9().toString();
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
	}

	private Widget getCenterPanel() {

		DockLayoutPanel dockPanel = new DockLayoutPanel(Unit.PX);
		dockPanel.getElement().setId("fullBackground");
		dockPanel.setWidth("800px");
		dockPanel.setHeight("600px");

		dockPanel.addWest(getButtonPanel(), 130);
		dockPanel.addEast(getPlanetInfoPanel(), 150);
		dockPanel.addNorth(getUserInfoPanel(), 40);
		dockPanel.add(getMainPanel());

		return dockPanel;
	}

	private Widget getMainPanel() {
		ScrollPanel scrollPanel = new ScrollPanel();
		scrollPanel.setWidth(WIDTH_100);
		scrollPanel.setHeight(WIDTH_100);

		timerPanel.setWidth("490px");

		scrollPanel.add(timerPanel);
		return scrollPanel;
	}

	private Widget getPlanetInfoPanel() {
		VerticalPanel verticalPanel = new VerticalPanel();
		verticalPanel.setWidth(WIDTH_100);
		verticalPanel.setHeight(WIDTH_100);
		verticalPanel.setSpacing(5);
		verticalPanel.getElement().setId("eastPanel");
		//
		verticalPanel.add(planetInfo);

		return verticalPanel;
	}

	private Widget getUserInfoPanel() {
		HorizontalPanel hMainPanel = new HorizontalPanel();
		hMainPanel.setWidth(WIDTH_100);
		hMainPanel.setHeight(WIDTH_100);
		hMainPanel.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
		hMainPanel.getElement().setId("eastPanel");
		hMainPanel.setSpacing(5);

		HorizontalPanel hPanel = new HorizontalPanel();
		hPanel.setSpacing(5);
		// money
		goldLabel.getElement().setId("valueLabel");
		goldLabel.setWidth("75px");
		goldLabel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		Label tempGoldLabel = new Label(GOLD_LABEL);
		tempGoldLabel.getElement().setId("captionLabel");
		// action
		actionLabel.getElement().setId("valueLabel");
		actionLabel.setWidth("75px");
		actionLabel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		Label tempActionLabel = new Label(ACTION_LABEL);
		tempActionLabel.getElement().setId("captionLabel");

		hPanel.add(tempGoldLabel);
		hPanel.add(goldLabel);
		hPanel.add(tempActionLabel);
		hPanel.add(actionLabel);

		hMainPanel.add(hPanel);
		return hMainPanel;
	}

	private Widget getButtonPanel() {
		VerticalPanel verticalPanel = new VerticalPanel();
		verticalPanel.setWidth("100%");

		verticalPanel.setSpacing(5);

		Button growButton = new Button(GROW_BUT);
		Button sendButton = new Button(SEND_BUT);
		Button plantButton = new Button(PLAN_BUT);
		Button bonusButton = new Button(BONUS_BUT);
		Button timerButton = new Button(TIMER_BUT);

		growButton.setWidth(WIDTH_100);
		growButton.setHeight(BUT_HEIGHT);

		sendButton.setWidth(WIDTH_100);
		sendButton.setHeight(BUT_HEIGHT);

		plantButton.setWidth(WIDTH_100);
		plantButton.setHeight(BUT_HEIGHT);

		bonusButton.setWidth(WIDTH_100);
		bonusButton.setHeight(BUT_HEIGHT);

		timerButton.setWidth(WIDTH_100);
		timerButton.setHeight(BUT_HEIGHT);

		verticalPanel.add(growButton);
		verticalPanel.add(sendButton);
		verticalPanel.add(plantButton);
		verticalPanel.add(bonusButton);
		verticalPanel.add(timerButton);

		timerButton.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				timerPanel.add(new TimerPanel("test text"));

			}
		});

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

		sendButton.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				Window.alert("Calculation ability of plant to "
						+ "survive on the planet.... \n\n Succefuly!!!\\Failed!!!");
			}
		});

		bonusButton.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				greetingService.getBonus(new AsyncCallback<EveryDayBonus>() {

					@Override
					public void onSuccess(EveryDayBonus result) {
						if (result.getGoldBonus() == 0) {
							Window.alert("Уже был заюзан бонус. Please w8 ");
						} else {
							Window.alert("Today bonus is "
									+ result.getGoldBonus().toString()
									+ " gold");
							initUser();
						}
					}

					@Override
					public void onFailure(Throwable caught) {
						// TODO Auto-generated method stub

					}
				});
			}
		});

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
