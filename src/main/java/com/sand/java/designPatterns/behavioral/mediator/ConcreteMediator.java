package com.sand.java.designPatterns.behavioral.mediator;

class ConcreteMediator implements Mediator {
    private Colleague colleagueA;
    private Colleague colleagueB;

    public void setColleagueA(Colleague colleagueA) {
        this.colleagueA = colleagueA;
    }

    public void setColleagueB(Colleague colleagueB) {
        this.colleagueB = colleagueB;
    }

    public void send(String message, Colleague colleague) {
        if (colleague == colleagueA) {
            colleagueB.receive(message);
        } else {
            colleagueA.receive(message);
        }
    }
}
