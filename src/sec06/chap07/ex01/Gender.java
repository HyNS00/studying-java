package sec06.chap07.ex01;

public enum Gender{
    MALE("👨"), FEMALE("👩");

    private String emoji;
    Gender(String emoji){
        this.emoji = emoji;
    }
    public String getEmoji(){
        return emoji;
    }
}
