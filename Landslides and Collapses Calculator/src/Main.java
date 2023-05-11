import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        System.out.println("Enter number of Risk Factors");
        int numRiskFactors = reader.nextInt();
        if(numRiskFactors >= 2){
            System.out.println("Unacceptable risk");
            System.out.println("Assessment of the level of risk depending on the frequency of occurrence of collapses / collapses");
            Calculator calculator = new Calculator();
        }
        else {
            System.out.println("Acceptable risk");
            System.out.println("--------------------------------------------------");
            main(args);
        }

    }
}
