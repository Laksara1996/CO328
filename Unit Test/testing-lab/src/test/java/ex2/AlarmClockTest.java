package ex2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.platform.commons.util.ReflectionUtils;

class AlarmClockTest {

    @Test
    void clockTest() {
        Clock clockTest = new Clock();
        clockTest.setTime(23, 59, 0);
        for (int i = 0; i < 60; i++) {
            clockTest.tick();
        }
        assertEquals(0, clockTest.hour, "After 24 hours clock hour should rest back to 0");
        assertEquals(0, clockTest.minute, "After 24 hours clock minute should rest back to 0");
        assertEquals(0, clockTest.second, "After 24 hours clock second should rest back to 0");
    }

    @Test
    void alarmTest() {
        AlarmClock alarmTest = new AlarmClock();
        alarmTest.setTime(05, 30, 0);
        alarmTest.setAlarmTime(05, 31);
        for (int i = 0; i < 60; i++) {
            alarmTest.tick();
        }
        assertEquals(true, alarmTest.alarmRinging, "alram ringing is true");
        for (int i = 0; i < 60; i++) {
            alarmTest.tick();
        }
        assertEquals(false, alarmTest.alarmRinging, "After a minute alarm should be back to false");
    }

}
