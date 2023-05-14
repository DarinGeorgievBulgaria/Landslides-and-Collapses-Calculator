import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    // TT == Text Translation
    public static void main(String[] args){

        Scanner reader = new Scanner(System.in);
        double numRiskFactors;
        while (true){
            System.out.println("Enter number of Risk Factors"); // TT: Въведете брой рискови фактори.

            try{
                numRiskFactors = reader.nextDouble();
            }catch (InputMismatchException e){
                System.out.println("Please use a natural number.");
                reader.nextLine();
                continue;
            }

            if(numRiskFactors % 1 == 0 && numRiskFactors>=0){
                break;
            }
            else{
                System.out.println("Please use a natural number.");
            }
        }

        if(numRiskFactors >= 2){
            System.out.println("Unacceptable risk"); // TT: Неприемлив риск
            System.out.println("Assessment of the level of risk depending on the frequency of occurrence of collapses / collapses"); // ТТ: Оценка на нивото на риска в зависимост от честотата на възникване на свлачища/ срутища.
            Calculator calculator = new Calculator();
        }
        else {
            System.out.println("Acceptable risk"); // ТТ: Приемлив риск
            System.out.println("--------------------------------------------------");
            main(args);
        }

    }
}
