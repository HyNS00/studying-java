package Yalco.sec12.chap03;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class Ex02 {
    // 파일에 쓰기 실습
    public static final String SONG_PATH = "src/Yalco.sec12/chap03/beatles.txt";
    public static final String IMG_PATH = "src/Yalco.sec12/chap03/windows.jpeg";

    public static void main(String[] args) {
//        writeLittleStar();
        copyWithBis(SONG_PATH, "new_beatles.txt");
        copyWithBis(IMG_PATH, "new_windows.jpeg"); // 사진도 byte로 가져올 수 있다.
    }

    public static void writeLittleStar(){
        String filePath = "src/Yalco.sec12/chap03/little_star.txt";
        Charset charset = StandardCharsets.UTF_8;

        List<String> lines = Arrays.asList(
                "반짝반짝 작은 별,",
                "아름답게 비치네.",
                "동쪽 하늘에서도",
                "서쪽 하늘에서도",
                "반짝반짝 작은 별,",
                "아름답게 비치네."
        );
        try(
                // //  💡 FileOutputStream & BufferedOutputStream
                // - 파일을 쓰기 & 버퍼링에 사용
                BufferedOutputStream bos = new BufferedOutputStream(
                        new FileOutputStream(filePath))
        ){
            for (String line : lines){
                //  🧺 바구니에 담아 🚚 트럭에 싣고 가져다주기
                byte[] buffer = (line + "\n").getBytes(charset);
                bos.write(buffer,0,buffer.length);
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void copyWithBis (String from, String newFileName){
        Path fromPath = Paths.get(from);
        Path toPath = fromPath.getParent().resolve(Paths.get(newFileName));
        String to = toPath.toString();

        try(
                BufferedInputStream bis = new BufferedInputStream(
                        new FileInputStream(from)
                );
                BufferedOutputStream bos = new BufferedOutputStream(
                        new FileOutputStream(to)
                )
            ){
            byte[] buffer = new byte[1024];
            int readBytes;
            while ((readBytes = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, readBytes);
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    // InputStream, OutputStream으로 설정할 수 있지만
    // 메소드로 가능
    public static void copyWithFilesClass (String from, String newFileName) {
        Path fromPath = Paths.get(from);
        Path toPath = fromPath.getParent().resolve(Paths.get(newFileName));

        try {
            Files.copy(fromPath, toPath);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    //  💡 Files의 copy 메소드
    //  - 내부적으로 Buffered...Stream 사용
    //  - 보다 간결한 코드, 예외 처리 등 내부 처리 구현
    //  - 실무에서 보다 권장



}
