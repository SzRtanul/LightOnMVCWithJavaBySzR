/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.LightOn;
import modelforview.Light;
import view.LightOnGUIView;

/**
 *
 * @author SzabóRoland(SZF_2024
 */
public class LightOnController {
    public LightOnController(LightOn model, LightOnGUIView view){
        view.doGeneral(model.getJatekter());
        Light[] lights = view.getLights();
        view.setVisible(true);
        for (int i = 0; i < model.getHossz(); i++) {
            final int it = i;
            lights[i].addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {
                    model.doKattint(it);
                    view.doFrissit(model.getJatekter());
                    if(model.isWin()) view.doWin();
                }
            });
        }
    }
}
