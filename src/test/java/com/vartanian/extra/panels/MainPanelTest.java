package com.vartanian.extra.panels;

import org.fest.swing.fixture.FrameFixture;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

/**
 * Created by super on 10/22/15.
 */
@Ignore
public class MainPanelTest {

    private FrameFixture mainPanelTest;

    @Before
    public void setUp() {
        mainPanelTest = new FrameFixture(new FrontPanel());
    }

    @After
    public void tearDown() {

        mainPanelTest.cleanUp();
    }

    @Test
    public void checkbox12Test() {

        mainPanelTest.checkBox("12").check();
        mainPanelTest.label("resultLabel").requireText("12");

    }
    @Test
    public void checkbox42Test() {

        mainPanelTest.checkBox("42").check();
        mainPanelTest.label("resultLabel").requireText("42");

    }
    @Test
    public void checkbox201Test() {

        mainPanelTest.checkBox("201").check();
        mainPanelTest.label("resultLabel").requireText("201");

    }

    @Test
    public void checkbox12_42Test() {

        mainPanelTest.checkBox("12").check();
        mainPanelTest.checkBox("42").check();
        mainPanelTest.label("resultLabel").requireText("54");

    }
    @Test
    public void checkbox12_201Test() {

        mainPanelTest.checkBox("12").check();
        mainPanelTest.checkBox("201").check();
        mainPanelTest.label("resultLabel").requireText("213");

    }
    @Test
    public void checkbox42_201Test() {

        mainPanelTest.checkBox("42").check();
        mainPanelTest.checkBox("201").check();
        mainPanelTest.label("resultLabel").requireText("243");

    }
    @Test
    public void checkbox12_42_201Test() {

        mainPanelTest.checkBox("12").check();
        mainPanelTest.checkBox("42").check();
        mainPanelTest.checkBox("201").check();
        mainPanelTest.label("resultLabel").requireText("255");

    }

}
