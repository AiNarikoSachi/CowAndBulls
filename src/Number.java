import java.util.Scanner;

public class Number {
    private int lengthMassiv;

  private void lenghtMas() {
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.print("Введите целое число от 1-ого до 10-ти:");
            while (!scanner.hasNextInt()) {
                System.out.println("Введите целое ЧИСЛО от 1-ого до 10-ти:");
                scanner.next();
            }
            lengthMassiv = scanner.nextInt();
        } while (lengthMassiv <= 0 || lengthMassiv > 10);
  }



}
