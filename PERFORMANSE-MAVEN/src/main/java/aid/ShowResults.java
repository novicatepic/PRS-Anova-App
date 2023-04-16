package aid;

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
	
	public ShowResults() {}
	
	private JLabel[][] labels;
	public ShowResults(double[] meanSquareColumns, double[] effects, double fullSquare,
			double SSA, double SSE, double SST, int degFreedom1, int degFreedom2, int degFreedom3,
			double sa, double se, double computedF, double tabulatedF) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 741, 534);
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
		gridPanel.setLayout(new GridLayout(2, meanSquareColumns.length));
		
		labels = new JLabel[2][meanSquareColumns.length];
		for(int i = 0; i < 2; i++) {
			labels[i] = new JLabel[meanSquareColumns.length];
		}
		for(int i = 0; i < 2; i++) {
			for(int j = 0; j < meanSquareColumns.length; j++) {
				labels[i][j] = new JLabel();
			}
		}
		
		/*System.out.println("TEST");
		for(int j = 0; j < meanSquareColumns.length; j++) {
			System.out.println(meanSquareColumns[j]);
		}
		System.out.println("PROBA");*/
		
		for(int i = 0; i < 2; i++) {
			if(i == 0) {
				for(int j = 0; j < meanSquareColumns.length; j++) {
					System.out.println(meanSquareColumns[j]);
					labels[i][j].setText(String.valueOf(meanSquareColumns[j]));
				}
			} else {
				for(int j = 0; j < meanSquareColumns.length; j++) {
					labels[i][j].setText(String.valueOf(effects[j]));
				}
			}
		}
		
		for(int i = 0; i < 2; i++) {
			for(int j = 0; j < meanSquareColumns.length; j++) {
				gridPanel.add(labels[i][j]);
			}
		}
		
		JLabel lblNewLabel_1 = new JLabel("Srednje vr.");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(20, 49, 67, 29);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Efekat");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(20, 88, 67, 18);
		contentPane.add(lblNewLabel_2);
		
		JLabel squareValue = new JLabel("Ukupna sr. vrijednost:");
		squareValue.setBounds(20, 155, 187, 46);
		squareValue.setText(squareValue.getText() + " " + String.valueOf(fullSquare));
		contentPane.add(squareValue);
		
		JLabel lblNewLabel_4 = new JLabel("Varijacija");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(38, 230, 67, 29);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_4_1 = new JLabel("Alternative");
		lblNewLabel_4_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4_1.setBounds(167, 230, 67, 29);
		contentPane.add(lblNewLabel_4_1);
		
		JLabel lblNewLabel_4_1_1 = new JLabel("Greske");
		lblNewLabel_4_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4_1_1.setBounds(317, 230, 67, 29);
		contentPane.add(lblNewLabel_4_1_1);
		
		JLabel lblNewLabel_4_1_1_1 = new JLabel("Total");
		lblNewLabel_4_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4_1_1_1.setBounds(490, 230, 67, 29);
		contentPane.add(lblNewLabel_4_1_1_1);
		
		JLabel lblNewLabel_4_2 = new JLabel("Suma kvad,");
		lblNewLabel_4_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4_2.setBounds(38, 267, 67, 29);
		contentPane.add(lblNewLabel_4_2);
		
		JLabel lblNewLabel_4_3 = new JLabel("St. slobode");
		lblNewLabel_4_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4_3.setBounds(38, 311, 67, 29);
		contentPane.add(lblNewLabel_4_3);
		
		JLabel lblNewLabel_4_4 = new JLabel("\"Mean square\"");
		lblNewLabel_4_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4_4.setBounds(38, 358, 67, 29);
		contentPane.add(lblNewLabel_4_4);
		
		JLabel lblNewLabel_4_4_1 = new JLabel("F izracunato");
		lblNewLabel_4_4_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4_4_1.setBounds(38, 406, 67, 29);
		contentPane.add(lblNewLabel_4_4_1);
		
		JLabel SSAlabel = new JLabel("");
		SSAlabel.setHorizontalAlignment(SwingConstants.CENTER);
		SSAlabel.setBounds(147, 269, 108, 29);
		SSAlabel.setText("SSA="+String.valueOf(SSA));
		contentPane.add(SSAlabel);
		
		JLabel k1label = new JLabel("");
		k1label.setHorizontalAlignment(SwingConstants.CENTER);
		k1label.setBounds(147, 311, 108, 29);
		k1label.setText("k-1="+String.valueOf(degFreedom1));
		contentPane.add(k1label);
		
		JLabel saSquareLabel = new JLabel("");
		saSquareLabel.setHorizontalAlignment(SwingConstants.CENTER);
		saSquareLabel.setBounds(147, 358, 108, 29);
		saSquareLabel.setText("sa^2="+String.valueOf(sa));
		contentPane.add(saSquareLabel);
		
		JLabel fComputedLabel = new JLabel("");
		fComputedLabel.setHorizontalAlignment(SwingConstants.CENTER);
		fComputedLabel.setBounds(147, 406, 108, 29);
		fComputedLabel.setText(String.valueOf(computedF));
		contentPane.add(fComputedLabel);
		
		JLabel SSElabel = new JLabel("");
		SSElabel.setHorizontalAlignment(SwingConstants.CENTER);
		SSElabel.setBounds(293, 267, 121, 29);
		SSElabel.setText("SSE="+String.valueOf(SSE));
		contentPane.add(SSElabel);
		
		JLabel kn1label = new JLabel("");
		kn1label.setHorizontalAlignment(SwingConstants.CENTER);
		kn1label.setBounds(286, 311, 128, 29);
		kn1label.setText("k(n-1)="+String.valueOf(degFreedom2));
		contentPane.add(kn1label);
		
		JLabel seSquareLabel = new JLabel("");
		seSquareLabel.setHorizontalAlignment(SwingConstants.CENTER);
		seSquareLabel.setBounds(293, 358, 121, 29);
		seSquareLabel.setText("se^2="+String.valueOf(se));
		contentPane.add(seSquareLabel);
		
		JLabel SSTlabel = new JLabel("");
		SSTlabel.setHorizontalAlignment(SwingConstants.CENTER);
		SSTlabel.setBounds(469, 267, 108, 29);
		SSTlabel.setText("SST="+String.valueOf(SST));
		contentPane.add(SSTlabel);
		
		JLabel kn2label = new JLabel("");
		kn2label.setHorizontalAlignment(SwingConstants.CENTER);
		kn2label.setBounds(469, 311, 108, 29);
		kn2label.setText("kn-1="+String.valueOf(degFreedom3));
		contentPane.add(kn2label);
		
		JLabel lblNewLabel_4_4_1_1 = new JLabel("F tabelarno");
		lblNewLabel_4_4_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4_4_1_1.setBounds(38, 445, 67, 29);
		contentPane.add(lblNewLabel_4_4_1_1);
		
		JLabel fTableLabel = new JLabel("");
		fTableLabel.setHorizontalAlignment(SwingConstants.CENTER);
		fTableLabel.setBounds(147, 445, 108, 29);
		fTableLabel.setText(String.valueOf(tabulatedF));
		contentPane.add(fTableLabel);
	}

}

