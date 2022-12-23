package Task1T;


public class MainT {

    static int value;

    public static void main(String[] args) throws InterruptedException {
        int[] a = {1, 4, 7};
        int[] b = {2, 5, 8};
        int[] c = {3, 6, 9};

        int[][] abc = {a, b, c};


        for (int i = 0; i < abc.length; i++) {
            for (int j = 0; j < abc.length; j++) {
                value = abc[j][i];
                SaveAsThread sat = new SaveAsThread();
                sat.start();
                sat.join();
            }
        }

    }
}
