import java.util.Scanner;

public class Number {
    private int lengthMassiv;

  private void lengthMas() {
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

    private char getMenu() {
      Scanner scanner = new Scanner(System.in);
      System.out.println("Выберите номер операции:\n1 — режим игры" +
              "\n2 — Ввод данных c файла или консоли" +
              "\n3 — Изменение длинны исходного числа" +
              "\n4 — Вкл./Выкл. повторяющиеся цифры");
      int menuNumber = 0;
      if (scanner.hasNextInt()) {
          menuNumber = scanner.nextInt();
      } else {
          System.out.println("Введенно не корректное значение, " +
                  "Введите повторно число, пожалуйста.");
          return getMenu();
      }
      switch (menuNumber) {
          case 1:
              return '1';
          case 2:
              return '2';
          case 3:
              return '3';
          case 4:
              return '4';
          default:
              System.out.println("Неправильный пункт меню! " +
                      "Пожалуйста, повторите операцию");
      }
      return scanner.next().charAt(0);
    }

}
