package com.potoware.genericsclass;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Camion <T>implements Iterable<T>{

    private List<T> objetos;
    private int max;

    public Camion(int max) {
        this.max = max;
        this.objetos = new ArrayList<>();
    }

    public void add(T object){
        if(this.objetos.size() <= max){
        this.objetos.add(object);
        }else{
            throw new RuntimeException("No hay mas espacio");
        }
    }

    @Override
    public Iterator<T> iterator() {
        return objetos.iterator();
    }
}
