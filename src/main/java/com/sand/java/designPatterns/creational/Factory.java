package com.sand.java.designPatterns.creational;

public class Factory {
    public Plan getPlan(String planType){
        if(planType == null){
            return null;
        }
        if(planType.equalsIgnoreCase("DOMESTICPLAN")) {
            return new DomesticPlan();
        }
        else if(planType.equalsIgnoreCase("COMMERCIALPLAN")){
            return new CommercialPlan();
        }
        return null;
    }
}

abstract class Plan{
    protected double rate;
    abstract void getRate();

    public void calculateBill(int units){
        System.out.println(units*rate);
    }
}

class  DomesticPlan extends Plan{
    //@override
    public void getRate(){
        rate=3.50;
    }
}

class  CommercialPlan extends Plan {
    //@override
    public void getRate() {
        rate = 7.50;
    }
}
