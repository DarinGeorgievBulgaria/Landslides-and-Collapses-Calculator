import javax.swing.*;
import java.math.BigDecimal;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Calculator {
    // TT == Text Translation
    private NewFrame frame;
    String input;
    public Calculator(NewFrame frame) throws InterruptedException {
        this.frame = frame;

        BigDecimal frequency;
        System.out.println("Enter the frequency of occurrence of landslides/collapses (from 0.000001 to 0.2)"); // ТТ: Въведете число на честотата на възникване на свлачища
        frame.getTextArea().append("\n"+ "Enter the frequency of occurrence of landslides/collapses (from 0.000001 to 0.2)");
        while (true){
            try{
                frequency = new BigDecimal(frame.getInput());
            }catch (InputMismatchException | NumberFormatException e){
                System.out.println("Please enter a number within the boundaries");
                JOptionPane.showMessageDialog(frame,"Please enter a number within the boundaries!","Wrong input", JOptionPane.PLAIN_MESSAGE);
                frame.setInputNum(null);
                continue;
            }
            if(frequency.compareTo(new BigDecimal("0.2"))<=0 && frequency.compareTo(new BigDecimal("0.000001"))>=0){
                measureRisk(frequency);
                frame.setInputNum(null);
                break;
            }
            else {
                System.out.println("Please enter a number within the boundaries"); // ТТ: Моля въведете чусло между границите.
                JOptionPane.showMessageDialog(frame,"Please enter a number within the boundaries!","Wrong input", JOptionPane.PLAIN_MESSAGE);
                frame.setInputNum(null);
            }
        }
    }
    public void measureRisk(BigDecimal freq) throws InterruptedException {
        if(freq.compareTo(new BigDecimal("0.1"))>=0){
            HigherRisk veryHighRisk = new HigherRisk("very high", frame);
        }
        else if(freq.compareTo(new BigDecimal("0.1"))<0 && freq.compareTo(new BigDecimal("0.01"))>0){ // 0.1>freq>0.01
            System.out.println("H - high level of risk");
            HigherRisk highRisk = new HigherRisk("high",frame);
        }
        else if(freq.compareTo(new BigDecimal("0.01"))<0 && freq.compareTo(new BigDecimal("0.001"))>0){ //0.01>freq>0.001
            System.out.println("M - Medium level of risk");
            LowerRisk mediumRisk = new LowerRisk("medium",frame);
        }
        else if(freq.compareTo(new BigDecimal("0.001"))<0 && freq.compareTo(new BigDecimal("0.0001"))>0){ //0.001>freq>0.0001
            System.out.println("L - Low level of risk");
            LowerRisk lowRisk = new LowerRisk("low",frame);
        }
        else if(freq.compareTo(new BigDecimal("0.0001"))<0 && freq.compareTo(new BigDecimal("0.00001"))>0){ //0.0001>freq>0.00001
            System.out.println("VL - very low level of risk");
            LowerRisk veryLowRisk = new LowerRisk("very low",frame);
        }
        else if(freq.compareTo(new BigDecimal("0.00001"))<0){   //freq<0.00001
            System.out.println("Acceptable risk");
            frame.restartProgram(frame,"Acceptable risk.\n");
            // END PROGRAM
        }
    }

}


