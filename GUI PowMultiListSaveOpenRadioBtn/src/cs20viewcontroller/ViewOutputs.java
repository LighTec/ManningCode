package cs20viewcontroller;

/**
 * Write methods in this class for displaying data in the DrawnView.
 *
 * You can use all the public instance variables you defined in AllModelsForView
 * and DrawnView as though they were part of this class! This is due to the
 * magic of subclassing (i.e. using the extends keyword).
 *
 * The methods for displaying data in the DrawnView are written as methods in
 * this class.
 *
 * Make sure to use these methods in the ViewUserActions class though, or else
 * they will be defined but never used!
 *
 * @author cheng
*/

public class ViewOutputs extends DrawnView {

    public void numResult() {
        int resultInt = this.CalcSimple.getResult();
        String result = "" + resultInt;
        Answer.setText(result);
    }
}
