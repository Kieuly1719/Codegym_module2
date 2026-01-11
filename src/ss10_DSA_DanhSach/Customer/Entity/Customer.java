package ss10_DSA_DanhSach.Customer.Entity;

public class Customer {
    private int id;
    private String name;
    private int type;
    private String address;
    private static int count = 1;

    public Customer() {
    }

    public Customer(String name, String address, int type) {
        this.id = count;
        this.name = name;
        this.type = type;
        this.address = address;
        count++;
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

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    @Override
    public String toString() {
        String str = this.getName() + " " + this.getType() + " | " + this.getAddress();
        return str;
    }
}
