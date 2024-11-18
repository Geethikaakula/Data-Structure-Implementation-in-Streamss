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
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;


	public class Class_cqueue extends JFrame {

	    private static final long serialVersionUID = 1L;
	    private JTextField textField;    // To display the queue elements
	    private JTextField textField_1;  // To input elements
	    private int[] queue;            // Circular Queue array
	    private int front, rear, size, capacity;
	    private JTextField textField_2;

	    public static void main(String[] args) {
	        EventQueue.invokeLater(new Runnable() {
	            public void run() {
	                try {
	                    Class_cqueue frame = new Class_cqueue();
	                    frame.setVisible(true);
	                } catch (Exception e) {
	                    e.printStackTrace();
	                }
	            }
	        });
	    }

	    // Constructor for setting up the GUI
	    public Class_cqueue() {
	    	getContentPane().setBackground(new Color(192, 192, 192));
	        // Basic JFrame setup
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        setBounds(100, 100, 763, 587);  // Window size and position
	        getContentPane().setLayout(null); // No layout manager (absolute positioning)

	        // Title Label
	        JLabel lblWelcomeToThe_1 = new JLabel("WELCOME TO THE CIRCULAR QUEUE");
	        lblWelcomeToThe_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));  // Font style
	        lblWelcomeToThe_1.setBounds(137, 35, 468, 37);  // Position and size
	        getContentPane().add(lblWelcomeToThe_1);

	        // TextField for Queue Display
	        textField = new JTextField();
	        textField.setColumns(10);
	        textField.setBounds(174, 380, 380, 29);  // Position and size
	        getContentPane().add(textField);

	        // TextField for Element Input
	        textField_1 = new JTextField();
	        textField_1.setColumns(10);
	        textField_1.setBounds(157, 210, 96, 29);  // Position and size
	        getContentPane().add(textField_1);

	        // Element Label
	        JLabel lblNewLabel_2 = new JLabel("ELEMENT:");
	        lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 20));  // Font style
	        lblNewLabel_2.setBounds(31, 210, 103, 29);  // Position and size
	        getContentPane().add(lblNewLabel_2);

	        // CREATE Button to initialize the queue
	        JButton btnCreate = new JButton("CREATE");
	        btnCreate.setBackground(new Color(0, 255, 0));
	        btnCreate.setFont(new Font("Tahoma", Font.BOLD, 20));  // Font style
	        btnCreate.setBounds(488, 140, 161, 37);  // Position and size
	        btnCreate.addActionListener(new ActionListener() {
	            

				public void actionPerformed(ActionEvent e) {
	                // Prompt for queue size
					try {
	                int size = Integer.parseInt(textField_2.getText());
	                // Initialize the Circular Queue
	                if(size <= 0) {
	                	JOptionPane.showMessageDialog(textField_2, "Ener the vaild value");
	                	textField_2.setText("");
	                }
	                else {
	                capacity = size;
	                queue = new int[capacity];
	                front = 0;
	                rear = -1;
	                JOptionPane.showMessageDialog(null, "Circular Queue Created with size " + size);
	            }
					}
					catch(Exception e1) {
						JOptionPane.showMessageDialog(textField_2, "Ener the vaild value");
					}
				} });
	        getContentPane().add(btnCreate);

	        // INSERT Button to add an element to the queue
	        JButton btnInsert = new JButton("INSERT");
	        btnInsert.setFont(new Font("Tahoma", Font.BOLD, 20));  // Font style
	        btnInsert.setBounds(488, 202, 161, 37);  // Position and size
	        btnInsert.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                if (queue == null) {
	                    JOptionPane.showMessageDialog(null, "Please create the queue first.");
	                    return;
	                }
	                try {
	                int element = Integer.parseInt(textField_1.getText());  // Get the element to insert
	                enqueue(element);
	                JOptionPane.showMessageDialog(textField_1, "element is inserted successfully." + element);
	                textField_1.setText("");
	                ;  // Display updated queue
	            }
	                catch(Exception e2) {
	                	JOptionPane.showMessageDialog(textField_1, "Please enter the valid input.");
	                }
	            }
	        });
	        getContentPane().add(btnInsert);

	        // DELETE Button to remove an element from the queue
	        JButton btnDelete = new JButton("DELETE");
	        btnDelete.setBackground(new Color(255, 0, 0));
	        btnDelete.setFont(new Font("Tahoma", Font.BOLD, 20));  // Font style
	        btnDelete.setBounds(289, 274, 161, 37);  // Position and size
	        btnDelete.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                if (queue == null) {
	                    JOptionPane.showMessageDialog(null, "Please create the queue first ");
	                    return;
	                }
	                dequeue();  // Remove an element
	               JOptionPane.showMessageDialog(null, "Element deleted successfully ");
	            }
	        });
	        getContentPane().add(btnDelete);

	        // RESET Button to clear the queue
	        JButton btnReset = new JButton("RESET");
	        btnReset.setBackground(new Color(192, 192, 192));
	        btnReset.setFont(new Font("Tahoma", Font.BOLD, 20));  // Font style
	        btnReset.setBounds(31, 455, 161, 37);  // Position and size
	        btnReset.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                if (queue != null) {
	                    reset();  // Reset the queue
	                    textField.setText("");  // Clear display
	                    textField_1.setText("");
	                    textField_2.setText("");
	                } else {
	                    JOptionPane.showMessageDialog(null, "Please create the queue first.");
	                }
	            }
	        });
	        getContentPane().add(btnReset);

	        // BACK Button (placeholder action)
	        JButton btnBack = new JButton("BACK");
	        btnBack.setBackground(new Color(255, 128, 192));
	        btnBack.setFont(new Font("Tahoma", Font.BOLD, 20));  // Font style
	        btnBack.setBounds(488, 455, 161, 37);  // Position and size
	        btnBack.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                toBack();  // Placeholder to go back
	            }
	        });
	        getContentPane().add(btnBack);
	        
	        JLabel lblNewLabel_2_1 = new JLabel("SIZE:");
	        lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 20));
	        lblNewLabel_2_1.setBounds(31, 148, 103, 29);
	        getContentPane().add(lblNewLabel_2_1);
	        
	        textField_2 = new JTextField();
	        textField_2.setColumns(10);
	        textField_2.setBounds(157, 148, 96, 29);
	        getContentPane().add(textField_2);
	        
	        JButton btnDisplay = new JButton("DISPLAY:");
	        btnDisplay.setBackground(new Color(255, 128, 0));
	        btnDisplay.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		
	                textField.setText(display()); 
	        	}
	        });
	        btnDisplay.setFont(new Font("Tahoma", Font.BOLD, 20));
	        btnDisplay.setBounds(289, 333, 161, 37);
	        getContentPane().add(btnDisplay);
	    }

	    // Enqueue method to add an element to the circular queue
	    public void enqueue(int element) {
	        if (size == capacity) {
	            JOptionPane.showMessageDialog(null, "Queue is full! Cannot insert.");
	        } else {
	            rear = (rear + 1) % capacity;
	            queue[rear] = element;
	            size++;
	        }
	    }

	    // Dequeue method to remove an element from the circular queue
	    public void dequeue() {
	        if (size == 0) {
	            JOptionPane.showMessageDialog(null, "Queue is empty! Cannot delete.");
	        } else {
	            front = (front + 1) % capacity;
	            size--;
	        }
	    }

	    // Display method to show the current elements in the queue
	    public String display() {
	        if (size == 0) {
	            return "Queue is empty!";
	        }

	        StringBuilder sb = new StringBuilder();
	        int i = front;
	        for (int count = 0; count < size; count++) {
	            sb.append(queue[i]).append(" ");
	            i = (i + 1) % capacity;
	        }
	        return sb.toString();
	    }

	    // Reset method to clear the queue
	    public void reset() {
	        front = 0;
	        rear = -1;
	        size = 0;
	    }
	}
