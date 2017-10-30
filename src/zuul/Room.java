package zuul;

import java.util.HashMap;

/**
 * Class Room - a room in an adventure game.
 *
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.  
 *
 * A "Room" represents one location in the scenery of the game.  It is 
 * connected to other rooms via exits.  The exits are labelled north, 
 * east, south, west.  For each direction, the room stores a reference
 * to the neighboring room, or null if there is no exit in that direction.
 * 
 * @author  Michael Kolling and David J. Barnes
 * @version 2008.03.30
 */
public class Room 
{
    public String description;
    private HashMap <String, Room> exits;
    private Item item;

    /**
     * Create a room described "description". Initially, it has
     * no exits. "description" is something like "a kitchen" or
     * "an open court yard".
     * @param description The room's description.
     */
    public Room(String description) 
    {
        this.description = description;
        exits = new HashMap<>();
        this.item = null;
    }
    
    public Room(String description, Item item) 
    {
        this(description); // chama o outro contrutor
        this.item = item;
    }
    
    public void setItem(Item item){
        this.item = item;
    }

    void setExits(String direction, Room neighbor) 
    {
        exits.put(direction, neighbor);
    }

    /**
     * @return The description of the room.
     */
    String getDescription()
    {
        return description;
    }
    
    public Room getExit(String direction){
        return exits.get(direction);
    }
    

    public String getExitString()
    {
        String exitString = "Saídas: ";
        for(String exit : exits.keySet()){
            exitString +=" " + exit;
        }
        return exitString;
    }
    
    public String getLongDescription(){
        String itemStr = (item != null) ? "Que contém " + item.getDescription() // if sim recede a descricão do item
                :""; // else recebe uma string vazia
        return "você está " + description + ".\n" +  itemStr + ".\n" + getExitString();
    }
}
