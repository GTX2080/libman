package com.chen.library.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * MD5通用类
 *
 */
public class MD5Utils {
    /**
     * 处理字符串
     * @param text  需要处理的字符串
     * @return
     */
    public static String dealStr(String text){
        char[] chars = null;
        if(text.length()>1){
            //将字符串转成char数组  求和
            chars = text.toCharArray();
        }
        Integer sum = 0;
        for (char aChar : chars) {
            sum += aChar;
        }
        //将密码第一位替换为求和后的数据
        text = sum + text.substring(1);
        return text;
    }

    /**
     * MD5加密
     * @param text
     * @return
     */
    public static String MD5(String text){
        text = dealStr(text);
        StringBuffer sb = new StringBuffer();
        try {
            // 加密对象，指定加密方式
            MessageDigest md5 = MessageDigest.getInstance("md5");
            // 准备要加密的数据
            byte[] b = text.getBytes();
            // 加密
            byte[] digest = md5.digest(b);
            // 十六进制的字符
            char[] chars = new char[]{'0', '1', '2', '3', '4', '5',
                    '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
            // 处理成十六进制的字符串(通常)
            for (byte bb : digest) {
                sb.append(chars[(bb >> 4) & 15]);
                sb.append(chars[bb & 15]);
            }
            // 打印加密后的字符串
            //System.out.println(sb);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        MD5Utils md = new MD5Utils();
        //String strMD5 = new String("12345");
        //61A33B3E1CAC0ABD91A6CF77AE788AD5
        // 原文
        String plaintext = "qwerasdf";
        String s = MD5(plaintext);
        System.out.println(s);
        System.out.println(s.length());
    }
}

