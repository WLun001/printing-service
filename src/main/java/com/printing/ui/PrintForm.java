package com.printing.ui;

import com.printing.domain.AppController;
import com.printing.domain.Order;
import com.printing.domain.Request;

import javax.swing.*;

public class PrintForm {
    private JPanel panel1;
    private JButton printButton;
    private JCheckBox highQualityPaperCheckBox;
    private JTextField textField1;
    private JCheckBox designEffectCheckBox;
    private JTextArea price;
    private AppController controller = new AppController();

    public PrintForm() {
        printButton.addActionListener(e -> {
            int quantity = Integer.valueOf(textField1.getText());
            boolean hasHighQualityPaper = highQualityPaperCheckBox.isSelected();
            boolean hasDesignEffect = designEffectCheckBox.isSelected();
            controller.addRequest(new Request(quantity,hasHighQualityPaper, hasDesignEffect));

            int dialog = JOptionPane
                    .showConfirmDialog(null,
                            "Do you want to add more request?",
                            "Attention", JOptionPane.YES_NO_OPTION);

            if (dialog == 0) {
                textField1.setText("");
                highQualityPaperCheckBox.setSelected(false);
                designEffectCheckBox.setSelected(false);
            } else {
                controller.submitRequest();
                price.setText("Total Charge: RM " + String.valueOf(controller.getTotalCharge()));
                controller.sendToPrinter();
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("PrintForm");
        frame.setContentPane(new PrintForm().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(500, 500);
        frame.setVisible(true);
    }
}
