package javaCeaserCiferDecoder2;

//@author Torin

import javax.swing.*; import java.awt.*; import java.awt.event.*;
public class CeaserCifer2Main {
	//Creating Window
	private static JFrame w = new JFrame();

	//Creating Panels
	private static JPanel p1 = new JPanel();
	private static JPanel p2 = new JPanel();
	private static JPanel p3 = new JPanel();
	private static JPanel p4 = new JPanel();
	private static JPanel p5 = new JPanel();
	private static JPanel p6 = new JPanel();
	
	//Creating Labels
	private static JLabel lC = new JLabel("Enter Ciphertext:");
	private static JLabel lK = new JLabel("Enter Key:");
	private static JLabel lD = new JLabel("");

	//Creating Text Fields
	private static JTextField tfC = new JTextField(50);
	private static JTextField tfK = new JTextField(5);
	
	//Creating Buttons
	private static JButton bD = new JButton("Decode");
	private static JButton bE = new JButton("Exit");
	
	
	//Making Array Of Panels
	private static JPanel[] pArr = {p1, p2, p3, p4, p5, p6};
	
	//Main Code
	public static void main(String[] args) {
		//Setting Window Settings
		w.setTitle("Shift Cipher Decoder");
		w.setSize(600, 320);
		w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		w.setLocationRelativeTo(null);
		w.setLayout(new GridLayout(6, 1));
		
		//Adding Event Listeners
		bD.addActionListener(new bDL());
		bE.addActionListener(new bEL());
		
		//Setting Exit Button Color
		bE.setBackground(new Color(200, 0, 0));
		
		//Adding Components To Panels
		p1.add(lC);
		p1.add(tfC);
		p2.add(lK);
		p2.add(tfK);
		p2.add(bD);
		p3.add(lD);
		p5.add(bE);
		
		//Adding Panels To window And Setting Panel Colors
		for(JPanel p : pArr) {
			p.setBackground(new Color(205, 200, 206));
			w.add(p);
		}
		
		//Setting JFrame To Visible
		w.setVisible(true);
		
	}
	//Event Listeners
	private static class bEL implements ActionListener{
		public void actionPerformed(ActionEvent a) {
			System.exit(0);
		}
	}
	private static class bDL implements ActionListener{
		public void actionPerformed(ActionEvent a) {
			try {
				lD.setText("The Decoded Text Is: "+Decoder.decode(tfC.getText(), Integer.parseInt(tfK.getText())));
			} catch(Exception e) {
				errorMsg();
			}
		}
	}
	
	//Error message JPane
	public static void errorMsg() {
		JOptionPane.showMessageDialog(null, "Whoops! There Was"
				+ " An Error.");
	}
	
}
