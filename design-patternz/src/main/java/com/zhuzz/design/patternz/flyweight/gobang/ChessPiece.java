package com.zhuzz.design.patternz.flyweight.gobang;

/**
 * 享元接口：棋子，落子时传入外部坐标
 * Flyweight: chess piece placed with external coordinates
 */
public interface ChessPiece {
    void place(int x, int y);
}