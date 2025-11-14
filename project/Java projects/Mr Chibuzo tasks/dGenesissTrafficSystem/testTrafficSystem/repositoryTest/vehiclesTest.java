import data.models.Gender;
import data.models.Owner;
import data.models.Vehicle;
import data.repositories.Vehicles;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Year;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class vehiclesTest {
    @BeforeEach
    void setUp() {
        Vehicles vehicles = new Vehicles();
        Vehicle vehicle = new Vehicle();
    }

    @Test
    public void vehiclesTestToRegisterVehicle() {
        Vehicle  vehicle = new Vehicle();
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
        vehicle.setOwner(new Owner("Daniel", "VI", 7031032739L, Gender.MALE, "DD@gmail.com", "00").toString());
        Vehicles vehicles = new Vehicles();
        vehicles.save(vehicle);
        assertTrue(vehicle == );
    }
}
