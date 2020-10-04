package management;

import java.awt.Color;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Label;
import java.awt.Panel;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.BoxLayout;
import javax.swing.JTable;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class Purchase {

	
	JFrame frame;
	private JPanel contentPane;
	private JTextField billNoText;
	private JTextField Amount;
	private JTextField Box;
	private JTextField itemName;
	private JTextField chqNO;
	private static JTable table;
	private JTextField billDate;
	private JTextField billDate2;
	private JTextField Amount2;
	private JTextField tdsNo;

	/**
	 * Launch the application.
	 */
	DefaultTableModel model = new DefaultTableModel(0,0);

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Purchase window = new Purchase();
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
	public Purchase() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(0, 0, 1366, 720);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.X_AXIS));
		
		
		
		Panel panel = new Panel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setFont(new Font("Dialog", Font.PLAIN, 17));
		contentPane.add(panel);
		panel.setLayout(null);
		
		table = new JTable();
		Object[] columns = {"Date","Bill No","Amount","Cheque No","Date","Amount","TDS","Item Name","Quantity","Box"};
		model.setColumnIdentifiers(columns);
		table.setModel(model);
		Font font = new Font("",1,22);
		
		billDate = new JTextField();
		billDate.setFont(new Font("Tahoma", Font.BOLD, 20));
		billDate.setColumns(10);
		billDate.setBounds(360, 164, 288, 32);
		panel.add(billDate);
		
		
		table.setFont(font);
		table.setRowHeight(30);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(691, 170, 614, 344);
		panel.add(scrollPane);
		
		Label label = new Label("PURCHASE");
		label.setAlignment(Label.CENTER);
		label.setForeground(Color.YELLOW);
		label.setBackground(Color.DARK_GRAY);
		label.setFont(new Font("Dialog", Font.BOLD, 70));
		label.setBounds(0, 0, 1330, 105);
		panel.add(label);
		
		JLabel lblNewLabel_1 = new JLabel("BILL NO");
		lblNewLabel_1.setForeground(Color.YELLOW);
		lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD, 20));
		lblNewLabel_1.setBounds(41, 207, 276, 32);
		panel.add(lblNewLabel_1);
		
		JLabel lblName = new JLabel("ITEM NAME");
		lblName.setForeground(Color.YELLOW);
		lblName.setFont(new Font("Dialog", Font.BOLD, 20));
		lblName.setBounds(41, 508, 276, 32);
		panel.add(lblName);
		
		JLabel lblName_1 = new JLabel("QUANTITY");
		lblName_1.setForeground(Color.YELLOW);
		lblName_1.setFont(new Font("Dialog", Font.BOLD, 20));
		lblName_1.setBounds(41, 554, 276, 32);
		panel.add(lblName_1);
		
		JLabel lblAmount = new JLabel("BOX");
		lblAmount.setForeground(Color.YELLOW);
		lblAmount.setFont(new Font("Dialog", Font.BOLD, 20));
		lblAmount.setBounds(41, 597, 276, 32);
		panel.add(lblAmount);
		
		JLabel lblTotalAmount = new JLabel("CHEQUE NO");
		lblTotalAmount.setForeground(Color.YELLOW);
		lblTotalAmount.setFont(new Font("Dialog", Font.BOLD, 20));
		lblTotalAmount.setBounds(41, 294, 277, 32);
		panel.add(lblTotalAmount);
		
		JLabel lblNewLabel_2 = new JLabel("AMOUNT");
		lblNewLabel_2.setForeground(Color.YELLOW);
		lblNewLabel_2.setFont(new Font("Dialog", Font.BOLD, 20));
		lblNewLabel_2.setBounds(41, 250, 276, 32);
		panel.add(lblNewLabel_2);
		
		JLabel lblAvailableItem = new JLabel("ITEMS");
		lblAvailableItem.setForeground(Color.LIGHT_GRAY);
		lblAvailableItem.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblAvailableItem.setBounds(691, 134, 172, 25);
		panel.add(lblAvailableItem);
		
		JLabel lblNewLabel_1_1 = new JLabel("DATE");
		lblNewLabel_1_1.setForeground(Color.YELLOW);
		lblNewLabel_1_1.setFont(new Font("Dialog", Font.BOLD, 20));
		lblNewLabel_1_1.setBounds(41, 164, 276, 32);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblAmo = new JLabel("DATE");
		lblAmo.setForeground(Color.YELLOW);
		lblAmo.setFont(new Font("Dialog", Font.BOLD, 20));
		lblAmo.setBounds(41, 336, 277, 32);
		panel.add(lblAmo);
		
		JLabel lblTotalAmount_1_1 = new JLabel("AMOUNT");
		lblTotalAmount_1_1.setForeground(Color.YELLOW);
		lblTotalAmount_1_1.setFont(new Font("Dialog", Font.BOLD, 20));
		lblTotalAmount_1_1.setBounds(41, 379, 277, 32);
		panel.add(lblTotalAmount_1_1);
		
		JLabel lblTotalAmount_1_1_1 = new JLabel("TDS");
		lblTotalAmount_1_1_1.setForeground(Color.YELLOW);
		lblTotalAmount_1_1_1.setFont(new Font("Dialog", Font.BOLD, 20));
		lblTotalAmount_1_1_1.setBounds(41, 422, 277, 32);
		panel.add(lblTotalAmount_1_1_1);
		
		billNoText = new JTextField();
		billNoText.setFont(new Font("Tahoma", Font.BOLD, 20));
		billNoText.setBounds(360, 207, 288, 32);
		panel.add(billNoText);
		billNoText.setColumns(10);
		
		Amount = new JTextField("0");
		Amount.setFont(new Font("Tahoma", Font.BOLD, 20));
		Amount.addKeyListener(new KeyAdapter() {
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
		Amount.setBounds(360, 250, 288, 32);
		panel.add(Amount);
		Amount.setColumns(10);
		
		JTextField Quantity = new JTextField("0");
		Quantity.setFont(new Font("Tahoma", Font.BOLD, 20));
		Quantity.addKeyListener(new KeyAdapter() {
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
		Quantity.setBounds(360, 554, 288, 32);
		panel.add(Quantity);
		
		Box = new JTextField("0");
		Box.setFont(new Font("Tahoma", Font.BOLD, 20));
		Box.addKeyListener(new KeyAdapter() {
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
		Box.setBounds(360, 597, 288, 32);
		panel.add(Box);
		Box.setColumns(10);
		
		JButton btnSetPrice = new JButton("SAVE");
		btnSetPrice.setBorderPainted(false);
		btnSetPrice.setForeground(Color.WHITE);
		btnSetPrice.setBackground(Color.BLACK);
		btnSetPrice.setFont(new Font("Dialog", Font.BOLD, 30));
		btnSetPrice.addActionListener(new ActionListener() {	
			public void actionPerformed(ActionEvent arg0) {
				
				InputStream inp = null;
				try {
					inp = new FileInputStream(Suvadip.ExcelPath());
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
			    Workbook wb = null;
				try {
					wb = WorkbookFactory.create(inp);
				} catch (InvalidFormatException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				} 
			    Sheet sheet = wb.getSheetAt(0); 
			    int num = sheet.getLastRowNum(); 
			    Row row = sheet.createRow(++num); 
			    
			    int nRow = model.getRowCount(), nCol = model.getColumnCount();
			    for (int i = 0 ; i < (nRow); i++)
			        for (int j = 0 ; j < nCol ; j++) {
//			        	row.createCell(j).setCellValue(model.getValueAt(i, j));
			        	if (model.getValueAt(i, j) instanceof String) {
			        		row.createCell(j).setCellValue((String) model.getValueAt(i, j));
		                } else if (model.getValueAt(i, j) instanceof Integer) {
		                	row.createCell(j).setCellValue((Integer) model.getValueAt(i, j));
		                }
			        }
			        FileOutputStream fileOut = null;
					try {
						fileOut = new FileOutputStream(Suvadip.ExcelPath());
					} catch (FileNotFoundException e) {
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
		            JOptionPane.showMessageDialog(null, "Item added  successfully");

				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
				int i=table.getRowCount();
				billDate.setText("");
				billNoText.setText("");
				Amount.setText("0");
				chqNO.setText("");
				billDate2.setText("");
				Amount2.setText("0");
				tdsNo.setText("0");
				Box.setText("0");
				itemName.setText("");
				Quantity.setText("0");
				while(i!=0)
				{
					model.removeRow(i-1);
					i--;
				}				
		}
		});
		
		itemName = new JTextField();
		itemName.setFont(new Font("Tahoma", Font.BOLD, 20));
		itemName.setColumns(10);
		itemName.setBounds(360, 508, 288, 32);
		panel.add(itemName);
		ArrayList<String> words = new ArrayList<>(Suvadip.word(Suvadip.ExcelPath()));
		@SuppressWarnings("unused")
		AutoSuggestor autoSuggestor = new AutoSuggestor(itemName, frame, null, Color.WHITE.brighter(), Color.BLUE, Color.RED, 0.75f) {
            boolean wordTyped(String typedWord) {
            	setDictionary(words);
                return super.wordTyped(typedWord);//now call super to check for any matches against newest dictionary
            }
        };
		
		billDate2 = new JTextField();
		billDate2.setFont(new Font("Tahoma", Font.BOLD, 20));
		billDate2.setColumns(10);
		billDate2.setBounds(360, 336, 288, 32);
		panel.add(billDate2);
		
		Amount2 = new JTextField("0");
		Amount2.setFont(new Font("Tahoma", Font.BOLD, 20));
		Amount2.addKeyListener(new KeyAdapter() {
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
		Amount2.setColumns(10);
		Amount2.setBounds(360, 379, 288, 32);
		panel.add(Amount2);
		
		tdsNo = new JTextField();
		tdsNo.setFont(new Font("Tahoma", Font.BOLD, 20));
		tdsNo.setColumns(10);
		tdsNo.setBounds(361, 422, 288, 32);
		panel.add(tdsNo);
		btnSetPrice.setBounds(927, 542, 216, 87);
		panel.add(btnSetPrice);
		
		JButton btnBack = new JButton("BACK");
		btnBack.setBorderPainted(false);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Home H =new Home();
				H.frame.setVisible(true);
				frame.setVisible(false);
			}
		});
		btnBack.setFont(new Font("Dialog", Font.BOLD, 15));
		btnBack.setForeground(Color.WHITE);
		btnBack.setBackground(Color.BLACK);
		btnBack.setBounds(1161, 542, 144, 38);
		panel.add(btnBack);
		
		JButton btnAddItem = new JButton("ADD ITEM");
		btnAddItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(itemName.getText().isEmpty()||Quantity.getText().equals(0)||Box.getText().equals(0))
				{
					JOptionPane.showMessageDialog(null, "Please Fill * Fields");
				}
				else
				{
					Object[] RowData=new Object[10];
					RowData[0]=billDate.getText();
					RowData[1]=billNoText.getText();
					RowData[2]=Integer.parseInt(Amount.getText());
					RowData[3]=Integer.parseInt(chqNO.getText());
					RowData[4]=billDate2.getText();
					RowData[5]=Integer.parseInt(Amount2.getText());
					RowData[6]=tdsNo.getText();					
					RowData[7]=itemName.getText();
					RowData[8]=Integer.parseInt(Quantity.getText());
					RowData[9]=Integer.parseInt(Box.getText());
					
					model.addRow(RowData);
				}
				
			}
		});
		btnAddItem.setForeground(Color.WHITE);
		btnAddItem.setFont(new Font("Dialog", Font.BOLD, 30));
		btnAddItem.setBorderPainted(false);
		btnAddItem.setBackground(Color.BLACK);
		btnAddItem.setBounds(691, 542, 216, 87);
		panel.add(btnAddItem);
		
		chqNO = new JTextField();
		chqNO.setFont(new Font("Tahoma", Font.BOLD, 20));
		chqNO.addKeyListener(new KeyAdapter() {
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
		chqNO.setColumns(10);
		chqNO.setBounds(361, 293, 288, 32);
		panel.add(chqNO);
		
		JButton btnClean = new JButton("CLEAN");
		btnClean.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				itemName.setText("");
				Quantity.setText("0");
				Box.setText("0");
			}
		});
		btnClean.setForeground(Color.WHITE);
		btnClean.setFont(new Font("Dialog", Font.BOLD, 15));
		btnClean.setBorderPainted(false);
		btnClean.setBackground(Color.BLACK);
		btnClean.setBounds(1161, 591, 144, 38);
		panel.add(btnClean);
		
		JLabel label_1 = new JLabel("*");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_1.setForeground(Color.RED);
		label_1.setBounds(658, 511, 27, 27);
		panel.add(label_1);
		
		JLabel label_1_1 = new JLabel("*");
		label_1_1.setForeground(Color.RED);
		label_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_1_1.setBounds(658, 554, 27, 27);
		panel.add(label_1_1);
		
		JLabel label_1_2 = new JLabel("*");
		label_1_2.setForeground(Color.RED);
		label_1_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_1_2.setBounds(658, 597, 27, 27);
		panel.add(label_1_2);
		
	}

}
