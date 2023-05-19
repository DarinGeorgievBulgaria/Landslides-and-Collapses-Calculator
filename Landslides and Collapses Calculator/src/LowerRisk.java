import javax.swing.*;
import java.math.BigDecimal;
import java.util.InputMismatchException;
import java.util.Scanner;

public class LowerRisk implements Risk{
    private String level;
    private NewFrame frame;
    public LowerRisk(String level, NewFrame frame){
        this.level = level;
        this.frame = frame;
        frame.getTextArea().setText("");
        frame.setInputNum(null);
        if(level.equals("medium")){
            printInfo(level);
            residualRisk();
        }
        else if(level.equals("low")){
            printInfo(level);
            residualRisk();
        }
        else if(level.equals("very low")){
            printInfo(level);
            residualRisk();
        }
    }
    @Override
    public void printInfo(String level) {
        System.out.println("That is "+ level + " level of risk"); // ТТ: МВ - Много високо ниво на риск.
        System.out.println("Determination of preventive construction and installation works on the site to reduce the "+ level + " level of risk"); // ТТ: Определяне на превантивни строително монтажни работи  на обекта за намаляване нивото на риска
        System.out.println("Determining the type of personal protective equipment");
        frame.getTextArea().setText("That is" + level +  "level of risk \n");
        frame.getTextArea().append("Determination of preventive construction and installation works on the site to reduce the "+ level + " level of \n");
        frame.getTextArea().append("Determining the type of personal protective equipment. \n");
    }

    public void residualRisk(){
        Scanner reader = new Scanner(System.in);
        BigDecimal residualRisk;
        BigDecimal acceptableRisk;
        String input;
        System.out.println("Enter the value of residual risk (to 0.00001)"); // ТТ:
        frame.getTextArea().append("Enter the value of residual risk (to 0.00001)");
        while (true) {
            try {
                while (true) {
                    if (frame.getInputNum() != null) {
                        input = frame.getInputNum();
                        break;
                    } else {
                        Thread.sleep(1000);
                        System.out.println("Waiting");
                    }
                }
                residualRisk = new BigDecimal(input);
            } catch (InputMismatchException | InterruptedException | NumberFormatException e) {
                System.out.println("Please enter a number within the boundaries");
                JOptionPane.showMessageDialog(frame, "Please use a natural number1!", "Wrong input", JOptionPane.PLAIN_MESSAGE);
                frame.setInputNum(null);
                continue;
            }
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
                try{
                    while (true){
                        if(frame.getInputNum()!=null){
                            input = frame.getInputNum();
                            break;
                        }
                        else{
                            Thread.sleep(1000);
                            System.out.println("Waiting");
                        }
                    }
                    acceptableRisk = new BigDecimal(input);
                }catch (InputMismatchException | NumberFormatException | InterruptedException e){
                    System.out.println("Please enter a number within the boundaries");
                    JOptionPane.showMessageDialog(frame,"Please use a number not lower than 0.00001!","Wrong input", JOptionPane.PLAIN_MESSAGE);
                    frame.setInputNum(null);
                    continue;
                }
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
                frame.getTextArea().setText("Tolerable level of residual risk.");
                //END !!!!
            }
            if(residualRisk.compareTo(acceptableRisk)>0){
                System.out.println("The type of personal protective equipment have to be reconsidered.");
                residualRisk();
                // !!!!!!!!!! TUKA SI!!!!!
            }
            else{
                System.out.println("Error");
            }
        }


    public String getLevel(){
        return level;
    }
    public void setLevel(String str){
        this.level = str;
    }

}
