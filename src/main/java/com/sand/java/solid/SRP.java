package com.sand.java.solid;

class SRP {
    private String name;

    public SRP(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public void saveToDatabase() { violation of SRP
//        // Save customer data to database
//    }
}

