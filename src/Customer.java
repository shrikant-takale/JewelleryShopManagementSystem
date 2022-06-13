import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.border.LineBorder;

public class Customer extends JPanel {
	private JTextField txtSrno;
	private JTextField txtPhno;
	private JTextField txtName;
	private JTextField txtEmail;
	private JTextField txtSearch;
	private JTable tblCustomer;
	private JLabel lblEsrno;
	private JLabel lblEname;
	private JLabel lblEemail;
	private JLabel lblEaddr;
	private JLabel lblEphno;
	private JTextArea txtAddr;
	private JButton btnSave ;
	private JButton btnUpdate;
	private JButton btnDelete;
	private JButton btnReset;
	Connection con;
	int Srno;
	private String Name;
	private String Addr;
	private String Phno;
	private String Email;
	int jobid;
	private JButton btnShow;
	/**
	 * Create the panel.
	 */
	public Customer() {
		setBounds(249, 16, 980, 550);
		setLayout(null);
		
		JPanel panelTitle = new JPanel();
		panelTitle.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelTitle.setLayout(null);
		panelTitle.setBounds(10, 0, 955, 46);
		add(panelTitle);
		
		getMySqLConnection();
		
		JLabel lblCustomerform = new JLabel("CustomerForm");
		lblCustomerform.setHorizontalAlignment(SwingConstants.CENTER);
		lblCustomerform.setForeground(new Color(220, 20, 60));
		lblCustomerform.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblCustomerform.setBounds(378, 7, 191, 32);
		panelTitle.add(lblCustomerform);
		
		JPanel panelContent = new JPanel();
		panelContent.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelContent.setLayout(null);
		panelContent.setForeground(Color.BLACK);
		panelContent.setBounds(10, 49, 955, 108);
		add(panelContent);
		
		JLabel label_1 = new JLabel("SrNo:-");
		label_1.setHorizontalTextPosition(SwingConstants.CENTER);
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setForeground(new Color(220, 20, 60));
		label_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		label_1.setBounds(148, 9, 55, 20);
		panelContent.add(label_1);
		
		JLabel lblCustomeremailid = new JLabel("C-EmailId:-");
		lblCustomeremailid.setHorizontalTextPosition(SwingConstants.CENTER);
		lblCustomeremailid.setHorizontalAlignment(SwingConstants.CENTER);
		lblCustomeremailid.setForeground(new Color(220, 20, 60));
		lblCustomeremailid.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblCustomeremailid.setBounds(90, 45, 116, 20);
		panelContent.add(lblCustomeremailid);
		
		JLabel lblCustomeraddress = new JLabel("C-Address:-");
		lblCustomeraddress.setHorizontalTextPosition(SwingConstants.CENTER);
		lblCustomeraddress.setHorizontalAlignment(SwingConstants.CENTER);
		lblCustomeraddress.setForeground(new Color(220, 20, 60));
		lblCustomeraddress.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblCustomeraddress.setBounds(514, 47, 110, 20);
		panelContent.add(lblCustomeraddress);
		
		JLabel lblCustomername = new JLabel("C-Name:-");
		lblCustomername.setHorizontalTextPosition(SwingConstants.CENTER);
		lblCustomername.setHorizontalAlignment(SwingConstants.CENTER);
		lblCustomername.setForeground(new Color(220, 20, 60));
		lblCustomername.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblCustomername.setBounds(534, 9, 90, 20);
		panelContent.add(lblCustomername);
		
		JLabel lblCustomerphonno = new JLabel("C-PhonNo:-");
		lblCustomerphonno.setHorizontalTextPosition(SwingConstants.CENTER);
		lblCustomerphonno.setHorizontalAlignment(SwingConstants.CENTER);
		lblCustomerphonno.setForeground(new Color(220, 20, 60));
		lblCustomerphonno.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblCustomerphonno.setBounds(90, 80, 116, 20);
		panelContent.add(lblCustomerphonno);
		
		txtAddr = new JTextArea();
		txtAddr.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				String PATTERN="^[#.0-9a-zA-Z\\s,-]+$";
			       Pattern patt=Pattern.compile(PATTERN);
			       Matcher match=patt.matcher(txtAddr.getText());
			       if(!match.matches()) {
			    	   lblEaddr.setText("Invalid Name!");  
			       }
			       else {
			    	   lblEaddr.setText(null);
			       }
			}
		});
		txtAddr.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtAddr.setBounds(627, 36, 162, 34);
		panelContent.add(txtAddr);
		
		txtSrno = new JTextField();
		txtSrno.setEditable(false);
		txtSrno.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtSrno.setColumns(10);
		txtSrno.setBounds(215, 7, 166, 26);
		panelContent.add(txtSrno);
		
		txtPhno = new JTextField();
		txtPhno.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				String PATTERN="^[7-9][0-9]{9}$";
			       Pattern patt=Pattern.compile(PATTERN);
			       Matcher match=patt.matcher(txtPhno.getText());
			       if(!match.matches()) {
			    	   lblEphno.setText("Invalid Name!");  
			       }
			       else {
			    	   lblEphno.setText(null);
			       }
			}
		});
		txtPhno.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtPhno.setColumns(10);
		txtPhno.setBounds(217, 78, 164, 26);
		panelContent.add(txtPhno);
		
		txtName = new JTextField();
		txtName.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				 String PATTERN="^[A-Za-z]{0,30}$";
			       Pattern patt=Pattern.compile(PATTERN);
			       Matcher match=patt.matcher(txtName.getText());
			       if(!match.matches()) {
			    	   lblEname.setText("Invalid Name!");  
			       }
			       else {
			    	   lblEname.setText(null);
			       }
			}
		});
		txtName.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtName.setColumns(10);
		txtName.setBounds(627, 7, 162, 26);
		panelContent.add(txtName);
		
		txtEmail = new JTextField();
		txtEmail.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				String PATTERN="^[a-zA-Z0-9_+&*-]+(?:\\."+
                        "[a-zA-Z0-9_+&*-]+)*@" +
                        "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                        "A-Z]{2,7}$";
			       Pattern patt=Pattern.compile(PATTERN);
			       Matcher match=patt.matcher(txtEmail.getText());
			       if(!match.matches()) {
			    	   lblEemail.setText("Invalid Email!");  
				       }
				       else {
				    	   lblEemail.setText(null);
				       }
			}
		});
		txtEmail.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtEmail.setColumns(10);
		txtEmail.setBounds(216, 43, 165, 26);
		panelContent.add(txtEmail);
		
		lblEsrno = new JLabel("");
		lblEsrno.setHorizontalAlignment(SwingConstants.CENTER);
		lblEsrno.setBounds(394, 10, 116, 20);
		panelContent.add(lblEsrno);
		
		lblEemail = new JLabel("");
		lblEemail.setHorizontalAlignment(SwingConstants.CENTER);
		lblEemail.setBounds(394, 46, 116, 20);
		panelContent.add(lblEemail);
		
		lblEphno = new JLabel("");
		lblEphno.setHorizontalAlignment(SwingConstants.CENTER);
		lblEphno.setBounds(395, 81, 115, 20);
		panelContent.add(lblEphno);
		
		lblEname = new JLabel("");
		lblEname.setHorizontalAlignment(SwingConstants.CENTER);
		lblEname.setBounds(792, 10, 136, 20);
		panelContent.add(lblEname);
		
		lblEaddr = new JLabel("");
		lblEaddr.setHorizontalAlignment(SwingConstants.CENTER);
		lblEaddr.setBounds(792, 46, 136, 20);
		panelContent.add(lblEaddr);
		
		JPanel panelSearchCustomer = new JPanel();
		panelSearchCustomer.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelSearchCustomer.setLayout(null);
		panelSearchCustomer.setBounds(10, 217, 955, 40);
		add(panelSearchCustomer);
		
		txtSearch = new JTextField();
		txtSearch.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				String Query="SELECT * FROM customer WHERE CustomerName LIKE '%" + txtSearch.getText() + "%'";
				fetchJobs(Query);
			}
		});
		txtSearch.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtSearch.setColumns(10);
		txtSearch.setBounds(204, 7, 736, 26);
		panelSearchCustomer.add(txtSearch);
		
		JLabel lblSearchcustomer = new JLabel("SearchCustomer:-");
		lblSearchcustomer.setHorizontalTextPosition(SwingConstants.CENTER);
		lblSearchcustomer.setHorizontalAlignment(SwingConstants.CENTER);
		lblSearchcustomer.setForeground(new Color(220, 20, 60));
		lblSearchcustomer.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblSearchcustomer.setBounds(55, 10, 153, 20);
		panelSearchCustomer.add(lblSearchcustomer);
		
		JPanel panelTable = new JPanel();
		panelTable.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelTable.setLayout(null);
		panelTable.setBounds(10, 266, 955, 276);
		add(panelTable);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(15, 16, 927, 244);
		panelTable.add(scrollPane);
		
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setLayout(null);
		panel.setBounds(10, 160, 952, 50);
		add(panel);
		
		btnSave = new JButton("Save");
		btnSave.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
						// SAVE BUTTON
				        String CName=txtName.getText();
				        String Cphno=txtPhno.getText();//Integer.parseInt(txtSphno.getText());
				        String Query1="Select *  From customer";
				        String Caddr=txtAddr.getText();
				        String Ceid=txtEmail.getText();
				        String Query="insert into customer(CustomerName,CustomerAddress,CustomerEmail,CustomerPhno,Date,Time) values (?,?,?,?,?,?)";				
				PreparedStatement ps=null;
				if(CName.length()!=0 || Caddr.length()!=0 || Ceid.length()!=0 || Cphno.length()!=0) {
				//Obtaining current date
				Calendar calendar=Calendar.getInstance();
				SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd");
				String date=formatter.format(calendar.getTime());
				//Obtaining Current Time
				formatter=new SimpleDateFormat("HH:mm:ss");
				String time=formatter.format(calendar.getTime());
				try{            ps=con.prepareStatement(Query);
								
				                ps.setString(1, CName);
				                ps.setString(2, Caddr);
				                ps.setString(3, Ceid);
				                ps.setString(4, Cphno);
				                ps.setString(5, date);
				                ps.setString(6, time);
				                
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
		btnSave.setBounds(214, 4, 115, 40);
		panel.add(btnSave);
		
		
		
		btnUpdate = new JButton("Update");
		btnUpdate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try{
					 
					String Name=txtName.getText();
			        String Phno=txtPhno.getText();
			        String Addr=txtAddr.getText();
			        String Email=txtEmail.getText();
					 String Query="Select * From Customer";
			         PreparedStatement ps=con.prepareStatement("update customer set CustomerName=?,CustomerAddress=?, CustomerEmail=?,CustomerPhNo=? where SrNo=?");
			         ps.setString(1, Name);
			         ps.setString(2, Addr);
			         ps.setString(3, Email);
			         ps.setString(4, Phno);
			         ps.setInt(5, Srno);
			         ps.execute();
			         Reset();
			         fetchJobs(Query);
			         JOptionPane.showMessageDialog(null, "Update Successfully.....");
			        }
			        catch(SQLException e){
			        }
			}
		});
		btnUpdate.setForeground(new Color(220, 20, 60));
		btnUpdate.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnUpdate.setBounds(344, 5, 115, 40);
		panel.add(btnUpdate);
		
		
		btnDelete = new JButton("Delete");
		btnDelete.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try{
					String Query="Select * From customer";
			        PreparedStatement ps=con.prepareStatement("delete from Customer where SrNo=?");
			         ps.setInt(1,Srno);
			         ps.execute();
			         Reset();
			        fetchJobs(Query);
			        JOptionPane.showMessageDialog(null, "Delete Successfully.....");
			        }
			        	catch(SQLException e){}
			}
		});
		btnDelete.setForeground(new Color(220, 20, 60));
		btnDelete.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnDelete.setBounds(470, 5, 115, 40);
		panel.add(btnDelete);
		
		btnReset = new JButton("Reset");
		btnReset.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String Query="Select * From Customer";
				Reset();
	            fetchJobs(Query);
			}
		});
		btnReset.setForeground(new Color(220, 20, 60));
		btnReset.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnReset.setBounds(600, 5, 115, 40);
		panel.add(btnReset);
		
		btnShow = new JButton("Show");
		btnShow.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String Query="Select * From Customer";
				//Reset();
	            fetchJobs(Query);
			}
		});
		btnShow.setForeground(new Color(220, 20, 60));
		btnShow.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnShow.setBounds(730, 4, 115, 40);
		panel.add(btnShow);
		setVisible(true);
		
		
		tblCustomer = new JTable();
		scrollPane.setViewportView(tblCustomer);
		tblCustomer.addMouseListener(new MouseAdapter(){
		       @Override
		       public void mouseClicked(MouseEvent e){
		       if(e.getClickCount()==2){
		           JTable target=(JTable)e.getSource();
		           int row=target.getSelectedRow();
		           Srno=Integer.parseInt(tblCustomer.getValueAt(row,0).toString());
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
		 data[rowCount][1]=rs.getString("CustomerName");
		 data[rowCount][2]=rs.getString("CustomerAddress");
		 data[rowCount][3]=rs.getString("CustomerEmail");
		 data[rowCount][4]=rs.getString("CustomerPhno");
		 data[rowCount][5]=rs.getDate("Date");
		 data[rowCount][6]=rs.getTime("Time");
		 rowCount ++;
		 }
		 }catch(Exception e){
		 e.printStackTrace();
		 }
		 String [] colNames ={"SrNo","CustomerName","CustomerAddress","CustomerEmail","CustomerPhno","Date","Time"};
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
	   
	   tblCustomer.setModel(dtm);
	   }
	 public void loadData(){
    	 try{
    		 String Query="select * from customer where SrNo=?";
    	     PreparedStatement ps=con.prepareStatement(Query);
    	     ps.setInt(1,Srno);
    	     ResultSet rs=ps.executeQuery();
    	     if (rs.next()){
    	     txtSrno.setText(rs.getString("SrNo"));
    	     txtName.setText(rs.getString("CustomerName"));
    	     txtAddr.setText(rs.getString("CustomerAddress"));
    	     txtEmail.setText(rs.getString("CustomerEmail"));
    	     txtPhno.setText (rs.getString("CustomerPhno"));
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
			txtName.setText("");
            txtPhno.setText("");
            txtAddr.setText("");
            txtEmail.setText("");
	 }
}
