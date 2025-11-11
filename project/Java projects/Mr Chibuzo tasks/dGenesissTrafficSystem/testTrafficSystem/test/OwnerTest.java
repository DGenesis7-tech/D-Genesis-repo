import data.models.Gender;
import data.models.Owner;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OwnerTest {
    @Test
    public void OwnerTestToSetName() {
        Owner owner = new Owner();
        owner.setName("Daniel");
        String name = owner.getName();
        assertEquals(name, owner.getName());
    }

    @Test
    public void OwnerTestToSetEmail() {
        Owner owner = new Owner();
        owner.setName("Daniel");
        assertEquals("Daniel", owner.getName());

        owner.setEmail("DanielOkp328@gmail.com");
        String email = owner.getEmail();
        assertEquals(email, owner.getEmail());
    }

    @Test
    public void OwnerTestToSetPhoneNumber() {
        Owner owner = new Owner();
        owner.setName("Daniel");
        assertEquals("Daniel", owner.getName());

        long phone = 9031032739L;

        owner.setPhone(phone);
        assertEquals(phone, owner.getPhone());
    }

    @Test
    public void OwnerTestToSetGender() {
        Owner owner = new Owner();
        owner.setName("Daniel");
        assertEquals("Daniel", owner.getName());

        owner.setGender("M");
        assertEquals(Gender.MALE, owner.getGender());
    }

    @Test
    public void OwnerTestToSetAddress() {
        Owner owner = new Owner();
        owner.setName("Daniel");
        assertEquals("Daniel", owner.getName());

        owner.setAddress("Victoria Island Lagos");
        assertEquals("Victoria Island Lagos", owner.getAddress());
    }

    @Test
    public void OwnerTestToSetId() {
        Owner owner = new Owner();
        owner.setName("Daniel");
        assertEquals("Daniel", owner.getName());

        owner.setId("123Genesis");
        assertEquals("123Genesis", owner.getId());
    }

}
