import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class InputReader {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter user data (Last Name First Name Patronymic Date_of_Birth Phone_Number Gender):");
            String input = scanner.nextLine();
            String[] data = input.split(" ");

            if (data.length != 6) {
                throw new IllegalArgumentException("Incorrect number of data fields. Please provide Last Name, First Name, Patronymic, Date of Birth, Phone Number, and Gender separated by spaces.");
            }

            String lastName = data[0];
            String firstName = data[1];
            String patronymic = data[2];
            LocalDate dateOfBirth = LocalDate.parse(data[3], DateTimeFormatter.ofPattern("dd.MM.yyyy"));
            long phoneNumber = Long.parseUnsignedLong(data[4]);
            String gender = data[5];

//          System.out.println("User data saved to file: " + file.getName());
//        } catch (IllegalArgumentException e) {
//            System.out.println("Error: " + e.getMessage());
//        } catch (DateTimeParseException e) {
//            System.out.println("Error: Incorrect data format. Date should be in dd.mm.yyyy format, Phone Number should be an unsigned integer.");
//        } catch (IOException e) {
//            System.out.println("Error writing to file. Details: " + e.getMessage());

            if (!gender.equalsIgnoreCase("f") && !gender.equalsIgnoreCase("m")) {
                throw new IllegalArgumentException("Invalid gender. Please enter 'f' for female or 'm' for male.");
            }

            File file = new File(lastName + ".txt");
            FileWriter writer = new FileWriter(file, true);
            writer.write(String.format("%s %s %s %s %d %s%n", lastName, firstName, patronymic, dateOfBirth.format(DateTimeFormatter.ofPattern("dd.MM.yyyy")), phoneNumber, gender));
            writer.close();

            System.out.println("User data saved to file: " + file.getName());
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (DateTimeParseException e) {
            System.out.println("Error: Incorrect data format. Date should be in dd.mm.yyyy format, Phone Number should be an unsigned integer.");
        } catch (IOException e) {
            System.out.println("Error writing to file. Details: " + e.getMessage());
        }
    }
}