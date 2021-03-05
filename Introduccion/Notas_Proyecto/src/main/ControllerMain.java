package main;

import ft.controller.Controller;
import ft.domain.Note;
import ft.domain.ThemeColor;
import ft.view.ViewBase;
import java.awt.Color;
import java.awt.EventQueue;

public class ControllerMain {

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                ViewBase vb = new ViewBase();
                vb.setVisible(true);
            }
        });
        
    }
}
