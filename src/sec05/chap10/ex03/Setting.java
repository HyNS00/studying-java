package sec05.chap10.ex03;

public class Setting {
    // 싱글톤으로 해보기
    // 클래스 (정적) 필드
    // 프로그램 메모리에서 하나만 존재

    private static Setting setting;

    // 생성자를 private로 만든다.
    private Setting () {}

    // 공유되는 인스턴스를 받아가는 public 클래스 메소드
    public static Setting getInstance(){
        // 아직 인스턴스가 만들어지지 않았다면 생성, 프로그램에서 처음 호출시 실행
        if (setting == null){
            setting = new Setting();
        }
        return setting;
    }

    private int volume = 5;

    public int getVolume() {
        return volume;
    }
    public void incVolume() {
        volume++;
    }
    public void decVolume() {
        volume--;
    }
}
