package com.zhuzz.design.patternz.flyweight.gobang;

import com.zhuzz.design.lab.i18n.Messages;

/**
 * 具体享元：黑棋，颜色为共享的内部状态
 * Concrete flyweight: black piece with shared color
 */
public class BlackPiece implements ChessPiece {
    @Override
    public void place(int x, int y) {
        Messages.println("gobang.placeBlack", x, y);
    }
}