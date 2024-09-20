// WAP in java to do the following
// 1) age calculator as on any date given by user

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.Period;

public class AgeCalculator extends JFrame {

    // UI Components
    private JTextField birthYearField, birthMonthField, birthDayField;
    private JTextField yearField, monthField, dayField;
    private JLabel resultLabel;

    public AgeCalculator() {
        // Setting up the frame
        setTitle("Age Calculator");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(8, 2, 10, 10));

        // Input labels and fields for birth date
        JLabel birthYearLabel = new JLabel("Enter birth year (yyyy):");
        birthYearField = new JTextField();
        JLabel birthMonthLabel = new JLabel("Enter birth month (1-12):");
        birthMonthField = new JTextField();
        JLabel birthDayLabel = new JLabel("Enter birth day (1-31):");
        birthDayField = new JTextField();

        // Input labels and fields for target date
        JLabel yearLabel = new JLabel("Enter the year (yyyy):");
        yearField = new JTextField();
        JLabel monthLabel = new JLabel("Enter the month (1-12):");
        monthField = new JTextField();
        JLabel dayLabel = new JLabel("Enter the day (1-31):");
        dayField = new JTextField();

        // Button to calculate age
        JButton calculateButton = new JButton("Calculate Age");
        calculateButton.addActionListener(new CalculateButtonListener());

        // Label to display result
        resultLabel = new JLabel("Age will be displayed here", JLabel.CENTER);
        resultLabel.setForeground(Color.BLUE);

        // Adding components to frame
        add(birthYearLabel);
        add(birthYearField);
        add(birthMonthLabel);
        add(birthMonthField);
        add(birthDayLabel);
        add(birthDayField);
        add(yearLabel);
        add(yearField);
        add(monthLabel);
        add(monthField);
        add(dayLabel);
        add(dayField);
        add(calculateButton);
        add(resultLabel);

        setVisible(true);
    }

    // ActionListener for the "Calculate Age" button
    private class CalculateButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                // Get birth date
                int birthYear = Integer.parseInt(birthYearField.getText());
                int birthMonth = Integer.parseInt(birthMonthField.getText());
                int birthDay = Integer.parseInt(birthDayField.getText());

                // Get target date
                int year = Integer.parseInt(yearField.getText());
                int month = Integer.parseInt(monthField.getText());
                int day = Integer.parseInt(dayField.getText());

                // Calculate age
                LocalDate dob = LocalDate.of(birthYear, birthMonth, birthDay);
                LocalDate currentDate = LocalDate.of(year, month, day);
                Period age = Period.between(dob, currentDate);

                // Display the result
                resultLabel.setText("Age: " + age.getYears() + " years, " 
                                     + age.getMonths() + " months, " 
                                     + age.getDays() + " days.");
            } catch (Exception ex) {
                resultLabel.setText("Invalid input. Please enter correct values.");
            }
        }
    }

    public static void main(String[] args) {
        new AgeCalculator();
    }
}