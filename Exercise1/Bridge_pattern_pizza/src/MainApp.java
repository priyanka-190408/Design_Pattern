import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Choose restaurant
        System.out.println("Select Restaurant: 1. American  2. Italian");
        int restChoice = sc.nextInt();
        sc.nextLine(); // consume newline

        // Choose pizza
        System.out.println("Select Pizza: 1. Pepperoni  2. Veggie");
        int pizzaChoice = sc.nextInt();
        sc.nextLine(); // consume newline

        Pizza pizza = null;
        switch(pizzaChoice) {
            case 1 -> pizza = new PepperoniPizza();
            case 2 -> pizza = new VeggiePizza();
            default -> { System.out.println("Invalid pizza choice!"); return; }
        }

        Restaurant restaurant = null;
        switch(restChoice) {
            case 1 -> restaurant = new AmericanRestaurant(pizza);
            case 2 -> restaurant = new ItalianRestaurant(pizza);
            default -> { System.out.println("Invalid restaurant choice!"); return; }
        }

        // Deliver order
        restaurant.deliver();
    }
}
