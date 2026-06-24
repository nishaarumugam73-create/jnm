import java.util.Scanner;

class Inventory {
    int id;
    String name;
    int quantity;
    double price;
}

public class InventorySystem1{

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Inventory[] products = new Inventory[100];
        int count = 0;
        int choice;

        do {
            System.out.println("\n===== INVENTORY MANAGEMENT SYSTEM =====");
            System.out.println("1. Insert Product");
            System.out.println("2. Display Products");
            System.out.println("3. Update Product");
            System.out.println("4. Delete Product");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    products[count] = new Inventory();

                    System.out.print("Enter Product ID: ");
                    products[count].id = sc.nextInt();

                    sc.nextLine();

                    System.out.print("Enter Product Name: ");
                    products[count].name = sc.nextLine();

                    System.out.print("Enter Quantity: ");
                    products[count].quantity = sc.nextInt();

                    System.out.print("Enter Price: ");
                    products[count].price = sc.nextDouble();

                    count++;
                    System.out.println("Product Added Successfully!");
                    break;

                case 2:
                    if (count == 0) {
                        System.out.println("No Products Available.");
                    } else {
                        System.out.println("\nID\tName\tQuantity\tPrice");
                        for (int i = 0; i < count; i++) {
                            System.out.println(
                                    products[i].id + "\t" +
                                    products[i].name + "\t" +
                                    products[i].quantity + "\t\t" +
                                    products[i].price);
                        }
                    }
                    break;

                case 3:
                    System.out.print("Enter Product ID to Update: ");
                    int updateId = sc.nextInt();

                    boolean found = false;

                    for (int i = 0; i < count; i++) {
                        if (products[i].id == updateId) {

                            sc.nextLine();

                            System.out.print("Enter New Name: ");
                            products[i].name = sc.nextLine();

                            System.out.print("Enter New Quantity: ");
                            products[i].quantity = sc.nextInt();

                            System.out.print("Enter New Price: ");
                            products[i].price = sc.nextDouble();

                            found = true;
                            System.out.println("Product Updated Successfully!");
                            break;
                        }
                    }

                    if (!found) {
                        System.out.println("Product Not Found!");
                    }
                    break;

                case 4:
                    System.out.print("Enter Product ID to Delete: ");
                    int deleteId = sc.nextInt();

                    int index = -1;

                    for (int i = 0; i < count; i++) {
                        if (products[i].id == deleteId) {
                            index = i;
                            break;
                        }
                    }

                    if (index != -1) {
                        for (int i = index; i < count - 1; i++) {
                            products[i] = products[i + 1];
                        }

                        products[count - 1] = null;
                        count--;

                        System.out.println("Product Deleted Successfully!");
                    } else {
                        System.out.println("Product Not Found!");
                    }
                    break;

                case 5:
                    System.out.println("Thank You!");
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }

        } while (choice != 5);

        sc.close();
    }
}