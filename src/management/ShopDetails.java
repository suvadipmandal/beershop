package management;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.awt.event.ActionEvent;

public class ShopDetails {

	public JFrame frame;
	private JPanel contentPane;
	private JTextField shoptext;
	private JTextField nametext;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ShopDetails window = new ShopDetails();
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
	public ShopDetails() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 720, 480);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		frame.setContentPane(contentPane);
		
		JLabel lblWelCome = new JLabel("Wel Come");
		lblWelCome.setForeground(Color.WHITE);
		lblWelCome.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelCome.setFont(new Font("Tahoma", Font.BOLD, 30));
		contentPane.add(lblWelCome, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblEnterYourShop = new JLabel("Enter Your Shop Name :");
		lblEnterYourShop.setForeground(Color.WHITE);
		lblEnterYourShop.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblEnterYourShop.setBackground(Color.DARK_GRAY);
		lblEnterYourShop.setBounds(35, 67, 241, 46);
		panel.add(lblEnterYourShop);
		
		shoptext = new JTextField();
		shoptext.setBounds(311, 74, 347, 33);
		panel.add(shoptext);
		shoptext.setColumns(10);
		
		JLabel lblEnterYourName = new JLabel("Enter Your Name :");
		lblEnterYourName.setForeground(Color.WHITE);
		lblEnterYourName.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblEnterYourName.setBackground(Color.DARK_GRAY);
		lblEnterYourName.setBounds(35, 139, 241, 46);
		panel.add(lblEnterYourName);
		
		nametext = new JTextField();
		nametext.setColumns(10);
		nametext.setBounds(311, 146, 347, 33);
		panel.add(nametext);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String st = "";
				if(shoptext.getText().isEmpty()) {
					st="Please Enter Shop Name";
					JOptionPane.showMessageDialog(null, st);
				}
				else if (nametext.getText().isEmpty())
				{
					st="Please Enter Your Name";
					JOptionPane.showMessageDialog(null, st);
				}
				else
				{
					String data=shoptext.getText()+","+nametext.getText();
					String path=Suvadip.FilePath();
					Suvadip.CreateFile(path);
					Suvadip.WriteFile(data,path);
					new Home();
					
			        XSSFWorkbook wb = new XSSFWorkbook();  
					String filename = Suvadip.ExcelPath();
			        try  (OutputStream fileOut = new FileOutputStream(filename)) {  
			            
			            
			            String[] headers = new String[] { "DATE", "BILL NO", "Amount","Cheque NO","Date","Amount","TDS","Item Name","Quantity","Box" };

			            XSSFSheet sheet1 = wb.createSheet("Purchase"); 

			            Row header = sheet1.createRow(0);
			            for (int rn=0; rn<headers.length; rn++) {
			            	header.createCell(rn).setCellValue(headers[rn]);
			            }
			            
			            
			            XSSFSheet sheet2 = wb.createSheet("Sale"); 
			            Row header_sale = sheet2.createRow(0);           
			            String[] headers_sale = new String[] { "RECIPT NO","BAR CODE","ITEM NAME","QT BOTTLE","PRICE","TOTAL PRICE" };        
			            for (int j=0; j<headers_sale.length; j++) {
			            	header_sale.createCell(j).setCellValue(headers_sale[j]);
			            }
			            
			            XSSFSheet sheet3= wb.createSheet("Vendor");  
			            
			            String[] headers_vendor = new String[] { "VENDOR ID","VENDOR NAME","PHONE","EMAIL","ADDRESS" }; 
			            Row header_vendor = sheet3.createRow(0);
			            for (int k=0; k<headers_vendor.length; k++) {
			            	header_vendor.createCell(k).setCellValue(headers_vendor[k]);
			            }
			            
			            
			            wb.write(fileOut);
			            }
			            catch(Exception e1) {  
			                System.out.println(( e1).getMessage());  
			            }  
					frame.setVisible(false);

				}
			}
		});
		btnNewButton.setBackground(Color.YELLOW);
		btnNewButton.setBorderPainted(false);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton.setBounds(254, 274, 182, 61);
		panel.add(btnNewButton);
	}

}
