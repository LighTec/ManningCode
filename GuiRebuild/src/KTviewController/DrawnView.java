/*
 * WARNING: There is nothing in this file for students to edit or change.
 *          This file is intended to have no student-serviceable code.
 *
 * "Draw" your GUI using the "Design" tab, and remember to give
 * them memorable variable names in the "Properties" panel
 * as well as make them public variables.
 * 
 * For convenience, you may want to set the default visibility of 
 * GUI elements to be public by going to:
 *    The NetBeans Preferences or Settings menu -> Miscellaneous -> GUI Builder
 * Then set Variables Modifier to public.
 */
package KTviewController;

import KTmodels.AllModelsForView;

/**
 * WARNING: Do NOT modify or write any code in this file!
 *
 * @author cheng
 */
public class DrawnView extends AllModelsForView {
    // WARNING: Do NOT modify or write any code in this file!
    // <editor-fold defaultstate="collapsed" desc="Generated Code">

    public DrawnView() {
        initComponents();
    }// </editor-fold>

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jRadioButton1 = new javax.swing.JRadioButton();
        jToggleButton1 = new javax.swing.JToggleButton();
        textField1 = new java.awt.TextField();
        number1 = new javax.swing.JTextField();
        number2 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        AddButton = new javax.swing.JButton();
        SubtractButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        Answer = new javax.swing.JLabel();
        Button = new javax.swing.JButton();

        jRadioButton1.setText("jRadioButton1");

        jToggleButton1.setText("jToggleButton1");

        textField1.setText("textField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        number1.setText("Number 1");
        number1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                number1ActionPerformed(evt);
            }
        });

        number2.setText("Number 2");

        jLabel1.setText("Please enter 2 numbers:");

        AddButton.setText("Add");

        SubtractButton.setText("Subtract");
        SubtractButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SubtractButtonActionPerformed(evt);
            }
        });

        jLabel2.setText("Answer:");

        Answer.setText("0");

        Button.setText("Push ME");

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(layout.createSequentialGroup()
                        .add(jLabel1)
                        .add(34, 34, 34)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                            .add(number1)
                            .add(number2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)))
                    .add(layout.createSequentialGroup()
                        .add(jLabel2)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(Answer, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 102, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(Button, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 255, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                    .add(layout.createSequentialGroup()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                            .add(SubtractButton)
                            .add(AddButton))
                        .add(33, 33, 33)))
                .add(17, 17, 17))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(26, 26, 26)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(number1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 42, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(number2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 42, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel2)
                    .add(Answer))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(AddButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 35, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(SubtractButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 35, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(56, 56, 56)
                .add(Button, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 101, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SubtractButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SubtractButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SubtractButtonActionPerformed

    private void number1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_number1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_number1ActionPerformed
    // WARNING: Do NOT modify or write any code in this file!
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton AddButton;
    public javax.swing.JLabel Answer;
    public javax.swing.JButton Button;
    public javax.swing.JButton SubtractButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JToggleButton jToggleButton1;
    public javax.swing.JTextField number1;
    public javax.swing.JTextField number2;
    private java.awt.TextField textField1;
    // End of variables declaration//GEN-END:variables
}
