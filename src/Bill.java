import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;
import net.sf.jasperreports.engine.JasperPrint;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Bill extends JPanel {
	private JTextField txtSrno;
	private JTextField txtCId;
	private JTextField txtSearch;
	private JTextField txtEId;
	private JTextField txtSId;
	private JTextField txtQuantity;
	private JTextField txtPrice;
	private JComboBox<Integer>cmbPurity;
	private JComboBox<Integer>cmbGram;
	private JComboBox <String>cmbName;
	private JComboBox<String>cmbCategories;
	int Srno;
	int Eid;
	int Sid;
	int Cid;
	
	Connection con;
	private JTable tblBill;
	private JTextField txtCid1;

	/**
	 * Create the panel.
	 */
	public Bill() {
		setBounds(249, 16, 980, 550);
		setLayout(null);
		getMySqLConnection();
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setLayout(null);
		panel.setBounds(15, 4, 950, 35);
		add(panel);
		
		JLabel lblBillForm = new JLabel("Bill Form");
		lblBillForm.setHorizontalAlignment(SwingConstants.CENTER);
		lblBillForm.setForeground(new Color(220, 20, 60));
		lblBillForm.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblBillForm.setBounds(403, 5, 120, 25);
		panel.add(lblBillForm);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setLayout(null);
		panel_1.setForeground(Color.BLACK);
		panel_1.setBounds(15, 41, 950, 174);
		add(panel_1);
		
		JLabel label_1 = new JLabel("SrNo:-");
		label_1.setHorizontalTextPosition(SwingConstants.CENTER);
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setForeground(new Color(220, 20, 60));
		label_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		label_1.setBounds(13, 9, 55, 20);
		panel_1.add(label_1);
		
		JLabel lblPquantity = new JLabel("CID:-");
		lblPquantity.setHorizontalTextPosition(SwingConstants.CENTER);
		lblPquantity.setHorizontalAlignment(SwingConstants.CENTER);
		lblPquantity.setForeground(new Color(220, 20, 60));
		lblPquantity.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblPquantity.setBounds(15, 45, 46, 20);
		panel_1.add(lblPquantity);
		
		JLabel lblPprice = new JLabel("Gram:-");
		lblPprice.setHorizontalTextPosition(SwingConstants.CENTER);
		lblPprice.setHorizontalAlignment(SwingConstants.CENTER);
		lblPprice.setForeground(new Color(220, 20, 60));
		lblPprice.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblPprice.setBounds(607, 12, 67, 20);
		panel_1.add(lblPprice);
		
		JLabel lblPname = new JLabel("P-Name:-");
		lblPname.setHorizontalTextPosition(SwingConstants.CENTER);
		lblPname.setHorizontalAlignment(SwingConstants.CENTER);
		lblPname.setForeground(new Color(220, 20, 60));
		lblPname.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblPname.setBounds(285, 9, 84, 20);
		panel_1.add(lblPname);
		
		JLabel lblCname = new JLabel("EID-");
		lblCname.setHorizontalTextPosition(SwingConstants.CENTER);
		lblCname.setHorizontalAlignment(SwingConstants.CENTER);
		lblCname.setForeground(new Color(220, 20, 60));
		lblCname.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblCname.setBounds(14, 80, 46, 20);
		panel_1.add(lblCname);
		
		txtSrno = new JTextField();
		txtSrno.setEditable(false);
		txtSrno.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtSrno.setColumns(10);
		txtSrno.setBounds(73, 7, 204, 26);
		panel_1.add(txtSrno);
		
		txtCId = new JTextField();
		txtCId.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtCId.setColumns(10);
		txtCId.setBounds(73, 43, 204, 26);
		panel_1.add(txtCId);
		
		JLabel lblCategories = new JLabel("Categories:-");
		lblCategories.setHorizontalTextPosition(SwingConstants.CENTER);
		lblCategories.setHorizontalAlignment(SwingConstants.CENTER);
		lblCategories.setForeground(new Color(220, 20, 60));
		lblCategories.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblCategories.setBounds(290, 42, 99, 20);
		panel_1.add(lblCategories);
		
		txtEId = new JTextField();
		txtEId.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtEId.setColumns(10);
		txtEId.setBounds(76, 77, 204, 26);
		panel_1.add(txtEId);
		
		JLabel lblPurity = new JLabel("Purity-");
		lblPurity.setHorizontalTextPosition(SwingConstants.CENTER);
		lblPurity.setHorizontalAlignment(SwingConstants.CENTER);
		lblPurity.setForeground(new Color(220, 20, 60));
		lblPurity.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblPurity.setBounds(291, 76, 67, 20);
		panel_1.add(lblPurity);
		
		JLabel label = new JLabel("SID:-");
		label.setHorizontalTextPosition(SwingConstants.CENTER);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(new Color(220, 20, 60));
		label.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		label.setBounds(614, 78, 55, 20);
		panel_1.add(label);
		
		txtSId = new JTextField();
		txtSId.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtSId.setColumns(10);
		txtSId.setBounds(700, 77, 204, 26);
		panel_1.add(txtSId);
		
		JLabel lblQuantity = new JLabel("Quantity:-");
		lblQuantity.setHorizontalTextPosition(SwingConstants.CENTER);
		lblQuantity.setHorizontalAlignment(SwingConstants.CENTER);
		lblQuantity.setForeground(new Color(220, 20, 60));
		lblQuantity.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblQuantity.setBounds(613, 47, 79, 20);
		panel_1.add(lblQuantity);
		
		txtQuantity = new JTextField();
		txtQuantity.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtQuantity.setColumns(10);
		txtQuantity.setBounds(699, 43, 204, 26);
		panel_1.add(txtQuantity);
		
		txtPrice = new JTextField();
		txtPrice.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtPrice.setColumns(10);
		txtPrice.setBounds(699, 114, 204, 26);
		panel_1.add(txtPrice);
		
		JLabel lblPrice = new JLabel("Price-");
		lblPrice.setHorizontalTextPosition(SwingConstants.CENTER);
		lblPrice.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrice.setForeground(new Color(220, 20, 60));
		lblPrice.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblPrice.setBounds(620, 117, 54, 20);
		panel_1.add(lblPrice);
		
		cmbCategories = new JComboBox();
		cmbCategories.setModel(new DefaultComboBoxModel(new String[] {"Platinum", "Gold", "Silver", "Diamond"}));
		cmbCategories.setSelectedItem(null);
		cmbCategories.setBounds(397, 43, 204, 26);
		panel_1.add(cmbCategories);
		
		cmbName = new JComboBox();
		cmbName.setModel(new DefaultComboBoxModel(new String[] {"Bengal", "Ring", "EireRing", "Neckless", "Chain"}));
		cmbName.setSelectedItem(null);
		cmbName.setBounds(397, 7, 204, 26);
		panel_1.add(cmbName);
		
		cmbGram = new JComboBox();
		cmbGram.setModel(new DefaultComboBoxModel(new String[] {"1","2","5", "10", "15", "20", "25", "30", "40", "50","300","500","700"}));
		cmbGram.setSelectedItem(null);
		cmbGram.setBounds(698, 7, 204, 26);
		panel_1.add(cmbGram);
		
		cmbPurity = new JComboBox();
		cmbPurity.setModel(new DefaultComboBoxModel(new String[] {"1","2","24", "22"}));
		cmbPurity.setBounds(396, 78, 204, 26);
		cmbPurity.setSelectedItem(null);
		panel_1.add(cmbPurity);
		
		txtCid1 = new JTextField();
		txtCid1.setHorizontalAlignment(SwingConstants.CENTER);
		txtCid1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				String Query="SELECT DISTINCT b.SrNo,"
						+"c.SrNo CID," 
						+"c.CustomerName," 
						+"IC.Item_Categories,"
						+"ITN.Item_Name,"
						+"IC.Itrm_Purity," 
						+"SUM( b.Item_Price) Item_Price," 
						+"SUM(ITN.Item_Gram) Item_Gram,"
						+"SUM(b.Item_Quantity) Item_Quantity,"
						+"s.ShopName,"
						+"s.ShopAddress,"
						+"b.EID,"
						+"e.EmployeeName,"
						+"b.Date,"
						+"b.Time FROM item_names ITN "
						+"INNER JOIN bill b ON (ITN.Item_Name = b.Item_Name AND ITN.Item_Gram= b.Item_Gram)"
						+"INNER JOIN catagories IC on (IC.Item_Categories = b.Item_Categories AND IC.Itrm_Purity= b.Itrm_Purity)"
						+"INNER JOIN shop s ON (s.SrNo=b.SID)"
						+"INNER JOIN employee e ON (e.SrNo = b.EID)"
						+"INNER JOIN customer c ON (c.SrNo=b.CID)"
						+"WHERE b.CID like '%"
						+txtCid1.getText()
						+"' GROUP BY c.CustomerName,"
						+"IC.Item_Categories,"
						+"IC.Itrm_Purity,"
						+"ITN.Item_Name,"
						+"ITN.Item_Gram,"
						+"b.Item_Price";
					table(Query);
			}
		});
		
		txtCid1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtCid1.setColumns(10);
		txtCid1.setBounds(332, 142, 204, 26);
		panel_1.add(txtCid1);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_3.setLayout(null);
		panel_3.setBounds(15, 266, 950, 35);
		add(panel_3);
		
		txtSearch = new JTextField();
		txtSearch.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtSearch.setColumns(10);
		txtSearch.setBounds(228, 5, 707, 26);
		panel_3.add(txtSearch);
		
		JLabel label_6 = new JLabel("SearchShopName:-");
		label_6.setHorizontalTextPosition(SwingConstants.CENTER);
		label_6.setHorizontalAlignment(SwingConstants.CENTER);
		label_6.setForeground(new Color(220, 20, 60));
		label_6.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		label_6.setBounds(69, 8, 153, 20);
		panel_3.add(label_6);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_4.setLayout(null);
		panel_4.setBounds(15, 303, 950, 241);
		add(panel_4);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(15, 16, 920, 209);
		panel_4.add(scrollPane);
		
		tblBill = new JTable();
		scrollPane.setViewportView(tblBill);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_2.setBounds(15, 218, 952, 45);
		add(panel_2);
		
		JButton btnSave = new JButton("Save");
		btnSave.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String Name=cmbName.getSelectedItem().toString();
			        int Quantity=Integer.parseInt(txtQuantity.getText());
			        int CID=Integer.parseInt(txtCId.getText());
			        int EID=Integer.parseInt(txtEId.getText());
			        int SID=Integer.parseInt(txtSId.getText());
			        String Categories=cmbCategories.getSelectedItem().toString();
			        int Purity=Integer.parseInt(cmbPurity.getSelectedItem().toString());
			        double Price=Double.parseDouble(txtPrice.getText());
			        int Gram=Integer.parseInt(cmbGram.getSelectedItem().toString());
			        check(Categories,Purity,Quantity,Gram);
			        Price=Double.parseDouble(txtPrice.getText());
			   
			        String Query1="SELECT * FROM Bill";
			        String Query="insert into Bill(CID,EID,SID,Item_Name,Item_Quantity,Item_Categories,Itrm_Purity,Item_Price,Item_Gram,Date,Time) values (?,?,?,?,?,?,?,?,?,?,?)";
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
					                ps.setInt(1, CID);
					                ps.setInt(2, EID);
					                ps.setInt(3, SID);
					                ps.setString(4, Name);
					                ps.setInt(5, Quantity);
					                ps.setString(6, Categories);
					                ps.setInt(7, Purity);
					                ps.setDouble(8, Price);
					                ps.setInt(9, Gram);
					                ps.setString(10, date);
					                ps.setString(11, time);
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
		btnSave.setBounds(296, 4, 115, 35);
		panel_2.add(btnSave);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				//txtSrno.setText(rs.getString("SrNo"));
				 try{
					 String Name=cmbName.getSelectedItem().toString();
				        int Quantity=Integer.parseInt(txtQuantity.getText());
				        int CID=Integer.parseInt(txtCId.getText());
				        int EID=Integer.parseInt(txtEId.getText());
				        int SID=Integer.parseInt(txtSId.getText());
				        String Categories=cmbCategories.getSelectedItem().toString();
				        int Purity=Integer.parseInt(cmbPurity.getSelectedItem().toString());
				        double Price=Double.parseDouble(txtPrice.getText());
				        int Gram=Integer.parseInt(cmbGram.getSelectedItem().toString());

			    // int Price1=Price;
			     //Price=(Price1 * Quantity * Gram);
			     //txtPrice.setText(String.valueOf(Price));
			     check( Categories,Purity,Quantity,Gram);
			     Price =Double.parseDouble(txtPrice.getText());
			     String Query="SELECT * FROM Bill";
		         PreparedStatement ps=con.prepareStatement("update Bill set Item_Name=?,Item_Quantity=?,Item_Categories=?,Itrm_Purity=?,Item_Price=?,CID=?,EID=?,SID=?,Item_Gram=? where SrNo=?");
		         ps.setString(1, Name);
		         ps.setInt(2, Quantity);
		         ps.setString(3, Categories);
		         ps.setInt(4, Purity);
		         ps.setDouble(5, Price);
		         ps.setInt(6, CID);
		         ps.setInt(7, EID);
		         ps.setInt(8, SID);
		         ps.setInt(9, Gram);
		         ps.setInt(10, Srno);
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
		btnUpdate.setBounds(424, 5, 115, 35);
		panel_2.add(btnUpdate);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
                try{
					
					String Query="Select * From bill";
			        PreparedStatement ps=con.prepareStatement("delete from bill where SrNo=?");
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
		btnDelete.setBounds(550, 5, 115, 35);
		panel_2.add(btnDelete);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0){
				String Query="SELECT * FROM bill ";								
				
				Reset();
	            fetchJobs(Query);
				}
		});
		btnReset.setForeground(new Color(220, 20, 60));
		btnReset.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnReset.setBounds(680, 5, 115, 35);
		panel_2.add(btnReset);
		
		JButton btntable = new JButton("Show");
		btntable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				       String Query="SELECT DISTINCT b.SrNo,"
								+"c.SrNo CID," 
								+"c.CustomerName," 
								+"IC.Item_Categories,"
								+"ITN.Item_Name,"
								+"IC.Itrm_Purity," 
								+"SUM( b.Item_Price) Item_Price," 
								+"SUM(ITN.Item_Gram) Item_Gram,"
								+"SUM(b.Item_Quantity) Item_Quantity,"
								+"s.ShopName,"
								+"s.ShopAddress,"
								+"b.EID,"
								+"e.EmployeeName,"
								+"b.Date,"
								+"b.Time FROM item_names ITN "
								+"INNER JOIN bill b ON (ITN.Item_Name = b.Item_Name AND ITN.Item_Gram= b.Item_Gram)"
								+"INNER JOIN catagories IC on (IC.Item_Categories = b.Item_Categories AND IC.Itrm_Purity= b.Itrm_Purity)"
								+"INNER JOIN shop s ON (s.SrNo=b.SID)"
								+"INNER JOIN employee e ON (e.SrNo = b.EID)"
								+"INNER JOIN customer c ON (c.SrNo=b.CID)"
								+"WHERE b.CID like '%"
								+txtCid1.getText()
								+"' GROUP BY c.CustomerName,"
								+"IC.Item_Categories,"
								+"IC.Itrm_Purity,"
								+"ITN.Item_Name,"
								+"ITN.Item_Gram,"
								+"b.Item_Price";
				       table(Query);
				      
	
			}
		});
		btntable.setForeground(new Color(220, 20, 60));
		btntable.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btntable.setBounds(810, 5, 115, 35);
		panel_2.add(btntable);
		
		JButton btnReport = new JButton("Report");
		btnReport.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				try{
				 	con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jewelleryshopmanagement","root","shrikant@123");
				 	//String sql1="select * from customer";
				 	String s="Select * From Bill";
				 	String sql="SELECT DISTINCT"
				 			
							+"c.CustomerName," 
							+"IC.Item_Categories,"
							+"ITN.Item_Name,"
							+"IC.Itrm_Purity," 
							+"SUM( b.Item_Price) Item_Price," 
							+"SUM(ITN.Item_Gram) Item_Gram,"
							+"SUM(b.Item_Quantity) Item_Quantity,"
							+"s.ShopName,"
							+"s.ShopAddress,"
							+"b.Date,"
							+"b.Time FROM item_names ITN "
							+"INNER JOIN bill b ON (ITN.Item_Name = b.Item_Name AND ITN.Item_Gram= b.Item_Gram)"
							+"INNER JOIN catagories IC on (IC.Item_Categories = b.Item_Categories AND IC.Itrm_Purity= b.Itrm_Purity)"
							+"INNER JOIN shop s ON (s.SrNo=b.SID)"
							+"INNER JOIN employee e ON (e.SrNo = b.EID)"
							+"INNER JOIN customer c ON (c.SrNo=b.CID)"
							+"WHERE b.CID="
							+txtCid1.getText()
							+" GROUP BY c.CustomerName";
							

			    	JasperDesign jdesigner=JRXmlLoader.load("C:\\Users\\Shrikant\\Desktop\\java xyz\\JewelleryShopManagement1\\Reports\\Bill.jrxml");
			 		JRDesignQuery updateQuery=new JRDesignQuery();
			 		updateQuery.setText(sql);
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
		 		}
				
			}
		});
		btnReport.setForeground(new Color(220, 20, 60));
		btnReport.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnReport.setBounds(8, 4, 115, 35);
		panel_2.add(btnReport);
			
		tblBill = new JTable();
		scrollPane.setViewportView(tblBill);
		tblBill.addMouseListener(new MouseAdapter(){
		       @Override
		       public void mouseClicked(MouseEvent e){
		       if(e.getClickCount()==2){
		           JTable target=(JTable)e.getSource();
		           int row=target.getSelectedRow();
		           Srno=Integer.parseInt(tblBill.getValueAt(row,0).toString());
		           loadData();  
		       }
		       }
		   });
		
		
		JButton btnReport_2 = new JButton("Report2");
		btnReport_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getSource()==btnReport_2)
		    	{
		    		try
		    		{
		    			Statement  st=con.createStatement();
						ResultSet rs=st.executeQuery("SELECT DISTINCT c.SrNo CID, c.CustomerName, IC.Item_Categories, ITN.Item_Name, IC.Itrm_Purity, SUM(b.Item_Price) Item_Price, SUM(ITN.Item_Gram) Item_Gram, SUM(b.Item_Quantity) Item_Quantity, s.ShopName, s.ShopAddress, b.EID, e.EmployeeName, b.Date, b.Time FROM item_names ITN INNER JOIN bill b ON (ITN.Item_Name = b.Item_Name AND ITN.Item_Gram= b.Item_Gram) INNER JOIN catagories IC on (IC.Item_Categories = b.Item_Categories AND IC.Itrm_Purity= b.Itrm_Purity) INNER JOIN shop s ON (s.SrNo=b.SID) INNER JOIN employee e ON (e.SrNo = b.EID) INNER JOIN customer c ON (c.SrNo=b.CID) WHERE b.CID="+txtCid1.getText());
						
						tblBill.setAutoResizeMode(tblBill.AUTO_RESIZE_ALL_COLUMNS);
						tblBill.setModel(DbUtils.resultSetToTableModel(rs));
						tblBill.print(JTable.PrintMode.NORMAL);	
		    		}catch(Exception e1)
		    		{
		    			JOptionPane.showMessageDialog(null,e1);
		    		}
		    	}
			}
		});
		btnReport_2.setForeground(new Color(220, 20, 60));
		btnReport_2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnReport_2.setBounds(147, 4, 126, 35);
		panel_2.add(btnReport_2);
		setVisible(true);

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
			 data=new Object[rowCount][12];
			 rs=ps.executeQuery();
			 rowCount=0;
			
			 while(rs.next()){
			 data[rowCount][0]=rs.getInt("SrNo");
			 data[rowCount][1]=rs.getInt("CID");
			 data[rowCount][2]=rs.getInt("EID");
			 data[rowCount][3]=rs.getInt("SID");
			 data[rowCount][4]=rs.getString("Item_Name");
			 data[rowCount][5]=rs.getInt("Item_Quantity");
			 data[rowCount][6]=rs.getString("Item_Categories");
			 data[rowCount][7]=rs.getInt("Itrm_Purity");
			 data[rowCount][8]=rs.getDouble("Item_Price");
			 data[rowCount][9]=rs.getInt("Item_Gram");
			 data[rowCount][10]=rs.getDate("Date");
			 data[rowCount][11]=rs.getTime("Time");
			 rowCount ++;
			 
			 }
			
			 
			 }catch(Exception e){
			 e.printStackTrace();
			 }
			 String [] colNames ={"SrNo","CID","EID","SID","Item_Name","Item_Quantity","Item_Categories","Itrm_Purity","Item_Price","Item_Gram","Date","Time"};
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
		   tblBill.setModel(dtm);
		   }
		   public void loadData(){
		    	 try{
		    		 String Query="select * from bill where SrNo=?";
		    	     PreparedStatement ps=con.prepareStatement(Query);
		    	     ps.setInt(1,Srno);
		    	     ResultSet rs=ps.executeQuery();
		    	     if (rs.next()){
		    	     txtSrno.setText(rs.getString("SrNo"));
		    	     txtCId.setText(rs.getString("CID"));
		    	     txtEId.setText(rs.getString("EID"));
		    	     txtSId.setText(rs.getString("SID"));
		    	     cmbName.setSelectedItem((rs.getString("Item_Name")));
		    	     txtQuantity.setText((rs.getString("Item_Quantity")));
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
				 txtCId.setText("");
				 txtEId.setText("");
				 txtSId.setText("");
				 txtCId.setText("");
				 txtQuantity.setText("");
				 cmbName.setSelectedItem(null);
				 cmbCategories.setSelectedItem(null);
				 cmbPurity.setSelectedItem(null);
				 cmbGram.setSelectedItem(null);
				 txtPrice.setText("");
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
	
	
	public void table(String Query){
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
		 data=new Object[rowCount][15];
		 rs=ps.executeQuery();
		 rowCount=0;
		
		 while(rs.next()){
		 data[rowCount][0]=rs.getInt("SrNo");
		 data[rowCount][1]=rs.getInt("CID");
		 data[rowCount][2]=rs.getString("CustomerName");
		 data[rowCount][3]=rs.getString("Item_Categories");
		 data[rowCount][4]=rs.getString("Item_Name");
         data[rowCount][5]=rs.getInt("Itrm_Purity");
         data[rowCount][6]=rs.getDouble("Item_Price");
         data[rowCount][7]=rs.getInt("Item_Gram");
         data[rowCount][8]=rs.getInt("Item_Quantity");
	     data[rowCount][9]=rs.getString("ShopName");
         data[rowCount][10]=rs.getString("ShopAddress");
         data[rowCount][11]=rs.getInt("EID");
         data[rowCount][12]=rs.getString("EmployeeName");  
		 data[rowCount][13]=rs.getDate("Date");
		 data[rowCount][14]=rs.getTime("Time");
		 rowCount ++;
		 
		 }
		
		 
		 }catch(Exception e){
		 e.printStackTrace();
		 }
		 String [] colNames ={"SrNo","CID","CustomerName","Item_Categories","Item_Name","Itrm_Purity","Item_Price","Item_Gram","Item_Quantity","ShopName","ShopAddress","EID","EmployeeName","Date","Time"};
		 setTableData(data,colNames);
		 }	
}
