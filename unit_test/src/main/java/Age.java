import java.time.LocalDate;
import java.time.Period;

public class Age {

    public static boolean isAgeMoreThan18(LocalDate birthDate) {
        return Period.between(birthDate, LocalDate.now()).getYears() >= 18;
    }
}