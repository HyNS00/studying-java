package sec06.chap06.ex03;

public class YalcoChicken {

    static YalcoChickenMenu[] menus = YalcoChickenMenu.values();
    // static을 사용함으로써 클래스의 모든 인스턴스가 하나의 변수를 공유
    // 메모리 측면에서 효율적이다.

    public void takeOrder (String menuName){
        YalcoChickenMenu ordered = null;

        for (YalcoChickenMenu menu : menus){
            if (menu.getName().equals(menuName)){
                ordered = menu;
            }
        }

        if (ordered == null) {
            System.out.println("해당 메뉴가 없습니다.");
            return;
        }

        System.out.println(ordered.getPrice() + "원입니다.");
    }

}
