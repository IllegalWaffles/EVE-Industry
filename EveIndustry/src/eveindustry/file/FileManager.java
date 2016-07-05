/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eveindustry.file;

import eveindustry.EveIndustryApp;

/**
 *
 * This class will handle all file operations (loading the static blueprint data)
 * 
 * @author Kuba Gasiorowski
 */
public class FileManager {
    
    //Our central application
    EveIndustryApp app;
    
    public FileManager(EveIndustryApp initApp)
    {
    
        app = initApp;
    
    }
    
    public void loadAllData(){}
    
    public void loadBlueprintData(){}
    
    public void loadItemIDs(){}
    
}
