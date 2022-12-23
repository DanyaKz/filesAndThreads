package Task1T;

import java.io.*;

public class SaveAsThread extends Thread {

    @Override
    public void run() {
        try (FileOutputStream fos = new FileOutputStream("src/Task1T/array.txt", true);
             BufferedOutputStream bos = new BufferedOutputStream(fos)) {

            bos.write(String.valueOf(MainT.value).getBytes());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
