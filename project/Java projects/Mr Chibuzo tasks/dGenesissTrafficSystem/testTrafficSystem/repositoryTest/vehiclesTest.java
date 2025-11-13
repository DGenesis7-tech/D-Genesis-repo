import data.models.Vehicle;
import data.repositories.Vehicles;
import org.junit.jupiter.api.Test;

import java.time.Year;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class vehiclesTest {
    @Test
    public void vehiclesTestToRegisterVehicle() {
        Vehicle vehicle = new Vehicle();
        vehicle.setName("Toyota");
        vehicle.setModel("Camry");
        vehicle.setYear(Year.parse("2020"));
        vehicle.setPlateNumber("PN1000A");
        Vehicles vehicles = new Vehicles();
        vehicles.updateVehicle(vehicle);

        assertEquals("PN1000A", vehicle.getPlateNumber());
    }

    @Test
    public void vehiclesTestToSaveVehicle() {
        Vehicle vehicle = new Vehicle();
        vehicle.setName("Toyota");
        vehicle.setModel("Camry");
        vehicle.setYear(Year.parse("2020"));
        vehicle.setPlateNumber("PN1000A");
        Vehicles vehicles = new Vehicles();
        vehicles.updateVehicle(vehicle);
        assertEquals("PN1000A", vehicle.getPlateNumber());

        vehicles.save(vehicle);

    }
}
