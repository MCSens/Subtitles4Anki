package svp.gui.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import svp.data.main.SubtitleType;
import svp.gui.controller.IConfigurationViewController;


public class ConfigurationView extends AbstractView<IConfigurationViewController> implements IConfigurationView {

	private static final long serialVersionUID = 6919806929256943883L;
	private JComboBox<SubtitleType> subtitleFileFormatCombobox;
    private JCheckBox isAudioEnabledCheckbox;
    private JCheckBox isMergeCommasEnabledCheckbox;
    private JCheckBox isGeneratePinyinEnabledCheckbox;
    private JTextField txtMovieTitle;
    private JTextArea txtSubtitleLanguages;
    
    public JCheckBox getIsGeneratePinyinEnabledCheckbox() {
		return isGeneratePinyinEnabledCheckbox;
	}

	public void setIsGeneratePinyinEnabledCheckbox(JCheckBox isGeneratePinyinEnabled) {
		this.isGeneratePinyinEnabledCheckbox = isGeneratePinyinEnabled;
	}

    
    public JComboBox<SubtitleType> getSubtitleFileFormatCombobox() {
		return subtitleFileFormatCombobox;
	}

	public void setSubtitleFileFormatCombobox(JComboBox<SubtitleType> subtitleFileFormatCombobox) {
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

	public JTextField getTxtMovieTitle() {
		return txtMovieTitle;
	}

	public void setTxtMovieTitle(JTextField txtMovieTitle) {
		this.txtMovieTitle = txtMovieTitle;
	}

	public JTextArea getTxtSubtitleLanguages() {
		return txtSubtitleLanguages;
	}

	public void setTxtSubtitleLanguages(JTextArea txtSubtitleLanguages) {
		this.txtSubtitleLanguages = txtSubtitleLanguages;
	}

	public ConfigurationView(IConfigurationViewController controller) {
    	super(controller);
    	setBackground(new Color(47, 79, 79));
		//Themes ;)
		
		subtitleFileFormatCombobox = new JComboBox<SubtitleType>();
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
		isAudioEnabledCheckbox.setSelected(true);
		isAudioEnabledCheckbox.setBackground(new Color(47, 79, 79));
		
		JLabel lblCleanup = new JLabel("Clean Up");
		lblCleanup.setForeground(new Color(128, 128, 0));
		lblCleanup.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		JLabel lblMergeCommasEnabled = new JLabel("Merge Lines with Commas at end?");
		lblMergeCommasEnabled.setForeground(new Color(255, 250, 205));
		
		isMergeCommasEnabledCheckbox = new JCheckBox("");
		isMergeCommasEnabledCheckbox.setSelected(true);
		isMergeCommasEnabledCheckbox.setBackground(new Color(47, 79, 79));
		
		
		JButton btnNext = new JButton("Next");
		btnNext.setActionCommand("Next"); //Idea: One Method to handle all Buttons, depending on ActionCommand?
		btnNext.setBackground(new Color(192, 192, 192));
		//btnNewButton.setBackground(new Color(255, 255, 255));
		
		JButton buttonCancel = new JButton("Cancel");
		buttonCancel.setBackground(new Color(192, 192, 192));
		
		JLabel lblLanguages = new JLabel("Languages of Subtitles.");
		lblLanguages.setForeground(new Color(255, 250, 205));
		
		txtSubtitleLanguages = new JTextArea();
		txtSubtitleLanguages.setFont(new Font("Monospaced", Font.PLAIN, 11));
		txtSubtitleLanguages.setText("Hanzi;English");
		//txtSubtitleLanguages.setText("Seprate Language with ;\r\ne.g.: Hanzi; English\r\n");
		txtSubtitleLanguages.setColumns(10);
		
		JLabel lblMovieTitle = new JLabel("Movie Title");
		lblMovieTitle.setForeground(new Color(255, 250, 205));
		
		txtMovieTitle = new JTextField("Test");
		txtMovieTitle.setColumns(10);
		
		isGeneratePinyinEnabledCheckbox = new JCheckBox("");
		isGeneratePinyinEnabledCheckbox.setSelected(true);
		isGeneratePinyinEnabledCheckbox.setBackground(new Color(47, 79, 79));
		
		JLabel lblConvertPinyin = new JLabel("Generate Column with Pinyin");
		lblConvertPinyin.setForeground(new Color(255, 250, 205));
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
							.addGroup(groupLayout.createSequentialGroup()
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
									.addComponent(lblGeneral)
									.addGroup(groupLayout.createSequentialGroup()
										.addGap(10)
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
											.addGroup(groupLayout.createSequentialGroup()
												.addComponent(lblSelectSubtitleFile, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE)
												.addGap(96)
												.addComponent(subtitleFileFormatCombobox, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE))
											.addGroup(groupLayout.createSequentialGroup()
												.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
													.addComponent(lblUseAudio, GroupLayout.PREFERRED_SIZE, 164, GroupLayout.PREFERRED_SIZE)
													.addComponent(lblMergeCommasEnabled, GroupLayout.PREFERRED_SIZE, 198, GroupLayout.PREFERRED_SIZE))
												.addGap(126)
												.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
													.addComponent(isMergeCommasEnabledCheckbox, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
													.addComponent(isAudioEnabledCheckbox)))))
									.addGroup(groupLayout.createSequentialGroup()
										.addGap(10)
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
											.addGroup(groupLayout.createSequentialGroup()
												.addComponent(lblConvertPinyin, GroupLayout.PREFERRED_SIZE, 198, GroupLayout.PREFERRED_SIZE)
												.addGap(126)
												.addComponent(isGeneratePinyinEnabledCheckbox, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
											.addGroup(groupLayout.createSequentialGroup()
												.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
													.addComponent(lblMovieTitle, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE)
													.addComponent(lblLanguages, GroupLayout.PREFERRED_SIZE, 173, GroupLayout.PREFERRED_SIZE))
												.addGap(34)
												.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
													.addComponent(txtSubtitleLanguages, GroupLayout.PREFERRED_SIZE, 270, GroupLayout.PREFERRED_SIZE)
													.addComponent(txtMovieTitle, 270, 270, 270))))))
								.addContainerGap(53, Short.MAX_VALUE))
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(lblCleanup, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
								.addContainerGap(433, Short.MAX_VALUE)))
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addComponent(btnNext, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(buttonCancel, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())))
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
						.addComponent(isAudioEnabledCheckbox)
						.addComponent(lblUseAudio, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addComponent(lblMergeCommasEnabled, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblCleanup, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblMovieTitle, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtMovieTitle, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addComponent(isMergeCommasEnabledCheckbox, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(13)
							.addComponent(lblLanguages, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(18)
							.addComponent(txtSubtitleLanguages, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)))
					.addGap(11)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblConvertPinyin, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
						.addComponent(isGeneratePinyinEnabledCheckbox, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
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
			
			System.out.println(e.getActionCommand());
			getViewController().nextHasBeenClicked();
		});
		
		buttonCancel.addActionListener((ActionEvent e) -> {
			getViewController().cancelHasBeenClicked();
		});

	}
}
