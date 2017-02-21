/**
 * @name Miriam Lee
 * @link https://www.hackerrank.com/challenges/ctci-merge-sort/editorial
 */


import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
 static long O;
    
    public static void main(String[] args) {
        
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        
        for(int i=0;i<t;i++){
            int n = in.nextInt();
            int[] ar = new int[n];
            for(int j=0;j<n;j++){
                ar[j]=in.nextInt();
                //System.err.println(ar[j]);
            }
            long c = insertSort(ar);      
            System.out.println(c);
            System.err.println(O);
        }
}
    
    
    public static long insertSort(int[] ar)
    {
         long count = 0;
        // Compute the required count

        return MergeCount(ar, 0, ar.length-1,ar.clone());
        
    }
    private static void show(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]);
        }
        System.out.println();
    }

    private static int mid(int from, int to) {
        return  from + (to - from) / 2;//(to + from) / 2;//
    }

    
    private static long MergeCount(int a[], int from, int to,int[] s) {
        O++;
        if (to - from <= 0)
            return 0;

        // show(a);

        int mid = mid(from, to);
        long x = MergeCount(s, from, mid,a);
        // show(a);
        long y = MergeCount(s, mid + 1, to,a);
        // show(a);

        return x + y + MergeCountSplitInv(a, from, to, mid,s);
    }

  private static long MergeCountSplitInv(int[] a, int from, int to, int mid,int[] s) {
      O++;
      
    //int[] s = a.clone();//new int[a.length];
    //System.arraycopy(a, from, s, from, to-from+1);

    int i = from;
    int j = mid + 1;
    long c = 0;

    for (int k = from; k <= to; k++) {
      if (j > to || (i <= mid && s[i] <= s[j])) {
        a[k] = s[i++];
      } else // if (i >= mid(to, from) || a[j] < a[i])
      {// split inversion
        a[k] = s[j++];
        //when element of 2nd array C gest copied to ouput D, increment total by number of elements remaining in 1st array B
        if (i <= mid)
          c += mid + 1 - i;
      }

    }
    
    // show(a);
    // System.out.println(c);
    return c;
  }

    
    
}