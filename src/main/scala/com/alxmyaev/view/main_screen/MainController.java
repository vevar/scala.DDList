package main.scala.com.alxmyaev.view.main_screen;

import main.scala.com.alxmyaev.model.DDList.DDList;
import main.scala.com.alxmyaev.model.DDList.IList;
import main.scala.com.alxmyaev.view.dialog.AddElementDialog;
import main.scala.com.alxmyaev.view.dialog.RandomGeneratorDialog;
import main.scala.com.alxmyaev.view.dialog.RemoveElementDialog;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

final public class MainController {

    private static final int WIDTH_WINDOW = 600;
    private static final int HEIGHT_WINDOW = 500;

    private static final int WIDTH_DIALOG = 350;
    private static final int HEIGHT_DIALOG = 150;

    private IList<Integer> modelData;

    private MainScreen mainScreen;

    public MainController() {
        modelData = new DDList<>();
        mainScreen = new MainScreen(this);
        mainScreen.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public void showMainScreen() {
        mainScreen.setSize(new Dimension(WIDTH_WINDOW, HEIGHT_WINDOW));
        mainScreen.setResizable(false);
        mainScreen.setVisible(true);
    }

    void showRandomGeneratorDialog() {
        RandomGeneratorDialog randomGeneratorDialog = new RandomGeneratorDialog(mainScreen, this, false);
        randomGeneratorDialog.setSize(new Dimension(WIDTH_DIALOG, HEIGHT_DIALOG));
        randomGeneratorDialog.setResizable(false);
        randomGeneratorDialog.setVisible(true);
    }

    public void setNewData(final ArrayList<Integer> data) {
        modelData = new DDList<>();
        for (Integer num : data) {
            modelData.add(num);
        }
        mainScreen.updateModel(modelData);
    }

    public void addData(final ArrayList<Integer> data) {
        if (modelData == null) {
            modelData = new DDList<>();
        }
        for (Integer num : data) {
            modelData.add(num);
        }
        mainScreen.updateModel(modelData);
    }

    void showAddElementDialog() {
        final AddElementDialog addElementDialog = new AddElementDialog(this, mainScreen, false);
        addElementDialog.setSize(new Dimension(WIDTH_DIALOG, HEIGHT_DIALOG));
        addElementDialog.setResizable(false);
        addElementDialog.setVisible(true);
    }

    void showRemoveElementDialog() {
        final RemoveElementDialog removeElementDialog = new RemoveElementDialog(this, mainScreen, false);
        removeElementDialog.setSize(new Dimension(WIDTH_DIALOG, HEIGHT_DIALOG));
        removeElementDialog.setResizable(false);
        removeElementDialog.setVisible(true);
    }

    void sortData() {

    }

    public void addNewElementToData(int element) {
        modelData.add(element);
        mainScreen.updateModel(modelData);
    }

    public void removeElementByIndex(int index) {
        modelData.remove(index);
        mainScreen.updateModel(modelData);
    }
}
