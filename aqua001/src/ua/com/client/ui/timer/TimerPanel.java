package ua.com.client.ui.timer;

import ua.com.client.resources.ImageBundle;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;

public class TimerPanel extends HorizontalPanel {

	private static final String PANEL_WIDTH = "100%";
	private static final String PANEL_HEIGHT = "40px";

	private Label timerInfo = new Label();
	private TimerWidget timer;
	
	public TimerPanel() {
		super();

		init();
		timer.startTimer();
	}

	private void init() {
		this.setHeight("50px");
		this.setWidth(PANEL_WIDTH);
		//this.setSpacing(5);
		this.getElement().setId("timerPanel");

		timer = new TimerWidget(100);
		timer.setHeight("20px");
		timerInfo.setHeight("20px");

		ImageBundle bundle = GWT.create(ImageBundle.class);
		Image image = new Image(bundle.timer());

		image.setWidth(PANEL_HEIGHT);
		image.setHeight(PANEL_HEIGHT);

		VerticalPanel vPanel = new VerticalPanel();
		// vPanel.setSpacing(5);
		// vPanel.setWidth(PANEL_WIDTH);
		vPanel.add(timer);
		vPanel.add(timerInfo);
		vPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_LEFT);
		vPanel.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
		// timerInfo.setWidth(PANEL_WIDTH);
		timerInfo.getElement().setId("valueLabel");

		//
		HorizontalPanel hPanel = new HorizontalPanel();
		hPanel.setSpacing(5);
		hPanel.add(image);
		hPanel.add(vPanel);

		this.add(hPanel);

	}

	public TimerPanel(String text) {
		super();
		init();
		setText(text);
		timer.startTimer();
	}

	public void setText(String text) {
		timerInfo.setText(text);
	}

}
