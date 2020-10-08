package ex3;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.platform.commons.util.ReflectionUtils;
import ex3.Developer;
import java.util.ArrayList;
import java.util.List;
import java.util.EnumSet;
import java.lang.reflect.Method;

class openFridgeTest {

    @Test
    void OpenFridgeTest() {
        Office testOffice = new Office(1);
        List<Developer> ls = new ArrayList<Developer>(EnumSet.allOf(Developer.class));
        testOffice.openFridge(ls);
        assertEquals(6, testOffice.maxibonsLeft, "maxibonLeft should be 6");
    }

    @Test
    void GrabMaxibonsTest() {
        Office testOffice = new Office(2);
        Class cls = testOffice.getClass();
        Method[] methods = cls.getMethods();
        try {
            Method methodCall = cls.getDeclaredMethod("grabMaxibons", Developer.class);
            methodCall.setAccessible(true);
            methodCall.invoke(testOffice, Developer.PEDRO);
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
        assertEquals(0, testOffice.maxibonsLeft, "maxibonLeft should be 0");
    }

}
