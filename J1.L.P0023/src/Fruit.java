public class Fruit {
    private String FruitID;
    private String FruitName;
    private int price;
    private int Quan;
    private String Origin;

    public Fruit() {
    }

    public Fruit(String FruitID, String FruitName, int price, int Quan, String Origin) {
        this.FruitID = FruitID;
        this.FruitName = FruitName;
        this.price = price;
        this.Quan = Quan;
        this.Origin = Origin;
    }

    public String getFruitID() {
        return FruitID;
    }

    public void setFruitID(String FruitID) {
        this.FruitID = FruitID;
    }

    public String getFruitName() {
        return FruitName;
    }

    public void setFruitName(String FruitName) {
        this.FruitName = FruitName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuan() {
        return Quan;
    }

    public void setQuan(int Quan) {
        this.Quan = Quan;
    }

    public String getOrigin() {
        return Origin;
    }

    public void setOrigin(String Origin) {
        this.Origin = Origin;
    }
    public String toString(){
        return String.format("%7s | %10s | %3d | %3d | %10s",FruitID,FruitName,price,Quan,Origin);
    }
    
}
