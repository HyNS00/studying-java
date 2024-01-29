package sec07.chap03;

public class Main {
    public static void main(String[] args) {
        Click click1 = new Click(123, 456, 5323487);
        Click click2 = new Click(123, 456, 5323487);
        Click click3 = new Click(123, 456, 2693702);
        Click click4 = new Click(234, 567, 93827345);

        int click1Hash = click1.hashCode();
        int click2Hash = click2.hashCode();
        int click3Hash = click3.hashCode();
        int click4Hash = click4.hashCode();

        //  💡 Object의 toString은 내부에 hashCode 메소드 사용
        //  hash코드를 오버라이드하면 기본 toString에도 영향
        String click1str = click1.toString();
        String click2str = click2.toString();
        String click3str = click3.toString();
        String click4str = click4.toString();

    }
}
