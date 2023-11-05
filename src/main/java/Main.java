
import java.io.FileNotFoundException;

class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Files file = new Files();
        file.readFile();
        file.viewFile();
        file.writeFile();
    }
}