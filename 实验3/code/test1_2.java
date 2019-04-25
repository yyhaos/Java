package test;

import java.util.Scanner;

public class test1_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);  
        System.out.println(" ‰»În£∫"); 
        int n = sc.nextInt();
        int ans=1;
        for(int i=1;i<=n;i++)
        {
        	ans*=i;
        }
        System.out.println(ans);
	}

}
