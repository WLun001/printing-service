package com.printing.ui;

import com.printing.domain.*;

import javax.swing.*;

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
                JOptionPane.showMessageDialog(null,"Start printing...");
            }

        });
        addRequestButton.addActionListener(e -> {
            try {
                int quantity = Integer.valueOf(textField1.getText());
                boolean hasHighQualityPaper = highQualityPaperCheckBox.isSelected();
                boolean hasDesignEffect = designEffectCheckBox.isSelected();
                addRequest(quantity, hasHighQualityPaper, hasDesignEffect);
                price.setText("Current request : " + controller.getNumberOfRequest());
            } catch (NumberFormatException error){
                JOptionPane.showMessageDialog(null, "Quantity must be an integer");

            }catch (IllegalArgumentException error){
                JOptionPane.showMessageDialog(null, error.getMessage());
            } finally {
                clearInput();
            }
        });

        computeRequestButton.addActionListener(e -> {
            if (controller.getNumberOfRequest() == 0)
                JOptionPane.showMessageDialog(null,"No request to compute");
            else {
                controller.submitRequest();
                price.setText("Total Charge: RM " + String.valueOf(controller.getTotalCharge()));
                clearInput();
            }
        });
    }

    private void addRequest(int quantity, boolean hasHighQuality, boolean hasDesignEffect) {
        controller.addRequest(new Request(quantity,hasHighQuality, hasDesignEffect));
        JOptionPane.showMessageDialog(null,"Request is added successfully!");
    }

    private void clearInput(){
        textField1.setText("");
        highQualityPaperCheckBox.setSelected(false);
        designEffectCheckBox.setSelected(false);
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
