package calculator;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class Class_array extends JFrame {

    private static final long serialVersionUID = 1L;
    private static Class_array frame;
    private JPanel contentPane;
    private JTextField textField_size, textField_index, textField_element, textField_removeIndex, textField_display;
    private ArrayList<Integer> ar;
    int size;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                frame = new Class_array();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public Class_array() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 711, 600);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblTitle = new JLabel("WELCOME TO ARRAY");
        lblTitle.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
        lblTitle.setBounds(206, 10, 278, 31);
        contentPane.add(lblTitle);

        // CREATE ArrayList Button
        JButton btnCreate = new JButton("CREATE");
        btnCreate.setBackground(Color.GREEN);
        btnCreate.setFont(new Font("Tahoma", Font.BOLD, 20));
        btnCreate.setBounds(472, 71, 162, 51);
        btnCreate.addActionListener(e -> {
        	try {
        	size = Integer.parseInt(textField_size.getText());
        	if (size > 0) {
            ar = new ArrayList<>(Collections.nCopies(size, 0));
        	
            JOptionPane.showMessageDialog(null, "ArrayList Created with the size " + (size-1));
        	}
        	else {
        		textField_size.setText("");
        		JOptionPane.showMessageDialog(textField_size, "Enter the valid value!");
        	}
        	}
        	catch(Exception e1) {
        		JOptionPane.showMessageDialog(textField_size, "Enter the valid value!");
        	}
        });
        contentPane.add(btnCreate);

        JLabel lblSize = new JLabel("SIZE:");
        lblSize.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblSize.setBounds(64, 94, 76, 25);
        contentPane.add(lblSize);

        textField_size = new JTextField();
        textField_size.setBounds(197, 88, 123, 31);
        contentPane.add(textField_size);
        textField_size.setColumns(10);

        // INSERT Button
        JButton btnInsert = new JButton("INSERT");
        btnInsert.setBackground(Color.CYAN);
        btnInsert.setFont(new Font("Tahoma", Font.BOLD, 20));
        btnInsert.setBounds(261, 205, 162, 51);
        btnInsert.addActionListener(e -> {
            try {
                if (ar == null) {
                    JOptionPane.showMessageDialog(null, "Please create the ArrayList first.");
                    return;
                }
                int index = Integer.parseInt(textField_index.getText());
                int element = Integer.parseInt(textField_element.getText());

                if (index >= size || index < 0) {
                    JOptionPane.showMessageDialog(null, "Index out of bounds. Enter a valid index (0 to " + (ar.size() - 1) + ").");
                    textField_index.setText("");
                    textField_element.setText("");
                } 
                else {
                    ar.set(index, element);
                    JOptionPane.showMessageDialog(null, "Element inserted at index " + index);
                    textField_index.setText("");
                    textField_element.setText("");
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Please enter valid integers for index and element.");
            }
        });
        contentPane.add(btnInsert);

        JLabel lblIndex = new JLabel("INDEX:");
        lblIndex.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblIndex.setBounds(64, 150, 123, 36);
        contentPane.add(lblIndex);

        textField_index = new JTextField();
        textField_index.setBounds(197, 145, 123, 31);
        contentPane.add(textField_index);
        textField_index.setColumns(10);

        JLabel lblElement = new JLabel("ELEMENT:");
        lblElement.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblElement.setBounds(384, 153, 129, 31);
        contentPane.add(lblElement);

        textField_element = new JTextField();
        textField_element.setBounds(564, 150, 123, 31);
        contentPane.add(textField_element);
        textField_element.setColumns(10);

        // REMOVE Button
        JButton btnRemove = new JButton("REMOVE");
        btnRemove.setBackground(Color.RED);
        btnRemove.setFont(new Font("Tahoma", Font.BOLD, 20));
        btnRemove.setBounds(472, 276, 162, 51);
        btnRemove.addActionListener(e -> {
            try {
            	
                if (ar == null || ar.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "ArrayList is empty or you gave invalid index. Nothing to remove.");
                    return;
                }
                int index = Integer.parseInt(textField_removeIndex.getText());
                if (index >= ar.size()) {
                    JOptionPane.showMessageDialog(null, "Invalid index. Enter a valid index (0 to " + (ar.size() - 1) + ").");
                } else {
                    ar.remove(index);
                    JOptionPane.showMessageDialog(null, "Element removed at index " + index);
                    textField_removeIndex.setText("");
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Please enter a valid integer index.");
            }
        });
        contentPane.add(btnRemove);

        JLabel lblRemoveIndex = new JLabel("REMOVE INDEX:");
        lblRemoveIndex.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblRemoveIndex.setBounds(64, 283, 180, 36);
        contentPane.add(lblRemoveIndex);

        textField_removeIndex = new JTextField();
        textField_removeIndex.setBounds(250, 279, 123, 36);
        contentPane.add(textField_removeIndex);
        textField_removeIndex.setColumns(10);

        // DISPLAY Button
        JButton btnDisplay = new JButton("DISPLAY");
        btnDisplay.setBackground(Color.ORANGE);
        btnDisplay.setFont(new Font("Tahoma", Font.BOLD, 20));
        btnDisplay.setBounds(261, 341, 162, 51);
        btnDisplay.addActionListener(e -> {
            if (ar == null || ar.isEmpty()) {
                textField_display.setText("Array is empty");
            } else {
                textField_display.setText(ar.toString());
            }
        });
        contentPane.add(btnDisplay);

        textField_display = new JTextField();
        textField_display.setBounds(64, 420, 570, 36);
        contentPane.add(textField_display);
        textField_display.setColumns(10);
        
        JButton btnNewButton = new JButton("RESET");
        btnNewButton.setBackground(new Color(192, 192, 192));
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		textField_size.setText("");
        		textField_index.setText("");
        		textField_element.setText("");
        		textField_removeIndex.setText("");
        		textField_display.setText("");
        		ar.clear();
        	}
        });
        btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
        btnNewButton.setBounds(80, 483, 123, 36);
        contentPane.add(btnNewButton);
        
        JButton btnNewButton_1 = new JButton("BACK");
        btnNewButton_1.setBackground(new Color(255, 128, 192));
        btnNewButton_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		toBack();
        	}
        	
        });
        btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 20));
        btnNewButton_1.setBounds(472, 483, 162, 33);
        contentPane.add(btnNewButton_1);
    }
}
