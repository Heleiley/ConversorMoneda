package ConversorMoneda;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Historial {

    private static final List<String> historial = new ArrayList<>();

    public static void agregarAlHistorial(String historialItem) {
        String tiempo = LocalDateTime.now().toString();
        historial.add(tiempo + " - " + historialItem);
    }

    public static void mostrarHistorial() {
        if (historial.isEmpty()) {
            System.out.println("\nNo hay conversiones en el historial.");
        } else {
            System.out.println("\n--- Historial de Conversiones ---");
            for (String item : historial) {
                System.out.println(item);
            }
        }
    }
}
