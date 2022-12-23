package Task2T;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class SaveAsThread extends Thread {
    @Override
    public void run() {
        String fileName = "src/Task2/array" + Main.ind2 + ".txt";
        try (FileInputStream fis = new FileInputStream(fileName);
             BufferedInputStream bis = new BufferedInputStream(fis)) {
            byte[] b = bis.readAllBytes();
            Main.num = (char) b[Main.ind1];

        } catch (IOException ioe) {
            throw new RuntimeException(ioe);
        }
    }
}
