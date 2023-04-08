package org.unibl.etf.lab3;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.GridLayout;

public class ShowResults extends JFrame {

	private JPanel contentPane;
	private JTextField meanSquare;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ShowResults frame = new ShowResults();
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
	public ShowResults() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 698, 510);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("REZULTATI:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(286, 10, 98, 29);
		contentPane.add(lblNewLabel);
		
		JPanel gridPanel = new JPanel();
		gridPanel.setBounds(97, 49, 577, 71);
		contentPane.add(gridPanel);
		gridPanel.setLayout(new GridLayout(1, 0, 0, 0));
		
		JLabel lblNewLabel_1 = new JLabel("Srednje vr.");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(20, 49, 67, 29);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Efekat");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(20, 88, 67, 18);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Ukupna sr. vrijednost:");
		lblNewLabel_3.setBounds(20, 155, 129, 46);
		contentPane.add(lblNewLabel_3);
		
		meanSquare = new JTextField();
		meanSquare.setBounds(202, 155, 136, 46);
		contentPane.add(meanSquare);
		meanSquare.setColumns(10);
	}

}
