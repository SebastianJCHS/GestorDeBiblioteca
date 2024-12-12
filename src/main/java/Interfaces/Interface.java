/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

public interface Interface {
    public String[] getcabecera();
    public boolean islleno();
    public void aumentar();
    public Object[][] getDatos();
    public void guardarArchivo(String rutaArchivo);
    public void cargarArchivo(String rutaArchivo);
    public void EliminarArchivo(String rutaArchivo);
    public void ActualizarArchivo(String rutaArchivo, int id, String nuevoEstado);
    public void actualizarEstadoMulta(String nombreArchivo, int idCarnet, String nuevoEstadoMulta);
}
