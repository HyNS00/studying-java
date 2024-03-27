package sec11.chap03;
// 쓰레드 그룹
// 쓰레드 그룹이 다른 쓰레드 그룹에 포함될 수 있음
// 연관된 쓰레드를 그룹으로 묶기 위해 만듦
public class Ex01 {
    public static void main(String[] args) {
        Thread thr1 = new Thread(() -> {});

        // 그룹을 정하지 않는 다면 mainThread에 속함
        ThreadGroup mainThrGroup = thr1.getThreadGroup(); // thr1의 스레드 그룹을 mainThrGroup이라는 변수에 할당
        String mainThrGroupName = mainThrGroup.getName(); // 이름확인


        // 스레드 그룹 생성
        ThreadGroup threadGroup2 = new ThreadGroup("AAA"); // 스레드 그룹의 이름을 인자로 받는다
        String thrGoup1Name = threadGroup2.getName();

        // 그룹에 새로운 스레드를 할당
        Thread thr2 = new Thread(threadGroup2, () -> {}); // Thread할 때 그룹을 인자로 넣어준다.
        String thrGroup2Name = thr2.getThreadGroup().getName();

        // 쓰레드 그룹 안에 속하는 다른 쓰레드 그룹을 만들 수 있다
        ThreadGroup threadGroup3 = new ThreadGroup(threadGroup2,"BBB");
        String thrGroup3ParentName = threadGroup3.getParent().getName();
        String threadGroup3Name = threadGroup3.getName();
    }
}
