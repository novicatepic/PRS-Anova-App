package org.unibl.etf.lab3;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FirstWindow extends JFrame {

	private JPanel contentPane;
	private JTextField alternativeNum;
	private JTextField measNum;
	private JTextField contrastNum;
	private JTextField fValue;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FirstWindow frame = new FirstWindow();
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
	public FirstWindow() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 308, 390);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		alternativeNum = new JTextField();
		alternativeNum.setHorizontalAlignment(SwingConstants.CENTER);
		alternativeNum.setBounds(45, 44, 167, 19);
		contentPane.add(alternativeNum);
		alternativeNum.setColumns(10);
		
		measNum = new JTextField();
		measNum.setHorizontalAlignment(SwingConstants.CENTER);
		measNum.setColumns(10);
		measNum.setBounds(45, 107, 167, 19);
		contentPane.add(measNum);
		
		JLabel alternativeLabel = new JLabel("Unesi broj alternativa:");
		alternativeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		alternativeLabel.setBounds(45, 10, 167, 24);
		contentPane.add(alternativeLabel);
		
		JLabel measurementLabel = new JLabel("Unesi broj mjerenja:");
		measurementLabel.setHorizontalAlignment(SwingConstants.CENTER);
		measurementLabel.setBounds(45, 73, 167, 24);
		contentPane.add(measurementLabel);
		
		JButton submitButton = new JButton("Nastavi dalje");
		submitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int numAlternatives = Integer.valueOf(alternativeNum.getText());
				int numMeasurements = Integer.valueOf(measNum.getText());
				double contrastTable = Double.valueOf(contrastNum.getText());
				double fTable = Double.valueOf(fValue.getText());
				InputParameters inputParameters = new InputParameters();
				inputParameters.setParameters(numAlternatives, numMeasurements, contrastTable, fTable);
				inputParameters.setVisible(true);
				setVisible(false);
				dispose();
				//System.out.println(numAlternatives + " " + numMeasurements);
			}
		});
		submitButton.setBounds(83, 308, 105, 21);
		contentPane.add(submitButton);
		
		JLabel contrastLabel = new JLabel("Unesi vrijednost iz tabele (za kontrast): ");
		contrastLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contrastLabel.setBounds(24, 143, 228, 24);
		contentPane.add(contrastLabel);
		
		contrastNum = new JTextField();
		contrastNum.setHorizontalAlignment(SwingConstants.CENTER);
		contrastNum.setColumns(10);
		contrastNum.setBounds(45, 171, 167, 19);
		contentPane.add(contrastNum);
		
		JLabel fLabel = new JLabel("Unesi F iz tabele: ");
		fLabel.setHorizontalAlignment(SwingConstants.CENTER);
		fLabel.setBounds(24, 213, 228, 24);
		contentPane.add(fLabel);
		
		fValue = new JTextField();
		fValue.setHorizontalAlignment(SwingConstants.CENTER);
		fValue.setColumns(10);
		fValue.setBounds(45, 247, 167, 19);
		contentPane.add(fValue);
		
		/*int numAlternatives = Integer.valueOf(alternativeNum.getText());
		int numMeasurements = Integer.valueOf(measNum.getText());
		System.out.println(numAlternatives + " " + numMeasurements);*/
	}
}
