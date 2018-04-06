package com.printing.ui;

import com.printing.domain.AppController;
import com.printing.domain.Order;
import com.printing.domain.OrderList;

import javax.swing.*;

public class PrintForm {
    private JPanel panel1;
    private JButton printButton;
    private JCheckBox highQualityPaperCheckBox;
    private JTextField textField1;
    private JCheckBox designEffectCheckBox;
    private JTextArea price;

    public PrintForm() {
        printButton.addActionListener(e -> {
            int quantity = Integer.valueOf(textField1.getText());
            boolean hasHighQualityPaper = highQualityPaperCheckBox.isSelected();
            boolean hasDesignEffect = designEffectCheckBox.isSelected();
            AppController controller = new AppController();
            for (int i = 0; i < quantity; i++){
                controller.addOrder(new Order(hasHighQualityPaper, hasDesignEffect));
            }
            controller.submitOrder();
            price.setText("RM: " + String.valueOf(controller.getTotalCharge()));
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("PrintForm");
        frame.setContentPane(new PrintForm().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(500,500);
        frame.setVisible(true);
    }
}
