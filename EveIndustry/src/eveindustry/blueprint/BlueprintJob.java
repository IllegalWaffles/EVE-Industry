/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eveindustry.blueprint;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Kuba
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
    
    public BlueprintJob()
    {
    
        blueprintName = new SimpleStringProperty(DEFAULT_STRING);
        producedName = new SimpleStringProperty(DEFAULT_STRING);
        costToProduce = new SimpleDoubleProperty(DEFAULT_NUMERICAL);
        producedSellPrice = new SimpleDoubleProperty(DEFAULT_NUMERICAL);
        profitPerRun = new SimpleDoubleProperty(DEFAULT_NUMERICAL);
        profitPerHour = new SimpleDoubleProperty(DEFAULT_NUMERICAL);
        profitPerWeekPerSlot = new SimpleDoubleProperty(DEFAULT_NUMERICAL);
    
    }
    
    public BlueprintJob(String blueprintName, 
                        String producedName, 
                        double costToProduce, 
                        double producedSellPrice,
                        double profitPerRun,
                        double profitPerHour,
                        double profitPerWeekPerSlot)
    {
    
        this.blueprintName.set(blueprintName);
        this.producedName.set(producedName);
        this.costToProduce.set(costToProduce);
        this.producedSellPrice.set(producedSellPrice);
        this.profitPerRun.set(profitPerRun);
        this.profitPerHour.set(profitPerHour);
        this.profitPerWeekPerSlot.set(profitPerWeekPerSlot);
    
    }
    
    //Getters
    public String getBlueprintName(){return blueprintName.get();}
    public String getProducedName(){return producedName.get();}
    public double getCostToProduce(){return costToProduce.get();}
    public double getProducedSellPrice(){return producedSellPrice.get();}
    public double getProfitPerRun(){return profitPerRun.get();}
    public double getProfitPerHour(){return profitPerHour.get();}
    public double getProfitPerWeekPerSlot(){return profitPerWeekPerSlot.get();}
    
    //Setters
    public void setBlueprintName(String s){blueprintName.set(s);}
    public void setProducedName(String s){producedName.set(s);}
    public void setCostToProduce(double d){costToProduce.set(d);}
    public void setProducedSellPrice(double d){producedSellPrice.set(d);}
    public void setProfitPerRun(double d){profitPerRun.set(d);}
    public void setProfitPerHour(double d){profitPerHour.set(d);}
    public void setProfitPerWeekPerSlot(double d){profitPerWeekPerSlot.set(d);}
    
}
