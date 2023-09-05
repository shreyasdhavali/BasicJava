package com.sand.java.designPatterns.structural.composite;

import java.util.ArrayList;
import java.util.List;

public class CompositePattern implements SurpriseBox {

    List<SurpriseBox> surpriseBoxes;

    public CompositePattern() {
        this.surpriseBoxes = new ArrayList<>();
    }

    public void add(SurpriseBox box) {
        this.surpriseBoxes.add(box);
    }

    public void remove(SurpriseBox box) {
        this.surpriseBoxes.remove(box);
    }

    @Override
    public void unwrap() {
        this.surpriseBoxes.forEach(SurpriseBox::unwrap);
    }

    public static void main(String[] args) {
        CompositePattern giftBox = new CompositePattern();
        CompositePattern subGiftBox = new CompositePattern();
        Gift gift = new Gift("Toy Car");
        Gift gift2 = new Gift("Toy plane");
        giftBox.add(gift);
        subGiftBox.add(gift2);
        giftBox.add(subGiftBox);
        giftBox.unwrap();
    }
}
