package com.youxi.trove;
import io.appium.java_client.android.AndroidDriver;


public class  MySwipe{
	//����
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
	//�ϻ�
	public  void swipeToUp(AndroidDriver driver, int during, int num)throws Exception{  
	    int width = driver.manage().window().getSize().width;  
	    int height = driver.manage().window().getSize().height;  
	    for (int i = 0; i < num; i++) {  
	        driver.swipe(width / 2, height * 3 / 4, width / 2, height / 4, during);  
	        Thread.sleep(3);  
	    }  
	}
   //��
	 public void swipeToLeft(AndroidDriver driver,int during,int num){
		 int width = driver.manage().window().getSize().width;//��ȡ��ǰ��Ļ�Ŀ��
		 int height = driver.manage().window().getSize().height;//��ȡ��ǰ��Ļ�ĸ߶�
		 for(int i = 0;i < num;i++){
		 driver.swipe(width*3/4, height/2, width/4, height/2, during);
		}
	}
    //�һ�
	 public void swipeToRight(AndroidDriver driver,int during,int num){
	     int width = driver.manage().window().getSize().width;//��ȡ��ǰ��Ļ�Ŀ��
		int height = driver.manage().window().getSize().height;//��ȡ��ǰ��Ļ�ĸ߶�
		for(int i = 0;i < num;i++){
		driver.swipe(width/4, height/2, width*3/4, height/2, during);
		  }
	 }

}


