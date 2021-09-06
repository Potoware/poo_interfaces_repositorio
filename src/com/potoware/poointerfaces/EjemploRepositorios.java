package com.potoware.poointerfaces;

import com.potoware.excepciones.AccesoDatosException;
import com.potoware.excepciones.EscrituraAccesoDatosException;
import com.potoware.excepciones.LecturaAccesoDatoException;
import com.potoware.poointerfaces.modelo.Cliente;
import com.potoware.poointerfaces.repositorio.*;
import com.potoware.poointerfaces.repositorio.lista.ClienteListRepositorio;

import java.util.List;

public class EjemploRepositorios {
    public static void main(String[] args) {
        try {
            IOrdenablePaginableCrudRepositorio<Cliente> repo = new ClienteListRepositorio();
            repo.crear(new Cliente("Juan", "Camacho"));
            repo.crear(new Cliente("Luci", "Martinez"));
            repo.crear(new Cliente("Alejandro", "Potosi"));
            repo.crear(new Cliente("Astrid", "Juliana"));
            repo.crear(new Cliente("Andres", "Alvarado"));
            repo.crear(null);
            System.out.println("===== LISTAR ======");
            //Listar los datos del arraylist
            List<Cliente> clientes = repo.listar();
            clientes.forEach(c -> System.out.println(c));
            System.out.println("===== PAGINAR ======");
            List<Cliente> paginable = repo.listar(1, 2);
            paginable.forEach(p -> System.out.println(p));

            System.out.println("===== ORDENAR ======");
            List<Cliente> clienteOrdenAsc = repo.listar("apellido", Direccion.DESC);
            clienteOrdenAsc.forEach(coa -> System.out.println(coa));

            System.out.println("===== EDITAR ======");
            Cliente phActualizar = new Cliente("Photo", "Both");
            phActualizar.setId(2);
            repo.editar(phActualizar);
            Cliente ph = repo.porId(2);
            System.out.println(ph);

            List<Cliente> clientesOrdenAsc2 = repo.listar("apellido", Direccion.ASC);
            clientesOrdenAsc2.forEach(coa -> System.out.println(coa));
            System.out.println("===== ELIMINAR ======");
            repo.eliminar(10);
            repo.listar().forEach(System.out::println);

            System.out.println("===== Total ======");
            System.out.println("Total Registros: " + repo.total());
        } catch (EscrituraAccesoDatosException eae) {
            System.out.println("eae.getMessage() = " + eae.getMessage());
            eae.printStackTrace();

        } catch (
                LecturaAccesoDatoException e) {
            System.out.println("Lectura: e.getMessage() = " + e.getMessage());
            e.printStackTrace(System.out);
        } catch (
                AccesoDatosException ae) {
            System.out.println("Generica: ae.getMessage() = " + ae.getMessage());
            ae.printStackTrace(System.out);
        }

    }
}
