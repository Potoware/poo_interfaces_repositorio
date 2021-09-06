package com.potoware.poointerfaces.repositorio;

import java.util.List;

public interface ICrudRepositorio<T> {

    List<T> listar();
    T porId(Integer id);
    void crear(T t);
    void editar(T t);
    void eliminar(Integer integer);
}
