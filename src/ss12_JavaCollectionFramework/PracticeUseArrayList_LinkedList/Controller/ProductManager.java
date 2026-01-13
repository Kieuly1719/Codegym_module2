package ss12_JavaCollectionFramework.PracticeUseArrayList_LinkedList.Controller;

import ss12_JavaCollectionFramework.PracticeUseArrayList_LinkedList.Model.Product;
import ss12_JavaCollectionFramework.PracticeUseArrayList_LinkedList.Model.ProductService;

import java.util.Scanner;

public class ProductManager {
    public static ProductService productService = new ProductService();
    public ProductManager() {}
    public void addProduct(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập tên sản phẩm: ");
        String name = sc.nextLine();
        System.out.print("Nhập giá sản phẩm: ");
        double price = sc.nextDouble();
        Product newProduct = new Product(name, price);
        productService.addProduct(newProduct);
    }
    public void removeProduct()
    {
        System.out.print("Nhập id sản phẩm muốn xóa: ");
        Scanner sc = new Scanner(System.in);
        int id = sc.nextInt();
        productService.removeProduct(id);
    }
    public void DisplayAllProducts()
    {
        productService.DisplayAllProducts();
    }
    public void FindProductByName()
    {
        System.out.print("Nhập tên sản phẩm: ");
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        Product product = productService.FindProductByName(name);
        System.out.println("Tên sản phẩm: " + product.getName());
        System.out.println("Giá sản phẩm: " + product.getPrice());
    }
    public void SortByPrice()
    {
        System.out.println("Sắp xếp sản phẩm theo giá: ");
        System.out.println("1. Tăng dần");
        System.out.println("2. Giảm dần");
        System.out.print("Nhập lựa chọn của bạn: ");
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        if(choice == 0){
            productService.SortByPrice(0);
        }
        else if(choice == 1){
            productService.SortByPrice(1);
        }
        else{
            System.out.println("Lựa chọn của bạn không hợp lệ");
        }
    }
    public void UpdateProductById(){
        System.out.print("Nhập Id sản phẩm bạn muốn chỉnh sửa: ");
        Scanner sc = new Scanner(System.in);
        int id = sc.nextInt();
        sc.nextLine();
        Product product = productService.FindProductById(id);
        System.out.print("1. Nhập tên sản phẩm: ");
        String name = sc.nextLine();
        System.out.print("2. Nhập giá sản phẩm: ");
        double price = sc.nextDouble();
        productService.UpdateProduct(id, name, price);
        System.out.println("Đã cập nhật thông tin sản phẩm thành công");
        productService.DisplayAllProducts();
    }
}
