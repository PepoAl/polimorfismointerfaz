public class TicketAlta implements Ticket {
    private int totalHoras;
    private int diasLunesViernes;
    private int diasFinDeSemana;

    // Constructor y métodos getter y setter

    @Override
    public double calcularIngreso() {
        double ingreso = totalHoras * 8;
        ingreso += (diasLunesViernes * 0.05 + diasFinDeSemana * 0.20) * 8;
        return ingreso;
    }

    @Override
    public String getTipo() {
        return "Alta";
    }
}