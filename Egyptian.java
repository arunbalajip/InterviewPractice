https://www.hackerrank.com/contests/coderadon/challenges/alien-numbers

import java.util.*;
 class pair{
     String value;
     int val;
    pair(String value, int val) {
        this.value = value;
        this.val = val;
    }
 }
public class Main
{
    public static void main(String[] args) {
        String s1 = "9";
        String s2 = "0123456789";
        String s3 = "oF8";
        //9 0123456789 oF8
        String decimalVal = getDecimalVal(s1,s2);
        String convertedVal = getLangVal(decimalVal,s3);
        System.out.println(convertedVal);
    }
    public static String add(String a, String b) {
 
    if(a.length() == 0)
        return b;
    if(b.length() == 0)
        return a;
 
    Integer i = a.length()-1, j = b.length() - 1, carry = 0;
    StringBuilder sb = new StringBuilder();
 
    while(i>=0 && j >=0) {
        int val = (a.charAt(i) - '0') + (b.charAt(j) - '0') + carry;
        Integer u = val %10;
        carry = val/10;
        i--;j--;
 sb.append(String.valueOf(u));
        
    }
 
    while(i>=0) {
        int val = (a.charAt(i) - '0') + carry;
        Integer u = val %10;
        carry = val/10;
        i--;
 
        sb.append(u.toString());
    }
 
    while(j>=0) {
        int val = (b.charAt(j) - '0') + carry;
        Integer u = val %10;
        carry = val/10;
        j--;
 
         sb.append(u.toString());
    }
 
    if(carry != 0)
          sb.append(carry.toString());
    sb.reverse();
    
    return sb.toString(); 
}
 
static String multiply(String a, String b) {
    StringBuilder res = new StringBuilder();
    String u = "";
 
    if(a == "0" || b == "0")
        return "0";
    if(a.length()< b.length()) {
        String temp = a;
        a = b;
        b = temp;
    }

    for(int i = b.length() - 1;i>=0;i--) {
         StringBuilder temp = new StringBuilder();
        int x = b.charAt(i) - '0';
        int carry = 0;
        for(int j = a.length() - 1;j>=0;j--) {
            int val = x * (a.charAt(j) - '0') + carry;
            int m = val % 10;
            carry = val/10;
 
            temp.append(m);
        }
 
        if(carry != 0)
             temp.append(carry);
 
        temp.reverse();
        temp.append(u);
        res.append(add(res.toString(),temp.toString()));
        u += "0";
    }
 
    return res.toString();
}
 
static String getPow(int base, int x) {
 
    String res = "";
 
    String number = String.valueOf(base);
    if(x == 0) {
        res = "1";
    } else {
        res = number;
        x--;
        while(x != 0) {
            res = multiply(res, number);
            x--;
        }
    }
 
    return res;
}
 
static String getDecimalVal(String number, String lang) {
    int base = lang.length();
    Map<Character, Integer> mp = new HashMap<>();

    for(int i = 0;i<lang.length();i++) {
        mp.put(lang.charAt(i), i);
    }
 
 
    String res = "";
    int k = 0;
    for(int i = number.length()-1;i>=0;i--) {
 
        String x = multiply(mp.get(number.charAt(i)).toString(), getPow(base,k));
        res = add(res,x);
        k++;
    }
 
 
    return res;
}

 
static pair division(String a, int n) {
    StringBuilder dividend = new StringBuilder();
    int rem = 0;
    for(int i = 0;i<a.length();i++) {
        int u = rem * 10 + a.charAt(i) - '0';
        int v = u/n;
        rem = u % n;
 
        if(v>0 || dividend.length() > 0)
            dividend.append(String.valueOf(v)); 
    }
    return new pair(dividend.toString(), rem);
}
 
static String getLangVal(String number, String lang) {
    int base = lang.length(); 
 
   StringBuilder res = new StringBuilder();
    while(number.length() > 0) {
        pair p = division(number, base);
        res.append(lang.charAt(p.val));
        number = p.value;
    }
    res.reverse();
    return res.toString();
}
 

}
