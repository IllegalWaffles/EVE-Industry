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
    private static final String ACTIVITY_TIMES_PATH = "./industryActivity.csv";
    
    //Our central application
    EveIndustryApp app;
    DataManager data;
    
    public FileManager(EveIndustryApp initApp)
    {
    
        app = initApp;
        data = initApp.getDataManager();
    
    }
    
    public void loadAllData() throws FileNotFoundException {
    
        loadItemIDs();
        loadBlueprintData();
    
    }
    
    public void loadBlueprintData() throws FileNotFoundException {
    
        Scanner matsScanner = new Scanner(new File(BLUEPRINT_MATS_PATH));
        
        String parsed[];
        int currentItemID = -1;
        BlueprintJob newJob;
        
        while(matsScanner.hasNextLine()) {
        
            parsed = matsScanner.nextLine().split(",");
        
            
            
        }
        
        matsScanner.close();
        
        Scanner runTimeScanner = new Scanner(new File(ACTIVITY_TIMES_PATH));
        
        while(runTimeScanner.hasNextLine())
        {
        
            runTimeScanner.nextLine();
        
        }
        
        runTimeScanner.close();
        
    }
    
    public void loadItemIDs() throws FileNotFoundException {
    
        Scanner sc = new Scanner(new File(ITEM_IDS_PATH));
        
        String[] parsed;
        
        //int i = 1;
        
        while(sc.hasNextLine())
        {
        
            parsed = sc.nextLine().split(",");
            
            //System.out.println("Line number: " + i++);
            
            if(isNumeric(parsed[0]) && (parsed[2].endsWith(" I") || 
                                        parsed[2].endsWith(" II") ||
                                        parsed[2].endsWith(" II Blueprint") ||
                                        parsed[2].endsWith(" I Blueprint"))){
             
                parsed[2] = parsed[2].trim();
                data.addItem(new Item(Integer.parseInt(parsed[0]), parsed[2]));
                
            }
            
        }
    
    }
    
    private boolean isNumeric(String str)
    {
        return str.matches("-?\\d+(\\.\\d+)?");  //match a number with optional '-' and decimal.
    }
    
}
