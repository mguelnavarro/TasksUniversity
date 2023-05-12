import java.util.Scanner;
public class Investigation {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);        
        System.out.println("-------------Depoimento-------------");
        
        String phoneVictim;
        do{
            System.out.println("Telefonou para vítima? (Sim ou Não)");
            phoneVictim = scanner.nextLine();
        } while (!phoneVictim.equalsIgnoreCase("Sim") && !phoneVictim.equalsIgnoreCase("Não"));
         
        String localVictim;
        do{
            System.out.println("Você esteve no local do crime? (Sim ou Não)");
            localVictim = scanner.nextLine();
        } while (!localVictim.equalsIgnoreCase("Sim") && !localVictim.equalsIgnoreCase("Não"));

        String houseVictin;
        do{
            System.out.println("Você emora perto da vítima? (Sim ou Não)");
            houseVictin = scanner.nextLine();
        } while (!houseVictin.equalsIgnoreCase("Sim") && !houseVictin.equalsIgnoreCase("Não"));

        String oweMoneyVictin;
        do{
            System.out.println("Você devia para a vítima? (Sim ou Não)");
            oweMoneyVictin = scanner.nextLine();
        } while (!oweMoneyVictin.equalsIgnoreCase("Sim") && !oweMoneyVictin.equalsIgnoreCase("Não"));

        String workVictin;
        do{
            System.out.println("Você trabalhava com a vítima? (Sim ou Não)");
            workVictin = scanner.nextLine();
        } while (!workVictin.equalsIgnoreCase("Sim") && !workVictin.equalsIgnoreCase("Não"));
       

        int count = 0;
        switch(phoneVictim.toLowerCase()) {
            case "sim":
                count++;
                break;
        }
        switch(localVictim.toLowerCase()) {
            case "sim":
                count++;
                break;
        }
        switch(houseVictin.toLowerCase()) {
            case "sim":
                count++;
                break;
        }
        switch(oweMoneyVictin.toLowerCase()) {
            case "sim":
                count++;
                break;
        }
        switch(workVictin.toLowerCase()) {
            case "sim":
                count++;
                break;
        }

        if (count == 1) {
            System.out.println("O suspeito é inocente.");
        } else if (count == 2) {
            System.out.println("O indivíduo é suspeito.");
        } else if (count == 3 || count == 4) {
            System.out.println("O suspeito é culpado.");
        } else  {
            System.out.println("O suspeito é assassino.");
        }

        scanner.close();




    }

    
}
