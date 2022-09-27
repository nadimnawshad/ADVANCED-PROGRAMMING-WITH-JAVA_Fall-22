import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
public class Main {
    public static void main(String[] args) {
       List<Person> person = new ArrayList<>();

        Employee e = new Employee();
        e.setName("Nadim");
        e.setEmail("nn@gmail.com");
        e.setDob(LocalDate.of(2001, 06, 25 ));
        e.setSalary(5000);
        person.add(e);

        Student s = new Student();
        s.setName("Nawshad");
        s.setEmail("naw@gmail.com");
        s.setDob(LocalDate.of(2004,01,27));
        s.setId("20-42609-1");
        person.add(s);

        for (Person p:person) {
            p.display();
            Calculator calculator = new Calculator(p);
            System.out.println(calculator.calculated_total_days());
        }



    }
}