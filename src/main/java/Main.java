import java.io.*;
import java.nio.file.*;
import java.util.List;
import java.util.Map;

import static org.apache.commons.io.IOUtils.*;


public class Main {

    public static void main(String[] args) throws IOException {

        Path directory = Paths.get("testfiles");

        if (Files.exists(directory) && Files.isDirectory(directory)) {

            StringBuilder stringBuilder = new StringBuilder();
            DirectoryStream<Path> files = Files.newDirectoryStream(directory);

            for (Path file : files) {
                TextUtils.printFileAtributes(file);
                List<String> lines = Files.readAllLines(Paths.get(file.toString()));

                for (String line : lines) {
                    stringBuilder.append(line).append(" ");
                }

                Map<String, Integer> frequency = new Text(stringBuilder.toString()).getWordFrequencies();
                stringBuilder = new StringBuilder();
                // System.out.println(frequency);
            }
        } else {
            System.out.println("It isn't directory");
        }

        myCopyFile("input.txt", "output.txt");

    }

    private static void myCopyFile(String originName, String copyName) {
        try (InputStream input = new FileInputStream(originName);
             OutputStream output = new FileOutputStream(copyName)) {

            byte[] buffer = new byte[1024];
            int length;
            while ((length = input.read(buffer)) > 0) {
                output.write(buffer, 0, length);
            }
            System.out.println("FILE WAS COPIED!");
        } catch (FileNotFoundException e) {
            System.out.println("Cant find file " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Can't copy");
        }
    }


}
