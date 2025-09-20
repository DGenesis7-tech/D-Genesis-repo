import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BikeTest {
    @Test
    public void testCheckBikePowerStatusOn() {
        Bike bike = new Bike();
        bike.setPower(true);
        boolean on = bike.getPower();
        assertTrue(on);
    }

    @Test
    public void testToCheckBikePowerStatusOff() {
        Bike bike = new Bike();
        bike.setPower(true);
        boolean on = bike.getPower();
        assertTrue(on);

        bike.setPower(false);
        boolean off = bike.getPower();
        assertFalse(off);
    }

    @Test
    public void testToAccelerateBikeWithIncrementOne() {
        Bike bike = new Bike();
        bike.setPower(true);
        boolean on = bike.getPower();
        assertTrue(on);

        BikeFunctions functions = new BikeFunctions();
        functions.setBike(bike);
        String dashboard = functions.accelerate();
        int accelerated = bike.getSpeed();
        assertEquals(bike.getSpeed(), accelerated);
    }

    @Test
    public void testToDecelerateBikeWithDecrementOne() {
        Bike bike = new Bike();
        bike.setPower(true);
        boolean on = bike.getPower();
        assertTrue(on);

        BikeFunctions functions = new BikeFunctions();
        functions.setBike(bike);
        String dashboard = functions.accelerate();
        int accelerated = bike.getSpeed();
        assertEquals(bike.getSpeed(), accelerated);

        functions.decelerate();
        int decelerated = bike.getSpeed();
        assertEquals(bike.getSpeed(), decelerated);
    }

    @Test
    public void testToThrowExceptionAcceleratingWhileBikePowerOff() {
        Bike bike = new Bike();
        boolean off = bike.getPower();
        assertFalse(off);

        BikeFunctions functions = new BikeFunctions();
        functions.setBike(bike);
        assertThrows(IllegalArgumentException.class, () -> {
            String dashboard = functions.accelerate();
        });
    }

    @Test
    public void testToThrowExceptionDeceleratingWhileBikePowerOff() {
        Bike bike = new Bike();
        boolean off = bike.getPower();
        assertFalse(off);

        BikeFunctions functions = new BikeFunctions();
        functions.setBike(bike);
        assertThrows(IllegalArgumentException.class, () -> {
            functions.decelerate();
        });
    }

    @Test
    public void testToDisplayGear1AccelerationWithIncrementOne() {
        Bike bike = new Bike();
        bike.setPower(true);
        boolean on = bike.getPower();
        assertTrue(on);

        BikeFunctions functions = new BikeFunctions();
        functions.setBike(bike);
        String dashboard = functions.accelerate();
        int accelerated = 1;
        String dashboard2 = "Gear 1 : " + accelerated + "kmp";
        assertEquals(dashboard2, dashboard);

        dashboard = functions.accelerate();
        accelerated++;
        dashboard2 = "Gear 1 : " + accelerated + "kmp";
        assertEquals(dashboard2, dashboard);
    }

    @Test
    public void testToDisplayGear1DecelerationWithDecrementOne() {
        Bike bike = new Bike();
        bike.setPower(true);
        boolean on = bike.getPower();
        assertTrue(on);

        BikeFunctions functions = new BikeFunctions();
        functions.setBike(bike);
        String dashboard = functions.accelerate();
        int accelerated = 1;
        String dashboard2 = "Gear 1 : " + accelerated + "kmp";
        assertEquals(dashboard2, dashboard);

        dashboard = functions.decelerate();
        accelerated--;
        dashboard2 = "Gear 1 : " + accelerated + "kmp";
        assertEquals(dashboard2, dashboard);
    }

    @Test
    public void testToDisplayGear1ToGear2AccelerationWithIncrementOne() {
        Bike bike = new Bike();
        bike.setPower(true);
        boolean on = bike.getPower();
        assertTrue(on);

        BikeFunctions functions = new BikeFunctions();
        functions.setBike(bike);
        int accelerated = 20;
        String dashboard = "";
        for (int counter = 1; counter < 21; counter++) {
            dashboard = functions.accelerate();
        }
        String dashboard2 = "Gear 1 : " + accelerated + "kmp";
        assertEquals(dashboard2, dashboard);

        dashboard = functions.accelerate();
        accelerated += 1;
        dashboard2 = "Gear 2 : " + accelerated + "kmp";
        assertEquals(dashboard2, dashboard);
    }

    @Test
    public void testToDisplayCurrentSpeedIsZeroIfDecelerationAtSpeedZero() {
        Bike bike = new Bike();
        bike.setPower(true);
        boolean on = bike.getPower();
        assertTrue(on);

        BikeFunctions functions = new BikeFunctions();
        functions.setBike(bike);
        String dashboard = functions.decelerate();
        int accelerated = 0;
        String dashboard2 = "Gear 1 : " + accelerated + "kmp";
        assertEquals(dashboard2, dashboard);
    }

    @Test
    public void testToDisplayGear2AccelerationWithIncrementTwo() {
        Bike bike = new Bike();
        bike.setPower(true);
        boolean on = bike.getPower();
        assertTrue(on);

        BikeFunctions functions = new BikeFunctions();
        functions.setBike(bike);
        int accelerated = 21;
        String dashboard = "";
        for (int counter = 1; counter <= 21; counter++) {
            dashboard = functions.accelerate();
        }
        String dashboard2 = "Gear 2 : " + accelerated + "kmp";
        assertEquals(dashboard2, dashboard);

        dashboard = functions.accelerate();
        accelerated += 2;
        dashboard2 = "Gear 2 : " + accelerated + "kmp";
        assertEquals(dashboard2, dashboard);
    }

    @Test
    public void testToDisplayGear2DecelerationWithDecrementTwo() {
            Bike bike = new Bike();
            bike.setPower(true);
            boolean on = bike.getPower();
            assertTrue(on);

            BikeFunctions functions = new BikeFunctions();
            functions.setBike(bike);
            String dashboard = "";
            int accelerated = 23;
            for (int counter = 1; counter <= 22; counter++) {
            dashboard = functions.accelerate();
            }
            String dashboard1 = "Gear 2 : " + accelerated + "kmp";
            assertEquals(dashboard1, dashboard);

            dashboard = functions.decelerate();
            int decelerated = accelerated - 2;
            dashboard1 = "Gear 2 : " + decelerated + "kmp";
            assertEquals(dashboard1, dashboard);
    }

    @Test
    public void testToDisplayGear2ToGear1DecelerationWithDecrementTwo() {
        Bike bike = new Bike();
        bike.setPower(true);
        boolean on = bike.getPower();
        assertTrue(on);

        BikeFunctions functions = new BikeFunctions();
        functions.setBike(bike);
        int accelerated = 21;
        String dashboard = "";
        for (int counter = 1; counter <= 21; counter++) {
            dashboard = functions.accelerate();
        }
        String dashboard2 = "Gear 2 : " + accelerated + "kmp";
        assertEquals(dashboard2, dashboard);

        dashboard = functions.decelerate();
        int decelerated = accelerated - 2;
        dashboard2 = "Gear 1 : " + decelerated + "kmp";
        assertEquals(dashboard2, dashboard);
    }

    @Test
    public void testToDisplayGear2ToGear3AccelerationWithIncrementTwo() {
        Bike bike = new Bike();
        bike.setPower(true);
        boolean on = bike.getPower();
        assertTrue(on);

        BikeFunctions functions = new BikeFunctions();
        functions.setBike(bike);
        int accelerated = 21;
        String dashboard = "";
        for (int counter = 1; counter <= 21; counter++) {
            dashboard = functions.accelerate();
        }
        String dashboard2 = "Gear 2 : " + accelerated + "kmp";
        assertEquals(dashboard2, dashboard);

        for (int counter = bike.getSpeed(); counter <= 29; counter += 2) {
            dashboard = functions.accelerate();
        }
        accelerated = 31;
        dashboard2 = "Gear 3 : " + accelerated + "kmp";
        assertEquals(dashboard2, dashboard);
    }

    @Test
    public void testToDisplayGear3AccelerationWithIncrementThree() {
        Bike bike = new Bike();
        bike.setPower(true);
        boolean on = bike.getPower();
        assertTrue(on);

        BikeFunctions functions = new BikeFunctions();
        functions.setBike(bike);
        int accelerated = 31;
        String dashboard = "";
        for (int counter = 1; counter <= 26; counter++) {
            dashboard = functions.accelerate();
        }
        String dashboard2 = "Gear 3 : " + accelerated + "kmp";
        assertEquals(dashboard2, dashboard);

        dashboard = functions.accelerate();
        accelerated += 3;
        dashboard2 = "Gear 3 : " + accelerated + "kmp";
        assertEquals(dashboard2, dashboard);
    }

    @Test
    public void testToDisplayGear3DecelerationWithDecrementThree() {
        Bike bike = new Bike();
        bike.setPower(true);
        boolean on = bike.getPower();
        assertTrue(on);

        BikeFunctions functions = new BikeFunctions();
        functions.setBike(bike);
        String dashboard = "";
        int accelerated = 34;
        for (int counter = 1; counter <= 27; counter++) {
            dashboard = functions.accelerate();
        }
        String dashboard1 = "Gear 3 : " + accelerated + "kmp";
        assertEquals(dashboard1, dashboard);

        dashboard = functions.decelerate();
        int decelerated = accelerated - 3;
        dashboard1 = "Gear 3 : " + decelerated + "kmp";
        assertEquals(dashboard1, dashboard);
    }

    @Test
    public void testToDisplayGear3ToGear2DecelerationWithDecrementThree() {
        Bike bike = new Bike();
        bike.setPower(true);
        boolean on = bike.getPower();
        assertTrue(on);

        BikeFunctions functions = new BikeFunctions();
        functions.setBike(bike);
        int accelerated = 31;
        String dashboard = "";
        for (int counter = 1; counter <= 26; counter++) {
            dashboard = functions.accelerate();
        }
        String dashboard2 = "Gear 3 : " + accelerated + "kmp";
        assertEquals(dashboard2, dashboard);

        dashboard = functions.decelerate();
        int decelerated = accelerated - 3;
        dashboard2 = "Gear 2 : " + decelerated + "kmp";
        assertEquals(dashboard2, dashboard);
    }

    @Test
    public void testToDisplayGear3ToGear4AccelerationWithIncrementThree() {
        Bike bike = new Bike();
        bike.setPower(true);
        boolean on = bike.getPower();
        assertTrue(on);

        BikeFunctions functions = new BikeFunctions();
        functions.setBike(bike);
        int accelerated = 40;
        String dashboard = "";
        for (int counter = 1; counter <= 29; counter++) {
            dashboard = functions.accelerate();
        }
        String dashboard2 = "Gear 3 : " + accelerated + "kmp";
        assertEquals(dashboard2, dashboard);

        dashboard = functions.accelerate();
        accelerated += 3;
        dashboard2 = "Gear 4 : " + accelerated + "kmp";
        assertEquals(dashboard2, dashboard);
    }

    @Test
    public void testToDisplayGear4AccelerationWithIncrementFour() {
        Bike bike = new Bike();
        bike.setPower(true);
        boolean on = bike.getPower();
        assertTrue(on);

        BikeFunctions functions = new BikeFunctions();
        functions.setBike(bike);
        int accelerated = 43;
        String dashboard = "";
        for (int counter = 1; counter <= 30; counter++) {
            dashboard = functions.accelerate();
        }
        String dashboard2 = "Gear 4 : " + accelerated + "kmp";
        assertEquals(dashboard2, dashboard);

        dashboard = functions.accelerate();
        accelerated += 4;
        dashboard2 = "Gear 4 : " + accelerated + "kmp";
        assertEquals(dashboard2, dashboard);
    }

    @Test
    public void testToDisplayGear4DecelerationWithDecrementFour() {
        Bike bike = new Bike();
        bike.setPower(true);
        boolean on = bike.getPower();
        assertTrue(on);

        BikeFunctions functions = new BikeFunctions();
        functions.setBike(bike);
        String dashboard = "";
        int accelerated = 47;
        for (int counter = 1; counter <= 31; counter++) {
            dashboard = functions.accelerate();
        }
        String dashboard1 = "Gear 4 : " + accelerated + "kmp";
        assertEquals(dashboard1, dashboard);

        dashboard = functions.decelerate();
        int decelerated = accelerated - 4;
        dashboard1 = "Gear 4 : " + decelerated + "kmp";
        assertEquals(dashboard1, dashboard);
    }

    @Test
    public void testToDisplayGear4ToGear3DecelerationWithDecrementFour() {
        Bike bike = new Bike();
        bike.setPower(true);
        boolean on = bike.getPower();
        assertTrue(on);

        BikeFunctions functions = new BikeFunctions();
        functions.setBike(bike);
        int accelerated = 43;
        String dashboard = "";
        for (int counter = 1; counter <= 30; counter++) {
            dashboard = functions.accelerate();
        }
        String dashboard2 = "Gear 4 : " + accelerated + "kmp";
        assertEquals(dashboard2, dashboard);

        dashboard = functions.decelerate();
        int decelerated = accelerated - 4;
        dashboard2 = "Gear 3 : " + decelerated + "kmp";
        assertEquals(dashboard2, dashboard);
    }

}

