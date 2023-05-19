import javax.swing.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class HigherRisk implements Risk {
    private String level;
    private NewFrame frame;

    public HigherRisk(String level, NewFrame frame) {
        this.level = level;
        this.frame = frame;
        frame.getTextArea().setText("");
        frame.setInputNum(null);
        if (level.equals("very high")) {
            printInfo(level);
            double inputNumPrev;
            double inputPrevMax;
            String input;
            frame.getTextArea().append("\n" + "Enter the value of preventive activities:");
            System.out.println("Enter the value of preventive activities:");
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
                    inputNumPrev = Double.parseDouble(input);
                } catch (InputMismatchException | InterruptedException | NumberFormatException e) {
                    System.out.println("Please enter a natural number:");
                    JOptionPane.showMessageDialog(frame, "Please use a natural number!3", "Wrong input", JOptionPane.PLAIN_MESSAGE);
                    frame.setInputNum(null);
                    //reader.nextLine();
                    continue;
                }

                if (inputNumPrev % 1 == 0 && inputNumPrev >= 0) {
                    frame.setInputNum(null);
                    break;
                } else {
                    System.out.println("Please use natural number.");
                    JOptionPane.showMessageDialog(frame, "Please use a natural number!4", "Wrong input", JOptionPane.PLAIN_MESSAGE);
                    frame.setInputNum(null);
                }
            }
            System.out.println("Economic feasibility criterion");
            frame.getTextArea().setText("Economic feasibility criterion\n");
            System.out.println("Enter the maximum value of the preventive activities:");
            frame.getTextArea().append("Enter the maximum value of the preventive activities:");
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
                    inputPrevMax = Double.parseDouble(input);
                }catch (InputMismatchException | InterruptedException | NumberFormatException e) {
                    System.out.println("Please enter a natural number");
                    JOptionPane.showMessageDialog(frame,"Please use a natural number!","Wrong input", JOptionPane.PLAIN_MESSAGE);
                    frame.setInputNum(null);
                    continue;
                }
                if (inputPrevMax % 1 == 0 && inputPrevMax >= 0) {
                    frame.setInputNum(null);
                    break;
                }
                else {
                    System.out.println("Please use natural number");
                    JOptionPane.showMessageDialog(frame,"Please use a natural number!","Wrong input", JOptionPane.PLAIN_MESSAGE);
                    frame.setInputNum(null);
                }
            }
            if (inputNumPrev <= inputPrevMax) {
                System.out.println("very high to just high");
                printInfo("high");
                LowerRisk highToLow = new LowerRisk("medium",frame);
            }
            else {
                JOptionPane.showMessageDialog(frame,"Economically inexpedient preventive activities. \nNecessity of route change.","Info", JOptionPane.PLAIN_MESSAGE);
                System.out.println("Economically inexpedient preventive activities");
                System.out.println("Necessity of route change");
                System.exit(0);
            }

        }
    }

        @Override
        public void printInfo (String level){
            System.out.println("That is " + level + " level of risk"); // ТТ: МВ - Много високо ниво на риск.
            System.out.println("Determine preventive activities to eliminate the dangers of " + level + " risk"); // ТТ: Определете превантивните дейности за елиминирането на опастностите от риск с ниво МБ
            frame.getTextArea().setText("That is " + level + " level of risk.\n" + "Determine preventive activities to eliminate the dangers of " + level + " risk.");
        }

        public String getLevel () {
            return level;
        }
        public void setLevel (String level){
            this.level = level;
        }
}

