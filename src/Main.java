import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws Exception {
        //Game game = new Game();
        Number number = new Number();
        ArrayList <Character> readMassiv = new ArrayList<>();
        try (FileReader reader = new FileReader("text.txt")){
            int c;
            char a;
            while ((c = reader.read()) !=-1) {
                System.out.print((char)c + " ");
                a = (char) c;
                readMassiv.add(a);
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        for (Character i: readMassiv) {
            System.out.println(i);
        }

//        BufferedReader reader = new BufferedReader(new FileReader("text.txt"));
//        String line;
//        while ((line = reader.readLine()) != null) {
//            System.out.println(line);
//        }
//        reader.close();
    }
}