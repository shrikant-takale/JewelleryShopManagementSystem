import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.regex.*;
import javax.swing.border.LineBorder;


public class Shop extends JPanel {
	private JTextField txtSrno;
	private JTextField txtSphno;
	private JTextField txtSname;
	private JTextField txtSeid;
	private JTextField txtSearchShop;
	private JTextArea  txtSaddr; 
	private JTable tblShop;
	private JLabel lblEsname;
	private JLabel lblEsrno;
	private JLabel lblEsemail;
	private JLabel lblEsaddr;
	private JLabel lblEsphno;
	Connection con;
	//int jobid;
	String s;
	int Srno;
	String Sphno;
	String Sname;
	String Seid;
	String Saddr;
	
	/**
	 * Create the panel.
	 */
	public Shop() {
		setBounds(249, 16, 980, 550);
		setLayout(null);
		
		JPanel panelContents = new JPanel();
		panelContents.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelContents.setForeground(Color.BLACK);
		panelContents.setBounds(12, 49, 953, 108);
		add(panelContents);
		panelContents.setLayout(null);
		
		getMySqLConnection();
		
		JLabel lblSrno = new JLabel("SrNo:-");
		lblSrno.setForeground(new Color(220, 20, 60));
		lblSrno.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblSrno.setHorizontalTextPosition(SwingConstants.CENTER);
		lblSrno.setHorizontalAlignment(SwingConstants.CENTER);
		lblSrno.setBounds(159, 9, 55, 20);
		panelContents.add(lblSrno);
		
		JLabel lblShopemailid = new JLabel("S-EmailId:-");
		lblShopemailid.setForeground(new Color(220, 20, 60));
		lblShopemailid.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblShopemailid.setHorizontalTextPosition(SwingConstants.CENTER);
		lblShopemailid.setHorizontalAlignment(SwingConstants.CENTER);
		lblShopemailid.setBounds(105, 45, 106, 20);
		panelContents.add(lblShopemailid);
		
		JLabel lblShopaddress = new JLabel("S-Address:-");
		lblShopaddress.setForeground(new Color(220, 20, 60));
		lblShopaddress.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblShopaddress.setHorizontalTextPosition(SwingConstants.CENTER);
		lblShopaddress.setHorizontalAlignment(SwingConstants.CENTER);
		lblShopaddress.setBounds(531, 47, 108, 20);
		panelContents.add(lblShopaddress);
		
		JLabel lblShopname = new JLabel("S-Name:-");
		lblShopname.setForeground(new Color(220, 20, 60));
		lblShopname.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblShopname.setHorizontalTextPosition(SwingConstants.CENTER);
		lblShopname.setHorizontalAlignment(SwingConstants.CENTER);
		lblShopname.setBounds(546, 9, 88, 20);
		panelContents.add(lblShopname);
		
		JLabel lblShopphonno = new JLabel("S-PhonNo:-");
		lblShopphonno.setForeground(new Color(220, 20, 60));
		lblShopphonno.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblShopphonno.setHorizontalTextPosition(SwingConstants.CENTER);
		lblShopphonno.setHorizontalAlignment(SwingConstants.CENTER);
		lblShopphonno.setBounds(105, 80, 106, 20);
		panelContents.add(lblShopphonno);
		
		txtSaddr = new JTextArea();
		txtSaddr.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				
				String PATTERN="^[#.0-9a-zA-Z\\s,-]+$";
			       Pattern patt=Pattern.compile(PATTERN);
			       Matcher match=patt.matcher(txtSaddr.getText());
			       if(!match.matches()) {
			    	   lblEsaddr.setText("Invalid Name!");  
			       }
			       else {
			    	   lblEsaddr.setText(null);
			       }
			}
		});
		txtSaddr.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtSaddr.setBounds(645, 41, 173, 34);
		panelContents.add(txtSaddr);
		
		 
		
		txtSrno = new JTextField();
		txtSrno.setEditable(false);
		txtSrno.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtSrno.setBounds(218, 7, 191, 26);
		panelContents.add(txtSrno);
		txtSrno.setColumns(10);
		
		txtSphno = new JTextField();
		txtSphno.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				
				String PATTERN="^[7-9][0-9]{9}$";
			       Pattern patt=Pattern.compile(PATTERN);
			       Matcher match=patt.matcher(txtSphno.getText());
			       if(!match.matches()) {
			    	  lblEsphno.setText("Invalid Name!");  
			       }
			       else {
			    	   lblEsphno.setText(null);
			       }
			}
		});
		txtSphno.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtSphno.setColumns(10);
		txtSphno.setBounds(220, 78, 189, 26);
		panelContents.add(txtSphno);
		
		txtSname = new JTextField();
		txtSname.setEnabled(false);
		txtSname.setText("Renuka Jewellers");
		txtSname.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				   
				       String PATTERN="^[A-Za-z]{0,30}$";
				       Pattern patt=Pattern.compile(PATTERN);
				       Matcher match=patt.matcher(txtSname.getText());
				       if(!match.matches()) {
				    	  lblEsname.setText("Invalid Name!");  
				       }
				       else {
				    	   lblEsname.setText(null);
				       }
			
			}});
		txtSname.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtSname.setColumns(10);
		txtSname.setBounds(645, 7, 173, 26);
		panelContents.add(txtSname);
		
		txtSeid = new JTextField();
		txtSeid.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				 String PATTERN="^[a-zA-Z0-9_+&*-]+(?:\\."+
                         "[a-zA-Z0-9_+&*-]+)*@" +
                         "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                         "A-Z]{2,7}$";
			       Pattern patt=Pattern.compile(PATTERN);
			       Matcher match=patt.matcher(txtSeid.getText());
			       if(!match.matches()) {
				    	  lblEsemail.setText("Invalid Email!");  
				       }
				       else {
				    	   lblEsemail.setText(null);
				       }
			}
		});
		txtSeid.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtSeid.setColumns(10);
		txtSeid.setBounds(219, 43, 190, 26);
		panelContents.add(txtSeid);
		
		lblEsrno = new JLabel("");
		lblEsrno.setHorizontalAlignment(SwingConstants.CENTER);
		lblEsrno.setBounds(416, 10, 120, 20);
		panelContents.add(lblEsrno);
		
		 lblEsemail = new JLabel("");
		lblEsemail.setHorizontalAlignment(SwingConstants.CENTER);
		lblEsemail.setBounds(413, 46, 120, 20);
		panelContents.add(lblEsemail);
		
		
		
		lblEsname = new JLabel("");
		lblEsname.setHorizontalAlignment(SwingConstants.CENTER);
		lblEsname.setBounds(825, 10, 120, 20);
		panelContents.add(lblEsname);
		
		lblEsaddr = new JLabel("");
		lblEsaddr.setHorizontalAlignment(SwingConstants.CENTER);
		lblEsaddr.setBounds(825, 48, 120, 20);
		panelContents.add(lblEsaddr);
		
		lblEsphno = new JLabel("");
		lblEsphno.setHorizontalAlignment(SwingConstants.CENTER);
		lblEsphno.setBounds(408, 81, 120, 20);
		panelContents.add(lblEsphno);
		
		
		
		JPanel panelButtons = new JPanel();
		panelButtons.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelButtons.setBounds(13, 160, 952, 50);
		add(panelButtons);
		panelButtons.setLayout(null);
		
		JButton btnSave = new JButton("Save");
		btnSave.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				// SAVE BUTTON
		        String Sname=txtSname.getText();
		        String Sphno=txtSphno.getText();//Integer.parseInt(txtSphno.getText());
		        String Query1="Select *  From Shop";
		        String Saddr=txtSaddr.getText();
		        String Seid=txtSeid.getText();
		     
		     
		      
		        String Query="insert into shop(ShopName,ShopEmailId,ShopAddress,ShopPhNo,Date,Time) values (?,?,?,?,?,?)";				
		PreparedStatement ps=null;
		if(Sname.length()!=0 || Saddr.length()!=0 || Seid.length()!=0 || Sphno.length()!=0) {
		//Obtaining current date
		Calendar calendar=Calendar.getInstance();
		SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd");
		String date=formatter.format(calendar.getTime());
		//Obtaining Current Time
		formatter=new SimpleDateFormat("HH:mm:ss");
		String time=formatter.format(calendar.getTime());
		try{            ps=con.prepareStatement(Query);
		                ps.setString(1, Sname);
		                ps.setString(2, Seid);
		                ps.setString(3, Saddr);
		                ps.setString(4, Sphno);
		                ps.setString(5, date);
		                ps.setString(6, time);
		                ps.execute();
		                fetchJobs(Query1);
		                JOptionPane.showMessageDialog(null, "Insertion Successfully.....");
		            }catch(SQLException e){
		                System.out.println(e.getMessage());
		            }
		         }
		            txtSname.setText("");
		            txtSphno.setText("");
		            txtSaddr.setText("");
		            txtSeid.setText("");
		            
			}
			      
		});
		
		btnSave.setForeground(new Color(220, 20, 60));
		btnSave.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnSave.setBounds(202, 4, 115, 40);
		panelButtons.add(btnSave);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				 try{
					 
				
			        Sphno=txtSphno.getText();
			        Saddr=txtSaddr.getText();
			        Seid=txtSeid.getText();
					 String Query="Select * From Shop";
			         PreparedStatement ps=con.prepareStatement("update Shop set ShopAddress=?, ShopEmailId=?,ShopPhNo=? where SrNo=?");
			        
			         ps.setString(1, Saddr);
			         ps.setString(2, Seid);
			         ps.setString(3, Sphno);
			         ps.setInt(4, Srno);
			         ps.execute();
			         fetchJobs(Query);
			         JOptionPane.showMessageDialog(null, "Update Successfully.....");
			        }
			        catch(SQLException e){
			        }
				 
			}
		});
		btnUpdate.setForeground(new Color(220, 20, 60));
		btnUpdate.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnUpdate.setBounds(332, 5, 115, 40);
		panelButtons.add(btnUpdate);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try{
					
					String Query="Select * From Shop";
			        PreparedStatement ps=con.prepareStatement("delete from Shop where SrNo=?");
			         ps.setInt(1,Srno);
			         ps.execute();
			        fetchJobs(Query);
			        JOptionPane.showMessageDialog(null, "Delete Successfully.....");
			        }
			        catch(SQLException e){}
			}
		});
		btnDelete.setForeground(new Color(220, 20, 60));
		btnDelete.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnDelete.setBounds(458, 5, 115, 40);
		panelButtons.add(btnDelete);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String Query="Select * From Shop";
				txtSrno.setText("");
				//txtSname.setText("");
	            txtSphno.setText("");
	            txtSaddr.setText("");
	            txtSeid.setText("");
	            fetchJobs(Query);
						
			}
		});
		btnReset.setForeground(new Color(220, 20, 60));
		btnReset.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnReset.setBounds(588, 5, 115, 40);
		panelButtons.add(btnReset);
		
		JPanel panelTitle = new JPanel();
		panelTitle.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelTitle.setBounds(12, 0, 953, 46);
		add(panelTitle);
		panelTitle.setLayout(null);
		
		JLabel lblShopForm = new JLabel("ShopForm");
		lblShopForm.setForeground(new Color(220, 20, 60));
		lblShopForm.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblShopForm.setHorizontalAlignment(SwingConstants.CENTER);
		lblShopForm.setBounds(415, 7, 120, 32);
		panelTitle.add(lblShopForm);
		
		JPanel panelSearch = new JPanel();
		panelSearch.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelSearch.setBounds(12, 212, 953, 40);
		add(panelSearch);
		panelSearch.setLayout(null);
		
		txtSearchShop = new JTextField();
		txtSearchShop.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				String Query="SELECT * FROM Shop WHERE ShopAddress LIKE '%" + txtSearchShop.getText() + "%'";
				fetchJobs(Query);
			}
		});
	
		
		txtSearchShop.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtSearchShop.setColumns(10);
		txtSearchShop.setBounds(197, 7, 741, 26);
		panelSearch.add(txtSearchShop);
		
		JLabel lblSearchshopname = new JLabel("SearchShop:-");
		lblSearchshopname.setForeground(new Color(220, 20, 60));
		lblSearchshopname.setHorizontalTextPosition(SwingConstants.CENTER);
		lblSearchshopname.setHorizontalAlignment(SwingConstants.CENTER);
		lblSearchshopname.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblSearchshopname.setBounds(69, 10, 153, 20);
		panelSearch.add(lblSearchshopname);
		
		JPanel panelTable = new JPanel();
		panelTable.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelTable.setBounds(12, 258, 953, 276);
		add(panelTable);
		panelTable.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(15, 16, 923, 244);
		panelTable.add(scrollPane);
		
		tblShop = new JTable();
		tblShop.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		scrollPane.setViewportView(tblShop);
		tblShop.addMouseListener(new MouseAdapter(){
		       @Override
		       public void mouseClicked(MouseEvent e){
		       if(e.getClickCount()==2){
		           JTable target=(JTable)e.getSource();
		           int row=target.getSelectedRow();
		           Srno=Integer.parseInt(tblShop.getValueAt(row,0).toString());
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
		 data=new Object[rowCount][7];
		 rs=ps.executeQuery();
		 rowCount=0;
		 while(rs.next()){
		 data[rowCount][0]=rs.getInt("SrNo");
		 data[rowCount][1]=rs.getString("ShopName");
		 data[rowCount][2]=rs.getString("ShopAddress");
		 data[rowCount][3]=rs.getString("ShopEmailId");
		 data[rowCount][4]=rs.getString("ShopPhNo");
		 data[rowCount][5]=rs.getDate("Date");
		 data[rowCount][6]=rs.getTime("Time");
		 rowCount ++;
		 }
		 }catch(Exception e){
		 e.printStackTrace();
		 }
		 String [] colNames ={"SrNo","ShopName","ShopAddress","ShopEmailId","ShopPhNo","Date","Time"};
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
	   
	   tblShop.setModel(dtm);
	   }
	   
	  
	     public void loadData(){
	    	 try{
	    		 String Query="select * from Shop where SrNo=?";
	    	     PreparedStatement ps=con.prepareStatement(Query);
	    	     ps.setInt(1,Srno);
	    	     ResultSet rs=ps.executeQuery();
	    	     if (rs.next()){
	    	     txtSrno.setText(rs.getString("SrNo"));;
	    	     //jLabel5.setText("  Date: "+rs.getDate("date"));
	    	     //jLabel6.setText("  Time: "+rs.getTime("time"));
	    	     txtSaddr.setText(rs.getString("ShopAddress"));
	    	     txtSname.setText(rs.getString("ShopName"));
	    	     txtSeid.setText(rs.getString("ShopEmailId"));
	    	     txtSphno.setText (rs.getString("ShopPhNo"));
	    	     	
	    	    
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
}
