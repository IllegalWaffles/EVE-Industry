package eveindustry.data;

import eveindustry.EveIndustryApp;
import java.util.ArrayList;
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
    ArrayList<Item> itemList;
    
    //The list of blueprint jobs currently loaded
    ObservableList<BlueprintJob> items;
    
    public DataManager(EveIndustryApp initApp)
    {
    
        app = initApp;
    
    }
    
    public ObservableList<BlueprintJob> getItems(){return items;}
    
    public void reset()
    {
    
        items.clear();
    
    }
    
}
