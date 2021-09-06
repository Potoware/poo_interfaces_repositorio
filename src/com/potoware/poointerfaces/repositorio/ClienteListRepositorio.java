package com.potoware.poointerfaces.repositorio;

import com.potoware.poointerfaces.modelo.Cliente;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ClienteListRepositorio implements ICrudRepositorio, IOrdenableRepositorio, PaginableRepositorio{

    private List<Cliente> datasource;

    public ClienteListRepositorio() {
        this.datasource = new ArrayList<>();
    }

    @Override
    public List<Cliente> listar() {
        return null;
    }

    @Override
    public Cliente porId(Integer id) {
        Cliente resultado = null;

        for(Cliente cli: datasource){
            if(cli.getId().equals(id)){
                resultado = cli;
                break;
            }
        }
        return resultado;
    }

    @Override
    public void crear(Cliente cliente) {

    }

    @Override
    public void editar(Cliente cliente) {
        Cliente c = this.porId(cliente.getId());
        c.setNombre(cliente.getNombre());
        c.setApellidos(cliente.getApellidos());
    }

    @Override
    public void eliminar(Integer integer) {
        this.datasource.remove(this.porId(integer));
    }

    //ORDENAR ARRAYLIST
    @Override
    public List<Cliente> listar(String campo, Direccion dir) {

       datasource.sort(new Comparator<Cliente>() {
           @Override
           public int compare(Cliente a, Cliente b) {
               int resultado = 0;
               if(dir == Direccion.ASC){
                   switch (campo){
                       case "id" ->
                               resultado = a.getId().compareTo(b.getId());
                       case "nombre" ->
                               resultado = a.getNombre().compareTo(b.getNombre());
                       case "apellido" ->
                               resultado= a.getApellidos().compareTo(b.getApellidos());
                   }
               }else if (dir == Direccion.DESC){
                   switch (campo){
                       case "id" ->
                               resultado = b.getId().compareTo(a.getId());
                       case "nombre" ->
                               resultado = b.getNombre().compareTo(a.getNombre());
                       case "apellido" ->
                               resultado= b.getApellidos().compareTo(a.getApellidos());
                   }
               }

               return resultado;
           }
       });
        return datasource;
    }

    @Override
    public List<Cliente> listar(int desde, int hasta) {
        return datasource.subList(desde,hasta);
    }
}
