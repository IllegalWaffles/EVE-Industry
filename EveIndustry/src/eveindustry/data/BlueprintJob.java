package eveindustry.data;

import java.util.ArrayList;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Kuba Gasiorowski/IllegalWaffles
 */
public class BlueprintJob {
    
    public static final double DEFAULT_NUMERICAL = 0.0;
    public static final String DEFAULT_STRING = "?";
    
    StringProperty blueprintName;
    StringProperty producedName;
    DoubleProperty costToProduce;
    DoubleProperty producedSellPrice;
    DoubleProperty profitPerRun;
    DoubleProperty profitPerHour;
    DoubleProperty profitPerWeekPerSlot;
    IntegerProperty numberRuns;
    IntegerProperty jobTime;
    Item itemProduced;
    ArrayList<Item> materials;
    ArrayList<Integer> materialQuantities;
    
    public BlueprintJob() {
    
        blueprintName = new SimpleStringProperty(DEFAULT_STRING);
        producedName = new SimpleStringProperty(DEFAULT_STRING);
        costToProduce = new SimpleDoubleProperty(DEFAULT_NUMERICAL);
        producedSellPrice = new SimpleDoubleProperty(DEFAULT_NUMERICAL);
        profitPerRun = new SimpleDoubleProperty(DEFAULT_NUMERICAL);
        profitPerHour = new SimpleDoubleProperty(DEFAULT_NUMERICAL);
        profitPerWeekPerSlot = new SimpleDoubleProperty(DEFAULT_NUMERICAL);
        numberRuns = new SimpleIntegerProperty((int)DEFAULT_NUMERICAL);
        jobTime = new SimpleIntegerProperty((int)DEFAULT_NUMERICAL);
        
        materials = new ArrayList<>();
        materialQuantities = new ArrayList<>();
        
    }
    
    public BlueprintJob(String blueprintName, 
                        String producedName, 
                        double costToProduce, 
                        double producedSellPrice,
                        double profitPerRun,
                        double profitPerHour,
                        double profitPerWeekPerSlot,
                        int numberRuns,
                        int jobTime){
    
        this.blueprintName.set(blueprintName);
        this.producedName.set(producedName);
        this.costToProduce.set(costToProduce);
        this.producedSellPrice.set(producedSellPrice);
        this.profitPerRun.set(profitPerRun);
        this.profitPerHour.set(profitPerHour);
        this.profitPerWeekPerSlot.set(profitPerWeekPerSlot);
        this.numberRuns.set(numberRuns);
        this.jobTime.set(jobTime);
        
    }
    
    //Getters
    public String getBlueprintName(){return blueprintName.get();}
    public String getProducedName(){return producedName.get();}
    public double getCostToProduce(){return costToProduce.get();}
    public double getProducedSellPrice(){return producedSellPrice.get();}
    public double getProfitPerRun(){return profitPerRun.get();}
    public double getProfitPerHour(){return profitPerHour.get();}
    public double getProfitPerWeekPerSlot(){return profitPerWeekPerSlot.get();}
    public int getNumberRuns(){return numberRuns.get();}
    public int getjobTime(){return jobTime.get();}
    public ArrayList<Item> getMaterialsNeeded(){return materials;}
    public ArrayList<Integer> getMaterialQuantities(){return materialQuantities;}
    public Item getItemProduced(){return itemProduced;}
    
    //Setters
    public void setBlueprintName(String s){blueprintName.set(s);}
    public void setProducedName(String s){producedName.set(s);}
    public void setCostToProduce(double d){costToProduce.set(d);}
    public void setProducedSellPrice(double d){producedSellPrice.set(d);}
    public void setProfitPerRun(double d){profitPerRun.set(d);}
    public void setProfitPerHour(double d){profitPerHour.set(d);}
    public void setProfitPerWeekPerSlot(double d){profitPerWeekPerSlot.set(d);}
    public void setNumberRuns(int i){numberRuns.set(i);}
    public void setJobTime(int i){jobTime.set(i);}
    
    public void setMaterialsNeeded(ArrayList<Item> matsNeeded) {
    
        this.materials = matsNeeded;
    
    }
    
    public void setMaterialQuantities(ArrayList<Integer> materialQuantities) {
        
        this.materialQuantities = materialQuantities;
    
    }
    
    public void setItemProduced(Item itemProduced) {
    
        this.itemProduced = itemProduced;
        setBlueprintName(itemProduced.getName() + " Blueprint");
        setProducedName(itemProduced.getName());
        
    }
    
}
