package com.vartanian.extra.animation.impl;

import com.vartanian.extra.animation.ComponentAnimation;
import com.vartanian.extra.utils.Utils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by vartanian on 22.10.2015.
 */
public class Fade implements ComponentAnimation {

    private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    private Utils utils = new Utils();

    private Timer timer;
    private int min = 20;
    private int max = 400;
    private int alpha = max;
    private int increment = -5;

    @Override
    public void makeUI(Component component) {

        if (timer != null && timer.isRunning()) return;
        timer = new Timer(25, new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                alpha += increment;
                int locationX = (screenSize.width - alpha);
                int locationY = 0;
                if (alpha >= max) {
                    alpha = max;
                    increment = -increment;
                }
                if (alpha <= min) {
                    alpha = min;
                    increment = -increment;
                }
                utils.changeBounds(component, alpha, 0);
                if (alpha >= max || alpha <= min) timer.stop();
            }
        });

        timer.start();

    }

}
