package com.zhuzz.design.patternz.flyweight.gobang;

/**
 * 具体享元：黑棋，颜色为共享的内部状态
 * Concrete flyweight: black piece with shared color
 */
public class BlackPiece implements ChessPiece {
    @Override
    public void place(int x, int y) {
        System.out.println("Placing a black piece at (" + x + "," + y + ")");
    }
}