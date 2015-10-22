package com.vartanian.extra.models;

import com.vartanian.extra.panels.MainPanel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeSelectionModel;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by super on 10/22/15.
 */
public class TreePanel extends JPanel {

    private static final Logger LOG = LogManager.getLogger(TreePanel.class);

    private JTree tree;

    public TreePanel() {

        super(new GridLayout(1, 0));

        DefaultMutableTreeNode top = new DefaultMutableTreeNode("Main node");
        createNodes(top);

        tree = new JTree(top);
        try (InputStream fontStream = getClass().getClassLoader().getResourceAsStream("fonts/festus.ttf");){
            Font font = Font.createFont(Font.PLAIN, fontStream);
            setFont(font);
            tree.setFont(font);
        } catch (FontFormatException e) {
            LOG.error(e);
        } catch (IOException e) {
            LOG.error(e);
        }
        tree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);

        JScrollPane treeView = new JScrollPane(tree);

        add(treeView);
    }

    private void createNodes(DefaultMutableTreeNode top) {
        DefaultMutableTreeNode group = null;
        DefaultMutableTreeNode item = null;

        group = new DefaultMutableTreeNode("group1");
        top.add(group);

        item = new DefaultMutableTreeNode("item1");
        group.add(item);

        item = new DefaultMutableTreeNode("item2");
        group.add(item);

        item = new DefaultMutableTreeNode("item3");
        group.add(item);

        item = new DefaultMutableTreeNode("item4");
        group.add(item);

        group = new DefaultMutableTreeNode("group2");
        top.add(group);

        DefaultMutableTreeNode subGroup = new DefaultMutableTreeNode("group22");
        group.add(subGroup);

        item = new DefaultMutableTreeNode("item8");
        subGroup.add(item);

        item = new DefaultMutableTreeNode("item9");
        subGroup.add(item);

        item = new DefaultMutableTreeNode("item10");
        subGroup.add(item);

        item = new DefaultMutableTreeNode("item5");
        group.add(item);

        item = new DefaultMutableTreeNode("item6");
        group.add(item);

        item = new DefaultMutableTreeNode("item7");
        group.add(item);

    }

}