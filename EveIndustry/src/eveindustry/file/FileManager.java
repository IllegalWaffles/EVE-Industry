/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eveindustry.file;

import eveindustry.EveIndustryApp;
import eveindustry.data.BlueprintJob;
import eveindustry.data.DataManager;
import eveindustry.data.Item;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * This class will handle all file operations (loading the static blueprint data)
 * 
 * @author Kuba Gasiorowski/IllegalWaffles
 */
public class FileManager {
    
    private static final String ITEM_IDS_PATH = "./data/invtypes.csv";
    private static final String BLUEPRINT_MATS_PATH = "./data/invTypeMaterials.csv";
    private static final String ACTIVITY_TIMES_PATH = "./data/industryActivity.csv";
    
    //Our central application
    EveIndustryApp app;
    DataManager data;
    
    public FileManager(EveIndustryApp initApp)
    {
    
        app = initApp;
        data = initApp.getDataManager();
    
    }
    
    /**
     * Loads all the static data.
     * 
     * @throws FileNotFoundException 
     */
    public void loadAllData() throws FileNotFoundException {
    
        loadItemIDs();
        loadBlueprintData();
    
    }
    
    /**
     * Loads all data associated with blueprints - materials,
     * runs, times etc.
     * 
     * @throws FileNotFoundException 
     */
    public void loadBlueprintData() throws FileNotFoundException {
    
        data.getJobs().clear();
        
        Scanner matsScanner = new Scanner(new File(BLUEPRINT_MATS_PATH));
        
        String parsed[];
        int currentJobItemID, currentItemID;
        BlueprintJob newJob = new BlueprintJob();
        
        //Skip first line
        matsScanner.nextLine();
        
        //Start off with the second line
        parsed = matsScanner.nextLine().split(",");
        
        currentJobItemID = Integer.parseInt(parsed[0]);
        newJob.setItemProduced(data.getItems().get(currentJobItemID));
        
        int i = 1;
        
        while(matsScanner.hasNextLine()) {
            
            System.out.println("Line: " + i++);
            
            parsed = matsScanner.nextLine().split(",");
            currentItemID = Integer.valueOf(parsed[0]);
            
            if(currentJobItemID == currentItemID) {
            //This is a material for the current job
            //Add the information and move on
                
                newJob.getMaterialsNeeded().add(data.getItems().get(Integer.parseInt(parsed[1])));
                newJob.getMaterialQuantities().add(Integer.parseInt(parsed[2]));
                
            }else{
            //New blueprint detected. Store the old one and make a new one
                
                data.getJobs().add(newJob);
            
                //Initialize the new job
                newJob = new BlueprintJob();
                currentJobItemID = currentItemID;
                
                newJob.setItemProduced(data.getItems().get(currentJobItemID));
                
                //Read the other two values
                newJob.getMaterialsNeeded().add(data.getItems().get(Integer.parseInt(parsed[1])));
                newJob.getMaterialQuantities().add(Integer.parseInt(parsed[2]));
                
            }
            
            
        }
        
        matsScanner.close();
        //All materials and quantities loaded. Close our material scanning reader.
        
        
        
        
        
        
        
        
        Scanner runTimeScanner = new Scanner(new File(ACTIVITY_TIMES_PATH));
        
        while(runTimeScanner.hasNextLine())
        {
        
            runTimeScanner.nextLine();
            break;
            
        }
        
        runTimeScanner.close();
        
    }
    
    /**
     * Loads all items we are concerned with.
     * 
     * @throws FileNotFoundException 
     */
    public void loadItemIDs() throws FileNotFoundException {
    
        Scanner sc = new Scanner(new File(ITEM_IDS_PATH));
        
        String[] parsed;
        
        while(sc.hasNextLine())
        {
        
            parsed = sc.nextLine().split(",");
            
            if(parsed.length < 3 || isNumeric(parsed[0]) /*&& (parsed[2].endsWith(" I") || 
                                        parsed[2].endsWith(" II") ||
                                        parsed[2].endsWith(" II Blueprint") ||
                                        parsed[2].endsWith(" I Blueprint"))*/){
             
                Item itemToAdd = new Item(Integer.parseInt(parsed[0]), parsed[2]);
                data.addItem(itemToAdd);
                
                System.out.println("Item loaded: " + itemToAdd);
                
            }
            
        }
    
    }
    
    private boolean isNumeric(String str)
    {
        
        return str.matches("-?\\d+(\\.\\d+)?");  //match a number with optional '-' and decimal.
        
    }
    
}
