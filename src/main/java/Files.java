import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.Double.parseDouble;

public class Files {
    ArrayList<MathematicalOperation> mathematicalOperationArrayList = new ArrayList<>();

    public List<MathematicalOperation> readFile() throws FileNotFoundException {

        File file = new File("operations.txt");
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String[] elements = scanner.nextLine().split(" ");
                mathematicalOperationArrayList.add(new MathematicalOperation(parseDouble(elements[0]), elements[1], parseDouble(elements[2])));
            }
        }
        return mathematicalOperationArrayList;
    }

    public void viewFile() {
        for (MathematicalOperation mathematicalOperation : mathematicalOperationArrayList) {
            System.out.println(mathematicalOperation.getNumber1() + " " + mathematicalOperation.getOperator()
                    + " " + mathematicalOperation.getNumber2() + " = " + mathematicalOperation.mathematicalOperationResult());
        }
    }

    public void writeFile() {
        try (FileWriter fileWriter = new FileWriter("result.txt", false)) {
            for (MathematicalOperation mathematicalOperation : mathematicalOperationArrayList) {

                fileWriter.append(mathematicalOperation.getNumber1() + " "
                        + mathematicalOperation.getOperator() + " " + mathematicalOperation.getNumber2() + " = "
                        + mathematicalOperation.mathematicalOperationResult() + "\n");

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
