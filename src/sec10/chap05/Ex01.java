package sec10.chap05;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
// try with resources  -> 사용한 다음 닫아주어야하는 리소스에 접근
// finally로 명시해줘야하는 것들을 간편화
public class Ex01 {
    public static void main(String[] args) {
        String correctPath = "./src/sec09/chap04/sample.txt";
        String wrongPath = "./src/sec09/chap04/rabbit.txt";
//
//        openFile1(correctPath);
//        openFile1(wrongPath);
        System.out.println("\n- - - - -\n");

        openFile2(correctPath);
        openFile2(wrongPath);
    }
    public static void openFile1 (String path){
        Scanner scanner = null;
        try{
            scanner = new Scanner(new File(path));
            while(scanner.hasNextLine()){
                System.out.println(scanner.nextLine());
            }
        }catch(FileNotFoundException e){
            e.printStackTrace();
            System.out.printf("%s 파일 없음%n",path);
        } finally{
            System.out.println("scanner는 사용 후 닫아줘야한다.");
            if(scanner != null){
                scanner.close();
            }
        }
    }

    public static void openFile2 (String path2){
        // AutoClosable 이용
        try(Scanner scanner = new Scanner(new File(path2))){
            while(scanner.hasNextLine()){
                System.out.println(scanner.nextLine());
            }
        } catch(FileNotFoundException e){
            e.printStackTrace();
            System.out.printf("%s 파일 없음%n", path2);
        }
    }
    // Scanner 클래스가 Closeable과 AutoCloseable 인터페이스를 구현했음을 확인
    // 이는 try-with-resources 구문을 사용하여 자동으로 자원을 닫을 수 있다는 의미
    // finally를 통해 명시적으로 작성하지 않아도됨
}
