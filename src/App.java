public class App {
    public static void pintaTopTabla() {
        System.out.printf("""
                 ___________________________________________________________________________________________
                |           |       |       |       |       |       |       |       |       |       |       |
                |   Índice  |   0   |   1   |   2   |   3   |   4   |   5   |   6   |   7   |   8   |   9   |
                |___________|_______|_______|_______|_______|_______|_______|_______|_______|_______|_______|
                |           |       |       |       |       |       |       |       |       |       |       |
                |   Valor   |""");
    }

    public static void pintarBottomTabla() {
        System.out.printf("""

                |___________|_______|_______|_______|_______|_______|_______|_______|_______|_______|_______|
                """);
    }

    public static void pintaTablaFUll(int[] array) {
        pintaTopTabla();
        for (int i = 0; i < 10; i++) {
            System.out.printf("""
                    %5s  |""", array[i]);
        }
        pintarBottomTabla();
    }

    public static void main(String[] args) throws Exception {
        int[] array;
        array = new int[10];
        int menorIgual = 0;
        int mayor = 0;
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 201);
            if (array[i] >= 0 && array[i] <= 100)
                menorIgual++;
            else if (array[i] > 100)
                mayor++;
        }
        pintaTablaFUll(array);
        System.out.println();
        System.out.println();
        // Array final
        int[] organizado;
        organizado = new int[10];
        // Array con nums menores de 100
        int[] menores;
        menores = new int[menorIgual];
        int nMenores = 0;
        // Array con nums mayores de 100
        int[] mayores;
        mayores = new int[mayor];
        int nMayores = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] <= 100) {
                menores[nMenores] = array[i];
                nMenores++;
            }
        }
        for (int i = 0; i < array.length; i++) {
            if (array[i] > 100) {
                mayores[nMayores] = array[i];
                nMayores++;
            }
        }
        nMenores = 0;
        nMayores = 0;
        for (int i = 0; i < array.length; i++) {
            if (i % 2 == 0) {
                if (nMenores == menorIgual) {
                    organizado[i] = mayores[nMayores];
                    nMayores++;
                } else {
                    organizado[i] = menores[nMenores];
                    nMenores++;
                }
            }
            if (i % 2 != 0) {
                if (nMayores == mayor) {
                    organizado[i] = menores[nMenores];
                    nMenores++;
                } else {
                    organizado[i] = mayores[nMayores];
                    nMayores++;
                }
            }
        }
        System.out.println("Array resultante:");
        pintaTablaFUll(organizado);
    }
}
