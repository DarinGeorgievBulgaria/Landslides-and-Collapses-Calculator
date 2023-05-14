import java.math.BigDecimal;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Calculator {
    // TT == Text Translation
    public Calculator(){

        Scanner reader = new Scanner(System.in);
        BigDecimal frequency;
        while (true){
            System.out.println("Enter the frequency of occurrence of landslides/collapses (from 0.000001 to 0.2)"); // ТТ: Въведете число на честотата на възникване на свлачища

            try{
                frequency = new BigDecimal(reader.nextLine());
            }catch (InputMismatchException | NumberFormatException e){
                System.out.println("Please enter a number within the boundaries");
                continue;
            }
            if(frequency.compareTo(new BigDecimal("0.2"))<=0 && frequency.compareTo(new BigDecimal("0.000001"))>=0){
                measureRisk(frequency);
                reader.close();
                break;
            }
            else {
                System.out.println("Please enter a number within the boundaries2"); // ТТ: Моля въведете чусло между границите.
            }
        }
    }
    public void measureRisk(BigDecimal freq){
        if(freq.compareTo(new BigDecimal("0.1"))>=0){
            HigherRisk higherRisk = new HigherRisk("very high");
        }
        else if(freq.compareTo(new BigDecimal("0.1"))<0 && freq.compareTo(new BigDecimal("0.01"))>0){ // 0.1>freq>0.01
            System.out.println("H - high level of risk");
        }
        else if(freq.compareTo(new BigDecimal("0.01"))<0 && freq.compareTo(new BigDecimal("0.001"))>0){ //0.01>freq>0.001
            System.out.println("M - Medium level of risk");
        }
        else if(freq.compareTo(new BigDecimal("0.001"))<0 && freq.compareTo(new BigDecimal("0.0001"))>0){ //0.001>freq>0.0001
            System.out.println("L - Low level of risk");
        }
        else if(freq.compareTo(new BigDecimal("0.0001"))<0 && freq.compareTo(new BigDecimal("0.00001"))>0){ //0.0001>freq>0.00001
            System.out.println("VL - very low level of risk");
        }
        else if(freq.compareTo(new BigDecimal("0.00001"))<0){   //freq<0.00001
            System.out.println("Acceptable risk");
            // END PROGRAM
        }
    }

}


