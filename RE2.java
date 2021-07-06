import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.lang.Class;

public class RE2{

    public static void main(String[] args) {

        String ipString;
        Boolean matchFound;
        RE re = new RE();
        Scanner sc = new Scanner(System.in);

        final String IPv4PatternFinal = "^(([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])(\\.(?!$)|$)){4}$";

        if(args.length > 0){
            ipString= args[0]; 
            System.out.println("Entered Argument(IPv4) : " + ipString);
        }else{
            System.out.print("Enter the IPv4 : ");
            ipString = sc.nextLine();
            System.out.println("Entered Scanner(IPv4) : " + ipString);
        }
        
        Pattern pattern = Pattern.compile(IPv4PatternFinal);
        Matcher matcher = pattern.matcher(ipString);
        matchFound = matcher.find();
        
        re.checkIP(matchFound);

    }

    public void checkIP(Boolean matchFound){
        if(matchFound){
            System.out.println("Match Found");
        }else{
            System.out.println("Match not found");
        }
    }
}
