import org.testng.annotations.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RegexProcessorTest {

    @Test
    public void testPhoneNumberValidation() {
        RegexProcessor processor = new RegexProcessor();
        assertTrue(processor.isPhoneNumberValid("(080)12345678"));
    }

    @Test
    public void testInvalidPhoneNumber() {
        RegexProcessor processor = new RegexProcessor();
        assertFalse(processor.isPhoneNumberValid("(080)1234567"));
    }

    @Test
    public void testEmailValidation() {
        RegexProcessor processor = new RegexProcessor();
        assertTrue(processor.isEmailValid("Danielokp328@gmail.com"));
    }

    @Test
    public void testEmailValidation2() {
        RegexProcessor processor = new RegexProcessor();
        assertTrue(processor.isEmailValid("d.genesis@native.semicolon.africa"));
    }

    @Test
    public void testInvalidEmail() {
        RegexProcessor processor = new RegexProcessor();
        assertFalse(processor.isEmailValid("__________@gmail.com"));
    }

}
