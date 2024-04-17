package Yalco.sec12.chap01;

import java.io.File;
import java.io.IOException;

public class Ex01 {
    // 기본적인 자바에서의 파일& 폴더 다루기
    // IO로 대체

    // 먼저 파일 경로 설정
    public static final String CUR_PATH = "src/Yalco.sec12/chap01/";
    public static void main(String[] args) {
        String filePath = "file1.txt"; // 생성할 파일 명 ,
        filePath = CUR_PATH + filePath; //
        File file1 = new File(filePath); // 파일의 인스턴스 생성
        System.out.println(file1.exists()); // 해당 파일이 존재하는지 여부
        if(!file1.exists()){
            try{
                file1.createNewFile();
                // createNewFile은 IOException를 던진다.
                // 상대 경로를 지정해주면 그곳에, 그게 아니라면 최상위 폴더 안에 생성
            }catch(IOException e){
                System.out.println("🛑 파일 생성 실패");
                throw new RuntimeException(e);
            }
        }
        // 처음실행하면 false가 뜨면서 file1.txt의 파일이 생성됨


        boolean file1Exist = file1.exists(); // 파일의 존재여부
        String file1Name = file1.getName(); // 파일의 이름
        boolean file1IsFile = file1.isFile(); // 파일인가?
        boolean file1IsDir = file1.isDirectory(); // 디렉토리인가?
        long file1Length = file1.length(); // 파일 내부에 있는 길이 반환_ 현재 빈파일이기 때문에 0

        String file1AbsPath = file1.getAbsolutePath(); // 절대경로
        // 🤓 최초의 시작점부터(최상위 디렉토리) 파일의 위치까지
        // 상대경로란 현재디렉토리(비교 대상)를 기준으로 작성
        String file1CnnPath = ""; // 완전 절대 경로
        // 경로 중 포함된 상대 경로를 모두 절대 경로로 변경
        try{
            file1CnnPath = file1.getCanonicalPath();
        }catch(IOException e){
            // Input/Output 예외
            // 파일의 읽기 권한이 없을 시
            throw new RuntimeException();
        }

        // 완전 절대 경로로 파일 생성
        File file2 = new File(file1CnnPath.replace("file1.txt","file2.txt"));
        try {
            boolean result = file2.createNewFile();
            //이미 동일한 이름의 파일이 있을 경우에는 아무런 작업을 하지 않고 false를 반환
            System.out.println(result ? "파일 생성됨" : "이미 있음");
        }catch(IOException e){
            throw new RuntimeException(e);
        }

    }
}
