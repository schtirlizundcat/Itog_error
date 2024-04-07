import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class InputReader {
    public static void main(String[] args) {
        String surname = "", firstName = "", middleName = "", dateOfBirth = "DD.MM.YYYY", phoneNumber = "89_________", sex = "M";
        try {
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            String[] inputArray = input.split(" ");
            if (inputArray.length != 6) {
                throw new Exception("Неверное количество параметров");
            }
            surname = inputArray[0];
            firstName = inputArray[1];
            middleName = inputArray[2];
            dateOfBirth = inputArray[3];
            phoneNumber = inputArray[4];
            sex = inputArray[5];

            try {
                File file = new File(surname + ".txt");
                FileWriter writer = new FileWriter(file, true);
                writer.write(String.format("%s %s %s %s %s %s%n", surname, firstName, middleName, dateOfBirth, phoneNumber, sex));
                writer.close();
                System.out.println("Данные субъекта ПДн с фамилией «" + surname + "» успешно записаны в файл «" + file.getName() + "».");
            }
            catch (IOException e) {
                System.out.println("ОШИБКА при записи данных в файл. Подробнее: " + e.getMessage());
            }

        }
        catch (Exception somethingWentWrongException) {
            System.out.println("ОШИБКА. " + somethingWentWrongException.getMessage());
        }
    }
}
