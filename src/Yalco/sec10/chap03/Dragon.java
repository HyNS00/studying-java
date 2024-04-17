package Yalco.sec10.chap03;

import Yalco.sec07.chap04.Side;
import Yalco.sec07.chap04.Unit;

public class Dragon extends Unit {
    public Dragon(Side side) {
        super(side, 3000);
    }

    @Override
    public String toString(){
        return side.toString() + " 진영 드래곤";
    }
}
