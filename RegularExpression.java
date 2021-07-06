import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.lang.Class;

public class ReqularExpression{

    public static void main(String[] args) {

        String ipString;
        Boolean matchFound;
        RE re = new RE();
        Scanner sc = new Scanner(System.in);

        // IPv4 패턴 확인 정규식
        final String IPv4PatternFinal = "^(([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])(\\.(?!$)|$)){4}$";

        
        if(args.length > 0){ // 인자가 들어왔을때
            ipString= args[0]; 
            System.out.println("Entered Argument(IPv4) : " + ipString);
        }else{// 인자가 들어오지 않았을때
            System.out.print("Enter the IPv4 : ");
            ipString = sc.nextLine();
            System.out.println("Entered Scanner(IPv4) : " + ipString);
        }

        Pattern pattern = Pattern.compile(IPv4PatternFinal);
        Matcher matcher = pattern.matcher(ipString);
        matchFound = matcher.find();
        
        re.checkIP(matchFound);

    }

    // 사용자가 입력한 IPv4가 유효한지 확인하는 함수
    public void checkIP(Boolean matchFound){
        if(matchFound){
            System.out.println("Match Found");
        }else{
            System.out.println("Match not found");
        }
    }
}
