package eveindustry.data;

import eveindustry.EveIndustryApp;
import java.util.ArrayList;
import java.util.HashMap;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * This class will handle all data operations (loading the changing market data)
 * 
 * @author Kuba Gasiorowski/IllegalWaffles
 */
public class DataManager {
    
    //The central application
    EveIndustryApp app;
    
    //Corresponds to the list of items and their IDs
    HashMap<Integer, Item> itemsByID;
    HashMap<String, Item> itemsByName;
    ArrayList<Item> items;
    
    //The list of blueprint jobs currently loaded
    ObservableList<BlueprintJob> jobs;
    
    /**
     * Creates a new datamanager object.
     * 
     * @param initApp 
     */
    public DataManager(EveIndustryApp initApp) {
    
        app = initApp;
    
        itemsByID = new HashMap<>();
        itemsByName = new HashMap<>();
        items = new ArrayList<>();
        jobs = FXCollections.observableArrayList();
        
    }
    
    /**
     * Gets a list of current blueprint jobs
     * 
     * @return 
     */
    public ObservableList<BlueprintJob> getJobs() {
        
        return jobs;
    
    }
    
    /**
     * Adds a new blueprint job to the list of current blueprint jobs.
     * 
     * @param newJob 
     */
    public void addJob(BlueprintJob newJob) {
    
        jobs.add(newJob);
    
    }
    
    /**
     * Returns a list of all stored items.
     * 
     * @return 
     */
    public ArrayList<Item> getItems() {
    
        return items;
    
    }
    
    /**
     * Adds an item to the items map.
     * 
     * @param item 
     */
    public void addItem(Item item) {
            
        if(itemsByID.containsKey(item.getID())) {
            
            System.out.println("Warning! ID number " + item.getID() + " is about to be overwritten! New item name: " + item.getName());
            return;
            
        }
            
        items.add(item);
        itemsByID.put(item.getID(), item);
        itemsByName.put(item.getName(), item);
    
    }
    
    /**
     * Finds an item by ID number.
     * Returns null if that ID doesn't exist.
     * 
     * @param itemID
     * @return 
     */
    public Item getItem(int itemID) {
    
        return itemsByID.get(itemID);
    
    }
    
    /**
     * Finds an item by Name.
     * Return null if that name doesn't exist.
     * 
     * @param itemName
     * @return 
     */
    public Item getItem(String itemName) {
    
        return itemsByName.get(itemName);
    
    }
    
    /**
     * Resets the dataManager, clears all the currently stored data.
     */
    public void reset() {
    
        items.clear();
        itemsByID.clear();
        itemsByName.clear();
        jobs.clear();
        
    }
    
    /**
     * Updates all jobs with relevant market data.
     */
    public void updateMarketData() {}
    
    
}
