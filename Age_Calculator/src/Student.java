public class Student extends Person{
     public String id;

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
    public void display(){
        System.out.println("Name : "+getName());
        System.out.println("Email : "+getEmail());
        System.out.println("DOB : "+getDob());
        System.out.println("ID : "+id);
    }
}
