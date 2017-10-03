import java.io.*;
import java.nio.file.Files;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
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
    }
}
