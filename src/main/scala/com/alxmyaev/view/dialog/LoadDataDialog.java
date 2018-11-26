package main.scala.com.alxmyaev.view.dialog;

import main.scala.com.alxmyaev.model.DDList.IList;
import main.scala.com.alxmyaev.view.main_screen.MainController;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class LoadDataDialog extends JDialog {

    private final static String TITLE_DIALOG = "Load data";

    private final static String TEXT_LABEL_PATH = "Path";

    private final static String TEXT_BUTTON_LOAD = "Load";

    private final static String TEXT_LABEL_INFO_ERROR = "ERROR!";

    private final JLabel labelInfo;
    private final MainController mainController;
    private final JTextField textFieldPath;

    public LoadDataDialog(final MainController mainController, final Frame owner, final boolean modal) {
        super(owner, TITLE_DIALOG, modal);

        this.mainController = mainController;

        labelInfo = new JLabel(" ");
        add(labelInfo, BorderLayout.PAGE_START);

        add(new JLabel(TEXT_LABEL_PATH), BorderLayout.WEST);

        textFieldPath = new JTextField();
        add(textFieldPath, BorderLayout.CENTER);
        final JButton buttonSave = new JButton(TEXT_BUTTON_LOAD);
        buttonSave.addActionListener(e -> {
            final String path = textFieldPath.getText();
            if (!path.isEmpty()) {
                final File file = new File(path);
                if (file.exists()) {
                    final IList iList;
                    try {
                        iList = this.mainController.loadDataFromFile(file);
                        this.mainController.setModelData(iList);
                        dispose();
                    } catch (IOException | ClassNotFoundException e1) {
                        e1.printStackTrace();
                        textFieldPath.setText(TEXT_LABEL_INFO_ERROR);
                    }
                }
            }
        });

        add(buttonSave, BorderLayout.PAGE_END);

    }
}
