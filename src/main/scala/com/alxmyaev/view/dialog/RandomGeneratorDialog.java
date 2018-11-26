package main.scala.com.alxmyaev.view.dialog;


import main.scala.com.alxmyaev.model.DDList.DDList;
import main.scala.com.alxmyaev.view.main_screen.MainController;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class RandomGeneratorDialog extends JDialog {
    private static final String TITLE_DIALOG = "Random generator";

    private static final String TEXT_LABEL_RANGE = "Range:";
    private static final String TEXT_LABEL_FROM = "From:";
    private static final String TEXT_LABEL_TO = "To:";

    private static final String TEXT_LABEL_SIZE_DATA = "Size data";

    private static final String TEXT_BUTTON_GENERATE_NEW_DATA = "Generate new data";
    private static final String TEXT_BUTTON_GENERATE_INTO_EXIST_DATA = "Generate into exist data";

    private static final int DEFAULT_FROM = 0;
    private static final int DEFAULT_TO = 100;
    private static final int DEFAULT_SIZE_DATA = 20;


    public RandomGeneratorDialog(final JFrame owner, final MainController mainController, final  boolean modal) {
        super(owner, TITLE_DIALOG, modal);
        setLayout(new GridBagLayout());

        final GridBagConstraints gridBagConstraints = new GridBagConstraints();

        final JLabel labelRange = new JLabel(TEXT_LABEL_RANGE);
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        add(labelRange, gridBagConstraints);

        final JLabel labelFrom = new JLabel(TEXT_LABEL_FROM);
        gridBagConstraints.weightx = 1;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.weightx = 0.5;
        add(labelFrom, gridBagConstraints);

        final JTextField textFieldFrom = new JTextField(String.valueOf(DEFAULT_FROM));
        gridBagConstraints.gridx = 1;
        gridBagConstraints.weightx = 0.5;
        add(textFieldFrom, gridBagConstraints);

        final JLabel labelTo = new JLabel(TEXT_LABEL_TO);
        gridBagConstraints.gridx = 2;
        gridBagConstraints.weightx = 0.5;
        add(labelTo, gridBagConstraints);

        final JTextField textFieldTo = new JTextField(String.valueOf(DEFAULT_TO));
        gridBagConstraints.gridx = 3;
        gridBagConstraints.weightx = 0.2;
        add(textFieldTo, gridBagConstraints);

        final JLabel labelSizeData = new JLabel(TEXT_LABEL_SIZE_DATA);
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.weightx = 0.5;
        add(labelSizeData, gridBagConstraints);

        final JTextField textFieldSizeData = new JTextField(String.valueOf(DEFAULT_SIZE_DATA));
        gridBagConstraints.gridx = 1;
        gridBagConstraints.weightx = 0.5;
        add(textFieldSizeData, gridBagConstraints);

        final JButton buttonGenerateNewData = new JButton(TEXT_BUTTON_GENERATE_NEW_DATA);
        buttonGenerateNewData.addActionListener(e -> {
            final int from = Integer.parseInt(textFieldFrom.getText());
            final int to = Integer.parseInt(textFieldTo.getText());
            final int size = Integer.parseInt(textFieldSizeData.getText());
            DDList<Integer> data = new DDList<>();
            for (int i = 0; i < size; i++) {
                data.add((int) (from + Math.random() * to));
            }
            mainController.setModelData(data);
            dispose();
        });
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.weightx = 0;
        add(buttonGenerateNewData, gridBagConstraints);

        final JButton buttonGenerateTOExistData = new JButton(TEXT_BUTTON_GENERATE_INTO_EXIST_DATA);
        buttonGenerateTOExistData.addActionListener(e -> {
            final int from = Integer.parseInt(textFieldFrom.getText());
            final int to = Integer.parseInt(textFieldTo.getText());
            final int size = Integer.parseInt(textFieldSizeData.getText());
            ArrayList<Integer> data = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                data.add((int) (from + Math.random() * to));
            }
            mainController.addData(data);
            dispose();
        });
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.weightx = 0;
        add(buttonGenerateTOExistData, gridBagConstraints);
    }


}
