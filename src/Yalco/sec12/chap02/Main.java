package Yalco.sec12.chap02;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Main {
    public static final String CUR_PATH = "src/Yalco.sec12/chap02/";
    public static void main(String[] args) {
        Path path1 = Paths.get(""); // 해당 프로젝트의 제일 최상위 폴더
        Path path1Abs = path1.toAbsolutePath();

        Path path2 = Paths.get("my_file.txt");
        Path path2Abs = path2.toAbsolutePath();

        //  💡 인자로 들어온 문자열을 각각 내부 폴더로
        Path path3 = Paths.get(CUR_PATH,"sub1","sub2","sub3");
        // first 로 처음을 만들고 나머진 sub1/sub2/sub3 하위폴더로 더 늘어남

        // 두 경로를 통합
        Path path4 = path3.resolve(path2); // path3 + path2

        // 부모 경로
        Path path5 = path4.getParent(); // 바로 상위폴더의 경로

        // 한 경로에서 다른 경로로의 상대 경로
        Path path6 = path4.relativize(path2);
        // path4에서 path2까지 이동하는 데 필요한 상대 경로
        // [../../../../../]은 상위 폴더로 이동하라는 의미

        // 끝단 파일 | 폴더 명
        Path path7 = path4.getFileName();

        //  💡 서브경로
        Path path8 = path4.subpath(3, 5); // 인덱스처럼 3~4까지의 경로


        // Files 클래스
        System.out.println(Files.exists(path2));

        // Path를 기준으로 파일 생서
        try{
            Files.createFile(path2);
        }catch (IOException e){
            // 🤓createFile은 createNewFile과 달리 파일 존재시 예외를 던진다.
            System.out.println("파일이 이미 존재");
        }

        // Path를 기준으로 폴더를 생성
        try{
            Files.createDirectory(
                    Paths.get(CUR_PATH,"myFolder")
            );
        } catch(IOException e){
            // 폴더가 존재할 시 예외를 던진다.
            System.out.println("폴더가 존재");
        }

        // 중첩된 폴더를 한번에 생성
        try{
            Files.createDirectories(
                    path4.getParent() // sub1/sub2/sub3까지의 경로를 확인하고 없으면 만든다.
            );
            // 그 안에 파일 생성
            Files.createFile(path4);
        }catch(IOException e){
            System.out.println("이미 존재");
        }

        //  ⭐️ Files를 사용하여 파일 쓰기
        //  - 용량이 크지 않은 데이터를 쓰는데 적합
        //  - 덧붙이는 작업이나 대용량 작업은 이후 강에서
        try{
            Files.write(path4, "김현수입니다.".getBytes(StandardCharsets.UTF_8));
        }catch (IOException e){
            throw new RuntimeException(e);
        }
        //  💡 write : 파일에 주어진 바이트 배열을 씀
        //  - 이미 내용이 있을 경우 덮어씀
        List<String> lines = Arrays.asList(
                "아기상어 뚜루루뚜루", "귀여운 뚜루루뚜루",
                "바다속 뚜루루뚜루",  "아기상어",
                "",
                "엄마상어 뚜루루뚜루", "어여쁜 뚜루루뚜루",
                "바다속 뚜루루뚜루",  "엄마상어"
        );

        try{
            Files.write(path4, lines);
        }catch (IOException e){
            throw new RuntimeException(e);
        }

        //  💡 파일의 내용을 byte 배열로 전부 받아오기
        //  - ⚠️ 대용량 파일의 경우에는 부적합
        byte[] path4Bytes;
        try{
            path4Bytes = Files.readAllBytes(path4);
        } catch(IOException e){
            throw new RuntimeException(e);
        }
        String path4Contents = new String(path4Bytes);
        System.out.println(path4Contents);

        System.out.println("\n- - - - -\n");

        //  💡 파일의 내용을 문자열의 리스트로 전부 받아오기
        //  - ⚠️ 역시 대용량 파일의 경우에는 부적합

        List<String> path4Read = null;
        try{
            path4Read = Files.readAllLines(path4);
            path4Read.stream()
                    .map(s ->  "🎤 " + s)
                    .forEach(System.out :: println);
        }catch (IOException e){
            throw new RuntimeException(e);
        }

        System.out.println("\n- - - - -\n");

        //  💡 파일의 내용을 한 줄씩 스트림으로 받아오기
        //  - 대용량 파일을 읽는데 보다 적합
        //  - 한 줄씩만 받아오므로 효율적
        //  - 중단시 스트림 닫을 필요 - try-with-resources 사용
        //  - 파일이 너무 클 시 제한 둘 필요

        try(Stream<String> lineStrm  = Files.lines(path4)){
            lineStrm
                    .map(s -> "👀" + s)
                    .forEach(System.out::println);

        }catch (IOException e){
            throw new RuntimeException(e);
        }

        Path copied = Paths.get(path4.getParent().toString(), "copied.txt");
        // 파일 복사하기
        try{
            Files.copy(path4, copied);
        }catch (IOException e) {}


        Path moved = Paths.get(
                path4.getParent().getParent().toString(),"Moved.txt"
        );
        try{
            Files.move(copied, moved); //🤓 copied파일을 moved라는 이름으로 바꿔서 moved위치로 옮김
        }catch (IOException e){
            System.out.println("파일이 이미 있음");
        }

        //  💡 파일 삭제하기
        try {
            Files.delete(moved);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
