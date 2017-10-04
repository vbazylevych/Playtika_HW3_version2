import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;


public class Main {

    public static void main(String[] args) throws IOException {


        Path directory = Paths.get("kot");

        if (Files.exists(directory) && Files.isDirectory(directory)) {

            StringBuilder stringBuilder = new StringBuilder();
            String oneLineText = "";
            int generalSum = 0;

            DirectoryStream<Path> files = Files.newDirectoryStream(directory);

            for (Path file : files) {

                try (BufferedReader reader = new BufferedReader(
                        new InputStreamReader(
                                new FileInputStream(file.toString()), StandardCharsets.UTF_8))) {
                    String line;

                    while ((line = reader.readLine()) != null) {

                        oneLineText = stringBuilder.append(line).append(" ").toString();
                    }

                    TextUtils.printFileAtributes(file);

                    int oneFileSum = TextUtils.getOneFileSum(oneLineText);
                    generalSum = generalSum + oneFileSum;
                    System.out.println("Sum of frequency for file " + file.getFileName() + " -- " + oneFileSum + "\n");

                    stringBuilder = new StringBuilder();

                } catch (IOException e) {
                    System.out.println("I cant find such directory :(");
                }

            }
            System.out.println("Sum of frequency for ALL files:  " + generalSum);
        } else {
            System.out.println("It isn't directory");
        }
    }


}
