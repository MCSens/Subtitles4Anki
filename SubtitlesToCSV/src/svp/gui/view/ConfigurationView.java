package svp.gui.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.util.Random;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import svp.data.main.ConfigurationTable;
import svp.data.main.SubtitleType;
import svp.gui.controller.IConfigurationViewController;


public class ConfigurationView extends AbstractView<IConfigurationViewController> implements IConfigurationView {

    private JComboBox subtitleFileFormatCombobox;
    private JCheckBox isAudioEnabledCheckbox;
    private JCheckBox isMergeCommasEnabledCheckbox;
    
    public JComboBox getSubtitleFileFormatCombobox() {
		return subtitleFileFormatCombobox;
	}

	public void setSubtitleFileFormatCombobox(JComboBox subtitleFileFormatCombobox) {
		this.subtitleFileFormatCombobox = subtitleFileFormatCombobox;
	}

	public JCheckBox getIsAudioEnabledCheckbox() {
		return isAudioEnabledCheckbox;
	}

	public void setIsAudioEnabledCheckbox(JCheckBox isAudioEnabledCheckbox) {
		this.isAudioEnabledCheckbox = isAudioEnabledCheckbox;
	}

	public JCheckBox getIsMergeCommasEnabledCheckbox() {
		return isMergeCommasEnabledCheckbox;
	}

	public void setIsMergeCommasEnabledCheckbox(JCheckBox isMergeCommasEnabledCheckbox) {
		this.isMergeCommasEnabledCheckbox = isMergeCommasEnabledCheckbox;
	}

	public ConfigurationView(IConfigurationViewController controller) {
    	super(controller);
    	setBackground(new Color(47, 79, 79));
		//Themes ;)
		
		subtitleFileFormatCombobox = new JComboBox();
		subtitleFileFormatCombobox.setBackground(new Color(192, 192, 192));
		subtitleFileFormatCombobox.setModel(new DefaultComboBoxModel<>(SubtitleType.values()));
		
		JLabel lblGeneral = new JLabel("General Settings");
		lblGeneral.setForeground(new Color(128, 128, 0));
		lblGeneral.setFont(new Font("Tahoma", Font.BOLD, 13));

		JLabel lblSelectSubtitleFile = new JLabel("Select Subtitle File Format");
		lblSelectSubtitleFile.setForeground(new Color(255, 250, 205));
		JLabel lblUseAudio = new JLabel("Do you want to use Audio?");
		lblUseAudio.setForeground(new Color(255, 250, 205));
		
		isAudioEnabledCheckbox = new JCheckBox("");
		isAudioEnabledCheckbox.setBackground(new Color(47, 79, 79));
		
		JLabel lblCleanup = new JLabel("Clean Up");
		lblCleanup.setForeground(new Color(128, 128, 0));
		lblCleanup.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		JLabel lblMergeCommasEnabled = new JLabel("Merge Lines with Commas at end?");
		lblMergeCommasEnabled.setForeground(new Color(255, 250, 205));
		
		isMergeCommasEnabledCheckbox = new JCheckBox("");
		isMergeCommasEnabledCheckbox.setBackground(new Color(47, 79, 79));
		
		
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
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addComponent(btnNext, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(buttonCancel, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(10)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(lblMergeCommasEnabled, GroupLayout.PREFERRED_SIZE, 198, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblLanguages, GroupLayout.PREFERRED_SIZE, 173, GroupLayout.PREFERRED_SIZE))
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup()
											.addGap(7)
											.addComponent(txtSubtitleLanguages, GroupLayout.PREFERRED_SIZE, 270, GroupLayout.PREFERRED_SIZE))
										.addGroup(groupLayout.createSequentialGroup()
											.addGap(131)
											.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
												.addComponent(isAudioEnabledCheckbox)
												.addComponent(isMergeCommasEnabledCheckbox, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)))))
								.addComponent(lblCleanup, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblGeneral)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(10)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(lblSelectSubtitleFile, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE)
											.addGap(96)
											.addComponent(subtitleFileFormatCombobox, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE))
										.addComponent(lblUseAudio, GroupLayout.PREFERRED_SIZE, 164, GroupLayout.PREFERRED_SIZE))))
							.addContainerGap(105, Short.MAX_VALUE))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblGeneral)
							.addGap(13)
							.addComponent(lblSelectSubtitleFile, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
						.addComponent(subtitleFileFormatCombobox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblUseAudio, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
						.addComponent(isAudioEnabledCheckbox))
					.addGap(18)
					.addComponent(lblCleanup, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblMergeCommasEnabled, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
						.addComponent(isMergeCommasEnabledCheckbox, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
					.addGap(5)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblLanguages, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtSubtitleLanguages, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(buttonCancel)
						.addComponent(btnNext))
					.addContainerGap())
		);
		setLayout(groupLayout);
		
		btnNext.addActionListener((ActionEvent e) -> {
			/*
			ConfigurationTable config = ConfigurationTable.getConfigurationTable();
			boolean isMergeCommasEnabled = isMergeCommasEnabledCheckbox.isSelected();
			config.setMergeCommasEnabled(isMergeCommasEnabled);
			boolean isMergeAudioEnabled = isAudioEnabledCheckbox.isSelected();
			config.setAudioEnabled(isMergeAudioEnabled);
			SubtitleType subtitleFileFormat = (SubtitleType) subtitleFileFormatCombobox.getSelectedItem(); 
			config.setSubtitleFormat(subtitleFileFormat);
			System.out.println("Commas: "+isMergeCommasEnabled+", Audio: "+isMergeAudioEnabled+ ", Type: "+subtitleFileFormat);
			 */
			//No Logic in View ;) Handle that in Controller with getters of relevanted Items
			getViewController().nextHasBeenClicked();
		});
		buttonCancel.addActionListener((ActionEvent e) -> {
			getViewController().cancelHasBeenClicked();
		});

	}
}
