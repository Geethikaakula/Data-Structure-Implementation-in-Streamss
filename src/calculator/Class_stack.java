package calculator;

import java.awt.Component;
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
import java.util.Stack;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Class_stack extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_size;
    private Stack<Integer> s;
    private int stackSize = 0;  // Size of the stack

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                Class_stack frame = new Class_stack();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public Class_stack() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 698, 550);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("WELCOME TO THE STACK");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
        lblNewLabel.setBounds(180, 30, 335, 37);
        contentPane.add(lblNewLabel);

        // CREATE button
        JButton btnCreate = new JButton("CREATE");
        btnCreate.setBackground(new Color(0, 255, 127));
        btnCreate.addActionListener(e -> {
            try {
            	
                stackSize = Integer.parseInt(textField_size.getText());
                if(stackSize <= 0) {
                	JOptionPane.showMessageDialog(textField_size, "Please enter a valid integer for the stack!");
                }
                else {
                s = new Stack<>();
                JOptionPane.showMessageDialog(contentPane, "Stack of size " + stackSize + " created successfully!");
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(contentPane, "Please enter a valid size for the stack!");
            }
        });
        btnCreate.setFont(new Font("Tahoma", Font.BOLD, 20));
        btnCreate.setBounds(260, 150, 161, 37);
        contentPane.add(btnCreate);

        // INSERT button
        JButton btnInsert = new JButton("INSERT");
        btnInsert.setBackground(new Color(0, 255, 255));
        btnInsert.addActionListener(e -> {
        	if (s == null) {
                JOptionPane.showMessageDialog(contentPane, "Please create a stack first!");
                return;
            }

            // Check if the stack is full
            if (s.size() >= stackSize) {
                JOptionPane.showMessageDialog(contentPane, "Stack is full! Cannot insert more elements.");
                return;
            }

            try {
                // Parse the input from the text field
                int element = Integer.parseInt(textField_1.getText());
                
                // Create a temporary stack to reverse the order of elements
                Stack<Integer> tempStack = new Stack<>();
                
                // Move all elements from the main stack to the temporary stack
                while (!s.isEmpty()) {
                    tempStack.push(s.pop());
                }

                // Insert the new element at the bottom (this will be the 0th index)
                s.push(element);

                // Push all elements from the temporary stack back to the main stack
                while (!tempStack.isEmpty()) {
                    s.push(tempStack.pop());
                }

                // Show confirmation message
                JOptionPane.showMessageDialog(contentPane, "Element inserted successfully: " + element);
                textField_1.setText("");
            } catch (NumberFormatException ex) {
                // Handle invalid input (not a valid integer)
                JOptionPane.showMessageDialog(contentPane, "Please enter a valid integer!");
            }
        });
        btnInsert.setFont(new Font("Tahoma", Font.BOLD, 20));
        btnInsert.setBounds(412, 220, 161, 37);
        contentPane.add(btnInsert);

        // DELETE button
        JButton btnDelete = new JButton("DELETE");
        btnDelete.setBackground(new Color(220, 20, 60));
        btnDelete.addActionListener(e -> {
            
        	if (s == null || s.isEmpty()) {
                JOptionPane.showMessageDialog(contentPane, "Stack is empty!");
                return;
            }

            // Create a temporary stack to reverse the order
            Stack<Integer> tempStack = new Stack<>();
            
            // Move all elements from the main stack to the temporary stack
            while (!s.isEmpty()) {
                tempStack.push(s.pop());
            }

            // Now pop the top element from the temporary stack, which is the bottom element of the original stack
            int removedElement = tempStack.pop();
            
            // Show confirmation message
            JOptionPane.showMessageDialog(contentPane, "Element deleted: " + removedElement);

            // Push the remaining elements back to the original stack
            while (!tempStack.isEmpty()) {
                s.push(tempStack.pop());
            }
});
            
        btnDelete.setFont(new Font("Tahoma", Font.BOLD, 20));
        btnDelete.setBounds(224, 280, 161, 37);
        contentPane.add(btnDelete);

        // DISPLAY button
        JButton btnDisplay = new JButton("DISPLAY");
        btnDisplay.setBackground(new Color(255, 0, 0));
        btnDisplay.addActionListener(e -> {
            if (s == null || s.isEmpty()) {
                textField_2.setText("Stack is empty!");
            } else {
                textField_2.setText(s.toString());
            }
        });
        btnDisplay.setFont(new Font("Tahoma", Font.BOLD, 20));
        btnDisplay.setBounds(62, 340, 161, 37);
        contentPane.add(btnDisplay);

        // RESET button
        JButton btnReset = new JButton("RESET");
        btnReset.setBackground(new Color(192, 192, 192));
        btnReset.addActionListener(e -> {
            textField_1.setText("");
            textField_2.setText("");
            textField_size.setText("");
            if (s != null) {
                s.clear();
            }
            stackSize = 0;
        });
        btnReset.setFont(new Font("Tahoma", Font.BOLD, 20));
        btnReset.setBounds(40, 430, 161, 37);
        contentPane.add(btnReset);

        // BACK button
        JButton btnBack = new JButton("BACK");
        btnBack.setBackground(new Color(255, 128, 192));
        btnBack.addActionListener(e -> toBack());
        btnBack.setFont(new Font("Tahoma", Font.BOLD, 20));
        btnBack.setBounds(452, 430, 161, 37);
        contentPane.add(btnBack);

        // Label for stack size
        JLabel lblSize = new JLabel("SIZE:");
        lblSize.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblSize.setBounds(62, 100, 130, 29);
        contentPane.add(lblSize);

        // Input field for stack size
        textField_size = new JTextField();
        textField_size.setBounds(200, 100, 96, 28);
        contentPane.add(textField_size);
        textField_size.setColumns(10);

        // Label for element input
        JLabel lblElement = new JLabel("ELEMENT:");
        lblElement.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblElement.setBounds(62, 220, 103, 29);
        contentPane.add(lblElement);

        // Input field for element
        textField_1 = new JTextField();
        textField_1.setBounds(200, 220, 96, 28);
        contentPane.add(textField_1);
        textField_1.setColumns(10);

        // Output field
        textField_2 = new JTextField();
        textField_2.setColumns(10);
        textField_2.setBounds(300, 350, 282, 28);
        contentPane.add(textField_2);
    }
}
