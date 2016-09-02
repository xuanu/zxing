# zxing

#zxing二维码扫码


**1、如何使用它？**  


先在 build.gradle(Project:XXXX) 的 repositories 添加:  

```
allprojects {
    repositories {
        ...
        maven { url "https://jitpack.io" }
    }
}
```  

然后在 build.gradle(Module:app) 的 dependencies 添加:  

```
dependencies {
        compile 'com.github.xuanu:zxing:0.0.1'
}
```   

#####2、代码中使用   


去扫描页面：```startActivityForResult(new Intent(MainActivity.this, CaptureActivity.class), 100); ``  

取扫描结果：```String tempResult = data.getStringExtra(CaptureActivity.RESULT_DATA);```  


截图：  
![image](https://github.com/xuanu/zxing/raw/master/screenshot/Screenshot_20160823-142056.png)
