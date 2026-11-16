package com.zhuzz.design.patternz.flyweight.gobang;

import java.util.HashMap;
import java.util.Map;

/**
 * 享元工厂：按颜色缓存并复用棋子实例
 * Flyweight factory: caches and reuses pieces by color
 */
public class PieceFactory {
    private static final Map<String, ChessPiece> pieceMap = new HashMap<>();

    public static ChessPiece getPiece(String color) {
        if ("white".equalsIgnoreCase(color)) {
            return pieceMap.computeIfAbsent("white", k -> new WhitePiece());
        }
        return pieceMap.computeIfAbsent("black", k -> new BlackPiece());
    }
}