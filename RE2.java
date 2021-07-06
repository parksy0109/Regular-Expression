import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.lang.Class;

public class RE2{

    public static void main(String[] args) {

        String ipNum = 0;
        Boolean matchFound;
        RE re = new RE();

        final String IPv4PatternFinal = "^(([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])(\\.(?!$)|$)){4}$";

        for(int i = 0; i < args.length; i ++){
            ipNum = args[i];
        }
        
        Pattern pattern = Pattern.compile(IPv4PatternFinal);
        Matcher matcher = pattern.matcher(ipNum);
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
