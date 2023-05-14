import java.util.Scanner;

public class HigherRisk implements Risk{
    private String level;
    public HigherRisk(String level){
        printInfo(level);
        Scanner reader = new Scanner(System.in);
        while (true){
            System.out.println("Enter the value of preventive activities:");
            double numPrevAct = reader.nextDouble();
            if(numPrevAct % 1 == 0 && numPrevAct>=0){
                break;
            }
            else{
                System.out.println("Please use natural number.");
            }
        }
        System.out.println("Economic feasibility criterion");
        while (true){
            System.out.println("");
        }
    }

    @Override
    public void printInfo(String level) {
        System.out.println("That is "+ level + " level of risk"); // ТТ: МВ - Много високо ниво на риск.
        System.out.println("Determine preventive activities to eliminate the dangers of "+ level + " risk"); // ТТ: Определете превантивните дейности за елиминирането на опастностите от риск с ниво МБ
    }
}
