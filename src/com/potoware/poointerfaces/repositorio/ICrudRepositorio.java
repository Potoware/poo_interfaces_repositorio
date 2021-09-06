package com.potoware.poointerfaces.repositorio;

import com.potoware.excepciones.AccesoDatosException;
import com.potoware.excepciones.EscrituraAccesoDatosException;
import com.potoware.excepciones.LecturaAccesoDatoException;

import java.util.List;

public interface ICrudRepositorio<T> {

    List<T> listar();
    T porId(Integer id) throws AccesoDatosException;
    void crear(T t) throws AccesoDatosException;
    void editar(T t) throws AccesoDatosException;
    void eliminar(Integer integer) throws AccesoDatosException;
}
