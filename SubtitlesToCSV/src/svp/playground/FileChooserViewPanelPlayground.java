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

import svp.files.FileChooser;
import svp.gui.model.SubtitleType;
import javax.swing.JTextField;

public class FileChooserViewPanelPlayground extends JPanel {
	private JTextField txtSubtitleFile;
	private JTextField txtAudioFile;
	private JTextField txtOutputFolder;
	private boolean isSubtitleFileSet;
	private boolean isAudioFileSet;
	private boolean isOutputPathSet;

	public static void main(String[] args) {
		JFrame jf = new JFrame();
		jf.setTitle("Subtitle to Anki");
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setBounds(100, 100, 600, 400);
		
		JPanel jp = new FileChooserViewPanelPlayground();
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
	public FileChooserViewPanelPlayground() {
		setBackground(new Color(47, 79, 79));
		//Themes ;)
		Color buttonColor = new Color(255, 250, 205);
		
		  ///////////////////////////
		 //		   Top Menu 	  //
		///////////////////////////
		
		//------ Subtitle ------//
		JLabel lblSubtitleFile = new JLabel("Subtitle File");
		lblSubtitleFile.setForeground(new Color(128, 128, 0));
		lblSubtitleFile.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtSubtitleFile = new JTextField();
		txtSubtitleFile.setColumns(10);
		JButton btnSubtitleFile = new JButton("Select");
		btnSubtitleFile.setBackground(Color.LIGHT_GRAY);
		btnSubtitleFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
	        	System.out.println("Button btnSelectOutputPath pressed");
	            String path = FileChooser.pickPath();
	            if(!path.equals("-1")) {
	            	isSubtitleFileSet = true; 
	            	txtSubtitleFile.setText(path);
	            }
	            else {
	            	isSubtitleFileSet = false; 
	            }
	            System.out.println("Erhaltener Pfad: "+path);
			}
		});
		
		//------ Audio ------//
		JLabel lblAudioFile = new JLabel("Audio File");
		lblAudioFile.setForeground(new Color(128, 128, 0));
		lblAudioFile.setFont(new Font("Tahoma", Font.BOLD, 13));		
		txtAudioFile = new JTextField();
		txtAudioFile.setColumns(10);
		JButton btnAudioFile = new JButton("Select");
		btnAudioFile.setBackground(Color.LIGHT_GRAY);
		btnAudioFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
	        	System.out.println("Button btnSelectOutputPath pressed");
	            String path = FileChooser.pickPath();
	            if(!path.equals("-1")) {
	            	isAudioFileSet = true; 
	            	txtAudioFile.setText(path);
	            }
	            else {
	            	isAudioFileSet = false; 
	            }
	            System.out.println("Erhaltener Pfad: "+path);
			}
		});
		
		
		//------ Output ------//
		JLabel lblOutputFolder = new JLabel("Output Folder");
		lblOutputFolder.setForeground(new Color(128, 128, 0));
		lblOutputFolder.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtOutputFolder = new JTextField();
		txtOutputFolder.setColumns(10);
		JButton btnOutputFolder = new JButton("Select");
		btnOutputFolder.setBackground(Color.LIGHT_GRAY);
		btnOutputFolder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
	        	System.out.println("Button btnSelectOutputPath pressed");
	            String path = FileChooser.pickPath();
	            if(!path.equals("-1")) {
	            	isOutputPathSet = true; 
	            	txtOutputFolder.setText(path);
	            }
	            else {
	            	isOutputPathSet = false; 
	            }
	            System.out.println("Erhaltener Pfad: "+path);
			}
		});
		
		
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
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblSubtitleFile)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(10)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(txtOutputFolder, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 450, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtAudioFile, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 450, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtSubtitleFile, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 450, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(btnOutputFolder, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnAudioFile, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnSubtitleFile, GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)))
						.addComponent(lblAudioFile, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblOutputFolder, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(24, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(237, Short.MAX_VALUE)
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
					.addComponent(lblSubtitleFile)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtSubtitleFile, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnSubtitleFile, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(lblAudioFile, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtAudioFile, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnAudioFile))
					.addGap(18)
					.addComponent(lblOutputFolder, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtOutputFolder, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnOutputFolder))
					.addGap(130)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnCancel)
						.addComponent(btnNext)
						.addComponent(btnBack))
					.addContainerGap())
		);
		setLayout(groupLayout);
	}
}
