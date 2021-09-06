package com.potoware.poointerfaces.repositorio;

import com.potoware.poointerfaces.modelo.Cliente;

import java.util.List;

public interface IOrdenableRepositorio<T> {

    List<T> listar(String campo,Direccion dir);



}
