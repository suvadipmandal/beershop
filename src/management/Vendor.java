package management;

import java.awt.BorderLayout;

import java.awt.Button;
import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.awt.Dimension;
import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.Font;
import java.awt.Label;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Vendor {
	DefaultTableModel model = new DefaultTableModel(0,0);
	JFrame frame;
	private JPanel contentPane;
	private JTextField txtname;
	private JTextField txtphone;
	private JTextField txtemail;
	private JTextField txtaddress;
	private JTable vendor_table;
	private JTextField txtid;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Vendor window = new Vendor();
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
	public Vendor() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(0, 0, 1280, 720);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setPreferredSize(new Dimension(100, 100));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		frame.setContentPane(contentPane);DefaultTableModel model = new DefaultTableModel();
		
		Panel panel = new Panel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setForeground(Color.DARK_GRAY);
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		vendor_table = new JTable();
		Object[] columns = {"ID","NAME","PHONE","EMAIL","ADDRESS"};
		model.setColumnIdentifiers(columns);
		vendor_table.setModel(model);
		Font font = new Font("",1,20);
		vendor_table.setFont(font);
		vendor_table.setRowHeight(25);
		JScrollPane scrollPane = new JScrollPane(vendor_table);
		scrollPane.setBounds(599, 179, 596, 329);
		panel.add(scrollPane);
		@SuppressWarnings("unused")
		
        
	
		Label label = new Label("VENDOR");
		label.setForeground(Color.YELLOW);
		label.setAlignment(Label.CENTER);
		label.setFont(new Font("Dialog", Font.BOLD, 80));
		label.setBounds(0, 0, 1232, 131);
		panel.add(label);
		
		JLabel lblVendorId = new JLabel("Vendor ID");
		lblVendorId.setForeground(Color.YELLOW);
		lblVendorId.setFont(new Font("Dialog", Font.BOLD, 20));
		lblVendorId.setBounds(33, 184, 183, 39);
		panel.add(lblVendorId);
		
		JLabel lblNewLabel = new JLabel("Vendor Name");
		lblNewLabel.setForeground(Color.YELLOW);
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 20));
		lblNewLabel.setBounds(33, 252, 183, 43);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Phone");
		lblNewLabel_1.setForeground(Color.YELLOW);
		lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD, 20));
		lblNewLabel_1.setBounds(33, 325, 183, 33);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Email");
		lblNewLabel_2.setForeground(Color.YELLOW);
		lblNewLabel_2.setFont(new Font("Dialog", Font.BOLD, 20));
		lblNewLabel_2.setBounds(33, 397, 183, 33);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Address");
		lblNewLabel_3.setForeground(Color.YELLOW);
		lblNewLabel_3.setFont(new Font("Dialog", Font.BOLD, 20));
		lblNewLabel_3.setBounds(33, 465, 183, 43);
		panel.add(lblNewLabel_3);
		
		txtid = new JTextField();
		txtid.setBounds(225, 184, 318, 39);
		panel.add(txtid);
		txtid.setColumns(10);
		
		txtname = new JTextField();
		txtname.setBounds(225, 254, 318, 39);
		panel.add(txtname);
		txtname.setColumns(10);
		
		txtphone = new JTextField();
		txtphone.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c=e.getKeyChar();
				if(!(Character.isDigit(c)) || (c==KeyEvent.VK_BACK_SPACE) || (c==KeyEvent.VK_DELETE))
				{
					Toolkit t = Toolkit.getDefaultToolkit();
				    t.beep();
					e.consume();
				}
			}
		});
		txtphone.setBounds(225, 322, 318, 39);
		panel.add(txtphone);
		txtphone.setColumns(10);
		
		txtemail = new JTextField();
		txtemail.setBounds(225, 394, 318, 39);
		panel.add(txtemail);
		txtemail.setColumns(10);
		
		txtaddress = new JTextField();
		txtaddress.setBounds(225, 467, 318, 39);
		panel.add(txtaddress);
		txtaddress.setColumns(10);
		
		Button add_btn = new Button("ADD");
		add_btn.setFont(new Font("Dialog", Font.BOLD, 20));
		add_btn.setForeground(Color.WHITE);
		add_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Object[] RowData=new Object[5];
				RowData[0]=txtid.getText();
				RowData[1]=txtname.getText();
				RowData[2]=txtphone.getText();
				RowData[3]=txtemail.getText();
				RowData[4]=txtaddress.getText();
				model.addRow(RowData);
				
				save("/home/kamalesh/Desktop/NewExcelFile.xlsx",2);
				
				txtid.setText("");
				txtname.setText("");
				txtphone.setText("");
				txtemail.setText("");
				txtaddress.setText("");
				
				
			}});
		add_btn.setBackground(Color.BLACK);
		add_btn.setActionCommand("New button");
		add_btn.setBounds(311, 599, 146, 69);
		panel.add(add_btn);
		
		Button edit_btn = new Button("SHOW");
		edit_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				table(model,"/home/kamalesh/Desktop/NewExcelFile.xlsx",2);
				
				
				
			}
		});
		edit_btn.setForeground(Color.WHITE);
		edit_btn.setFont(new Font("Dialog", Font.BOLD, 20));
		edit_btn.setBackground(Color.BLACK);
		edit_btn.setActionCommand("Purchase button");
		edit_btn.setBounds(546, 599, 146, 69);
		panel.add(edit_btn);
		
		Button delete_btn = new Button("DELETE");
		delete_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int x = vendor_table.getSelectedRow();
				try {
					deleteRow("/home/kamalesh/Desktop/NewExcelFile.xlsx",x);
					model.removeRow(x);
		            JOptionPane.showMessageDialog(null, "Selected vendor deleted successfully");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			    
	                
				
			}
		});
		delete_btn.setFont(new Font("Dialog", Font.BOLD, 20));
		delete_btn.setForeground(Color.WHITE);
		delete_btn.setBackground(Color.BLACK);
		delete_btn.setActionCommand("New Button");
		delete_btn.setBounds(781, 599, 146, 69);
		panel.add(delete_btn);
		
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
		btnBack.setFont(new Font("Dialog", Font.BOLD, 20));
		btnBack.setForeground(Color.WHITE);
		btnBack.setBounds(89, 599, 133, 69);
		panel.add(btnBack);
		
		Button clean = new Button("CLEAR");
		clean.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtid.setText("");
				txtname.setText("");
				txtphone.setText("");
				txtemail.setText("");
				txtaddress.setText("");
			}
		});
		clean.setForeground(Color.WHITE);
		clean.setFont(new Font("Dialog", Font.BOLD, 20));
		clean.setBackground(Color.BLACK);
		clean.setActionCommand("New Button");
		clean.setBounds(1016, 599, 146, 69);
		panel.add(clean);
	}
		public void save(String filename, int sheetno) {
			InputStream inp = null;
			try {
				inp = new FileInputStream(new File(filename));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		    Workbook wb = null;
			try {
				wb = WorkbookFactory.create(inp);
			} catch (InvalidFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		    Sheet sheet = wb.getSheetAt(sheetno); 
		    int num = sheet.getLastRowNum(); 
		    Row row = sheet.createRow(++num); 
		    
		    int nRow = model.getRowCount(), nCol = model.getColumnCount();
		    for (int i = 0 ; i < (nRow); i++) {
		        for (int j = 0 ; j < nCol ; j++) {
		        	
		        	row.createCell(j).setCellValue(model.getValueAt(i, j).toString());
		        }
		    }

		    
		        
		        // Now this Write the output to a file 
		        FileOutputStream fileOut = null;
				try {
					fileOut = new FileOutputStream(filename);
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
		    try {
				wb.write(fileOut);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		    try {
				fileOut.close();
	            JOptionPane.showMessageDialog(null, "Vendor added  successfully");

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		    
		    
			
			
			}
			
		public boolean deleteRow(String sheetName, int rowNo) throws IOException {

		    XSSFWorkbook workbook = null;
		    XSSFSheet sheet = null;

		    try {
		        FileInputStream file = new FileInputStream(new File(sheetName));
		        workbook = new XSSFWorkbook(file);
		        sheet = workbook.getSheetAt(2);
		        if (sheet == null) {
		            return false;
		        }
		        int lastRowNum = sheet.getLastRowNum();
		        if (rowNo >= 0 && rowNo < lastRowNum) {
		            sheet.shiftRows(rowNo + 1, lastRowNum, -1);
		        }
		        if (rowNo == lastRowNum) {
		            XSSFRow removingRow=sheet.getRow(rowNo);
		            if(removingRow != null) {
		                sheet.removeRow(removingRow);
		            }
		        }
		        file.close();
		        FileOutputStream outFile = new FileOutputStream(new File(sheetName));
		        workbook.write(outFile);
		        outFile.close();


		    } catch(Exception e) {
		        throw e;
		    } 
		    
		    return false;
		}
			
		void table(DefaultTableModel model,String filename,int SheetNo)
		{
			@SuppressWarnings("unused")
			int cnt=0,g=0;
			try
	        {
	            FileInputStream file = new FileInputStream(new File(filename));
	            XSSFWorkbook workbook = new XSSFWorkbook(file);
	            XSSFSheet sheet = workbook.getSheetAt(SheetNo);
	            int colCount = sheet.getRow(SheetNo).getLastCellNum();
	            
	            Object[] RowData=new Object[colCount];
	            Iterator<Row> rowIterator = sheet.iterator();
	            while (rowIterator.hasNext()) 
	            {
	                Row row = rowIterator.next();
	                Iterator<Cell> cellIterator = row.cellIterator();
	                while (cellIterator.hasNext()) 
	                {
	                    Cell cell = cellIterator.next();
	                    switch (cell.getCellType()) 
	                    {
	                        case Cell.CELL_TYPE_NUMERIC:                   
	                            RowData[cell.getColumnIndex()]=cell.getNumericCellValue();
	                            break;
	                        case Cell.CELL_TYPE_STRING:
	                        	RowData[cell.getColumnIndex()]=cell.getStringCellValue();
	                            break;
	                        case Cell.CELL_TYPE_FORMULA:
	                        	RowData[cell.getColumnIndex()]=cell.getNumericCellValue();
	                        	break;
	                    }
	                    g=cell.getRow().getRowNum();
	                }
	                
	                if(cnt==0)
	                {
	                	model.setColumnIdentifiers(RowData);
	                	vendor_table.getColumnModel().getColumn(0).setPreferredWidth(300);
	                	cnt++;
	                }
	                else
	                {
	                	model.addRow(RowData);
	                	
	                }
	                int k=0;
	                while(colCount!=k)
	                {
	                	RowData[k]=null;
	                	k++;
	                }  
	            }
	            file.close();
	           
	        } 
	        catch (Exception e1) 
	        {
	            e1.printStackTrace();
	        }
		}
	}

		
	
	

