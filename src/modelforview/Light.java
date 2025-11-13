/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelforview;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import javax.swing.BorderFactory;
import javax.swing.JButton;

/**
 *
 * @author SzabóRoland(SZF_2024
 */
public class Light extends JButton{
    public Light(boolean isOn){
        this.setPreferredSize(new Dimension(72, 72));
        setOn(isOn);
        this.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));
        //this.setContentAreaFilled(false);
       // this.setBounds(0, 0, 0, 0);
        this.setFocusPainted(false);
    }
    
    public final void setOn(boolean isOn){
        this.setBackground(isOn ? Color.YELLOW : Color.BLACK);
        this.validate();
    }
}
