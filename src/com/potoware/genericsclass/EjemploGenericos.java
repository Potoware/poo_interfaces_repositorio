package com.potoware.genericsclass;

import com.sun.jdi.connect.Connector;

public class EjemploGenericos {
    public static void main(String[] args) {

        System.out.println("======== Caballos");
        Camion<Animal> camionCaballos = new Camion<>(5);
        camionCaballos.add(new Animal("Pererino","Caballo"));
        camionCaballos.add(new Animal("Grillo", "Caballo"));
        camionCaballos.add(new Animal("Mateus", "Caballo"));
        camionCaballos.add(new Animal("Topocalma", "Caballo"));
        camionCaballos.add(new Animal("Fonsopior", "Caballo"));

        imprimirCamion(camionCaballos);


        System.out.println("======== MAQUINARIA");
        Camion<Maquinaria> camionMaquinas = new Camion<>(3);
        camionMaquinas.add(new Maquinaria("Bulldozer"));
        camionMaquinas.add(new Maquinaria("Grua"));
        camionMaquinas.add(new Maquinaria("Escabadora"));
        imprimirCamion(camionMaquinas);

        System.out.println("======== Automovil");
        Camion<Automovil> camionAutos = new Camion<>(3);
        camionAutos.add(new Automovil("Toyoya"));
        camionAutos.add(new Automovil("Mercedes Benz"));
        camionAutos.add(new Automovil("BMW"));
        imprimirCamion(camionAutos);

    }
    public static <T> void imprimirCamion(Camion<T> camion){
        for(T a: camion){
            if (a instanceof Animal) {
                System.out.println(((Animal)a).getNombre() + " " + ((Animal)a).getTipo());
            }
            else if(a instanceof Maquinaria){
                System.out.println(((Maquinaria)a).getTipo());
            }
            else if(a instanceof Automovil){
                System.out.println(((Automovil)a).getMarca());
            }
        }
    }
}
