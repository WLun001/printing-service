package com.printing;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
            OrderList orderList = new OrderList();
            for (int i = 0; i < quantity; i++){
                orderList.addOrder(hasHighQualityPaper, hasDesignEffect);
            }
            orderList.submitOrder();
            price.setText("RM: " + String.valueOf(orderList.getTotalCharge()));
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
