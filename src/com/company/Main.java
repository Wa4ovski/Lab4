package com.company;

public class Main {

    public static void main(String[] args) {
	Sniff sniff = new Sniff("Sniff");
	Troll troll = new Troll("Mumintroll");
	sniff.go(new Definite("corner"));
	sniff.coverTheFace();
	sniff.count();
	sniff.turn();
	sniff.search(Places.Indeterminate.USUAL, troll);
	sniff.search(Places.Indeterminate.UNUSUAL, troll);
	troll.hide(new Definite("table"));
	troll.worry();
	troll.look(new Definite("cylinder"));
	troll.hide(new Definite("cylinder"));
	sniff.search(new Definite("cylinder"), troll);
	/*Definite place = new Definite("cylinder");
	troll.look(place);
	troll.hide(place);
	sniff.search(place, troll);*/
	}

}
