package Convertor;

import Units.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

import static javax.swing.JOptionPane.*;

public class Form {
    private JPanel contentPanel; // Основна панель
    private JButton clearButton;
    private JButton convertButton;
    private JComboBox<String> measurementComboBox;
    private JComboBox<String> unitsComboBox;
    private JTextField fromLabel;
    private JTextField toLabel;
    private JLabel equalsSign;

    private Unit unit;

    public Form() {
        JFrame frame = new JFrame("Unit Converter"); // Назва вікна
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Закриття програми при закритті вікна
        frame.setSize(800, 600); // Розмір вікна
        frame.setContentPane(getContentPanel());
        frame.setLocationRelativeTo(null);
        equalsSign.setFont(new Font(equalsSign.getFont().getFontName(), Font.BOLD, 36));


        clearButton.addActionListener(this::clearText);

        convertButton.addActionListener(this::convertUnits);

        measurementComboBox.addActionListener(this::updateUnitsComboBox);

        frame.setVisible(true);
    }

    public JPanel getContentPanel() {
        return contentPanel;
    }

    private void createUIComponents() {
        measurementComboBox = new JComboBox<>(new String[]{
                "Area",
                "Distance",
                "Energy",
                "Pressure",
                "Speed",
                "Temperature",
                "Time",
                "Volume",
                "Weight"});
        measurementComboBox.setSelectedIndex(-1);
    }

    private void clearText(ActionEvent e) {
        fromLabel.setText("");
        toLabel.setText("");
    }

    private void convertUnits(ActionEvent e) {
        try {
            String text = fromLabel.getText();
            double i = Double.parseDouble(text);
            toLabel.setText(String.valueOf(unit.convert(i, unitsComboBox.getItemAt(unitsComboBox.getSelectedIndex()))));
        } catch (NumberFormatException ex) {
            showMessageDialog(null, // Вікно-контейнер
                    "Your input has invalid characters",
                    "Error",
                    ERROR_MESSAGE // Піктограма
            );
        }

    }

    private void updateUnitsComboBox(ActionEvent e) {
        unitsComboBox.removeAllItems();
        switch (measurementComboBox.getItemAt(measurementComboBox.getSelectedIndex())) {
            case "Area" -> unit = new Area();
            case "Distance" -> unit = new Distance();
            case "Energy" -> unit = new Energy();
            case "Pressure" -> unit = new Pressure();
            case "Speed" -> unit = new Speed();
            case "Temperature" -> unit = new Temperature();
            case "Time" -> unit = new Time();
            case "Volume" -> unit = new Volume();
            case "Weight" -> unit = new Weight();
        }
        for (String key : unit.getUnits()) {
            unitsComboBox.addItem(key);
        }
    }
}