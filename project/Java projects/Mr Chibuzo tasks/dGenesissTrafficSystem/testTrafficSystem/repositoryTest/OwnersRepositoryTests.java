import data.models.Gender;
import data.models.Owner;
import data.repositories.OwnerRepository;
import data.repositories.Owners;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class OwnersRepositoryTests {
    OwnerRepository ownerRepo;
    Owner owner;

    @BeforeEach
    void setUp() {
        ownerRepo = new Owners();
        owner = new Owner("Daniel", "VI", "DD@gmail.com", 7031032739L, Gender.MALE);
    }

    @AfterEach
    void tearDown() {
        ownerRepo.deleteAll();
    }

    @Test
    void testToSaveOwner() {
        ownerRepo.save(owner);
        assertEquals(1, ownerRepo.count());
        assertEquals("Daniel", ownerRepo.findById(0).getName());
    }

    @Test
    void testUpdateOwner() {
        ownerRepo.save(owner);
        ownerRepo.updateOwner(owner, "Daniel Smith", "NY", "daniel.smith@gmail.com", 1234567890L, Gender.MALE);

        Owner updated = ownerRepo.findById(0);
        assertEquals("Daniel Smith", updated.getName());
        assertEquals("NY", updated.getAddress());
        assertEquals("daniel.smith@gmail.com", updated.getEmail());
        assertEquals(1234567890L, updated.getPhone());
    }

    @Test
    void testDeleteOwner() {
        ownerRepo.save(owner);
        ownerRepo.delete(owner);
        assertEquals(0, ownerRepo.count());
        assertTrue(ownerRepo.findAll().isEmpty());
    }

    @Test
    void testDeleteOwnerById() {
        ownerRepo.save(owner);
        ownerRepo.deleteById(0);
        assertEquals(0, ownerRepo.count());
    }
}
