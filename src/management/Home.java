package management;

import java.awt.Color;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;


public class Home {

	public JFrame frame;

	/**
	 * Launch the application.
	 */
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home window = new Home();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}

	/**
	 * Create the application.
	 */
	public Home() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Suvadip.word(Suvadip.ExcelPath());
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.DARK_GRAY);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	    frame.setSize(screenSize.width, screenSize.height);
		frame.setTitle("Shop Management");
		frame.setAlwaysOnTop(true);		
		frame.getContentPane().setLayout(null);
		
		JLabel shopLabel = new JLabel(Suvadip.ShopName());
		shopLabel.setHorizontalAlignment(SwingConstants.CENTER);
		shopLabel.setForeground(Color.YELLOW);
		shopLabel.setFont(new Font("Tahoma", Font.BOLD, 99));
		shopLabel.setBounds(0, 120, 1350, 122);
		frame.getContentPane().add(shopLabel);
		
		JButton btnNewButton = new JButton("STOCK");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Stock st=new Stock();
				st.frame.setVisible(true);
				frame.setVisible(false);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBorderPainted(false);
		btnNewButton.setBackground(Color.BLACK);
		btnNewButton.setBounds(48, 394, 212, 122);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnSale = new JButton("SALE");
		btnSale.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sale sl=new Sale();
				sl.frame.setVisible(true);
				frame.setVisible(false);
			}
		});
		btnSale.setForeground(Color.WHITE);
		btnSale.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnSale.setBorderPainted(false);
		btnSale.setBackground(Color.BLACK);
		btnSale.setBounds(308, 394, 212, 122);
		frame.getContentPane().add(btnSale);
		
		JButton btnReports = new JButton("REPORTS");
		btnReports.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Reports rp=new Reports();
				rp.frame.setVisible(true);
				frame.setVisible(false);
			}
		});
		btnReports.setForeground(Color.WHITE);
		btnReports.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnReports.setBorderPainted(false);
		btnReports.setBackground(Color.BLACK);
		btnReports.setBounds(1088, 394, 212, 122);
		frame.getContentPane().add(btnReports);
		
		JButton btnPurchase = new JButton("PURCHASE");
		btnPurchase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Purchase pr=new Purchase();
				pr.frame.setVisible(true);
				frame.setVisible(false);
			}
		});
		btnPurchase.setForeground(Color.WHITE);
		btnPurchase.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnPurchase.setBorderPainted(false);
		btnPurchase.setBackground(Color.BLACK);
		btnPurchase.setBounds(568, 394, 212, 122);
		frame.getContentPane().add(btnPurchase);
		
		JButton btnVendor = new JButton("VENDOR");
		btnVendor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Vendor vr=new Vendor();
				vr.frame.setVisible(true);
				frame.setVisible(false);
			}
		});
		btnVendor.setForeground(Color.WHITE);
		btnVendor.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnVendor.setBorderPainted(false);
		btnVendor.setBackground(Color.BLACK);
		btnVendor.setBounds(828, 394, 212, 122);
		frame.getContentPane().add(btnVendor);
		
		
	
	
	}

}
