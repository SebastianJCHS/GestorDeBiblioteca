package modelo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Multa {
    private float monto;
    private String fecha;
    private Cliente cliente;
    private String estado; 

    public Multa(float monto, Cliente cliente) {
        this.monto = monto;
        this.fecha = LocalDate.now().format(DateTimeFormatter.ISO_DATE); // Fecha actual
        this.cliente = cliente;
        this.estado = "pendiente";
    }

    public float getMonto() {
        return monto;
    }

    public String getFecha() {
        return fecha;
    }

    public String getEstado() {
        return estado;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void pagarMulta() {
        this.estado = "pagado"; 
    }
}