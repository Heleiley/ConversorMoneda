package ConversorMoneda;

import java.util.Map;

public class Conversor {

    public static void mostrarMonedasDisponibles(Map<String, Double> tasas) {
        System.out.println("Monedas disponibles para conversión:");
        String[] codigos = {"ARS", "BOB", "BRL", "CLP", "COP", "USD"};
        for (String codigo : codigos) {
            if (tasas.containsKey(codigo)) {
                System.out.println(codigo + ": " + tasas.get(codigo));
            }
        }
    }

    public static double convertirMoneda(Map<String, Double> tasas, String monedaOrigen, String monedaDestino, double cantidad) {
        if (!tasas.containsKey(monedaOrigen) || !tasas.containsKey(monedaDestino)) {
            throw new IllegalArgumentException("Código de moneda no válido.");
        }

        double tasaOrigen = tasas.get(monedaOrigen);
        double tasaDestino = tasas.get(monedaDestino);

        return cantidad / tasaOrigen * tasaDestino;
    }
}
