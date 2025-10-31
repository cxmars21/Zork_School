package src;

//TODO: Add the custom commands you made in Checkpoint 2 and your Execute commands if needed








import java.util.*;

/*
 * 
 * All green comments are tasks for these checkpoints
 * Note that this code will be used for both checkpoints 4 and 5.
 * Be sure to focus only on the checkpoint you are currently assigned to work on.
 * 
 */


/**
 * Creates the class Commands, 
 * There will only be one instance used by the game
 * therefore all of its methods are static to prevent multiple
 */

public class Commands {



/*
 * TODO: checkpoint 4 Tasks
 * 
 * add class level variables
 * Declare a two dimensional array called "map" it should be of type "Room"
 * Declare two variables of type int called "row" and "column"
 * Declare a Room object called currentRoom
 * 
 * note that these variables should be "static" because there should only be one world
 */

  
 

    static Room[][] map = new Room[4][5];
    static int row;
    static int column;
    static Room currentRoom;
    static ArrayList<InventoryItem> armoryItems = new ArrayList<>();
    static ArrayList<InventoryItem> castleFrontItems = new ArrayList<>();
    static ArrayList<InventoryItem> kitchenItems = new ArrayList<>();
    static ArrayList<InventoryItem> entranceHallItems = new ArrayList<>();
    static ArrayList<InventoryItem> dimPassageItems = new ArrayList<>();
    static ArrayList<InventoryItem> sleepingQuartersItems = new ArrayList<>();
    static ArrayList<InventoryItem> throneHallItems = new ArrayList<>();
    static ArrayList<InventoryItem> artifactRoomItems = new ArrayList<>();
    static ArrayList<InventoryItem> playerInventory = new ArrayList<>();
    
    

/**
 * runGame method
 * method responsible for running a console version of the game
 * this method returns nothing and has no parameters
 * it contains the while loop that is used to run the game
 */
    
    public static void runGame(){
      

/*
 * TODO: checkpoint 4 Tasks
 * 
 * initialize your map 
 * 
 * then construct each room of your world, 
 * be sure they match the correct locations of you map and have the appropriate 
 * passages set to true and false
 * Any spot in your map that is not used should be built with the default constructor
 * 
 * HINT: The upper left is row 0 and column 0
 */

    Commands cmd = new Commands();
    cmd.setUpGame();

    map[0][0]= new Room(false, false, true, false,"Armory", "An empty room filled to the brim \nwith sets of armor and equipment.\nYou can only leave through the door you entered.", armoryItems);    
    map[0][1]= new Room(false, true, true, true,"Kitchen", "The cooks and servants are running around in this large room. \nOn the table is chicken leg and a loaf of bread. \nThere appears to  be a secret door behind a cabinet to the west.", kitchenItems); 
     
    map[0][2]= new Room(false, false, true, true,"Dining hall", "There is a large table filled with a feast. \nServants are cleaning the table and serving food. \nNobody notices you sneak through the back."); 
    map[0][3]= new Room(false, true, true, true,"Throne room ", "You walk into a large room filled with magnificent paintings and a throne. \nNobody appears to be around, but you can hear the faint sound of footsteps.", throneHallItems); 
    
    map[0][4]= new Room(false, true, false, true,"Throne hall ", "You walk down an ominous hall filled with statues and armor.");     
    map[1][1]= new Room(true, true, false, false,"Guarded door", "You see an enormous door guarded by 5 soldiers. \nYou see a small opening to the south that you could crowl \nthrough without being seen."); 
    map[1][2]= new Room(false, false, true, false,"Closet", "You enter a small closet filled with outfits for the soldiers and servants."); 
    map[1][3]= new Room(true, false, false, true,"Sleeping quarters", "You enter a large room filled with beds and sleeping soldiers. \nBe careful not to alert them!", sleepingQuartersItems); 
    map[1][4]= new Room(true, true, false, false,"Lookout tower", "You look outside of a large lookout tower from the top of the castle. \nYou can see the entire castle and notice that \neach exit is highly guarded except for the backdoor.");  
    map[2][1]= new Room(true, true, false, false,"Dim passage", "You walk into a dimly lit passage. \nYou feel something walk by your feet. \nYou see a massive room at the end of the tunnel.", dimPassageItems); 
    map[2][2]= new Room(false, false, true, false,"Castle front", "In front of you is an enormous castle. \nYou hear the sound of a large army inside.", castleFrontItems); 
    // starting point
    map[2][3]= new Room(false, false, false, true,"Entrance hall", "You enter the castle and are met by a locked door. \nYou hear guards talking on the other side of the door. \nOn the door you notice that you need a key to open.", entranceHallItems); 
    // east should be locked
    map[2][4]= new Room(true, false, false, true,"Guard station", "You slowly open the door and see 3 guards with their backs turned. \nThey do not notice your presence at first. \nYou see a ladder to the north."); 
    map[3][0]= new Room(false, false, true, false,"Training arena", "You enter a large coliseum area. \nYou look around and see many ferocious warriors surrounding you.");     
    map[3][1]= new Room(true, false, false, true,"Open room", "The massive room has two exits. \nOne door to the west is highly decorated with drawings of fights \nand the other to the east is plain and sturdy looking."); 
    // east should be locked
    map[3][2]= new Room(false, false, true, true,"Artifact room", "A large room with a pedestal in the middle holding the artifact. \nYou hear the sound of soldiers being alerted of your presence. \nYour only exit is to the East!", artifactRoomItems); 
    
    map[3][3]= new Room(false, false, false, false,"Back of castle", "You run to the back exit of the castle and escape. \nYou are free and have successfully completed your mission!"); 
    // winning room 


    

/*
 * TODO: checkpoint 4 Tasks
 * 
 * initialize the values for your variables "row" and "column"
 * to represent the starting location of your game, 
 * then set the currentRoom to the starting location
 * 
 */
    
    
    row = 2;
    column = 2;
    currentRoom = map[row][column]; 
    
    
    
    

        
        String userInput = "";
        String command = "";
        String item = "";
        Scanner s = new Scanner(System.in);
        
//TODO: When you have made your game work in the console
//change done to true to play your game in the JFrame        
        boolean done = false;
        String output ="";
        if(!done){
            output = gameIntro();
            System.out.println(output);
        }
        
        while(!done){
            System.out.print("\n\n>>");      
            userInput = s.nextLine().toLowerCase();
            command = getFirstWord(userInput);
            item = getRestOfSentence(userInput);
            output = executeCommand(command, item);

            /*
             * TODO: checkpoint 4 Task
             * 
             * Update the currentRoom to the new location on the map
             * Hint: there is a new method for this, go to the bottom and make it
             * using the currentRoom object. 
             */

            updateRoom();
            
            if (currentRoom.getName().equalsIgnoreCase("Back of castle")) {
                System.out.println("Congratulations! \nYou escaped the castle and completed your mission!");
                done = true;
                continue;
            }
            
            
            System.out.println(output +"\n"); 

            if(command.equals("quit"))
                done = true;
          }
          s.close();    
    }
    
/**
 * gameIntro method 
 * used to set the scene to the opening of your game 
 * @return: a String that is the opening description to your game, 
 *          be sure to note the help option 
 *          (i.e. "type help for a list of commands").  
 */

//TODO: Update this to your Intro (copy and paste it here)    
    public static String gameIntro(){
        return "You wake up at the front of an enormous castle. \nYou are an explorer trying to retrieve a lost artifact \nfrom an ancient castle. It is highly-guarded by a large \narmy and various warriors. You must sneak into the castle \nto retrieve the treasure. You are alone and start with \nnothing on your character except for some light armor. \nThe castle is designed like a maze and you must find the \nsafest pathway to the artifact."
                + "\n (Type \"help\" to see a list of commands)";
    }
    
/**
 * getFirstWord method
 * pulls the first word out of any phrase (1 or more words)
 * @param a string that contains the commands from the user
 * @return a string that is only the first word, 
 *         returns a blank string "" if nothing entered, 
 *         do not use print or println
 */
    
    public static String getFirstWord(String input){
        int spaceLocation = input.indexOf(" ");
        if(spaceLocation > 0)
            return input.substring(0,spaceLocation);
        if(input.length() >0)
            return input;
        return "";
    }

/**
 * getRestOfSentence 
 * pulls everything after the first word and the space behind it
 * @param a string that contains the commands from the user
 * @return a string that returns everything after the first word 
 *         and the space behind it, returns a blank string "" if 1 word entry 
 *         or nothing entered. 
 *         Do not use print or println
 */
        
    public static String getRestOfSentence(String input){
        int spaceLocation = input.indexOf(" ");
        if(spaceLocation >= 0)
            return input.substring(spaceLocation+1);
        return "";
    }    

    
/**
 * north method
 * Method to state that you moved north, you will add movement functionality
 * in checkpoint 4
 * @return a string that states you moved North, do not use print or println    
 */

/*
 * TODO: checkpoint 4 Task
 * 
 * Update the "north" method to allow the player to move North only if possible
 * Be sure to both move the player north and state that the player moved North
 * If you cannot move North, then state that you cannot move North
 */

    public static String north(){
        if(currentRoom.getCanGoNorth()){
            row--;
            return "You moved North.";
        }
      return "You cannot move North.";
    }



/**
 * south method
 * Method to state that you moved south, you will add movement functionality
 * in checkpoint 4
 * @return a string that states you moved South, do not use print or println
 */        

/*
 * TODO: checkpoint 4 Task
 * 
 * Update the "south" method to allow the player to move South only if possible
 * Be sure to move the player South and state that the player moved South
 * If you cannot move South, then state that you cannot move South
 */
    public static String south(){
          if(currentRoom.getCanGoSouth()){
            row++;
            return "You moved South.";
        }
      return "You cannot move South.";
    }

/**
 * east method
 * Method to state the you moved East,  you will add movement functionality in 
 * checkpoint 4
 * @return a string that states you moved East, do not use print or println
 */
    
/*
 * TODO: checkpoint 4 Task
 * 
 * Update the "east" method to allow the player to move East only if possible
 * Be sure to both move the player East and state that the player moved East
 * If you cannot move East, then state that you cannot move East
 */
    public static String east(){
          if(currentRoom.getCanGoEast()){
            column++;
            return "You moved East.";
        }
      return "You cannot move East.";
    }

/**
 * west method
 * Method to state the you moved West, you will add movement functionality in 
 * checkpoint 4
 * @return a string that states you moved West, do not use print or println
 */
    
/*
 * TODO: checkpoint 4 Task
 * 
 * Update the "west" method to allow the player to move West only if possible
 * Be sure to move the player West and state that the player moved West
 * If you cannot move West, then state that you cannot move West
 */
    
    public static String west(){
            if(currentRoom.getCanGoWest()){
            column--;
            return "You moved West.";
        }
      return "You cannot move West.";
    }
    
/**
 * take method
 * Method to allow you to take an item, for now you will just state that 
 * "You took the <itemName>." where <itemName> is the actual name of the item.
 * 
 * example return statement:
 * "You took the apple." 
 * 
 * You will actually pick up items in checkpoint 5
 * 
 * @param takes in a String to determine what object was picked up
 * @return a String that states "You took the <itemName>", do not use print or println
 */
    
    public static String take(String itemName){
    if (currentRoom.hasObject(itemName)) {
        InventoryItem item = currentRoom.removeObject(itemName);
        playerInventory.add(item);
        return "You took the " + itemName + ".";
    }
    return "There is no " + itemName + " in the room.";
}
    
/** 
 * drop method
 * Method to allow you to drop an item, for now you will just state that 
 * "You dropped the <itemName>." where <itemName> is the actual name of the item.
 * 
 * example return statement:
 * "You dropped the apple."
 * 
 * You will actually drop items in checkpoint 5
 * @param takes in a string to determine what object was dropped
 * @return a string that states "You dropped the <itemName>", do not use print or println 
 */
    
    public static String drop(String objectName){
    for (InventoryItem item : playerInventory) {
        if (item.getName().equalsIgnoreCase(objectName)) {
            currentRoom.addObject(item);
            playerInventory.remove(item);
            return "You dropped the " + objectName + ".";
        }
    }
    return "You don't have a " + objectName + " to drop.";
}
    
/** 
 * look method
 * Method to allow you to look around the room
 * In checkpoint3, this will change to the room description
 *  @return a string that states "You looked around the room", do not use print or println
 */    
 
/*  
 * TODO: checkpoint 4 task
 * 
 * update the "look" method to return the Name of the Room, 
 * then a new line, and then the room's description instead of its current output.
 */
 
    public static String look() {
    StringBuilder result = new StringBuilder(currentRoom.getName() + "\n" + currentRoom.getDescription());

    String itemNames = currentRoom.getNamesOfObjectsInRoom();
    if (!itemNames.equals("No items are in the room")) {
        result.append("\n").append(itemNames);
    }

    return result.toString();
}
    
/** 
 * inventory method
 * Method to display the items in your inventory, for now state
 * "The current items in your inventory are:"
 * 
 * In checkpoint 5 you will create a String that consists of all of the 
 * items in your inventory
 *  @return the "The current items in your inventory are:", do not use print or println
 */
 
    public static String inventory(){
    if (playerInventory.isEmpty()) {
        return "Your inventory is empty.";
    }
    StringBuilder sb = new StringBuilder("The current items in your inventory are:\n");
    for (InventoryItem item : playerInventory) {
        sb.append("- ").append(item.getName()).append("\n");
    }
    return sb.toString();
}   


    
/**
 * examine method
 * Method that returns the description on an item in your inventory, for now state:
 * "Description of <itemName>" where <itemName> is the itemName
 * 
 * example return statement:
 * "Description of apple"
 * 
 * In checkpoint 5 you will return the description of the object you are examining
 * @param takes in a string to determine what item you want the description of
 * @return a string that is the description of the item, do not use print or println
 */


    public static String examine(String itemName){
    for (InventoryItem item : playerInventory) {
        if (item.getName().equalsIgnoreCase(itemName)) {
            return item.getName() + ": " + item.getDescription();
        }
    }
    return "You do not have that item.";
}    

/**
 * eat method
 * Method that allows you to eat a Food object, for now state:
 * "You ate the <itemName>" where <itemName> is the name of the itemName
 * 
 * example return statement:
 * "You ate the apple."
 * 
 * In checkpoint 5, you will update this method to remove it from your inventory, 
 * but not drop it in the room.  Advanced: this could be useful for a health system
 * 
 * 
 * @param takes in a string to determine what item you want to eat
 * @return a string that states you ate the item, do not use print or println
 */    
 
    public static String eat(String itemName){
    for (InventoryItem item : playerInventory) {
        if (item.getName().equalsIgnoreCase(itemName)) {
            if (item instanceof Food) {
                playerInventory.remove(item);
                return "You ate the " + itemName + ".";
            } else {
                return "You cannot eat the " + itemName + ".";
            }
        }
    }
    return "You do not have that item.";
}        
    

/**  
 * use method
 * Method that allows you to use an item it, for now state:
 * "You used the <itemName>", where <itemName> is the name of the item.
 * 
 * example return statement:
 * "You used the apple."
 * 
 * In checkpoint 5 this will be updated to only allow the player to use a Key
 * in the room where the key can open a door
 * 
 * @param takes in a string to determine what item you want to use
 * @return a string that You used the item, do not use print or println
 */

    public static String use(String itemName){
    for (InventoryItem item : playerInventory) {
        if (item.getName().equalsIgnoreCase(itemName)) {

            if (item instanceof Key) {
                Key key = (Key) item;
                String keyRoomName = key.getNameOfRoomIWorkIn();
                String keyDirection = key.getDirectionToOpen();

                if (currentRoom.getName().equalsIgnoreCase(keyRoomName)) {
                    // Unlock the specified direction
                    String result = currentRoom.unlock(keyDirection.toLowerCase());
                    return result + " using the " + itemName + ".";
                } else {
                    return "You cannot use the " + itemName + " here.";
                }
            }

            // If item is not a Key, but exists in inventory
            return "You cannot use the " + itemName + ".";
        }
    }

    // If item is not in inventory
    return "You do not have that item.";
}    
    
    
/**
 * help method
 * Method that returns all of the commands and what they do
 * 
 * example return output:
 * "Command      Example      Description
 *  take         take apple   used to pick up objects"
 * 
 * @return a String that contains all the command names, an example of use, and a description of what they do.  Be sure to consider readability of the player.  Do not use print or println.
 */
        
    public static String help(){
        return "The following commands are used to play the game\n"
                + "Command    Example      Description\n"
                + "North      North        Allows you to move North\n"
                + "South      south        Allows you to move South\n"
                + "East       east         allows you to move East\n"
                + "West       west         allows you to move West\n"
                + "Look       Look         provides a detailed descriptoin of the room\n"
                + "Take       take key     adds an item in a room to your inventory\n"
                + "Drop       drop key     removes an item from your inventory and leaves it in the room\n"
                + "Inventory  inventory    displays the names of items in your inventory\n"
                + "Examine    examine key  provides a detailed description of the specified item, it must be in your inventory\n"
                + "Eat        eat apple    Allows you to eat an edible item\n"
                + "Use        use key      Allows you to use the item\n"
                + "Help       help         displays the help menu\n"
                + "Quit       quit         player initiated end of game\n";
    }

    
/**
 * quit Method
 * Method that states "You have decided to quit the game"
 * @return a message saying You have decided to quit the game, do not use print or println
 */
    
    public static String quit(){
        return "You have decided to quit the game.";
    }
    
/**
 * invalid method
 * Method called when a player tries a command that is not used in the game
 * @return message "I do not understand", do not use print or println
 */
    
    public static String invalid(){
        return "I do not understand.";
    }
    
/**
 * executeCommand method
 * This method uses the first word to call the appropriate method that you
 * made above.  Basically, this method manages complexity by hosting the 
 * logic to detemine which method should be used.
 * (for example, if the command is north, call the north() method). 
 * @param the String command used to check which method to call
 * @param the String item used for methods that interact with objects 
 * @return a String that is passed back from the appropriate method, 
 *         do not use print or println
 */
        
    public static String executeCommand(String command, String item){
        if(command.equals("north"))
            return north();
        if(command.equals("south"))
            return south();
        if(command.equals("east"))
            return east();
        if(command.equals("west"))
            return west();
        if(command.equals("inventory"))
            return inventory();
        if(command.equals("look"))
            return look();
        if(command.equals("take"))
            return take(item);
        if(command.equals("drop"))
            return drop(item);
        if(command.equals("examine"))
            return examine(item);
        if(command.equals("eat"))
            return eat(item);
        if(command.equals("use"))
            return use(item);
        if(command.equals("help"))
            return help();
        if(command.equals("quit"))
            return quit();
        return invalid();
                
    }
    
/**  
 * updateRoom method
 * Method to update the room you are in (currentRoom)
 * this method uses the row and column values to 
 * update the currentRoom location
 * no parameters or return values
 */
/*
 * TODO: checkpoint 4 Task
 * 
 * make the updateRoom method
 */
    public static void updateRoom(){
        currentRoom = map[row][column];
    }
            
/**
 *     getCurrentRoom method
 *  In order to work with the JFrame, we need a way to get the room
 *  create an accessor method that returns the currentRoom called getCurrentRoom
 *  @return the current room, but sure to update the room first
 */

/* 
 * TODO: checkpoint 4 Task
 * 
 * make the getCurrentRoom method
 */
    
public static Room getCurrentRoom(){
        updateRoom();
        return currentRoom;
    }

    
    //DO NOT TOUCH
    public static void main(String[] args){
        runGame();
    }

public void setUpGame() {

    castleFrontItems.add(new InventoryItem("tattered paper", "Fort Ashveil: treasure awaits for those who dare", 0.5));
    castleFrontItems.add(new Key("silver key", "Can be used to open locked door", "Entrance hall", "east"));

    kitchenItems.add(new Food("bread", "Can be consumed for an increase of health points by 5", 2, 5));
    kitchenItems.add(new Food("chicken leg", "Can be consumed for an increase of health points by 10", 0.5, 10));

    entranceHallItems.add(new InventoryItem("small paper", "Code: 6431", 0.5));

    dimPassageItems.add(new InventoryItem("small rock", "Can be thrown or used in slingshot", 0.5));
    dimPassageItems.add(new InventoryItem("slingshot", "Can be used to fling a small rock", 3));

    armoryItems.add(new InventoryItem("helmet", "Can be worn for a medium increase to health", 5));
    armoryItems.add(new InventoryItem("coat", "Can be worn for a small increase to health", 1));
    armoryItems.add(new InventoryItem("cape", "Can be worn for a small increase to health", 1));
    armoryItems.add(new InventoryItem("heavy suit of armor", "Can be worn for a large increase to health", 8));
    armoryItems.add(new InventoryItem("boots", "Can be worn for a small increase to health", 2));
    armoryItems.add(new InventoryItem("gloves", "Can be worn for a small increase to health", 1));

    sleepingQuartersItems.add(new Food("bottle of potion", "Can be consumed to gain speed and strength", 6, 15));

    throneHallItems.add(new Key("golden key", "Can be used to open locked door", "Open room", "east"));

    artifactRoomItems.add(new InventoryItem("artifact", "The ancient summoning stone", 5));
}     

}