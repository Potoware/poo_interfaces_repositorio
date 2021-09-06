package com.potoware.poointerfaces.repositorio;

import com.potoware.poointerfaces.modelo.Cliente;

import java.util.List;

public interface PaginableRepositorio<T> {
    List<T> listar(int desde, int hasta);
}
