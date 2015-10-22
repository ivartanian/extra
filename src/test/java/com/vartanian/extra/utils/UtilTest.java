package com.vartanian.extra.utils;

import com.vartanian.extra.utils.Utils;
import org.fest.swing.fixture.FrameFixture;
import org.junit.*;

import java.awt.*;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

/**
 * Created by super on 10/22/15.
 */
public class UtilTest {

    private static Font[] allFonts;
    private Utils mockUtil;

    @BeforeClass
    public static void beforeClass() {
        allFonts = GraphicsEnvironment.getLocalGraphicsEnvironment().getAllFonts();
    }

    @Before
    public void before() {
        mockUtil = spy(Utils.class);
        when(mockUtil.getAllFonts()).thenReturn(allFonts);
    }

    @Test
    public void existFont() {
        Assert.assertTrue(mockUtil.findFont(allFonts[0].getFontName()));
    }

    @Test
    public void notExistFont() {
        Assert.assertFalse(mockUtil.findFont("-----"));
    }

    @Test
    public void nullFont() {
        Assert.assertFalse(mockUtil.findFont(null));
    }

}
