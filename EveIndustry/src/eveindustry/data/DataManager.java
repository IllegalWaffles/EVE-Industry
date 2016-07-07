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
    HashMap<Integer, Item> items;
    
    //The list of blueprint jobs currently loaded
    ObservableList<BlueprintJob> jobs;
    
    /**
     * Creates a new datamanager object.
     * 
     * @param initApp 
     */
    public DataManager(EveIndustryApp initApp) {
    
        app = initApp;
    
        items = new HashMap<>();
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
    public HashMap<Integer, Item> getItems() {
    
        return items;
    
    }
    
    /**
     * Adds an item to the items map.
     * 
     * @param item 
     */
    public void addItem(Item item) {
    
        items.put(item.getID(), item);
    
    }
    
    /**
     * Resets the dataManager, clears all the currently stored data.
     */
    public void reset() {
    
        items.clear();
        jobs.clear();
        
    }
    
    /**
     * Updates all jobs with relevant market data.
     */
    public void updateMarketData() {}
    
    
}
