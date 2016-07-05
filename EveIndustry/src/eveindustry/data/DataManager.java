package eveindustry.data;

import eveindustry.EveIndustryApp;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * This class will handle all data operations (loading the changing market data)
 * 
 * @author Kuba Gasiorowski/IllegalWaffles
 */
public class DataManager {
    
    //The central application
    EveIndustryApp app;
    
    //Corresponds to the list of items and their IDs
    ArrayList<Item> items;
    
    //The list of blueprint jobs currently loaded
    ObservableList<BlueprintJob> jobs;
    
    public DataManager(EveIndustryApp initApp) {
    
        app = initApp;
    
        items = new ArrayList<>();
        jobs = FXCollections.observableArrayList();
        
    }
    
    public ObservableList<BlueprintJob> getJobs() {
        
        return jobs;
    
    }
    
    public void addJob(BlueprintJob newJob) {
    
        jobs.add(newJob);
    
    }
    
    public ArrayList<Item> getItems() {
    
        return items;
    
    }
    
    public void addItem(Item item) {
    
        items.add(item);
    
    }
    
    public void reset() {
    
        items.clear();
        jobs.clear();
        
    }
    
}
