package com.company;

public class Troll extends Heroes implements Hider{
    public Troll(String name, Information.Game game){
       super(name);
       game.IncrementHiders();
    }

   // public Definite currentPlace = new Definite();

    @Override
    public void go(Definite somewhere) {
        System.out.println(name+" went to "+somewhere);
        currentPlace = somewhere;
    }

    @Override
    public void turn() {
        System.out.println(name+" turned around ");
    }

    @Override
    public void look(Space somewhere) {
        System.out.println(name+" looked at "+somewhere);
    }

    @Override
    public void hide(Definite somewhere) {
        System.out.println(name+" is hiding "+somewhere);
        currentPlace = somewhere;
    }
    public void giggle(){
        System.out.println(name+"is giggling quietly");
    }
    public void worry() {
        System.out.println(name+" is thinking that he choosed bad place");
    }

    @Override
    public Definite getPlace() {
        return currentPlace;
    }

}
