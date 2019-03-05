package svp.gui.view;

import javax.swing.JComponent;
import javax.swing.JPanel;

import svp.gui.controller.IViewController;


public abstract class AbstractView<C extends IViewController> extends JPanel implements IView<C> {

    private C viewController;

    public AbstractView(C viewController) {
        this.viewController = viewController;
    }

    @Override
    public JComponent getView() {
        return this;
    }

    @Override
    public C getViewController() {
        return viewController;
    }

}
