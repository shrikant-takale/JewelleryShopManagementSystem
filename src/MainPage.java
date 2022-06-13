import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;

public class MainPage extends JDialog {

	private final JPanel contentPanel = new JPanel();
	
	private Shop panelShop;
	private Item panelItem;
	private Customer panelCustomer;
	private Bill panelBill;
	private Employee panelEmployee;
	
	//private Image img_logo=new ImageIcon(MainPage.class.getResource("res/GoldenRing.png")).getImage().getScaledInstance(190, 180, Image.SCALE_SMOOTH);
	private Image img_Shop=new ImageIcon(MainPage.class.getResource("res/COMPONY.jpeg")).getImage().getScaledInstance(80, 50, Image.SCALE_SMOOTH);
	private Image img_Employee=new ImageIcon(MainPage.class.getResource("res/Employee2.jpeg")).getImage().getScaledInstance(80, 50, Image.SCALE_SMOOTH);
	private Image img_Item=new ImageIcon(MainPage.class.getResource("res/ITEM1.jpeg")).getImage().getScaledInstance(80, 50, Image.SCALE_SMOOTH);
	private Image img_Customers=new ImageIcon(MainPage.class.getResource("res/Customer2.jpeg")).getImage().getScaledInstance(80, 50, Image.SCALE_SMOOTH);
	private Image img_Bill=new ImageIcon(MainPage.class.getResource("res/Bill.png")).getImage().getScaledInstance(80, 50, Image.SCALE_SMOOTH);
	private Image img_SingOut=new ImageIcon(MainPage.class.getResource("res/SingOut1.jpeg")).getImage().getScaledInstance(80, 50, Image.SCALE_SMOOTH);

	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			MainPage dialog = new MainPage();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public MainPage() {
		setUndecorated(true);
		getContentPane().setFont(new Font("Times New Roman", Font.PLAIN, 20));
		setFont(new Font("Times New Roman", Font.PLAIN, 20));
		
		setBounds(100, 100, 1250, 566);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			
			panelShop=new Shop();
			panelCustomer=new Customer();
			panelItem=new Item();
			panelEmployee=new Employee();
			panelBill=new Bill();
			
			
			JPanel panelMenu = new JPanel();
			panelMenu.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			panelMenu.setBorder(new LineBorder(new Color(0, 128, 128), 2));
			panelMenu.setBackground(new Color(47, 79, 79));
			panelMenu.setBounds(0, 0, 247, 566);
			contentPanel.add(panelMenu);
			panelMenu.setLayout(null);
			
			JPanel paneShop = new JPanel();
			paneShop.addMouseListener(new PanelButtonMouseAdapter(paneShop) {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					menuClicked(panelShop);
				}
			});
			paneShop.setBorder(new LineBorder(new Color(0, 0, 0)));
			paneShop.setBackground(new Color(47, 79, 79));
			paneShop.setBounds(2, 202, 244, 51);
			panelMenu.add(paneShop);
			paneShop.setLayout(null);
				
			JLabel lblNewLabel = new JLabel("Shop");
			lblNewLabel.setForeground(Color.WHITE);
			lblNewLabel.setHorizontalTextPosition(SwingConstants.CENTER);
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			lblNewLabel.setBounds(114, 16, 59, 20);
			paneShop.add(lblNewLabel);
			
			JLabel lblIconShop = new JLabel("");
			lblIconShop.setHorizontalAlignment(SwingConstants.CENTER);
			lblIconShop.setBounds(7, 0, 80, 50);
			lblIconShop.setIcon(new ImageIcon(img_Shop));
			paneShop.add(lblIconShop);
				
			
			
			JPanel paneItem = new JPanel();
			paneItem.addMouseListener(new PanelButtonMouseAdapter(paneItem) {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					menuClicked(panelItem);
				}
			});
			paneItem.setBorder(new LineBorder(new Color(0, 0, 0)));
			paneItem.setBackground(new Color(47, 79, 79));
			paneItem.setBounds(1, 265, 244, 51);
			panelMenu.add(paneItem);
			paneItem.setLayout(null);
				
			JLabel lblItem = new JLabel("Item");
			lblItem.setForeground(Color.WHITE);
			lblItem.setHorizontalTextPosition(SwingConstants.CENTER);
			lblItem.setHorizontalAlignment(SwingConstants.CENTER);
			lblItem.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			lblItem.setBounds(117, 16, 56, 20);
			paneItem.add(lblItem);
			
			JLabel lblIconItem = new JLabel("");
			lblIconItem.setHorizontalAlignment(SwingConstants.CENTER);
			lblIconItem.setBounds(7, 0, 80, 50);
			lblIconItem.setIcon(new ImageIcon(img_Item));
			paneItem.add(lblIconItem);
				
			
			
			JPanel paneCutsomer = new JPanel();
			paneCutsomer.addMouseListener(new PanelButtonMouseAdapter(paneCutsomer) {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					menuClicked(panelCustomer);
				}
			});
			paneCutsomer.setBorder(new LineBorder(new Color(0, 0, 0)));
			paneCutsomer.setBackground(new Color(47, 79, 79));
			paneCutsomer.setBounds(1, 389, 244, 51);
			panelMenu.add(paneCutsomer);
			paneCutsomer.setLayout(null);
				
			JLabel lblCustomer = new JLabel("Customer");
			lblCustomer.setForeground(Color.WHITE);
			lblCustomer.setHorizontalTextPosition(SwingConstants.CENTER);
			lblCustomer.setHorizontalAlignment(SwingConstants.CENTER);
			lblCustomer.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			lblCustomer.setBounds(99, 16, 92, 20);
			paneCutsomer.add(lblCustomer);
			
			JLabel lblIconCustomer = new JLabel("");
			lblIconCustomer.setBounds(7, 0, 80, 50);
			paneCutsomer.add(lblIconCustomer);
			lblIconCustomer.setHorizontalAlignment(SwingConstants.CENTER);
			lblIconCustomer.setIcon(new ImageIcon(img_Customers));
				
			
			
			JPanel paneBill = new JPanel();
			paneBill.addMouseListener(new PanelButtonMouseAdapter(paneBill) {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					menuClicked(panelBill);
				}
			});
			paneBill.setBorder(new LineBorder(new Color(0, 0, 0)));
			paneBill.setBackground(new Color(47, 79, 79));
			paneBill.setBounds(1, 449, 244, 51);
			panelMenu.add(paneBill);
			paneBill.setLayout(null);
				
			JLabel lblBill = new JLabel("Bill");
			lblBill.setForeground(Color.WHITE);
			lblBill.setHorizontalTextPosition(SwingConstants.CENTER);
			lblBill.setHorizontalAlignment(SwingConstants.CENTER);
			lblBill.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			lblBill.setBounds(113, 16, 64, 20);
			paneBill.add(lblBill);
			
			JLabel lblIconBill = new JLabel("");
			lblIconBill.setHorizontalAlignment(SwingConstants.CENTER);
			lblIconBill.setBounds(7, 0, 80, 50);
			lblIconBill.setIcon(new ImageIcon(img_Bill));
			paneBill.add(lblIconBill);
				
			
			
			JPanel paneSignOut = new JPanel();
			paneSignOut.addMouseListener(new PanelButtonMouseAdapter(paneSignOut) {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					if(JOptionPane.showConfirmDialog(null, "Are you want to sing out?")==0) {
						JewelleryLoginFrame frmLogin=new JewelleryLoginFrame();
						frmLogin.setVisible(true);
						MainPage.this.dispose();
					}
				}
			});
			paneSignOut.setBorder(new LineBorder(new Color(0, 0, 0)));
			paneSignOut.setBackground(new Color(47, 79, 79));
			paneSignOut.setBounds(1, 508, 244, 51);
			panelMenu.add(paneSignOut);
			paneSignOut.setLayout(null);
				
			JLabel lblSignout = new JLabel("SignOut");
			lblSignout.setForeground(Color.WHITE);
			lblSignout.setHorizontalTextPosition(SwingConstants.CENTER);
			lblSignout.setHorizontalAlignment(SwingConstants.CENTER);
			lblSignout.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			lblSignout.setBounds(112, 16, 82, 20);
			paneSignOut.add(lblSignout);
			
			JLabel lblIconSignOut = new JLabel("");
			lblIconSignOut.setHorizontalAlignment(SwingConstants.CENTER);
			lblIconSignOut.setBounds(8, 1, 80, 50);
			lblIconSignOut.setIcon(new ImageIcon( img_SingOut));
			paneSignOut.add(lblIconSignOut);
			
			JPanel paneEmployee = new JPanel();
			paneEmployee.addMouseListener(new PanelButtonMouseAdapter(paneEmployee) {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					menuClicked(panelEmployee);
				}
			});
			paneEmployee.setLayout(null);
			paneEmployee.setBorder(new LineBorder(new Color(0, 0, 0)));
			paneEmployee.setBackground(new Color(47, 79, 79));
			paneEmployee.setBounds(2, 326, 244, 51);
			panelMenu.add(paneEmployee);
			
			JLabel lblEmployee = new JLabel("Employee");
			lblEmployee.setHorizontalTextPosition(SwingConstants.CENTER);
			lblEmployee.setHorizontalAlignment(SwingConstants.CENTER);
			lblEmployee.setForeground(Color.WHITE);
			lblEmployee.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			lblEmployee.setBounds(99, 16, 92, 20);
			paneEmployee.add(lblEmployee);
			
			JLabel lblIconEmployee = new JLabel("");
			lblIconEmployee.setHorizontalAlignment(SwingConstants.CENTER);
			lblIconEmployee.setBounds(7, 0, 80, 50);
			lblIconEmployee.setIcon(new ImageIcon(img_Employee));
			paneEmployee.add(lblIconEmployee);
				
			
		}	
		
			JPanel paneMainContent = new JPanel();
			paneMainContent.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			paneMainContent.setBorder(new LineBorder(new Color(0, 0, 0), 0));
			paneMainContent.setBounds(249, 16, 980, 550);
			contentPanel.add(paneMainContent);
			paneMainContent.setLayout(new BoxLayout(paneMainContent, BoxLayout.X_AXIS));
		    
			Toolkit toolkit =getToolkit();
			Dimension size=toolkit.getScreenSize();
			setLocation(size.width/2-getWidth()/2,size.height/2-getHeight()/2);
	
			paneMainContent.add(panelShop);
			paneMainContent.add(panelItem);
			paneMainContent.add(panelCustomer);
			paneMainContent.add(panelBill);
			paneMainContent.add(panelEmployee);
			
			menuClicked(panelShop);
			
			JLabel lblExit = new JLabel("x");
			lblExit.setHorizontalTextPosition(SwingConstants.CENTER);
			lblExit.setFont(new Font("Times New Roman", Font.PLAIN, 15));
			lblExit.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					if(JOptionPane.showConfirmDialog(null, "Are you sure you want to close this application?", "Confirmation", JOptionPane.YES_NO_OPTION)==0) {  
						MainPage.this.dispose();
						}
				}
				@Override
				public void mouseEntered(MouseEvent arg0) {
					lblExit.setForeground(Color.RED);
				}
				@Override
				public void mouseExited(MouseEvent arg0) {
					lblExit.setForeground(Color.WHITE);
				}
			});
			lblExit.setHorizontalAlignment(SwingConstants.CENTER);
			lblExit.setBounds(1231, 0, 19, 18);
			contentPanel.add(lblExit);
	
	}
    
	
	public void menuClicked(JPanel panel) {
		panelShop.setVisible(false);
		panelItem.setVisible(false);
		panelCustomer.setVisible(false);
		panelBill.setVisible(false);
		panelEmployee.setVisible(false);
		
		panel.setVisible(true);
	}
	
	
	
	private class PanelButtonMouseAdapter extends MouseAdapter
	{
		JPanel panel;
		public  PanelButtonMouseAdapter(JPanel panel) {
			this.panel=panel;
		}
		@Override
		public void mouseEntered(MouseEvent e) {
			
			panel.setBackground(new Color(0, 139, 139));
			
		}
		@Override
		public void mouseExited(MouseEvent e) {
		
			panel.setBackground(new Color(47, 79, 79));  
		}
		@Override
		public void mousePressed(MouseEvent e) {
			
			panel.setBackground(new Color(0, 0, 205));
		}
		@Override
		public void mouseReleased(MouseEvent e) {
		
			panel.setBackground(new Color(0, 139, 139));
		}
	}
}
