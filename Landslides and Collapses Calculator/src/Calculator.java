import javax.swing.*;
import java.math.BigDecimal;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Calculator {
    // TT == Text Translation
    private NewFrame newFrame;
    String input;
    public Calculator(NewFrame newFrame) throws InterruptedException {
        this.newFrame = newFrame;

        Scanner reader = new Scanner(System.in);
        BigDecimal frequency;
        System.out.println("Enter the frequency of occurrence of landslides/collapses (from 0.000001 to 0.2)"); // ТТ: Въведете число на честотата на възникване на свлачища
        //newFrame.getTextArea().append("\n"+ "Enter the frequency of occurrence of landslides/collapses (from 0.000001 to 0.2)");
        newFrame.getTextArea().append("\n"+ "Въведете честотата на възникване на свлачища и срутища (от 0.000001 до 0.2)");
        while (true){
            try{
                while(true){
                    if(newFrame.getInputNum()!=null){
                        input = newFrame.getInputNum();
                        break;
                    }
                    else{
                        Thread.sleep(1000);
                        System.out.println("Waiting");
                    }
                }
                frequency = new BigDecimal(input);
            }catch (InputMismatchException | NumberFormatException | InterruptedException e){
                System.out.println("Please enter a number within the boundaries");
                //JOptionPane.showMessageDialog(newFrame,"Please enter a number within the boundaries!","Wrong input", JOptionPane.PLAIN_MESSAGE);
                JOptionPane.showMessageDialog(newFrame,"Въведете число в границите!","Грешно число", JOptionPane.PLAIN_MESSAGE);
                newFrame.setInputNum(null);
                continue;
            }
            if(frequency.compareTo(new BigDecimal("0.2"))<=0 && frequency.compareTo(new BigDecimal("0.000001"))>=0){
                measureRisk(frequency);
                newFrame.setInputNum(null);
                break;
            }
            else {
                System.out.println("Please enter a number within the boundaries"); // ТТ: Моля въведете чусло между границите.
                //JOptionPane.showMessageDialog(newFrame,"Please enter a number within the boundaries!","Wrong input", JOptionPane.PLAIN_MESSAGE);
                JOptionPane.showMessageDialog(newFrame,"Въведете число в границите!","Грешно число", JOptionPane.PLAIN_MESSAGE);
                newFrame.setInputNum(null);
            }
        }
    }
    public void measureRisk(BigDecimal freq) throws InterruptedException {
        if(freq.compareTo(new BigDecimal("0.1"))>=0){
            //HigherRisk veryHighRisk = new HigherRisk("very high", newFrame);
            HigherRisk veryHighRisk = new HigherRisk("много високо", newFrame);
        }
        else if(freq.compareTo(new BigDecimal("0.1"))<0 && freq.compareTo(new BigDecimal("0.01"))>=0){ // 0.1>freq>=0.01
            System.out.println("H - high level of risk");
            //HigherRisk highRisk = new HigherRisk("high",newFrame);
            HigherRisk highRisk = new HigherRisk("високо",newFrame);
        }
        else if(freq.compareTo(new BigDecimal("0.01"))<0 && freq.compareTo(new BigDecimal("0.001"))>=0){ //0.01>freq>=0.001
            System.out.println("M - Medium level of risk");
            //LowerRisk mediumRisk = new LowerRisk("medium",newFrame);
            LowerRisk mediumRisk = new LowerRisk("средно",newFrame);
        }
        else if(freq.compareTo(new BigDecimal("0.001"))<0 && freq.compareTo(new BigDecimal("0.0001"))>=0){ //0.001>freq>=0.0001
            System.out.println("L - Low level of risk");
            //LowerRisk lowRisk = new LowerRisk("low", newFrame);
            LowerRisk lowRisk = new LowerRisk("ниско", newFrame);
        }
        else if(freq.compareTo(new BigDecimal("0.0001"))<0 && freq.compareTo(new BigDecimal("0.00001"))>=0){ //0.0001>freq>=0.00001
            System.out.println("VL - very low level of risk");
            //LowerRisk veryLowRisk = new LowerRisk("very low", newFrame);
            LowerRisk veryLowRisk = new LowerRisk("много ниско", newFrame);
        }
        else if(freq.compareTo(new BigDecimal("0.00001"))<0){   //freq<0.00001
            System.out.println("Acceptable risk");
            //newFrame.restartProgram(newFrame,"Acceptable risk.\n");
            newFrame.restartProgram(newFrame,"Приемлив риск.\n");
            // END PROGRAM
        }
    }

}


