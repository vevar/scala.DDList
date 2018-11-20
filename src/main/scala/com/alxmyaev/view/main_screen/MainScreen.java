package main.scala.com.alxmyaev.view.main_screen;

import javax.swing.*;
import java.awt.*;

final class MainScreen extends JFrame {

    private final static String TEXT_BUTTON_SAVE = "Save data";
    private final static String TEXT_BUTTON_LOAD = "Load data";

    private final static String TEXT_BUTTON_ADD_ELEMENT = "Add new element";
    private final static String TEXT_BUTTON_REMOVE_ELEMENT = "Remove element";
    private final static String TEXT_BUTTON_RANDOM_GENERATOR = "Random generator";
    private final static String TEXT_BUTTON_SORT = "Sort data";


    MainScreen(final MainController mainController) {
        final JPanel mainPanel = new JPanel();
        setContentPane(mainPanel);
        mainPanel.setLayout(new BorderLayout());

        final JPanel modelPanel = new JPanel();

        modelPanel.setLayout(new BorderLayout());
        final JTextArea textArea = new JTextArea();
        modelPanel.add(textArea, BorderLayout.CENTER);
        final JPanel controlModelPanel = new JPanel();
        controlModelPanel.setLayout(new FlowLayout());
        final JButton buttonRandomGenerationData = new JButton(TEXT_BUTTON_RANDOM_GENERATOR);
        buttonRandomGenerationData.addActionListener(e -> mainController.showRandomGeneratorScreen());
        controlModelPanel.add(buttonRandomGenerationData);
        final JButton buttonAddElement = new JButton(TEXT_BUTTON_ADD_ELEMENT);
        controlModelPanel.add(buttonAddElement);
        final JButton buttonRemoveElement = new JButton(TEXT_BUTTON_REMOVE_ELEMENT);
        controlModelPanel.add(buttonRemoveElement);
        final JButton buttonSort = new JButton(TEXT_BUTTON_SORT);
        controlModelPanel.add(buttonSort);

        modelPanel.add(controlModelPanel, BorderLayout.PAGE_END);

        mainPanel.add(modelPanel, BorderLayout.CENTER);

        final JPanel endPanel = new JPanel();
        endPanel.setLayout(new FlowLayout());

        final JButton buttonSaveData = new JButton(TEXT_BUTTON_SAVE);
        final JButton buttonLoadData = new JButton(TEXT_BUTTON_LOAD);
        endPanel.add(buttonSaveData);
        endPanel.add(buttonLoadData);

        mainPanel.add(endPanel, BorderLayout.PAGE_END);
    }
}
