import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// 파일관련 import
import java.io.File;
import java.io.FileWriter;
import java.text.SimpleDateFormat;


/********************************************************************************************
사용자가 입력한 IPv4 값이 유효한지 유효하지 않은지 확인하고 terminal에 출력해주고 로그에 기록 파일
*********************************************************************************************/

public class IPv4Check{

    public static void main(String[] args) {

        while(true){
        //imutable regular expression checking IPv4
        final String IPv4PatternFinal = "^(([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])(\\.(?!$)|$)){4}$";
        final String filePath = System.getProperty("user.dir") + "\\log.txt";
        
        String userIpString; // args or scanner로 받는 ipString
        IPv4Check iCheck = new IPv4Check(); // IPv4Check class iCheck
        
        userIpString = iCheck.checkArg(args); // checkArg 함수에서 리턴받은 String ipString에 저장
        iCheck.endScanner(userIpString); // Scanner로 받은 userIpString이 "END"일 경우 프로그램 종료
        int checkIP = iCheck.checkIP(IPv4PatternFinal, userIpString); // checkIP에서 리턴받은 값 int checkIP에 저장
        iCheck.fileWirte(filePath, userIpString, checkIP); // 파일관련 log 작성하는 함수
        iCheck.endArg(args); // 인자로 받았을경우 프로그램 종료
        }
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
            if(userIpString.equals("END")){
                sc.close();
            }
            System.out.println("Entered Scanner(IPv4) : " + userIpString);

            return userIpString; // scanner로 받은 userIpString 값 리턴
        }

    }

    // 정규식 패턴과 사용자가 입력한값을 비교하여 IPv4 valid or invalid cmd에 출력하는 함수
    public int checkIP(String IPv4PatternFinal, String userIpString){
        
        Pattern pattern = Pattern.compile(IPv4PatternFinal);
        Matcher matcher = pattern.matcher(userIpString);
        Boolean matchFound = matcher.find(); // matcher.find()함수는 패턴과 입력값이 매치하면 true, 매치하지않으면 false를 리턴한다

        if(matchFound){
            System.out.println("The IPv4 you entered is valid");
            return 1;
        }else{
            System.out.println("The IPv4 you entered is invalid");
            return 0;
        }
    }

    // log file 작성 함수
    public void fileWirte(String filePath, String txt, int checkIP){
        IPv4Check iCheck = new IPv4Check();
        String dTime = iCheck.currentTime();
        String whetherValid = iCheck.whetherValid(checkIP);

        if(!(txt.equals("END")))
        try{
            File file = new File(filePath);

            FileWriter fw = new FileWriter(file, true);
            fw.write(txt+" / "+whetherValid+" / "+dTime+"\r\n");
            fw.flush();

            fw.close();

        }catch(Exception e){
            e.printStackTrace();
        }
    }

    // fileWrite 함수에 쓰일 현재시각 계산 함수
    public String currentTime(){
        long systemTime = System.currentTimeMillis();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss",Locale.KOREA);
        String dTime = formatter.format(systemTime);

        return dTime;
    }

    // fileWirte 함수에 쓰일 String 리턴 함수
    public String whetherValid(int ipCheck){
        if(ipCheck == 1){
            return "The IPv4 is valid";
        }else{
            return "The IPv4 is invalid";
        }

    }

    public void endArg(String[] args){
        if(args.length > 0){
            System.exit(0);
        }
    }

    public void endScanner(String userIpString){
        if(userIpString.equals("END")){ // userIpString이 END일 경우는 시스템 종료
            System.exit(0);
        }
    }
}
