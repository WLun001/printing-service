package com.printing.ui;

import com.printing.domain.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ContainerAdapter;

public class PrintForm {
    private JPanel panel1;
    private JButton printButton;
    private JCheckBox highQualityPaperCheckBox;
    private JTextField textField1;
    private JCheckBox designEffectCheckBox;
    private JTextArea price;
    private JButton computeRequestButton;
    private JButton addRequestButton;
    private AppController controller = new AppController();
    private IPrintable printer = new PhotoPrinter();

    public PrintForm() {
        printButton.addActionListener(e -> {

            int dialog = JOptionPane
                    .showConfirmDialog(null,
                            "Do you want start printing?",
                            "Attention", JOptionPane.YES_NO_OPTION);

            if(dialog == 0) {
                controller.setPrinter(printer);
                controller.sendToPrinter();
            }

        });
        addRequestButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int quantity = Integer.valueOf(textField1.getText());
                boolean hasHighQualityPaper = highQualityPaperCheckBox.isSelected();
                boolean hasDesignEffect = designEffectCheckBox.isSelected();
                getUserInput(quantity, hasHighQualityPaper, hasDesignEffect);

                textField1.setText("");
                highQualityPaperCheckBox.setSelected(false);
                designEffectCheckBox.setSelected(false);
            }
        });

        computeRequestButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int quantity = Integer.valueOf(textField1.getText());
                boolean hasHighQualityPaper = highQualityPaperCheckBox.isSelected();
                boolean hasDesignEffect = designEffectCheckBox.isSelected();
                getUserInput(quantity, hasHighQualityPaper, hasDesignEffect);

                textField1.setText("");
                highQualityPaperCheckBox.setSelected(false);
                designEffectCheckBox.setSelected(false);

                controller.submitRequest();
                price.setText("Total Charge: RM " + String.valueOf(controller.getTotalCharge()));
            }
        });
    }

    private void getUserInput(int quantity, boolean hasHighQuality, boolean hasDesignEffect) {
        controller.addRequest(new Request(quantity,hasHighQuality, hasDesignEffect));
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
