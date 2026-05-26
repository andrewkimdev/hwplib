package kr.dogfoot.hwplib.object.bodytext.paragraph.text;

import java.io.UnsupportedEncodingException;

/**
 * 일반 Character
 *
 * @author neolord
 */
public class HWPCharNormal extends HWPChar {
    /**
     * 생성자
     */
    public HWPCharNormal() {
    }

    public HWPCharNormal(int code) {
        this.code = code;
    }

    /**
     * 글자의 종류을 반환한다.
     *
     * @return 글자의 타입
     */
    @Override
    public HWPCharType getType() {
        return HWPCharType.Normal;
    }

    /**
     * 글자를 반환한다.
     *
     * @return 글자
     * @throws UnsupportedEncodingException
     */
    public String getCh() throws UnsupportedEncodingException {
        return intToString(code);
    }

    /**
     * 2 byte 문자코드를 문자열로 변환한다.
     *
     * @param code 2 byte 문자코드
     * @return 변환된 문자열
     */
    private String intToString(int code) {
        // 2 byte 문자코드를 그대로 보존한다. UTF-16 서러게이트 쌍(보충 평면 문자)은
        // 두 개의 HWPCharNormal에 나뉘어 저장되는데, 각 2 byte를 따로 UTF-16LE로
        // 디코딩하면 외톨이 서러게이트가 U+FFFD로 바뀐다. 코드 단위를 그대로 두면
        // getCh()를 이어붙이는 StringBuilder에서 서러게이트 쌍이 올바른 코드 포인트로
        // 다시 합쳐진다.
        return String.valueOf((char) code);
    }

    public HWPChar clone() {
        HWPCharNormal cloned = new HWPCharNormal();
        cloned.code = code;
        return cloned;
    }

    @Override
    public int getCharSize() {
        return 1;
    }
}
