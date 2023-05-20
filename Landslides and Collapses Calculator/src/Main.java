import javax.swing.*;
import java.awt.*;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.concurrent.*;

public class Main {
    // TT == Text Translation
    public static void main(String[] args) throws InterruptedException {
        NewFrame frame = new NewFrame();

        double numRiskFactors = 0;
        String input;
        System.out.println("Enter number of Risk Factors"); // TT: Въведете брой рискови фактори.
        bigLoop:
        while(true){
            frame.getTextArea().setText("Enter number of risk factors");
            mediumLoop:
            while (true){
                try{
                    smallLoop:
                    while (true){
                        if(frame.getInputNum() != null){
                            input = frame.getInputNum();
                            break smallLoop;
                        }
                        else{
                            Thread.sleep(1000);
                            System.out.println("Waiting");
                        }
                    }
                    numRiskFactors = Double.parseDouble(input);
                }catch (InputMismatchException | InterruptedException | NumberFormatException  e){
                    System.out.println("Please use a natural number1.");
                    JOptionPane.showMessageDialog(frame,"Please use a natural number!","Wrong input", JOptionPane.PLAIN_MESSAGE);
                    frame.setInputNum(null);
                    //reader.nextLine();
                    continue mediumLoop;
                }

                if(numRiskFactors % 1 == 0 && numRiskFactors>=0){
                    frame.setInputNum(null);
                    break mediumLoop;
                }
                else{
                    System.out.println("Please use a natural number.");
                    JOptionPane.showMessageDialog(frame,"Please use a natural number!","Wrong input", JOptionPane.PLAIN_MESSAGE);
                    frame.setInputNum(null);
                }
            }

            if(numRiskFactors >= 2){
                System.out.println("Unacceptable risk"); // TT: Неприемлив риск
                System.out.println("Assessment of the level of risk depending on the frequency of occurrence of collapses / collapses"); // ТТ: Оценка на нивото на риска в зависимост от честотата на възникване на свлачища/ срутища.
                frame.getTextArea().setText("Unacceptable risk.\nAssess the level of risk depending on the frequency of occurrence of collapses / collapses");
                Calculator calculator = new Calculator(frame);
            }
            else {

                frame.restartProgram(frame,"Acceptable risk\nProgram is going to restart in: \n");
            }
        }
    }
}
