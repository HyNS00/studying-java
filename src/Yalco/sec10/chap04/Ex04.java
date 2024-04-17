package Yalco.sec10.chap04;
import java.util.stream.*;
public class Ex04 {
    // 예외의 버블링 - 하위 메소드에서 처리하지 못한 문제는 윗선에서 처리
    public static void main(String[] args) {
        IntStream.rangeClosed(0, 4)
                .forEach(Ex04::ceo);
    }
    public static void sawon(int i) throws XLargeException, LargeException, MediumException{
        try{
            switch (i){
                case 1: throw new SmallException();
                case 2: throw new MediumException();
                case 3: throw new LargeException();
                case 4: throw new XLargeException();
                default:
                    System.out.println("정상입니다.");
            }
        }catch(SmallException se){
            System.out.println("작은 문제입니다.");
        }catch (Exception e){
            throw e;
        }
    }

    public static void daeri (int i) throws XLargeException, LargeException{
        try{
            sawon(i);
        } catch (MediumException me){
            System.out.println("중간 급 문제입니다");
        } catch (Exception e){
            throw e;
        }
    }

    public static void bujang (int i) throws XLargeException{
        try{
            daeri(i);
        } catch(LargeException le){
            System.out.println("큰 문제입니다");
        } catch(Exception e){
            throw e;
        }
    }

    public static void ceo (int i){
        try{
            bujang(i);
        } catch(XLargeException xle){
            System.out.println("매우 큰 문제입니다");
        }
        System.out.println("\n -- - -- -- - --\n");
    }
}
