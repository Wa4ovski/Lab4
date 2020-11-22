package com.company;

public class Sniff extends Heroes implements Searcher{
    public Sniff(String name){
        super(name);
    }

   // public Definite currentPlace = new Definite();

    @Override
    public Definite getPlace() {
        return currentPlace;
    }

    @Override
    public void go(Definite somewhere) {
        System.out.println(name+" went to "+somewhere);
        currentPlace = somewhere;
    }

    @Override
    public void look(Space somewhere) {
        System.out.println(name+" looked at "+somewhere);
    }

    @Override
    public void turn() {
        System.out.println(name+" turned around ");
    }

    @Override
    public void search(Definite somewhere, Heroes somebody) {
        go(somewhere);
        look(somewhere);
        if(getPlace().equals(somebody.getPlace())){
            System.out.println(name+" has found the "+somebody.name+". Game over!");
            System.exit(0);
        }
    }
    public void search(Places.Indeterminate somewhere, Heroes somebody) {
        System.out.println(name+" is searching "+somebody.name+" in "+somewhere+" places");
    }

    @Override
    public void coverTheFace(){
        System.out.println(name+" covered his face");
    }

    @Override
    public void count() {
        System.out.println(name+" began counting");
        for (int i = 1; i <= 10; ++i) {
            System.out.println(i + "...");
            //Thread.sleep(300);
        }
        System.out.println(name+" finished counting");
    }
}
