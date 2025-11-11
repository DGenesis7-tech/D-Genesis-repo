import data.models.Vehicle;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VehicleTest {
    @Test
    public void vehicleTestToGetVehicleName() {
        Vehicle vehicle = new Vehicle();
        vehicle.setName("Toyota");
        assertEquals("Toyota", vehicle.getName());
    }

    @Test
    public void vehicleTestToSetVehicleModel() {
        Vehicle vehicle = new Vehicle();

        vehicle.setName("Toyota");
        assertEquals("Toyota", vehicle.getName());

        vehicle.setModel("Camry");
        assertEquals("Camry", vehicle.getModel());
    }

    @Test
    public void vehicleTestToSetVehicleName() {
        Vehicle vehicle = new Vehicle();
        vehicle.setName("Toyota");
        assertEquals("Toyota", vehicle.getName());
    }

    @Test
    public void vehicleTestToSetYear() {
        Vehicle vehicle = new Vehicle();
        vehicle.setName(
    }
}
