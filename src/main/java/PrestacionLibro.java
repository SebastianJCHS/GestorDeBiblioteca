import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class PrestacionLibro {
    private String fechaPrestamo;
    private String fechaDevolucion;
    private Cliente cliente; 
    private Libro libro;
    private Multa multa;

    public PrestacionLibro(String fechaPrestamo, String fechaDevolucion, Cliente cliente, Libro libro) {
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucion = fechaDevolucion;
        this.cliente = cliente;
        this.libro = libro;
        this.multa = null; 
        cliente.agregarPrestamo(this); 
    }

    public Cliente getCliente() {
        return cliente;
    }

    public boolean estaPendiente() {
        try {
            LocalDate fechaDevol = LocalDate.parse(fechaDevolucion, DateTimeFormatter.ISO_DATE);
            LocalDate fechaActual = LocalDate.now();
            return fechaActual.isAfter(fechaDevol); 
        } catch (Exception e) {
            return false;
        }
    }

    public void generarMulta() {
        if (estaPendiente() && multa == null) {
            float montoMulta = calcularMontoMulta();
            this.multa = new Multa(montoMulta, cliente); 
        }
    }

    private float calcularMontoMulta() {
        LocalDate fechaDevol = LocalDate.parse(fechaDevolucion, DateTimeFormatter.ISO_DATE);
        LocalDate fechaActual = LocalDate.now();
        long diasRetraso = fechaActual.toEpochDay() - fechaDevol.toEpochDay();
        return diasRetraso * 10.0f; 
    }

    public Multa getMulta() {
        return multa;
    }
}
