package com.stockControl.view;

import javax.swing.*;

/**
 * @author GromHoll
 */
public class StockMainFrame extends JFrame {

    private JButton findButton;
    private JButton resetButton;
    private JFormattedTextField idField;
    private JComboBox conditionCombo;
    private JFormattedTextField priceField;
    private JComboBox typeCombo;
    private JTable ResultPanel;
    private JTextField nameField;
    private JLabel ResultCountPanel;
    private JPanel mainPanel;

    public static void main(String[] args) {
        JFrame frame = new JFrame("StockMainFrame");
        frame.setContentPane(new StockMainFrame().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    private String idFilterValue = "";
    private String priceFilterValue = "";
    private String nameFilterValue = "";

    public String getIdFilterValue() {
        return idFilterValue;
    }

    public void setIdFilterValue(final String idFilterValue) {
        this.idFilterValue = idFilterValue;
    }

    public String getPriceFilterValue() {
        return priceFilterValue;
    }

    public void setPriceFilterValue(final String priceFilterValue) {
        this.priceFilterValue = priceFilterValue;
    }

    public String getNameFilterValue() {
        return nameFilterValue;
    }

    public void setNameFilterValue(final String nameFilterValue) {
        this.nameFilterValue = nameFilterValue;
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }

    public void setData(StockMainFrame data) {
        idField.setText(data.getIdFilterValue());
        priceField.setText(data.getPriceFilterValue());
        nameField.setText(data.getNameFilterValue());
    }

    public void getData(StockMainFrame data) {
        data.setIdFilterValue(idField.getText());
        data.setPriceFilterValue(priceField.getText());
        data.setNameFilterValue(nameField.getText());
    }

    public boolean isModified(StockMainFrame data) {
        if (idField.getText() != null ? !idField.getText().equals(data.getIdFilterValue()) : data.getIdFilterValue() != null)
            return true;
        if (priceField.getText() != null ? !priceField.getText().equals(data.getPriceFilterValue()) : data.getPriceFilterValue() != null)
            return true;
        if (nameField.getText() != null ? !nameField.getText().equals(data.getNameFilterValue()) : data.getNameFilterValue() != null)
            return true;
        return false;
    }
}
