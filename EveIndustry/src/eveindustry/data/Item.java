package eveindustry.data;

/**
 * Represents an item, basically a wrapper 
 * for an int and a String
 * 
 * @author Kuba Gasiorowski/IllegalWaffles
 */
public class Item {
    
    private static final String DEFAULT_NAME = "";
    private static final int DEFAULT_ID = -1;
    
    private String name;
    private int ID;
    
    public Item()
    {
        
        name = DEFAULT_NAME;
        ID = DEFAULT_ID;
    
    }
    
    public Item(int ID, String name) {
    
        this.ID = ID;
        this.name = name;
    
    }
    
    public Item(String name, int ID)
    {
    
        this.name = name;
        this.ID = ID;
    
    }
    
    public String getName(){return name;}
    public double getID(){return ID;}
    
    public void setName(String name){this.name = name;}
    public void setID(int ID){this.ID = ID;}
    
}
