package frontend_viewcontroller;

import backend_models.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Enumeration;
import javax.swing.JRadioButton;

/**
 * This class is responsible for manipulating the data in the backend, and
 * letting the user otherwise control the GUI on the screen.
 *
 * Responsibilities of this class include:
 *
 * (1) Ask the MainViewDisplay object to change the GUI on the screen in
 * response to user input actions (without modifying any data in the backend).
 *
 * (2) Ask the backend models to modify its data, and also ask the
 * MainViewDisplay object to update the GUI on the screen (to match the data in
 * the backend), in response to user input actions.
 *
 * There should be no code here directly about painting graphics on the screen!
 * That belongs in the MainViewDisplay class.
 *
 * There should also be no code here directly about modeling the problem or
 * situation your program solves.
 *
 * All problem or situation modeling related code must go in the backend classes
 *
 * The FOUR (4) main steps to creating GUI widgets are labeled below. There are
 * many smaller steps you should get familiar with as well.
 *
 * @author cheng
 */
public class ModelsAndViewsController {

    /*
     *
     * ModelsAndViewsController needs to have an instance variable to reference
     * the backend's models because the frontend's ModelsAndViewsController is
     * responsible for asking the backend to modify its data.
     *
     * Since the backend models is initially set up by an instance of the
     * BackendModelSetup class, we just need this one instance variable here:
     */
    BackendModelSetup theBackendModel;
    /*
     *
     * This class also needs to have an instance variable to reference the
     * frontend's MainViewDisplay because the ModelsAndViewsController object is
     * responsible for asking the MainViewDisplay object to update itself.
     */
    MainViewDisplay theMainViewDisplay;

    /*
     *
     * Step 1 of 2 to provide user controls: write user action as private class
     * ------------------------------------------------------------------------
     *
     * User actions are written as private inner classes that implement
     * ActionListener, and override the actionPerformed method.
     *
     * Use the following as a template for writting more user actions.
     */
    private class OpenFileAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            try {
                String pathToFile = theMainViewDisplay.showOpenDialog();
                if (pathToFile == null) {
                    return;
                }

                theBackendModel.thePowList.openFromFile(pathToFile);
                theMainViewDisplay.clearPowDisplay();
            } catch (IOException ex) {
                System.err.println(ex);
            }
        }
    }

    private class SaveToFileAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            try {
                String pathToFile = theMainViewDisplay.showSaveDialog();
                if (pathToFile == null) {
                    return;
                }

                theBackendModel.thePowList.saveToFile(pathToFile);
            } catch (IOException ex) {
                System.err.println(ex);
            }
        }
    }

    private class ClearPowDisplayAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            theMainViewDisplay.clearPowDisplay();
        }
    }

    private class GetPowInfoAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            Object powObj = theMainViewDisplay.powJListForScrollPane.getSelectedValue();
            PowPerson aPow = (PowPerson) powObj;
            int serial = aPow.getSerial();
            theMainViewDisplay.showPowInfo(serial);
        }
    }

    private class SetPowInfoAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            String serialStr = theMainViewDisplay.serialField.getText();
            if (serialStr.equals("")) {
                return;
            }

            int serial = Integer.parseInt(serialStr);

            PowPerson aPowPerson = theBackendModel.thePowList.getPow(serial);

            if (aPowPerson != null) {
                String name = theMainViewDisplay.nameField.getText();
                aPowPerson.setName(name);

                String rank = theMainViewDisplay.rankField.getText();
                aPowPerson.setRank(rank);

                serialStr = theMainViewDisplay.serialField.getText();
                serial = Integer.parseInt(serialStr);
                aPowPerson.setSerial(serial);


                String gender = "";

                /*
                 * Two ways of checking if some radio buttons are selected.....
                 * Way #1 requires each button to be listed by name:
                 */
                /*
                 * if (maleChoiceBtn.isSelected()){ gender = "male"; } else if
                 * (femaleChoiceBtn.isSelected()){ gender = "female"; }
                 */

                /*
                 * Way #2 loops through every button in the button group and
                 * checks each button in turn by its action command String:
                 */
                Enumeration allRadioBtns = theMainViewDisplay.genderChoiceBtnGrp.getElements();
                while (allRadioBtns.hasMoreElements()) {
                    JRadioButton aBtn = (JRadioButton) allRadioBtns.nextElement();
                    if (aBtn.isSelected()) {
                        String choice = aBtn.getActionCommand();
                        if (choice.equals("f")) {
                            gender = "female";
                        } else if (choice.equals("m")) {
                            gender = "male";
                        }
                    }
                }

                /*
                 * Both ways above are left here as an example only.
                 */
                aPowPerson.setGender(gender);
            } else {
                PowPerson newPerson = new PowPerson();
                newPerson.setName(theMainViewDisplay.nameField.getText());
                newPerson.setRank(theMainViewDisplay.rankField.getText());
                newPerson.setSerial(serial);

                String gender = "";
                if (theMainViewDisplay.maleChoiceBtn.isSelected()) {
                    gender = "male";
                } else if (theMainViewDisplay.femaleChoiceBtn.isSelected()) {
                    gender = "female";
                }
                newPerson.setGender(gender);

                theBackendModel.thePowList.addPow(newPerson);
            }

            theMainViewDisplay.updatePowListDisplay();
        }
    }

    /*
     *
     * Constructor. Probably nothing for students to change.
     */
    public ModelsAndViewsController(BackendModelSetup aBackend, MainViewDisplay aMainViewDisplay) {
        this.theBackendModel = aBackend;
        this.theMainViewDisplay = aMainViewDisplay;
        this.initController();
    }

    /*
     *
     * Step 2 of 2 to provide user controls: wire user action to GUI widgets
     * ----------------------------------------------------------------------
     *
     * Once a private inner class has been written for a user action, you can
     * wire it to a GUI widget (i.e. one of the GUI widgets you created in the
     * MainViewDisplay class and which you gave a memorable variable name!).
     *
     * Use the following as templates for wiring in more user actions.
     */
    private void initController() {
        this.theMainViewDisplay.getPowButton.addActionListener(new GetPowInfoAction());
        this.theMainViewDisplay.setPowInfoButton.addActionListener(new SetPowInfoAction());
        this.theMainViewDisplay.clearButton.addActionListener(new ClearPowDisplayAction());
        this.theMainViewDisplay.saveButton.addActionListener(new SaveToFileAction());
        this.theMainViewDisplay.openButton.addActionListener(new OpenFileAction());
    }
}
