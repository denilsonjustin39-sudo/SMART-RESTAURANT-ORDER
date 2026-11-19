import java.util.Scanner;

public class SmartRestaurantOrder {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Ask for customer info
        System.out.print("Customer's name: ");
        String name = sc.nextLine();
        
        System.out.print("Customer's age: ");
        int age = sc.nextInt();
        
        System.out.print("Meal cost: ");
        double meal = sc.nextDouble();
        
        System.out.print("Number of drinks: ");
        int drinksCount = sc.nextInt();
        
        System.out.print("Is student (true/false): ");
        boolean isStudent = sc.nextBoolean();
        
        System.out.print("Service rating (1 to 5): ");
        int rating = sc.nextInt();
        
        // Check if rating is valid
        if (rating < 1 || rating > 5) {
            System.out.println("Error: Rating must be between 1 and 5!");
        } else {
            // Calculate drinks and subtotal
            double drinksCost = drinksCount * 15.50;
            double subtotal = meal + drinksCost;
            
            // Figure out the discount
            double discount = 0.0;
            boolean isSenior = (age >= 60);
            
            if (isStudent && isSenior) {
                // Student is 10%, Senior is 5%, pick the bigger one
                if (0.10 > 0.05) {
                    discount = subtotal * 0.10;
                } else {
                    discount = subtotal * 0.05;
                }
            } else if (isStudent) {
                discount = subtotal * 0.10;
            } else if (isSenior) {
                discount = subtotal * 0.05;
            }
            
            double afterDiscount = subtotal - discount;
            
            // Tip rule (10% if rating is 4 or 5)
            double tip = 0.0;
            if (rating == 4 || rating == 5) {
                tip = afterDiscount * 0.10;
            }
            
            double finalBill = afterDiscount + tip;
            int wholeAmount = (int) finalBill;
            
            // Print out the receipt
            System.out.println("\nSMART RESTAURANT");
            System.out.println("Customer: " + name);
            System.out.println("Meal: $" + meal);
            System.out.println("Drinks: $" + drinksCost);
            System.out.println("Discount: $" + discount);
            System.out.println("Tip: $" + tip);
            System.out.println("Final bill: $" + finalBill);
            System.out.println("Whole amount: $" + wholeAmount);
        }
        
        sc.close();
    }
}