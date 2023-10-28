import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TicketManager {
    private List<Ticket> tickets = new ArrayList<>();

    public void agregarTicket(Ticket ticket) {
        tickets.add(ticket);
    }

    public void mostrarCantidadTicketsPorPrioridad() {
        int alta = 0;
        int media = 0;
        int baja = 0;

        for (Ticket ticket : tickets) {
            if (ticket.getTipo().equals("Alta")) {
                alta++;
            } else if (ticket.getTipo().equals("Media")) {
                media++;
            } else if (ticket.getTipo().equals("Baja")) {
                baja++;
            }
        }

        System.out.println("Cantidad de Tickets por Prioridad:");
        System.out.println("Alta: " + alta);
        System.out.println("Media: " + media);
        System.out.println("Baja: " + baja);
    }

    public void validarMayorIngreso() {
        double maxIngreso = 0;
        String prioridad = "";

        for (Ticket ticket : tickets) {
            double ingreso = ticket.calcularIngreso();
            if (ingreso > maxIngreso) {
                maxIngreso = ingreso;
                prioridad = ticket.getTipo();
            }
        }

        System.out.println("Prioridad de Tickets que genera mayor ingreso: " + prioridad);
    }

    public void guardarTicketsEnCSV(String filename) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(filename));

            for (Ticket ticket : tickets) {
                writer.write(ticket.getTipo() + "," + ticket.calcularIngreso());
                writer.newLine();
            }

            writer.close();
            System.out.println("Tickets guardados en archivo CSV: " + filename);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void cargarTicketsDesdeCSV(String filename) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            String line;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    String tipo = parts[0];
                    double ingreso = Double.parseDouble(parts[1]);

                    if (tipo.equals("Alta")) {
                        TicketAlta ticket = new TicketAlta();
                        // Establecer los valores necesarios para el ticket de prioridad alta
                        // ticket.set...
                        agregarTicket(ticket);
                    } else if (tipo.equals("Media")) {
                        TicketMedia ticket = new TicketMedia();
                        // Establecer los valores necesarios para el ticket de prioridad media
                        // ticket.set...
                        agregarTicket(ticket);
                    } else if (tipo.equals("Baja")) {
                        TicketBaja ticket = new TicketBaja();
                        // Establecer los valores necesarios para el ticket de prioridad baja
                        // ticket.set...
                        agregarTicket(ticket);
                    }
                }
            }

            reader.close();
            System.out.println("Tickets cargados desde archivo CSV: " + filename);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        TicketManager ticketManager = new TicketManager();

        // Agregar ejemplos de tickets
        TicketAlta altaTicket = new TicketAlta();
        // Configurar valores para el ticket de prioridad alta
        ticketManager.agregarTicket(altaTicket);

        TicketMedia mediaTicket = new TicketMedia();
        // Configurar valores para el ticket de prioridad media
        ticketManager.agregarTicket(mediaTicket);

        TicketBaja bajaTicket = new TicketBaja();
        // Configurar valores para el ticket de prioridad baja
        ticketManager.agregarTicket(bajaTicket);

        // Mostrar cantidad de tickets por prioridad
        ticketManager.mostrarCantidadTicketsPorPrioridad();

        // Validar prioridad de tickets que genera mayor ingreso
        ticketManager.validarMayorIngreso();

        // Guardar los tickets en un archivo CSV
        ticketManager.guardarTicketsEnCSV("tickets.csv");

        // Cargar los tickets desde un archivo CSV
        ticketManager.cargarTicketsDesdeCSV("tickets.csv");
    }
}
