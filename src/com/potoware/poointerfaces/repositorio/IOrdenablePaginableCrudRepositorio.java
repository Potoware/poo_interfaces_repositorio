package com.potoware.poointerfaces.repositorio;

public interface IOrdenablePaginableCrudRepositorio<T> extends IOrdenableRepositorio<T>, PaginableRepositorio<T>,ICrudRepositorio<T>, IContableRepositorio {

}
