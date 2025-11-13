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
        this.reActions(model, view);
        view.Bt_exit.addActionListener((e) -> {
            view.doExit();
        });
        view.Bt_restart.addActionListener((e) -> {
            model.doRestart();
            this.reActions(model, view);
        });
        view.Bt_load.addActionListener((e) -> {
            if(model.doLoad()) this.reActions(model, view);
        });
        view.Bt_save.addActionListener((e) -> {
            view.doSave(model.doSave());
        });
        view.setVisible(true);
    }
    
    public void reActions(LightOn model, LightOnGUIView view){
        view.doGeneral(model.getJatekter());
        view.setLabels(model);
        Light[] lights = view.getLights();
        for (int i = 0; i < model.getHossz(); i++) {
            final int it = i;
            lights[i].addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {
                    model.doKattint(it);
                    view.doFrissit(model.getJatekter());
                    if(model.isWin()) view.doWin();
                    view.setLabels(model);
                }
            });
        }
    }
}
