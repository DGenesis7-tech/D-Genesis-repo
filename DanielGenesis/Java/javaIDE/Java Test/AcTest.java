import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AcTest {
    @Test
    public void testToCheckAcPowerStatusOn() {
        AC ac = new AC();
        ac.setPower(true);
        boolean on = ac.getPower();
        assertTrue(on);
    }

    @Test
    public void testToCheckAcPowerStatusOff() {
        AC ac = new AC();

        ac.setPower(true);
        boolean on = ac.getPower();
        assertTrue(on);

        ac.setPower(false);
        boolean off = ac.getPower();
        assertFalse(off);
    }

    @Test
    public void testToNotifyIfAcPowerOn() {
        AC ac = new AC();

        ac.setPower(true);
        boolean acPower = ac.getPower();
        assertTrue(acPower);

        String notice = "Switched On";
        boolean acPower2 = true;
        AcFunctions functions = new AcFunctions();
        String notice1 = functions.switchMessage(acPower2);
        assertEquals(notice, notice1);
    }

    @Test
    public void testToNotifyIfAcPowerOff() {
        AC ac = new AC();

        ac.setPower(false);
        boolean acPower1 = ac.getPower();
        assertFalse(acPower1);

        String notice = "Switched Off";
        boolean acPower2 = false;
        AcFunctions functions = new AcFunctions();
        String notice1 = functions.switchMessage(acPower2);
        assertEquals(notice, notice1);
    }

    @Test
    public void testToThrowErrorForIncreaseAndDecreaseTemperatureIfAcPowerOff() {
        AC ac = new AC();

        ac.setPower(false);
        boolean acPower1 = ac.getPower();
        assertFalse(acPower1);

        AcFunctions functions = new AcFunctions();
        functions.setObject(ac);
        assertThrows(IllegalArgumentException.class, () -> {
            functions.increaseTemperature();
        });
        assertThrows(IllegalArgumentException.class, () -> {
            functions.decreaseTemperature();
        });
    }

    @Test
    public void testToThrowErrorForIncreaseTemperatureIfWhenAcInMinimumTemperature() {
        AC ac = new AC();
        ac.setPower(true);
        boolean acPower1 = ac.getPower();
        assertTrue(acPower1);

        AcFunctions functions = new AcFunctions();
        functions.setObject(ac);
        ac.setTemperature(32);
        assertEquals(32, ac.getTemperature());
        assertThrows(IllegalArgumentException.class, () -> {
            functions.increaseTemperature();
        });
    }

    @Test
    public void testToThrowErrorForDecreaseTemperatureIfWhenAcInMaximumTemperature() {
        AC ac = new AC();
        ac.setPower(true);
        boolean acPower1 = ac.getPower();
        assertTrue(acPower1);

        AcFunctions functions = new AcFunctions();
        functions.setObject(ac);
        ac.setTemperature(16);
        assertEquals(16, ac.getTemperature());
        assertThrows(IllegalArgumentException.class, () -> {
            functions.decreaseTemperature();
        });
    }

    @Test
    public void testToIncreaseIfAcPowerOn() {
        AC ac = new AC();
        ac.setPower(true);
        boolean acPower = ac.getPower();
        assertTrue(acPower);

        AcFunctions functions = new AcFunctions();
        functions.setObject(ac);
        double temperature = ac.getTemperature();
        temperature += 1;
        functions.increaseTemperature();
        assertEquals(temperature, ac.getTemperature());
    }

    @Test
    public void testToDecreaseIfAcPowerOn() {
        AC ac = new AC();

        ac.setPower(true);
        boolean acPower1 = ac.getPower();
        assertTrue(acPower1);

        AcFunctions functions = new AcFunctions();
        functions.setObject(ac);
        double temperature = 18;
        ac.setTemperature(temperature);
        temperature -= 1;
        functions.decreaseTemperature();
        assertEquals(temperature, ac.getTemperature());
    }

}

