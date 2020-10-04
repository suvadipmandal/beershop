package management;

import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import javax.swing.JTable;

public class Sale {

	JFrame frame;
	private JPanel contentPane;
	private JTextField QttText;
	private JTextField PriceText;
	private JTextField TotPrice;
	private JTextField RecitText;
	private JTextField ItemText;
	private JTable table;
	private JTextField BarText;
	DefaultTableModel model = new DefaultTableModel(0,0);

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Sale window = new Sale();
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
	public Sale() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(0, 00, 1280, 720);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Sale");
		frame.setBackground(Color.WHITE);
		frame.setForeground(Color.DARK_GRAY);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		frame.setContentPane(contentPane);
		
		Panel panel = new Panel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setForeground(Color.BLACK);
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		Label label = new Label("SALE");
		label.setForeground(Color.YELLOW);
		label.setAlignment(Label.CENTER);
		label.setFont(new Font("Dialog", Font.BOLD, 80));
		label.setBounds(10, 0, 1234, 93);
		panel.add(label);
		
		JLabel lblNewLabel = new JLabel("RECIPT NO");
		lblNewLabel.setForeground(Color.YELLOW);
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 20));
		lblNewLabel.setBounds(10, 141, 214, 43);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("PRICE");
		lblNewLabel_1.setForeground(Color.YELLOW);
		lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD, 20));
		lblNewLabel_1.setBounds(10, 410, 214, 43);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("QUANTITY  BOTTLE");
		lblNewLabel_2.setForeground(Color.YELLOW);
		lblNewLabel_2.setFont(new Font("Dialog", Font.BOLD, 20));
		lblNewLabel_2.setBounds(10, 341, 214, 43);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("TOTAL PRICE");
		lblNewLabel_3.setForeground(Color.YELLOW);
		lblNewLabel_3.setFont(new Font("Dialog", Font.BOLD, 20));
		lblNewLabel_3.setBounds(10, 486, 214, 43);
		panel.add(lblNewLabel_3);
		
		QttText = new JTextField("0");
		QttText.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				
				int tprice=Integer.parseInt(QttText.getText())*(int) Math.round(Double.parseDouble(PriceText.getText()));
				TotPrice.setText(String.valueOf(tprice));
				
			}
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
		QttText.setBounds(249, 341, 221, 43);
		QttText.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel.add(QttText);
		QttText.setColumns(10);
		
		PriceText = new JTextField("1");
		PriceText.setEditable(false);
		PriceText.setBounds(249, 410, 221, 43);
		PriceText.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel.add(PriceText);
		PriceText.setColumns(10);
		
		TotPrice = new JTextField("0.00");
		TotPrice.setEditable(false);
		TotPrice.setBounds(249, 486, 221, 43);
		TotPrice.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel.add(TotPrice);
		TotPrice.setColumns(10);
		
		JButton btnSaleWithoutBill = new JButton("WITHOUT BILL");
		btnSaleWithoutBill.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				InputStream inp = null;
				try {
					inp = new FileInputStream("/home/kamalesh/Desktop/NewExcelFile.xls");
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} 
			    Workbook wb = null;
				try {
					wb = WorkbookFactory.create(inp);
				} catch (InvalidFormatException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} 
			    Sheet sheet = wb.getSheetAt(1); 
			    int num = sheet.getLastRowNum(); 
			   Row row = sheet.createRow(++num); 
			    
			    int nRow = model.getRowCount(), nCol = model.getColumnCount();
			    for (int i = 0 ; i < (nRow); i++)
			        for (int j = 0 ; j < nCol ; j++) {
			        	row.createCell(j).setCellValue(model.getValueAt(i, j).toString());
			        }    
			        // Now this Write the output to a file 
			        FileOutputStream fileOut = null;
					try {
						fileOut = new FileOutputStream(Suvadip.ExcelPath());
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} 
			    try {
					wb.write(fileOut);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} 
			    try {
					fileOut.close();
		            JOptionPane.showMessageDialog(null, "Item sale  successfully");

				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				
				
				}
			    }
		});
		btnSaleWithoutBill.setBorderPainted(false);
		btnSaleWithoutBill.setForeground(Color.WHITE);
		btnSaleWithoutBill.setBackground(Color.BLACK);
		btnSaleWithoutBill.setFont(new Font("Dialog", Font.BOLD, 20));
		btnSaleWithoutBill.setBounds(695, 540, 194, 66);
		panel.add(btnSaleWithoutBill);
		
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
		btnBack.setFont(new Font("Dialog", Font.BOLD, 15));
		btnBack.setForeground(Color.WHITE);
		btnBack.setBounds(1112, 144, 132, 40);
		panel.add(btnBack);
		
		JLabel lblNewLabel_4 = new JLabel("ITEM NAME");
		lblNewLabel_4.setForeground(Color.YELLOW);
		lblNewLabel_4.setFont(new Font("Dialog", Font.BOLD, 20));
		lblNewLabel_4.setBounds(10, 270, 214, 43);
		panel.add(lblNewLabel_4);
		
		RecitText = new JTextField();
		RecitText.setEnabled(true);
		RecitText.setFont(new Font("Tahoma", Font.BOLD, 20));
		RecitText.setColumns(10);
		RecitText.setBounds(249, 141, 221, 43);
		panel.add(RecitText);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RecitText.setText("");
				BarText.setText("");
				TotPrice.setText("0.00");
				QttText.setText("0");
				PriceText.setText("1");
				ItemText.setText("");
			}
		});
		btnClear.setForeground(Color.WHITE);
		btnClear.setFont(new Font("Dialog", Font.BOLD, 15));
		btnClear.setBorderPainted(false);
		btnClear.setBackground(Color.BLACK);
		btnClear.setBounds(1112, 245, 132, 40);
		panel.add(btnClear);
		
		ItemText = new JTextField();
		ItemText.addKeyListener(new KeyAdapter() {
			@Override 
			public void keyPressed(KeyEvent e) {
//				price();
				char c=e.getKeyChar();
				if(c==KeyEvent.VK_ENTER)
				{
					for(int j=0;j<data.length;j++)
					{
						String s=data[j][0].toString();
						if(ItemText.getText().trim().equals(s.trim()))
						{
							PriceText.setText(data[j][1].toString());
						}
					}
				}
				
			}
		});
		ItemText.setColumns(10);
		ItemText.setBounds(249, 270, 221, 43);
		ItemText.setFont(new Font("Tahoma", Font.BOLD, 15));
		panel.add(ItemText);
		ArrayList<String> words = new ArrayList<>(Suvadip.word(Suvadip.ExcelPath()));
		@SuppressWarnings("unused")
		AutoSuggestor autoSuggestor = new AutoSuggestor(ItemText, frame, null, Color.WHITE.brighter(), Color.BLUE, Color.RED, 0.75f) {
            boolean wordTyped(String typedWord) {
            	setDictionary(words);
                return super.wordTyped(typedWord);//now call super to check for any matches against newest dictionary
            }
        };
		price();
		table = new JTable();
		Object[] columns = {"Recipt no","Bar Code","Name","QT Bottle","price","Total Amount"};
		model.setColumnIdentifiers(columns);
		table.setModel(model);
		table.getColumnModel().getColumn(1).setPreferredWidth(200);
		Font font = new Font("",1,15);
		table.setFont(font);
		table.setRowHeight(30);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(491, 144, 602, 385);
		panel.add(scrollPane);
		
		JButton btnAddItem = new JButton("Add Item");
		btnAddItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Object[] RowData=new Object[10];
				RowData[0]=RecitText.getText();
				RowData[1]=BarText.getText();
				RowData[2]=ItemText.getText();
				RowData[3]=QttText.getText();
				RowData[4]=PriceText.getText();
				RowData[5]=TotPrice.getText();
				if(QttText.getText().equals("0")||QttText.getText().isEmpty())
				{
					 JOptionPane.showMessageDialog(null, "Please Enter The QTT Bottle");
				}
				else
				{
					
				}
				model.addRow(RowData);
			}
		});
		btnAddItem.setForeground(Color.WHITE);
		btnAddItem.setFont(new Font("Dialog", Font.BOLD, 20));
		btnAddItem.setBorderPainted(false);
		btnAddItem.setBackground(Color.BLACK);
		btnAddItem.setBounds(491, 540, 194, 66);
		panel.add(btnAddItem);
		
		JButton btnPrintBill = new JButton("PRINT BILL");
		btnPrintBill.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				InputStream inp = null;
				try {
					inp = new FileInputStream(Suvadip.ExcelPath());
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} 
			    Workbook wb = null;
				try {
					wb = WorkbookFactory.create(inp);
				} catch (InvalidFormatException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} 
			    Sheet sheet = wb.getSheetAt(1); 
			    int num = sheet.getLastRowNum(); 
			   Row row = sheet.createRow(++num); 
			    
			    int nRow = model.getRowCount(), nCol = model.getColumnCount();
			    for (int i = 0 ; i < (nRow); i++)
			        for (int j = 0 ; j < nCol ; j++) {
			        	row.createCell(j).setCellValue(model.getValueAt(i, j).toString());
			        }    
			        // Now this Write the output to a file 
			        FileOutputStream fileOut = null;
					try {
						fileOut = new FileOutputStream(Suvadip.ExcelPath());
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} 
			    try {
					wb.write(fileOut);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} 
			    try {
					fileOut.close();
		            JOptionPane.showMessageDialog(null, "Item sale  successfully");

				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				
				
				}
				
			}
		});
		btnPrintBill.setForeground(Color.WHITE);
		btnPrintBill.setFont(new Font("Dialog", Font.BOLD, 20));
		btnPrintBill.setBorderPainted(false);
		btnPrintBill.setBackground(Color.BLACK);
		btnPrintBill.setBounds(899, 540, 194, 66);
		panel.add(btnPrintBill);
		
		JButton btnClearBill = new JButton("Clear Bill");
		btnClearBill.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				model.setRowCount(0);
			}
		});
		btnClearBill.setForeground(Color.WHITE);
		btnClearBill.setFont(new Font("Dialog", Font.BOLD, 15));
		btnClearBill.setBorderPainted(false);
		btnClearBill.setBackground(Color.BLACK);
		btnClearBill.setBounds(1112, 296, 132, 40);
		panel.add(btnClearBill);
		
		BarText = new JTextField();
		BarText.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
			}
		});
		BarText.setFont(new Font("Tahoma", Font.BOLD, 20));
		BarText.setColumns(10);
		BarText.setBounds(249, 204, 221, 43);
		panel.add(BarText);
		
		JLabel lblNewLabel_5 = new JLabel("BAR CODE");
		lblNewLabel_5.setForeground(Color.YELLOW);
		lblNewLabel_5.setFont(new Font("Dialog", Font.BOLD, 20));
		lblNewLabel_5.setBounds(10, 204, 214, 43);
		panel.add(lblNewLabel_5);
		
		JButton btnDelete = new JButton("DELETE");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int j=table.getSelectedRow();
				if(j==-1)
				{
					String st="Please Select Item Which You Delete";
					JOptionPane.showMessageDialog(null, st);
				}
				else
					model.removeRow(j);
			}
		});
		btnDelete.setForeground(Color.WHITE);
		btnDelete.setFont(new Font("Dialog", Font.BOLD, 15));
		btnDelete.setBorderPainted(false);
		btnDelete.setBackground(Color.BLACK);
		btnDelete.setBounds(1112, 195, 132, 40);
		panel.add(btnDelete);
		
	}
	
	Object[][] data=new Object[Suvadip.getLastRow(Suvadip.ExcelPath(), 0)][2];
	void price()
	{
		for(int i=0;i<Suvadip.getLastRow(Suvadip.ExcelPath(), 0);i++)
		{
			for(int j=0;j<2;j++)
			{
				if(j==0) {
					data[i][j]=Suvadip.ReadCellData(i, 0);
//					System.out.println(Suvadip.ReadCellData(i, 0));
				}
				else {
					data[i][j]=Suvadip.ReadCellData(i, 4);
//					System.out.println(Suvadip.ReadCellData(i, 4));
				}
			}
		}
	}
}
