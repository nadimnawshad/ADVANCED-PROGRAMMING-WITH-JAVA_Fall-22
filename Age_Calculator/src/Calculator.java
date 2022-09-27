import java.time.LocalDate;
import java.time.Period;

public class Calculator<T extends Person>{
    private T person;
    public Calculator(T person){
        this.person = person;
    }
    public String calculated_total_days(){
        LocalDate currentDate = LocalDate.now();
        Period period = Period.between(person.getDob(), currentDate);
        String age = "Your age is: " + period.getYears() + " years " + period.getMonths() + " months " + period.getDays() + " days " ;
        return age;
    }
}
