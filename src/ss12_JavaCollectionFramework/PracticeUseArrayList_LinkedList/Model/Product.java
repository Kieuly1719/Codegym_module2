package ss12_JavaCollectionFramework.PracticeUseArrayList_LinkedList.Model;

public class Product {
    public int id;
    public String name;
    public double price;
    public static int count = 0;
    public Product() {}
    public Product(String name, double price) {
        this.id = count++;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
