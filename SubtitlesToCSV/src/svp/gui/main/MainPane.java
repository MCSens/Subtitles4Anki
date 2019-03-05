package svp.gui.main;

import java.awt.CardLayout;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import svp.files.FileChooser;
import svp.gui.controller.IConfigurationViewController;
import svp.gui.controller.IFileChooserViewController;
import svp.gui.model.ConfigurationTable;
import svp.gui.model.SubtitleType;
import svp.gui.view.ConfigurationView;
import svp.gui.view.FileChooserView;
import svp.gui.view.IConfigurationView;
import svp.gui.view.IFileChooserView;

public class MainPane extends JPanel {
    protected static final String CONFIGURATION_VIEW = "View.configuration";
    protected static final String FILE_CHOOSER_VIEW = "View.file";

    private CardLayout cardLayout;

    private IConfigurationView configurationView;
    private IFileChooserView fileChooserView;

    public MainPane() {
        cardLayout = new CardLayout();
        setLayout(cardLayout);

        // This could be established via a factory or builder pattern
        configurationView = new ConfigurationView(new ConfigurationViewController());
        fileChooserView = new FileChooserView(new FileChooserViewController());

        add(configurationView.getView(), CONFIGURATION_VIEW);
        add(fileChooserView.getView(), FILE_CHOOSER_VIEW);

        cardLayout.show(this, CONFIGURATION_VIEW);
    }

    protected class ConfigurationViewController implements IConfigurationViewController {
    	ConfigurationTable config = ConfigurationTable.getConfigurationTable();

        @Override
        public void nextHasBeenClicked() {
        	//fileChooserView.getViewController().setCredentials(name);
			boolean isMergeCommasEnabled = ((ConfigurationView)configurationView).getIsMergeCommasEnabledCheckbox().isSelected();
			config.setMergeCommasEnabled(isMergeCommasEnabled);
			
			boolean isAudioEnabled = ((ConfigurationView)configurationView).getIsAudioEnabledCheckbox().isSelected();
			config.setAudioEnabled(isAudioEnabled);
			
			SubtitleType subtitleFileFormat = (SubtitleType) ((ConfigurationView)configurationView).getSubtitleFileFormatCombobox().getSelectedItem(); 
			config.setSubtitleFormat(subtitleFileFormat);
			
			System.out.println("Commas: "+isMergeCommasEnabled+", Audio: "+isAudioEnabled+ ", Type: "+subtitleFileFormat);
            cardLayout.show(MainPane.this, FILE_CHOOSER_VIEW);
        }

        @Override
        public void cancelHasBeenClicked() {
            JOptionPane.showMessageDialog(MainPane.this, "Do you want to cancel?", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }

    protected class FileChooserViewController implements IFileChooserViewController {
    	ConfigurationTable config = ConfigurationTable.getConfigurationTable();
    	
		@Override
		public void backHasBeenClicked() {
			cardLayout.show(MainPane.this, CONFIGURATION_VIEW);
		}

		@Override
		public void nextHasBeenClicked() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void cancelHasBeenClicked() {
			JOptionPane.showMessageDialog(MainPane.this, "Do you want to cancel?", "Error", JOptionPane.ERROR_MESSAGE);
		}

		@Override
		public void selectSubtitleFilePathHasBeenClicked() {
            String path = FileChooser.pickPath();
            if(!path.equals("-1")) {
            	config.setPathToSubtitleFile(path);
            	((FileChooserView)fileChooserView).setTxtSubtitleFileText(path);
            	((FileChooserView)fileChooserView).setSubtitleFileSet(true); 
            	config.setPathToSubtitleFile(path);
            }
            else {
            	((FileChooserView)fileChooserView).setTxtSubtitleFileText("");
            	((FileChooserView)fileChooserView).setSubtitleFileSet(false); 
            	config.setPathToSubtitleFile("");
            }
		}

		@Override
		public void selectAudioFilePathHasBeenClicked() {
            String path = FileChooser.pickPath();
            if(!path.equals("-1")) {
            	config.setPathToSubtitleFile(path);
            	((FileChooserView)fileChooserView).setTxtAudioFileText(path);
            	((FileChooserView)fileChooserView).setAudioFileSet(true); 
            }
            else {
            	((FileChooserView)fileChooserView).setTxtAudioFileText("");
            	((FileChooserView)fileChooserView).setAudioFileSet(false); 
            }
		}

		@Override
		public void selectOutputFolderHasBeenClicked() {
            String path = FileChooser.pickPath();
            if(!path.equals("-1")) {
            	config.setPathToSubtitleFile(path);
            	((FileChooserView)fileChooserView).setTxtOutputFolderText(path);
            	((FileChooserView)fileChooserView).setOutputFolderSet(true); 
            }
            else {
            	((FileChooserView)fileChooserView).setTxtOutputFolderText("");
            	((FileChooserView)fileChooserView).setOutputFolderSet(false); 
            }
		}
    }
}
