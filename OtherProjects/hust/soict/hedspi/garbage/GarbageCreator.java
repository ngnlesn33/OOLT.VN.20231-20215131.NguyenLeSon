package OtherProjects.hust.soict.hedspi.garbage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class GarbageCreator {
    public static void main(String[] args) throws IOException {
        String filename = "OtherProjects/hust/soict/hedspi/garbage/test.exe"; // test.exe is the name or path to an executable file
        byte[] inputBytes = Files.readAllBytes(Paths.get(filename));
        long startTime = System.currentTimeMillis();
        StringBuilder outputStringBuilder = new StringBuilder();
        for (byte b : inputBytes) {
            outputStringBuilder.append((char) b);
        }
        long endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime);
    }
}
