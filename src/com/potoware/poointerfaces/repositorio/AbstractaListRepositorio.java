package com.potoware.poointerfaces.repositorio;


import java.util.ArrayList;

import java.util.List;

public abstract class AbstractaListRepositorio<T> implements IOrdenablePaginableCrudRepositorio<T>{

    protected List<T> datasource;

    public AbstractaListRepositorio() {
        this.datasource = new ArrayList<>();
    }

    @Override
    public List<T> listar() {
        return datasource;
    }

    /*@Override
    public Cliente porId(Integer id) {
        Cliente resultado = null;

        for(Cliente cli: datasource){
            if(cli.getId() != null &&cli.getId().equals(id)){
                resultado = cli;
                break;
            }
        }
        return resultado;
    }*/

    @Override
    public void crear(T t) {
        this.datasource.add(t);
    }


    @Override
    public void eliminar(Integer integer) {
        this.datasource.remove(this.porId(integer));
    }

    @Override
    public List<T> listar(int desde, int hasta) {
        return datasource.subList(desde,hasta);
    }


    @Override
    public int total() {
        return this.datasource.size();
    }
}
