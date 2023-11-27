package sec06.chap02.pkg1;

public class Friend {
    Parent parent = new Parent();

    // int aa = new Parent().a 역시 private이기 때문에 불가
    int bb = parent.b;  // default지만 같은 패키지라서 가능
    int cc = parent.c;  // 상속관계가 아니더라도, 같은 패키지 내에 있기 때문에 가능
    int dd= parent.d;  // public이기에 가능

    public static void main(String[] args) {
        System.out.println("안녕하세요");
    }
}
