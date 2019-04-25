package test;

import java.util.Scanner;

public class test1_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);  
        int cnt=10;
		while(cnt-->0)
        {
        	System.out.println("输入n：");
        	int n = sc.nextInt();
            int flag=0;
            if(n%4==0 && (n%100!=0 || n%400 == 0))
            {
            	flag=1;
            }
            if(flag==1)
            {
            	System.out.println(n+"年是闰年。");
            }
            else
            {
            	System.out.println(n+"年是平年。");
            }
        }
	}

}
