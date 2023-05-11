import java.math.BigDecimal;
import java.util.Scanner;

public class Calculator {

    private final double frequency;
    public Calculator(){

        Scanner reader = new Scanner(System.in);
            System.out.println("Enter the frequency of occurrence of landslides/collapses (from 0.000001 to 0.1)");
            frequency = reader.nextDouble();
            measureRisk(frequency);
        }
    public void measureRisk(double freq){
        if(freq>=0.1){
            System.out.println("VH - very high level of risk");
        }
        else if(freq<0.1 && freq>0.01){ // 0.1>freq>0.01
            System.out.println("H - high level of risk");
        }
        else if(freq<0.01 && freq>0.001){ //0.01>freq>0.001
            System.out.println("M - Medium level of risk");
        }
        else if(freq<0.001 && freq>0.0001){ //0.001>freq>0.0001
            System.out.println("L - Low level of risk");
        }
        else if(freq<0.0001 && freq>0.00001){ //0.0001>freq>0.00001
            System.out.println("VL - very low level of risk");
        }
        else if(freq<0.00001){   //freq<0.00001
            System.out.println("Acceptable risk");
            // END PROGRAM
        }
    }

}


