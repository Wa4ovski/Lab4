package com.company;

public class Information {
    static public class Weather {
        private boolean kind;
        public Weather(boolean kind){
            SetWeather(kind);
        }
        public void SetWeather(boolean kind){
            this.kind = kind;
        }
        public boolean GetWeather(){
            return kind;
        }
        public void WhatIsTheWeather() throws BadWeatherException{
            if(GetWeather())
                System.out.println("The weather is good. We cat play now.");
            else
                throw new BadWeatherException("The weather is bad. We cat't play now.");
        }
    }
    public class Game {
        private int HidersCount, SearchersCount;
        public Game(){
            HidersCount = 0;
            SearchersCount = 0;
        }
        public void IncrementHiders(){
            HidersCount++;
        }
        public void DecrementHiders(){
            HidersCount--;
        }
        public int GetHidersCount(){
            return HidersCount;
        }
        public void IncrementSearchers(){
            SearchersCount++;
        }
        public int GetSearchersCount(){
            return SearchersCount;
        }
    }
}
