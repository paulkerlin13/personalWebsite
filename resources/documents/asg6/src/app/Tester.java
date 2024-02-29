package app;

import controller.NavigableDocController;
import model.NavigableDocModel;
import model.Pair;
import view.NavigableDocView;

public class Tester {

    //Main that will start up the GUI and make it visible
    public static void main(String[] args) {
        NavigableDocModel model = new NavigableDocModel();
        NavigableDocView view = new NavigableDocView();
        NavigableDocController controller = new NavigableDocController(model,view);
        view.setVisible(true);

        /*NavigableDocModel<String> s = new NavigableDocModel<>(); // $
        s.insertNewItemRt("c"); // $ c
        s.insertNewItemRt("b"); // $ b c
        s.insertNewItemRt("a");
        System.out.println(s);

        s.forward();
        System.out.println(s);

        s.forward();
        System.out.println(s);


        s.reset();
        System.out.println("reset: " + s);
        System.out.println(s.contains("c").first);
        System.out.println(s.contains("c").second);*/
    }

}
