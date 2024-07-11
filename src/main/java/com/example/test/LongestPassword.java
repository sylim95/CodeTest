package com.example.test;

/**
 * 저작권 문제로 원본 각색하여 업로드
 * 비밀번호 후보들을 입력받아 해당 비밀번호가 유효한지 판단 후 유효한 비밀번호 중 가장 길이가 긴 비밀번호의 글자 수를 반환
 * 유효한 비밀번호?
 1. 대소문 영문자 또는 숫자로 이루어진 글자
 2. 문자의 개수는 짝수여야함(0 포함)
 3. 숫자의 개수는 홀수여야함
 이 모든 조건을 만족하는 비밀번호

 */

/* solved */
import java.util.regex.Pattern;

public class LongestPassword {
    public static int solution(String S) {
        String[] arr = S.split(" ");
        int length = -1;

        for(String s : arr) {
            if(Pattern.matches("^[a-z|A-z|\\d]*$", s)
                    && s.replaceAll("\\d", "").length() % 2 == 0
                    && s.replaceAll("[a-z|A-z]", "").length() % 2 == 1) {
                length = Math.max(length, s.length());
            }
        }
        return length;
    }
}

// 90점
