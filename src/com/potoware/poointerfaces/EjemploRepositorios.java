package com.potoware.poointerfaces;

import com.potoware.poointerfaces.modelo.Cliente;
import com.potoware.poointerfaces.repositorio.*;

import java.util.List;

public class EjemploRepositorios {
    public static void main(String[] args) {
        IOrdenablePaginableCrudRepositorio repo = new ClienteListRepositorio();
        repo.crear(new Cliente("Juan",  "Camacho"));
        repo.crear(new Cliente("Luci", "Martinez"));
        repo.crear(new Cliente("Alejandro", "Potosi"));
        repo.crear(new Cliente("Astrid", "Juliana"));
        repo.crear(new Cliente("Andres", "Alvarado"));
        System.out.println("===== LISTAR ======");
        //Listar los datos del arraylist
        List<Cliente> clientes = repo.listar();
        clientes.forEach(c-> System.out.println(c));
        System.out.println("===== PAGINAR ======");
        List<Cliente> paginable = repo.listar(1,2);
        paginable.forEach(p-> System.out.println(p));

        System.out.println("===== ORDENAR ======");
        List<Cliente> clienteOrdenAsc =repo.listar("apellido", Direccion.DESC);
        clienteOrdenAsc.forEach(coa-> System.out.println(coa));

        System.out.println("===== EDITAR ======");
        Cliente phActualizar = new Cliente("Photo", "Both");
        phActualizar.setId(2);
        repo.editar(phActualizar);
        Cliente ph = repo.porId(2);
        System.out.println(ph);

        List<Cliente> clientesOrdenAsc2 = repo.listar("apellido",Direccion.ASC);
        clientesOrdenAsc2.forEach(coa-> System.out.println(coa));
        System.out.println("===== ELIMINAR ======");
        repo.eliminar(2);
        repo.listar().forEach(System.out::println);

        System.out.println("===== Total ======");
        System.out.println("Total Registros: " + repo.total());

    }
}
