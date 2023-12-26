package sec06.chap06.ex03;

public class Main {
    public static void main(String[] args) {
        YalcoChickenMenu menu1 = YalcoChickenMenu.YN;
        YalcoChickenMenu menu2 = YalcoChickenMenu.RS;
        YalcoChickenMenu menu3 = YalcoChickenMenu.XX;

        String menu1Name = menu1.getName();
        int menu2Price = menu2.getPrice();
        String menu3Desc = menu3.getDesc();

        menu2.setPrice(16000);
        int menu2NewPrice = menu2.getPrice();


        // 열거형 메소드
        YalcoChickenMenu[] byNames = new YalcoChickenMenu[] {
                YalcoChickenMenu.valueOf("FR"),
                YalcoChickenMenu.valueOf("PP"),
                YalcoChickenMenu.valueOf("GJ")
                // 런타임 에러
                // YalcoChickenMenu.valueOf("NN") 존재하지 않음
        };

        // name 메소드 : .name() | 각 항목의 이름을 반환
        String[] names = new String[]{
                menu1.name(), menu2.name(), menu3.name()
        };

        // ordinal 메소드 : .ordinal() | 순번 반환 (index)
        int[] orders = new int[] {
                menu1.ordinal(), menu2.ordinal(), menu3.ordinal()
        };

        // values 메소드 : .values() | 전체 포함된 배열 반환
        // YalcoChickenMenu[] 자료형
        YalcoChickenMenu[] menus = YalcoChickenMenu.values();
        for(YalcoChickenMenu menu : menus){
            System.out.println(menu.getDesc());
        }
        System.out.println("\n -- -- -- -- -- -- \n");

        YalcoChicken store1 = new YalcoChicken();
        String menuNames = "양념치킨,능이백숙,땡초치킨";

        String[] menuList = menuNames.split(",");

        for(String menuName : menuList){
            store1.takeOrder(menuName);
        }
    }
}
