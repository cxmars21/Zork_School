package src;

public class Key extends InventoryItem {
    // Additional fields specific to Key
    private String nameOfRoomIWorkIn;
    private String directionToOpen;

    // Constructor
    public Key(String name, String description, String nameOfRoomIWorkIn, String directionToOpen) {
        super(name, description, 0.3); // weight is always 0.3
        this.nameOfRoomIWorkIn = nameOfRoomIWorkIn;
        this.directionToOpen = directionToOpen;
    }

    // Getters for the new fields
    public String getNameOfRoomIWorkIn() {
        return nameOfRoomIWorkIn;
    }

    public String getDirectionToOpen() {
        return directionToOpen;
    }

    // Override getDescription to include nameOfRoomIWorkIn
    @Override
    public String getDescription() {
        return super.getDescription() + " (Works in room: " + nameOfRoomIWorkIn + ")";
    }

    // Override toString to include nameOfRoomIWorkIn
    @Override
    public String toString() {
        return super.toString() + "\nWorks in Room: " + nameOfRoomIWorkIn + "\nDirection to Open: " + directionToOpen;
    }
}