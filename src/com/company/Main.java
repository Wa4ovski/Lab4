package com.company;
import java.io.*;

import java.io.FileReader;
import java.util.Scanner;

public class Main {
	public static int StrToInt(String S) throws IncorrectInputException{
		for(int i = 0; i < S.length(); ++i){
			if('0' > S.charAt(i) || S.charAt(i) > '9'){
				throw new IncorrectInputException("Incorrect input: unexpected symbols!");
			}
		}
		return Integer.parseInt(S);
	}
    public static void main(String[] args) throws IOException {

		Information Inf = new Information();
    	Information.Weather weather = new Information.Weather(true);
    	try{
			weather.WhatIsTheWeather();
		}
    	catch (BadWeatherException e){
    		System.out.println(e.getMessage());
    		return;
		}
    	Information.Game HideAndSeek = Inf.new Game();

    	Sniff sniff = new Sniff("Sniff", HideAndSeek);
		Troll troll = new Troll("Mumintroll", HideAndSeek);
		sniff.go(new Definite("corner"));
		sniff.coverTheFace();
		sniff.count();

		class HideGroup extends Heroes implements Hider{
			public HideGroup(String name){
				super(name);
				HideAndSeek.IncrementHiders();
			}
			@Override
			public void hide(Definite somewhere) {
				currentPlace = somewhere;
			}

			@Override
			void go(Definite somewhere) { }
			@Override
			void look(Space somewhere) { }
			@Override
			void turn() { }
		}


		int n;
		try
		{
//			File myFile =new File("c:\\fileWith11Line.txt");
//			FileReader fileReader = new FileReader(myFile);

			FileReader reader = new FileReader("C:\\Java\\Lab3\\.idea\\Input");
			LineNumberReader lineNumberReader = new LineNumberReader(reader);
			String StrN = lineNumberReader.readLine();
			n = StrToInt(StrN);
		}
		catch (IncorrectInputException e){
			System.out.println("Incorrect input: n must be a positive integer!");
			System.out.println("n will be automatically initialized like 5");
			n = 5;
		}
		catch(FileNotFoundException e){
			System.out.println("File is not found!");
			System.out.println("n will be automatically initialized like 5");
			n = 5;
		}

		HideGroup[] Hiders = new HideGroup[n];

		for(int i = 0; i < n; ++i){
			Hiders[i] = new HideGroup( "hider".concat(String.valueOf(i+1)));
			Hiders[i].hide(new Definite("place".concat(String.valueOf(i+1))));
		}

		sniff.turn();
		sniff.search(Places.Indeterminate.USUAL, troll);
		sniff.search(Places.Indeterminate.UNUSUAL, troll);
		troll.hide(new Definite("table"));
		troll.worry();
		troll.look(new Definite("cylinder"));
		troll.hide(new Definite("cylinder"));

		for(int i = 0; i < n; ++i){
			String place = "place".concat(String.valueOf(i+1));
			sniff.search(new Definite(place), Hiders[i], HideAndSeek);
			troll.giggle();
		}

		class SearchGroup extends Heroes implements Searcher{
			public SearchGroup(String name){
				super(name);
				HideAndSeek.IncrementSearchers();
			}

			@Override
			public void search(Definite somewhere, Heroes somebody) {
				go(somewhere);
				look(somewhere);
				if(getPlace().equals(somebody.getPlace())){
					System.out.println(name+" has found the "+somebody.name);
				}
			}

			public void search(Heroes somebody){
				System.out.println(name+" is searching "+somebody.name);
			}

			@Override
			public void coverTheFace() { }
			@Override
			public void count() { }
			@Override
			void go(Definite somewhere) { }
			@Override
			void look(Space somewhere) { }
			@Override
			void turn() { }
		}

		SearchGroup[] Searchers = new SearchGroup[n];
		for(int i = 0; i < n; ++i){
			Searchers[i] = new SearchGroup( "hider".concat(String.valueOf(i+1)));
			Searchers[i].search(troll);
		}

	}

}
