package Yalco.sec12.chap04;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class Ex01 {
    public static final String SONG_PATH = "src/Yalco.sec12/chap04/beatles.txt";

    public static void main(String[] args) {
//        fileReaderWriteEx();
        String frw = measureTime(Ex01::fileReaderWriteEx);
        String brw = measureTime(Ex01::bufferedReaderWriterEx);
        String iorw = measureTime(Ex01::ioStreamReaderWriterEx);
    }
    public static void fileReaderWriteEx(){
        Charset charset = StandardCharsets.UTF_8;
        // FileReader & FileWriter
        // 파일에 텍스트를 입력하는 기본 클래스
        try(
                FileReader fr = new FileReader(
                        SONG_PATH,charset
                );
                FileWriter fw = new FileWriter(
                        SONG_PATH.replace("beatles","beatles1")
                        ,charset
                )
        ){
            int c;
            //  💡 한 글자씩 불려오고 출력 후 쓰기
            //  - 때문에 비효율적. 곧 다룰 Buffered... 사용
            while ((c = fr.read()) != -1) {
                System.out.print((char) c);
                fw.write(c);
            }
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }

    public static void bufferedReaderWriterEx () {
        Charset charset = StandardCharsets.UTF_8;

        //  💡 BufferedReader & BufferedWriter
        //  - 파일 텍스트 입출력에 버퍼 사용
        try (
                //  💡 기본적으로 8192바이트짜리 🚚 트럭에 실어옴
                FileReader fr = new FileReader(
                        SONG_PATH, charset
                );
                BufferedReader br = new BufferedReader(fr);
                FileWriter fw = new FileWriter(
                        SONG_PATH.replace("beatles", "beatles_2")
                        , charset
                );
                BufferedWriter bw = new BufferedWriter(fw);
        ) {

            String line;
            //  💡 한 줄씩 🧺 바구니에 버퍼링해서 읽어옴
            //  - File... 만 사용하는 것보다 효율적
            while ((line = br.readLine()) != null) {
                System.out.println(line);
                bw.write(line);
                bw.newLine(); // 💡 줄 바꿔줌
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String measureTime (Runnable runnable) {
        long startTime = System.nanoTime();
        runnable.run();
        long endTime = System.nanoTime();
        return String.valueOf("%,d 나노초")
                .formatted(endTime - startTime);
    }

    public static void ioStreamReaderWriterEx(){
        Charset charset = StandardCharsets.UTF_8;
        //  💡 InputStreamReader & OuputStreamWriter
        //  - 갹종 Input/Output Stream을 Reader/Writer로 바꿔줌
        try(
                FileInputStream fis = new FileInputStream(SONG_PATH);
                //파일에서 바이트 단위로 데이터를 읽기 위한 클래스
                InputStreamReader ir = new InputStreamReader(fis,charset);
                // 바이트 스트림을 문자 스트림으로 변환
                BufferedReader br = new BufferedReader(ir);
                //입력 스트림으로부터 텍스트를 읽음
                FileOutputStream fos = new FileOutputStream(
                        SONG_PATH.replace("beatles","beatles_3")
                ); // 파일에 바이트 단위로 데이터를 쓰기 위한 클래스
                OutputStreamWriter ow = new OutputStreamWriter(fos,charset);
                //  바이트 스트림을 문자 스트림으로 변환
                BufferedWriter bw = new BufferedWriter(ow);
                //출력 스트림에 텍스트를 쓰기 위한 클래스
                ){
            String line;
            // 한줄씩 읽어옴
            while((line = br.readLine()) != null){
                System.out.println(line);
                bw.write(line);
                bw.newLine(); // 줄 바꿈
            }
        } catch (IOException e){
            throw new RuntimeException(e);
        }
    }
}
