package calculator;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.awt.event.ActionEvent;
import java.awt.Color;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Class_queue extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textFieldElement, textFieldDisplay, textFieldSize;
    private int[] queueArray;
    private int front, rear, maxSize, currentSize;
    private JTextField textField;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
            	Class_queue frame = new Class_queue();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public Class_queue() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 800, 600);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblTitle = new JLabel("Queue Implementation Using Array");
        lblTitle.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
        lblTitle.setBounds(150, 20, 500, 30);
        contentPane.add(lblTitle);

        // Size Label and Text Field
        JLabel lblSize = new JLabel("SIZE:");
        lblSize.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblSize.setBounds(50, 80, 100, 30);
        contentPane.add(lblSize);

        textFieldSize = new JTextField();
        textFieldSize.setBounds(180, 85, 100, 30);
        contentPane.add(textFieldSize);

        // Create Queue Button
        JButton btnCreate = new JButton("CREATE");
        btnCreate.setBackground(new Color(0, 255, 0));
        btnCreate.setFont(new Font("Tahoma", Font.BOLD, 20));
        btnCreate.setBounds(554, 77, 150, 37);
        btnCreate.addActionListener(e -> {
            try {
                maxSize = Integer.parseInt(textFieldSize.getText());
                if(maxSize <= 0) {
                	JOptionPane.showMessageDialog(null, "Please enter a valid integer size.");
                	textFieldSize.setText("");
                }
                else {
                queueArray = new int[maxSize];
                front = 0;
                rear = -1;
                currentSize = 0;
                JOptionPane.showMessageDialog(null, "Queue created with size " + maxSize);
            }} catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Please enter a valid integer size.");
            }
        });
        contentPane.add(btnCreate);

        // Element Label and Text Field
        JLabel lblElement = new JLabel("ELEMENT:");
        lblElement.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblElement.setBounds(50, 150, 120, 29);
        contentPane.add(lblElement);

        textFieldElement = new JTextField();
        textFieldElement.setBounds(180, 150, 100, 29);
        contentPane.add(textFieldElement);

        // Insert Button
        JButton btnInsert = new JButton("INSERT");
        btnInsert.setBackground(new Color(0, 255, 255));
        btnInsert.setFont(new Font("Tahoma", Font.BOLD, 20));
        btnInsert.setBounds(554, 146, 150, 37);
        btnInsert.addActionListener(e -> {
            if (queueArray == null) {
                JOptionPane.showMessageDialog(null, "Please create the queue first.");
                return;
            }
            if (currentSize >= maxSize) {
                JOptionPane.showMessageDialog(null, "Queue is full. Cannot insert more elements.");
            } else {
                try {
                    int element = Integer.parseInt(textFieldElement.getText());
                    rear = (rear + 1) % maxSize;
                    queueArray[rear] = element;
                    currentSize++;
                    JOptionPane.showMessageDialog(null, "Element " + element + " inserted successfully.");
                    textFieldElement.setText("");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Please enter a valid integer element.");
                }
            }
        });
        contentPane.add(btnInsert);

        // Delete Button
        JButton btnDelete = new JButton("DELETE");
        btnDelete.setBackground(new Color(255, 0, 0));
        btnDelete.setFont(new Font("Tahoma", Font.BOLD, 20));
        btnDelete.setBounds(317, 210, 150, 37);
        btnDelete.addActionListener(e -> {
            if (queueArray == null || currentSize == 0) {
                JOptionPane.showMessageDialog(null, "Queue is empty. Cannot delete elements.");
            } else {
                int removedElement = queueArray[front];
                front = (front + 1) % maxSize;
                currentSize--;
                JOptionPane.showMessageDialog(null, "Removed element: " + removedElement);
            }
        });
        contentPane.add(btnDelete);

        // Display Button
        JButton btnDisplay = new JButton("DISPLAY");
        btnDisplay.setBackground(new Color(255, 128, 0));
        btnDisplay.setFont(new Font("Tahoma", Font.BOLD, 20));
        btnDisplay.setBounds(35, 290, 150, 37);
        btnDisplay.addActionListener(e -> {
            if (queueArray == null || currentSize == 0) {
                JOptionPane.showMessageDialog(null, "Queue is empty.");
            } else {
            	StringBuilder display = new StringBuilder("");
                for (int i = 0; i < currentSize; i++) {
                    int index = (front + i) % maxSize;
                    display.append(queueArray[index]).append(" ");
                }
                textField.setText(display.toString());
                
            }
        });
        contentPane.add(btnDisplay);

        // Reset Button
        JButton btnReset = new JButton("RESET");
        btnReset.setBackground(new Color(192, 192, 192));
        btnReset.setFont(new Font("Tahoma", Font.BOLD, 20));
        btnReset.setBounds(35, 422, 150, 37);
        btnReset.addActionListener(e -> {
            front = 0;
            rear = -1;
            currentSize = 0;
//            queueArray.length;
            textFieldElement.setText("");
           textField.setText("");
            textFieldSize.setText("");
            JOptionPane.showMessageDialog(null, "Queue reset successfully.");
            
        });
        contentPane.add(btnReset);
        
        JButton btnNewButton = new JButton("BACK");
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		toBack();
        	}
        });
        btnNewButton.setBackground(new Color(255, 128, 192));
        btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
        btnNewButton.setBounds(554, 422, 150, 37);
        contentPane.add(btnNewButton);
        
        textField = new JTextField();
        textField.setBounds(255, 290, 384, 32);
        contentPane.add(textField);
        textField.setColumns(10);
    }
}
