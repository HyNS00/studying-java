package sec07.chap03.ex05;

public class Main {
    public static void main(String[] args) {
        // extends -> 상속받은 클래스들
        // super -> 그 클래스와 조상 클래스들

        // 아무 유닛이나 태우는 말
        Horse<Unit> avante = new Horse<>();
        avante.setRider(new Unit());
        avante.setRider(new Knight());
        avante.setRider(new MagicKnight());

        //  기사 계급 이상을 태우는 말
        Horse<Knight> sonata = new Horse<>();
//        sonata.setRider(new Unit()); // ⚠️ 불가
        sonata.setRider(new Knight());
        sonata.setRider(new MagicKnight());


        //  마법기사만 태우는 말
        Horse<MagicKnight> grandeur = new Horse<>();
//        grandeur.setRider(new Unit()); // ⚠️ 불가
//        grandeur.setRider(new Knight()); // ⚠️ 불가
        grandeur.setRider(new MagicKnight());

        // 자료형과 제네릭 타입이 일치하지 않으면 대입 불가
        // 상속관계여도 마찬가지
//        Horse<Unit> wrongHorse1 = new Horse<Knight>();
//        Horse<Knight> wrongHorse2 = new Horse<Unit>();
//
//        avante = sonata;
//        sonata = grandeur;

        //  ⭐️ 와일드카드 - 제네릭 타입의 다형성을 위함

        //  💡 Knight과 그 자식 클래스만 받을 수 있음
        //  기사 계급 이상을 태우는 말 이상만 대입할 받을 수 있는 변수
        Horse<? extends Knight> knightHorse;
//        knightHorse = new Horse<Unit>(); // ⚠️ 불가
        knightHorse = new Horse<Knight>();
        knightHorse = new Horse<MagicKnight>();
//        knightHorse = avante; // ⚠️ 불가
        knightHorse = sonata;
        knightHorse = grandeur;

        // Knight와 그 조상 클래스만 받을 때
        Horse<? super Knight> nonLuxuryHorse;
        nonLuxuryHorse = avante;
        nonLuxuryHorse = sonata;

        // 제한이 없을 때 <? extends Object>와 동일
        Horse<?> anyHorse;
        anyHorse = avante;
        anyHorse = sonata;
        anyHorse = grandeur;

        HorseShop.intoBestSellers(avante);
        HorseShop.intoBestSellers(sonata);
        HorseShop.intoBestSellers(grandeur);

//        HorseShop.intoPremiums(avante); // ⚠️ 불가
        HorseShop.intoPremiums(sonata);
        HorseShop.intoPremiums(grandeur);

        HorseShop.intoEntryLevels(avante);
        HorseShop.intoEntryLevels(sonata);
//        HorseShop.intoEntryLevels(grandeur); // ⚠️ 불가

    }
}
