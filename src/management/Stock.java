package management;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.*;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.awt.event.*;

public class Stock {

	JFrame frame;
	private JPanel contentPane;
	private JTable table;
	private JTextField textField;
	JLabel warning;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Stock window = new Stock();
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
	public Stock() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings("unused")
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(0, 0, 1280, 720);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Total Stock");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		frame.setContentPane(contentPane);
		
		
		Panel panel = new Panel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setForeground(Color.DARK_GRAY);
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		Label label = new Label("CURRENT AVAILABLE STOCK");
		label.setForeground(Color.ORANGE);
		label.setAlignment(Label.CENTER);
		label.setFont(new Font("Dialog", Font.BOLD, 71));
		label.setBounds(0, 0, 1244, 115);
		panel.add(label);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				warning.setText("");
			}
		});

		DefaultTableModel model = new DefaultTableModel();
		table.setModel(model);
		Font font = new Font("",1,20);
		table.setFont(font);
		table.setRowHeight(25);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(76, 150, 1111, 409);
		panel.add(scrollPane);
		table(model,Suvadip.ExcelPath(),0);
	
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField.setBounds(651, 600, 327, 44);
		panel.add(textField);
		textField.setColumns(10);
		ArrayList<String> words = new ArrayList<>(Suvadip.word(Suvadip.ExcelPath()));
		AutoSuggestor autoSuggestor = new AutoSuggestor(textField, frame, null, Color.WHITE.brighter(), Color.BLUE, Color.RED, 0.75f) {
            boolean wordTyped(String typedWord) {
            	setDictionary(words);
                return super.wordTyped(typedWord);//now call super to check for any matches against newest dictionary
            }
        };
	
		
		JButton btnBack = new JButton("BACK");
		btnBack.setBorderPainted(false);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Home h=new Home();
				h.frame.setVisible(true);
				frame.setVisible(false);
			}
		});
		btnBack.setBackground(Color.BLACK);
		btnBack.setFont(new Font("Dialog", Font.BOLD, 15));
		btnBack.setForeground(Color.WHITE);
		btnBack.setBounds(76, 600, 166, 44);
		panel.add(btnBack);
		
		JButton btnSetPrice = new JButton("SET PRICE");
		btnSetPrice.addActionListener(new ActionListener() {
			int i=0;
			public void actionPerformed(ActionEvent e) {
				i=table.getSelectedRow();
				int rowNum=0;
				if(i!=-1)
				{	
					if(Suvadip.ck!=0)
					{
//						System.out.println("Search"+i);
						rowNum=Suvadip.ck;
						Suvadip.ck=0;
					}
					else
					{
//						System.out.println("touch"+i);
						rowNum=i;
					}
//					System.out.println(rowNum);
					try
					{
						Set_Price SP = new Set_Price(model.getValueAt(i, 0).toString(),(int) Math.round(Double.parseDouble(model.getValueAt(i, 5).toString())),rowNum);
						SP.setVisible(true);
						frame.dispose();
					}
					catch(NullPointerException e1)
					{
						Set_Price SP = new Set_Price("",0,rowNum);
						SP.setVisible(true);
						frame.dispose();
					}
					
				}
				else
				{
					warning.setText("Please select item on table");;
				}
			}
		});
		btnSetPrice.setForeground(Color.WHITE);
		btnSetPrice.setFont(new Font("Dialog", Font.BOLD, 15));
		btnSetPrice.setBorderPainted(false);
		btnSetPrice.setBackground(Color.BLACK);
		btnSetPrice.setBounds(263, 600, 166, 44);
		panel.add(btnSetPrice);
		
		warning = new JLabel("");
		warning.setForeground(Color.RED);
		warning.setFont(new Font("Tahoma", Font.BOLD, 15));
		warning.setBounds(76, 121, 300, 18);
		panel.add(warning);
		
		JButton btnSetBarcode = new JButton("SET BARCODE");
		btnSetBarcode.addActionListener(new ActionListener() {
			int i=0;
			public void actionPerformed(ActionEvent e) {
				i=table.getSelectedRow();
				int rowNum=0;
				if(i!=-1)
				{	
					if(Suvadip.ck!=0)
					{
//						System.out.println("Search"+i);
						rowNum=Suvadip.ck;
						Suvadip.ck=0;
					}
					else
					{
//						System.out.println("touch"+i);
						rowNum=i;
					}
					try
					{
						Set_Barcode BC = new Set_Barcode(model.getValueAt(i, 0).toString(),model.getValueAt(i, 1).toString(),rowNum);
						BC.setVisible(true);
						frame.dispose();
					}
					catch(NullPointerException e1)
					{
						Set_Barcode BC = new Set_Barcode(model.getValueAt(i, 0).toString(),"",rowNum);
						BC.setVisible(true);
						frame.dispose();
					}
				}
				else
				{
					warning.setText("Please select item on table");;
				}
			}
		});
		btnSetBarcode.setForeground(Color.WHITE);
		btnSetBarcode.setFont(new Font("Dialog", Font.BOLD, 15));
		btnSetBarcode.setBorderPainted(false);
		btnSetBarcode.setBackground(Color.BLACK);
		btnSetBarcode.setBounds(457, 600, 166, 44);
		panel.add(btnSetBarcode);
		
		JButton Seal_btn = new JButton("SEARCH ITEM");
		Seal_btn.setBorderPainted(false);
		Seal_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				model.setRowCount(0);
				table(model,"Sales And Purchase.xlsx",0);
				for(int i=0;i<model.getRowCount();i++)
				{
					try
					{
						if(model.getValueAt(i, 0).toString().equals(textField.getText().trim()))
						{
							Suvadip.ck=i;
//							System.out.println("chk"+i);
							table.addRowSelectionInterval(i,i);
							while(i!=0)
							{
								model.removeRow(i-1);
								i--;
							}
							break;
						}
					}
					catch(NullPointerException e1)
					{
						
					}
				}
			}
		});
		Seal_btn.setForeground(Color.WHITE);
		Seal_btn.setFont(new Font("Dialog", Font.BOLD, 20));
		Seal_btn.setBackground(Color.BLACK);
		Seal_btn.setActionCommand("New Button");
		Seal_btn.setBounds(987, 600, 200, 44);
		panel.add(Seal_btn);
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
            		table.getColumnModel().getColumn(0).setPreferredWidth(300);
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
