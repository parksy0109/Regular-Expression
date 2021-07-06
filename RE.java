import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.lang.Class;

public class RE {

    public static void main(String[] args) {

        String ipString;
        Boolean matchFound;
        RE re = new RE();
        Scanner sc = new Scanner(System.in);

        final String IPv4PatternFinal = "^(([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])(\\.(?!$)|$)){4}$";

        try {
            ipString = args[0];
            System.out.println("Entered Argument(IPv4) : " + ipString);
        } catch (Exception e) {
            System.out.print("Enter the IPv4 : ");
            ipString = sc.nextLine();
            System.out.println("Entered Scanner(IPv4) : " + ipString);
        }
        sc.close();
        
        
        Pattern pattern = Pattern.compile(IPv4PatternFinal);
        Matcher matcher = pattern.matcher(ipString);
        matchFound = matcher.find();
        
        re.checkIP(matchFound);

    }

    public void checkIP(Boolean matchFound){
        if(matchFound){
            System.out.println("Valid IPv4");
        }else{
            System.out.println("Invalid IPv4");
        }
    }
}
