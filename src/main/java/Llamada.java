public class Llamada {
    private  String tipo;
    private  int duracion;
    private  double tarifa;

    public Llamada(String tipo, int duracion, double tarifa) {
        this.tipo = tipo;
        this.duracion = duracion;
        this.tarifa = tarifa;
    }

    public double calcularCosto() {
        return duracion * tarifa;
    }

    public String getTipo() {
        return tipo;
    }

    public int getDuracion() {
        return duracion;
    }

    public double getTarifa() {
        return tarifa;
    }
}