package ru.vienoulis;

import ru.vienoulis.logic.Bord;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Bord bord = new Bord(10, 10);
        bord.initBord();
        while (true){
            Thread.sleep(1000);
            bord.refactorBord(bord.getEssences());
        }

    }
}
