package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Point;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import functions.AddUser;
import functions.FrameDragListener;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextPane;
import java.awt.TextArea;
import java.awt.TextField;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import java.awt.ScrollPane;



public class Menu extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;

	//private final ScrollPane scrollPane = new ScrollPane();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
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
	public Menu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		setContentPane(contentPane);
		//setUndecorated(true);
		//Color back= new Color(0,0,0,0);
		//setBackground(back);
		
		
		JLabel lblChar = new JLabel("");
		JLabel lblListUsers = new JLabel("List Users");
		
				
		//setIconImage (new ImageIcon(getClass().getResource("/UserAdmin/src/im/SakuraUsers.png")).getImage());
		lblChar.setSize(400, 400);
		ImageIcon iconChar = new ImageIcon(getClass().getResource("/images/SakuraUsers.png"));
		Image imgChar = iconChar.getImage() ;  
		Image newimgChar = imgChar.getScaledInstance( lblChar.getWidth(), lblChar.getHeight(),  Image.SCALE_SMOOTH ) ;  
		iconChar = new ImageIcon( newimgChar );
		lblChar.setIcon(iconChar);
		contentPane.add(lblChar);
		//contentPane.setLayout(gl_contentPane);
		
		
		 FrameDragListener frameDragListener = new FrameDragListener(this);
         addMouseListener(frameDragListener);
         addMouseMotionListener(frameDragListener);
         
 		TextField txtUser = new TextField();
		
 		JTextPane textPane = new JTextPane();	
		
		
		
		lblListUsers.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String[][] userPass = new String[100][2];
				functions.List list = new functions.List();
				textPane.setText("asd");
				userPass = list.listUserPass();
				for(int i=0;i<userPass.length;i++) {
					if(userPass[i][0]==null & userPass[i][1]==null & userPass[i][2]==null& userPass[i][3]==null) {
						break;
					}
					for(int o=0;o<4;o++) {
						System.out.println(userPass[i][o]);
					}
				}
			}
		});
		
		JLabel lblAddUser = new JLabel("Add User");
		lblAddUser.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//AddUser add = new AddUser();
				//add.add(txt, password);
			}
		});
		
		Object columnNames[] = { "Column One", "Column Two"};
		
		Object rowData[][] = { { "Row1-Column1", "Row1-Column2"},
                { "Row2-Column1", "Row2-Column2"} };
		

		
		JTable table = new JTable(rowData, columnNames);
				
		table = new JTable(20,2);
		
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		table.setCellSelectionEnabled(true);
		table.setColumnSelectionAllowed(true);
		
		//JScrollPane scrollPane = new JScrollPane();
		
		
		
		JScrollPane scrollPane = new JScrollPane(table);
		
		table.setFillsViewportHeight(true);
		
		scrollPane.setViewportView(table);
		
		scrollPane.add(table.getTableHeader());
		
		getContentPane().add(scrollPane);
		
		getContentPane().add(scrollPane);
		
		
		  
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
	
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addComponent(lblListUsers, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)
							.addGap(45)
							.addComponent(textPane, GroupLayout.PREFERRED_SIZE, 222, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED))
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addComponent(table, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(98)))
					.addComponent(lblChar)
					.addPreferredGap(ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblAddUser)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtUser, GroupLayout.PREFERRED_SIZE, 440, GroupLayout.PREFERRED_SIZE))))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(txtUser, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(lblAddUser, GroupLayout.PREFERRED_SIZE, 254, GroupLayout.PREFERRED_SIZE)
					.addGap(224))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblChar, GroupLayout.DEFAULT_SIZE, 739, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(26)
					.addComponent(table, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 126, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(textPane, GroupLayout.PREFERRED_SIZE, 236, GroupLayout.PREFERRED_SIZE)
							.addGap(23))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblListUsers, GroupLayout.PREFERRED_SIZE, 254, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addGap(239))
		);
		
		
		contentPane.setLayout(gl_contentPane);
	}
}
