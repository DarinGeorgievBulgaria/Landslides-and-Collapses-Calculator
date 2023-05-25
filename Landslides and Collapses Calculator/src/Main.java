import javax.swing.*;
import java.awt.*;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.concurrent.*;

public class Main {
    // TT == Text Translation
    public static void main(String[] args) throws InterruptedException {
        NewFrame frame = new NewFrame();

        System.out.println("Enter number of Risk Factors"); // TT: Въведете брой рискови фактори.
        frame.getTextArea().setText("Enter number of risk factors");
        int numRiskFactors = frame.getRealNum();

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
