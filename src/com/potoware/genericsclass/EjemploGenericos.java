package com.potoware.genericsclass;

import com.sun.jdi.connect.Connector;

public class EjemploGenericos {
    public static void main(String[] args) {

        System.out.println("======== Caballos");
        Camion camionCaballos = new Camion(5);
        camionCaballos.add(new Animal("Pererino","Caballo"));
        camionCaballos.add(new Animal("Grillo", "Caballo"));
        camionCaballos.add(new Animal("Mateus", "Caballo"));
        camionCaballos.add(new Animal("Topocalma", "Caballo"));
        camionCaballos.add(new Animal("Fonsopior", "Caballo"));

        for(Object o: camionCaballos){
            Animal a = (Animal) o;
            System.out.println(((Animal) o).getNombre()+ " "+((Animal) o).getTipo());
                    }

        System.out.println("======== MAQUINARIA");
        Camion camionMaquinas = new Camion(3);
        camionMaquinas.add(new Maquinaria("Bulldozer"));
        camionMaquinas.add(new Maquinaria("Grua"));
        camionMaquinas.add(new Maquinaria("Escabadora"));

        for(Object o : camionMaquinas){
            Maquinaria a = (Maquinaria) o;
            System.out.println(((Maquinaria) o).getTipo());
        }
        System.out.println("======== Automovil");
        Camion camionAutos = new Camion(3);
        camionAutos.add(new Automovil("Toyoya"));
        camionAutos.add(new Automovil("Mercedes Benz"));
        camionAutos.add(new Automovil("BMW"));

        for(Object o: camionAutos){
            Automovil a = (Automovil) o;
            System.out.println(((Automovil) o).getMarca());
        }
    }
}
