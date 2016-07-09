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
    private static final String BLUEPRINT_LIST_PATH = "./data/industryActivityTest";
    
    private static final String[] NAMES_TO_IGNORE;
    static{
    
        NAMES_TO_IGNORE = loadIgnoreStrings();
    
    }
    
    
    //Our central application
    EveIndustryApp app;
    DataManager data;
    
    private static String[] loadIgnoreStrings() {
    
        try{
        
            Scanner sc = new Scanner(new File("./data/ignore.txt"));
            
            ArrayList<String> ignoreList = new ArrayList<>();
            
            while(sc.hasNextLine())
                ignoreList.add(sc.nextLine().trim());
            
            sc.close();
            
            return (String[])ignoreList.toArray(new String[ignoreList.size()]);
            
        }
        catch(FileNotFoundException e)
        {
        
            System.out.println("ignore.txt not found");
            return new String[0];
            
        }
        
    }
    
    public FileManager(EveIndustryApp initApp) {
    
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
     * Loads all items we are concerned with.
     * 
     * @throws FileNotFoundException 
     */
    public void loadItemIDs() throws FileNotFoundException {
    
        Scanner sc = new Scanner(new File(ITEM_IDS_PATH));
        
        String[] parsed;
        String line;
        
        while(sc.hasNextLine())
        {
        
            line = sc.nextLine();
            parsed = line.split(",");
            
            if(parsed.length >= 3 && isNumeric(parsed[0]) && isNumeric(parsed[1]) && !isNumeric(parsed[2])){
             
                Item itemToAdd = new Item(Integer.parseInt(parsed[0]), parsed[2]);
                data.addItem(itemToAdd);
                
                //System.out.println("Item loaded: " + itemToAdd);
                
            }
            
        }
    
    }
    
    /**
     * Loads all data associated with blueprints - materials,
     * runs, times etc.
     * 
     * @throws FileNotFoundException 
     */
    public void loadBlueprintData() throws FileNotFoundException {
    
        /*
        
        FILE NOTES:
        industryActivity holds the ID of every BLUEPRINT.
        industryActivity holds the TIME of every JOB.
        invTypes holds the IDs and NAMEs of every item.
        invTypeMaterials holds the materials required for a specific ITEM.
        invTypeMaterials holds the quantities for these materials.
        
        Our algorithm: 
        1. Create a reference list of items and IDs, so we can look an ID or item name up.
        2. Read a blueprint ID from industryActivity.
        3. Get the NAME of this blueprint.
        4. Remove the "Blueprint" from the end of the NAME.
        5. Get the ID of the resulting Item NAME.
        6. Iterate through invTypeMaterials until this ID is reached.
        7. Iterate through invTypeMaterials until the currentID is no longer the same as the ID of Item we are looking up.
        8. Add the blueprint job to the joblist.
        9. Back to step 2 until industryActivity is completely read through.
        
        */
        
        
        data.getJobs().clear();
        
        Scanner matsScanner = new Scanner(new File(BLUEPRINT_MATS_PATH));
        Scanner bpListScanner = new Scanner(new File(BLUEPRINT_LIST_PATH));
        
        String[] parsed;
        
        matsScanner.nextLine();
        bpListScanner.nextLine();
        
        Item item;
        
        int counter = 0;
        int manufacturingTime;
        
        //We are assuming the file has at least one line.
        do {
        
            //Parse input
            parsed = bpListScanner.nextLine().split(",");
            
            if(Integer.valueOf(parsed[1]) != 1) //We only care about manufacturing for now
                continue;
            //Gets the item for the ID scanned in
            item = data.getItem(Integer.valueOf(parsed[0]));
            
            //Depending on if the blueprint is found the items list, OR if it's to be ignored
            if(item == null || isIgnoredItem(item.getName())) {
                
                /*System.out.println("Skipped ID " + Integer.valueOf(parsed[0]));*/
            
            }else{
                
                //Here is code to scan each blueprint's data
                System.out.print(++counter + ". Found blueprint: " + item.getName() + " with ID: " + item.getID());
                String itemName = item.getName().substring(0,item.getName().length()-10);
                
                Item material;
                Item itemProduced = data.getItem(itemName);
                int itemProducedID = itemProduced.getID();
                
                System.out.println(" Item ID: " + itemProducedID);
                boolean itemFound = false;
                BlueprintJob newJob = new BlueprintJob();
                
                while(matsScanner.hasNextLine()) {
                
                    String[] parsedMats = matsScanner.nextLine().split(",");
                    if(Integer.valueOf(parsedMats[0]) == itemProducedID) {
                        
                        material = new Item(data.getItem(Integer.valueOf(parsedMats[1])));
                        
                        System.out.println("Found material: " + material + " of quantity " + Integer.valueOf(parsedMats[2]));
                        
                        newJob.getMaterialsNeeded().add(material);
                        newJob.getMaterialQuantities().add(Integer.valueOf(parsedMats[2]));
                        
                        itemFound = true;
                        
                    }else
                        if(itemFound){
                         
                            data.getJobs().add(newJob);
                            //System.out.println("End of materials list reached, added new job");
                            break;
                            
                        }
                    
                }
                
            }
                
        } while(bpListScanner.hasNextLine());
        
        bpListScanner.close();
        matsScanner.close();
        //All materials and quantities loaded. Close our material scanning reader.
        
    }
    
    private boolean isIgnoredItem(String s) {
    
        for(String ignoreString : NAMES_TO_IGNORE) {
        
            if(s.contains(ignoreString))
                return true;
        
        }
    
        return false;
        
    }
    
    /**
     * Returns true if the string is empty or alphanumeric
     * 
     * @param str
     * @return 
     */
    private boolean isNumeric(String str){
        
        return str.matches("-?\\d+(\\.\\d+)?");  //match a number with optional '-' and decimal.
        
    }
    
}
