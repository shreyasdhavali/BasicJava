package com.sand.java.solid;

public class LSubstitutionP {

}
class Bird {
    void fly() {
        System.out.println("Flying");
    }
}

class Penguin extends Bird {
//    @Override violets LSP
//    void fly() {
//        throw new UnsupportedOperationException("Penguins cannot fly");
//    }
}

