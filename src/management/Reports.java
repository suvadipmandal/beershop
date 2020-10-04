package management;

import java.awt.BorderLayout;



import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Panel;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;


import java.io.IOException;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
public class Reports {

	JFrame frame;
	private JPanel contentPane;
	private JTable table;
	private JTable table_1;
	private JTextField txtTotal;
	private JTextField txtTotal_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Reports window = new Reports();
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
	public Reports() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(0, 0, 1280, 720);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		frame.setContentPane(contentPane);
		
		Panel panel = new Panel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setForeground(Color.DARK_GRAY);
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		table = new JTable();
		table.setBounds(353, 118, 841, 186);
		panel.add(table);
		
		table_1 = new JTable();
		table_1.setBounds(353, 409, 841, 186);
		panel.add(table_1);
		
		txtTotal = new JTextField();
		txtTotal.setForeground(Color.GREEN);
		txtTotal.setBounds(962, 315, 232, 38);
		panel.add(txtTotal);
		txtTotal.setColumns(10);
		
		txtTotal_1 = new JTextField();
		txtTotal_1.setBounds(957, 606, 243, 38);
		panel.add(txtTotal_1);
		txtTotal_1.setColumns(10);
		
		JButton btnSave = new JButton("SAVE ");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DefaultTableModel model = new DefaultTableModel(); 
				 
				
				File excelFile;
		        FileInputStream excelFIS = null;
		        BufferedInputStream excelBIS = null;
		        XSSFWorkbook excelImportToJTable = null;
		        String defaultCurrentDirectoryPath = "C:\\Users\\Authentic\\Desktop";
		        JFileChooser excelFileChooser = new JFileChooser(defaultCurrentDirectoryPath);
		        excelFileChooser.setDialogTitle("Select Excel File");
		        FileNameExtensionFilter fnef = new FileNameExtensionFilter("EXCEL FILES", "xls", "xlsx", "xlsm");
		        excelFileChooser.setFileFilter(fnef);
		        int excelChooser = excelFileChooser.showOpenDialog(null);
		        if (excelChooser == JFileChooser.APPROVE_OPTION) {
		            try {
		                excelFile = excelFileChooser.getSelectedFile();
		                excelFIS = new FileInputStream(excelFile);
		                excelBIS = new BufferedInputStream(excelFIS);
		                excelImportToJTable = new XSSFWorkbook(excelBIS);
		                XSSFSheet excelSheet = excelImportToJTable.getSheetAt(0);
		 
		                for (int row = 0; row < excelSheet.getLastRowNum(); row++) {
		                    XSSFRow excelRow = excelSheet.getRow(row);
		 
		                    XSSFCell excelName = excelRow.getCell(0);
		                    XSSFCell excelGender = excelRow.getCell(1);
		                    XSSFCell excelProgrammingLanguage = excelRow.getCell(2);
		                    XSSFCell excelSubject = excelRow.getCell(3);
		                    
		 
		                    model.addRow(new Object[]{excelName, excelGender, excelProgrammingLanguage, excelSubject});
		                }
		                JOptionPane.showMessageDialog(null, "Imported Successfully !!.....");
		            } catch (IOException iOException) {
		                JOptionPane.showMessageDialog(null, iOException.getMessage());
		            } finally {
		                try {
		                    if (excelFIS != null) {
		                        excelFIS.close();
		                    }
		                    if (excelBIS != null) {
		                        excelBIS.close();
		                    }
		                    if (excelImportToJTable != null) {
//		                        excelImportToJTable.close();
		                    }
		                } catch (IOException iOException) {
		                    JOptionPane.showMessageDialog(null, iOException.getMessage());
		                }
		            }
		        }
		    }                                   
				
					
		}
				
			
			
				
	);
	
		btnSave.setBorderPainted(false);
		btnSave.setBackground(Color.BLACK);
		btnSave.setForeground(Color.WHITE);
		btnSave.setBounds(122, 246, 117, 38);
		panel.add(btnSave);
		
		JButton btnSave_1 = new JButton("SAVE");
		btnSave_1.setBorderPainted(false);
		btnSave_1.setBackground(Color.BLACK);
		btnSave_1.setForeground(Color.WHITE);
		btnSave_1.setBounds(122, 514, 117, 38);
		panel.add(btnSave_1);
		
		JLabel lblTotal = new JLabel("TOTAL");
		lblTotal.setFont(new Font("Dialog", Font.BOLD, 20));
		lblTotal.setForeground(Color.YELLOW);
		lblTotal.setBounds(787, 315, 132, 38);
		panel.add(lblTotal);
		
		JLabel lblTotal_1 = new JLabel("TOTAL");
		lblTotal_1.setFont(new Font("Dialog", Font.BOLD, 20));
		lblTotal_1.setForeground(Color.YELLOW);
		lblTotal_1.setBounds(787, 606, 132, 38);
		panel.add(lblTotal_1);
		
		JButton btnBack = new JButton("BACK");
		btnBack.setBorderPainted(false);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Home H =new Home();
				H.frame.setVisible(true);
				frame.setVisible(false);
				
			}
		});
		btnBack.setBackground(Color.BLACK);
		btnBack.setForeground(Color.WHITE);
		btnBack.setFont(new Font("Dialog", Font.BOLD, 15));
		btnBack.setBounds(10, 622, 132, 38);
		panel.add(btnBack);
		
		JLabel lblReports = new JLabel("REPORTS");
		lblReports.setHorizontalAlignment(SwingConstants.CENTER);
		lblReports.setFont(new Font("Dialog", Font.BOLD, 50));
		lblReports.setForeground(Color.YELLOW);
		lblReports.setBackground(Color.DARK_GRAY);
		lblReports.setBounds(0, 0, 1254, 90);
		panel.add(lblReports);
		
		JLabel lblToday = new JLabel("TODAY");
		lblToday.setFont(new Font("Dialog", Font.BOLD, 40));
		lblToday.setForeground(Color.YELLOW);
		lblToday.setBounds(95, 128, 190, 72);
		panel.add(lblToday);
		
		JLabel lblThisMonth = new JLabel("THIS MONTH");
		lblThisMonth.setForeground(Color.YELLOW);
		lblThisMonth.setFont(new Font("Dialog", Font.BOLD, 40));
		lblThisMonth.setBounds(25, 409, 323, 72);
		panel.add(lblThisMonth);
	}

}
