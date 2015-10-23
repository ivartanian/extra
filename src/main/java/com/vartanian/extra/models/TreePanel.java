package com.vartanian.extra.models;

import com.vartanian.extra.utils.Utils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeSelectionModel;
import java.awt.*;

/**
 * Created by super on 10/22/15.
 */
public class TreePanel extends JPanel {

    private static final Logger LOG = LogManager.getLogger(TreePanel.class);

    private String textFont;
    private JTree tree;
    private Utils utils = new Utils();

    public TreePanel() {
        this(null);
    }

    public TreePanel(String textFont) {
        super(new GridLayout(1, 0));
        this.textFont = textFont;
        initialize();
    }

    private void initialize() {
        DefaultMutableTreeNode top = new DefaultMutableTreeNode("Main node");
        createNodes(top);

        tree = new JTree(top);
        Font font = null;
        boolean find = false;
        if (this.textFont != null && !(find = utils.findFont(this.textFont))){
            String path = new StringBuilder("fonts/").append(this.textFont.toLowerCase()).append(".ttf").toString();
            font = utils.createFont(getClass().getClassLoader(), path);
            find = utils.registerFont(font);
        }

        if (find && font != null){
            FontUIResource fontUIResource = new FontUIResource(font.getFontName(), 0, 14);
            tree.setFont(fontUIResource);
        }

        tree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);

        JScrollPane treeView = new JScrollPane(tree);

        add(treeView);
    }

    private void createNodes(DefaultMutableTreeNode top) {
        DefaultMutableTreeNode group;
        DefaultMutableTreeNode item;

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