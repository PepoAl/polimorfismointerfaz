public class TicketBaja implements Ticket {
    private int totalHoras;

    // Constructor y métodos getter y setter

    @Override
    public double calcularIngreso() {
        return totalHoras * 10;
    }

    @Override
    public String getTipo() {
        return "Baja";
    }
}