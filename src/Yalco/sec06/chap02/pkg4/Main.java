package Yalco.sec06.chap02.pkg4;
import Yalco.sec06.chap02.pkg1.Parent;
import Yalco.sec06.chap02.pkg3.*; // 해당 패키지 내 모든 클래스를 import 해온다.
public class Main {
    public static void main(String[] args) {
        Parent parent = new Parent();

        // 패키지가 다르지만 동일한 이름의 클래스를 가져올 때 방법
        Yalco.sec06.chap02.pkg1.Child child1= new Yalco.sec06.chap02.pkg1.Child();
        Yalco.sec06.chap02.pkg2.Child child2 = new Yalco.sec06.chap02.pkg2.Child();

        Cls1 cls1 = new Cls1();
        Cls2 cls2 = new Cls2();
        Cls3 cls3 = new Cls3();
    }
}
