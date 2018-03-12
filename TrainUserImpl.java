package hu.bme.mit.train.user;

import hu.bme.mit.train.interfaces.TrainController;
import hu.bme.mit.train.interfaces.TrainUser;

public class TrainUserImpl implements TrainUser {

	private TrainController controller;
	private int joystickPosition;
	private boolean isAlarmed;

	public TrainUserImpl(TrainController controller) {
		this.controller = controller;
	}

	@Override
		public boolean getAlarmState() {
			return this.isAlarmed;
		}
	
		@Override
		public void setAlarmState(boolean alarmState) {
			this.isAlarmed = alarmState;
		}
	
	
	@Override
	public boolean getAlarmFlag() {
		return false;
	}

	@Override
	public int getJoystickPosition() {
		return joystickPosition;
	}

	@Override
	public void overrideJoystickPosition(int joystickPosition) {
		this.joystickPosition = joystickPosition;
		controller.setJoystickPosition(joystickPosition);
	}

}
