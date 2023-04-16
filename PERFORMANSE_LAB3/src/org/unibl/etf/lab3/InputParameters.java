package org.unibl.etf.lab3;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.awt.event.ActionEvent;

public class InputParameters extends JFrame {

	private JPanel contentPane;
	private JTextField[][] textFields;
	private int numAlternatives=2, numMeasurements=2;
	private JPanel panel;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InputParameters frame = new InputParameters();
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
	public InputParameters() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 670, 486);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Unesi vrijednosti:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(29, 10, 591, 32);
		contentPane.add(lblNewLabel);
		
		panel = new JPanel();
		panel.setBounds(57, 82, 578, 357);
		contentPane.add(panel);
		
		
		JLabel lblNewLabel_1 = new JLabel("ALTERNATIVE");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(203, 41, 236, 24);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("MJ.");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(10, 238, 30, 32);
		contentPane.add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("IZRACUNAJ");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calculateParameters();
				
			}
		});
		btnNewButton.setBounds(504, 43, 85, 21);
		contentPane.add(btnNewButton);
		/*System.out.println(numAlternatives);
		System.out.println(numMeasurements);*/
	}
	
	private double contrastValue;
	private double fValue;
	public void setParameters(int numAlternatives, int numMeasurements, double contrastValue, double fValue) {
		this.numAlternatives = numAlternatives;
		this.numMeasurements = numMeasurements;
		this.contrastValue = contrastValue;
		this.fValue = fValue;
		panel.setLayout(new GridLayout(numMeasurements, numAlternatives));
		
		textFields = new JTextField[numMeasurements][numAlternatives];
		
		for(int i = 0; i < numMeasurements; i++) {
			textFields[i] = new JTextField[numAlternatives];
		}
		
		for(int i = 0; i < numMeasurements; i++) {
			for(int j = 0; j < numAlternatives; j++) {
				textFields[i][j] = new JTextField();
			}
		}
		
		for(int i = 0; i < numMeasurements; i++) {
			for(int j = 0; j < numAlternatives; j++) {
				//textFields[i][j] = new JTextField();
				panel.add(textFields[i][j]);
			}
		}
		
		meanSquareColumns = new double[numAlternatives];
		effects = new double[numAlternatives];
		
		
	}
	
	private double SSE = 0.0;
	private double SSA = 0.0;
	private double SST = 0.0;
	private double meanSquareColumns[];
	private double effects[];
	private double meanSquare;
	private int degFreedomAlternatives;
	private int degFreedomErrors;
	private int degFreedomTotal;
	private double meanSquareAlternatives;
	private double meanSquareErrors;
	private double computedF;
	private boolean doesDifferenceExist = false;
	
	private void calculateParameters() {
		double[] sumOfAlternatives = new double[numAlternatives];
		double fullSum = 0.0;
		//double[] meanSquaresOfColumns
		for(int i = 0; i < numMeasurements; i++) {
			for(int j = 0; j < numAlternatives; j++) {
				//textFields[i][j] = new JTextField();
				sumOfAlternatives[j] += Double.valueOf(textFields[i][j].getText());
				fullSum += Double.valueOf(textFields[i][j].getText());
			}
		}
		
		for(int i = 0; i < numAlternatives; i++) {
			meanSquareColumns[i] = sumOfAlternatives[i] / numMeasurements;
		}
		
		meanSquare = fullSum / (numAlternatives * numMeasurements);
		
		for(int i = 0; i < numAlternatives; i++) {
			effects[i] = meanSquareColumns[i] - meanSquare;
			/*if(effects[i] < 0) {
				effects[i] *= -1.0;
			}*/
		}
		
		for(int j = 0; j < numAlternatives; j++) {
			for(int i = 0; i < numMeasurements; i++) {
				double tempVal = Double.valueOf(textFields[i][j].getText()) - meanSquareColumns[j];
				tempVal *= tempVal;
				SSE += tempVal;
			}
		}
		
		for(int j = 0; j < numAlternatives; j++) {
			double tempVal = (meanSquareColumns[j] - meanSquare);
			tempVal *= tempVal;
			SSA += tempVal;
		}
		SSA *= numMeasurements;
		SST = SSA + SSE;
		
		for(int i = 0; i < numAlternatives; i++) {
			System.out.println("Mean square of " + i + " = " + meanSquareColumns[i]);
		}
		
		for(int i = 0; i < numAlternatives; i++) {
			System.out.println("Effects of " + i + " = " + effects[i]);
		}
		
		degFreedomAlternatives = numAlternatives - 1;
		degFreedomErrors = numAlternatives * (numMeasurements - 1);
		degFreedomTotal = degFreedomAlternatives + degFreedomErrors;
		
		meanSquareAlternatives = SSA / Double.valueOf(degFreedomAlternatives);
		meanSquareErrors = SSE / degFreedomErrors;
		
		computedF = meanSquareAlternatives / meanSquareErrors;
		
		System.out.println("Mean square of full = " + meanSquare);
		System.out.println("SSA = " + SSA);
		System.out.println("SSE = " + SSE);
		System.out.println("SST = " + SST);
		System.out.println("Deg. freedom alternatives = " + degFreedomAlternatives);
		System.out.println("Deg. freedom errors = " + degFreedomErrors);
		System.out.println("Deg. freedom total = " + degFreedomTotal);
		System.out.println("Mean square alternatives = " + meanSquareAlternatives);
		System.out.println("Mean square errors = " + meanSquareErrors);
		System.out.println("Computed F = " + computedF);
		
		if(computedF > fValue) {
			doesDifferenceExist = true;
		}
		
		System.out.println("Difference exists = " + doesDifferenceExist);
		
		for(int i = 0; i < numAlternatives; i++) {
			for(int j = 0; j < numAlternatives; j++) {
				if(i < j) {
					calculateContrast(i, j);
				}
			}
		}
		
		ShowResults showResults = new ShowResults(meanSquareColumns, effects, meanSquare, SSA, SSE, SST, degFreedomAlternatives, degFreedomErrors,
				degFreedomTotal, meanSquareAlternatives, meanSquareErrors, computedF, fValue);
		showResults.setVisible(true);
		ShowProbabilities showProbabilities = new ShowProbabilities(map);
		showProbabilities.setVisible(true);
	}
	
	private ArrayList<String> map = new ArrayList<>();
	private void calculateContrast(int alternative1, int alternative2) {	
		double sc = 0.0, scTemp = 0.0;
		scTemp += 2.0 / Double.valueOf(numAlternatives * numMeasurements);
		sc = Math.sqrt(scTemp) * Math.sqrt(meanSquareErrors);
		
		double effect1 = effects[alternative1];
		double effect2 = effects[alternative2];
		double c = effect1 - effect2;
		
		double c1 = c - contrastValue * sc;
		double c2 = c + contrastValue * sc;
		String toMap = ("("+String.valueOf(alternative1+1)+", "+String.valueOf(alternative2+1)+") = " + 
		"(" + String.valueOf(c1) + ", " + String.valueOf(c2) + ")");
		//map.put(toMap, null)
		map.add(toMap);
		System.out.println("Between alternatives: " + alternative1 + " and " + alternative2);
		System.out.println("C1 = " + c1);
		System.out.println("C2 = " + c2);
		
		
	}
}
