package com.javaproject;

public class P3for2018 {

        private int minLength;
        private int maxLength;
        private String notAllowed;

        public P3for2018(int minLen, int maxLen, String symbol)
        {
            minLength = minLen;
            maxLength = maxLen;
            notAllowed = symbol;
        }
        public P3for2018(String symbol)
        {
            minLength = 6;
            maxLength = 20;
            notAllowed = symbol;
        }
        public boolean isValid(String str)
        {
            return str.length() >= minLength && str.length() <= maxLength && str.indexOf(notAllowed) == -1;
        }
    }

