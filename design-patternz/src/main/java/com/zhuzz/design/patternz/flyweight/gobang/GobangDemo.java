package com.zhuzz.design.patternz.flyweight.gobang;

import com.zhuzz.design.lab.playground.PlaygroundCase;
import com.zhuzz.design.lab.playground.PlaygroundInput;
import com.zhuzz.design.lab.i18n.I18nMessages;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import static com.zhuzz.design.lab.i18n.I18nMessages.*;

public class GobangDemo implements PlaygroundCase {
    @Override public I18nMessages pattern() { return PAT_FLYWEIGHT; }
    @Override public Map<Locale, String> caseNames() {
        return Map.of(Locale.ENGLISH, "Gobang Pieces", Locale.SIMPLIFIED_CHINESE, "五子棋棋子");
    }
    @Override public List<PlaygroundInput> inputs() {
        return List.of();
    }

    @Override public void run(Map<String, String> values) {
        // 反复获取黑白棋子，验证实例被复用
        // fetch black/white pieces repeatedly to verify reuse
        ChessPiece black1 = PieceFactory.getPiece("black");
        ChessPiece black2 = PieceFactory.getPiece("black");
        ChessPiece white1 = PieceFactory.getPiece("white");
        ChessPiece white2 = PieceFactory.getPiece("white");

        System.out.println("black reused: " + (black1 == black2));
        System.out.println("white reused: " + (white1 == white2));

        // 落子时坐标作为外部状态传入
        // coordinates passed as external state
        black1.place(3, 3);
        white1.place(3, 4);
        black2.place(4, 4);
        white2.place(4, 3);
    }
}