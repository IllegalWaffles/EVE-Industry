package eveindustry.controller;

import eveindustry.EveIndustryApp;

/**
 *
 * @author Kuba Gasiorowski/IllegalWaffles
 */
public class Controller {
    
    //The application which has this controller
    EveIndustryApp app;

    public Controller(EveIndustryApp initApp) {
        
        app = initApp;
        
    }
    
    public void handleLoadMarketData() {
    
        
    
    }
    
    public void handleExit() {
    
        app.getMainStage().close();
    
    }
    
}
