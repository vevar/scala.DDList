package main.scala.com.alxmyaev.view.main_screen;

import main.scala.com.alxmyaev.model.DDList.DDList;
import main.scala.com.alxmyaev.model.DDList.IList;
import main.scala.com.alxmyaev.view.dialog.*;
import scala.math.Ordering;

import javax.swing.*;
import java.awt.*;
import java.io.*;
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

    public void setModelData(final IList<Integer> data) {
        modelData = data;
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
        modelData = modelData.sort(new Ordering<Integer>() {
            @Override
            public int compare(Integer x, Integer y) {
                return x - y;
            }
        });
        mainScreen.updateModel(modelData);
    }

    public void addNewElementToData(int element) {
        modelData.add(element);
        mainScreen.updateModel(modelData);
    }

    public void removeElementByIndex(int index) {
        modelData.remove(index);
        mainScreen.updateModel(modelData);
    }

    public void saveDataToFile(final IList list, final File file) throws IOException {
        final FileOutputStream fileOutputStream = new FileOutputStream(file);
        final ObjectOutputStream outputStream = new ObjectOutputStream(fileOutputStream);
        outputStream.writeObject(list);

        outputStream.close();
        fileOutputStream.close();
    }

    public IList loadDataFromFile(final File file) throws IOException, ClassNotFoundException {
        final FileInputStream fileInputStream = new FileInputStream(file);
        final ObjectInputStream inputStream = new ObjectInputStream(fileInputStream);
        final IList data = (IList) inputStream.readObject();
        inputStream.close();
        fileInputStream.close();

        return data;
    }

    void showSaveDataDialog() {
        final SaveDataDialog saveDataDialog = new SaveDataDialog(this, modelData, mainScreen, true);
        saveDataDialog.setSize(new Dimension(WIDTH_DIALOG, HEIGHT_DIALOG));
        saveDataDialog.setVisible(true);
    }

    void showLoadDialog() {
        final LoadDataDialog loadDataDialog = new LoadDataDialog(this, mainScreen, true);
        loadDataDialog.setSize(new Dimension(WIDTH_DIALOG, HEIGHT_DIALOG));
        loadDataDialog.setVisible(true);
    }
}
