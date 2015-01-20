package ua.com.client.ui.timer;

import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.Label;

public class TimerWidget extends Label{
	
	private int seconds;
	
	private Timer t = new Timer() {
		public void run() {
			if(seconds == 0){
				t.cancel();
			}
			setText(Integer.toString(seconds));
			seconds--;
		}
	};
	
	public TimerWidget(int seconds){
		this.seconds = seconds;
		this.getElement().setId("timerLabel");
		setText(Integer.toString(seconds));
		
	}

	public void startTimer(){
		t.scheduleRepeating(1000);
		//t.run();
	}

}
