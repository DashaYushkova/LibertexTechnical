import org.testng.annotations.Test;

import java.time.LocalDate;

import static org.testng.Assert.assertTrue;

public class AgeTest {

    @Test(description = "Checking that the applied age is more than 18")
    public void testCalculateAge() {
        LocalDate birthDate = LocalDate.of(1988, 9, 26);
        int actualAge = Age.calculateAge(birthDate);
        assertTrue(actualAge >= 18);
    }
}