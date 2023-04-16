package aid;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.GridLayout;

public class ShowProbabilities extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ShowProbabilities frame = new ShowProbabilities();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ShowProbabilities() {}
	
	/**
	 * Create the frame.
	 */
	private JLabel[] labels;
	public ShowProbabilities(ArrayList<String> list) {
		//ArrayList<String> list = new ArrayList<>();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 704, 547);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("REZULTATI ZA POREDJENJE ALTERNATIVA: ");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(113, 25, 439, 31);
		contentPane.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBounds(44, 76, 622, 410);
		contentPane.add(panel);
		panel.setLayout(new GridLayout(list.size(), 1));
		
		labels = new JLabel[list.size()];
		for(int i = 0; i < list.size(); i++) {
			labels[i] = new JLabel();
		}
		for(int i = 0; i < list.size(); i++) {
			labels[i].setText(list.get(i));
		}
		for(int i = 0; i < list.size(); i++) {
			panel.add(labels[i]);
		}
	}

}
