package com.company;

public abstract class Heroes {
    String name;
    public Heroes(String name){
        this.name = name;
    }
   // public Heroes(){ }
    Definite currentPlace;
    Definite getPlace(){
        return currentPlace;
    }
    abstract void go(Definite somewhere);
    abstract void look(Space somewhere);
    abstract void turn();
}
