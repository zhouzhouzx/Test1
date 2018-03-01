package com.youxi.trove;
import io.appium.java_client.android.AndroidDriver;


public class  MySwipe{
	//下拉
	public  void swipeToDown(AndroidDriver driver, int during,int num)throws Exception{  
	    int width = driver.manage().window().getSize().width;  
	    int height = driver.manage().window().getSize().height;  
	    System.out.println(width);  
	    System.out.println(height); 
	    for (int i = 0; i < num; i++) {  
	        driver.swipe(width / 2, height / 4, width / 2, height * 3 / 4, during);  
	        Thread.sleep(3);  
	    }  
    } 
	//上滑
	public  void swipeToUp(AndroidDriver driver, int during, int num)throws Exception{  
	    int width = driver.manage().window().getSize().width;  
	    int height = driver.manage().window().getSize().height;  
	    for (int i = 0; i < num; i++) {  
	        driver.swipe(width / 2, height * 3 / 4, width / 2, height / 4, during);  
	        Thread.sleep(3);  
	    }  
	}
   //左滑
	 public void swipeToLeft(AndroidDriver driver,int during,int num){
		 int width = driver.manage().window().getSize().width;//获取当前屏幕的宽度
		 int height = driver.manage().window().getSize().height;//获取当前屏幕的高度
		 for(int i = 0;i < num;i++){
		 driver.swipe(width*3/4, height/2, width/4, height/2, during);
		}
	}
    //右滑
	 public void swipeToRight(AndroidDriver driver,int during,int num){
	     int width = driver.manage().window().getSize().width;//获取当前屏幕的宽度
		int height = driver.manage().window().getSize().height;//获取当前屏幕的高度
		for(int i = 0;i < num;i++){
		driver.swipe(width/4, height/2, width*3/4, height/2, during);
		  }
	 }

}


