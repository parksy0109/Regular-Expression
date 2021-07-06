import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.lang.Class;

// 사용자가 입력한 IPv4 값이 유효한지 유효하지 않은지 확인하고 terminal에 출력해주는 파일

public class IPv4Check{

    public static void main(String[] args) {

        //imutable regular expression checking IPv4
        final String IPv4PatternFinal = "^(([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])(\\.(?!$)|$)){4}$";

        String userIpString; // args or scanner로 받는 ipString
        IPv4Check iCheck = new IPv4Check(); // IPv4Check class iCheck

        userIpString = iCheck.checkArg(args); // checkArg 함수에서 리턴받은 String ipString에 저장
        iCheck.checkIP(IPv4PatternFinal, userIpString);

    }

    // 인자가 있는경우 인자를 리턴 없을경우 Scanner로 받은 String 리턴
    public String checkArg(String[] args){
    
        if(args.length > 0){ // 인자가 있을 경우
            System.out.println("Entered Argument(IPv4) : " + args[0]);
            return args[0]; // main 에서 받은 args[] 인자값 리턴
        }else{ // 인자가 없을 경우 (Scanner) 
            Scanner sc = new Scanner(System.in);

            System.out.print("Enter the IPv4 : ");
            String userIpString = sc.nextLine();
            System.out.println("Entered Scanner(IPv4) : " + userIpString);

            sc.close();
            return userIpString; // scanner로 받은 userIpString 값 리턴
        }

    }

    // 정규식 패턴과 사용자가 입력한값을 비교하여 IPv4 valid or invalid cmd에 출력하는 함수
    public void checkIP(String IPv4PatternFinal, String userIpString){
        
        Pattern pattern = Pattern.compile(IPv4PatternFinal);
        Matcher matcher = pattern.matcher(userIpString);
        Boolean matchFound = matcher.find(); // matcher.find()함수는 패턴과 입력값이 매치하면 true, 매치하지않으면 false를 리턴한다

        if(matchFound){
            System.out.println("The IPv4 you entered is valid");
        }else{
            System.out.println("The IPv4 you entered is invalid");
        }
    }
}
