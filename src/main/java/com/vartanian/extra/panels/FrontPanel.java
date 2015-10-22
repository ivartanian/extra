package com.vartanian.extra.panels;

import com.jgoodies.forms.factories.Paddings;
import com.vartanian.extra.models.CheckBoxPanel;
import com.vartanian.extra.models.TreePanel;
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
    private final CheckBoxPanel checkBoxPanel = new CheckBoxPanel();
    private final TreePanel treePanel = new TreePanel();

    private boolean open = false;

    public FrontPanel() throws HeadlessException {
        super("Test panel");

        initComponents();
    }

    private void initComponents() {

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Test panel");
//        setResizable(false);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                thisMouseEntered(e);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                thisMouseExited(e);
            }
        });

        JPanel dialogPane = new JPanel(new BorderLayout());

        dialogPane.setBorder(Paddings.DIALOG);

        dialogPane.add(checkBoxPanel, BorderLayout.NORTH);
        dialogPane.add(treePanel, BorderLayout.CENTER);

        add(dialogPane);

        changeSize(400, 0);

    }

    private void thisMouseEntered(MouseEvent e) {
    }

    private void thisMouseExited(MouseEvent e) {
    }

    private void changeSize(int width, int height) {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int locationX = (screenSize.width - width);
        int locationY = height;
        setBounds(locationX, locationY, width, screenSize.height);
    }

    public static void main(String args[]) {

        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            LOG.error(ex);
        } catch (InstantiationException ex) {
            LOG.error(ex);
        } catch (IllegalAccessException ex) {
            LOG.error(ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            LOG.error(ex);
        }

        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrontPanel().setVisible(true);
            }
        });
    }

}
