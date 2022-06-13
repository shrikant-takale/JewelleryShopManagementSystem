 import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.border.LineBorder;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;
import net.sf.jasperreports.engine.JasperPrint;

public class Item extends JPanel {
	private JTextField txtSrno;
	private JTextField txtPrice;
	private JTextField txtSearch;
    private JComboBox<String>cmbCategories;
	private JComboBox<Integer>cmbQuantity;
	private JComboBox<Integer>cmbPurity;
	private JComboBox<Integer>cmbGram;
	private JComboBox <String>cmbName;
	Connection con;
	int Srno;
	
	private JTable tblItem;
	private JTextField txtDate1;
	private JTextField txtDate2;
	/**
	 * Create the panel.
	 */
	public Item() {
		setBounds(249, 16, 980, 550);
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setLayout(null);
		panel.setBounds(10, 5, 955, 46);
		add(panel);
		getMySqLConnection();
		JLabel lblItemform = new JLabel("ItemForm");
		lblItemform.setHorizontalAlignment(SwingConstants.CENTER);
		lblItemform.setForeground(new Color(220, 20, 60));
		lblItemform.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblItemform.setBounds(374, 7, 120, 32);
		panel.add(lblItemform);
		
		JPanel panel_Menus = new JPanel();
		panel_Menus.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_Menus.setLayout(null);
		panel_Menus.setForeground(Color.BLACK);
		panel_Menus.setBounds(10, 54, 955, 108);
		add(panel_Menus);
		
		JLabel label_1 = new JLabel("SrNo:-");
		label_1.setHorizontalTextPosition(SwingConstants.CENTER);
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setForeground(new Color(220, 20, 60));
		label_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		label_1.setBounds(19, 9, 55, 20);
		panel_Menus.add(label_1);
		
		JLabel lblItemcategories = new JLabel("Categories:-");
		lblItemcategories.setHorizontalTextPosition(SwingConstants.CENTER);
		lblItemcategories.setHorizontalAlignment(SwingConstants.CENTER);
		lblItemcategories.setForeground(new Color(220, 20, 60));
		lblItemcategories.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblItemcategories.setBounds(234, 11, 105, 20);
		panel_Menus.add(lblItemcategories);
		
		JLabel lblItemname = new JLabel("I-Name:-");
		lblItemname.setHorizontalTextPosition(SwingConstants.CENTER);
		lblItemname.setHorizontalAlignment(SwingConstants.CENTER);
		lblItemname.setForeground(new Color(220, 20, 60));
		lblItemname.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblItemname.setBounds(483, 9, 80, 20);
		panel_Menus.add(lblItemname);
		
		JLabel lblItemprice = new JLabel("Price:-");
		lblItemprice.setHorizontalTextPosition(SwingConstants.CENTER);
		lblItemprice.setHorizontalAlignment(SwingConstants.CENTER);
		lblItemprice.setForeground(new Color(220, 20, 60));
		lblItemprice.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblItemprice.setBounds(492, 43, 71, 20);
		panel_Menus.add(lblItemprice);
		
		txtSrno = new JTextField();
		txtSrno.setHorizontalAlignment(SwingConstants.LEFT);
		txtSrno.setEditable(false);
		txtSrno.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtSrno.setColumns(10);
		txtSrno.setBounds(89, 7, 130, 26);
		panel_Menus.add(txtSrno);
		
		txtPrice = new JTextField();
		txtPrice.setHorizontalAlignment(SwingConstants.LEFT);
		txtPrice.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtPrice.setColumns(10);
		txtPrice.setBounds(562, 40, 122, 26);
		panel_Menus.add(txtPrice);
		
		
		
		
		cmbGram = new JComboBox();
		cmbGram.setModel(new DefaultComboBoxModel(new String[] {"1","2","5", "10", "15", "20", "25", "30", "40", "50","300","500","700"}));
		cmbGram.setSelectedItem(null);
		cmbGram.setBounds(91, 42, 125, 26);
		panel_Menus.add(cmbGram);
		
		cmbPurity = new JComboBox();
		cmbPurity.setModel(new DefaultComboBoxModel(new String[] {"1","2","24", "22"}));
		cmbPurity.setSelectedItem(null);
		cmbPurity.setBounds(348, 41, 129, 26);
		panel_Menus.add(cmbPurity);
		
		JLabel lblPurity = new JLabel("Purity:-");
		lblPurity.setHorizontalTextPosition(SwingConstants.CENTER);
		lblPurity.setHorizontalAlignment(SwingConstants.CENTER);
		lblPurity.setForeground(new Color(220, 20, 60));
		lblPurity.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblPurity.setBounds(241, 42, 69, 20);
		panel_Menus.add(lblPurity);
		
		JLabel lblGram = new JLabel("Gram:-");
		lblGram.setHorizontalTextPosition(SwingConstants.CENTER);
		lblGram.setHorizontalAlignment(SwingConstants.CENTER);
		lblGram.setForeground(new Color(220, 20, 60));
		lblGram.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblGram.setBounds(3, 45, 71, 20);
		panel_Menus.add(lblGram);
		
		JLabel lblQuantity = new JLabel("Quantity:-");
		lblQuantity.setHorizontalTextPosition(SwingConstants.CENTER);
		lblQuantity.setHorizontalAlignment(SwingConstants.CENTER);
		lblQuantity.setForeground(new Color(220, 20, 60));
		lblQuantity.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblQuantity.setBounds(703, 10, 80, 20);
		panel_Menus.add(lblQuantity);
		
		cmbQuantity = new JComboBox();
        cmbQuantity.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "4", "5", "10", "20", "40"}));
		cmbQuantity.setSelectedItem(null);
		cmbQuantity.setBounds(788, 6, 158, 26);
		panel_Menus.add(cmbQuantity);
		
		cmbCategories = new JComboBox();
		cmbCategories.setModel(new DefaultComboBoxModel(new String[] {"Platinum", "Gold", "Silver", "Diamond"}));
		cmbCategories.setSelectedItem(null);
		cmbCategories.setBounds(348, 7, 129, 26);
		panel_Menus.add(cmbCategories);
		
		cmbName = new JComboBox();
		cmbName.setBounds(563, 7, 125, 26);
		cmbName.setModel(new DefaultComboBoxModel(new String[] {"Bengal", "Ring", "EireRing", "Neckless", "Chain"}));
		cmbName.setSelectedItem(null);
		panel_Menus.add(cmbName);
		
		JPanel panel_Date = new JPanel();
		panel_Date.setBounds(689, 38, 260, 67);
		panel_Date.setVisible(false);
		panel_Menus.add(panel_Date);
		panel_Date.setLayout(null);
		
		txtDate1 = new JTextField();
		txtDate1.setHorizontalAlignment(SwingConstants.CENTER);
		txtDate1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtDate1.setColumns(10);
		txtDate1.setBounds(6, 6, 122, 26);
		panel_Date.add(txtDate1);
		
		txtDate2 = new JTextField();
		txtDate2.setHorizontalAlignment(SwingConstants.CENTER);
		txtDate2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtDate2.setColumns(10);
		txtDate2.setBounds(6, 38, 122, 26);
		panel_Date.add(txtDate2);
		
		JButton btnDay = new JButton("Day");
		btnDay.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String Query="SELECT * FROM `items` WHERE Date in ('" +txtDate1.getText()+ "')";
				fetchJobs(Query);
			}
		});
		btnDay.setForeground(new Color(220, 20, 60));
		btnDay.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnDay.setBounds(134, 4, 87, 18);
		panel_Date.add(btnDay);
		
		JButton btnMonth = new JButton("Month");
		btnMonth.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String Query="SELECT * FROM items WHERE YEAR(Date) ='"+txtDate1.getText()+"' AND MONTH(Date) ="+txtDate2.getText();
				fetchJobs(Query);
			}
		});
		btnMonth.setForeground(new Color(220, 20, 60));
		btnMonth.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnMonth.setBounds(134, 24, 87, 18);
		panel_Date.add(btnMonth);
		
		JButton btnYear = new JButton("Year");
		btnYear.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String Query="SELECT * FROM items WHERE YEAR(Date) ='" +txtDate1.getText()+"'";
				fetchJobs(Query);
			}
		});
		btnYear.setForeground(new Color(220, 20, 60));
		btnYear.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnYear.setBounds(134, 44, 87, 18);
		panel_Date.add(btnYear);
		
		JButton btnClear = new JButton(".");
		btnClear.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtDate1.setText("");
				txtDate2.setText("");
			}
		});
		btnClear.setForeground(new Color(220, 20, 60));
		btnClear.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnClear.setBounds(225, 20, 32, 31);
		panel_Date.add(btnClear);
		
		
		JPanel panel_Search = new JPanel();
		panel_Search.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_Search.setLayout(null);
		panel_Search.setBounds(10, 223, 955, 40);
		add(panel_Search);
		
		txtSearch = new JTextField();
		txtSearch.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				String Query="SELECT * FROM ITEMS WHERE Item_Name LIKE '%"+txtSearch.getText()+"%'";
				fetchJobs(Query);
			}
		});
		
		txtSearch.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtSearch.setColumns(10);
		txtSearch.setBounds(142, 7, 800, 26);
		panel_Search.add(txtSearch);
		
		JLabel lblSearchitem = new JLabel("SearchItem:-");
		lblSearchitem.setHorizontalTextPosition(SwingConstants.CENTER);
		lblSearchitem.setHorizontalAlignment(SwingConstants.CENTER);
		lblSearchitem.setForeground(new Color(220, 20, 60));
		lblSearchitem.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblSearchitem.setBounds(29, 10, 113, 20);
		panel_Search.add(lblSearchitem);
		
		JPanel panel_Table = new JPanel();
		panel_Table.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_Table.setLayout(null);
		panel_Table.setBounds(8, 265, 957, 279);
		add(panel_Table);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(15, 14, 930, 250);
		panel_Table.add(scrollPane_1);
		
		tblItem = new JTable();
		scrollPane_1.setViewportView(tblItem);
		
		JPanel panel_Buttons = new JPanel();
		panel_Buttons.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_Buttons.setLayout(null);
		panel_Buttons.setBounds(9, 170, 956, 50);
		add(panel_Buttons);
		
		JButton btnSave = new JButton("Save");
		btnSave.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				// SAVE BUTTON
		        String Name=cmbName.getSelectedItem().toString();
		        int Quantity=Integer.parseInt(cmbQuantity.getSelectedItem().toString());
		        String Categories=cmbCategories.getSelectedItem().toString();
		        int Purity=Integer.parseInt(cmbPurity.getSelectedItem().toString());
		        double Price=Double.parseDouble(txtPrice.getText());
		        int Gram=Integer.parseInt(cmbGram.getSelectedItem().toString());
		        check( Categories,Purity,Quantity,Gram);
		        Price =Double.parseDouble(txtPrice.getText());
		        //int Price1=Price;
		        String Query1="SELECT * FROM ITEMS";
		        
               // Price=(Price1 * Quantity * Gram);
                //txtPrice.setText(String.valueOf(Price));
		        
		        String Query="insert into items(Item_Name,Item_Quantity,Item_Categories,Itrm_Purity,Item_Price,Item_Gram,Date,Time) values (?,?,?,?,?,?,?,?)";				
		PreparedStatement ps=null;
		if(Name.length()!=0 ) {
		//Obtaining current date
		Calendar calendar=Calendar.getInstance();
		SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd");
		String date=formatter.format(calendar.getTime());
		//Obtaining Current Time
		formatter=new SimpleDateFormat("HH:mm:ss");
		String time=formatter.format(calendar.getTime());
		try{            ps=con.prepareStatement(Query);
		                ps.setString(1, Name);
		                ps.setInt(2, Quantity);
		                ps.setString(3, Categories);
		                ps.setInt(4, Purity);
		                ps.setDouble(5, Price);
		                ps.setInt(6, Gram);
		                ps.setString(7, date);
		                ps.setString(8, time);
		                ps.execute();
		                fetchJobs(Query1);
		                JOptionPane.showMessageDialog(null, "Insertion Successfully.....");
		                
		            }catch(SQLException e){
		                System.out.println(e.getMessage());
		            }
				}
			}
		});
		btnSave.setForeground(new Color(220, 20, 60));
		btnSave.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnSave.setBounds(240, 4, 115, 40);
		panel_Buttons.add(btnSave);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				//txtSrno.setText(rs.getString("SrNo"));
				 try{
				String Name=cmbName.getSelectedItem().toString();
				String Categories=cmbCategories.getSelectedItem().toString();
			     int Quantity=Integer.parseInt(cmbQuantity.getSelectedItem().toString());
			     int Purity=Integer.parseInt(cmbPurity.getSelectedItem().toString());
			     int Gram=Integer.parseInt(cmbGram.getSelectedItem().toString());
			     double Price=Double.parseDouble(txtPrice.getText());
			    // int Price1=Price;
			     //Price=(Price1 * Quantity * Gram);
			     //txtPrice.setText(String.valueOf(Price));
			     check( Categories,Purity,Quantity,Gram);
			     Price =Double.parseDouble(txtPrice.getText());
			     String Query="SELECT * FROM ITEMS";
		         PreparedStatement ps=con.prepareStatement("update Items set Item_Name=?,Item_Quantity=?,Item_Categories=?,Itrm_Purity=?,Item_Price=?,Item_Gram=? where SrNo=?");
		         ps.setString(1, Name);
		         ps.setInt(2, Quantity);
		         ps.setString(3, Categories);
		         ps.setInt(4, Purity);
		         ps.setDouble(5, Price);
		         ps.setInt(6, Gram);
		         ps.setInt(7, Srno);
		         ps.execute();
		         fetchJobs(Query);
		         JOptionPane.showMessageDialog(null, "Update Successfully.....");
		         Reset();
				 }
			        catch(SQLException ex){
			        }
			}
		});
		btnUpdate.setForeground(new Color(220, 20, 60));
		btnUpdate.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnUpdate.setBounds(358, 5, 115, 40);
		panel_Buttons.add(btnUpdate);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try{
					
					String Query="Select * From Items";
			        PreparedStatement ps=con.prepareStatement("delete from Items where SrNo=?");
			         ps.setInt(1,Srno);
			         ps.execute();
			        fetchJobs(Query);
			        JOptionPane.showMessageDialog(null, "Delete Successfully.....");
			        Reset();
			        }
			        catch(SQLException e){}
			}
		});
		btnDelete.setForeground(new Color(220, 20, 60));
		btnDelete.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnDelete.setBounds(475, 5, 115, 40);
		panel_Buttons.add(btnDelete);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				//String Query="Select * From Items";
				String Query="SELECT * FROM ITEMS";								
				Reset();
	            fetchJobs(Query);
			}
		});
		btnReset.setForeground(new Color(220, 20, 60));
		btnReset.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnReset.setBounds(591, 5, 115, 40);
		panel_Buttons.add(btnReset);
		
		JButton btnDate_Report = new JButton("DateReport");
		btnDate_Report.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				panel_Date.setVisible(true);
				if(arg0.getClickCount()==2){
					panel_Date.setVisible(false); 
			       }
			}
		});
		btnDate_Report.setForeground(new Color(220, 20, 60));
		btnDate_Report.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnDate_Report.setBounds(819, 4, 125, 40);
		panel_Buttons.add(btnDate_Report);
		
		JButton btnYear_1 = new JButton("year");
		btnYear_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(arg0.getSource()==btnYear_1)
		    	{
		    		try
		    		{
		    			Statement  st=con.createStatement();
						ResultSet rs=st.executeQuery("SELECT * FROM items WHERE YEAR(Date) ='" +txtDate1.getText()+ "'");
						
						tblItem.setAutoResizeMode(tblItem.AUTO_RESIZE_ALL_COLUMNS);
						tblItem.setModel(DbUtils.resultSetToTableModel(rs));
						tblItem.print(JTable.PrintMode.NORMAL);	
		    		}catch(Exception e1)
		    		{
		    			JOptionPane.showMessageDialog(null,e1);
		    		}
		    	}
				
				
				
				
				/*try{
				 	con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jewelleryshopmanagement","root","shrikant@123");
			    	String sql1="SELECT * FROM items WHERE YEAR(Date) =" +txtDate1.getText();
			    	JasperDesign jdesigner=JRXmlLoader.load("C:\\Users\\Shrikant\\Desktop\\JewelleryShopManagement1\\AnnualReportsItems.jrxml");
			 		JRDesignQuery updateQuery=new JRDesignQuery();
			 		updateQuery.setText(sql1);
			 		jdesigner.setQuery(updateQuery);
			 		JasperReport jReport=JasperCompileManager.compileReport(jdesigner);
			 		JasperPrint jasperPrint=JasperFillManager.fillReport(jReport,null,con);
			 		JasperViewer.viewReport(jasperPrint,false);
			 		}catch(JRException e){
			    		System.out.println("SQL Exception:"+e.getMessage());
			    		JOptionPane.showMessageDialog(null,e);
			 		}
			 		catch(SQLException e1){
		    		System.out.println("SQL Exception:"+e1.getMessage());
		    		JOptionPane.showMessageDialog(null,e1);
		 		}*/
			}
		});
		btnYear_1.setForeground(new Color(220, 20, 60));
		btnYear_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnYear_1.setBounds(6, 4, 71, 40);
		panel_Buttons.add(btnYear_1);
		
		JButton btnMonth_1 = new JButton("Month");
		btnMonth_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(arg0.getSource()==btnMonth_1)
		    	{
		    		try
		    		{
		    			Statement  st=con.createStatement();
						ResultSet rs=st.executeQuery("SELECT * FROM items WHERE YEAR(Date) ='"+txtDate1.getText()+"' AND MONTH(Date) ="+txtDate2.getText());
						tblItem.setAutoResizeMode(tblItem.AUTO_RESIZE_ALL_COLUMNS);
						tblItem.setModel(DbUtils.resultSetToTableModel(rs));
						tblItem.print(JTable.PrintMode.NORMAL);	
		    		}catch(Exception e1)
		    		{
		    			JOptionPane.showMessageDialog(null,e1);
		    		}
		    	}
				
				/*
				try{
				 	con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jewelleryshopmanagement","root","shrikant@123");
			    	String sql1="SELECT * FROM items WHERE YEAR(Date) = "+txtDate1.getText()+" AND MONTH(Date) ="+txtDate2.getText();
			    	JasperDesign jdesigner=JRXmlLoader.load("C:\\Users\\Shrikant\\Desktop\\JewelleryShopManagement1\\ItemsReportMonthly.jrxml");
			 		JRDesignQuery updateQuery=new JRDesignQuery();
			 		updateQuery.setText(sql1);
			 		jdesigner.setQuery(updateQuery);
			 		JasperReport jReport=JasperCompileManager.compileReport(jdesigner);
			 		JasperPrint jasperPrint=JasperFillManager.fillReport(jReport,null,con);
			 		JasperViewer.viewReport(jasperPrint,false);
			 		}catch(JRException e){
			    		System.out.println("SQL Exception:"+e.getMessage());
			    		JOptionPane.showMessageDialog(null,e);
			 		}
			 		catch(SQLException e1){
		    		System.out.println("SQL Exception:"+e1.getMessage());
		    		JOptionPane.showMessageDialog(null,e1);
		 		}*/
			}
		});
		btnMonth_1.setForeground(new Color(220, 20, 60));
		btnMonth_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnMonth_1.setBounds(80, 4, 83, 40);
		panel_Buttons.add(btnMonth_1);
		
		JButton btnDay_1 = new JButton("Day");
		btnDay_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(arg0.getSource()== btnDay_1)
		    	{
		    		try
		    		{
		    			Statement  st=con.createStatement();
						ResultSet rs=st.executeQuery("SELECT * FROM `items` WHERE Date in ('" +txtDate1.getText()+ "')");
						
						tblItem.setAutoResizeMode(tblItem.AUTO_RESIZE_ALL_COLUMNS);
						tblItem.setModel(DbUtils.resultSetToTableModel(rs));
						tblItem.print(JTable.PrintMode.NORMAL);	
		    		}catch(Exception e1)
		    		{
		    			JOptionPane.showMessageDialog(null,e1);
		    		}
		    	}
				/*
				try{
				 	con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jewelleryshopmanagement","root","shrikant@123");
			    	String sql1="SELECT * FROM items WHERE Date IN ("+txtDate1.getText()+")";
			    	JasperDesign jdesigner=JRXmlLoader.load("C:\\Users\\Shrikant\\Desktop\\JewelleryShopManagement1\\ Reports\\ItemsByDay.jrxml");
			 		JRDesignQuery updateQuery=new JRDesignQuery();
			 		updateQuery.setText(sql1);
			 		jdesigner.setQuery(updateQuery);
			 		JasperReport jReport=JasperCompileManager.compileReport(jdesigner);
			 		JasperPrint jasperPrint=JasperFillManager.fillReport(jReport,null,con);
			 		JasperViewer.viewReport(jasperPrint,false);
			 		}catch(JRException e){
			    		System.out.println("SQL Exception:"+e.getMessage());
			    		JOptionPane.showMessageDialog(null,e);
			 		}
			 		catch(SQLException e1){
		    		System.out.println("SQL Exception:"+e1.getMessage());
		    		JOptionPane.showMessageDialog(null,e1);
		 		}*/
			}
		});
		btnDay_1.setForeground(new Color(220, 20, 60));
		btnDay_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnDay_1.setBounds(166, 4, 71, 40);
		panel_Buttons.add(btnDay_1);
		
		JButton btnShow = new JButton("Show");
		btnShow.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String Query="SELECT * FROM ITEMS";								
				//Reset();
	            fetchJobs(Query);
			}
		});
		btnShow.setForeground(new Color(220, 20, 60));
		btnShow.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnShow.setBounds(709, 4, 107, 40);
		panel_Buttons.add(btnShow);
		setVisible(true);
		
		tblItem = new JTable();
		scrollPane_1.setViewportView(tblItem);
		tblItem.addMouseListener(new MouseAdapter(){
		       @Override
		       public void mouseClicked(MouseEvent e){
		       if(e.getClickCount()==2){
		           JTable target=(JTable)e.getSource();
		           int row=target.getSelectedRow();
		           Srno=Integer.parseInt(tblItem.getValueAt(row,0).toString());
		           loadData();  
		       }
		       }
		   });

	}
			public void getMySqLConnection(){
		    try{
		        con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jewelleryshopmanagement","root","shrikant@123");
			    }catch(SQLException e){
			    System.out.println("SQL Exception:"+e.getMessage());
			    }
		    }
			public void fetchJobs(String Query){
				 //This funcion runs when tab view jobs selected or refresh button clicked
				 //Fetch jos on Jtable
				   String Query1=Query;
				 Object [][]data=null;
				 try{
				 PreparedStatement ps=con.prepareStatement(Query1);
				 int rowCount=0;
				 ResultSet rs=ps.executeQuery();
				 while(rs.next()){
				 rowCount ++;
				 }
				 data=new Object[rowCount][9];
				 rs=ps.executeQuery();
				 rowCount=0;
				
				 while(rs.next()){
				 data[rowCount][0]=rs.getInt("SrNo");
				 data[rowCount][1]=rs.getString("Item_Name");
				 data[rowCount][2]=rs.getInt("Item_Quantity");
				 data[rowCount][3]=rs.getString("Item_Categories");
				 data[rowCount][4]=rs.getInt("Itrm_Purity");
				 data[rowCount][5]=rs.getDouble("Item_Price");
				 data[rowCount][6]=rs.getInt("Item_Gram");
				 data[rowCount][7]=rs.getDate("Date");
				 data[rowCount][8]=rs.getTime("Time");
				 rowCount ++;
				 
				 }
				
				 
				 }catch(Exception e){
				 e.printStackTrace();
				 }
				 String [] colNames ={"SrNo","Item_Name","Item_Quantity","Item_Categories","Itrm_Purity","Item_Price","Item_Gram","Date","Time"};
				 setTableData(data,colNames);
				 } 
			//Method setTableData
			   public void setTableData(Object[][] data,String[] colNames){
			   DefaultTableModel dtm=new DefaultTableModel(data,colNames){
			   @Override 
			   public boolean isCellEditable(int row,int column)//this makes all columns non-editable
			   {
			   return false;
			   }
			   }; 
			   tblItem.setModel(dtm);
			   }
			   public void loadData(){
			    	 try{
			    		 String Query="select * from items where SrNo=?";
			    	     PreparedStatement ps=con.prepareStatement(Query);
			    	     ps.setInt(1,Srno);
			    	     ResultSet rs=ps.executeQuery();
			    	     if (rs.next()){
			    	     txtSrno.setText(rs.getString("SrNo"));
			    	     cmbName.setSelectedItem((rs.getString("Item_Name")));
			    	     cmbQuantity.setSelectedItem((rs.getString("Item_Quantity")));
			    	     cmbCategories.setSelectedItem((rs.getString("Item_Categories")));
			    	     cmbPurity.setSelectedItem((rs.getString("Itrm_Purity")));
			    	     txtPrice.setText(rs.getString("Item_Price"));
			    	     cmbGram.setSelectedItem((rs.getString("Item_Gram")));
			    	     //jLabel5.setText("  Date: "+rs.getDate("date"));
			    	     //jLabel6.setText("  Time: "+rs.getTime("time"));
			    	     /* int itemIndex=0;
			    	     String status=rs.getString("status");
			    	     if(status.equals("Pending"))
			    	     itemIndex=0;
			    	      else if(status.equals("Done"))
			    	      itemIndex=1;
			    	     else 
			    	      itemIndex=2;
			    	      //jComboBox1.setSelectedIndex(itemIndex); 
			    	     */
			    	     }
			    	 }
			    	 catch (SQLException e){
			    	 System.out.println("Sql Exception in SELECT");
			    	 }
			    	 }
				 public void Reset() {
						//txtSrno.setText("");
					 cmbName.setSelectedItem(null);
					 cmbCategories.setSelectedItem(null);
					 cmbQuantity.setSelectedItem(null);
					 cmbPurity.setSelectedItem(null);
					 cmbGram.setSelectedItem(null);
					 txtPrice.setText("");
				 }  
				 public void check(String Categories,int Purity,int Quantity,int Gram) {
					 String Categories1=Categories;
					 int Purity1=Purity;
					 int Quantity1=Quantity; 
					 double Price;
					 int Gram1= Gram;
						 if(Categories1=="Gold" && Purity1==24){
							 // int Price1=Price;
							 double g1=4804.00;
						     Price=( Quantity1 * Gram1 * g1);
						     txtPrice.setText(String.valueOf(Price));
							 //txtPrice.setText(String.valueOf("4804.00")); 
						 }
						 else if(Categories1=="Gold" && Purity1==22) {
							 // int Price1=Price;
							 double g2=4730.00;
						     Price=(Quantity1 * Gram1 * g2);
						     txtPrice.setText(String.valueOf(Price));
							 //txtPrice.setText(String.valueOf("4730.00")); 
						 }
						 else if(Categories1=="Silver" && Purity1==24) {
							// int Price1=Price;
							 double g3=70.00;
						     Price=( Quantity1 * Gram1 * g3);
						     txtPrice.setText(String.valueOf(Price));
							 //txtPrice.setText(String.valueOf("70.00")); 
						 }
						 else if(Categories1=="Silver" && Purity1==22) {
							// int Price1=Price;
							 double g4=67.50;
						     Price=(Quantity1 * Gram1 * g4);
						     //txtPrice.setText(String.valueOf(Price));
							 txtPrice.setText(String.valueOf("67.50")); 
						 }
						 else if(Categories1=="Platinum" && Purity1==24) {
							// int Price1=Price;
							 double g5=2583.00;
						     Price=(Quantity1 * Gram1 * g5);
						     txtPrice.setText(String.valueOf(Price));
							 //txtPrice.setText(String.valueOf("2583.00")); 
						 }
						 else if(Categories1=="Platinum" && Purity1==22) {
							// int Price1=Price;
							 double g6=1583.00;
						     Price=(Quantity1 * Gram1 * g6);
						     txtPrice.setText(String.valueOf(Price));
							 //txtPrice.setText(String.valueOf("1583.00")); 
						 }
						 else if(Categories1=="Diamond" && Purity1==1) {
							// int Price1=Price;
							 double g7=50000.00;
						     Price=(Quantity1 * Gram1 * g7);
						     txtPrice.setText(String.valueOf(Price));
							// txtPrice.setText(String.valueOf("50000.00")); 
						 }
						 else if(Categories1=="Diamond" && Purity1==2) {
							// int Price1=Price;
							 double g8=5000.00;
						     Price=( Quantity1 * Gram1 * g8);
						     txtPrice.setText(String.valueOf(Price));
							 //txtPrice.setText(String.valueOf("5000.00")); 
						 }
						 else {
							System.out.println("not allowed");
						 }
				 }
}			
