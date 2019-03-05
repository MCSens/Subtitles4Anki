package svp.gui.view;

import javax.swing.JComponent;

import svp.gui.controller.IViewController;


public interface IView<C extends IViewController> {

    public JComponent getView();

    public C getViewController();

}
