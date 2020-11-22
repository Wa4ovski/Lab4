package com.company;

public abstract class Heroes {
    String name;
    public Heroes(String name){
        this.name = name;
    }
    Definite currentPlace;
    abstract Definite getPlace();
    abstract void go(Definite somewhere);
    abstract void look(Space somewhere);
    abstract void turn();
}
