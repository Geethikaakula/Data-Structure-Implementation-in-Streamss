package calculator;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Class_ll extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private LinkedList<Integer> ll;
	int a;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Class_ll frame = new Class_ll();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Class_ll() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 757, 644);
		getContentPane().setLayout(null);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("SIZE:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setBounds(30, 153, 54, 37);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblWelcomeToThe_1 = new JLabel("WELCOME TO THE LINKEDLIST");
		lblWelcomeToThe_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		lblWelcomeToThe_1.setBounds(158, 51, 468, 37);
		getContentPane().add(lblWelcomeToThe_1);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(158, 161, 96, 29);
		getContentPane().add(textField);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(158, 234, 96, 29);
		getContentPane().add(textField_1);
		
		JLabel lblNewLabel_2 = new JLabel("ELEMENT:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_2.setBounds(420, 230, 103, 29);
		getContentPane().add(lblNewLabel_2);
		
		JButton btnCreate = new JButton("CREATE");
		btnCreate.setBackground(new Color(0, 255, 0));
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				
				 a = Integer.parseInt(textField.getText());
				 if(a <= 0) {
					 JOptionPane.showMessageDialog(textField, "Enter the valid value!");
				 }
				 else {
				 ll = new LinkedList<>(Collections.nCopies(a, 0));
				 
				 JOptionPane.showMessageDialog(null, "LinkedList Created with size " + a);
				}
				}
				catch(Exception e1) {
					JOptionPane.showMessageDialog(textField, "Enter the valid value!");
				}
			}
		});
		btnCreate.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnCreate.setBounds(520, 153, 161, 37);
		getContentPane().add(btnCreate);
		
		JButton btnNewButton = new JButton("INSERT");
		btnNewButton.setBackground(new Color(0, 255, 255));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
		            // Parsing input values from text fields
		            int b = Integer.parseInt(textField_1.getText());
		            int c = Integer.parseInt(textField_2.getText());
		            
		            // Check if index is valid
		            if (b < 0 || b >= ll.size()) {
		                JOptionPane.showMessageDialog(textField_1, "Enter a valid index within the range: 0 to " + (ll.size() - 1));
		                textField_1.setText("");
		                textField_2.setText("");
		            } else {
		                // Update the value at the specified index
		                ll.set(b, c);
		                JOptionPane.showMessageDialog(null, "Value updated successfully!");
		                textField_1.setText("");
		                textField_2.setText("");
		            }
		        } catch (NumberFormatException e1) {
		            // Handle invalid integer input
		            JOptionPane.showMessageDialog(textField_1, "Please enter valid integer values.");
		        } catch (IndexOutOfBoundsException e2) {
		            // Handle invalid index
		            JOptionPane.showMessageDialog(textField_1, "Index is out of bounds. Enter a valid index.");
		        } catch (Exception e3) {
		            // Catch any other unexpected exceptions
		            JOptionPane.showMessageDialog(textField_1, "An unexpected error occurred.");
		        }
		    } 
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton.setBounds(30, 277, 161, 37);
		getContentPane().add(btnNewButton);
		
		JButton btnDelet = new JButton("DELETE");
		btnDelet.setBackground(new Color(255, 0, 0));
		btnDelet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int u ;
					u = Integer.parseInt(textField_3.getText());
					ll.remove(u);
                    JOptionPane.showMessageDialog(null, "Element removed at index " + u);
                    textField.setText("");
					}
					catch(Exception e2) {
						JOptionPane.showMessageDialog(textField_3,"Enter the valid index");
					}
			}
		});
		btnDelet.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnDelet.setBounds(520, 343, 161, 37);
		getContentPane().add(btnDelet);
		
		JButton btnDispaly = new JButton("DISPALY");
		btnDispaly.setBackground(new Color(255, 128, 0));
		btnDispaly.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField_4.setText(ll.toString());
			}
		});
		btnDispaly.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnDispaly.setBounds(30, 426, 161, 37);
		getContentPane().add(btnDispaly);
		
		JButton btnReset = new JButton("RESET");
		btnReset.setBackground(new Color(192, 192, 192));
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField_4.setText("");
				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
				textField_3.setText("");
				ll.clear();
			}
		});
		btnReset.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnReset.setBounds(30, 560, 161, 37);
		getContentPane().add(btnReset);
		
		JButton btnBack = new JButton("BACK");
		btnBack.setBackground(new Color(255, 128, 192));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				toBack();
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnBack.setBounds(520, 560, 161, 37);
		getContentPane().add(btnBack);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(566, 234, 115, 29);
		getContentPane().add(textField_2);
		
		JLabel lblNewLabel_1_1 = new JLabel("POSITION:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1_1.setBounds(30, 230, 115, 37);
		getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("POSITION:");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1_1_1.setBounds(30, 343, 115, 37);
		getContentPane().add(lblNewLabel_1_1_1);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(158, 351, 96, 29);
		getContentPane().add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(262, 426, 351, 37);
		getContentPane().add(textField_4);
		
		JButton btnNewButton_1 = new JButton("REMOVE-FIRST");
		btnNewButton_1.setBackground(new Color(128, 128, 255));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				ll.removeFirst();
                JOptionPane.showMessageDialog(null, "Element removed at index 0");
			}
				catch(Exception e4) {
					JOptionPane.showMessageDialog(null,"Enter the valid element");
				}
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton_1.setBounds(30, 500, 201, 37);
		getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("REMOVE-LAST");
		btnNewButton_2.setBackground(new Color(153, 204, 153));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
				ll.removeLast();
				JOptionPane.showMessageDialog(null, "Element removed at last");
			}
				catch(Exception e3) {
					JOptionPane.showMessageDialog(null,"Enter the valid element");
				}
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton_2.setBounds(488, 502, 193, 33);
		getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_4 = new JButton("ADD FIRST");
		btnNewButton_4.setBackground(new Color(0, 128, 255));
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				int d = Integer.parseInt(textField_2.getText());
				ll.addFirst(d);
				JOptionPane.showMessageDialog(null, "Element added at index 0");
				
			}
				catch(Exception e2) {
					JOptionPane.showMessageDialog(textField_2,"Enter the valid element");
				}
			}
		});
		btnNewButton_4.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton_4.setBounds(289, 277, 161, 37);
		getContentPane().add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("ADD LAST");
		btnNewButton_5.setBackground(new Color(255, 0, 128));
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				int r = Integer.parseInt(textField_2.getText());
				ll.addLast(r);
				JOptionPane.showMessageDialog(null, "Element added at last index");
			}
				catch(Exception e1) {
					JOptionPane.showMessageDialog(textField_2,"Enter the valid element");
				}
			}
		});
		btnNewButton_5.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton_5.setBounds(520, 277, 161, 33);
		getContentPane().add(btnNewButton_5);
	}
}
