package com.youxi.trove;

import io.appium.java_client.android.AndroidDriver;

import java.io.File;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;



public class Trove {
         static AndroidDriver<WebElement> driver;
         static boolean isInstall =false;
         public static void main(String[] args) throws Exception {
       
    	//File classpathRoot = new File(System.getProperty("user.dir"));
       // File appDir = new File(classpathRoot, "apps");
       //����appium
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("automationName", "Appium");
        cap.setCapability("platformName","IOS");  
        cap.setCapability("deviceName","NRDADQCECMLVHIQS");        
        cap.setCapability("platformVersion","6.0");  
        cap.setCapability("noReset", true);   //����Ҫ�ٴΰ�װ
        cap.setCapability("noSign","true");//����true����appium��װ��װ��ʱ������ǩ�����Ӷ���������appʱ��ʾǩ��ʧ��
        
       // cap.setCapability("automationName","Selendroid");
       // cap.setCapability("app", app.getAbsolutePath());
            
        //���ò���apk  
        cap.setCapability("appPackage", "com.youxi.trove");  
        cap.setCapability("appActivity", ".View.SplashActivity");  
        cap.setCapability("sessionOverride", true);    //ÿ������ʱ����session������ڶ��κ����лᱨ�����½�session  
        cap.setCapability("unicodeKeyboard", true);    //���ü���  
        cap.setCapability("resetKeyboard", false);     //����Ĭ�ϼ���Ϊappium�ļ���  
        
        //driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
        driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"),cap);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);//��ʽ�ȴ�
        
        //�������豸�Ѿ���װtrove����Ҫ���°�װ
        if(isInstall){
        	File classpathRoot = new File(System.getProperty("user.dir"));
        	File appDir = new File(classpathRoot,"apps");
        	File app = new File(appDir,"TroveHelper_0.1.2.apk_0.1.2.apk");
        	cap.setCapability("app",app.getAbsolutePath());       	
        }
        
        
        String tro=driver.getPageSource();
        System.out.println(tro);
        Thread.sleep(2000);
        
        if(tro.contains("����")){
        	System.out.println("����1");
        	driver.findElementByClassName("android.widget.Button").click();        	
        }
        else
        {
        	System.out.println("����1");
        }
        
        tro=driver.getPageSource();
        if(tro.contains("����")){
        	System.out.println("����2");
        	driver.findElementByClassName("android.widget.Button").click();        	
        }
        
        else
        {
        	System.out.println("����2");
        }
       
            
        Thread.sleep(2000);
        
        //�ҵĶ���ҳ����30��
        tro=driver.getPageSource();
    	driver.findElementById("com.youxi.trove:id/favorite_btn").click();  //�ҵĶ���
    	Thread.sleep(100);   	
    	MySwipe hua =new MySwipe();
    	tro=driver.getPageSource();
    	 if(tro.contains("��¼")){
         	System.out.println("��¼");
         	driver.findElementById("com.youxi.trove:id/qaet_autoComplete").sendKeys("zhouzhoux80");  
            driver.findElementById("com.youxi.trove:id/login_password").sendKeys("zx3256zx");
            driver.findElementById("com.youxi.trove:id/login_click_1").click();
            driver.findElementByXPath("//android.widget.TextView[contains(@text,'Mod')]").click();
            driver.findElementById("com.youxi.trove:id/favorite_btn").click();
         }
    	 else
    	 {
         	System.out.println("��¼����");
         	 //���� �ҵĶ���ҳ                      	 
    	 }
    	 for(int i=0;i<30;i++){
         	hua.swipeToDown(driver,100,2);
         	hua.swipeToUp(driver,100,2);
         } 
    	 
      Screenshot jietu = new Screenshot(); 
      driver.findElementByClassName("android.widget.ImageView").click();//���<��ת����ҳ
      jietu.takeScreenShot(driver);  //��ͼ����
      tro=driver.getPageSource();
     //������ҳ30��
       for(int i=0;i<10;i++){
    	hua.swipeToUp(driver,200,2);
       	hua.swipeToDown(driver,200,2);      	
        } 
        
        //��ҳ������ҳ�����л�
         tro=driver.getPageSource();
         for(int i=0;i<2;i++){
        	 driver.findElementByXPath("//android.widget.TextView[contains(@text,'�ڽ���')]").click();  //��ҳtext��λ����ת��mod����ҳ
        	 tro=driver.getPageSource();
        	 if (tro.contains("ȡ������")){
        		 driver.findElementByXPath("//android.widget.TextView[contains(@text,'ȡ������')]").click(); 
        	 }
        	 else{
        		 driver.findElementByXPath("//android.widget.TextView[contains(@text,'����')]").click();
        	 }
        	 jietu.takeScreenShot(driver);    	 
    	     driver.findElementByClassName("android.widget.ImageView").click();
    	     
    	     
    	     driver.findElementByXPath("//android.widget.TextView[contains(@text,'������˹_���ݻ�����')]").click();  
    	     tro=driver.getPageSource();
        	 if (tro.contains("ȡ������")){
        		 driver.findElementByXPath("//android.widget.TextView[contains(@text,'ȡ������')]").click(); 
        	 }
        	 else{
        		 driver.findElementByXPath("//android.widget.TextView[contains(@text,'����')]").click();
        	 }
        	 jietu.takeScreenShot(driver);
    	     driver.findElementByClassName("android.widget.ImageView").click();
    	     
    	     
    	     driver.findElementByXPath("//android.widget.TextView[contains(@text,'�������')]").click(); 
    	     tro=driver.getPageSource();
        	 if (tro.contains("ȡ������")){
        		 driver.findElementByXPath("//android.widget.TextView[contains(@text,'ȡ������')]").click(); 
        	 }
        	 else{
        		 driver.findElementByXPath("//android.widget.TextView[contains(@text,'����')]").click();
        	 }
        	 jietu.takeScreenShot(driver);
    	     driver.findElementByClassName("android.widget.ImageView").click();
    	     
    	     
    	     driver.findElementByXPath("//android.widget.TextView[contains(@text,'˫������ǹ')]").click();  
    	     tro=driver.getPageSource();
        	 if (tro.contains("ȡ������")){
        		 driver.findElementByXPath("//android.widget.TextView[contains(@text,'ȡ������')]").click(); 
        	 }
        	 else{
        		 driver.findElementByXPath("//android.widget.TextView[contains(@text,'����')]").click();
        	 }
        	 jietu.takeScreenShot(driver);
    	     driver.findElementByClassName("android.widget.ImageView").click();
    	     
    	     jietu.takeScreenShot(driver);
    	     hua.swipeToUp(driver, 200, 1);
    	     driver.findElementByXPath("//android.widget.TextView[contains(@text,'���չ�')]").click(); 
    	     tro=driver.getPageSource();
        	 if (tro.contains("ȡ������")){
        		 driver.findElementByXPath("//android.widget.TextView[contains(@text,'ȡ������')]").click(); 
        	 }
        	 else{
        		 driver.findElementByXPath("//android.widget.TextView[contains(@text,'����')]").click();
        	 }
        	 jietu.takeScreenShot(driver);
    	     driver.findElementByClassName("android.widget.ImageView").click();
    	     
    	     
    	     driver.findElementByXPath("//android.widget.TextView[contains(@text,'��ǹ')]").click();
    	     tro=driver.getPageSource();
        	 if (tro.contains("ȡ������")){
        		 driver.findElementByXPath("//android.widget.TextView[contains(@text,'ȡ������')]").click(); 
        	 }
        	 else{
        		 driver.findElementByXPath("//android.widget.TextView[contains(@text,'����')]").click();
        	 }
        	 jietu.takeScreenShot(driver);
    	     driver.findElementByClassName("android.widget.ImageView").click();
    	     
    	     
    	     driver.findElementByXPath("//android.widget.TextView[contains(@text,'����õ��')]").click();
    	     tro=driver.getPageSource();
        	 if (tro.contains("ȡ������")){
        		 driver.findElementByXPath("//android.widget.TextView[contains(@text,'ȡ������')]").click(); 
        	 }
        	 else{
        		 driver.findElementByXPath("//android.widget.TextView[contains(@text,'����')]").click();
        	 }
        	 jietu.takeScreenShot(driver);
    	     driver.findElementByClassName("android.widget.ImageView").click();
    	     
    	     
    	     driver.findElementByXPath("//android.widget.TextView[contains(@text,'��ɫ����')]").click();
    	     tro=driver.getPageSource();
        	 if (tro.contains("ȡ������")){
        		 driver.findElementByXPath("//android.widget.TextView[contains(@text,'ȡ������')]").click(); 
        	 }
        	 else{
        		 driver.findElementByXPath("//android.widget.TextView[contains(@text,'����')]").click();
        	 }
        	 jietu.takeScreenShot(driver);
    	     driver.findElementByClassName("android.widget.ImageView").click();
    	     hua.swipeToDown(driver, 200, 1);
    	     jietu.takeScreenShot(driver);
         }
        
        //����ҳ�˳���¼
         driver.findElementById("com.youxi.trove:id/toolbar_left_head").click();
         driver.findElementByXPath("//android.widget.TextView[contains(@text,'�˳���¼')]").click(); 
         driver.findElementByXPath("//android.widget.TextView[contains(@text,'�˳���¼')]").click();
         jietu.takeScreenShot(driver);
    }
  	    
}



