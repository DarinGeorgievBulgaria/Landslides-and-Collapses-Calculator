import java.util.InputMismatchException;
import java.util.Scanner;

public class HigherRisk implements Risk{
    private String level;
    public HigherRisk(String level){
        this.level = level;
        if(level.equals("very high")){
            printInfo(level);
            Scanner reader = new Scanner(System.in);
            ;
            double inputNumPrev;
            double inputPrevMax;
            while (true){
                System.out.println("Enter the value of preventive activities:");
                try{
                    inputNumPrev = reader.nextDouble(); // !!!! Input Mismatch Exception needs to be handled
                }catch (InputMismatchException e){
                    System.out.println("Please enter a natural number");
                    reader.nextLine();
                    continue;
                }

                if(inputNumPrev % 1 == 0 && inputNumPrev>=0){
                    break;
                }
                else{
                    System.out.println("Please use natural number.");
                }
            }
            System.out.println("Economic feasibility criterion");
            while (true){
                System.out.println("Enter the maximum value of the preventive activities:");
                try{
                    inputPrevMax = reader.nextDouble();
                }catch (InputMismatchException e){
                    System.out.println("Please enter a natural number");
                    reader.nextLine();
                    continue;
                }

                if(inputPrevMax % 1 == 0 && inputPrevMax>=0){
                    break;
                }
                else{
                    System.out.println("Please use natural number");
                }
            }
            if(inputNumPrev <= inputPrevMax){
                System.out.println("very high to just high");
                printInfo("high");
            }
            else{
                System.out.println("Economically inexpedient preventive activities");
                System.out.println("Necessity of route change");
                System.exit(0);
            }

        }
    }

    @Override
    public void printInfo(String level) {
        System.out.println("That is "+ level + " level of risk"); // ТТ: МВ - Много високо ниво на риск.
        System.out.println("Determine preventive activities to eliminate the dangers of "+ level + " risk"); // ТТ: Определете превантивните дейности за елиминирането на опастностите от риск с ниво МБ
    }

    public String getLevel(){
        return level;
    }
    public void setLevel(String level){
        this.level = level;
    }
}

