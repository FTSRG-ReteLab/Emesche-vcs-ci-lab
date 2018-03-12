package hu.bme.mit.train.sensor;

import hu.bme.mit.train.interfaces.TrainController;
import hu.bme.mit.train.interfaces.TrainUser;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;
import static org.mockito.Mockito.*;

public class TrainSensorTest {

    TrainSensorImpl trainSensor;
    TrainController controller;
    TrainUser user;

    @Before
    public void before() {
        controller =  mock(TrainController.class);
        user = mock(TrainUser.class);
        trainSensor = new TrainSensorImpl(controller, user);
    }

    @Test
    public void CheckNegative() {
        int speed = -10;
        when(user.getAlarmState()).thenReturn(true);
        trainSensor.overrideSpeedLimit(speed);
        Assert.assertEquals(trainSensor.isUserAlarm(), true);
    }


    @Test
    public void OkSpeedLimit() {
        int speed = 90;
        when(user.getAlarmState()).thenReturn(false);
        trainSensor.overrideSpeedLimit(speed);
        Assert.assertEquals(trainSensor.isUserAlarm(), false);
    }


    @Test
    public void CheckMaximum() {
        int speed = 1000;
        when(user.getAlarmState()).thenReturn(true);
        trainSensor.overrideSpeedLimit(speed);
        Assert.assertEquals(trainSensor.isUserAlarm(), true);
    }


    @Test
    public void CheckAbsolute() {
        int speed = 10;
        when(user.getAlarmState()).thenReturn(true);
        when(controller.getReferenceSpeed()).thenReturn(200);
        trainSensor.overrideSpeedLimit(speed);
        Assert.assertEquals(trainSensor.isUserAlarm(), true);
    }
}
