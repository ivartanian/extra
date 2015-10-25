package com.vartanian.extra.panels;

import com.jgoodies.forms.factories.Paddings;
import com.vartanian.extra.animation.ComponentAnimation;
import com.vartanian.extra.animation.impl.Fade;
import com.vartanian.extra.models.CheckBoxPanel;
import com.vartanian.extra.models.TreePanel;
import com.vartanian.extra.utils.Utils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by super on 10/22/15.
 */
public class FrontPanel extends JFrame {

    private static final Logger LOG = LogManager.getLogger(FrontPanel.class);
    private Utils utils = new Utils();
    private CheckBoxPanel checkBoxPanel;
    private TreePanel treePanel;

    private ComponentAnimation componentAnimation;

    public FrontPanel() throws HeadlessException {
        super("Panel");

        initComponents();
    }

    public ComponentAnimation getComponentAnimation() {
        return componentAnimation;
    }

    public FrontPanel setComponentAnimation(ComponentAnimation componentAnimation) {
        this.componentAnimation = componentAnimation;
        return this;
    }

    private void initComponents() {

        checkBoxPanel = new CheckBoxPanel();
        treePanel = new TreePanel("Festus");

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Panel");
        setResizable(false);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e)  {
                thisMouseClicked(e);
            }
        });

        JPanel dialogPane = new JPanel(new BorderLayout());

        dialogPane.setBorder(Paddings.DIALOG);

        dialogPane.add(checkBoxPanel, BorderLayout.NORTH);
        dialogPane.add(treePanel, BorderLayout.CENTER);

        add(dialogPane);

        utils.changeBounds(this, 400, 0);

    }

    private void thisMouseClicked(MouseEvent e) {
        if (componentAnimation != null){
            componentAnimation.makeUI(this);
        }
    }

    public static void main(String args[]) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrontPanel().setComponentAnimation(new Fade(25, 20, 400)).setVisible(true);
            }
        });
    }

}
