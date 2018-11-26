package main.scala.com.alxmyaev.view.dialog;

import main.scala.com.alxmyaev.model.DDList.IList;
import main.scala.com.alxmyaev.view.main_screen.MainController;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class SaveDataDialog extends JDialog {

    private final static String TITLE_DIALOG = "Save data";

    private final static String TEXT_LABEL_PATH = "Path";

    private final static String TEXT_BUTTON_SAVE = "Save";

    private final static String TEXT_LABEL_INFO_SUCCESS = "Success!";
    private final static String TEXT_LABEL_INFO_ERROR = "ERROR!";

    private final JLabel labelInfo;
    private final MainController mainController;
    private final JTextField textFieldPath;

    private final IList data;

    public SaveDataDialog(final MainController mainController, final IList data, final Frame owner, final boolean modal) {
        super(owner, TITLE_DIALOG, modal);

        this.mainController = mainController;
        this.data = data;

        labelInfo = new JLabel(" ");
        add(labelInfo, BorderLayout.PAGE_START);

        add(new JLabel(TEXT_LABEL_PATH), BorderLayout.WEST);

        textFieldPath = new JTextField();
        add(textFieldPath, BorderLayout.CENTER);

        final JButton buttonSave = new JButton(TEXT_BUTTON_SAVE);
        buttonSave.addActionListener(e -> {
            final String path = textFieldPath.getText();
            if (!path.isEmpty()) {
                final File file = new File(path);
                try {
                    if (file.createNewFile()) {
                        this.mainController.saveDataToFile(this.data, file);
                        labelInfo.setText(TEXT_LABEL_INFO_SUCCESS);
                    }
                } catch (IOException e1) {
                    e1.printStackTrace();
                    labelInfo.setText(TEXT_LABEL_INFO_ERROR);
                }
            }
        });

        add(buttonSave, BorderLayout.PAGE_END);
    }


}
