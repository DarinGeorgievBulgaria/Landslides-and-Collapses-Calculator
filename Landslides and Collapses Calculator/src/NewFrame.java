import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.util.InputMismatchException;

/**
 * This class is contains the functionality of the frame.
 * It is a sub-class of JFrame and implements ActionListener as there is a button.
 */
public class NewFrame extends JFrame implements ActionListener {
    private final JTextArea textArea;
    private final JTextField textField;
    private final JButton button;
    private String inputNum;

    /**
     * Creates the frame and adds the components to it.
     * The components are of type: JTextArea, JTextField, JButton, JPanel,
     */
    NewFrame(){
        this.setTitle("Landslides and collapses");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(500,300);

        JPanel panel = new JPanel();

        textArea = new JTextArea();
        //labelMain.setHorizontalAlignment(JLabel.CENTER);
        textArea.setEditable(false);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setFont(new Font("SansSerif", Font.PLAIN,20));
        textArea.setPreferredSize(new Dimension(450,200));
        textArea.setAlignmentX(SwingConstants.CENTER);

        textField = new JTextField(20);
        textField.setPreferredSize(new Dimension(150,30));
        textField.setHorizontalAlignment(JTextField.CENTER);

        button = new JButton("Submit");
        button.addActionListener(this);

        panel.add(textArea);
        panel.add(textField);
        panel.add(button);
        this.getContentPane().add(panel);
        this.setVisible(true);

    }

    /**
     * This is a GET method for the text area.
     * @return textArea (JTextArea)
     */
    public JTextArea getTextArea(){
        return textArea;
    }
    /**
     * This is a GET method for the text field.
     * @return textField (JTextField)
     */
    public JTextField getTextField(){
        return textField;
    }
    /**
     * This is a GET method for the button.
     * @return button (JButton)
     */
    public JButton getButton(){
        return button;
    }
    /**
     * This is a GET method for the input number.
     * @return inputNum (String)
     */
    public String getInputNum(){
        return inputNum;
    }

    /**
     * This is a SET method to change the input number.
     * It is used to change it to null.
     * @param inputNum - new value of inputNum
     */
    public void setInputNum(String inputNum){
        this.inputNum = inputNum;
    }

    /**
     * NEEDS TO BE MODIFIED
     * This method is used to restart the program when it reaches its end.
     * Easy way to start the program from the beginning. IT WILL BE CHANGED LATER ON.
     * @param frame - instance of NewFrame needs to be passed.
     * @param text - String to be displayed on the frame
     * @throws InterruptedException
     */
    public void restartProgram(NewFrame frame, String text) throws InterruptedException {
        frame.getTextArea().setText(text);
        for(int i=5; i>-1;i--){
            Thread.sleep(1000);
            frame.getTextArea().append(i+"\n");
        }
        frame.dispose();
        Main.main(null);
    }

    /**
     * Method to wait until a number is inputted.
     * @return the number is returned as String
     * @throws InterruptedException
     */
    public String getInput() throws InterruptedException {
        while(true){
            if(inputNum != null){
                break;
            }
            else{
                Thread.sleep(500);
                System.out.println("Waiting for input");
            }
        }
        return inputNum;
    }

    /**
     * Method to get real numbers as input. It checks if the number is positive and catches the cases where the number is not an int.
     * @return returnRealNum - returns a real number,
     */
    public int getRealNum(){
        int returnRealNum;
        while (true){
            try{
                returnRealNum = Integer.parseInt(getInput());
            }catch (InputMismatchException | NumberFormatException | InterruptedException  e){
                System.out.println("Please use a natural number1.");
                JOptionPane.showMessageDialog(this,"Please use a natural number!","Wrong input", JOptionPane.PLAIN_MESSAGE);
                this.setInputNum(null);
                continue;
            }
            if(returnRealNum >= 0){
                this.setInputNum(null);
                break;
            }
            else{
                System.out.println("Please use a natural number.");
                JOptionPane.showMessageDialog(this,"Please use a natural number!","Wrong input", JOptionPane.PLAIN_MESSAGE);
                this.setInputNum(null);
            }
        }
        return returnRealNum;
    }

    /**
     * Method to get a Big Decimal from input. Checks if the inputted value is appropriate type.
     * @return returnBD - returns a Big Decimal
     */
    public BigDecimal getBigDecimal(){
        BigDecimal returnBD = null;
        try {
            returnBD = new BigDecimal(getInput());
        } catch (InputMismatchException | InterruptedException | NumberFormatException | NullPointerException e) {
            System.out.println("Please enter a number within the boundaries");
            JOptionPane.showMessageDialog(this, "Please enter a number within the boundaries!", "Wrong input", JOptionPane.PLAIN_MESSAGE);
            setInputNum(null);
            getBigDecimal();
        }
        return returnBD;
    }

    /**
     * This is action listener method for the button which takes the value from the text field and sets it to empty.
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==button){
            inputNum = textField.getText();
            textField.setText("");
        }
    }
}
