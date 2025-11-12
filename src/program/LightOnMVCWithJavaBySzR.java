/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package program;

import controller.LightOnController;
import model.LightOn;
import view.LightOnGUIView;

/**
 *
 * @author SzabóRoland(SZF_2024
 */
public class LightOnMVCWithJavaBySzR {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new LightOnController(new LightOn(), new LightOnGUIView());
    }
    
}
