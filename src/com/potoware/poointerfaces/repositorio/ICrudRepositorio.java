package com.potoware.poointerfaces.repositorio;

import com.potoware.poointerfaces.modelo.Cliente;

import java.util.List;

public interface ICrudRepositorio {

    List<Cliente> listar();
    Cliente porId(Integer id);
    void crear(Cliente cliente);
    void editar(Cliente cliente);
    void eliminar(Integer integer);
}
