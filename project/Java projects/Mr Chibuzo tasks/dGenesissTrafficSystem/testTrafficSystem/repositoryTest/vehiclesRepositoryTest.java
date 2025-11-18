import data.models.Gender;
import data.models.Owner;
import data.models.Vehicle;
import data.repositories.VehicleRepository;
import data.repositories.Vehicles;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Year;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class vehiclesRepositoryTest {
    VehicleRepository vehiclesRepo;
    Vehicle vehicle;

    @BeforeEach
    void setUp() {
        vehiclesRepo = new Vehicles();
        vehicle = new Vehicle("Toyota", "Camry", Year.of(2020), "PN1000A", new Owner("Daniel", "VI", "DD@gmail.com", 7031032739L, Gender.MALE));
    }

    @AfterEach
    void tearDown() {
        vehiclesRepo.deleteAll();
    }

    @Test
    public void testToSaveVehicle() {
        vehiclesRepo.save(vehicle);
        assertEquals(1, vehiclesRepo.count());
        assertEquals("PN1000A", vehiclesRepo.findById(100).getPlateNumber());
    }

    @Test
    public void testToPreventDuplicateVehicle() {
        vehiclesRepo.save(vehicle);
        Vehicle copy = new Vehicle("Toyota", "Camry", Year.of(2020), "PN1000A", new Owner("Daniel", "VI", "DD@gmail.com", 7031032739L, Gender.MALE));
        vehiclesRepo.save(copy);
        assertEquals(1, vehiclesRepo.count());
    }

    @Test
    public void testUpdateVehicle() {
        vehiclesRepo.save(vehicle);
        vehiclesRepo.updateVehicle(vehicle, "Toyota", "PN2000B", Year.of(2021), "Corolla", "Daniel", "VI", "DD@gmail.com", 7031032739L, Gender.MALE);

        Vehicle update = vehiclesRepo.findById(100);
        assertEquals("PN2000B", update.getPlateNumber());
        assertEquals("Corolla", update.getModel());
    }

    @Test
    public void testDeleteVehicle() {
        vehiclesRepo.save(vehicle);
        vehiclesRepo.delete(vehicle);
        assertEquals(0, vehiclesRepo.count());
        assertTrue(vehiclesRepo.findAll().isEmpty());
    }


    @Test
    public void testDeleteById() {
        vehiclesRepo.save(vehicle);
        vehiclesRepo.deleteById(100);
        assertEquals(0, vehiclesRepo.count());
    }
}

