package sec07.chap01.ex02;

public class Click {
    int x;
    int y;
    int timestamp;

    public Click(int x, int y, int timestamp){
        this.x = x;
        this.y = y;
        this.timestamp = timestamp;
    }

    @Override
    public boolean equals(Object obj){
        if (!(obj instanceof Click)) {
            return false;
        }
        return this.x == ((Click)obj).x && this.y == ((Click)obj).y;
        // 애초에 인스턴스가 Click이 아니면 false 반환 (instanceof)로 해당 클래스의 인스턴스인지 비교
        // obj의 형변환으로 (Click)을 해주고 비교
        // 여기서 형변환을 해주는 이유는 equals의 매개변수가 Object클래스라서 실제로 어떤 클래스의 인스턴스인지 알기 어렵기 때문
    }
}
