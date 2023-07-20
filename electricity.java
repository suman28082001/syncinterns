import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class electricity extends JFrame {
    private JTextField textFieldName;
    private JTextField textFieldUnits;
    private JButton buttonCalculate;
    private JLabel labelResult;

    public electricity() {
        setTitle("Electricity Billing System");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create components
        JLabel labelName = new JLabel("Name:");
        JLabel labelUnits = new JLabel("\nUnits:");
        textFieldName = new JTextField(10);
        textFieldUnits = new JTextField(10);
        buttonCalculate = new JButton("Calculate");
        labelResult = new JLabel();

        // Set layout
        setLayout(new FlowLayout());

        // Add components to the frame
        add(labelName);
        add(textFieldName);
        add(labelUnits);
        add(textFieldUnits);
        add(buttonCalculate);
        add(labelResult);

        // Add action listener to the Calculate button
        buttonCalculate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calculateBill();
            }
        });
    }

    private void calculateBill() {
        String name = textFieldName.getText();
        int units = Integer.parseInt(textFieldUnits.getText());
        double rate = 0;

        // Calculate the bill based on the units consumed
        if (units <= 100) {
            rate = 1.20;
        } else if (units <= 300) {
            rate = 2.00;
        } else if (units <= 500) {
            rate = 3.00;
        } else {
            rate = 4.50;
        }

        double billAmount = units * rate;

        // Display the bill amount
        labelResult.setText("Hello " + name + ", your bill amount is ₹" + billAmount);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new electricity().setVisible(true);
            }
        });
    }
}

