package svp.gui.view;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JComboBox;
import javax.swing.JFrame;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import javax.swing.JToggleButton;
import javax.swing.border.EmptyBorder;

import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import net.miginfocom.swing.MigLayout;
import svp.data.main.SubtitleType;

import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JInternalFrame;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import javax.swing.JCheckBox;
import java.awt.Component;
import javax.swing.Box;
import java.awt.SystemColor;
import javax.swing.UIManager;
import javax.swing.JTextField;

public class ConfigurationViewPanelPlayground extends JPanel {

	public static void main(String[] args) {
		JFrame jf = new JFrame();
		jf.setTitle("Subtitle to Anki");
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setBounds(100, 100, 400, 400);
		
		JPanel jp = new ConfigurationViewPanelPlayground();
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
	public ConfigurationViewPanelPlayground() {
		setBackground(new Color(47, 79, 79));
		//Themes ;)
		Color buttonColor = new Color(255, 250, 205); //Yellow/Gold
		
		JComboBox subtitleFileFormatCombobox = new JComboBox();
		subtitleFileFormatCombobox.setBackground(new Color(192, 192, 192));
		subtitleFileFormatCombobox.setModel(new DefaultComboBoxModel<>(SubtitleType.values()));
		
		JLabel lblGeneral = new JLabel("General Settings");
		lblGeneral.setForeground(new Color(128, 128, 0));
		lblGeneral.setFont(new Font("Tahoma", Font.BOLD, 13));

		JLabel lblSelectSubtitleFile = new JLabel("Select Subtitle File Format");
		lblSelectSubtitleFile.setForeground(new Color(255, 250, 205));
		JLabel lblUseAudio = new JLabel("Do you want to use Audio?");
		lblUseAudio.setForeground(new Color(255, 250, 205));
		
		JCheckBox isAudioEnabled = new JCheckBox("");
		isAudioEnabled.setBackground(new Color(47, 79, 79));
		
		JLabel lblCleanup = new JLabel("Clean Up");
		lblCleanup.setForeground(new Color(128, 128, 0));
		lblCleanup.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		JLabel lblMergeLines = new JLabel("Merge Lines with Commas at end?");
		lblMergeLines.setForeground(new Color(255, 250, 205));
		
		JCheckBox isMergeCommasEnabled = new JCheckBox("");
		isMergeCommasEnabled.setBackground(new Color(47, 79, 79));
		
		
		JButton btnNext = new JButton("Next");
		btnNext.setBackground(new Color(192, 192, 192));
		//btnNewButton.setBackground(new Color(255, 255, 255));
		
		JButton buttonCancel = new JButton("Cancel");
		buttonCancel.setBackground(new Color(192, 192, 192));
		
		JLabel lblLanguages = new JLabel("Languages of Subtitles.");
		lblLanguages.setForeground(new Color(255, 250, 205));
		
		JTextArea txtSubtitleLanguages = new JTextArea();
		txtSubtitleLanguages.setFont(new Font("Monospaced", Font.PLAIN, 11));
		txtSubtitleLanguages.setText("Seprate Language with ;\r\ne.g.: Hanzi; English;\r\n");
		txtSubtitleLanguages.setColumns(10);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(160)
					.addComponent(btnNext, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(buttonCancel, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(18, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
							.addGap(10)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblLanguages, GroupLayout.PREFERRED_SIZE, 173, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(txtSubtitleLanguages, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblMergeLines, GroupLayout.PREFERRED_SIZE, 198, GroupLayout.PREFERRED_SIZE)
									.addGap(46)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(isAudioEnabled)
										.addComponent(isMergeCommasEnabled, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)))))
						.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
							.addComponent(lblCleanup, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 202, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblGeneral)
							.addPreferredGap(ComponentPlacement.RELATED, 202, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(10)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblSelectSubtitleFile, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblUseAudio, GroupLayout.PREFERRED_SIZE, 164, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addComponent(subtitleFileFormatCombobox, 0, 131, Short.MAX_VALUE)))
					.addGap(33))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblGeneral)
					.addGap(13)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblSelectSubtitleFile, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
						.addComponent(subtitleFileFormatCombobox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblUseAudio, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
						.addComponent(isAudioEnabled))
					.addGap(18)
					.addComponent(lblCleanup, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblMergeLines, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
						.addComponent(isMergeCommasEnabled, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
					.addGap(5)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblLanguages, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtSubtitleLanguages, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNext)
						.addComponent(buttonCancel))
					.addContainerGap())
		);
		setLayout(groupLayout);

	}
}
