package Task2T;

public class Main {

    static char num;
    static int n = 3;
    static int ind1, ind2;

    public static void main(String[] args) throws InterruptedException {
        char[][] abc = new char[n][n];


        for (int i = 0; i < 3; i++) {
            ind1 = i;
            for (int j = 0; j < 3; j++) {
                ind2 = j + 1;
                SaveAsThread sat = new SaveAsThread();
                sat.start();
                sat.join();
                abc[j][i] = num;
                System.out.print(abc[j][i] + " ");
            }
            System.out.println();
        }
        
        /* 1 2 3
           4 5 6
           7 8 9 */


    }
}
