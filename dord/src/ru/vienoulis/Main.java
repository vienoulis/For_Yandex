package ru.vienoulis;

import ru.vienoulis.logic.Bord;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        try {
            Bord bord = start();
            bord.initBord();
            while (true){
                Thread.sleep(1000);
                bord.refactorBord(bord.getEssences());
            }
        } catch (IOException e) {
            System.out.println("Кто то, что то не то ввел. Сушность улетела, я победжал ее ловить... Опять.");
            e.printStackTrace();
        } catch (Exception e){
            System.out.println("Сушность испугалась и убежала. Я пошел ловить... Ну зачем так то?");
        }

    }

    private static Bord start() throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int choice;
        System.out.print("Привет, данная программа эмитирует жизненный цикл одного странного организма.\n"
                        + "Мы можете заселить поле, как вам хочется, либо приложение заселить поле самостоятельно,\n"
                            + "поймав их немного из окружающей среды.\n"
                                + "Введите 1, чтобы считать существ из файла (Да, они живут в файлах).\nВведите 2, чтобы поймать существ: " );
        choice = Integer.parseInt(reader.readLine());
        if (choice == 1){
            System.out.print("Введите имя \"зараженного\" файла: ");
            return new Bord(reader.readLine());
        } else if (choice == 2 ){
            System.out.println("Сушность живет на поле. Какое поле надо?");
            System.out.print("Ширина поля равна: ");
            int width = Integer.parseInt(reader.readLine());
            System.out.print("Длина поля равна: ");
            int length = Integer.parseInt(reader.readLine());
            return new Bord(width, length);
        } else {
            throw new Exception();
        }
    }

}
