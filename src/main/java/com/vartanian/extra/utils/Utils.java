package com.vartanian.extra.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.swing.plaf.FontUIResource;
import java.awt.*;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by vartanian on 22.10.2015.
 */
public class Utils {

    private static final Logger LOG = LogManager.getLogger(Utils.class);

    public boolean findFont(String fontName) {
        if (fontName == null){
            return false;
        }
        Font[] fonts = getAllFonts();
        for (int i = 0; i < fonts.length; i++) {
            if (fontName.equalsIgnoreCase(fonts[i].getFontName())) {
                return true;
            }
        }
        return false;
    }

    Font[] getAllFonts() {
        return GraphicsEnvironment.getLocalGraphicsEnvironment().getAllFonts();
    }

    public boolean registerFont(Font font) {
        if (font == null){
            return false;
        }
        GraphicsEnvironment localGraphicsEnvironment = GraphicsEnvironment.getLocalGraphicsEnvironment();
        return localGraphicsEnvironment.registerFont(font);
    }

    public Font createFont(ClassLoader classLoader, String path) {
        try (InputStream fontStream = classLoader.getResourceAsStream(path);){
            return FontUIResource.createFont(Font.PLAIN, fontStream);
        } catch (FontFormatException e) {
            LOG.error("Bad font format", e);
        } catch (IOException e) {
            LOG.error("Couldn't find file " + path, e);
        }
        return null;
    }

    public void changeBounds(Component component, int width, int height) {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int locationX = (screenSize.width - width);
        int locationY = height;
        component.setBounds(locationX, locationY, width, screenSize.height);
    }



}
