package com.company;

import java.util.Objects;

public class Definite extends Places{

        public String name;
        public Definite(String name){
            this.name = name;
        }
        public Definite(){};

        @Override
        public String toString() {
            return name;
        }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Definite definite = (Definite) o;
        return Objects.equals(name, definite.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}

