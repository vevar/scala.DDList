package main.scala.com.alxmyaev.view.dialog;

import main.scala.com.alxmyaev.view.main_screen.MainController;

import javax.swing.*;
import java.awt.*;

public class RemoveElementDialog extends JDialog {

    private static final String TITLE_DIALOG = "Remove element";

    private static final String TEXT_INPUT_INDEX = "Input index: ";
    private static final String TEXT_REMOVE = "Remove";

    public RemoveElementDialog(final MainController controller, final Frame owner, final boolean modal) {
        super(owner, TITLE_DIALOG, modal);

        final JLabel labelInputIndex = new JLabel(TEXT_INPUT_INDEX);
        add(labelInputIndex, BorderLayout.WEST);

        final JTextField textFieldInputIndex = new JTextField();
        add(textFieldInputIndex, BorderLayout.CENTER);

        final JButton buttonRemove = new JButton(TEXT_REMOVE);
        buttonRemove.addActionListener(e ->
                controller.removeElementByIndex(Integer.parseInt(textFieldInputIndex.getText()))
        );
        add(buttonRemove, BorderLayout.PAGE_END);

    }

}
