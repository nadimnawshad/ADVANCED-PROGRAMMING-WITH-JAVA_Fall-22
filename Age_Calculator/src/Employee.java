public class Employee extends Person{
    int salary;

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getSalary() {
        return salary;
    }

    public void display(){
        System.out.println("Name : "+getName());
        System.out.println("Email : "+getEmail());
        System.out.println("DOB : "+getDob());
        System.out.println("Salary : "+salary);
    }
}
