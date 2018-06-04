package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class PayRecorder extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PayRecorder frame = new PayRecorder();
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
	public PayRecorder() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
//*************************************************************************************************
// CREACION DE LA TABLA

		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		
		
		
Object columnNames[] = { "Date","Description"};
		
		Object rowData[][] = { { "Row1-Column1", "Row1-Column2","Row1-Column3","Row1-Column4","Row1-Column5"},
                { "Row2-Column1", "Row2-Column2","Row2-Column3", "Row2-Column4","Row2-Column5"} };
		

		
		JTable table = new JTable(rowData, columnNames);

		JScrollPane scrollPane = new JScrollPane(table);
		
		contentPane.add(scrollPane);
//*************************************************************************************
//CREACION DE LABEL LISTAR
		
		JLabel lblList = new JLabel("Listar");
		
		contentPane.add(lblList);
		
		
		
		
		
		
		
		
		
		
		
//		
		
		
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(186)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(236, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(58)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(192, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
