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
        ArregloPersona persona = new ArregloPersona();
        Administrador administrador = new Administrador();
        ArregloCarnet carnets = new ArregloCarnet();
        ArregloLibro libros = new ArregloLibro(50);
        ArregloMulta multas = new ArregloMulta(50);
        ArregloPrestamo prestamos = new ArregloPrestamo();
        Biblioteca biblioteca = new Biblioteca();
        Carnet carnet = new Carnet();
        Cliente cliente = new Cliente();
        Libro libro = new Libro();
        Multa multa = new Multa();
        PrestacionLibro prestacionLibro = new PrestacionLibro();
        ControladorAdmin controlador = new ControladorAdmin(ventana1, ventana2, ventana4, ventana5, ventana6, ventana7, ventana8, ventana12, ventana13, ventana14, ventana15, persona, administrador, carnets, libros, multas, prestamos, carnet, cliente, libro, multa, prestacionLibro);
        ControladorCliente controlador2 = new ControladorCliente(ventana16, ventana3, ventana9, ventana11, ventana10, persona, administrador, carnets, libros, multas, prestamos, carnet, cliente, libro, multa, prestacionLibro, ventana1);
        Controladorlogin controlador3 = new Controladorlogin(ventana2, ventana1, ventana3);
        controlador3.iniciar();
    }
}
