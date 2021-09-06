package com.potoware.poointerfaces.repositorio;

import com.potoware.poointerfaces.modelo.Cliente;

import java.util.List;

public interface ICrudRepositorio<T> {

    List<T> listar();
    Cliente porId(Integer id);
    void crear(T cliente);
    void editar(T cliente);
    void eliminar(Integer integer);
}
