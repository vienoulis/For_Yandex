package ru.vienoulis.logic;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class Bord {
    private final int X_SIZE;
    private final int Y_SIZE;
    private Essence[][] essences;

    public Bord(int X_SIZE, int Y_SIZE) {
        this.X_SIZE = X_SIZE;
        this.Y_SIZE = Y_SIZE;
        this.essences = new Essence[X_SIZE][Y_SIZE];

        for (int i = 0; i < Y_SIZE; i++) {
            for (int j = 0; j < X_SIZE ; j++) {
                this.essences[j][i] = new Essence(new Random().nextInt(2), j, i);

            }
        }
    }

    public Bord(String fileName) {

        File fail = new File(fileName);
        List<String> strings = new ArrayList<>();
        int countY = 0;
        try (Scanner scanner = new Scanner(fail)){
            while (scanner.hasNext()){
                strings.add(scanner.next());
                countY++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        this.X_SIZE = strings.get(0).length();
        this.Y_SIZE = strings.size();
        this.essences = new Essence[X_SIZE][Y_SIZE];
        for (int i = 0; i < Y_SIZE; i++) {
            for (int j = 0; j < X_SIZE; j++) {
                int value = Integer.parseInt(String.valueOf(strings.get(i).charAt(j)));
                this.essences[j][i] = new Essence(value, j, i);
            }
        }
    }

    public Essence[][] getEssences() {
        return essences;
    }

    public void initBord(){
        for (int i = 0; i < Y_SIZE; i++) {
            for (int j = 0; j < X_SIZE ; j++) {
                System.out.print(essences[j][i].toString());
            }
            System.out.println();
        }
    }

    public void refactorBord(Essence[][] essences){
        System.out.println();
        System.out.println();
        for (int i = 0; i < Y_SIZE ; i++) {
            for (int j = 0; j < X_SIZE; j++) {
                essences[j][i] = changValueOfEssence(essences, j ,i);
                System.out.print(essences[j][i]);
            }
            System.out.println( );
        }
    }

    private Essence changValueOfEssence(Essence[][] essence, int x, int y){
        int count = 0;
        for (int i = 0; i < Y_SIZE; i++) {
            for (int j = 0; j < X_SIZE; j++) {
                if (j >= x -1 && j <= x + 1 && i >= y - 1 && i <= y + 1 ){
                    if (x != j || y != i){
                        count += essence[j][i].getAlive();
                    }
                }
            }
        }
        return isAlive(essence[x][y], count );
    }

    private Essence isAlive(Essence essence, int count) {
        if (essence.getAlive() == 1) {
            if (count < 2) {
                return new Essence(0);
            } else if (count == 2 || count == 3) {
                return essence;
            } else return new Essence(0);
        }
        if (count == 3) {
            return new Essence(1);
        } else return essence;
    }

}
