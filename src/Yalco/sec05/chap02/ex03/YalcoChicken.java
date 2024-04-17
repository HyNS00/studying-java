package Yalco.sec05.chap02.ex03;

public class YalcoChicken {
    int no;
    String name;
    ChickenMenu[] menus; // 다른 클래스의 인스턴스를 필드로 쓸 수 있다.

    YalcoChicken (int no, String name, ChickenMenu[] menus){
        this.no = no;
        this.name = name;
        this.menus = menus;
    }

    ChickenMenu orderMenu (String name){
        for (ChickenMenu menu : menus){
            if (menu.name.equals(name)){
                return menu;
            }
        }
        return null;
    }
}
