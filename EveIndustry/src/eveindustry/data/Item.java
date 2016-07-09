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
    private static final double DEFAULT_PRICE = -1;
    
    private String name;
    private int ID;
    private double sellPrice;
    private double buyPrice;
    
    public Item()
    {
        
        name = DEFAULT_NAME;
        ID = DEFAULT_ID;
        sellPrice = DEFAULT_PRICE;
        buyPrice = DEFAULT_PRICE;
        
    }
    
    public Item(int ID, String name) {
    
        this();
        this.ID = ID;
        this.name = name;
        
        
    }
    
    public Item(String name, int ID)
    {
    
        this(ID, name);
    
    }
    
    public Item(Item copy) {
    
        this();
        this.name = copy.name;
        this.ID = copy.ID;
    
    }
    
    public double getSellPrice(){return sellPrice;}
    public double getBuyPrice(){return buyPrice;}
    
    public void setSellPrice(int i){sellPrice = i;}
    public void setBuyPrice(int i){buyPrice = i;}
    
    public String getName(){return name;}
    public int getID(){return ID;}
    
    public void setName(String name){this.name = name;}
    public void setID(int ID){this.ID = ID;}
 
    @Override
    public String toString(){return ID + ", " + name;}
    
}
