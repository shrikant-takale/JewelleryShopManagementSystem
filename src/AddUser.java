

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JPasswordField;



public class AddUser extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField txtname;
	private JTextField txtmobile;
	private JTextField txtemail;
	private JPasswordField pass;
	JButton btnAdd,btnClose;
	private JPasswordField cpass;
	private JTextField txtuser;
	JComboBox cb;
	//Regular expression to accept valid email id
    String regex = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$";
    //Creating a pattern object
    Pattern pattern = Pattern.compile(regex);
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddUser frame = new AddUser();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AddUser() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 411);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Add New User");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(158, 11, 139, 14);
		contentPane.add(lblNewLabel);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 36, 480, 2);
		contentPane.add(separator);
		
		JLabel lblName = new JLabel("Full Name ");
		lblName.setBounds(10, 60, 63, 14);
		contentPane.add(lblName);
		
		txtname = new JTextField();
		txtname.setBounds(132, 57, 165, 20);
		contentPane.add(txtname);
		txtname.setColumns(10);
		
		JLabel lblMobileNo = new JLabel("Mobile No");
		lblMobileNo.setBounds(10, 128, 63, 14);
		contentPane.add(lblMobileNo);
		
		txtmobile = new JTextField();
		txtmobile.setBounds(132, 125, 165, 20);
		contentPane.add(txtmobile);
		txtmobile.setColumns(10);
		txtmobile.addKeyListener(new KeyAdapter() {
			
			public void keyTyped(KeyEvent arg) {
				char c=arg.getKeyChar();
				if(!(Character.isDigit(c)))
				{
					arg.consume();
					//System.out.print("key");
				}
			}
		});		
		JLabel lblUserRole = new JLabel("User Role");
		lblUserRole.setBounds(10, 207, 63, 14);
		contentPane.add(lblUserRole);
		
		 cb = new JComboBox();
		cb.setModel(new DefaultComboBoxModel(new String[] {"Select", "Admin", "User"}));
		cb.setBounds(132, 204, 63, 20);
		contentPane.add(cb);
		
		btnAdd = new JButton("Add");
		btnAdd.setIcon(new ImageIcon(AddUser.class.getResource("/res2/Add new.png")));
		btnAdd.setBounds(51, 357, 89, 23);
		contentPane.add(btnAdd);
		
		btnClose = new JButton("Close");
		btnClose.setIcon(new ImageIcon(AddUser.class.getResource("/res2/Exit application.png")));
		btnClose.setBounds(227, 357, 103, 23);
		contentPane.add(btnClose);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(10, 169, 63, 14);
		contentPane.add(lblEmail);
		
		txtemail = new JTextField();
		txtemail.setBounds(131, 166, 166, 20);
		contentPane.add(txtemail);
		txtemail.setColumns(10);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(-12, 324, 512, 10);
		contentPane.add(separator_1);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(10, 247, 63, 14);
		contentPane.add(lblPassword);
		
		pass = new JPasswordField();
		pass.setBounds(132, 244, 165, 20);
		contentPane.add(pass);
		
		JLabel lblConfirmPassword = new JLabel("Confirm Password");
		lblConfirmPassword.setBounds(10, 285, 112, 14);
		contentPane.add(lblConfirmPassword);
		
		cpass = new JPasswordField();
		cpass.setBounds(132, 282, 165, 20);
		contentPane.add(cpass);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(10, 95, 63, 14);
		contentPane.add(lblUsername);
		
		txtuser = new JTextField();
		txtuser.setBounds(132, 88, 165, 20);
		contentPane.add(txtuser);
		txtuser.setColumns(10);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(AddUser.class.getResource("/res2/all page background image.png")));
		label.setBounds(0, 0, 500, 411);
		contentPane.add(label);
		
		//add listener
		btnAdd.addActionListener(this);
		btnClose.addActionListener(this);
	}

	public void actionPerformed(ActionEvent arg) {
		// TODO Auto-generated method stub
		String id,name,mobile,username,password,cpassword,email,role;
		name=txtname.getText().toString();
		mobile=txtmobile.getText().toString();
		username=txtuser.getText().toString();
		password=pass.getText().toString();
		email=txtemail.getText().toString();
		role=cb.getSelectedItem().toString();
		cpassword=cpass.getText().toString();
	    Matcher matcher = pattern.matcher(email);

		if(arg.getSource()==btnAdd)
		{
			if(name.length()!=0 && mobile.length()==10 && username.length()!=0 && password.length()!=0 && 
					email.length()!=0 && cb.getSelectedIndex()!=0 &&cpassword.length()!=0&& password.equals(cpassword) && matcher.matches())
			{
			try {
				Connection conn = DbConnection.getConnection();
				if(conn!=null)
				{
					int newUserPk = getNewUserPk(conn);
					String sqlStmt="insert into users(user_pk,username,password,user_role,fullname,email,mobile) values(?,?,?,?,?,?,?)";
					PreparedStatement pStmt = conn.prepareStatement(sqlStmt);
					pStmt.setInt(1,newUserPk);

					pStmt.setString(2,username);
					pStmt.setString(3,password );
					pStmt.setString(4, role);
					pStmt.setString(5,name );
					pStmt.setString(6,email );
					pStmt.setString(7,mobile );
				 	pStmt.executeUpdate();
				    JOptionPane.showMessageDialog(null,"Successfully Saved");
				    empty();
				}
				}catch(Exception ex){
				ex.printStackTrace();
			       JOptionPane.showMessageDialog(null,"connection error"+ex);
				}
			}else
			{
			       JOptionPane.showMessageDialog(null,"Please enter all fields");

			}
			}

		if(arg.getSource()==btnClose)
		{
			setVisible(false);
		}
	}
	public void empty()
	 {
		
			txtname.setText("");
			txtmobile.setText("");
			pass.setText("");
			cpass.setText("");
			txtuser.setText("");
			txtemail.setText("");
			cb.setSelectedIndex(0);;

	 }
	private static int getNewUserPk(Connection conn) {
		// TODO Auto-generated method stub
		 String sqlStmt = "SELECT MAX(user_pk) FROM users";
	        int returnVal = 1; // default to 1 if not found

	        try {
	        	PreparedStatement pStmt = conn.prepareStatement(sqlStmt);
	            ResultSet rs = pStmt.executeQuery();
	            if (rs.next()) {
	            returnVal = rs.getInt(1) + 1;
	        }}
	        catch (Exception e) {
	           // throw e;
	            System.out.println(e);
	        }
			return returnVal;
		}
	}

