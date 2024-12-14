/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.gestordebiblioteca2;
import vista.LoginAdminCliente;
import vista.RegistroCliente;
import vista.VentanaRegistroAdmin;
import vista.RegistroMulta;
import vista.VentanaAdminCarnet;
import vista.VentanaAgragarMulta;
import vista.VentanaAgregarLibro;
import vista.VentanaBuscarCarnet;
import vista.VentanaClienteBuscarCarnet;
import vista.VentanaPagarMulta;
import vista.VentanaPrestamoLibro;
import vista.VentanaRegistroCarnet;
import vista.VentanaRegistroLibros;
import vista.VentanaVerificarLibro;
import vista.MenuAdmin;
import vista.MenuCliente;
import vista.VentanaBuscarLibro;
import vista.VentanaBuscarLibroAdmin;
import vista.VentanaVerPrestamos;
import Modelo.Administrador;
import Modelo.ArregloCarnet;
import Modelo.Persona;
import Modelo.Cliente;
import Modelo.ArregloPersona;
import Modelo.ArregloLibro;
import Modelo.ArregloPrestamo;
import Modelo.Biblioteca;
import Modelo.Carnet;
import Modelo.Ejemplar;
import Modelo.Libro;
import Modelo.PrestacionLibro;
import Modelo.ArregloMulta;
import Modelo.Multa;
import controlador.Controladorlogin;
import controlador.ControladorAdmin;
import controlador.ControladorCliente;
import vista.VentanaEliminarLibro;
import vista.VentanaModificarLibro;
import vista.VentanaPagarMulta2;

public class GestordeBiblioteca2 {

    public static void main(String[] args) {
        LoginAdminCliente ventana1 = new LoginAdminCliente();
        VentanaRegistroAdmin ventana2 = new VentanaRegistroAdmin();
        RegistroCliente ventana3 = new RegistroCliente();
        RegistroMulta ventana4 = new RegistroMulta();
        VentanaAdminCarnet ventana5 = new VentanaAdminCarnet();
        VentanaAgragarMulta ventana6 = new VentanaAgragarMulta();
        VentanaAgregarLibro ventana7 = new VentanaAgregarLibro();
        VentanaBuscarCarnet ventana8 = new VentanaBuscarCarnet();
        VentanaClienteBuscarCarnet ventana9 = new VentanaClienteBuscarCarnet();
        VentanaPagarMulta ventana10 = new VentanaPagarMulta();
        VentanaPrestamoLibro ventana11 = new VentanaPrestamoLibro();
        VentanaRegistroCarnet ventana12 = new VentanaRegistroCarnet();
        VentanaRegistroLibros ventana13 = new VentanaRegistroLibros();
        VentanaVerificarLibro ventana14 = new VentanaVerificarLibro();
        MenuAdmin ventana15 = new MenuAdmin();
        MenuCliente ventana16 = new MenuCliente();
        VentanaEliminarLibro ventana17 = new VentanaEliminarLibro();
        VentanaModificarLibro ventana18 = new VentanaModificarLibro();
        VentanaPagarMulta2 ventana19 = new VentanaPagarMulta2();
        VentanaBuscarLibro ventana20 = new VentanaBuscarLibro();
        VentanaBuscarLibroAdmin ventana21 = new VentanaBuscarLibroAdmin();
        VentanaVerPrestamos ventana22 = new VentanaVerPrestamos();
        ArregloPersona persona = new ArregloPersona();
        Administrador administrador = new Administrador();
        ArregloCarnet carnets = new ArregloCarnet();
        ArregloLibro libros = new ArregloLibro();
        ArregloMulta multas = new ArregloMulta();
        ArregloPrestamo prestamos = new ArregloPrestamo();
        Biblioteca biblioteca = new Biblioteca();
        Carnet carnet = new Carnet();
        Cliente cliente = new Cliente();
        Ejemplar ejemplar = new Ejemplar();
        Libro libro = new Libro();
        Multa multa = new Multa();
        PrestacionLibro prestacionLibro = new PrestacionLibro();
        persona.cargarArchivo("Administrador.txt");
        persona.cargarClientesDesdeArchivo("Clientes.txt");
        carnets.cargarArchivo("Clientes.txt");
        multas.cargarArchivo("Multas.txt");
        libros.cargarArchivo("Libros.txt");
        prestamos.cargarPrestamosDesdeArchivo("Prestamos.txt", persona, libros);
        libros.mostrarLibros();
        ControladorAdmin controlador = new ControladorAdmin(ventana1, ventana2, ventana4, ventana5, ventana6, ventana7, ventana8, ventana12, ventana13, ventana14, ventana15, ventana17, ventana18, ventana21, ventana22, persona, administrador, carnets, libros, multas, prestamos, carnet, cliente, libro, multa, prestacionLibro);
        ControladorCliente controlador2 = new ControladorCliente(ventana19,ventana16, ventana3, ventana9, ventana11, ventana10, ventana20, persona, administrador, carnets, libros, multas, prestamos, carnet, cliente, libro, multa, prestacionLibro, ventana1);
        Controladorlogin controlador3 = new Controladorlogin(ventana2, ventana1, ventana3);
        controlador3.iniciar();
    }
}
