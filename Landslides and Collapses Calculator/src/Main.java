import javax.swing.*;
import java.awt.*;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.concurrent.*;

public class Main {
    // TT == Text Translation
    public static void main(String[] args){
        NewFrame frame = new NewFrame();
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        Scanner reader = new Scanner(System.in);
        double numRiskFactors = 0;
        String input;
        System.out.println("Enter number of Risk Factors"); // TT: Въведете брой рискови фактори.
        frame.getTextArea().setText("Enter number of Risk Factors");
        while (true){
            try{
                //numRiskFactors = reader.nextDouble();
               // Future<String> future = executorService.submit(frame::getInputNum);
                while (true){
                    if(frame.getInputNum() != null){
                        input = frame.getInputNum();
                        break;
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
                continue;
            }

            if(numRiskFactors % 1 == 0 && numRiskFactors>=0){
                frame.setInputNum(null);
                break;
            }
            else{
                System.out.println("Please use a natural number2.");
                //frame.getLabelMain().setText("Please use a natural number.");
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
            System.out.println("Acceptable risk"); // ТТ: Приемлив риск
            System.out.println("--------------------------------------------------");
            main(args);
        }

    }
}
