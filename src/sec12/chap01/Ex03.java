package sec12.chap01;

import java.io.File;
import java.io.IOException;
import java.util.stream.IntStream;

public class Ex03 {
    public static void main(String[] args) {
        String folderName = "myFolder";
        File folder = new File(Ex01.CUR_PATH + folderName);

        // 디렉토리 만들기
        boolean folderMade = folder.mkdir();
        boolean isFile = folder.isFile();
        boolean isDir = folder.isDirectory();
        IntStream.range(0,10).forEach(i ->{
            try{
                if(i %3 ==0) {
                    new File(
                            "%s%s/folder%d".formatted(Ex01.CUR_PATH, folderName, i + 1)
                    ).mkdir();
                    return; // 반복문에서와 다른 케이스, return을 통해 다음 요소로 넘어간다.
                }
                new File(
                        "%s%s/file%d.txt"
                                .formatted(Ex01.CUR_PATH, folderName, i + 1)
                ).createNewFile();
            } catch(IOException e){
                throw new RuntimeException(e);
            }
        });

        //  💡 폴더 안의 파일/폴더들 배열로 출력
        File[] filesInFolder= folder.listFiles(); // 특정 폴더 내의 모든 파일과 폴더
        String[] fileNamesInFolder = folder.list(); // 폴더 내의 파일 및 하위 폴더의 이름

        for (File item : filesInFolder) {
            System.out.println(
                    (item.isFile() ? " 📄" : "📁")
                            + " " + item.getName()
            );
        }


    }
}
