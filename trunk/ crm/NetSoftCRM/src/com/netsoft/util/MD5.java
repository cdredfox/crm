package com.netsoft.util;
import java.security.MessageDigest;

/** *//**
 * @discription:A tool of Secutity by SHA
 * @author     :Hui Wanpeng
 * @time       :2008-1-25
 * @version    :1.0
 * @see        :no
 */
public class MD5 {
    private synchronized static byte[] encode(String origin) {
        byte[] hash = null;
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.reset();
            hash = md.digest(origin.getBytes());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return hash;
    }

    public synchronized static String getPassword(String origin) {
        String result = "";
        byte[] hash = MD5.encode(origin);
        for (int i = 0; i < hash.length; i++) {
            int itemp = hash[i]&0xFF;
            if(itemp<16) result += "0";
            result += Integer.toString(itemp, 16).toUpperCase();
        }
        return result;
    }

    public synchronized static boolean isPassword(String origin, String result) {
        if (MD5.getPassword(origin).equals(result)) {
            return true;
        }
        return false;
    }
    public static void main(String[] args){
        String result = "";
        result = MD5.getPassword("00-0F-FE-9D-AD-AA");
        System.out.println(result);
        String str1="2008-01-01";
        
        
        
    }
}