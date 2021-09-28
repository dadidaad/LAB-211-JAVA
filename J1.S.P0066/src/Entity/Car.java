package Entity;

public class Car {
    private String name;
    private String color;
    private double price;
    private String day;

    public Car() {
    }

    public Car(String name, String color, double price, String day) {
        this.name = name;
        this.color = color;
        this.price = price;
        this.day = day;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public double getPrice() {
        return price;
    }

    public String getDay() {
        return day;
    }
}
