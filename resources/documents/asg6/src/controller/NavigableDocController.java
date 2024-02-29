package controller;

import model.NavigableDocModel;
import model.Side;
import view.NavigableDocView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NavigableDocController<T> {
    //fields
    private NavigableDocView view;
    private NavigableDocModel model;

    /**
     * NavigableDocController constructor that stores the view and model
     * @param model
     * @param view
     */
    public NavigableDocController(NavigableDocModel model, NavigableDocView view) {
        this.model = model;
        this.view = view;

        /**
         * ADD BUTTON
         */
        view.form.getAddButton().addActionListener(e -> {
            //pulls the data from the text field
            String addedData = view.form.getTextBox().getText();
            //checks the input isn't empty
            if(addedData.equals("")){
                JOptionPane.showMessageDialog(view, "Error: You must enter an item to add it.");
                return;
            }

            //inserts the item
            model.insertNewItemRt(addedData);

            //clears the text box
            view.form.getTextBox().setText("");

            //clears and updates the list box
            view.form.getListBox().setText("");
            view.form.getListBox().setText(model.toString());

        });

        /**
         * FORWARD BUTTON
         */
        view.form.getForwardButton().addActionListener(e -> {
            //validation to check if the cursor is as far right as it can go
            if(model.getRightHead() == null){
                JOptionPane.showMessageDialog(view, "Error: The cursor is already all the way right.");
            }
            //calls the forward method then updates the list box
            model.forward();
            view.form.getListBox().setText(model.toString());
        });

        /**
         * RESET BUTTON
         */
        view.form.getResetButton().addActionListener(e -> {
            if(model.getLeftHead() == null){
                JOptionPane.showMessageDialog(view, "You already are reset.");
            }

            //calls the reset method then updates the list box
            model.reset();
            view.form.getListBox().setText(model.toString());
        });

        /**
         * CONTAINS BUTTON
         */
        view.form.getContainsButton().addActionListener(e -> {
            //gets item you are looking for
            String inputData = view.form.getTextBox().getText();
            Side first = (Side) model.contains(inputData).first;
            Integer second = (Integer) model.contains(inputData).second;
            //validates you inputted something
            if(inputData.equals("")){
                JOptionPane.showMessageDialog(view, "Error: You must enter an item to check for it.");
                return;
            }
            //Displays message if the item was found on the right side
            if(first.equals(Side.RIGHT)) {
                JOptionPane.showMessageDialog(view, "Item: " + inputData + " appears on the RIGHT side at index: " + second);
            }
            //Displays message if the item was found on the left side
            else if (first.equals(Side.LEFT)) {
                JOptionPane.showMessageDialog(view, "Item: " + inputData + " appears on the LEFT side at index: " + second);
            }
            //Displays message if the item was found on both side
            else if(first.equals(Side.BOTH)) {
                JOptionPane.showMessageDialog(view, "Item: " + inputData + " appears on the BOTH sides, the left index is: " + second);
            }
            //Displays message if the item was not found
            else if(first.equals(Side.NONE)){
                JOptionPane.showMessageDialog(view, "Item: " + inputData + " doesn't appear.");
            }
        });
    }
}
