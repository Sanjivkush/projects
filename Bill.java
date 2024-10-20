import java.util.ArrayList;  
import java.util.List;  
import java.util.Scanner;  
import java.text.SimpleDateFormat;    
import java.util.Date;    
class Product {      
    private String pid;  
    private String cname;  
    private int qtity;  
    private double price;  
    private double tPrice;    
    Product(String pid, String cname, int qtity, double price, double tPrice) {  
        this.pid = pid;  
        this.cname = cname;  
        this.qtity = qtity;  
        this.price = price;  
        this.tPrice = tPrice;  
    }  
   
    public String getpId() {  
        return pid;  
    }  
    public String getcname() {  
        return cname;  
    }  
    public int getQty() {  
        return qtity;  
    }  
    public double getPrice() {  
        return price;  
    }  
    public double getTPrice() {  
        return tPrice;  
    }  
    
    public static void displayFormat() {  
        System.out.println("\nProduct ID \tName\tQuantity\tPrice \t\ttTotal Price\n");  
    }  
  
    public void display() {  
        System.out.format("   %s          %s      %d               %.2f             %.2f\n", pid, cname, qtity, price, tPrice);  
    }  
}  

public class Bill {  
    public static void main(String args[]) {  
        
        String id ;  
        String productName;  
        int quantity;  
        double price;  
        double totalPrice;  
        double overAllPrice=0.0;  
        double subtotal, discount;  
        char choice ;  
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");    
        Date date = new Date();          
        System.out.println("Date: " + formatter.format(date));         
        Scanner scan = new Scanner(System.in);  
        System.out.print("Enter Customer Name: ");  
        String customername = scan.nextLine();  
 
        List<Product> product = new ArrayList<>();  
        
        do {  
             
            System.out.println("Enter the product details: ");  
            System.out.print("Product ID: ");  
            id = scan.nextLine();  
            System.out.print("Product Name: ");  
            productName = scan.nextLine();  
            System.out.print("Quantity: ");  
            quantity = scan.nextInt();  
            System.out.print("Price (per unit): ");  
            price = scan.nextDouble();  
            
            totalPrice = price * quantity;  
            
            overAllPrice += totalPrice;  
             
            product.add(new Product(id, productName, quantity, price, totalPrice));  
           
            System.out.print("Want to add more items? (y or n): ");  
         
            choice = scan.next().charAt(0);  
    
            scan.nextLine();  
            
        } while (choice == 'y' || choice == 'Y');  

        Product.displayFormat();  
        for (Product p : product) {  
            p.display();  
        }  
 
        System.out.println("Total Amount (Rs.): " + overAllPrice);  
      
        discount = overAllPrice * 4 / 100;  
        System.out.println("Discount (Rs.): " + discount);  
         
        subtotal = overAllPrice - discount;   
        System.out.println("Subtotal: " + subtotal);  
        scan.close();  
    }     
}
