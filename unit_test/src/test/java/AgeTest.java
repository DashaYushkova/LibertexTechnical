import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class AgeTest {

    private LocalDate invalidBirthday, validBirthday;

    @BeforeMethod(description = "Preparing valid & invalid data")
    public void prepareTestData() {
        validBirthday = getYearsAgo(18);
        invalidBirthday = getYearsAgo(17);
    }

    @Test(description = "Checking if the applied age is more than 18")
    public void testValidateAge() {
        assertFalse(Age.calculateAge(invalidBirthday) >= 18);
        assertTrue(Age.calculateAge(validBirthday) >= 18);
    }

    private LocalDate getYearsAgo(int yearsAgo){
        Calendar date = Calendar.getInstance();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        date.set(Calendar.YEAR, date.get(Calendar.YEAR) - yearsAgo);
        return LocalDate.parse(formatter.format(date.getTime()));
    }
}