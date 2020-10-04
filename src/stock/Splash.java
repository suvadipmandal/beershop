package stock;

import java.awt.EventQueue;
import javax.swing.JFrame;
import java.awt.SystemColor;
import javax.swing.JProgressBar;

import management.Home;
import management.Suvadip;
import management.ShopDetails;
import java.awt.Window.Type;
import java.io.*;
import java.awt.Cursor;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;

public class Splash {

	private JFrame frame;
	private JProgressBar progressBar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
			}
		});
		Splash window = new Splash();
		
		int i;
		for(i=0;i<=100;i++)
		{
			window.progressBar.setValue(i);
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			window.frame.setVisible(true);
		}
		if(i >= 100)
		{
			String path=Suvadip.DirPath();
			File myObj = new File(path);
			if(myObj.mkdirs()) {
			 ShopDetails spd=new ShopDetails();
			 spd.frame.setVisible(true);
			 window.frame.dispose();
			 
			 
			 
			}
			else 
			{
             Home h=new Home();
			 h.frame.setVisible(true);
			 window.frame.dispose();
			}
		}
	}

	/**
	 * Create the application.
	 */
	public Splash() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setAlwaysOnTop(true);
		frame.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
		frame.setType(Type.POPUP);
		frame.setUndecorated(true);
		frame.getContentPane().setBackground(SystemColor.textHighlight);
		frame.setBounds((1366/2)-300,(768/2)-150, 600, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		progressBar = new JProgressBar();
		progressBar.setForeground(new Color(0, 0, 139));
		progressBar.setValue(0);
		progressBar.setBounds(22, 261, 552, 14);
		frame.getContentPane().add(progressBar);
		
		JLabel lblNewLabel = new JLabel("SK Solution Pvt. Ltd");
		lblNewLabel.setForeground(SystemColor.text);
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 35));
		lblNewLabel.setBounds(130, 50, 345, 50);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblCommonEditor = new JLabel("SHOP MANAGEMENT");
		lblCommonEditor.setForeground(new Color(0, 255, 0));
		lblCommonEditor.setFont(new Font("Arial", Font.BOLD, 48));
		lblCommonEditor.setBounds(36, 125, 529, 114);
		frame.getContentPane().add(lblCommonEditor);
	}

	
}
