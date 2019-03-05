package svp.gui.main;

import java.awt.CardLayout;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import svp.data.files.FileChooser;
import svp.data.main.ConfigurationTable;
import svp.data.main.SubtitleType;
import svp.gui.controller.IConfigurationViewController;
import svp.gui.controller.IFileChooserViewController;
import svp.gui.controller.ISubtitleReviewViewController;
import svp.gui.view.ConfigurationView;
import svp.gui.view.FileChooserView;
import svp.gui.view.IConfigurationView;
import svp.gui.view.IFileChooserView;
import svp.gui.view.ISubtitleReviewView;
import svp.gui.view.SubtitleReviewView;

public class MainPane extends JPanel {
    protected static final String CONFIGURATION_VIEW = "View.configuration";
    protected static final String FILE_CHOOSER_VIEW = "View.file";
    protected static final String SUBTITLE_REVIEW_VIEW = "View.review";

    private CardLayout cardLayout;

    private IConfigurationView configurationView;
    private IFileChooserView fileChooserView;
    private ISubtitleReviewView subtitleReviewView;

    public MainPane() {
        cardLayout = new CardLayout();
        setLayout(cardLayout);

        // This could be established via a factory or builder pattern
        configurationView = new ConfigurationView(new ConfigurationViewController());
        fileChooserView = new FileChooserView(new FileChooserViewController());
        subtitleReviewView = new SubtitleReviewView(new SubtitleReviewViewController());

        add(configurationView.getView(), CONFIGURATION_VIEW);
        add(fileChooserView.getView(), FILE_CHOOSER_VIEW);
        add(subtitleReviewView.getView(), SUBTITLE_REVIEW_VIEW);
        
        cardLayout.show(this, CONFIGURATION_VIEW);
    }

    protected class ConfigurationViewController implements IConfigurationViewController {
    	ConfigurationTable config = ConfigurationTable.getConfigurationTable();

        @Override
        public void nextHasBeenClicked() {
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
			cardLayout.show(MainPane.this, SUBTITLE_REVIEW_VIEW);
			System.out.println("Boy?");
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
    
    protected class SubtitleReviewViewController implements ISubtitleReviewViewController {
    	ConfigurationTable config = ConfigurationTable.getConfigurationTable();

		@Override
		public void nextHasBeenClicked() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void backHasBeenClicked() {
			cardLayout.show(MainPane.this, FILE_CHOOSER_VIEW);
		}
		
		@Override
		public void cancelHasBeenClicked() {
			// TODO Auto-generated method stub
			
		}
    	
    }
}
