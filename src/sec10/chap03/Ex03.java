package sec10.chap03;

import java.io.FileNotFoundException;

public class Ex03 {
    public static void main(String[] args) {
        openMyFile("잘나온얼굴.png");
        openMyFile("야구동영상.avi");
    }

    public static void openMyFile(String name){
        if (name.contains("야구동영상")){
            try {
                throw new FileNotFoundException(
                        "그런 내용은 존재하지 않습니다."
                );
            } catch (FileNotFoundException e){
                e.printStackTrace(); // 어떤 오류인지 제대로 표기
                // 예외가 발생한 위치부터 예외가 발생한 메서드를 호출한 스택 트레이스를 출력
                System.out.println("다시 입력해주세요");
            }
            return; // 뒤에 문장을 완전히 나오지 않게 하기 위해 return;으로 끝냄 -> 즉시 종료
        }
        System.out.printf("%s 파일 열람 %n", name);
    }
}
