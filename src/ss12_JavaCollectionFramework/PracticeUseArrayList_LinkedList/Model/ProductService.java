package ss12_JavaCollectionFramework.PracticeUseArrayList_LinkedList.Model;

import java.util.ArrayList;
import java.util.Comparator;

public class ProductService {
    public static ArrayList<Product> products = new ArrayList<>();
    public ProductService() {
        products.add(new Product("Sửa rửa mặt Hadalabo", 60.000));
        products.add(new Product("Nước tẩy trang Loreal", 175.000));
        products.add(new Product("Son romand", 150.000));
        products.add(new Product("Phấn phủ carland", 290.000));
    }
    public void addProduct(Product product) {
        products.add(product);
        System.out.println("Thêm sản phẩm thành công");
        DisplayAllProducts();
    }
    public void removeProduct(int id) {
        if(FindProductById(id) == null) {
            System.out.println("Khong tìm thấy sản phẩm có id: " + id);
        }
        else{
            products.remove(FindProductById(id));
            System.out.println("Xóa sản phẩm thành công");
            DisplayAllProducts();
        }
    }
    public void DisplayAllProducts() {
        System.out.println("Danh sách sản phẩm:");
        for (Product product : products) {
            System.out.println("    " + product.getId() + " - " + product.getName() + " - " + product.getPrice());
        }
    }
    public Product FindProductById(int id){
        for(Product product : products){
            if(product.getId() == id){
                return product;
            }
        }
        return null;
    }
    public Product FindProductByName(String name){
        for(Product product : products){
            if(product.getName().equals(name)){
                return product;
            }
        }
        return null;
    }
    public void SortByPrice(int i){
        if(i == 0){
            products.sort(Comparator.comparing(Product::getPrice));
            DisplayAllProducts();
        }
        else{
            products.sort(Comparator.comparing(Product::getPrice).reversed());
            DisplayAllProducts();
        }
    }
    public void UpdateProduct(int id, String name, double price){
        for(Product product : products){
            if(product.getId() == id){
                product.setName(name);
                product.setPrice(price);
                return;
            }
        }
    }
}
