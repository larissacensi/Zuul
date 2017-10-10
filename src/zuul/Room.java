package zuul;

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
    public Room northExit;
    public Room southExit;
    public Room eastExit;
    public Room westExit;

    /**
     * Create a room described "description". Initially, it has
     * no exits. "description" is something like "a kitchen" or
     * "an open court yard".
     * @param description The room's description.
     */
    public Room(String description) 
    {
        this.description = description;
    }

    /**
     * Define the exits of this room.  Every direction either leads
     * to another room or is null (no exit there).
     * @param north The north exit.
     * @param east The east east.
     * @param south The south exit.
     * @param west The west exit.
     */
    private void setExits(Room north, Room east, Room south, Room west) 
    {
        if(north != null)
            northExit = north;
        if(east != null)
            eastExit = east;
        if(south != null)
            southExit = south;
        if(west != null)
            westExit = west;
    }

    /**
     * @return The description of the room.
     */
    String getDescription()
    {
        return description;
    }
    
    public Room getExit(String direction){
        if(direction.equals("norte")){
            return northExit;
        }else{
            if(direction.equals("leste")){
                return eastExit;
            }else{
                if(direction.equals("sul")){
                    return southExit;
                }else{
                    if(direction.equals("oeste")){
                         return westExit;
                    }
                    else{
                         return null;
                    }
                }
            }
        }
    }
    
    /**
     * retorna uma descrição
     */
    
    public String getExitString()
    {
        String exitString = "Saídas: ";
        if(northExit != null) {
            exitString +="norte ";
        }
        if(eastExit != null) {
            exitString +="leste ";
        }
        if(southExit != null) {
            exitString +="sul ";
        }
        if(westExit != null) {
            exitString +="oeste ";
        }
        return exitString;
    }
}
