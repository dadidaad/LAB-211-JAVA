public class Order {
    private String id;
    private String name;
    private int quantity;
    private int price;
    public Order() {
    }

    public Order(String id, String name, int quantity, int price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }
    

    public double getPrice() {
        return price;
    }
    public int getAmount(){
        return price*quantity;
    }

    @Override
    public String toString() {
        return String.format("%7s %3d %3d$ %3d$",name,quantity,price,getAmount());
    }
}
