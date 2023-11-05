import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.Double.parseDouble;

public class Files {
    public List<Calculator> calculatorList = new ArrayList<>();

    public void readFile() throws FileNotFoundException {
        File file = new File("operations.txt");
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String[] elements = scanner.nextLine().split(" ");
                calculatorList.add(new Calculator(parseDouble(elements[0]), elements[1], parseDouble(elements[2])));
            }
        }
    }

    public void viewFile() {
        for (Calculator calculator1 : calculatorList) {
            System.out.println(calculator1.getNumber1() + " " + calculator1.getOperator()
                    + " " + calculator1.getNumber2() + " = " + calculator1.calculatorResult());
        }
    }

    public void writeFile() {
        try (FileWriter fileWriter = new FileWriter("result.txt", false)) {
            for (Calculator calculator : calculatorList) {

                fileWriter.append(calculator.getNumber1() + " "
                        + calculator.getOperator() + " " + calculator.getNumber2() + " = " + calculator.calculatorResult() + "\n");

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
