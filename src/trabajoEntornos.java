
//@autor Laura Altava
import java.util.Scanner;

/**
 *  //Este programa nos saca los primos//
 */
public class trabajoEntornos {
    /**
     *  //aqui empiezan los datos de entrada y salida//
     */
    //Este programa nos saca los primos//
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduce el número para la criba de Erastótenes:");
        int numero = teclado.nextInt();
        int listaNumeros[] = new int[numero];
        System.out.println("\nVector inicial hasta :" + numero);
        imprimeTodos(listaNumeros);
        listaNumeros = generarPrimos(numero);
        System.out.println("\nVector de primos hasta:" + numero);
        imprime(listaNumeros);
    }

    /**
     *  //Imprime todos este//
     */
    private static void imprimeTodos(int[] vector) {
        for (int i = 0; i < vector.length; i++) {
            if (i % 10 == 0) System.out.println();
            System.out.print(i + 1 + "\t");
        }
    }


    /**
     *  //solo imprime los primos//
     */
    private static void imprime(int[] vector) {
        for (int i = 0; i < vector.length; i++) {
            if (i % 10 == 0) System.out.println();
            System.out.print(vector[i] + "\t");
        }
    }

    // Generar números primos de 1 a max
    public static int[] generarPrimos(int max) {
        int i, j;
        if (max >= 2) {
            // Declaraciones
            int dim = max + 1; // Tamaño del array
            boolean[] esPrimo = new boolean[dim];
            // Inicializar el array
            for (i = 0; i < dim; i++)
                esPrimo[i] = true;
            // Eliminar el 0 y el 1, que no son primos
            esPrimo[0] = esPrimo[1] = false;
            // Criba
            seleccionPrimos(dim, esPrimo);
            // ¿Cuántos primos hay?
            int cuenta = cuantosHay(dim, esPrimo);
            // Rellenar el vector de números primos
            int[] primos = getPrimos(dim, esPrimo, cuenta);
            return primos;
        } else { // max < 2
            return new int[0];
            // Vector vacío
        }
    }

    private static int cuantosHay(int dim, boolean[] esPrimo) {
        int i;
        int cuenta = 0;
        for (i = 0; i < dim; i++) {
            if (esPrimo[i])
                cuenta++;
        }
        return cuenta;
    }

    private static int[] getPrimos(int dim, boolean[] esPrimo, int cuenta) {
        int j;
        int i;
        int[] primos = new int[cuenta];
        for (i = 0, j = 0; i < dim; i++) {
            if (esPrimo[i])
                primos[j++] = i;
        }
        return primos;
    }

    private static void seleccionPrimos(int dim, boolean[] esPrimo) {
        int i;
        int j;
        for (i = 2; i < Math.sqrt(dim) + 1; i++) {
            if (esPrimo[i]) {
                // Eliminar los múltiplos de i
                for (j = 2 * i; j < dim; j += i)
                    esPrimo[j] = false;
            }
        }
    }
}

