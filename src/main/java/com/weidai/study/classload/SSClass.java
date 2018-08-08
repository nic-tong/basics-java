package com.weidai.study.classload;

public class SSClass {
	   static
	    {
	        System.out.println("SSClass");
	    }
	   
	   private static class  Lazy {
		   private static SSClass ss = new SSClass();
	   }

	   public SSClass() {
		   
	   }
	   public static SSClass getInstance() {
		   return Lazy.ss;
	   }
}
