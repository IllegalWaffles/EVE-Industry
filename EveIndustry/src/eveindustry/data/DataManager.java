/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eveindustry.data;

import eveindustry.EveIndustryApp;
import java.util.HashMap;

/**
 *
 * This class will handle all data operations (loading the changing market data)
 * 
 * Should utilize hashmaps considering the large table size, and need for
 * quick lookup.
 * 
 * @author Kuba Gasiorowski
 */
public class DataManager {
    
    //The central application
    EveIndustryApp app;
    
    //Corresponds to the list of items and their ID's
    HashMap<String, Integer> itemIdMap;
    
    public DataManager(EveIndustryApp initApp)
    {
    
        app = initApp;
    
    }
    
    public void reloadData()
    {
    
        
    
    }
    
}
