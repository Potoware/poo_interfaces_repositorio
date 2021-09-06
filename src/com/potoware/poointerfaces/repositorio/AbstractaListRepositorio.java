package com.potoware.poointerfaces.repositorio;


import com.potoware.excepciones.EscrituraAccesoDatosException;
import com.potoware.excepciones.LecturaAccesoDatoException;
import com.potoware.excepciones.RegistroDuplicadoAccesoDatosException;
import com.potoware.poointerfaces.modelo.BaseEntity;

import java.util.ArrayList;

import java.util.List;

public abstract class AbstractaListRepositorio<T extends BaseEntity> implements IOrdenablePaginableCrudRepositorio<T>{

    protected List<T> datasource;

    public AbstractaListRepositorio() {
        this.datasource = new ArrayList<>();
    }

    @Override
    public List<T> listar() {
        return datasource;
    }

    @Override
    public T porId(Integer id) throws LecturaAccesoDatoException {
        if(id == null || id<=0){
            throw new LecturaAccesoDatoException("Id Invalido, debe ser mayor que 0");
        }

        T resultado = null;

        for(T cli: datasource){
            if(cli.getId() != null &&cli.getId().equals(id)){
                resultado = cli;
                break;
            }
        }
        if(resultado==null){
            throw new LecturaAccesoDatoException("No existe el registro con el id" +id);
        }
        return resultado;
    }

    @Override
    public void crear(T t) throws EscrituraAccesoDatosException {

        if(t==null){
            throw new EscrituraAccesoDatosException("Error el crear objeto vacio");
        }
        if(this.datasource.contains(t)){
            throw new RegistroDuplicadoAccesoDatosException("Error con el objeto " +t.getId()+
                    "YA existe en el repositorio");
        }
        this.datasource.add(t);
    }


    @Override
    public void eliminar(Integer integer) throws LecturaAccesoDatoException {
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
