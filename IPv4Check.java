import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.lang.Class;

// 사용자가 입력한 IPv4 값이 유효한지 유효하지 않은지 확인하고 terminal에 출력해주는 파일

public class IPv4Check{

    public static void main(String[] args) {

        //imutable regular expression checking IPv4
        final String IPv4PatternFinal = "^(([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])(\\.(?!$)|$)){4}$";

        String ipString; // args or scanner로 받는 ipString
        IPv4Check iCheck = new IPv4Check(); // IPv4Check class iCheck

        ipString = iCheck.checkArg(args); // checkArg 함수에서 리턴받은 String ipString에 저장
        iCheck.checkIP(IPv4PatternFinal, ipString);

    }

    // 인자가 있는경우 인자를 리턴 없을경우 Scanner로 받은 String 리턴
    public String checkArg(String[] args){
    
        if(args.length > 0){ // 인자가 있을 경우
            System.out.println("Entered Argument(IPv4) : " + args[0]);
            return args[0];
        }else{ // 인자가 없을 경우 (Scanner) 
            String userIpString;
            Scanner sc = new Scanner(System.in);

            System.out.print("Enter the IPv4 : ");
            userIpString = sc.nextLine();
            System.out.println("Entered Scanner(IPv4) : " + userIpString);
            sc.close();
            return userIpString;
        }

    }

    // 정규식 패턴과 사용자가 입력한값을 비교하여 IPv4 valid or invalid cmd에 출력하는 함수
    public void checkIP(String IPv4PatternFinal, String ipString){
        
        Pattern pattern = Pattern.compile(IPv4PatternFinal);
        Matcher matcher = pattern.matcher(ipString);
        Boolean matchFound = matcher.find();

        if(matchFound){
            System.out.println("The IPv4 you entered is valid");
        }else{
            System.out.println("The IPv4 you entered is invalid");
        }
    }
}
