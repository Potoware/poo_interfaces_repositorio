package com.potoware.poointerfaces;

import com.potoware.poointerfaces.modelo.Cliente;
import com.potoware.poointerfaces.modelo.Producto;
import com.potoware.poointerfaces.repositorio.Direccion;
import com.potoware.poointerfaces.repositorio.IOrdenablePaginableCrudRepositorio;
import com.potoware.poointerfaces.repositorio.lista.ClienteListRepositorio;
import com.potoware.poointerfaces.repositorio.lista.ProductoListRepositorio;

import java.util.List;

public class EjemploRepositoriosProducto {
    public static void main(String[] args) {
        IOrdenablePaginableCrudRepositorio<Producto> repo = new ProductoListRepositorio();
        repo.crear(new Producto("Mesa",  50.50));
        repo.crear(new Producto("Silla", 120.00));
        repo.crear(new Producto("Monitor", 400.00));
        repo.crear(new Producto("Mouse", 25.00));
        repo.crear(new Producto("Teclado", 70.00));
        System.out.println("===== LISTAR ======");
        //Listar los datos del arraylist
        List<Producto> productos = repo.listar();
        productos.forEach(c-> System.out.println(c));
        System.out.println("===== PAGINAR ======");
        List<Producto> paginable = repo.listar(1,2);
        paginable.forEach(p-> System.out.println(p));

        System.out.println("===== ORDENAR ======");
        List<Producto> productoOrdenAsc =repo.listar("descripcion", Direccion.DESC);
        productoOrdenAsc.forEach(coa-> System.out.println(coa));

        System.out.println("===== EDITAR ======");
        Producto phActualizar = new Producto("camara", 90.00);
        phActualizar.setId(2);
        repo.editar(phActualizar);
        Producto ph = repo.porId(2);
        System.out.println(ph);

        List<Producto> productoOrdenAsc2 = repo.listar("precio",Direccion.ASC);
        productoOrdenAsc2.forEach(coa-> System.out.println(coa));
        System.out.println("===== ELIMINAR ======");
        repo.eliminar(2);
        repo.listar().forEach(System.out::println);

        System.out.println("===== Total ======");
        System.out.println("Total Registros: " + repo.total());

    }
}
