package Modelo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Multa {
    private float monto;
    private String fecha;
    private Cliente cliente;
    private String estado; 

    public Multa(float monto, Cliente cliente, String estado) {
        this.monto = monto;
        this.fecha = LocalDate.now().format(DateTimeFormatter.ISO_DATE); // Fecha actual
        this.cliente = cliente;
        this.estado = estado;
    }

    public Multa() {
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

    @Override
    public String toString() {
        return "Multa{" + "monto=" + monto + ", fecha=" + fecha + ", cliente=" + cliente + ", estado=" + estado + '}';
    }
    
}
