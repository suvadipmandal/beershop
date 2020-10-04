package management;

import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Label;
import java.awt.Panel;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.io.*;

public class Set_Price extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Set_Price frame = new Set_Price("beer",20,0);
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
	public Set_Price(String Iname,int Iprice,int rowNum) {
		setTitle("Price Setup");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 811, 464);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		Panel panel = new Panel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setFont(new Font("Dialog", Font.PLAIN, 17));
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JButton set_btn = new JButton("SET PRICE");
		set_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				System.out.println(rowNum);
				try {
					Suvadip.update(Integer.parseInt(textField_1.getText()),rowNum);
					Stock sk=new Stock();
					sk.frame.setVisible(true);
					dispose();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
//				Suvadip.WriteExcel("Sales And Purchase.xlsx", rowNum, 1, Iname);
			}
		});
		set_btn.setBorderPainted(false);
		set_btn.setForeground(Color.WHITE);
		set_btn.setFont(new Font("Dialog", Font.BOLD, 20));
		set_btn.setBackground(Color.BLACK);
		set_btn.setActionCommand("New Button");
		set_btn.setBounds(579, 228, 168, 69);
		panel.add(set_btn);
		
		Label label = new Label("PRICE SETUP");
		label.setForeground(Color.YELLOW);
		label.setAlignment(Label.CENTER);
		label.setFont(new Font("Dialog", Font.BOLD, 60));
		label.setBounds(0, 0, 785, 91);
		panel.add(label);
		
		JLabel lblBeerName = new JLabel("ITEM NAME");
		lblBeerName.setForeground(Color.YELLOW);
		lblBeerName.setFont(new Font("Dialog", Font.BOLD, 20));
		lblBeerName.setBounds(38, 147, 141, 50);
		panel.add(lblBeerName);
		
		textField = new JTextField(Iname);
		textField.setBounds(189, 147, 353, 50);
		textField.setFont(new Font("Dialog", Font.BOLD, 20));
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblPrice = new JLabel("PRICE");
		lblPrice.setForeground(Color.YELLOW);
		lblPrice.setFont(new Font("Dialog", Font.BOLD, 20));
		lblPrice.setBounds(38, 244, 141, 50);
		panel.add(lblPrice);
		
		textField_1 = new JTextField(String.valueOf(Iprice));
		textField_1.setBounds(189, 244, 353, 50);
		textField_1.setFont(new Font("Dialog", Font.BOLD, 20));
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnBack = new JButton("BACK");
		btnBack.setBorderPainted(false);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Stock st = new Stock();
				st.frame.setVisible(true);
				setVisible(false);
			}
		});
		btnBack.setFont(new Font("Dialog", Font.BOLD, 15));
		btnBack.setForeground(Color.WHITE);
		btnBack.setBackground(Color.BLACK);
		btnBack.setBounds(619, 147, 128, 36);
		panel.add(btnBack);
	}
	
	
}
