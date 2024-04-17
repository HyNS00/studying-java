package Yalco.sec06.chap03.ex02;

public class YalcoChicken {
    private String name;
    public YalcoChicken (String name){
        this.name = name;
    }

    public static class LaunchTF {
        private String title;
        private String leader;

        public LaunchTF(String title, String leader) {
            this.title = title;
            this.leader = leader;
        }

        public YalcoChicken launch(){
            // 인스턴스 필드는 사용불가 - static이 아니라서
//            System.out.println(this.name);
            return new YalcoChicken(title);
        }
    }

    class Gift{
        private String message;

        public Gift(String to){
            this.message = "From 얄코치킨 %s점 to %s님".formatted(name, to);
        }
    }
    public Gift getGift(String to){
        return new Gift(to);
    }

}
