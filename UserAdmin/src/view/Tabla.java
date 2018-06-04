package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;

public class Tabla extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tabla frame = new Tabla();
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
	public Tabla() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		Object columnNames[] = { "Column One", "Column Two"};
		
		Object rowData[][] = { { "Row1-Column1", "Row1-Column2"},
                { "Row2-Column1", "Row2-Column2"} };
		
		JTable table = new JTable(rowData, columnNames);
		
		/*table = new JTable(2,columnNames[]);
		contentPane.add(table, BorderLayout.CENTER);
		*/
		String[][] userPass = new String[2][2];
		userPass[0][0] = "hola";
		table.setValueAt("asd", 0, 0);
		
		
		
	}

}
