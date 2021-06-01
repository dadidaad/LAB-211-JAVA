package Entity;

public class Person {
    private String name;
    private String address;
    private double money;

    public Person() {
    }

    public Person(String name, String address, double money) {
        this.name = name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();
        this.address = address.substring(0, 1).toUpperCase() + address.substring(1).toLowerCase();
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public double getMoney() {
        return money;
    }
    public String toString(){
        return String.format("%-10s  %-10s  %-5.1f", getName(), getAddress(), getMoney());
    }
}
