/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eveindustry;

import eveindustry.data.MarketData;
import eveindustry.file.FileManager;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.stage.Screen;
import javafx.stage.Stage;

/**
 *
 * @author Kuba Gasiorowski
 */
public class EveIndustryApp extends Application{

    Scene myScene;
    VBox mainPane;
    
    TableView bluePrintTable;
    
    MarketData data;
    FileManager file;
    
    @Override
    public void start(Stage mainStage)
    {
    
        data = new MarketData(this);
        
            
        
        mainPane = new VBox();
        myScene = new Scene(mainPane);
        
        mainStage.setScene(myScene);
        mainStage.setTitle("Komo's Market Calculator");
        mainStage.setWidth(Screen.getPrimary().getBounds().getWidth()*.95);
        mainStage.setHeight(Screen.getPrimary().getBounds().getHeight()*.95);
        mainStage.show();
    
    }
    
    private void reload()
    {
    
        
    
    }
    
    public static void main(String[] args) {
        
        launch(args);
        
    }
    
}
