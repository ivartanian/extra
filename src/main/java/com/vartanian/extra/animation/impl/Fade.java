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
    private final int delay;
    private final int min;
    private final int max;
    private int alpha;
    private int increment = -5;

    public Fade(int delay, int min, int max) {
        this.delay = delay;
        this.min = min;
        this.max = max;
        this.alpha = max;
    }

    @Override
    public void makeUI(Component component) {

        if (timer != null && timer.isRunning()) return;
        timer = new Timer(delay, new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                alpha += increment;
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
