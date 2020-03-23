package lib;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

public class Platform {
    private static final String PLATFORM_IOS = "ios";
    private static final String PLATFORM_ANDROID = "android";
    private static final String APPIUM_URL = "http://127.0.0.1:4723/wd/hub";

    private static Platform instance;

    private Platform(){}

    public static Platform getInstance()
    {
        if(instance == null){
            instance = new Platform();
        }
        return instance;
    }



    public boolean isAndroid()
    {
        return isPlatform(PLATFORM_ANDROID);
    }
    public boolean isIos()
    {
        return isPlatform(PLATFORM_IOS);
    }

    public AppiumDriver getDriver() throws Exception
    {
        URL URL = new URL(APPIUM_URL);
        if(this.isAndroid()){
            return new AndroidDriver(URL, this.getAndroidDesiredCapabilities());
        }else if (this. isIos()){
            return new IOSDriver(URL, getIosDesiredCapabilities());
        }else {
            throw new Exception("Cannot get run platform from env variable. Platform value "  + this.getPlatformVar());
        }
    }
       private DesiredCapabilities getAndroidDesiredCapabilities()
    {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName","Android");
        capabilities.setCapability("deviceName","AndroidTestDevice");
        capabilities.setCapability("platformVersion","6.0");
        capabilities.setCapability("automationName","Appium");
        capabilities.setCapability("appPackage",".main.MainActivityg.wikipedia");
        capabilities.setCapability("appActivity","");
        capabilities.setCapability("app","/Users/alexanderosipets/Documents/AutoTests/apks/org.wikipedia.apk");
        capabilities.setCapability("automationName", "UiAutomator2");
        return capabilities;
    }
    private DesiredCapabilities getIosDesiredCapabilities(){
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName","iOS");
        capabilities.setCapability("deviceName","iPhone 8");
        capabilities.setCapability("platformVersion","13.3");
        capabilities.setCapability("app","/Users/alexanderosipets/Documents/AutoTests/apks/Wikipedia.app");
        return capabilities;
    }

    private boolean isPlatform(String my_platform)
    {
        String platform = this.getPlatformVar();
        return my_platform.equals(platform);

    }
    private String getPlatformVar()
    {
        return System.getenv("PLATFORM");
    }


}
