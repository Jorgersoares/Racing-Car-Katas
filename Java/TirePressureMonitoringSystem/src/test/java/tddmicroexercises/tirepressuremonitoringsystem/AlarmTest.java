package tddmicroexercises.tirepressuremonitoringsystem;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AlarmTest {

    Sensor sensor;

    @BeforeEach
    public void init() {
        sensor = mock(Sensor.class);
    }

    @Test
    public void testSensorReturnLowerPressure() {
        doReturn(new Double("16")).when(sensor).popNextPressurePsiValue();
        Alarm alarm = new Alarm(sensor);
        alarm.check();
        assertTrue(alarm.isAlarmOn());
    }

    @Test
    public void testSensorReturnHighPressure() {
        doReturn(new Double("21.5")).when(sensor).popNextPressurePsiValue();
        Alarm alarm = new Alarm(sensor);
        alarm.check();
        assertTrue(alarm.isAlarmOn());
    }

    @Test
    public void testSensorReturnNormalPressure() {
        doReturn(new Double("20.5")).when(sensor).popNextPressurePsiValue();
        Alarm alarm = new Alarm(sensor);
        alarm.check();
        assertFalse(alarm.isAlarmOn());
    }
}
