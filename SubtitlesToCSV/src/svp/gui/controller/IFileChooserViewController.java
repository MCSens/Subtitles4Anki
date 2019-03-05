package svp.gui.controller;

public interface IFileChooserViewController extends IViewController {

	public void backHasBeenClicked();

	public void nextHasBeenClicked();

    public void cancelHasBeenClicked();
    
    public void selectSubtitleFilePathHasBeenClicked();

    public void selectAudioFilePathHasBeenClicked();
    
    public void selectOutputFolderHasBeenClicked();
}