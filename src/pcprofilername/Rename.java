package pcprofilername;


import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.net.InetAddress;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Point;
import java.awt.BorderLayout;
import javax.swing.JTextField;

public class Rename extends JFrame implements KeyListener{
	private static JTextField textField;
	private static JLabel Newname;
	private static JLabel overide;
		Rename(){
			JFrame nameframe = new JFrame("PC/Profile rename tool");
			nameframe.getContentPane().setBackground(new Color(0, 0, 139));
			nameframe.setAlwaysOnTop(true);
			nameframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			nameframe.setPreferredSize(new Dimension(400, 400));
			String[] sitelist = { "<Select Your Site>" };
			String[] siteprofile = { "NA"};
			String[] sitepwlist = { "NA" };
			String[] desklist = { "<Select Your Job Title>"};
			
			Map<String, String> sitedic = new HashMap<String, String>();
			for(int i=0;i<sitelist.length;i++) {
				sitedic.put(sitelist[i], siteprofile[i]);
			}
			Map<String, String> sitedicpw = new HashMap<String, String>();
			for(int i=0;i<sitelist.length;i++) {
				sitedicpw.put(sitelist[i], sitepwlist[i]);
			}
			Map<String, String> deskdic = new HashMap<String, String>();
			String hostname = "Unknown";
			ImageIcon logoic = new ImageIcon("ToshibaAppMenuLogo.png");
					nameframe.getContentPane().setLayout(new BorderLayout(0, 0));
					
					JPanel panel = new JPanel() {

	                    @Override
	                    public void paintComponent(Graphics g) {
	                        super.paintComponent(g);

	                        Point point1 = new Point(10, 10);
	                        Point point2 = new Point(
	                                getWidth() - 10, 
	                                getHeight() - 10);
	                        final GradientPaint gp = new GradientPaint(
	                                point1, Color.BLUE,
	                                point2, new Color(75,75,75),
	                                true);

	                        // we need a Graphics2D to use GradientPaint.
	                        // If this is Swing, it should be one..
	                        final Graphics2D g2 = (Graphics2D) g;
	                        g2.setPaint(gp);
	                        g.fillRect(0, 0, getWidth(), getHeight());
	                    }
	                };
	                
	                panel.setBackground(new Color(0, 0, 139));
					nameframe.getContentPane().add(panel);
									GridBagLayout gbl_panel = new GridBagLayout();
									gbl_panel.columnWidths = new int[] {30, 143, 143, 30};
									gbl_panel.rowHeights = new int[] {0, 0, 87, 30, 30, 30, 0};
									gbl_panel.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0};
									gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
									panel.setLayout(gbl_panel);
										
										JPanel LogoPNG = new JPanel();
										FlowLayout flowLayout = (FlowLayout) LogoPNG.getLayout();
										flowLayout.setAlignOnBaseline(true);
										GridBagConstraints gbc_LogoPNG = new GridBagConstraints();
										gbc_LogoPNG.gridwidth = 2;
										gbc_LogoPNG.insets = new Insets(0, 0, 5, 5);
										gbc_LogoPNG.gridx = 1;
										gbc_LogoPNG.gridy = 2;
										LogoPNG.setOpaque(false);
										panel.add(LogoPNG, gbc_LogoPNG);
										URL file = Rename.class.getClassLoader().getResource("ShivitoMGOnew.png");
										System.out.println(file.toString());
										JLabel logo = new JLabel(new ImageIcon(file));
										LogoPNG.add(logo);
										
								
										JComboBox<Object> site = new JComboBox<Object>(sitelist);
										GridBagConstraints gbc_site = new GridBagConstraints();
										gbc_site.fill = GridBagConstraints.BOTH;
										gbc_site.insets = new Insets(0, 0, 5, 5);
										gbc_site.gridx = 1;
										gbc_site.gridy = 3;
										panel.add(site, gbc_site);
										site.setPreferredSize(new Dimension(165, 30));
												
										
										JComboBox<Object> desk = new JComboBox<Object>(desklist);
										GridBagConstraints gbc_desk = new GridBagConstraints();
										gbc_desk.fill = GridBagConstraints.BOTH;
										gbc_desk.anchor = GridBagConstraints.WEST;
										gbc_desk.insets = new Insets(0, 0, 5, 5);
										gbc_desk.gridx = 2;
										gbc_desk.gridy = 3;
										panel.add(desk, gbc_desk);
										desk.setPreferredSize(new Dimension(165, 30));
										
										
											// JComboBox listeners
											
										JLabel lblname = new JLabel("New Computer Name: ");
										GridBagConstraints gbc_lblname = new GridBagConstraints();
										gbc_lblname.anchor = GridBagConstraints.EAST;
										gbc_lblname.insets = new Insets(0, 0, 5, 5);
										gbc_lblname.gridx = 1;
										gbc_lblname.gridy = 4;
										panel.add(lblname, gbc_lblname);
										lblname.setForeground(new Color(153, 153, 153));
										Newname = new JLabel(hostname);
										GridBagConstraints gbc_Newname = new GridBagConstraints();
										gbc_Newname.anchor = GridBagConstraints.WEST;
										gbc_Newname.insets = new Insets(0, 0, 5, 5);
										gbc_Newname.gridx = 2;
										gbc_Newname.gridy = 4;
										panel.add(Newname, gbc_Newname);
										Newname.setForeground(new Color(204, 204, 204));
										Newname.setPreferredSize(new Dimension(150, 30));
										
										
										JButton btndone = new JButton("Done");
										GridBagConstraints gbc_btndone = new GridBagConstraints();
										gbc_btndone.fill = GridBagConstraints.BOTH;
										gbc_btndone.insets = new Insets(0, 0, 5, 5);
										gbc_btndone.anchor = GridBagConstraints.NORTH;
										gbc_btndone.gridwidth = 2;
										gbc_btndone.gridx = 1;
										gbc_btndone.gridy = 5;
									
									panel.add(btndone, gbc_btndone);
									btndone.setForeground(new Color(153, 153, 153));
									btndone.setBackground(new Color(0, 0, 0));
									btndone.setPreferredSize(new Dimension(275, 30));
									
									overide = new JLabel("Overide Name:");
									overide.setPreferredSize(new Dimension(150, 30));
									overide.setForeground(new Color(204, 204, 204));
									GridBagConstraints gbc_overide = new GridBagConstraints();
									gbc_overide.insets = new Insets(0, 0, 0, 5);
									gbc_overide.anchor = GridBagConstraints.EAST;
									gbc_overide.gridx = 1;
									gbc_overide.gridy = 6;
									panel.add(overide, gbc_overide);
									overide.setVisible(false);
									
									textField = new JTextField();
									GridBagConstraints gbc_textField = new GridBagConstraints();
									gbc_textField.insets = new Insets(0, 0, 0, 5);
									gbc_textField.fill = GridBagConstraints.HORIZONTAL;
									gbc_textField.gridx = 2;
									gbc_textField.gridy = 6;
									panel.add(textField, gbc_textField);
									textField.setColumns(10);
									textField.setVisible(false);
									
									
									// button listener
									btndone.addActionListener(new ActionListener()
		    {
										@Override
										public void actionPerformed(ActionEvent l) {
											int siteindex = site.getSelectedIndex();
											int deskindex = desk.getSelectedIndex();
											if (siteindex == 0 || deskindex == 0 ) {
												JOptionPane optionPane = new JOptionPane("Must set Site and Title!");
												JDialog dialog = optionPane.createDialog("Title");
												dialog.setAlwaysOnTop(true);
												dialog.setVisible(true);
												
											}else {
												System.out.println(Newname.getText());
												try {
													exicutcommands(Newname.getText(),sitedic.get(site.getSelectedItem().toString()),sitedicpw.get(site.getSelectedItem().toString()));
												} catch (IOException e) {
													// TODO Auto-generated catch block
													e.printStackTrace();
												}
											}
										}
									    });
			nameframe.pack();
			nameframe.setLocationRelativeTo(null);
			
			// JComboBox method
		    ItemListener itemListener = new ItemListener() {
		        public void itemStateChanged(ItemEvent itemEvent) {
		        	String hostname = "Unknown";
		        	String[] h1;
		        	try
		    		{
		    		    InetAddress addr;
		    		    addr = InetAddress.getLocalHost();
		    		    hostname = execCmd("wmic bios get serialnumber");
		    		    h1 = hostname.split("\r\n");
		    		    hostname = h1[1].substring(0,7);
		    		    System.out.println(hostname);
		    		    hostname = hostname.replace(" ", "").replace("\n", "").replace("\r", "");
		    		    int siteindex = site.getSelectedIndex();
						int deskindex = desk.getSelectedIndex();
		    		    if (siteindex == 0 && deskindex != 0) {
		    		    	Newname.setText(hostname+"-"+desk.getSelectedItem().toString());
						}else if (deskindex == 0 && siteindex != 0) {
							Newname.setText(site.getSelectedItem().toString()+"-"+hostname);
						}else if (deskindex != 0 && siteindex != 0) {
							Newname.setText(site.getSelectedItem().toString()+"-"+hostname+"-"+desk.getSelectedItem().toString());
						}else if (deskindex == 0 && siteindex == 0) {
							Newname.setText(hostname.substring(0,7));
						}
		    		    if (textField.isValid() == true) {
		    		    	textField.setText(Newname.getText());
		    		    }
		    		    System.out.println(sitedic.get(site.getSelectedItem().toString()));
		    		    System.out.println(sitedicpw.get(site.getSelectedItem().toString()));
		    		    System.out.println(site.getSelectedItem().toString()+"-"+hostname+"-"+desk.getSelectedItem().toString());
		    		   
		    		    
		    		}
		    		catch (UnknownHostException ex)
		    		{
		    		    System.out.println("Hostname can not be resolved");
		    		} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		        	
		        }
		      };
		      
		      desk.addItemListener(itemListener);
		      site.addItemListener(itemListener);
			
			nameframe.setVisible(true);
	//key listener	
			site.addKeyListener(this);
			textField.addKeyListener(this);
			
			;
		}
		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
			String e1 =String.valueOf(e.getKeyChar());
			if (e.getKeyCode() == KeyEvent.VK_CONTROL) {
				textField.setVisible(true);
				overide.setVisible(true);
			}
			Nameoveride(textField.getText());
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			String e1 =String.valueOf(e.getKeyChar());
			if (e.getKeyCode() == KeyEvent.VK_CONTROL) {
				textField.setVisible(true);
				overide.setVisible(true);
			}
			Nameoveride(textField.getText());
		}

		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
			String e1 =String.valueOf(e.getKeyChar());
			if (e.getKeyCode() == KeyEvent.VK_CONTROL) {
				textField.setVisible(true);
			}
			Nameoveride(textField.getText());
			overide.setVisible(true);
		}
	
	public static void main(String[] args) {
		new Rename();
		
		
	}

	public static String execCmd(String cmd) throws java.io.IOException {
	    @SuppressWarnings("resource")
		java.util.Scanner s = new java.util.Scanner(Runtime.getRuntime().exec(cmd).getInputStream()).useDelimiter("\\A");
	    return s.hasNext() ? s.next() : "";
	}
	
	public static void Nameoveride(String cmd) {
		Rename.Newname.setText(cmd);
		
	}
	
	public static void exicutcommands(String computername, String profilename, String password) throws IOException {
		System.out.println(computername+" "+profilename);
		InetAddress addr;
		addr = InetAddress.getLocalHost();
		String hostname = addr.getHostName();
		String username = System.getProperty("user.name");
		String profilecommand = "wmic useraccount where name='"+username+"' rename "+profilename;
		String command = "wmic computersystem where caption='"+ hostname +"' rename "+ "'"+ computername+"'";
		String newpw = "net user "+username+" "+ password;
		System.out.println(command+"\n"+profilecommand);
		execCmd(newpw);
		execCmd(command);
		execCmd(profilecommand);
		JOptionPane optionPane = new JOptionPane("After reboot please use this Password: ("+ password +") to login and let Carbonite install. Then your good to go. Thanks!");
		JDialog dialog = optionPane.createDialog("Reboot required");
		dialog.setAlwaysOnTop(true);
		dialog.setVisible(true);
		execCmd("shutdown /r /f /t 00");
	}
}
