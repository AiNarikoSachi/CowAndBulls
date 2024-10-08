import javax.swing.*;
import java.util.Scanner;

public class Game {
    private int length;
    private int[] mas;
    private int[] inputArray;

    private void printMas(int[] mas) {
        for (int i = 0; i < length; i++) {
            System.out.print(mas[i] + " ");
        }
    }

    private void getMas() {
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.print("Введите целое число от 1 до 10");
            while (!scanner.hasNextInt()) {
                System.out.println("Введите число");
                scanner.next();
            }
            length = scanner.nextInt();
        } while (length <= 0 || length > 10);
        setMas(creatMas());
    }

    public void setMas (int[] mas) {
        this.mas = mas;
    }

    private int[] creatMas() {
        int[] arr = new int[length];
        for (int i = 0; i < this.length; i++) {
            arr[i] = (int) (Math.random() * 10);
        }
        boolean checkMas = false;
        while (!checkMas) {
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr.length; j++) {
                    if (i != j) {
                        if (arr[i] == arr[j]) {
                            arr[j] = (int) (Math.random() * 10);
                        }
                    }
                }
            }

            boolean check = false;
            for (int i = 0; i < arr.length && !check; i++) {
                for (int j = 0; j < arr.length && !check; j++) {

                    if (i != j) {
                        if (arr[i] == arr[j]) {
                            check = true;
                            checkMas = false;
                        } else checkMas = true;
                    }
                }
            }
        }
        return arr;
    }

    private void CheckInput() {
        Scanner scanner = new Scanner(System.in);
        int[] arr = new int[length];
        if (length == 1) System.out.println("Введите "+ length + " число через ввод");
        else {
            if (length > 1 && length <5) {
                System.out.println("Введите "+ length + " числа через ввод");
            } else {
                if (length > 4 && length < 11) {
                    System.out.println("Введите "+ length + " чисел через ввод");
                }
            }
        }
        boolean checkMas = false;
        while (!checkMas) {
            for (int i = 0; i < length; i++) {
                do {
                    System.out.println("Введите целое число");
                    while (!scanner.hasNextInt()) {
                        System.out.println("Введите число");
                        scanner.next();
                    }
                    arr[i] = scanner.nextInt();
                    if(arr[i] < 0 || arr[i] >= 10) System.out.println("Введите число от 0 до 9 включительно");
                } while (arr[i] < 0 || arr[i] >= 10);
            }

            boolean check = checkInputArray(arr);
            if (check) {
                checkMas = true;
            } else {
                System.out.println("Введенное число содержит повторяющиеся числа");
                System.out.println("Повторите ввод сначала");
            }
        }
        setInputArray(arr);
    }

    private boolean checkInputArray(int[] arr) {
        boolean checkMas = false;
        boolean check = false;
        for (int i = 0; i < arr.length && !check; i++) {
            for (int j = 0; j < arr.length && !check; j++) {

                if (i != j) {
                    if (arr[i] == arr[j]) {
                        check = true;
                        checkMas = false;
                    } else checkMas = true;
                }
            }
        }
        return checkMas;
    }

    public void setInputArray(int[] inputArray) {
        this.inputArray = inputArray;
    }

    public int[] checkCowAndBull() {
        int[] arr = new int[2];
        int cow = 0;
        int bull = 0;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {

                if (mas[i] == inputArray[j]) {
                    if (i == j) bull++;
                    else cow++;
                }
            }
        }
        arr[0] = cow;
        arr[1] = bull;
        return arr;
    }

    public Game() {
        getMas();
        boolean win = false;
        while (win == false) {
            CheckInput();
            System.out.println("Введенный массив:");
            printMas(inputArray);
            System.out.println();
            int[] arr = checkCowAndBull();
            if (arr[1] == length) {
                win = true;
                System.out.println("Поздравляю! Вы победили!");
            } else {
                System.out.println("В введенно числе " + arr[0] + "коров, " + arr[0] + "быков");
                System.out.println("Повторите ввод числа");
            }
        }
    }

}
