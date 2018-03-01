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
       //启动appium
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("automationName", "Appium");
        cap.setCapability("platformName","IOS");  
        cap.setCapability("deviceName","NRDADQCECMLVHIQS");        
        cap.setCapability("platformVersion","6.0");  
        cap.setCapability("noReset", true);   //不需要再次安装
        cap.setCapability("noSign","true");//设置true避免appium安装安装包时进行重签名，从而导致启动app时提示签名失败
        
       // cap.setCapability("automationName","Selendroid");
       // cap.setCapability("app", app.getAbsolutePath());
            
        //配置测试apk  
        cap.setCapability("appPackage", "com.youxi.trove");  
        cap.setCapability("appActivity", ".View.SplashActivity");  
        cap.setCapability("sessionOverride", true);    //每次启动时覆盖session，否则第二次后运行会报错不能新建session  
        cap.setCapability("unicodeKeyboard", true);    //设置键盘  
        cap.setCapability("resetKeyboard", false);     //设置默认键盘为appium的键盘  
        
        //driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
        driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"),cap);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);//隐式等待
        
        //如果真机设备已经安装trove，则不要重新安装
        if(isInstall){
        	File classpathRoot = new File(System.getProperty("user.dir"));
        	File appDir = new File(classpathRoot,"apps");
        	File app = new File(appDir,"TroveHelper_0.1.2.apk_0.1.2.apk");
        	cap.setCapability("app",app.getAbsolutePath());       	
        }
        
        
        String tro=driver.getPageSource();
        System.out.println(tro);
        Thread.sleep(2000);
        
        if(tro.contains("允许")){
        	System.out.println("允许1");
        	driver.findElementByClassName("android.widget.Button").click();        	
        }
        else
        {
        	System.out.println("跳过1");
        }
        
        tro=driver.getPageSource();
        if(tro.contains("允许")){
        	System.out.println("允许2");
        	driver.findElementByClassName("android.widget.Button").click();        	
        }
        
        else
        {
        	System.out.println("跳过2");
        }
       
            
        Thread.sleep(2000);
        
        //我的订阅页滑动30次
        tro=driver.getPageSource();
    	driver.findElementById("com.youxi.trove:id/favorite_btn").click();  //我的订阅
    	Thread.sleep(100);   	
    	MySwipe hua =new MySwipe();
    	tro=driver.getPageSource();
    	 if(tro.contains("登录")){
         	System.out.println("登录");
         	driver.findElementById("com.youxi.trove:id/qaet_autoComplete").sendKeys("zhouzhoux80");  
            driver.findElementById("com.youxi.trove:id/login_password").sendKeys("zx3256zx");
            driver.findElementById("com.youxi.trove:id/login_click_1").click();
            driver.findElementByXPath("//android.widget.TextView[contains(@text,'Mod')]").click();
            driver.findElementById("com.youxi.trove:id/favorite_btn").click();
         }
    	 else
    	 {
         	System.out.println("登录跳过");
         	 //滑动 我的订阅页                      	 
    	 }
    	 for(int i=0;i<30;i++){
         	hua.swipeToDown(driver,100,2);
         	hua.swipeToUp(driver,100,2);
         } 
    	 
      Screenshot jietu = new Screenshot(); 
      driver.findElementByClassName("android.widget.ImageView").click();//点击<跳转到首页
      jietu.takeScreenShot(driver);  //截图操作
      tro=driver.getPageSource();
     //滑动首页30次
       for(int i=0;i<10;i++){
    	hua.swipeToUp(driver,200,2);
       	hua.swipeToDown(driver,200,2);      	
        } 
        
        //首页和详情页来回切换
         tro=driver.getPageSource();
         for(int i=0;i<2;i++){
        	 driver.findElementByXPath("//android.widget.TextView[contains(@text,'黑金龙')]").click();  //首页text定位后跳转到mod详情页
        	 tro=driver.getPageSource();
        	 if (tro.contains("取消订阅")){
        		 driver.findElementByXPath("//android.widget.TextView[contains(@text,'取消订阅')]").click(); 
        	 }
        	 else{
        		 driver.findElementByXPath("//android.widget.TextView[contains(@text,'订阅')]").click();
        	 }
        	 jietu.takeScreenShot(driver);    	 
    	     driver.findElementByClassName("android.widget.ImageView").click();
    	     
    	     
    	     driver.findElementByXPath("//android.widget.TextView[contains(@text,'阿特拉斯_数据毁灭者')]").click();  
    	     tro=driver.getPageSource();
        	 if (tro.contains("取消订阅")){
        		 driver.findElementByXPath("//android.widget.TextView[contains(@text,'取消订阅')]").click(); 
        	 }
        	 else{
        		 driver.findElementByXPath("//android.widget.TextView[contains(@text,'订阅')]").click();
        	 }
        	 jietu.takeScreenShot(driver);
    	     driver.findElementByClassName("android.widget.ImageView").click();
    	     
    	     
    	     driver.findElementByXPath("//android.widget.TextView[contains(@text,'光辉行者')]").click(); 
    	     tro=driver.getPageSource();
        	 if (tro.contains("取消订阅")){
        		 driver.findElementByXPath("//android.widget.TextView[contains(@text,'取消订阅')]").click(); 
        	 }
        	 else{
        		 driver.findElementByXPath("//android.widget.TextView[contains(@text,'订阅')]").click();
        	 }
        	 jietu.takeScreenShot(driver);
    	     driver.findElementByClassName("android.widget.ImageView").click();
    	     
    	     
    	     driver.findElementByXPath("//android.widget.TextView[contains(@text,'双管熔岩枪')]").click();  
    	     tro=driver.getPageSource();
        	 if (tro.contains("取消订阅")){
        		 driver.findElementByXPath("//android.widget.TextView[contains(@text,'取消订阅')]").click(); 
        	 }
        	 else{
        		 driver.findElementByXPath("//android.widget.TextView[contains(@text,'订阅')]").click();
        	 }
        	 jietu.takeScreenShot(driver);
    	     driver.findElementByClassName("android.widget.ImageView").click();
    	     
    	     jietu.takeScreenShot(driver);
    	     hua.swipeToUp(driver, 200, 1);
    	     driver.findElementByXPath("//android.widget.TextView[contains(@text,'夏日弓')]").click(); 
    	     tro=driver.getPageSource();
        	 if (tro.contains("取消订阅")){
        		 driver.findElementByXPath("//android.widget.TextView[contains(@text,'取消订阅')]").click(); 
        	 }
        	 else{
        		 driver.findElementByXPath("//android.widget.TextView[contains(@text,'订阅')]").click();
        	 }
        	 jietu.takeScreenShot(driver);
    	     driver.findElementByClassName("android.widget.ImageView").click();
    	     
    	     
    	     driver.findElementByXPath("//android.widget.TextView[contains(@text,'长枪')]").click();
    	     tro=driver.getPageSource();
        	 if (tro.contains("取消订阅")){
        		 driver.findElementByXPath("//android.widget.TextView[contains(@text,'取消订阅')]").click(); 
        	 }
        	 else{
        		 driver.findElementByXPath("//android.widget.TextView[contains(@text,'订阅')]").click();
        	 }
        	 jietu.takeScreenShot(driver);
    	     driver.findElementByClassName("android.widget.ImageView").click();
    	     
    	     
    	     driver.findElementByXPath("//android.widget.TextView[contains(@text,'荆棘玫瑰')]").click();
    	     tro=driver.getPageSource();
        	 if (tro.contains("取消订阅")){
        		 driver.findElementByXPath("//android.widget.TextView[contains(@text,'取消订阅')]").click(); 
        	 }
        	 else{
        		 driver.findElementByXPath("//android.widget.TextView[contains(@text,'订阅')]").click();
        	 }
        	 jietu.takeScreenShot(driver);
    	     driver.findElementByClassName("android.widget.ImageView").click();
    	     
    	     
    	     driver.findElementByXPath("//android.widget.TextView[contains(@text,'橙色长剑')]").click();
    	     tro=driver.getPageSource();
        	 if (tro.contains("取消订阅")){
        		 driver.findElementByXPath("//android.widget.TextView[contains(@text,'取消订阅')]").click(); 
        	 }
        	 else{
        		 driver.findElementByXPath("//android.widget.TextView[contains(@text,'订阅')]").click();
        	 }
        	 jietu.takeScreenShot(driver);
    	     driver.findElementByClassName("android.widget.ImageView").click();
    	     hua.swipeToDown(driver, 200, 1);
    	     jietu.takeScreenShot(driver);
         }
        
        //从首页退出登录
         driver.findElementById("com.youxi.trove:id/toolbar_left_head").click();
         driver.findElementByXPath("//android.widget.TextView[contains(@text,'退出登录')]").click(); 
         driver.findElementByXPath("//android.widget.TextView[contains(@text,'退出登录')]").click();
         jietu.takeScreenShot(driver);
    }
  	    
}



