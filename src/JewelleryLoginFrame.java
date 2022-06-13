import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JPasswordField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JButton;

public class JewelleryLoginFrame extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsername;
	private JPasswordField txtPassword;
	
	private Image img_username=new ImageIcon(JewelleryLoginFrame.class.getResource("res/ad1.png")).getImage().getScaledInstance(35, 35, Image.SCALE_SMOOTH);
	private Image img_password=new ImageIcon(JewelleryLoginFrame.class.getResource("res/loc3.png")).getImage().getScaledInstance(32, 30, Image.SCALE_SMOOTH);
	private Image img_log_in=new ImageIcon(JewelleryLoginFrame.class.getResource("res/GK1.png")).getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
	

	
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JewelleryLoginFrame frame = new JewelleryLoginFrame();
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
	public JewelleryLoginFrame() {
		setUndecorated(true);
		setTitle("LoginForm");
		setFont(new Font("Times New Roman", Font.PLAIN, 20));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 933, 566);
		contentPane = new JPanel();
		contentPane.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panelMainBox = new JPanel();
		panelMainBox.setBorder(new LineBorder(new Color(250, 235, 215)));
		panelMainBox.setOpaque(false);
		panelMainBox.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		panelMainBox.setBounds(287, 132, 322, 214);
		contentPane.add(panelMainBox);
		panelMainBox.setLayout(null);
		
		JPanel panelUserName = new JPanel();
		panelUserName.setBorder(new LineBorder(new Color(250, 235, 215)));
		panelUserName.setOpaque(false);
		panelUserName.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		panelUserName.setBounds(6, 6, 310, 49);
		panelMainBox.add(panelUserName);
		panelUserName.setLayout(null);
		
		txtUsername = new JTextField();
		txtUsername.setForeground(new Color(0, 0, 255));
		txtUsername.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				if(txtUsername.getText().contentEquals("Username")) {
					txtUsername.setText("");
				}
				else {
					txtUsername.selectAll();
				}
			}
			@Override
			public void focusLost(FocusEvent arg0) {
				if(txtUsername.getText().equals(""))
					txtUsername.setText("Username");
			}
		});
		txtUsername.setBorder(new LineBorder(new Color(250, 235, 215)));
		txtUsername.setOpaque(false);
		txtUsername.setHorizontalAlignment(SwingConstants.CENTER);
		txtUsername.setText("Username");
		txtUsername.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtUsername.setBounds(8, 13, 240, 26);
		panelUserName.add(txtUsername);
		txtUsername.setColumns(10);
		
		JLabel lblIconUsername = new JLabel("");
		lblIconUsername.setBorder(new LineBorder(new Color(250, 235, 215)));
		lblIconUsername.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblIconUsername.setHorizontalTextPosition(SwingConstants.CENTER);
		lblIconUsername.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconUsername.setBounds(254, 4, 50, 42);
		lblIconUsername.setIcon(new ImageIcon(img_username));
		panelUserName.add(lblIconUsername);
		
		JPanel panelPassword = new JPanel();
		panelPassword.setBorder(new LineBorder(new Color(250, 235, 215)));
		panelPassword.setOpaque(false);
		panelPassword.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		panelPassword.setBounds(6, 58, 310, 49);
		panelMainBox.add(panelPassword);
		panelPassword.setLayout(null);
		
		JLabel lblIconPassword = new JLabel("");
		lblIconPassword.setBorder(new LineBorder(new Color(250, 235, 215)));
		lblIconPassword.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblIconPassword.setHorizontalTextPosition(SwingConstants.CENTER);
		lblIconPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconPassword.setBounds(254, 4, 50, 42);
		lblIconPassword.setIcon(new ImageIcon(img_password));
		panelPassword.add(lblIconPassword);
		
		txtPassword = new JPasswordField();
		txtPassword.setForeground(new Color(0, 0, 255));
		txtPassword.setEchoChar((char)0);
		txtPassword.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				if(txtPassword.getText().contentEquals("Password")) {
					txtPassword.setEchoChar('●');
					txtPassword.setText("");	
				}
				else {
					txtPassword.selectAll();
				}
			}
			@Override
			public void focusLost(FocusEvent arg0) {
				if(txtPassword.getText().equals("")) {
					txtPassword.setText("Password");
					txtPassword.setEchoChar((char)0);
				}
			}
		});
		txtPassword.setOpaque(false);
		txtPassword.setText("Password");
		txtPassword.setHorizontalAlignment(SwingConstants.CENTER);
		txtPassword.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtPassword.setBorder(new LineBorder(new Color(250, 235, 215)));
		txtPassword.setBounds(8, 12, 240, 26);
		panelPassword.add(txtPassword);
		
		JLabel lblLoginMessage = new JLabel("");
		lblLoginMessage.setForeground(new Color(255, 0, 0));
		lblLoginMessage.setBorder(new LineBorder(new Color(250, 235, 215)));
		lblLoginMessage.setHorizontalAlignment(SwingConstants.CENTER);
		lblLoginMessage.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblLoginMessage.setHorizontalTextPosition(SwingConstants.CENTER);
		lblLoginMessage.setBounds(6, 109, 310, 49);
		panelMainBox.add(lblLoginMessage);
		
		JPanel panelBtnLogin = new JPanel();
		panelBtnLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jewelleryshopmanagement", "root", "shrikant@123");
				Statement stmt=con.createStatement();
				String sql="Select * from users where username='"+txtUsername.getText()+"' and password='"+txtPassword.getText().toString()+"'";
				ResultSet rs=stmt.executeQuery(sql);
				if(rs.next()) {
					lblLoginMessage.setText("");
					JOptionPane.showMessageDialog(null, "Login Successfully.....");
					JewelleryLoginFrame.this.dispose();
					MainPage frm =new MainPage();
					frm.setVisible(true);
				}
				else if(txtUsername.getText().equals("") || txtUsername.getText().equals("username") || 
						txtPassword.getText().equals("") || txtPassword.getText().equals("password")){
						lblLoginMessage.setText("Plase input all requirements!");
				}
				else {
					lblLoginMessage.setText("Username and Password is Invalid");
				con.close();
				}
				}catch(Exception e){  System.out.println("SQL Exception:"+e.getMessage());}
				
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {
				panelBtnLogin.setBackground(new Color(60, 80, 60));
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				panelBtnLogin.setBackground(new Color(105, 105, 105));
			}
			@Override
			public void mousePressed(MouseEvent arg0) {
				panelBtnLogin.setBackground(new Color(60, 80, 60));
			}
			@Override
			public void mouseReleased(MouseEvent arg0) {
				panelBtnLogin.setBackground(new Color(60, 80, 60));
			}
		});
		panelBtnLogin.setBorder(new LineBorder(new Color(250, 235, 215)));
		panelBtnLogin.setOpaque(false);
		panelBtnLogin.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		panelBtnLogin.setBounds(6, 161, 310, 49);
		panelMainBox.add(panelBtnLogin);
		panelBtnLogin.setLayout(null);
		
		JLabel lblIconLogin = new JLabel("");
		lblIconLogin.setBorder(new LineBorder(new Color(250, 235, 215)));
		lblIconLogin.setHorizontalTextPosition(SwingConstants.CENTER);
		lblIconLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconLogin.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblIconLogin.setBounds(3, 4, 70, 42);
		lblIconLogin.setIcon(new ImageIcon(img_log_in));
		panelBtnLogin.add(lblIconLogin);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setForeground(Color.WHITE);
		lblLogin.setBorder(new LineBorder(new Color(250, 235, 215)));
		lblLogin.setHorizontalTextPosition(SwingConstants.CENTER);
		lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogin.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblLogin.setBounds(77, 13, 70, 20);
		panelBtnLogin.add(lblLogin);
		
		JLabel lblCreatenewuser_1 = new JLabel("CreateNewUser");
		lblCreatenewuser_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AddUser ad=new AddUser();
				ad.setVisible(true);
			}
		});
		lblCreatenewuser_1.setHorizontalTextPosition(SwingConstants.CENTER);
		lblCreatenewuser_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblCreatenewuser_1.setForeground(Color.WHITE);
		lblCreatenewuser_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblCreatenewuser_1.setBorder(new LineBorder(new Color(250, 235, 215)));
		lblCreatenewuser_1.setBounds(160, 13, 143, 20);
		panelBtnLogin.add(lblCreatenewuser_1);
		
		JLabel lblx = new JLabel("x");
		lblx.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(JOptionPane.showConfirmDialog(null, "Are you sure you want to close this application?", "Confirmation", JOptionPane.YES_NO_OPTION)==0) {  
					JewelleryLoginFrame.this.dispose();	
					}
				
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {
				lblx.setForeground(Color.RED);
			}
			
			@Override
			public void mouseExited(MouseEvent arg0) {
				lblx.setForeground(Color.WHITE);
			}
			
		});
		lblx.setHorizontalTextPosition(SwingConstants.CENTER);
		lblx.setHorizontalAlignment(SwingConstants.CENTER);
		lblx.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblx.setBorder(new LineBorder(new Color(250, 235, 215)));
		lblx.setBounds(908, 1, 21, 19);
		contentPane.add(lblx);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(JewelleryLoginFrame.class.getResource("/res/MainFrame.jpg")));
		lblNewLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 1, 929, 565);
		contentPane.add(lblNewLabel);
		Toolkit toolkit =getToolkit();
		Dimension size=toolkit.getScreenSize();
		setLocation(size.width/2-getWidth()/2,size.height/2-getHeight()/2);
	}
}
