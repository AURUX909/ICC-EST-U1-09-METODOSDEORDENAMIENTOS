import java.util.ArrayList;
import java.util.List;

public class Metodos {
    public Metodos() {}

    private String arrayToString(int[] arr) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
            if (i < arr.length - 1) sb.append(", ");
        }
        return String.format("%-30s", sb.toString());
    }

    // Método de ordenamiento por Burbuja
    public int[] sortByBubble(int[] arreglo) {
        int tamanio = arreglo.length;
        List<String> pasos = new ArrayList<>();
        
        for (int i = 0; i < tamanio - 1; i++) {
            for (int j = 0; j < tamanio - 1 - i; j++) {
                pasos.add(String.format("%s valor a: %-2d valor b: %d", arrayToString(arreglo), arreglo[j], arreglo[j + 1]));
                if (arreglo[j] > arreglo[j + 1]) {
                    int aux = arreglo[j];
                    arreglo[j] = arreglo[j + 1];
                    arreglo[j + 1] = aux;
                    pasos.add(String.format("%s (intercambio)", arrayToString(arreglo)));
                }
            }
        }
        
        System.out.println("Método Burbuja:");
        for (String paso : pasos) {
            System.out.println(paso);
        }
        return arreglo;
    }

    // Método de ordenamiento por Selección
    public int[] selectionSort(int[] arreglo, boolean ascendente) {
        int tamanio = arreglo.length;
        List<String> pasos = new ArrayList<>();
        
        for (int i = 0; i < tamanio - 1; i++) {
            int indice = i;
            for (int j = i + 1; j < tamanio; j++) {
                pasos.add(String.format("%s pos menor=%d pos j=%d", arrayToString(arreglo), indice, j));
                if (ascendente ? arreglo[j] < arreglo[indice] : arreglo[j] > arreglo[indice]) {
                    indice = j;
                }
            }
            if (indice != i) {
                int aux = arreglo[indice];
                arreglo[indice] = arreglo[i];
                arreglo[i] = aux;
                pasos.add(String.format("%s (intercambio)", arrayToString(arreglo)));
            }
        }
        
        System.out.println("Método Selección:");
        for (String paso : pasos) {
            System.out.println(paso);
        }
        return arreglo;
    }

    // Método de ordenamiento por Inserción
    public int[] insertionSort(int[] arreglo) {
        int n = arreglo.length;
        List<String> pasos = new ArrayList<>();
        
        for (int i = 1; i < n; i++) {
            int valorActual = arreglo[i];
            int j = i - 1;
            
            pasos.add(String.format("%s valor actual: %d", arrayToString(arreglo), valorActual));
            
            while (j >= 0 && arreglo[j] > valorActual) {
                pasos.add(String.format("%s comparando con: %d", arrayToString(arreglo), arreglo[j]));
                arreglo[j + 1] = arreglo[j];
                j--;
                pasos.add(String.format("%s (desplazamiento)", arrayToString(arreglo)));
            }
            arreglo[j + 1] = valorActual;
            pasos.add(String.format("%s (inserción)", arrayToString(arreglo)));
        }
        
        System.out.println("Método Inserción:");
        for (String paso : pasos) {
            System.out.println(paso);
        }
        return arreglo;
    }

    // Método Burbuja con Ajuste
    public int[] sortByBubbleAjuste(int[] arreglo) {
        int tamanio = arreglo.length;
        boolean swapped;
        List<String> pasos = new ArrayList<>();
        
        for (int i = 0; i < tamanio - 1; i++) {
            swapped = false;
            for (int j = 0; j < tamanio - 1 - i; j++) {
                pasos.add(String.format("%s valor a: %-2d valor b: %d", arrayToString(arreglo), arreglo[j], arreglo[j + 1]));
                if (arreglo[j] > arreglo[j + 1]) {
                    int aux = arreglo[j];
                    arreglo[j] = arreglo[j + 1];
                    arreglo[j + 1] = aux;
                    swapped = true;
                    pasos.add(String.format("%s (intercambio)", arrayToString(arreglo)));
                }
            }
            if (!swapped) {
                pasos.add("Arreglo ordenado antes de tiempo");
                break;
            }
        }
        
        System.out.println("Método Burbuja con Ajuste:");
        for (String paso : pasos) {
            System.out.println(paso);
        }
        return arreglo;
    }

    // Método para imprimir el arreglo
    public void printArreglo(int[] arreglo) {
        System.out.println(arrayToString(arreglo));
    }
}