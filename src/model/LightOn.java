/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Arrays;

/**
 *
 * @author SzabóRoland(SZF_2024
 */
public class LightOn {

    int oszlop;
    int hossz;
    boolean win;
    boolean[] jatekter;

    public LightOn() {
        doRestart();
    }

    public final void doRestart() {
        this.oszlop = 3;
        this.hossz = oszlop * 3;
        this.jatekter = new boolean[this.hossz];
        int rand = (int) (Math.random() * hossz);
        jatekter[rand] = true;
    }

    public boolean doKattint(int hely) {
        boolean both = !win && (hely ^ (1 << 31)) < hossz;
        if (both) {
            int mino = hely - oszlop;
            int maxo = hely + oszlop;
            if (mino >= 0) {
                jatekter[mino] = !jatekter[mino];
            }
            if (maxo < hossz) {
                jatekter[maxo] = !jatekter[maxo];
            }
            for (int i = hely - (hely % this.oszlop > 0 ? 1 : 0); i < hely + ((hely + 1) % this.oszlop == 0 ? 1 : 2); i++) {
                this.jatekter[i] = !this.jatekter[i];
            }
            this.win = checkWin();
        }
        return both;
    }

    public int getOszlop() {
        return oszlop;
    }

    public int getHossz() {
        return hossz;
    }

    private boolean checkWin() {
        boolean both = true;
        for (int i = 0; i < this.hossz && both; i++) {
            both = !jatekter[i];
        }
        return both;
    }

    public boolean isWin() {
        return win;
    }

    public boolean[] getJatekter() {
        return Arrays.copyOf(jatekter, jatekter.length);
    }
}
