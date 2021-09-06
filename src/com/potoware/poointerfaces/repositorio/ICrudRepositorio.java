package com.potoware.poointerfaces.repositorio;

import java.util.List;

public interface ICrudRepositorio<T> {

    List<T> listar();
    T porId(Integer id);
    void crear(T cliente);
    void editar(T cliente);
    void eliminar(Integer integer);
}
