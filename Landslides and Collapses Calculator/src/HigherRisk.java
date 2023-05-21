import javax.swing.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class HigherRisk implements Risk {
    private String level;
    private NewFrame frame;


    public HigherRisk(String level, NewFrame frame) throws InterruptedException {
        this.level = level;
        this.frame = frame;
        frame.getTextArea().setText("");
        frame.setInputNum(null);
        //if (level.equals("very high")) {
        if (level.equals("много високо")) {
                printInfo(level);
                double inputNumPrev;
                double inputPrevMax;
                String input;
                //frame.getTextArea().append("\n" + "Enter the value of preventive activities:");
                frame.getTextArea().append("\n" + "Въведете стойността на превантивни дейности:");
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
                        //JOptionPane.showMessageDialog(frame, "Please use a natural number!", "Wrong input", JOptionPane.PLAIN_MESSAGE);
                        JOptionPane.showMessageDialog(frame, "Въведете цяло число!", "Грешно число", JOptionPane.PLAIN_MESSAGE);
                        frame.setInputNum(null);
                        //reader.nextLine();
                        continue;
                    }

                    if (inputNumPrev % 1 == 0 && inputNumPrev >= 0) {
                        frame.setInputNum(null);
                        break;
                    } else {
                        System.out.println("Please use natural number.");
                        //JOptionPane.showMessageDialog(frame, "Please use a natural number!", "Wrong input", JOptionPane.PLAIN_MESSAGE);
                        JOptionPane.showMessageDialog(frame, "Въведете цяло число!", "Грешно число", JOptionPane.PLAIN_MESSAGE);
                        frame.setInputNum(null);
                    }
                }
                System.out.println("Economic feasibility criterion");
                //frame.getTextArea().setText("Economic feasibility criterion\n");
                frame.getTextArea().setText("Критерий за икономическа целесъобразност.\n");

                System.out.println("Enter the maximum value of the preventive activities:");
                //frame.getTextArea().append("Enter the maximum value of the preventive activities:");
                frame.getTextArea().append("Въведете максималната стойност на превантивните дейности:");

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
                        //JOptionPane.showMessageDialog(frame,"Please use a natural number!","Wrong input", JOptionPane.PLAIN_MESSAGE);
                        JOptionPane.showMessageDialog(frame,"Въведете цяло число!","Грешно число", JOptionPane.PLAIN_MESSAGE);
                        frame.setInputNum(null);
                        continue;
                    }
                    if (inputPrevMax % 1 == 0 && inputPrevMax >= 0) {
                        frame.setInputNum(null);
                        break;
                    }
                    else {
                        System.out.println("Please use natural number");
                        //JOptionPane.showMessageDialog(frame,"Please use a natural number!","Wrong input", JOptionPane.PLAIN_MESSAGE);
                        JOptionPane.showMessageDialog(frame,"Въведете цяло число!","Грешно число", JOptionPane.PLAIN_MESSAGE);
                        frame.setInputNum(null);
                    }
                }
                if (inputNumPrev <= inputPrevMax) {
                    highLevel();
                }
                else {
                    System.out.println("Economically inexpedient preventive activities");
                    System.out.println("Necessity of route change");
                    //frame.restartProgram(frame, "Economically inexpedient preventive activities. \nNecessity of route change.\n");
                    frame.restartProgram(frame, "Икономически нецелесъобразни превантивни дейности. \nНеобходимост от промяна на трасето.\n");
                }
            }
            //else if(level.equals("high")){
            else if(level.equals("високо")){
                highLevel();
            }
        }

        public void highLevel() throws InterruptedException {
            System.out.println("very high to just high");
            //printInfo("high");
            printInfo("високо");
            Thread.sleep(5000);
            //LowerRisk highToLow = new LowerRisk("medium",frame);
            LowerRisk highToLow = new LowerRisk("средно",frame);
        }
        @Override
        public void printInfo (String level){
            System.out.println("That is " + level + " level of risk"); // ТТ: МВ - Много високо ниво на риск.
            System.out.println("Determine preventive activities to eliminate the dangers of " + level + " risk"); // ТТ: Определете превантивните дейности за елиминирането на опастностите от риск с ниво МБ
            //frame.getTextArea().setText("That is " + level + " level of risk.\n" + "Determine preventive activities to eliminate the dangers of " + level + " risk.");
            frame.getTextArea().setText("Това е " + level + " ниво на риск.\n" + "Определете превантивни дейности за елиминирането на "+ level + " ниво на риск.");
        }

        public String getLevel () {
            return level;
        }
        public void setLevel (String level){
            this.level = level;
        }
}

