import org.testng.annotations.Test;

import java.time.LocalDate;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class AgeTest {

    @Test(description = "Checking if the applied age is more than 18")
    public void testValidateAge() {
        LocalDate now = LocalDate.now();
        // age is 18
        LocalDate validBirthday = now.minusYears(18);
        // age is one day less than 18
        LocalDate invalidBirthday = now.minusYears(18).plusDays(1);

        assertTrue(Age.isAgeMoreThan18(validBirthday));
        assertFalse(Age.isAgeMoreThan18(invalidBirthday));
    }
}