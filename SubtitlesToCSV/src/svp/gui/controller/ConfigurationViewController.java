package svp.gui.controller;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import svp.data.main.ConfigurationTable;
import svp.data.main.SubtitleDataholder;
import svp.data.main.SubtitleType;
import svp.gui.main.MainPane;
import svp.gui.view.ConfigurationView;

public class ConfigurationViewController implements ActionListener, IConfigurationViewController{
	ConfigurationView configurationView;
	CardLayout cardLayout;
	ConfigurationTable config = ConfigurationTable.getConfigurationTable();
	SubtitleDataholder subtitleDataholder = SubtitleDataholder.getSubtitleDataholder();
	
	public ConfigurationViewController(ConfigurationView configurationView, CardLayout cardLayout) {
		this.configurationView = configurationView;
		this.cardLayout = cardLayout;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String actionCommand = e.getActionCommand();
		switch(actionCommand) {
		case "Next":
				this.nextHasBeenClicked();
		case "Cancel":
				this.cancelHasBeenClicked();
		}
	}
	
    @Override
    public void nextHasBeenClicked() {
		boolean isMergeCommasEnabled = configurationView.getIsMergeCommasEnabledCheckbox().isSelected();
		config.setMergeCommasEnabled(isMergeCommasEnabled);
		
		boolean isAudioEnabled = configurationView.getIsAudioEnabledCheckbox().isSelected();
		config.setAudioEnabled(isAudioEnabled);
		
		SubtitleType subtitleFileFormat = (SubtitleType) configurationView.getSubtitleFileFormatCombobox().getSelectedItem(); 
		config.setSubtitleFormat(subtitleFileFormat);
		
		String movieTitle = configurationView.getTxtMovieTitle().getText();
		config.setMovieTitle(movieTitle);
		
		String languagesString = configurationView.getTxtSubtitleLanguages().getText();
		String[] languages = {"English"}; //Default language
		try {
			languages = languagesString.split(";");
		}catch(Exception e) {
			System.out.println(e.getStackTrace());
		}
		subtitleDataholder.setLanguages(languages);
		System.out.println("TRACE Commas: "+isMergeCommasEnabled+", Audio: "+isAudioEnabled+ ", Type: "+subtitleFileFormat);
        cardLayout.show(MainPane.this, FILE_CHOOSER_VIEW);
    }

    @Override
    public void cancelHasBeenClicked() {
        JOptionPane.showMessageDialog(MainPane.this, "Do you want to cancel?", "Error", JOptionPane.ERROR_MESSAGE);
    }
}
