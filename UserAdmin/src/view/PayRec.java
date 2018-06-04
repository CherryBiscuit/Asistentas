package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import java.awt.Color;
import java.awt.Dimension;

import com.sun.javafx.tk.Toolkit;
import com.sun.xml.internal.ws.api.Component;

import functions.CRQ;
import functions.TableColumnAdjuster;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PayRec extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PayRec frame = new PayRec();
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
	public PayRec() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		/**
		 * Set screen variabels
		 */		
		
		GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
		int width = gd.getDisplayMode().getWidth();
		int height = gd.getDisplayMode().getHeight();
		int width2 = width/2 + width/4;
		
		
		setBounds(width/6, height/4, width2, height/2);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		setContentPane(contentPane);
		
		//Make background invisible
		/*
		setUndecorated(true);
		Color back= new Color(0,0,0,0);
		setBackground(back);
		*/
		
		/**
		 * Create the table
		 */
		
		/* Create objects to fill the table*/
		Object columnNames[] = {"ID","Date","CRQ","Status","Observations","PID"};
		
		//Object rowData[][] = { { "Row1-Column1", "Row1-Column2","Row1-Column3","Row1-Column4","Row1-Column5"}};
		
		CRQ crq = new CRQ();
		
		Object rowData[][] = crq.list(); 
		
		DefaultTableModel model = new DefaultTableModel(rowData,columnNames);
		
		JTable table = new JTable(model);
		
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		TableColumnAdjuster tca = new TableColumnAdjuster(table);
		tca.adjustColumns();
		
		
		table.setColumnSelectionAllowed(true);
		
		table.getColumnModel().getColumn(0).setWidth(0);
		table.getColumnModel().getColumn(0).setMinWidth(0);
		table.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(0);
		table.getTableHeader().getColumnModel().getColumn(0).setMinWidth(0);
		
		table.setAutoResizeMode(5);
		
		
		JScrollPane scrollPane = new JScrollPane(table);
		
		//scrollPane.setSize(table.getWidth(), height);
		Dimension dim = new Dimension();
		dim.setSize(table.getPreferredSize().getWidth()+20, table.getPreferredSize().getHeight());
		scrollPane.setPreferredSize(dim);
		
		//crq.addCRQ();
		
		/**
		 * Create the frame.
		 */
		
		JLabel lblAdd = new JLabel("Add CRQ");
		lblAdd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				//DefaultTableModel model = (DefaultTableModel) table.getModel();
				//model.addRow(new Object[]{"ulti", "ulti", "ulti","ulti","ulti"});
				contentPane.hide();
				AddCRQ crq = new AddCRQ();
				crq.setVisible(true);
				
			}
		});
		
		//lblListUsers.setBounds(scrollPane.getX()-100, scrollPane.getY()-100, lblListUsers.getWidth(), lblListUsers.getHeight());
		
		//lblListUsers.setBounds(width/2, height/2, lblListUsers.getWidth(), lblListUsers.getHeight());
		
		lblAdd.setLocation(width/2, height/2);
		
		JLabel lblNewLabel = new JLabel("New label");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblAdd)
						.addComponent(lblNewLabel))
					.addGap(21)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(121))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(36)
							.addComponent(lblAdd)
							.addGap(61)
							.addComponent(lblNewLabel))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(5)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 187, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(154, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
		
		//contentPane.setLayout(getLayout());
		
	}
}
