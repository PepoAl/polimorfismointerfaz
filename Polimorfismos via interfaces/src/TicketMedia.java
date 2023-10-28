public class TicketMedia implements Ticket {
    private int totalHoras;
    private double comisionEmpleado;

    // Constructor y métodos getter y setter

    @Override
    public double calcularIngreso() {
        return totalHoras * 10 + (totalHoras * comisionEmpleado);
    }

    @Override
    public String getTipo() {
        return "Media";
    }
}
