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
    	 //ָ����OutputType.FILE��Ϊ�������ݸ�getScreenshotAs()�������京���ǽ���ȡ����Ļ���ļ���ʽ���ء�
    	  File scr = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
    	 
    		   try{
    			   FileUtils.copyFile(scr,new File("D:\\AutoScreenCapture\\"+getCurrentDateTime()+".jpg"));
    		   }
    	   catch(IOException e){e.printStackTrace();}
       }
       public static String getCurrentDateTime(){
    	   SimpleDateFormat df=new SimpleDateFormat("yyyyMMdd_HHmmss");  //����ʱ���ʽ
    	   return df.format(new Date());
    	   
       }
}
