package Entity;

public class Employee {
    private String id;
    private String FirstName;
    private String LastName;
    private String phone;
    private String email;
    private String address;
    private String DOB;
    private String Sex;
    private double salary;
    private String engecy;

    public Employee() {
    }

    public Employee(String id, String FirstName, String LastName, String phone, String email, String address, String DOB, String Sex, double salary, String engecy) {
        this.id = id;
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.DOB = DOB;
        this.Sex = Sex;
        this.salary = salary;
        this.engecy = engecy;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String LastName) {
        this.LastName = LastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDOB() {
        return DOB;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    public String getSex() {
        return Sex;
    }

    public void setSex(String Sex) {
        this.Sex = Sex;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getEngecy() {
        return engecy;
    }

    public void setEngecy(String engecy) {
        this.engecy = engecy;
    }

    @Override
    public String toString() {
        return id + "   " + FirstName + "   " + LastName + "    " + phone + "   " + email + "   " + address + " " + DOB + " " + Sex + " " + salary + "  " + engecy;
    }
    
}
