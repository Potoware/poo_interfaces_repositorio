package com.potoware.poointerfaces.repositorio;

import com.potoware.poointerfaces.modelo.Cliente;

import java.util.List;

public interface IOrdenableRepositorio {

    List<Cliente> listar(String campo,Direccion dir);



}
