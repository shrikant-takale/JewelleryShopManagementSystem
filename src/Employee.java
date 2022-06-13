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
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.DefaultComboBoxModel;
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


public class Employee extends JPanel {
	private JTextField txtSrno;
	private JTextField txtPhno;
	private JTextField txtName;
	private JTextField txtEmail;
	private JTextField txtSearch;
	private JTextField txtSalary;
	private JTable tblEmployee;
	Connection con;
	int Srno; 
	private JTextArea txtAddr;
	private JComboBox<String> cmbType;
	private JComboBox<String> cmbAge;

	/**
	 * Create the panel.
	 */
	public Employee() {
		setBounds(249, 16, 980, 550);
		setLayout(null);
		
		JPanel panelTitle = new JPanel();
		panelTitle.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelTitle.setLayout(null);
		panelTitle.setBounds(10, 5, 955, 46);
		add(panelTitle);
		getMySqLConnection();
		
		
		JLabel lblEmployeeform = new JLabel("EmployeeForm");
		lblEmployeeform.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmployeeform.setForeground(new Color(220, 20, 60));
		lblEmployeeform.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblEmployeeform.setBounds(356, 7, 191, 32);
		panelTitle.add(lblEmployeeform);
		
		JPanel panelContent = new JPanel();
		panelContent.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelContent.setLayout(null);
		panelContent.setForeground(Color.BLACK);
		panelContent.setBounds(10, 54, 955, 137);
		add(panelContent);
		
		JLabel label_1 = new JLabel("SrNo:-");
		label_1.setHorizontalTextPosition(SwingConstants.CENTER);
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setForeground(new Color(220, 20, 60));
		label_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		label_1.setBounds(141, 5, 55, 20);
		panelContent.add(label_1);
		
		JLabel lblEmployeemailid = new JLabel("E-EmailId:-");
		lblEmployeemailid.setHorizontalTextPosition(SwingConstants.CENTER);
		lblEmployeemailid.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmployeemailid.setForeground(new Color(220, 20, 60));
		lblEmployeemailid.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblEmployeemailid.setBounds(93, 37, 106, 20);
		panelContent.add(lblEmployeemailid);
		
		JLabel lblEmployeeaddress = new JLabel("E-Address:-");
		lblEmployeeaddress.setHorizontalTextPosition(SwingConstants.CENTER);
		lblEmployeeaddress.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmployeeaddress.setForeground(new Color(220, 20, 60));
		lblEmployeeaddress.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblEmployeeaddress.setBounds(488, 39, 109, 20);
		panelContent.add(lblEmployeeaddress);
		
		JLabel lblEmployeename = new JLabel("E-Name:-");
		lblEmployeename.setHorizontalTextPosition(SwingConstants.CENTER);
		lblEmployeename.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmployeename.setForeground(new Color(220, 20, 60));
		lblEmployeename.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblEmployeename.setBounds(505, 5, 92, 20);
		panelContent.add(lblEmployeename);
		
		JLabel lblEmployeephonno = new JLabel("E-PhonNo:-");
		lblEmployeephonno.setHorizontalTextPosition(SwingConstants.CENTER);
		lblEmployeephonno.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmployeephonno.setForeground(new Color(220, 20, 60));
		lblEmployeephonno.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblEmployeephonno.setBounds(93, 74, 106, 20);
		panelContent.add(lblEmployeephonno);
		
		txtAddr = new JTextArea();
		txtAddr.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtAddr.setBounds(603, 33, 167, 30);
		panelContent.add(txtAddr);
		
		txtSrno = new JTextField();
		txtSrno.setEditable(false);
		txtSrno.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtSrno.setColumns(10);
		txtSrno.setBounds(202, 3, 204, 26);
		panelContent.add(txtSrno);
		
		txtPhno = new JTextField();
		txtPhno.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtPhno.setColumns(10);
		txtPhno.setBounds(204, 74, 203, 26);
		panelContent.add(txtPhno);
		
		txtName = new JTextField();
		txtName.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtName.setColumns(10);
		txtName.setBounds(603, 3, 167, 26);
		panelContent.add(txtName);
		
		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtEmail.setColumns(10);
		txtEmail.setBounds(203, 35, 204, 26);
		panelContent.add(txtEmail);
		
		JLabel lblEmployeetype = new JLabel("E-Type:-");
		lblEmployeetype.setHorizontalTextPosition(SwingConstants.CENTER);
		lblEmployeetype.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmployeetype.setForeground(new Color(220, 20, 60));
		lblEmployeetype.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblEmployeetype.setBounds(510, 71, 83, 20);
		panelContent.add(lblEmployeetype);
		
		cmbType = new JComboBox<String>();
		cmbType.setBounds(599, 68, 171, 30);
		panelContent.add(cmbType);
		
		txtSalary = new JTextField();
		txtSalary.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtSalary.setColumns(10);
		txtSalary.setBounds(203, 107, 203, 26);
		panelContent.add(txtSalary);
		
		JLabel lblEsalary = new JLabel("E-Salary:-");
		lblEsalary.setHorizontalTextPosition(SwingConstants.CENTER);
		lblEsalary.setHorizontalAlignment(SwingConstants.CENTER);
		lblEsalary.setForeground(new Color(220, 20, 60));
		lblEsalary.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblEsalary.setBounds(103, 110, 93, 20);
		panelContent.add(lblEsalary);
		
		JLabel lblEage = new JLabel("E-Age:-");
		lblEage.setHorizontalTextPosition(SwingConstants.CENTER);
		lblEage.setHorizontalAlignment(SwingConstants.CENTER);
		lblEage.setForeground(new Color(220, 20, 60));
		lblEage.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblEage.setBounds(510, 104, 83, 20);
		panelContent.add(lblEage);
		
		cmbAge = new JComboBox<String>();
		cmbAge.setBounds(599, 101, 171, 30);
		panelContent.add(cmbAge);
		
		JPanel panelSearchShop = new JPanel();
		panelSearchShop.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelSearchShop.setLayout(null);
		panelSearchShop.setBounds(10, 248, 955, 34);
		add(panelSearchShop);
		
		txtSearch = new JTextField();
		txtSearch.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				String Query="SELECT * FROM employee WHERE EmployeeName LIKE '%" + txtSearch.getText() + "%'";
				fetchJobs(Query);
			}
		});
		txtSearch.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtSearch.setColumns(10);
		txtSearch.setBounds(177, 4, 763, 26);
		panelSearchShop.add(txtSearch);
		
		JLabel lblSearchemployeename = new JLabel("SearchEmployee:-");
		lblSearchemployeename.setHorizontalTextPosition(SwingConstants.CENTER);
		lblSearchemployeename.setHorizontalAlignment(SwingConstants.CENTER);
		lblSearchemployeename.setForeground(new Color(220, 20, 60));
		lblSearchemployeename.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblSearchemployeename.setBounds(22, 8, 153, 20);
		panelSearchShop.add(lblSearchemployeename);
		
		JPanel panelTable = new JPanel();
		panelTable.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelTable.setLayout(null);
		panelTable.setBounds(10, 294, 955, 251);
		add(panelTable);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(7, 5, 940, 243);
		panelTable.add(scrollPane);
		
	
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setLayout(null);
		panel.setBounds(11, 195, 952, 50);
		add(panel);
		
		JButton btnSave = new JButton("Save");
		btnSave.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				 String EName=txtName.getText();
			        String Ephno=txtPhno.getText();//Integer.parseInt(txtSphno.getText());
			        String Query1="Select *  From Employee";
			        String Eaddr=txtAddr.getText();
			        String EAge=cmbAge.getSelectedItem().toString();
			        String Eeid=txtEmail.getText();
			        String EType=cmbType.getSelectedItem().toString();
			        String ESalary=txtSalary.getText();
			        String Query="insert into employee(EmployeeName,EmployeeEmail,EmployeeAddress,EmployeeAge,EmployeePhno,EmployeeType,EmployeeSalary,Date,Time) values (?,?,?,?,?,?,?,?,?)";				
			PreparedStatement ps=null;
			if(EName.length()!=0 || Eaddr.length()!=0 || Eeid.length()!=0 || Ephno.length()!=0) {
			//Obtaining current date
			Calendar calendar=Calendar.getInstance();
			SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd");
			String date=formatter.format(calendar.getTime());
			//Obtaining Current Time
			formatter=new SimpleDateFormat("HH:mm:ss");
			String time=formatter.format(calendar.getTime());
			
				try{       ps=con.prepareStatement(Query);
							
			                ps.setString(1, EName);
			                ps.setString(2, Eeid);
			                ps.setString(3, Eaddr);
			                ps.setString(4, EAge);
			                ps.setString(5, Ephno);
			                ps.setString(6, EType);
			                ps.setString(7, ESalary);
			                ps.setString(8, date);
			                ps.setString(9, time);
			               
			                ps.execute();
			                fetchJobs(Query1);
			                JOptionPane.showMessageDialog(null, "Insertion Successfully.....");
			            }catch(SQLException e){
			                System.out.println(e.getMessage());
			            }
			         }
						Reset();
					}
		});
		btnSave.setForeground(new Color(220, 20, 60));
		btnSave.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnSave.setBounds(296, 4, 115, 40);
		panel.add(btnSave);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				 try{
					 
					     String EName=txtName.getText();
					     String EEmail=txtEmail.getText();
					     String EAddr=txtAddr.getText();
					     String EcmbAge=cmbAge.getSelectedItem().toString();
					     String EPhno=txtPhno.getText();
					     String EcmbType=cmbType.getSelectedItem().toString();
					     String ESalary=txtSalary.getText();
						 String Query="Select * From employee";
				         PreparedStatement ps=con.prepareStatement("update employee set EmployeeName=?,EmployeeEmail=?,EmployeeAddress=?,EmployeeAge=?,EmployeePhno=?,EmployeeType=?,EmployeeSalary=? where SrNo=?");
				         ps.setString(1, EName);
				         ps.setString(2, EEmail);
				         ps.setString(3, EAddr);
				         ps.setString(4, EcmbAge);
				         ps.setString(5, EPhno);
				         ps.setString(6, EcmbType);
				         ps.setString(7, ESalary);
				         ps.setInt(8, Srno);
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
		btnUpdate.setBounds(426, 5, 115, 40);
		panel.add(btnUpdate);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try{
					
					String Query="Select * From employee";
			        PreparedStatement ps=con.prepareStatement("delete from employee where SrNo=?");
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
		btnDelete.setBounds(552, 5, 115, 40);
		panel.add(btnDelete);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String Query="Select * From employee";
				Reset();
				cmbType();
				cmbAge();
				fetchJobs(Query);
			}
		});
		btnReset.setForeground(new Color(220, 20, 60));
		btnReset.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnReset.setBounds(682, 5, 115, 40);
		panel.add(btnReset);
		
		JButton btnShow = new JButton("Show");
		btnShow.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String Query="Select * From employee";
				//Reset();
				//cmbType();
				//cmbAge();
				fetchJobs(Query);
			}
		});
		btnShow.setForeground(new Color(220, 20, 60));
		btnShow.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnShow.setBounds(812, 4, 115, 40);
		panel.add(btnShow);
		
		JButton btnReport = new JButton("Report");
		btnReport.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try{
				 	con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jewelleryshopmanagement","root","shrikant@123");
				 	String sql1="Select * From Employee";
				 	String sql="SELECT EmployeeName,EmployeeAddress,EmployeeEmail,EmployeeAge,EmployeePhno,EmployeeType,EmployeeSalary,Date,Time FROM Employee";
			    	JasperDesign jdesigner=JRXmlLoader.load("C:\\Users\\Shrikant\\Desktop\\java xyz\\JewelleryShopManagement1\\Reports\\empl.jrxml");
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
		 		}
				
			}
		});
		btnReport.setForeground(new Color(220, 20, 60));
		btnReport.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnReport.setBounds(10, 4, 115, 40);
		panel.add(btnReport);
		
		JButton btnReport2 = new JButton("Report2");
		btnReport2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getSource()==btnReport2)
		    	{
		    		try
		    		{
		    			Statement  st=con.createStatement();
						ResultSet rs=st.executeQuery("Select * From Employee");
						
						tblEmployee.setAutoResizeMode(tblEmployee.AUTO_RESIZE_ALL_COLUMNS);
						tblEmployee.setModel(DbUtils.resultSetToTableModel(rs));
						tblEmployee.print(JTable.PrintMode.NORMAL);	
		    		}catch(Exception e1)
		    		{
		    			JOptionPane.showMessageDialog(null,e1);
		    		}
		    	}
			}
		});
		btnReport2.setForeground(new Color(220, 20, 60));
		btnReport2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnReport2.setBounds(152, 4, 115, 40);
		panel.add(btnReport2);
		setVisible(true);
		
		tblEmployee = new JTable();
		scrollPane.setViewportView(tblEmployee);
		tblEmployee.addMouseListener(new MouseAdapter(){
		       @Override
		       public void mouseClicked(MouseEvent e){
		       if(e.getClickCount()==2){
		           JTable target=(JTable)e.getSource();
		           int row=target.getSelectedRow();
		           Srno=Integer.parseInt(tblEmployee.getValueAt(row,0).toString());
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
		 data=new Object[rowCount][10];
		 rs=ps.executeQuery();
		 rowCount=0;
		 while(rs.next()){
		 data[rowCount][0]=rs.getInt("SrNo");
		 data[rowCount][1]=rs.getString("EmployeeName");
		 data[rowCount][2]=rs.getString("EmployeeEmail");
		 data[rowCount][3]=rs.getString("EmployeeAddress");
		 data[rowCount][4]=rs.getString("EmployeeAge");
		 data[rowCount][5]=rs.getString("EmployeePhno");
		 data[rowCount][6]=rs.getString("EmployeeType");
		 data[rowCount][7]=rs.getString("EmployeeSalary");
		 data[rowCount][8]=rs.getDate("Date");
		 data[rowCount][9]=rs.getTime("Time");
		 rowCount ++;
		 }
		 }catch(Exception e){
		 e.printStackTrace();
		 }
		 String [] colNames ={"SrNo","EmployeeName","EmployeeEmail","EmployeeAddress","EmployeeAge","EmployeePhno","EmployeeType","EmployeeSalary","Date","Time"};
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
	   
	   tblEmployee.setModel(dtm);
	   }
	 public void loadData(){
   	 try{
   		 String Query="select * from employee where SrNo=?";
   	     PreparedStatement ps=con.prepareStatement(Query);
   	     ps.setInt(1,Srno);
   	     ResultSet rs=ps.executeQuery();
   	     if (rs.next()){
   	    txtSrno.setText(rs.getString("SrNo"));
   	     txtName.setText(rs.getString("EmployeeName"));
   	     txtAddr.setText(rs.getString("EmployeeAddress"));
   	     cmbAge.removeAllItems();
   	     cmbAge.addItem(rs.getString("EmployeeAge"));
   	     txtEmail.setText(rs.getString("EmployeeEmail"));
   	     txtPhno.setText (rs.getString("EmployeePhno"));
   	     txtSalary.setText (rs.getString("EmployeeSalary"));
   	     cmbType.removeAllItems();
   	     cmbType.addItem(rs.getString("EmployeeType"));
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
   	  cmbType1();
      cmbAge1();
   	     }
   	 }
   	 catch (SQLException e){
   	 System.out.println("Sql Exception in SELECT");
   	 }
   	 }
	 
	 public void cmbType() {
		 cmbType.removeAllItems();
		 cmbType.addItem("Sales Executive");
		 cmbType.addItem("Account Assistant");
		 cmbType.addItem("Lead Cashier");
		 cmbType.addItem("Sales Representative");
		 cmbType.addItem("Self Employed");
		 cmbType.addItem("Selsman");
		 cmbType.addItem("Senior Accountant");
		 cmbType.addItem("Store Manager");
		 cmbType.setSelectedItem(null);
	
	 }
	  public void cmbType1() {
			 cmbType.addItem("Sales Executive");
			 cmbType.addItem("Account Assistant");
			 cmbType.addItem("Lead Cashier");
			 cmbType.addItem("Sales Representative");
			 cmbType.addItem("Self Employed");
			 cmbType.addItem("Selsman");
			 cmbType.addItem("Senior Accountant");
			 cmbType.addItem("Store Manager");
		 }
	  public void cmbAge() {
		  cmbAge.removeAllItems();
		  cmbAge.addItem("24");
		  cmbAge.addItem("25");
		  cmbAge.addItem("26");
		  cmbAge.addItem("27");
		  cmbAge.addItem("28");
		  cmbAge.addItem("29");
		  cmbAge.addItem("30");
		  cmbAge.addItem("31");
		  cmbAge.setSelectedItem(null);
		
		 }
		  public void cmbAge1() {
			  cmbAge.addItem("24");
			  cmbAge.addItem("25");
			  cmbAge.addItem("26");
			  cmbAge.addItem("27");
			  cmbAge.addItem("28");
			  cmbAge.addItem("29");
			  cmbAge.addItem("30");
			  cmbAge.addItem("31");
			 }
	  public void  Reset(){
		  txtSrno.setText("");
		  txtName.setText("");
          txtPhno.setText("");
          txtAddr.setText("");
          txtEmail.setText("");
          cmbType.removeAllItems();
          cmbAge.removeAllItems();
          txtSalary.setText("");
	  }
}
