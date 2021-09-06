package com.potoware.generics;

import com.potoware.poointerfaces.modelo.Cliente;
import com.potoware.poointerfaces.modelo.ClientePremium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EjemploGenerics {
    public static void main(String[] args) {

        List<Cliente> clientes= new ArrayList<>();
        clientes.add(new Cliente("Andres", "Guzman"));

        Cliente andres = (Cliente) clientes.iterator().next();
        Cliente[] clientesArreglo = {new Cliente("Andres", "Guzman"),
                new Cliente("Andres", "Guzman")};

        Integer[] enterosArreglo = {12,2,3};

        List<Cliente> clientes2 = fromArrayToList(clientesArreglo);
        List<Integer> enteros2 = fromArrayToList(enterosArreglo);

        clientes2.forEach(System.out::println);
        enteros2.forEach(System.out::println);

        List<String> nombres = fromArrayToList(new String[]{"Andres", "Pepe","Luci", "Jhon"}, enterosArreglo);
        nombres.forEach(System.out::println);

        List<ClientePremium> clientePremiumList = fromArrayToList(new ClientePremium[]{new ClientePremium("Nora","Ver")});


        imprimirClientes(clientes);
        imprimirClientes(clientes2);
        imprimirClientes(clientePremiumList);


        System.out.println("Mamimo de 1,9,4 es: " + maximo(1,9,4));
        System.out.println("Mamimo de 7,74.2,499 es: " + maximo(7.74,4.99,4.78));
        System.out.println("Mamimo de Naranja, Mnazana, Pera es: " + maximo("Manzana","Naranja","Pera"));
    }
//Parametros genericos en objetos
    public static <T extends Number> List<T> fromArrayToList(T[] c){
        return Arrays.asList(c);
    }

    public static <T extends Cliente & Comparable> List<T> fromArrayToList(T[] c){
        return Arrays.asList(c);
    }

    public static <T,G> List<T> fromArrayToList(T[] c, G[] g){
        for(G gIterator:g){
            System.out.println(gIterator);
        }
        return Arrays.asList(c);
    }

    public static <T> List<T> fromArrayToList(T[] c){
        return Arrays.asList(c);
    }

    public static void imprimirClientes(List<? extends Cliente> clientes){
        clientes.forEach(System.out::println);
    }

    public static <T extends Comparable<T>> T maximo(T a, T b, T c){
        T max =a;
        if(b.compareTo(max)>0){
            max = b;
        }
        if(c.compareTo(max) >0){
            max =c;
        }
        return max;
    }
}
