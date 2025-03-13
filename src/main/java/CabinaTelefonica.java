import java.util.ArrayList;

public class CabinaTelefonica {

    private int numero;
    private ArrayList<Llamada> llamadas;
    public CabinaTelefonica(int numero) {
        this.numero = numero;
        this.llamadas = new ArrayList<Llamada>();
    }

    public void agregarLlamada(Llamada llamada) {
        llamadas.add(llamada);
    }

    public void mostrarInformacion() {
        System.out.println("Cabina #" + numero);
        System.out.println("Número de llamadas: " + llamadas.size());

        int totalMinutos = 0;
        double costoTotal = 0;

        for (int i = 0; i < llamadas.size(); i++) {
            Llamada llamada = llamadas.get(i);
            totalMinutos = totalMinutos + llamada.getDuracion();
            costoTotal = costoTotal + llamada.calcularCosto();
        }

        System.out.println("Total minutos: " + totalMinutos);
        System.out.println("Costo total: $" + costoTotal);

        if (llamadas.size() > 0) {
            System.out.println("\nLista de llamadas:");
            for (int i = 0; i < llamadas.size(); i++) {
                Llamada llamada = llamadas.get(i);
                System.out.println("Tipo: " + llamada.getTipo() +
                        ", Duración: " + llamada.getDuracion() +
                        ", Costo: $" + llamada.calcularCosto());
            }
        }
    }


    public void reiniciar() {
        llamadas.clear();
    }

    public int getNumero() {
        return numero;
    }

    public int getTotalMinutos() {
        int total = 0;
        for (int i = 0; i < llamadas.size(); i++) {
            total = total + llamadas.get(i).getDuracion();
        }
        return total;
    }

    public double getCostoTotal() {
        double total = 0;
        for (int i = 0; i < llamadas.size(); i++) {
            total = total + llamadas.get(i).calcularCosto();
        }
        return total;
    }
}