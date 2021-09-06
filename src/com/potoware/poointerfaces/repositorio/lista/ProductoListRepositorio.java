package com.potoware.poointerfaces.repositorio.lista;

import com.potoware.excepciones.LecturaAccesoDatoException;
import com.potoware.poointerfaces.modelo.Cliente;
import com.potoware.poointerfaces.modelo.Producto;
import com.potoware.poointerfaces.repositorio.AbstractaListRepositorio;
import com.potoware.poointerfaces.repositorio.Direccion;

import java.util.ArrayList;
import java.util.List;

public class ProductoListRepositorio extends AbstractaListRepositorio<Producto> {
    @Override
    public void editar(Producto producto) throws LecturaAccesoDatoException {
        Producto p = porId(producto.getId());
        p.setDescripcion(producto.getDescripcion());
        p.setPrecio(producto.getPrecio());
    }

    @Override
    public List<Producto> listar(String campo, Direccion dir) {
        List<Producto> listaOrdenada = new ArrayList<>(this.datasource);
        listaOrdenada.sort((a, b) -> {
            int resultado = 0;
            if(dir == Direccion.ASC){
                resultado = this.ordenar(a,b, campo);
            }else if (dir == Direccion.DESC){
                resultado = this.ordenar(b,a, campo);
            }

            return resultado;
        });
        return listaOrdenada;
    }

    private int ordenar(Producto a, Producto b, String campo){
        int resultado =0;
        switch (campo){
            case "id" ->
                    resultado = a.getId().compareTo(b.getId());
            case "descripcion" ->
                    resultado = a.getDescripcion().compareTo(b.getDescripcion());
            case "precio" ->
                    resultado= a.getPrecio().compareTo(b.getPrecio());
        }
        return resultado;

    }

}
