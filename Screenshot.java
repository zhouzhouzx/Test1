package com.youxi.trove;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.TakesScreenshot;

public class Screenshot {
     WebDriver driver;
      
       public static void takeScreenShot(WebDriver driver) throws Exception{
    	 //指定了OutputType.FILE做为参数传递给getScreenshotAs()方法，其含义是将截取的屏幕以文件形式返回。
    	  File scr = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
    	 
    		   try{
    			   FileUtils.copyFile(scr,new File("D:\\AutoScreenCapture\\"+getCurrentDateTime()+".jpg"));
    		   }
    	   catch(IOException e){e.printStackTrace();}
       }
       public static String getCurrentDateTime(){
    	   SimpleDateFormat df=new SimpleDateFormat("yyyyMMdd_HHmmss");  //设置时间格式
    	   return df.format(new Date());
    	   
       }
}
