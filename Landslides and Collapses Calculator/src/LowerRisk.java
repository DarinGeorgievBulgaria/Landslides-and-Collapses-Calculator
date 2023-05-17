import java.math.BigDecimal;
import java.util.InputMismatchException;
import java.util.Scanner;

public class LowerRisk implements Risk{
    String level;
    public LowerRisk(String level){
        this.level = level;
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
    }

    public void residualRisk(){
        Scanner reader = new Scanner(System.in);
        BigDecimal residualRisk;
        BigDecimal acceptableRisk;
        while (true){
            System.out.println("Enter the value of residual risk (to 0.00001)"); // ТТ:

            try{
                residualRisk = new BigDecimal(reader.nextLine());
            }catch (InputMismatchException | NumberFormatException e){
                System.out.println("Please enter a number within the boundaries");
                continue;
            }

            while (true){
                System.out.println("Enter the value of acceptable risk (to 0.0001)"); // ТТ:

                try{
                    acceptableRisk = new BigDecimal(reader.nextLine());
                }catch (InputMismatchException | NumberFormatException e){
                    System.out.println("Please enter a number within the boundaries");
                    continue;
                }
            if(residualRisk.compareTo(new BigDecimal("0.00001"))>=0 && acceptableRisk.compareTo(new BigDecimal("0.0001"))>=0){
                //measureRisk(frequency);
                reader.close();
                break;
            }
            else {
                System.out.println("Please enter a number within the boundaries2"); // ТТ: Моля въведете чусло между границите.
            }
            }
            if(residualRisk.compareTo(acceptableRisk)<=0){
                System.out.println("Tolerable level of residual risk");
                //END !!!!
            }
        }

    }

}
