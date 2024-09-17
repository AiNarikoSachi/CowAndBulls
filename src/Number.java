import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.file.Files;
import java.util.Scanner;

public class Number  {
    private int lengthMassiv = 5;
    private int number;
    private int[] massiv = new int[lengthMassiv];

    //Ввод длины числа.
    private int lengthMas() {
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.print("Введите целое число от 1-ого до 10-ти:");
            while (!scanner.hasNextInt()) {
                System.out.println("Введите целое ЧИСЛО от 1-ого до 10-ти:");
                scanner.next();
            }
            lengthMassiv = scanner.nextInt();
        } while (lengthMassiv <= 0 || lengthMassiv > 10);
        return lengthMassiv;
    }

    //Ввод номера меню.(???)
    private int menuNumber() {
        Scanner scanner = new Scanner(System.in);
        int menuNumber = 0;
        if (scanner.hasNextInt()) {
            menuNumber = scanner.nextInt();
        } else {
            System.out.println("Введенно не корректное значение, " +
                    "Введите повторно число, пожалуйста.");
            return menuNumber();
        }
        return menuNumber;
    }

    //Меню основное.(???)
    private int getMenu() {
      Scanner scanner = new Scanner(System.in);
      System.out.println("Выберите номер операции:" +
              "\n1 — режим игры" +
              "\n2 — Ввод данных c файла или консоли" +
              "\n3 — Изменение длинны исходного числа" +
              "\n4 — Вкл./Выкл. повторяющиеся цифры");
      int menuNumber = menuNumber();
      switch (menuNumber) {
          case 1:
              return 1;
          case 2:
              return getPrint();
          case 3:
              return lengthMas();
          case 4:
              return getLenght();
          default:
              System.out.println("Неправильный пункт меню! " +
                      "Пожалуйста, повторите операцию\n");
              return getMenu();
      }
    }

    //Меню повторов.(???)
    private char getLenght() {
        System.out.println("Вкл./Выкл. повторяющиеся цифры" +
                "\n1 — Вкл." +
                "\n2 — Выкл.");
        int menuNumber = menuNumber();
        switch (menuNumber) {
            case 1:
                return '1';
            case 2:
                return '2';
            default:
                System.out.println("Неправильный пункт меню! " +
                        "Пожалуйста, повторите операцию\n");
                return getLenght();
        }
    }

    //Меню выбора чтения файлов.(???)
    private char getPrint() {
      System.out.println("Выберите как читать/выводить данные" +
              "\n1 — Консоль" +
              "\n2 — Файл");
      int menuNumber = menuNumber();
      switch (menuNumber) {
          case 1:
              return '1';
          case 2:
              return '2';
          default:
              System.out.println("Неправильный пункт меню! " +
                      "Пожалуйста, повторите операцию\n");
              return getPrint();
      }
    }

    //Ввод числа для игры.
    private int numberScan() {
        Scanner scanner = new Scanner(System.in);
        int leni = 0;
        do {
            System.out.println("Введите число длниы: " + lengthMassiv);
            while (!scanner.hasNextInt()) {
                System.out.println("Введите целое ЧИСЛО длины:" + lengthMassiv);
                scanner.next();
            }
            number = scanner.nextInt();
            leni = String.valueOf(number).length();
        } while (leni != lengthMassiv);
        return number;
    }

    //Разделение числа на цифры.
    private int[] numberRepitition() {
        double temp = number;
        for (int i = 0; i < lengthMassiv; i++) {
            int pown = lengthMassiv - 1 - i;
            double j = temp / Math.pow(10, pown);
            int k = (int) j;
            temp = temp % Math.pow(10, pown);
            massiv[i] = k;
            //System.out.println(massiv[i]);
        }
        return massiv;
    }

    //Загаданный массив от бота.
    private int[] testMassiv(int testMassiv[]) {
        for (int i = 0; i < lengthMassiv; i++) {
            testMassiv[i] = (int) (Math.random() * 10);
//            System.out.print(testMassiv[i] + " ");
//            System.out.println();
        }
        return testMassiv;
    }

    //Проверка числа на повторяющиеся числа.
    private int[] numberComparison() {
        int testMassiv[] = new int[lengthMassiv];
        testMassiv(testMassiv);

        for (int i = 0; i < lengthMassiv; i++) {
            for (int j = 0; j < lengthMassiv; j++) {
                if (testMassiv[i] == testMassiv[j]) {
                    if (i != j) {
                        //System.out.println("Повторение чисел:");
                        testMassiv[j] = (int) (Math.random() * 10);
                        //System.out.println(testMassiv[i] + " " + testMassiv[j]);
                        i = 0;
                        j = 0;
                    }
                }
            }
        }
//        for (int i = 0; i < lengthMassiv; i++) {
//            System.out.print(testMassiv[i] + " ");
//        }
//        System.out.println();
        return testMassiv;
    }

    private void cowAndBulls() {
        //int testMassiv[] = numberComparison();
        int testMassiv[] = new int[lengthMassiv];
        testMassiv(testMassiv);
        int gamerMassiv[] = numberRepitition();

        for (int i: testMassiv) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i: gamerMassiv) {
            System.out.print(i + " ");
        }
        System.out.println();
        int cow = 0;
        int bulls = 0;
        int figure = 10;
        int cowMassiv[] = new int[figure];
        int counter = 0;
        int testing[] = new int[figure];
        for (int i = 0; i < lengthMassiv; i++) {
            for (int j = 0; j < lengthMassiv; j++) {
                if (i != j) {
                    if (testMassiv[i] == gamerMassiv[j]) {
                        cowMassiv[counter]  = testMassiv[i];
                        testing[counter] = testMassiv[i];
                        counter += 1;
                        cow += 1;
                        System.out.println(testMassiv[i] + " " + gamerMassiv[j]);
                    }
                }
                if (i == j) {
                    if (testMassiv[i] == gamerMassiv[j]) {
                        bulls += 1;
                    }
                }
            }
        }
        for (int i: cowMassiv) {
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.println("Cow: " + cow);
        System.out.println("Bulls: " + bulls);
    }

    private void readFile() {

    }

    public Number() {
        numberScan();
        //numberRepitition();
        //numberComparison();
        //lengthMas();
        //getMenu();
        cowAndBulls();
    }

}
