import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        double tarifaLocal = 50.0;
        double tarifaLargaDistancia = 350.0;
        double tarifaCelular = 150.0;

        Scanner scanner = new Scanner(System.in);

        ArrayList<CabinaTelefonica> cabinas = new ArrayList<CabinaTelefonica>();

        Random random = new Random();

        int opcion = 0;

        while (opcion != 6) {

            System.out.println("\n=== CONTROL DE GASTOS CABINAS TELEFÓNICAS ===");
            System.out.println("1. Crear cabina");
            System.out.println("2. Registrar llamada");
            System.out.println("3. Ver información de cabina");
            System.out.println("4. Ver consolidado");
            System.out.println("5. Reiniciar cabina");
            System.out.println("6. Salir");
            System.out.print("Ingrese una opción: ");


            opcion = scanner.nextInt();


            if (opcion == 1) {

                System.out.print("Ingrese número de cabina: ");
                int numero = scanner.nextInt();


                boolean existe = false;
                for (int i = 0; i < cabinas.size(); i++) {
                    if (cabinas.get(i).getNumero() == numero) {
                        existe = true;
                        break;
                    }
                }

                if (existe) {
                    System.out.println("Ya existe una cabina con ese número");
                } else {
                    CabinaTelefonica cabina = new CabinaTelefonica(numero);
                    cabinas.add(cabina);
                    System.out.println("Cabina creada exitosamente");
                }
            }
            else if (opcion == 2) {

                if (cabinas.size() == 0) {
                    System.out.println("No hay cabinas disponibles");
                } else {

                    System.out.println("Cabinas disponibles:");
                    for (int i = 0; i < cabinas.size(); i++) {
                        System.out.println("Cabina #" + cabinas.get(i).getNumero());
                    }

                    System.out.print("Ingrese número de cabina: ");
                    int numero = scanner.nextInt();


                    CabinaTelefonica cabina = null;
                    for (int i = 0; i < cabinas.size(); i++) {
                        if (cabinas.get(i).getNumero() == numero) {
                            cabina = cabinas.get(i);
                            break;
                        }
                    }

                    if (cabina == null) {
                        System.out.println("Cabina no encontrada");
                    } else {

                        System.out.println("Tipo de llamada:");
                        System.out.println("1. Local ($" + tarifaLocal + " por minuto)");
                        System.out.println("2. Larga distancia ($" + tarifaLargaDistancia + " por minuto)");
                        System.out.println("3. Celular ($" + tarifaCelular + " por minuto)");
                        System.out.print("Seleccione tipo: ");
                        int tipo = scanner.nextInt();

                        // Generar duración aleatoria entre 1 y 15 minutos
                        int duracion = random.nextInt(15) + 1;
                        System.out.println("Duración: " + duracion + " minutos");


                        Llamada llamada = null;
                        if (tipo == 1) {
                            llamada = new Llamada("Local", duracion, tarifaLocal);
                        } else if (tipo == 2) {
                            llamada = new Llamada("Larga distancia", duracion, tarifaLargaDistancia);
                        } else if (tipo == 3) {
                            llamada = new Llamada("Celular", duracion, tarifaCelular);
                        } else {
                            System.out.println("Tipo inválido");
                            continue;
                        }

                        cabina.agregarLlamada(llamada);
                        System.out.println("Llamada registrada. Costo: $" + llamada.calcularCosto());
                    }
                }
            }
            else if (opcion == 3) {
                if (cabinas.size() == 0) {
                    System.out.println("No hay cabinas disponibles");
                } else {
                    System.out.print("Ingrese número de cabina: ");
                    int numero = scanner.nextInt();

                    CabinaTelefonica cabina = null;
                    for (int i = 0; i < cabinas.size(); i++) {
                        if (cabinas.get(i).getNumero() == numero) {
                            cabina = cabinas.get(i);
                            break;
                        }
                    }

                    if (cabina == null) {
                        System.out.println("Cabina no encontrada");
                    } else {
                        cabina.mostrarInformacion();
                    }
                }
            }
            else if (opcion == 4) {

                if (cabinas.size() == 0) {
                    System.out.println("No hay cabinas disponibles");
                } else {
                    System.out.println("\n=== CONSOLIDADO TOTAL ===");

                    int totalLlamadas = 0;
                    int totalMinutos = 0;
                    double totalCosto = 0;

                    for (int i = 0; i < cabinas.size(); i++) {
                        CabinaTelefonica cabina = cabinas.get(i);
                        System.out.println("Cabina #" + cabina.getNumero() + ": $" + cabina.getCostoTotal());

                        totalMinutos += cabina.getTotalMinutos();
                        totalCosto += cabina.getCostoTotal();
                    }

                    System.out.println("\nTotal minutos: " + totalMinutos);
                    System.out.println("Total costo: $" + totalCosto);
                }
            }
            else if (opcion == 5) {

                if (cabinas.size() == 0) {
                    System.out.println("No hay cabinas disponibles");
                } else {
                    System.out.print("Ingrese número de cabina: ");
                    int numero = scanner.nextInt();

                    CabinaTelefonica cabina = null;
                    for (int i = 0; i < cabinas.size(); i++) {
                        if (cabinas.get(i).getNumero() == numero) {
                            cabina = cabinas.get(i);
                            break;
                        }
                    }
                    if (cabina == null) {
                        System.out.println("Cabina no encontrada");
                    } else {
                        cabina.reiniciar();
                        System.out.println("Cabina reiniciada exitosamente");
                    }
                }
            }
            else if (opcion == 6) {
                System.out.println("¡Gracias por usar el sistema!");
            }
            else {
                System.out.println("Opción inválida");
            }
        }

        scanner.close();
    }
}
