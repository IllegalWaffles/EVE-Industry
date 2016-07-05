/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eveindustry;

import eveindustry.blueprint.BlueprintJob;
import eveindustry.controller.Controller;
import eveindustry.data.DataManager;
import eveindustry.file.FileManager;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Screen;
import javafx.stage.Stage;

/**
 *
 * @author Kuba Gasiorowski
 */
public class EveIndustryApp extends Application{

    public static final String APP_TITLE = "Komo's Calculator";
    public static final String RELOAD_BUTTON_TEXT = "Reload Market Data";
    public static final String EXIT_BUTTON_TEXT = "Exit Button";
    
    Scene myScene;
    VBox mainPane;
    
    Button loadMarketData;
    Button exitButton;
    
    HBox buttonBox;
    
    TableView blueprintTable;
    TableColumn<BlueprintJob, String> blueprintNameColumn;
    TableColumn<BlueprintJob, String> producedNameColumn;
    TableColumn<BlueprintJob, Double> costToProduceColumn;
    TableColumn<BlueprintJob, Double> producedSellPriceColumn;
    TableColumn<BlueprintJob, Double> profitPerRunColumn;
    TableColumn<BlueprintJob, Double> profitPerHourColumn;
    TableColumn<BlueprintJob, Double> profitPerWeekPerSlotColumn;
    
    DataManager data;
    FileManager file;
    
    @Override
    public void start(Stage mainStage)
    {
    
        data = new DataManager(this);
        file = new FileManager(this);
        
        setupComponents(mainStage);
        setupHandlers();
        
        mainStage.show();
        
    }
    
    private void setupComponents(Stage mainStage){
            
        loadMarketData = new Button(RELOAD_BUTTON_TEXT);
        exitButton = new Button(EXIT_BUTTON_TEXT);
        
        buttonBox = new HBox(10);
        buttonBox.getChildren().addAll(loadMarketData, exitButton);
        buttonBox.setPadding(new Insets(10, 0, 10, 10));
        
        blueprintTable = new TableView();
        HBox.setHgrow(blueprintTable, Priority.SOMETIMES);
        VBox.setVgrow(blueprintTable, Priority.SOMETIMES);
        
        blueprintNameColumn = new TableColumn<>("Blueprint Name");
        producedNameColumn = new TableColumn<>("Product Name");
        costToProduceColumn = new TableColumn<>("Total Cost");
        producedSellPriceColumn = new TableColumn<>("Sell Price");
        profitPerRunColumn = new TableColumn<>("Profit Per Run");
        profitPerHourColumn = new TableColumn<>("Profit Per Hour");
        profitPerWeekPerSlotColumn = new TableColumn<>("Profit Per Week Per Slot");
        
        blueprintNameColumn.setCellValueFactory(new PropertyValueFactory<BlueprintJob, String>("blueprintName"));
        producedNameColumn.setCellValueFactory(new PropertyValueFactory<BlueprintJob, String>("producedName"));
        costToProduceColumn.setCellValueFactory(new PropertyValueFactory<BlueprintJob, Double>("costToProduce"));
        producedSellPriceColumn.setCellValueFactory(new PropertyValueFactory<BlueprintJob, Double>("produceSellPrice"));
        profitPerRunColumn.setCellValueFactory(new PropertyValueFactory<BlueprintJob, Double>("profitPerRun"));
        profitPerHourColumn.setCellValueFactory(new PropertyValueFactory<BlueprintJob, Double>("profitPerHour"));
        profitPerWeekPerSlotColumn.setCellValueFactory(new PropertyValueFactory<BlueprintJob, Double>("profitPerWeekPerSlot"));
        
        blueprintNameColumn.prefWidthProperty().bind(blueprintTable.widthProperty().divide(7));
        producedNameColumn.prefWidthProperty().bind(blueprintTable.widthProperty().divide(7));
        costToProduceColumn.prefWidthProperty().bind(blueprintTable.widthProperty().divide(7));
        producedSellPriceColumn.prefWidthProperty().bind(blueprintTable.widthProperty().divide(7));
        profitPerRunColumn.prefWidthProperty().bind(blueprintTable.widthProperty().divide(7));
        profitPerHourColumn.prefWidthProperty().bind(blueprintTable.widthProperty().divide(7));
        profitPerWeekPerSlotColumn.prefWidthProperty().bind(blueprintTable.widthProperty().divide(7));
        
        blueprintTable.getColumns().setAll(blueprintNameColumn,
                              producedNameColumn,
                              costToProduceColumn,
                              producedSellPriceColumn,
                              profitPerRunColumn,
                              profitPerHourColumn,
                              profitPerWeekPerSlotColumn);
        
        blueprintTable.getItems().add(new BlueprintJob());
        
        mainPane = new VBox();
        mainPane.getChildren().addAll(buttonBox, blueprintTable);
        
        myScene = new Scene(mainPane);
        
        mainStage.setScene(myScene);
        mainStage.setTitle(APP_TITLE);
        mainStage.setWidth(Screen.getPrimary().getBounds().getWidth()*.95);
        mainStage.setHeight(Screen.getPrimary().getBounds().getHeight()*.95);
    
    }
    
    private void setupHandlers(){
    
        Controller handler = new Controller(this);
        
        exitButton.setOnAction(e -> {
            
            handler.handleExit();
            
        });
        
        loadMarketData.setOnAction(e -> {
        
            handler.handleLoadMarketData();
        
        });
        
        
    
    }
    
    public void reloadWorkspace(){
    
        
    
    }
    
    private void enableButtons(){
    
        exitButton.setDisable(false);
        loadMarketData.setDisable(false);
    
    }
    
    private void disableButtons(){
    
        exitButton.setDisable(true);
        loadMarketData.setDisable(true);
    
    }
    
    public FileManager getFileManager(){return file;}
    public DataManager getDataManager(){return data;}
    
    public static void main(String[] args) {
        
        launch(args);
        
    }
    
}
