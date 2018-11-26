package main.scala.com.alxmyaev.view.dialog;


import main.scala.com.alxmyaev.view.main_screen.MainController;

import javax.swing.*;
import java.awt.*;

public class AddElementDialog extends JDialog {

    private static final String TITLE_DIALOG = "Add new element";

    private static final String TEXT_INPUT_ELEMENT = "Input element: ";
    private static final String TEXT_ADD = "Add";

    public AddElementDialog(final MainController controller, final JFrame owner, final boolean modal) {
        super(owner, TITLE_DIALOG, modal);

        final JLabel labelInputElement = new JLabel(TEXT_INPUT_ELEMENT);
        add(labelInputElement, BorderLayout.WEST);

        final JTextField textFieldInputElement = new JTextField();
        add(textFieldInputElement, BorderLayout.CENTER);

        final JButton buttonAdd = new JButton(TEXT_ADD);
        buttonAdd.addActionListener(
                e -> {
                    controller.addNewElementToData(Integer.parseInt(textFieldInputElement.getText()));
                    dispose();
                }
        );

        add(buttonAdd,BorderLayout.PAGE_END);
    }


}
