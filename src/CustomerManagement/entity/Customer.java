package CustomerManagement.entity;

public class Customer {
    private String id;
    private String name;
    private int type;
    private String address;

    public Customer(String id, String name, int type, String address) {
        this.id = id;
        this.name = name;
        this.type = type; //0 hoặc 1
        this.address = address;
    }

    public Customer() {}

    public String getId() {
        return id;
    }

    public void setId(String id) {
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
        String type;
        if(this.getType()==0) {
            type = "Cá nhân";
        }
        else{
            type = "Doanh nghiệp";
        }
        String str = this.getId() + " | " + this.getName() + " | " + type + " | " + this.getAddress();
        return str;
    }
}
