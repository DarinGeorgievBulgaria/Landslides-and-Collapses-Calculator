import javax.swing.*;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * This class is for Very High Risk (VH) and High Risk (H).
 * It implements the Risk interface and the printInfo() method is overridden.
 */
public class HigherRisk implements Risk {
    private String level;
    private NewFrame frame;

    /**
     * This constructor contains the functionality for high and very high levels of risk.
     * @param level - String for the level of risk. Works with "very high" and "high".
     * @param frame - NewFrame object needs to be passed.
     * @throws InterruptedException
     */
    public HigherRisk(String level, NewFrame frame) throws InterruptedException {
        this.level = level;
        this.frame = frame;
        frame.getTextArea().setText("");
        frame.setInputNum(null);
        if (level.equals("very high")) {
            veryHighLevel();
        }
        else if(level.equals("high")){
            highLevel();
        }
    }

    /**
     * This method is initiated when the level of risk is "very high".
     * MORE FUNCTIONALITY WILL BE ADDED TO THIS LEVEL LATER ON.
     * @throws InterruptedException
     */
    public void veryHighLevel() throws InterruptedException {
        printInfo(level);
        frame.getTextArea().append("\n" + "Enter the value of preventive activities:");
        System.out.println("Enter the value of preventive activities:");
        int inputNumPrev = frame.getRealNum();

        System.out.println("Economic feasibility criterion");
        frame.getTextArea().setText("Economic feasibility criterion\n");
        System.out.println("Enter the maximum value of the preventive activities:");
        frame.getTextArea().append("Enter the maximum value of the preventive activities:");
        int inputPrevMax = frame.getRealNum();

        if (inputNumPrev <= inputPrevMax) {
            highLevel();
        }
        else {
            //JOptionPane.showMessageDialog(frame,"Economically inexpedient preventive activities. \nNecessity of route change.","Info", JOptionPane.PLAIN_MESSAGE);
            System.out.println("Economically inexpedient preventive activities");
            System.out.println("Necessity of route change");
            frame.restartProgram(frame, "Economically inexpedient preventive activities. \nNecessity of route change.\n");
        }
    }

    /**
     * This method is initiated when the level of risk is "high".
     * MORE FUNCTIONALITY WILL BE ADDED TO THIS LEVEL LATER ON.
     * But eventually the risk should get to medium level
     * @throws InterruptedException
     */
    public void highLevel() throws InterruptedException {
        System.out.println("very high to just high");
        printInfo("high");
        Thread.sleep(5000);
        LowerRisk highToLow = new LowerRisk("medium",frame);
    }

    /**
     * This method is overridden from the Risk interface. It displays informative text on the frame.
     * @param level - level of risk
     */
    @Override
    public void printInfo (String level){
        System.out.println("That is " + level + " level of risk"); // ТТ: МВ - Много високо ниво на риск.
        System.out.println("Determine preventive activities to eliminate the dangers of " + level + " risk"); // ТТ: Определете превантивните дейности за елиминирането на опастностите от риск с ниво МБ
        frame.getTextArea().setText("That is " + level + " level of risk.\n" + "Determine preventive activities to eliminate the dangers of " + level + " risk.");
    }

    /**
     * This is a GET method which returns the level of risk.
     * @return level - level of risk
     */
    public String getLevel () {
        return level;
    }

    /**
     * This is a SET method which sets the level of risk.
     * @param level - the new level
     */
    public void setLevel (String level){
        this.level = level;
    }
}

