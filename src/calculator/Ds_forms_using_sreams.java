package calculator;

import java.awt.EventQueue;
import java.util.List;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Ds_forms_using_sreams extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ds_forms_using_sreams frame = new Ds_forms_using_sreams();
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
	public Ds_forms_using_sreams() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 679, 506);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Welom to the Data Sturcture");
		lblNewLabel.setBackground(new Color(255, 128, 0));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(108, 10, 463, 54);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("ARRAY");
		btnNewButton.setBackground(new Color(0, 255, 255));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				ArrayList ar = new ArrayList();
				Class_array a = new Class_array();
				
				a.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton.setBounds(45, 146, 155, 54);
		contentPane.add(btnNewButton);
		
		JButton btnStack = new JButton("Stack");
		btnStack.setBackground(new Color(255, 255, 0));
		btnStack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Class_stack a = new Class_stack();
				a.setVisible(true);
			}
		});
		btnStack.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnStack.setBounds(452, 146, 155, 54);
		contentPane.add(btnStack);
		
		JButton btnQueue = new JButton("Queue");
		btnQueue.setBackground(new Color(255, 128, 255));
		btnQueue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Class_queue a = new Class_queue();
				a.setVisible(true);
			}
		});
		btnQueue.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnQueue.setBounds(452, 245, 155, 54);
		contentPane.add(btnQueue);
		
		JButton btnCircularqueue = new JButton("CircularQueue");
		btnCircularqueue.setBackground(new Color(0, 128, 192));
		btnCircularqueue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Class_cqueue a = new Class_cqueue();
				a.setVisible(true);
			}
		});
		btnCircularqueue.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnCircularqueue.setBounds(237, 359, 188, 54);
		contentPane.add(btnCircularqueue);
		
		JButton btnLinkedlist = new JButton("LinkedList");
		btnLinkedlist.setBackground(new Color(255, 128, 0));
		btnLinkedlist.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Class_ll a = new Class_ll();
				a.setVisible(true);
			}
		});
		btnLinkedlist.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnLinkedlist.setBounds(45, 245, 155, 54);
		contentPane.add(btnLinkedlist);
	}
}
