package com.potoware.poointerfaces.repositorio;

import com.potoware.poointerfaces.modelo.Cliente;

import java.util.ArrayList;
import java.util.List;

public class ClienteListRepositorio extends AbstractaListRepositorio<Cliente>{


    @Override
    public void editar(Cliente cliente) {
        Cliente c = this.porId(cliente.getId());
        c.setNombre(cliente.getNombre());
        c.setApellidos(cliente.getApellidos());
    }

    //ORDENAR ARRAYLIST
    @Override
    public List<Cliente> listar(String campo, Direccion dir) {
        List<Cliente> listaOrdenada = new ArrayList<>(this.datasource);
       listaOrdenada.sort((a, b) -> {
           int resultado = 0;
           if(dir == Direccion.ASC){
               resultado = this.ordenar(a,b, campo);
           }else if (dir == Direccion.DESC){
               resultado = this.ordenar(b,a, campo);
           }

           return resultado;
       });
        return listaOrdenada;
    }

    private int ordenar(Cliente a, Cliente b, String campo){
        int resultado =0;
        switch (campo){
            case "id" ->
                    resultado = a.getId().compareTo(b.getId());
            case "nombre" ->
                    resultado = a.getNombre().compareTo(b.getNombre());
            case "apellido" ->
                    resultado= a.getApellidos().compareTo(b.getApellidos());
        }
        return resultado;

    }

}
