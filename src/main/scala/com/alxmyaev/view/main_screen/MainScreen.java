package main.scala.com.alxmyaev.view.main_screen;

import main.scala.com.alxmyaev.model.DDList.IList;

import javax.swing.*;
import java.awt.*;

final class MainScreen extends JFrame {

    private final static String TEXT_BUTTON_SAVE = "Save data";
    private final static String TEXT_BUTTON_LOAD = "Load data";

    private final static String TEXT_BUTTON_ADD_ELEMENT = "Add new element";
    private final static String TEXT_BUTTON_REMOVE_ELEMENT = "Remove element";
    private final static String TEXT_BUTTON_RANDOM_GENERATOR = "Random generator";
    private final static String TEXT_BUTTON_SORT = "Sort data";


    private final JTextArea textArea;

    MainScreen(final MainController mainController) {
        final JPanel mainPanel = new JPanel();
        setContentPane(mainPanel);
        mainPanel.setLayout(new BorderLayout());

        final JPanel modelPanel = new JPanel();
        modelPanel.setLayout(new BorderLayout());

        textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        modelPanel.add(textArea, BorderLayout.CENTER);

        final JPanel controlModelPanel = new JPanel();
        controlModelPanel.setLayout(new FlowLayout());

        final JButton buttonRandomGenerationData = new JButton(TEXT_BUTTON_RANDOM_GENERATOR);
        buttonRandomGenerationData.addActionListener(e -> mainController.showRandomGeneratorDialog());
        controlModelPanel.add(buttonRandomGenerationData);

        final JButton buttonAddElement = new JButton(TEXT_BUTTON_ADD_ELEMENT);
        buttonAddElement.addActionListener(e -> mainController.showAddElementDialog());
        controlModelPanel.add(buttonAddElement);

        final JButton buttonRemoveElement = new JButton(TEXT_BUTTON_REMOVE_ELEMENT);
        buttonRemoveElement.addActionListener(e -> mainController.showRemoveElementDialog());
        controlModelPanel.add(buttonRemoveElement);

        final JButton buttonSort = new JButton(TEXT_BUTTON_SORT);
        buttonSort.addActionListener(e -> mainController.sortData());
        controlModelPanel.add(buttonSort);

        modelPanel.add(controlModelPanel, BorderLayout.PAGE_END);

        mainPanel.add(modelPanel, BorderLayout.CENTER);

        final JPanel endPanel = new JPanel();
        endPanel.setLayout(new FlowLayout());

        final JButton buttonSaveData = new JButton(TEXT_BUTTON_SAVE);
        buttonSaveData.addActionListener(e-> mainController.showSaveDataDialog());
        final JButton buttonLoadData = new JButton(TEXT_BUTTON_LOAD);
        buttonLoadData.addActionListener(e -> mainController.showLoadDialog());
        endPanel.add(buttonSaveData);
        endPanel.add(buttonLoadData);

        mainPanel.add(endPanel, BorderLayout.PAGE_END);
    }

    void updateModel(final IList<Integer> modelData) {
        textArea.setText("");
        final StringBuilder text = new StringBuilder();

//        modelData.forEach(e -> {
//            text.append(e).append(" ");
//            return null;
//        });
        for (int i = 0; i < modelData.getSize(); i++) {
            text.append(modelData.get(i)).append(" ");
        }
        textArea.setText(text.toString());
    }
}
