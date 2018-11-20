package main.scala.com.alxmyaev.view.main_screen;

import java.awt.*;

final public class MainController {

    private static final int WIDTH_WINDOW = 600;
    private static final int HEIGHT_WINDOW = 500;

    public void createScreen() {
        final MainScreen screen = new MainScreen(this);
        screen.setSize(new Dimension(WIDTH_WINDOW, HEIGHT_WINDOW));
        screen.setResizable(false);
        screen.setVisible(true);
    }

    void showRandomGeneratorScreen() {

    }
}
