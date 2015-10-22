package com.vartanian.extra.panels;

import java.awt.event.*;

import com.jgoodies.forms.factories.Paddings;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.swing.*;
import javax.swing.event.TreeModelEvent;
import javax.swing.event.TreeModelListener;
import javax.swing.tree.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by super on 10/21/15.
 */
public class MainPanel extends JFrame implements ActionListener {

    private static final Logger LOG = LogManager.getLogger(MainPanel.class);

    private int newNodeSuffix = 1;
    private static String ADD_COMMAND = "add";
    private static String REMOVE_COMMAND = "remove";
    private static String CLEAR_COMMAND = "clear";
    private DefaultMutableTreeNode rootNode;
    private DefaultTreeModel treeModel;
    private Toolkit toolkit = Toolkit.getDefaultToolkit();;


    public MainPanel() throws HeadlessException {
        super("Test panel");

        initComponents();

        changeSize(400, 0);

    }

    public static void main(String args[]) {

        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        }
        catch (ClassNotFoundException ex) {
            LOG.error(ex);
        }
        catch (InstantiationException ex) {
            LOG.error(ex);
        }
        catch (IllegalAccessException ex) {
            LOG.error(ex);
        }
        catch (javax.swing.UnsupportedLookAndFeelException ex) {
            LOG.error(ex);
        }

        /* Create and display the form */
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainPanel().setVisible(true);
            }
        });
    }

    private void checkBox1ActionPerformed(ActionEvent evt) {
        resultLabel.setText("result = " + String.valueOf(Integer.valueOf(checkBox1.getActionCommand()) + Integer.valueOf(checkBox2.getActionCommand()) + Integer.valueOf(checkBox3.getActionCommand())));
    }

    private void checkBox2ActionPerformed(ActionEvent evt) {
        resultLabel.setText("result = " + String.valueOf(Integer.valueOf(checkBox1.getActionCommand()) + Integer.valueOf(checkBox2.getActionCommand()) + Integer.valueOf(checkBox3.getActionCommand())));
    }

    private void checkBox3ActionPerformed(ActionEvent evt) {
        resultLabel.setText("result = " + String.valueOf(Integer.valueOf(checkBox1.getActionCommand()) + Integer.valueOf(checkBox2.getActionCommand()) + Integer.valueOf(checkBox3.getActionCommand())));
    }

    private void changeSize(int width, int height) {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int locationX = (screenSize.width - width);
        int locationY = height;
        setBounds(locationX, locationY, width, screenSize.height);
    }

    public void clear() {
        rootNode.removeAllChildren();
        treeModel.reload();
    }

    /**
     * Remove the currently selected node.
     */
    public void removeCurrentNode() {
        TreePath currentSelection = tree1.getSelectionPath();
        if (currentSelection != null) {
            DefaultMutableTreeNode currentNode = (DefaultMutableTreeNode)
                    (currentSelection.getLastPathComponent());
            MutableTreeNode parent = (MutableTreeNode) (currentNode.getParent());
            if (parent != null) {
                treeModel.removeNodeFromParent(currentNode);
                return;
            }
        }

        // Either there was no selection, or the root was selected.
        toolkit.beep();
    }

    /**
     * Add child to the currently selected node.
     */
    public DefaultMutableTreeNode addObject(Object child) {
        DefaultMutableTreeNode parentNode = null;
        TreePath parentPath = tree1.getSelectionPath();

        if (parentPath == null) {
            parentNode = rootNode;
        } else {
            parentNode = (DefaultMutableTreeNode)
                    (parentPath.getLastPathComponent());
        }

        return addObject(parentNode, child, true);
    }

    public DefaultMutableTreeNode addObject(DefaultMutableTreeNode parent,
                                            Object child) {
        return addObject(parent, child, false);
    }

    public DefaultMutableTreeNode addObject(DefaultMutableTreeNode parent,
                                            Object child,
                                            boolean shouldBeVisible) {
        DefaultMutableTreeNode childNode =
                new DefaultMutableTreeNode(child);

        if (parent == null) {
            parent = rootNode;
        }

        //It is key to invoke this on the TreeModel, and NOT DefaultMutableTreeNode
        treeModel.insertNodeInto(childNode, parent,
                parent.getChildCount());

        //Make sure the user can see the lovely new node.
        if (shouldBeVisible) {
            tree1.scrollPathToVisible(new TreePath(childNode.getPath()));
        }
        return childNode;
    }

    public void populateTree() {
        String p1Name = new String("Parent 1");
        String p2Name = new String("Parent 2");
        String c1Name = new String("Child 1");
        String c2Name = new String("Child 2");

        DefaultMutableTreeNode p1, p2;

        p1 = addObject(null, p1Name);
        p2 = addObject(null, p2Name);

        addObject(p1, c1Name);
        addObject(p1, c2Name);

        addObject(p2, c1Name);
        addObject(p2, c2Name);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        if (ADD_COMMAND.equals(command)) {
            //Add button clicked
            addObject("New Node " + newNodeSuffix++);
        } else if (REMOVE_COMMAND.equals(command)) {
            //Remove button clicked
            removeCurrentNode();
        } else if (CLEAR_COMMAND.equals(command)) {
            //Clear button clicked.
            clear();
        }
    }

    private void thisMouseEntered(MouseEvent e) {
        // TODO add your code here
    }

    private void thisMouseExited(MouseEvent e) {
        // TODO add your code here
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Igor Vartanian
        dialogPane = new JPanel();
        checkboxPanel = new JPanel();
        checkBox1 = new JCheckBox();
        checkBox2 = new JCheckBox();
        checkBox3 = new JCheckBox();
        resultPanel = new JPanel();
        resultLabel = new JLabel();
        scrollPane1 = new JScrollPane();
        tree1 = new JTree();
        buttonPanel = new JPanel();
        addButton = new JButton();
        removeButton = new JButton();
        clearButton = new JButton();

        //======== this ========
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Test");
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
        Container contentPane = getContentPane();

        //======== dialogPane ========
        {
            dialogPane.setBorder(Paddings.DIALOG);

            // JFormDesigner evaluation mark
            dialogPane.setBorder(new javax.swing.border.CompoundBorder(
                new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                    "JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
                    javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                    java.awt.Color.red), dialogPane.getBorder())); dialogPane.addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});

            dialogPane.setLayout(new GridLayout(4, 0));

            //======== checkboxPanel ========
            {
                checkboxPanel.setMinimumSize(new Dimension(15, 10));
                checkboxPanel.setLayout(new GridLayout());

                //---- checkBox1 ----
                checkBox1.setText("12");
                checkBox1.setActionCommand("12");
                checkBox1.addActionListener(e -> checkBox1ActionPerformed(e));
                checkboxPanel.add(checkBox1);

                //---- checkBox2 ----
                checkBox2.setText("42");
                checkBox2.setActionCommand("42");
                checkBox2.addActionListener(e -> checkBox2ActionPerformed(e));
                checkboxPanel.add(checkBox2);

                //---- checkBox3 ----
                checkBox3.setText("201");
                checkBox3.setActionCommand("201");
                checkBox3.addActionListener(e -> checkBox3ActionPerformed(e));
                checkboxPanel.add(checkBox3);
            }
            dialogPane.add(checkboxPanel);

            //======== resultPanel ========
            {
                resultPanel.setLayout(new GridLayout());

                //---- resultLabel ----
                resultLabel.setText("result = 0");
                resultPanel.add(resultLabel);
            }
            dialogPane.add(resultPanel);

            //======== scrollPane1 ========
            {

                //---- tree1 ----
                tree1.setModel(new DefaultTreeModel(
                        new DefaultMutableTreeNode("Root Node") {
                            {
                            }
                        }));
                scrollPane1.setViewportView(tree1);
            }
            dialogPane.add(scrollPane1);

            //======== buttonPanel ========
            {
                buttonPanel.setLayout(new GridLayout());

                //---- addButton ----
                addButton.setText("add");
                buttonPanel.add(addButton);

                //---- removeButton ----
                removeButton.setText("remove");
                buttonPanel.add(removeButton);

                //---- clearButton ----
                clearButton.setText("clear");
                buttonPanel.add(clearButton);
            }
            dialogPane.add(buttonPanel);
        }

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addComponent(dialogPane, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addComponent(dialogPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Igor Vartanian
    private JPanel dialogPane;
    private JPanel checkboxPanel;
    private JCheckBox checkBox1;
    private JCheckBox checkBox2;
    private JCheckBox checkBox3;
    private JPanel resultPanel;
    private JLabel resultLabel;
    private JScrollPane scrollPane1;
    private JTree tree1;
    private JPanel buttonPanel;
    private JButton addButton;
    private JButton removeButton;
    private JButton clearButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
