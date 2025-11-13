/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.nio.ByteBuffer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

/**
 *
 * @author SzabóRoland(SZF_2024
 */
public class LightOn {

    int oszlop;
    int hossz;
    boolean win;
    byte[] jatekter;

    public LightOn() {
        doRestart();
    }

    public final void doRestart() {
        this.oszlop = 3;
        this.hossz = oszlop * 3;
        this.jatekter = new byte[this.hossz+1];
        int rand = (int) (Math.random() * hossz);
        jatekter[rand] = 1;
    }
    
    public boolean doSave(){
        boolean both = !win;
        if(both){
            try {
                Files.write(Path.of("yea.gs"), jatekter);
            } catch (Exception e) {
                return false;
            }
        }
        return both;
    }
    
    public boolean doLoad(){
        try {
            if(Files.exists(Path.of("yea.gs"))) this.jatekter = Files.readAllBytes(Path.of("yea.gs"));
            else return false;
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public boolean doKattint(int hely) {
        boolean both = !win && (hely ^ (1 << 31)) < hossz;
        if (both) {
            int mino = hely - oszlop;
            int maxo = hely + oszlop;
            byte h = 0;
            if (mino >= 0) {
                h = jatekter[mino];
                jatekter[mino] = h == 1 ? (byte)0 : (byte)1;
            }
            if (maxo < hossz) {
                h = jatekter[maxo];
                jatekter[maxo] = h == 1 ? (byte)0 : (byte)1;
            }
            for (int i = hely - (hely % this.oszlop > 0 ? 1 : 0); i < hely + ((hely + 1) % this.oszlop == 0 ? 1 : 2); i++) {
                h = this.jatekter[i];
                this.jatekter[i] = h == 1 ? (byte)0 : 1;
            }
            jatekter[this.hossz]++;
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
            both = this.jatekter[i] == 0;
        }
        return both;
    }

    public boolean isWin() {
        return win;
    }

    public byte[] getJatekter() {
        return Arrays.copyOf(jatekter, jatekter.length-1);
    }
    
    public byte getLepes(){
        return jatekter[this.hossz];
    }
}
