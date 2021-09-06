package com.potoware.poointerfaces.repositorio;

import com.potoware.poointerfaces.modelo.Cliente;

import java.util.ArrayList;
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

    @Override
    public List<Cliente> listar(String campo, Direccion dir) {
        return null;
    }

    @Override
    public List<Cliente> listar(int desde, int hasta) {
        return null;
    }
}
