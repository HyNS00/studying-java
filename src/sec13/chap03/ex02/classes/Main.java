package sec13.chap03.ex02.classes;

import TIL.복습.toString.Person;
import TIL.복습.인터페이스.Test;
import sec13.chap03.ex02.annotations.*;
import sec13.chap03.ex02.enums.*;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        List<Object> objList = new ArrayList<>();

        Object[] objsToVerify = {

                new Introduction(
                        "홍길동", 28, "프로그래머",
                        "외길인생 자바 프로그래머입니다."),
                new Introduction(
                        "전우치토스", 20, "협객",
                        "나는 복수를 하지."),
                new Appointment(
                        "페르세우스", WeekDay.MON, 20,
                        "정신이 오락가락"),
                new Appointment(
                        "황금박쥐", WeekDay.WED, 14,
                        "두통"),
                new Appointment(
                        "정핫준", WeekDay.TUE, 12,
                        "콧물과 가래"),
                new Introduction(
                        "김갓난", 0, "영아",
                        "너무 young해서 영아")
        };

        List<Object> objsVerified = new ArrayList<>();
        for(Object obj : objsToVerify){
            try{
                objsVerified.add(verifyObj(obj));
                System.out.println("✅ 통과");
            }catch (Exception e){
                System.out.println("🛑 반려 : " + e.getMessage());
                e.printStackTrace();
            }finally {
                System.out.println("- - - - -");
            }
        }
    }
    public static Object verifyObj (Object obj) throws Exception{
        Class<?> objClass = obj.getClass(); //obj에 있는 클래스를 반환
        ClassicDesc cd = objClass.getAnnotation(ClassicDesc.class);
        // ClassicDesc의 클래스 개체를 가져와서 어노테이션 확인
        System.out.println(cd.value() + " 검증 시작");
        // 모든 필드를 돌며 진행
        for(Field f: objClass.getDeclaredFields()){
            f.setAccessible(true); // private한 필드까지 접근할 수 있게
            Object val = f.get(obj); // 필드값을 가져와서 val에 할당

            //  🧪 필드의 어노테이션 검증 및 처리 + 어노테이션은 항상 명시적 형변환이 필요
            for(Annotation a : f.getAnnotations()){

                // Blind일 시 첫 글자를 제외하고 *으로 처리
                if(a instanceof Blind){
                    String s = (String) val;
                    // set메소드를 사용해서 해당 필드의 값을 변경
                    f.set(obj,s.substring(0,1) + "*".repeat(s.length()-1));
                }

                // 최대 길이 검증
                if(a instanceof MaxLength){
                    int maxLen = ((MaxLength)a).value();
                    if(((String)val).length() > maxLen){
                        throw new Exception(
                                "%s 최대 길이(%d)초과".formatted(f.getName(),maxLen)
                        );
                    }
                }
                // 최솟값 최댓값 검증
                // Repeatable 여럿을 썼을 경우, 묶음으로 돌아감
                // 각 annotation마다 진행을 해야하는 이유
                if(a instanceof NumLimits){
                    // value 메소드가 NumLimits[]을 반환
                    for(NumLimit nl : ((NumLimits)a).value()){ // value()으로 []에 접근
                        verifyNumLimit(f.getName(),nl,(int)val);
                    }
                }
                if(a instanceof NumLimit){
                    verifyNumLimit(f.getName(),(NumLimit) a, (int)val);
                }

                // 가중 요일 검증
                if(a instanceof WeekDaysAvail){
                    WeekDaysAvail wda = (WeekDaysAvail) a;
                    WeekDay wd = (WeekDay) f.get(obj); // 코드의 안전성을 위한 명시적 형변환
                    WeekDay[] availables = wda.value();
                    boolean available = false;
                    for (WeekDay inAvail : availables) {
                        if (wd == inAvail) available = true;
                    }
                    if (!available) throw new Exception(
                            "해당 요일(%s) 불가".formatted(wd.getName())
                    );
                }
            }
            // 테스트 해야할 메소드 진행
            for(Method m : objClass.getDeclaredMethods()){
                for(Annotation a: m.getAnnotations()){
                    if(a instanceof TestAndPrint){
                        TestAndPrint tp = (TestAndPrint) a;
                        String printBefore = tp.before();
                        String printAfter = tp.after();
                        // isEmpty는 공백으로 띄어쓰기가 있으면 false반환
                        // isBlank는 공백으로 띄어쓰기가 있어도 true반환
                        if(!printBefore.isBlank())
                            System.out.println(printBefore);
                        m.invoke(obj);
                        if(!printAfter.isBlank()){
                            System.out.println(printAfter);
                        }
                    }
                }
            }
        }
        return obj;
    }
    public static void verifyNumLimit(String fieldName, NumLimit nl, int val) throws Exception{
        if(nl.type() == LimitType.MIN && val < nl.to()){
            throw new Exception(
                    "%s 범위(최소 %d) 오류".formatted(fieldName,nl.to())
            );
        }

        if(nl.type() == LimitType.MAX && val > nl.to()){
            throw new Exception(
                    "%s 범위(최대 %d) 오류".formatted(fieldName, nl.to())
            );
        }
    }
}
