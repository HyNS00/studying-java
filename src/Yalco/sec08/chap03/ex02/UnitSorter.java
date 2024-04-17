package Yalco.sec08.chap03.ex02;

import Yalco.sec07.chap04.*;

import java.util.Comparator;

public class UnitSorter implements Comparator<Unit> {
    @Override
    public int compare(Unit o1, Unit o2){
        int result = getClassPoint(o2) - getClassPoint(o1);
        if (result == 0){
            result = o2.hashCode() - o1.hashCode();
        }
        return result;
    }

    public int getClassPoint(Unit unit){
        int result = (unit.getSide() == Side.RED ? 10 : 0);
        if (unit instanceof Swordman) result += 1;
        if (unit instanceof Knight) result +=2;
        if (unit instanceof MagicKnight) result += 3;

        return result;
    }
}
