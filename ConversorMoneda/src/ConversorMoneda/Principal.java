package ConversorMoneda;
import com.google.gson.Gson;
import java.util.Map;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        try {
            String json = ClienteAPI.getRates("USD");

            Gson gson = new Gson();
            ExchangeRatio exchangeRatio = gson.fromJson(json, ExchangeRatio.class);

            Map<String, Double> tasas = exchangeRatio.getConversionRates();

            Scanner scanner = new Scanner(System.in);
            int opcion;

            do {
                System.out.println("\n=== Conversor de Moneda ===");
                System.out.println("1 - Realizar conversión");
                System.out.println("2 - Ver historial de conversiones");
                System.out.println("3 - Salir");
                System.out.print("Elija una opción: ");
                opcion = Integer.parseInt(scanner.nextLine());

                switch (opcion) {
                    case 1:
                        System.out.println("\n--- Realizar Conversión ---");
                        Conversor.mostrarMonedasDisponibles(tasas);

                        System.out.print("\nIngrese moneda de origen (ej: USD): ");
                        String origen = scanner.nextLine().toUpperCase();

                        System.out.print("Ingrese moneda de destino (ej: ARS): ");
                        String destino = scanner.nextLine().toUpperCase();

                        System.out.print("Ingrese cantidad a convertir: ");
                        double cantidad = Double.parseDouble(scanner.nextLine());

                        double resultado = Conversor.convertirMoneda(tasas, origen, destino, cantidad);
                        System.out.printf("\n%.2f %s = %.2f %s\n", cantidad, origen, resultado, destino);

                        // Agregar al historial
                        Historial.agregarAlHistorial(String.format("%.2f %s = %.2f %s", cantidad, origen, resultado, destino));
                        break;

                    case 2:
                        // Mostrar historial
                        Historial.mostrarHistorial();
                        break;

                    case 3:
                        System.out.println("Gracias por usar el conversor de monedas.");
                        break;

                    default:
                        System.out.println("Opción no válida, por favor intente nuevamente.");
                }

            } while (opcion != 3);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}