package src;

public class Food extends InventoryItem {
    // Additional field specific to Food
    private int healthValue;

    // Constructor
    public Food(String name, String description, double weight, int healthValue) {
        super(name, description, weight);
        this.healthValue = healthValue;
    }

    // Getter for healthValue
    public int getHealth() {
        return healthValue;
    }

    // Override toString to include health value
    @Override
    public String toString() {
        return super.toString() + "\nHealth Value: " + healthValue;
    }
}