package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import functions.CRQ;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AddCRQ extends JFrame {

	private JPanel contentPane;
	private JTextField txtDate;
	private JTextField txtCRQ;
	private JTextField txtStatus;
	private JTextField txtObservations;
	private JTextField txtPID;
	private JLabel lblAddCrq;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddCRQ frame = new AddCRQ();
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
	public AddCRQ() {
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 527, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		txtDate = new JTextField();
		txtDate.setColumns(10);
		
		txtCRQ = new JTextField();
		txtCRQ.setColumns(10);
		
		txtStatus = new JTextField();
		txtStatus.setColumns(10);
		
		txtObservations = new JTextField();
		txtObservations.setColumns(10);
		
		txtPID = new JTextField();
		txtPID.setColumns(10);
		
		JLabel lblDate = new JLabel("Date");
		
		JLabel lblCRQ = new JLabel("CRQ");
		
		JLabel lblStatus = new JLabel("Status");
		
		JLabel lblObservations = new JLabel("Observations");
		
		JLabel lblPID = new JLabel("PID");
		
		lblAddCrq = new JLabel("Add CRQ");
		lblAddCrq.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String date, crqText, status, observations, pid;
				date=txtDate.getText();
				crqText = txtCRQ.getText();
				status= txtStatus.getText();
				observations = txtObservations.getText();
				pid = txtPID.getText();
				CRQ crq = new CRQ();
				crq.addCRQ(date, crqText, status, observations, pid);				
			}
		});
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(235, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblDate)
						.addComponent(lblCRQ)
						.addComponent(lblStatus)
						.addComponent(lblObservations)
						.addComponent(lblPID))
					.addGap(48)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtDate, GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE))
						.addComponent(txtCRQ)
						.addComponent(txtStatus)
						.addComponent(txtObservations)
						.addComponent(txtPID))
					.addGap(21))
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addGap(181)
					.addComponent(lblAddCrq)
					.addContainerGap(274, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(41, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtDate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblDate))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtCRQ, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblCRQ))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtStatus, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblStatus))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(txtObservations, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtPID, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblPID)))
						.addComponent(lblObservations))
					.addGap(14)
					.addComponent(lblAddCrq)
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
	}
}
