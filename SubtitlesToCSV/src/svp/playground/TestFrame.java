package svp.playground;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import svp.files.FileChooser;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;

public class TestFrame extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	boolean isSubtitleFilePathSet;
	boolean isAudioFilePathSet;
	boolean isOutputPathSet;
	
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TestFrame frame = new TestFrame();
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
	public TestFrame() {
		setTitle("Subtitle to Anki");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 677, 376);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(135, 206, 235));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		  /////////////////////
		 //   Subtitle Path	//
		/////////////////////
		JButton btnSelectSubtitlePath = new JButton("Select Path");
		JLabel lblSubtitleFileHeader = new JLabel("Subtitle File");
		lblSubtitleFileHeader.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		JLabel lblSubtitleFile = new JLabel("   Path to Subtitle File");
		//lblSubtitleFile.setMaximumSize(new Dimension(271,27));
		lblSubtitleFile.setBackground(Color.WHITE);
		lblSubtitleFile.setOpaque(true);
		
		btnSelectSubtitlePath.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
	        	System.out.println("Button btnSelectSubtitlePath pressed");
	            String path = FileChooser.pickPath();
	            if(!path.equals("-1")) {
		            isSubtitleFilePathSet = true; 
		            lblSubtitleFile.setText(path);
	            }
	            System.out.println("Erhaltener Pfad: "+path);
			}
		});
		
		  /////////////////////
		 //   Audio Path	//
		/////////////////////
		JButton btnSelectAudioPath = new JButton("Select Path");
		JLabel lblAudioFileHeader = new JLabel("Audio File");
		lblAudioFileHeader.setFont(new Font("Tahoma", Font.BOLD, 13));

		JLabel lblAudioFile = new JLabel("   Path to Audio File");
		lblAudioFile.setBackground(Color.WHITE);
		lblAudioFile.setOpaque(true);
		
		btnSelectAudioPath.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
	        	System.out.println("Button btnSelectAudioPath pressed");
	            String path = FileChooser.pickPath();
	            if(!path.equals("-1")) {
		            isAudioFilePathSet = true; 
		            lblAudioFile.setText(path);
	            }
	            System.out.println("Erhaltener Pfad: "+path);
			}
		});
		
		  /////////////////////
		 //   Output Path	//
		/////////////////////
		JButton btnSelectOutputPath = new JButton("Select Path");
		
		JLabel lblOutputPath = new JLabel("   Path to Output File");
		lblOutputPath.setOpaque(true);
		lblOutputPath.setBackground(Color.WHITE);
		JLabel lblOutputPathHeader = new JLabel("Output Path");
		
		btnSelectOutputPath.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
	        	System.out.println("Button btnSelectOutputPath pressed");
	            String path = FileChooser.pickPath();
	            if(!path.equals("-1")) {
	            	isOutputPathSet = true; 
	            	lblOutputPath.setText(path);
	            }
	            System.out.println("Erhaltener Pfad: "+path);
			}
		});
		
		  /////////////////////
		 //     Generate	//
		/////////////////////		
		JButton btnNewButton = new JButton("Generate");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Subtitle File Path: "+isSubtitleFilePathSet);
				System.out.println("Audio File Path: "+isAudioFilePathSet);
				System.out.println("Output Path: "+isOutputPathSet);
				System.out.println("Button btnSelectSubtitlePath pressed");
				String path = FileChooser.pickPath();
				lblSubtitleFile.setText(path);
				System.out.println("Erhaltener Pfad: "+path);
			}
		});
		
		
		lblOutputPathHeader.setFont(new Font("Tahoma", Font.BOLD, 13));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, 631, Short.MAX_VALUE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
										.addComponent(lblOutputPath, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 508, Short.MAX_VALUE)
										.addComponent(lblAudioFile, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 508, Short.MAX_VALUE)
										.addComponent(lblSubtitleFile, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 520, GroupLayout.PREFERRED_SIZE))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
										.addComponent(btnSelectSubtitlePath, GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
										.addComponent(btnSelectAudioPath, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
										.addComponent(btnSelectOutputPath, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)))))
						.addComponent(lblAudioFileHeader, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblSubtitleFileHeader, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblOutputPathHeader, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(16)
					.addComponent(lblSubtitleFileHeader, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblSubtitleFile, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnSelectSubtitlePath, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
					.addGap(22)
					.addComponent(lblAudioFileHeader, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblAudioFile, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnSelectAudioPath, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(lblOutputPathHeader, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnSelectOutputPath, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblOutputPath, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
					.addGap(20))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
