package com.potoware.poointerfaces.modelo;

public class ClientePremium extends Cliente implements Comparable{

    public ClientePremium(String nombre, String apellidos) {
        super(nombre, apellidos);
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
