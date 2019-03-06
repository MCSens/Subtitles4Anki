package svp.playground;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import svp.data.main.SubtitleType;
import svp.util.FileChooser;

import javax.swing.JTextField;

public class SubtitleReviewViewPanelPlayground extends JPanel {
	private boolean isSubtitleFileSet;
	private boolean isAudioFileSet;
	private boolean isOutputPathSet;

	public static void main(String[] args) {
		JFrame jf = new JFrame();
		jf.setTitle("Subtitle to Anki");
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setBounds(100, 100, 600, 400);
		
		JPanel jp = new SubtitleReviewViewPanelPlayground();
		jf.setContentPane(jp);
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					jf.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * Create the panel.
	 */
	public SubtitleReviewViewPanelPlayground() {
		setBackground(new Color(47, 79, 79));
		//Themes ;)
		Color buttonColor = new Color(255, 250, 205);
		
		  ///////////////////////////
		 //		   Top Menu 	  //
		///////////////////////////
		
		//------ Subtitle ------//
		JLabel lblSubtitleReview = new JLabel("Subtitle Review View");
		lblSubtitleReview.setForeground(new Color(128, 128, 0));
		lblSubtitleReview.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		
		  ///////////////////////////
		 //			Button Bar	  //
		///////////////////////////
		JButton btnNext = new JButton("Next");
		btnNext.setBackground(new Color(192, 192, 192));
		//btnNewButton.setBackground(new Color(255, 255, 255));
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBackground(new Color(192, 192, 192));
		
		
		JButton btnBack = new JButton("Back");
		btnBack.setBackground(Color.LIGHT_GRAY);
		
		  ///////////////////////////
		 //		Layout Setting	  //
		///////////////////////////		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblSubtitleReview)
					.addContainerGap(286, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(213, Short.MAX_VALUE)
					.addComponent(btnBack, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnNext, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnCancel, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblSubtitleReview)
					.addGap(288)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnCancel)
						.addComponent(btnNext)
						.addComponent(btnBack))
					.addContainerGap())
		);
		setLayout(groupLayout);
	}
}
