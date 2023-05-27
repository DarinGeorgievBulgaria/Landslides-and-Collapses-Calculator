import javax.swing.*;
import java.math.BigDecimal;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * This class is for Medium (M), Low (L) and Very Low (VL) level of risk.
 * It implements the Risk interface and the printInfo() method is overridden.
 */
public class LowerRisk implements Risk{
    private String level;
    private NewFrame frame;
    /**
     * This constructor contains the functionality for medium, low, very low levels of risk.
     * @param level - String for the level of risk. Works with "very high" and "high".
     * @param frame - NewFrame object needs to be passed.
     * @throws InterruptedException
     */
    public LowerRisk(String level, NewFrame frame) throws InterruptedException {
        this.level = level;
        this.frame = frame;
        frame.getTextArea().setText("");
        frame.setInputNum(null);
        if(level.equals("medium")){
            residualAndAcceptableRisk(level);
        }
        else if(level.equals("low")){
            residualAndAcceptableRisk(level);
        }
        else if(level.equals("very low")){
            residualAndAcceptableRisk(level);
        }
    }
    /**
     * This method is overridden from the Risk interface. It displays informative text on the frame.
     * @param level - level of risk
     */
    @Override
    public void printInfo(String level) {
        System.out.println("That is "+ level + " level of risk"); // ТТ: МВ - Много високо ниво на риск.
        System.out.println("Determination of preventive construction and installation works on the site to reduce the "+ level + " level of risk"); // ТТ: Определяне на превантивни строително монтажни работи  на обекта за намаляване нивото на риска
        System.out.println("Determining the type of personal protective equipment");
        frame.getTextArea().setText("That is " + level +  " level of risk. \n");
        frame.getTextArea().append("Determination of preventive construction and installation works on the site to reduce the "+ level + " level of risk. \n");
        frame.getTextArea().append("Determining the type of personal protective equipment. \n");
    }

    /**
     * This method is to take and compare the residual and the acceptable risk.
     * @param newLevel - this is the level of risk, and it is used in the printInfo() method.
     * @throws InterruptedException
     */
    public void residualAndAcceptableRisk(String newLevel) throws InterruptedException {
        printInfo(newLevel);
        BigDecimal residualRisk;
        BigDecimal acceptableRisk;
        String input;
        System.out.println("Enter the value of residual risk (to 0.00001)"); // ТТ:
        frame.getTextArea().append("Enter the value of residual risk (to 0.00001)");
        while (true) {
            residualRisk = frame.getBigDecimal();
            if(residualRisk.compareTo(new BigDecimal("0.00001"))>=0){
                frame.setInputNum(null);
                break;
            }
            else {
                System.out. println("Please use a number within the boundaries");
                JOptionPane.showMessageDialog(frame,"Please use a number not lower than 0.00001!","Wrong input", JOptionPane.PLAIN_MESSAGE);
                frame.setInputNum(null);
            }
        }
        printInfo(level);
        frame.getTextArea().append("Enter the value of acceptable risk (to 0.0001)");
        System.out.println("Enter the value of acceptable risk (to 0.0001)"); // ТТ:
            while (true){
                acceptableRisk = frame.getBigDecimal();
                if(acceptableRisk.compareTo(new BigDecimal("0.0001"))>=0){
                    frame.setInputNum(null);
                    break;
                }
                else {
                    System.out.println("Please enter a number within the boundaries"); // ТТ: Моля въведете чусло между границите.
                    JOptionPane.showMessageDialog(frame,"Please use a number not lower than 0.00001!","Wrong input", JOptionPane.PLAIN_MESSAGE);
                    frame.setInputNum(null);
                }
            }
            if(residualRisk.compareTo(acceptableRisk)<=0){
                System.out.println("Tolerable level of residual risk");
                //END !!!!
                frame.restartProgram(frame, "Tolerable level of residual risk.\n");
            }
            if(residualRisk.compareTo(acceptableRisk)>0){
                System.out.println("The type of personal protective equipment have to be reconsidered.");
                JOptionPane.showMessageDialog(frame,"The type of personal protective equipment have to be reconsidered.\nThe residual risk needs to be lower than the acceptable risk\n","Wrong input", JOptionPane.PLAIN_MESSAGE);
                residualAndAcceptableRisk(level);
            }
            else{
                System.out.println("Error");
            }
        }

    /**
     * This is a GET method for the string of the level of risk.
     * @return level which is a string
     */
    public String getLevel(){
        return level;
    }

    /**
     * This is a SET method which is to modify the level of risk.
     * @param str this is the new level of risk
     */
    public void setLevel(String str){
        this.level = str;
    }

}
