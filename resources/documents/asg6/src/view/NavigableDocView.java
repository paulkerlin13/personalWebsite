package view;

import javax.swing.*;

public class NavigableDocView extends JFrame {
    //fields
    public NavigableDocGui form;

    /**
     * Constructor that sets up the view of the GUI
     */
    public NavigableDocView(){
        this.form = new NavigableDocGui();
        JPanel content = form.getMyPanel();

        this.setContentPane(content);
        this.pack();
        this.setTitle("My Cursor");
        this.form.getListBox().setText("$");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

}
