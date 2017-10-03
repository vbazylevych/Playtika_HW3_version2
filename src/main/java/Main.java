import com.sun.xml.internal.fastinfoset.util.StringArray;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {


/*
        System.out.println("Dratuti!");


        //Method[] metods = Text.class.getDeclaredAnnotation()

        File file = new File("text.txt");

     //   InputStream stream = new FileInputStream(file);

       // Reader reader = new Reader();
try(FileInputStream stream = new FileInputStream(file)){

    //File Utils FROM APACHE COMMON


        Reader inputStreamReader = new InputStreamReader(new FileInputStream(file));
    List<String> strings = Files.readAllLines(file.toPath());
    for (String line : strings) {
        System.out.println(line);

    }
} catch (FileNotFoundException e){
}

*/


        System.out.println("Enter absolute path to directory and press Enter OR  enter kot in order to continue with default directory");

        Scanner scanner = new Scanner(System.in);
        String directoryPath = scanner.nextLine();

        Path directory = Paths.get(directoryPath);
        StringBuilder stringBuilder = new StringBuilder();

        if (directoryPath == "def") {
            directory = Paths.get("kot");
        }
        String newLine = "";
        if (Files.exists(directory) && Files.isDirectory(directory)) {
            DirectoryStream<Path> files = Files.newDirectoryStream(directory);

            for (Path file : files) {

                try (BufferedReader reader = new BufferedReader(
                        new InputStreamReader(
                                new FileInputStream(file.toString()), StandardCharsets.UTF_8))) {
                    String line;

                    while ((line = reader.readLine()) != null) {

                        newLine = stringBuilder.append(line).append(" ").toString();


                    }

                } catch (IOException e) {
                    System.out.println("nexoroshii put'");

                }

                System.out.println(newLine);
                stringBuilder = new StringBuilder();
            }
        } else {
            System.out.println("It isn't directory");
        }


    }
}
