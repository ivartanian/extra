package com.vartanian.extra.models;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/**
 * Created by super on 10/22/15.
 */
public class CheckBoxPanel extends JPanel implements ItemListener {

    JCheckBox button12;
    JCheckBox button42;
    JCheckBox button201;

    int total = 0;

    JLabel resultLabel;

    public CheckBoxPanel() {

        super(new BorderLayout());

        button12 = new JCheckBox("12");
        button12.setName("12");
        button12.setSelected(false);

        button42 = new JCheckBox("42");
        button42.setName("42");
        button42.setSelected(false);

        button201 = new JCheckBox("201");
        button201.setName("201");
        button201.setSelected(false);

        button12.addItemListener(this);
        button42.addItemListener(this);
        button201.addItemListener(this);

        resultLabel = new JLabel("resultLabel");
        resultLabel.setName("resultLabel");
        updateResult();

        JPanel checkPanel = new JPanel(new GridLayout(0, 3));
        checkPanel.add(button12);
        checkPanel.add(button42);
        checkPanel.add(button201);
        add(checkPanel, BorderLayout.LINE_START);

        JPanel resultPanel = new JPanel(new GridLayout(0, 1));
        resultPanel.add(resultLabel);
        add(resultPanel, BorderLayout.SOUTH);
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        Object source = e.getItemSelectable();
        int currentValue = 0;
        if (source == button12) {
            currentValue = 12;
        } else if (source == button42) {
            currentValue = 42;
        } else if (source == button201) {
            currentValue = 201;
        }
        if (e.getStateChange() == ItemEvent.DESELECTED) {
            total -= currentValue;
        }else {
            total += currentValue;
        }

        updateResult();
    }

    protected void updateResult() {
        resultLabel.setText(String.valueOf(total));
    }

}