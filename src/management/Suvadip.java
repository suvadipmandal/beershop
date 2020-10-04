package management;

import java.io.*;

import java.util.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JWindow;
import javax.swing.KeyStroke;
import javax.swing.border.LineBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;

public class Suvadip {
	public static String DirPath()
	{
		String path=System.getProperty("user.home");
		String dirname="sksolution";
		if (System.getProperty("os.name").equals("Linux"))
		{
		path+="//"+dirname;
		return path;
		}
		else
		{
		path+="\\"+dirname;
		return path;
		}
	}
	public static String FilePath()
	{
		String path=System.getProperty("user.home");
		if(System.getProperty("os.name").equals("Linux"))
		{
			path += "//sksolution//userdata.sk";
			return path;
		}
		else
		{
			path +="\\sksolution\\userdata.sk";
			return path;
		}
	}
	
	public static String ExcelPath()
	{
		String path=System.getProperty("user.home");
		if(System.getProperty("os.name").equals("Linux"))
		{
			path += "//sksolution//userdata.xlsx";
			return path;
		}
		else
		{
			path +="\\sksolution\\userdata.xlsx";
			return path;
		}
	}
	
	static void CreateFile(String path)
	{
		File fo=new File(path);
		try {
			fo.createNewFile();
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
	}
	static void WriteFile(String data,String path)
	{
		try {
			FileWriter fw=new FileWriter(path);
			fw.write(data);
			fw.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
	public static String ShopName()
	{
		String p=System.getProperty("user.home");
		if(System.getProperty("os.name").equals("Linux"))
		{
			p += "//sksolution//userdata.sk";
		}
		else
		{
			p +="\\sksolution\\userdata.sk";
		}
		try {
		      File myObj = new File(p);
		      Scanner myReader = new Scanner(myObj);
		      String data = null;
		      while (myReader.hasNextLine()) {
		      data = myReader.nextLine();
		      }
		      myReader.close();
		      String[] spn=data.split(",");
		      return spn[0];	      
		    } catch (FileNotFoundException e) {
		      e.printStackTrace();
		      return "SHOP MANAGEMENT";
		    }
	}
	static String OwnerName()
	{
		String p=System.getProperty("user.home");
		if(System.getProperty("os.name").equals("Linux"))
		{
			p += "//sksolution//userdata.sk";
		}
		else
		{
			p +="\\sksolution\\userdata.sk";
		}
		try {
		      File myObj = new File(p);
		      Scanner myReader = new Scanner(myObj);
		      String data = null;
		      while (myReader.hasNextLine()) {
		      data = myReader.nextLine();
		      }
		      myReader.close();
		      String[] spn=data.split(",");
		      return spn[1];	      
		    } catch (FileNotFoundException e) {
		      e.printStackTrace();
		      return "Suvadip Mandal";
		    }
		
	}
	
	static String ReadCellData(int vRow, int vColumn)
	{  
	String value=null;          //variable for storing the cell value  
	Workbook wb=null;           //initialize Workbook null  
	try  
	{  
	FileInputStream fis=new FileInputStream(Suvadip.ExcelPath());  
	wb=new XSSFWorkbook(fis);  
	}  
	catch(FileNotFoundException e)  
	{  
	e.printStackTrace();  
	}  
	catch(IOException e1)  
	{  
	e1.printStackTrace();  
	}  
	Sheet sheet=wb.getSheetAt(0);   //getting the XSSFSheet object at given index  
	Row row=sheet.getRow(vRow); //returns the logical row  
	Cell cell=row.getCell(vColumn); //getting the cell representing the given column  
	try
	{
		switch (cell.getCellType()) 
	    {
	        case Cell.CELL_TYPE_NUMERIC:                   
	            value=String.valueOf(cell.getNumericCellValue());
	            //System.out.print(j+""+cell.getColumnIndex()+"\t");
	            break;
	        case Cell.CELL_TYPE_STRING:
	        	value=cell.getStringCellValue();
	        	//System.out.print(j+""+cell.getColumnIndex()+"\t");
	            break;
	        case Cell.CELL_TYPE_BLANK:
	        	value=" ";
	    } 
	}
	catch(NullPointerException e)
	{
		
	}
	
	return value;               //returns the cell value  
	}  
	
	static int getLastRow(String filename,int no)
	{
		try {
			FileInputStream file = new FileInputStream(new File(filename));
            XSSFWorkbook workbook = new XSSFWorkbook(file);
            XSSFSheet sheet = workbook.getSheetAt(no);
			return sheet.getLastRowNum();
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	static int getLastColumn(String filename,int no)
	{
		try {
			FileInputStream file = new FileInputStream(new File(filename));
            XSSFWorkbook workbook = new XSSFWorkbook(file);
            XSSFSheet sheet = workbook.getSheetAt(no);
			return sheet.getRow(no).getLastCellNum();
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	static Object[][] ReadExcel(String filename)
	{
		Object datas[][] = null;
		int j=0;
		try
        {
            FileInputStream file = new FileInputStream(new File(filename));
            XSSFWorkbook workbook = new XSSFWorkbook(file);
            XSSFSheet sheet = workbook.getSheetAt(1);
            XSSFRow collum = null;
            collum= sheet.getRow(1);
            int colCount = collum.getLastCellNum();
            int rowCount = sheet.getLastRowNum();
            datas=new Object[rowCount][colCount];
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
                            datas[j][cell.getColumnIndex()]=cell.getNumericCellValue();
                            //System.out.print(j+""+cell.getColumnIndex()+"\t");
                            break;
                        case Cell.CELL_TYPE_STRING:
                        	datas[j][cell.getColumnIndex()]=cell.getStringCellValue();
                        	//System.out.print(j+""+cell.getColumnIndex()+"\t");
                            break;
                    }
                }
                System.out.println();
                j++;
            }
            file.close();
            
        } 
        catch (Exception e1) 
        {
            e1.printStackTrace();
        }
		return datas;
	}
	static int ck=0;
	
	
	static ArrayList<String> word(String filename)
	{
		
		ArrayList<String> words = new ArrayList<>();
        int j=getLastRow(filename, 0);
//        if(ck==0)
//        {
        for(int i=0;i<j;i++)
        {
        	try
            {
            	
            	words.add(Suvadip.ReadCellData(i, 7));
            }
            catch(NullPointerException e)
            {
            	e.getStackTrace();
            }
        }
//        ck++;       
//        }
		return words;
	}
	
	static void update(int price,int row) throws IOException {
        FileInputStream input_document = new FileInputStream(new File(Suvadip.ExcelPath()));
        XSSFWorkbook my_xlsx_workbook = new XSSFWorkbook(input_document); 
        XSSFSheet my_worksheet = my_xlsx_workbook.getSheetAt(0);
        Cell cell = null; 
        cell = my_worksheet.getRow(row).getCell(1);
        try
        {
        	cell.setCellValue(price);
        	System.out.print(price);
        }
        catch(NullPointerException e)
        {
        	System.out.println("Null value");
        }
        
        input_document.close();
        FileOutputStream output_file =new FileOutputStream(new File(Suvadip.ExcelPath()));
        my_xlsx_workbook.write(output_file);
        output_file.close();
		                
	}
	
	static void update(String price,int row) throws IOException {
        FileInputStream input_document = new FileInputStream(new File(Suvadip.ExcelPath()));
        XSSFWorkbook my_xlsx_workbook = new XSSFWorkbook(input_document); 
        XSSFSheet my_worksheet = my_xlsx_workbook.getSheetAt(0);
        Cell cell = null; 
        cell = my_worksheet.getRow(row).getCell(1);
        try
        {
        	cell.setCellValue(price);
        	System.out.print(price);
        }
        catch(NullPointerException e)
        {
        	System.out.println("Null value");
        }
        
        input_document.close();
        FileOutputStream output_file =new FileOutputStream(new File(Suvadip.ExcelPath()));
        my_xlsx_workbook.write(output_file);
        output_file.close();
		                
	}
	
	static void WriteExcel(String path,int page,int col,String data)
	{
		XSSFWorkbook workbook = new XSSFWorkbook(); 
        
        //Create a blank sheet
        XSSFSheet sheet = workbook.createSheet(Suvadip.ExcelPath());
          
      /*  //This data needs to be written (Object[])
        Map<String, Object[]> data = new TreeMap<String, Object[]>();
        data.put("1", new Object[] {"ID", "NAME", "LASTNAME","TOTAL"});
        data.put("2", new Object[] {1, "Amit", "Shukla"});
        data.put("3", new Object[] {2, "Lokesh", "Gupta"});
        data.put("4", new Object[] {3, "John", "Adwards"});
        data.put("7", new Object[] {4, "Brian", "Schultz"});
        
        
          
        //Iterate over data and write to sheet
        Set<String> keyset = data.keySet();
        int rownum = 0;
        for (String key : keyset)
        {
            Row row = sheet.createRow(rownum++);
            Object [] objArr = data.get(key);
            int cellnum = 0;
            for (Object obj : objArr)
            {
               Cell cell = row.createCell(cellnum++);
               if(obj instanceof String)
                    cell.setCellValue((String)obj);
                else if(obj instanceof Integer)
                    cell.setCellValue((Integer)obj);
            }
        }*/
        
//        int num=sheet.getLastRowNum();
//        for(num=0;num<5;num++)
//        {
//        	
//        
        Row row=sheet.createRow(page);
//        for(int j=0;j<4;j++)
//        {
        	row.createCell(col).setCellValue(data);
//        }
//        }
        try
        {
            //Write the workbook in file system
            FileOutputStream out = new FileOutputStream(new File(path));
            workbook.write(out);
            out.close();
            System.out.println(path+" written successfully on disk.");
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
	}
}



class AutoSuggestor {

    private final JTextField textField;
    private final Window container;
    private JPanel suggestionsPanel;
    private JWindow autoSuggestionPopUpWindow;
    private String typedWord;
    private final ArrayList<String> dictionary = new ArrayList<>();
    private int currentIndexOfSpace, tW, tH;
    private DocumentListener documentListener = new DocumentListener() {
        @Override
        public void insertUpdate(DocumentEvent de) {
            checkForAndShowSuggestions();
        }

        @Override
        public void removeUpdate(DocumentEvent de) {
            checkForAndShowSuggestions();
        }

        @Override
        public void changedUpdate(DocumentEvent de) {
            checkForAndShowSuggestions();
        }
    };
    private final Color suggestionsTextColor;
    private final Color suggestionFocusedColor;

    public AutoSuggestor(JTextField textField, Window mainWindow, ArrayList<String> words, Color popUpBackground, Color textColor, Color suggestionFocusedColor, float opacity) {
        this.textField = textField;
        this.suggestionsTextColor = textColor;
        this.container = mainWindow;
        this.suggestionFocusedColor = suggestionFocusedColor;
        this.textField.getDocument().addDocumentListener(documentListener);

        setDictionary(words);

        typedWord = "";
        currentIndexOfSpace = 0;
        tW = 0;
        tH = 0;

        autoSuggestionPopUpWindow = new JWindow(mainWindow);
        autoSuggestionPopUpWindow.setOpacity(opacity);

        suggestionsPanel = new JPanel();
        suggestionsPanel.setLayout(new GridLayout(0, 1));
        suggestionsPanel.setBackground(popUpBackground);

        addKeyBindingToRequestFocusInPopUpWindow();
    }

    @SuppressWarnings("serial")
	private void addKeyBindingToRequestFocusInPopUpWindow() {
        textField.getInputMap(JComponent.WHEN_FOCUSED).put(KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0, true), "Down released");
        textField.getActionMap().put("Down released", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent ae) {//focuses the first label on popwindow
                for (int i = 0; i < suggestionsPanel.getComponentCount(); i++) {
                    if (suggestionsPanel.getComponent(i) instanceof SuggestionLabel) {
                        ((SuggestionLabel) suggestionsPanel.getComponent(i)).setFocused(true);
                        autoSuggestionPopUpWindow.toFront();
                        autoSuggestionPopUpWindow.requestFocusInWindow();
                        suggestionsPanel.requestFocusInWindow();
                        suggestionsPanel.getComponent(i).requestFocusInWindow();
                        break;
                    }
                }
            }
        });
        suggestionsPanel.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0, true), "Down released");
        suggestionsPanel.getActionMap().put("Down released", new AbstractAction() {
            int lastFocusableIndex = 0;

            @Override
            public void actionPerformed(ActionEvent ae) {//allows scrolling of labels in pop window (I know very hacky for now :))

                ArrayList<SuggestionLabel> sls = getAddedSuggestionLabels();
                int max = sls.size();

                if (max > 1) {//more than 1 suggestion
                    for (int i = 0; i < max; i++) {
                        SuggestionLabel sl = sls.get(i);
                        if (sl.isFocused()) {
                            if (lastFocusableIndex == max - 1) {
                                lastFocusableIndex = 0;
                                sl.setFocused(false);
                                autoSuggestionPopUpWindow.setVisible(false);
                                setFocusToTextField();
                                checkForAndShowSuggestions();//fire method as if document listener change occured and fired it

                            } else {
                                sl.setFocused(false);
                                lastFocusableIndex = i;
                            }
                        } else if (lastFocusableIndex <= i) {
                            if (i < max) {
                                sl.setFocused(true);
                                autoSuggestionPopUpWindow.toFront();
                                autoSuggestionPopUpWindow.requestFocusInWindow();
                                suggestionsPanel.requestFocusInWindow();
                                suggestionsPanel.getComponent(i).requestFocusInWindow();
                                lastFocusableIndex = i;
                                break;
                            }
                        }
                    }
                } else {//only a single suggestion was given
                    autoSuggestionPopUpWindow.setVisible(false);
                    setFocusToTextField();
                    checkForAndShowSuggestions();
                    //fire method as if document listener change occured and fired it
                }
            }
        });
    }

    private void setFocusToTextField() {
        container.toFront();
        container.requestFocusInWindow();
        textField.requestFocusInWindow();
    }

    public ArrayList<SuggestionLabel> getAddedSuggestionLabels() {
        ArrayList<SuggestionLabel> sls = new ArrayList<>();
        for (int i = 0; i < suggestionsPanel.getComponentCount(); i++) {
            if (suggestionsPanel.getComponent(i) instanceof SuggestionLabel) {
                SuggestionLabel sl = (SuggestionLabel) suggestionsPanel.getComponent(i);
                sls.add(sl);
            }
        }
        return sls;
    }

    private void checkForAndShowSuggestions() {
        typedWord = getCurrentlyTypedWord();

        suggestionsPanel.removeAll();//remove previos words/jlabels that were added

        //used to calcualte size of JWindow as new Jlabels are added
        tW = 0;
        tH = 0;

        boolean added = wordTyped(typedWord);

        if (!added) {
            if (autoSuggestionPopUpWindow.isVisible()) {
                autoSuggestionPopUpWindow.setVisible(false);
            }
        } else {
            showPopUpWindow();
            setFocusToTextField();
        }
    }

    protected void addWordToSuggestions(String word) {
        SuggestionLabel suggestionLabel = new SuggestionLabel(word, suggestionFocusedColor, suggestionsTextColor, this);

        calculatePopUpWindowSize(suggestionLabel);

        suggestionsPanel.add(suggestionLabel);
    }

    public String getCurrentlyTypedWord() {
    	//get newest word after last white space if any or the first word if no white spaces
        String text = textField.getText();
        String wordBeingTyped = "";
        if (text.contains(" ")) {
            int tmp = text.lastIndexOf(" ");
            if (tmp >= currentIndexOfSpace) {
                currentIndexOfSpace = tmp;
                wordBeingTyped = text.substring(text.lastIndexOf(" "));
            }
        } else {
            wordBeingTyped = text;
        }
        return wordBeingTyped.trim();
    }

    private void calculatePopUpWindowSize(JLabel label) {
        //so we can size the JWindow correctly
        if (tW < label.getPreferredSize().width) {
            tW = label.getPreferredSize().width;
        }
        tH += label.getPreferredSize().height;
    }

    private void showPopUpWindow() {
        autoSuggestionPopUpWindow.getContentPane().add(suggestionsPanel);
        autoSuggestionPopUpWindow.setMinimumSize(new Dimension(textField.getWidth(), 30));
        autoSuggestionPopUpWindow.setSize(tW, tH);
        autoSuggestionPopUpWindow.setVisible(true);

        int windowX = 0;
        int windowY = 0;

        windowX = container.getX() + textField.getX() + 5;
        if (suggestionsPanel.getHeight() > autoSuggestionPopUpWindow.getMinimumSize().height) {
            windowY = container.getY() + textField.getY() + textField.getHeight() + autoSuggestionPopUpWindow.getMinimumSize().height;
        } else {
            windowY = container.getY() + textField.getY() + textField.getHeight() + autoSuggestionPopUpWindow.getHeight();
        }

        autoSuggestionPopUpWindow.setLocation(windowX+8, windowY+5);
        autoSuggestionPopUpWindow.setMinimumSize(new Dimension(textField.getWidth(), 30));
        autoSuggestionPopUpWindow.revalidate();
        autoSuggestionPopUpWindow.repaint();

    }

    public void setDictionary(ArrayList<String> words) {
        dictionary.clear();
        if (words == null) {
            return;//so we can call constructor with null value for dictionary without exception thrown
        }
        for (String word : words) {
            dictionary.add(word);
        }
    }

    public JWindow getAutoSuggestionPopUpWindow() {
        return autoSuggestionPopUpWindow;
    }

    public Window getContainer() {
        return container;
    }

    public JTextField getTextField() {
        return textField;
    }

    public void addToDictionary(String word) {
        dictionary.add(word);
    }

    boolean wordTyped(String typedWord) {

        if (typedWord.isEmpty()) {
            return false;
        }
        //System.out.println("Typed word: " + typedWord);

        boolean suggestionAdded = false;

        for (String word : dictionary) {//get words in the dictionary which we added
            boolean fullymatches = true;
            for (int i = 0; i < typedWord.length(); i++) {//each string in the word
                if (!typedWord.toLowerCase().startsWith(String.valueOf(word.toLowerCase().charAt(i)), i)) {//check for match
                    fullymatches = false;
                    break;
                }
            }
            if (fullymatches) {
                addWordToSuggestions(word);
                suggestionAdded = true;
            }
        }
        return suggestionAdded;
    }
}

@SuppressWarnings("serial")
class SuggestionLabel extends JLabel {

    private boolean focused = false;
    private final JWindow autoSuggestionsPopUpWindow;
    private final JTextField textField;
    private final AutoSuggestor autoSuggestor;
    private Color suggestionsTextColor, suggestionBorderColor;

    public SuggestionLabel(String string, final Color borderColor, Color suggestionsTextColor, AutoSuggestor autoSuggestor) {
        super(string);

        this.suggestionsTextColor = suggestionsTextColor;
        this.autoSuggestor = autoSuggestor;
        this.textField = autoSuggestor.getTextField();
        this.suggestionBorderColor = borderColor;
        this.autoSuggestionsPopUpWindow = autoSuggestor.getAutoSuggestionPopUpWindow();

        initComponent();
    }

    private void initComponent() {
        setFocusable(true);
        setForeground(suggestionsTextColor);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                super.mouseClicked(me);

                replaceWithSuggestedText();

                autoSuggestionsPopUpWindow.setVisible(false);
            }
        });

        getInputMap(JComponent.WHEN_FOCUSED).put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0, true), "Enter released");
        getActionMap().put("Enter released", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                replaceWithSuggestedText();
                autoSuggestionsPopUpWindow.setVisible(false);
            }
        });
    }

    public void setFocused(boolean focused) {
        if (focused) {
            setBorder(new LineBorder(suggestionBorderColor));
        } else {
            setBorder(null);
        }
        repaint();
        this.focused = focused;
    }

    public boolean isFocused() {
        return focused;
    }

    private void replaceWithSuggestedText() {
        String suggestedWord = getText();
        String text = textField.getText();
        String typedWord = autoSuggestor.getCurrentlyTypedWord();
        String t = text.substring(0, text.lastIndexOf(typedWord));
        String tmp = t + text.substring(text.lastIndexOf(typedWord)).replace(typedWord, suggestedWord);
        textField.setText(tmp + " ");
    }
}
