package sec13.chap03.ex02.classes;

import sec13.chap03.ex02.annotations.*;
import sec13.chap03.ex02.enums.*;

@ClassicDesc("자기 소개")
public class Introduction {
    @Blind
    @MaxLength(4) // max Length 4로설정
    private String name; // 이름의 길이 4로 제한

    @NumLimit(type = LimitType.MIN, to = 1)
    private int age; // 나이 값의 개수는 1로 제한

    @MaxLength
    private String job; // MaxLength에 대한 값을 설정하지 않았으니 10으로 설정

    @MaxLength(50)
    private String description; // 최대 길이 50설정

    public Introduction(String name, int age, String job, String description) {
        this.name = name;
        this.age = age;
        this.job = job;
        this.description = description;
    }

    @TestAndPrint(after = "- - - 이상 간략 소개입니다. - - -")
    // 아래의 메소드 호출 후, after값 호출
    public void shortPrint(){
        System.out.printf(
                "%s (%d대 %s)%n",name,age, job
        );
    }

    public void fullPrint(){
        StringBuilder sb= new StringBuilder();
        sb.append("이름 : %s%n".formatted(name));
        sb.append("나이 : %d대%n".formatted(age));
        sb.append("직업 : %s%n".formatted(job));
        sb.append(description);
        System.out.println(sb.toString());
    }
}
