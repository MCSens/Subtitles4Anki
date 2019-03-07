package svp.gui.main;

import java.awt.CardLayout;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import svp.data.filereader.AudacityFileReader;
import svp.data.main.ConfigurationTable;
import svp.data.main.SubtitleDataholder;
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
import svp.util.CSVGenerator;
import svp.util.FileChooser;
import svp.util.MP3Splitter;

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
    	SubtitleDataholder subtitleDataholder = SubtitleDataholder.getSubtitleDataholder();

        @Override
        public void nextHasBeenClicked() {
			boolean isMergeCommasEnabled = ((ConfigurationView)configurationView).getIsMergeCommasEnabledCheckbox().isSelected();
			config.setMergeCommasEnabled(isMergeCommasEnabled);
			
			boolean isAudioEnabled = ((ConfigurationView)configurationView).getIsAudioEnabledCheckbox().isSelected();
			config.setAudioEnabled(isAudioEnabled);
			
			SubtitleType subtitleFileFormat = (SubtitleType) ((ConfigurationView)configurationView).getSubtitleFileFormatCombobox().getSelectedItem(); 
			config.setSubtitleFormat(subtitleFileFormat);
			
			String movieTitle = ((ConfigurationView)configurationView).getTxtMovieTitle().getText();
			config.setMovieTitle(movieTitle);
			
			String languagesString = ((ConfigurationView)configurationView).getTxtSubtitleLanguages().getText();
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

    protected class FileChooserViewController implements IFileChooserViewController {
    	ConfigurationTable config = ConfigurationTable.getConfigurationTable();
    	
		@Override
		public void backHasBeenClicked() {
			cardLayout.show(MainPane.this, CONFIGURATION_VIEW);
		}

		@Override
		public void nextHasBeenClicked() {
			//Start Processing of data and after that open SUBTITLE View to display the result
			String pathToSubtitleFile = ((FileChooserView)fileChooserView).getTxtSubtitleFile().getText();
			String pathToAudioFile = ((FileChooserView)fileChooserView).getTxtAudioFile().getText();
			String pathToOutputFolder = ((FileChooserView)fileChooserView).getTxtOutputFolder().getText();
			config.setPathToSubtitleFile(pathToSubtitleFile);
			config.setPathToAudioFile(pathToAudioFile);
			config.setPathToOutputFolder(pathToOutputFolder);
			
			String subtitleType = config.getSubtitleFormat().name();
			switch(subtitleType){
			case "Audacity":
				AudacityFileReader afr = new AudacityFileReader();
				afr.readFile();
				afr.mergeCommas();
				break;
			case "SubRip":
				System.out.println("Youtube");
				break;
			}
			
			cardLayout.show(MainPane.this, SUBTITLE_REVIEW_VIEW);
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
			MP3Splitter.splitMP3File();
			CSVGenerator.createCSV();
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
