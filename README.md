# NYT Articles

## Android Studio & Gradle

This project was developed in **Android Studio** and all build configurations are based on the Gradle Build System which is the newest standard for Android Projects.

This App will show the list of most popular articles from **The New York Times Developer Network**.  Clone this repository and import into **Android Studio**

> git clone git@github.com:munuarbasha/NYTArticles.git

### Setting up the project after cloning from a repository

From Android Studio simply choose to import and select the `build.gradle` in the
root directory of the repository. Android Studio will set everything else up
automatically.

### Summary of Dependencies

The dependencies are all declared in terms of **Group ID**, **Artifact ID**, and
**Version** number in `app/build.gradle`. The dependencies will then be downloaded
from [Maven Central](http://search.maven.org/) or [BinTray](https://bintray.com/).

The downloaded dependencies will be available automatically as part of the project.

Jar file dependencies can also be included. The configuration for this project
looks inside `app/libs` for `*.jar` files and includes them for all build types.


*Example Dependency Declarations:*
```
dependencies {  
    implementation fileTree(dir: 'libs', include: ['*.jar'])  
  
    //Support Libraries  
    implementation 'com.android.support:appcompat-v7:'+rootProject.supportLibVersion  
    implementation 'com.android.support.constraint:constraint-layout:' +rootProject.constraintLayoutVersion  
    implementation 'com.android.support:support-v4:'+rootProject.supportLibVersion  
    implementation 'com.android.support:design:'+rootProject.supportLibVersion  
  
    //Other Libraries  
	implementation 'com.jakewharton.timber:timber:'+rootProject.timberVersion  
    annotationProcessor 'com.google.dagger:dagger-compiler:'+rootProject.daggerVersion  
    implementation 'com.google.dagger:dagger:'+rootProject.daggerVersion  
    implementation 'com.google.code.gson:gson:'+rootProject.gsonVersion  
    implementation 'com.squareup.okhttp3:logging-interceptor:'+rootProject.okhttpVersion  
    implementation 'com.squareup.okhttp3:okhttp:'+rootProject.okhttpVersion  
    implementation 'com.squareup.retrofit2:retrofit:'+rootProject.retrofit2Version  
    implementation 'com.squareup.retrofit2:converter-gson:'+rootProject.gsondConverterVersion  
    implementation 'com.jakewharton.retrofit:retrofit2-rxjava2-adapter:'+rootProject.rxAdapterVersion  
    implementation 'com.jakewharton:butterknife:'+rootProject.butterKnifeVersion  
    annotationProcessor 'com.jakewharton:butterknife-compiler:'+rootProject.butterKnifeVersion  
  
    // RxJava  
    implementation 'io.reactivex.rxjava2:rxjava:'+rootProject.rxJavaVersion  
    // RxAndroid  
    implementation 'io.reactivex.rxjava2:rxandroid:'+rootProject.rxAndroidVersion  
    compileOnly 'javax.annotation:jsr250-api:'+rootProject.javaxAnnotationVersion  
    implementation 'com.squareup.picasso:picasso:'+rootProject.picassoVersion  
  
    //Testing  
    testImplementation 'junit:junit:4.12'  
    androidTestImplementation 'com.android.support.test:rules:'+rootProject.runnerVersion  
    androidTestImplementation 'com.android.support.test:runner:' +rootProject.runnerVersion  
    androidTestImplementation 'com.android.support.test.espresso:espresso-core:' +rootProject.espressoVersion  
    androidTestImplementation 'com.android.support.test.espresso:espresso-contrib:2.2.2'
}
```



## Other Remarks

### Code Analysis

Verifyied Lint Error Using Android Lint. Possible errors has been fixed. Follow the below steps to inspect the code

`From Android Studio -> Analyze -> Inspect code -> Select "Whole project" From the Inspect Scope then Click "OK"`

### Espresso Test

Tested UI using espresso. Follow the steps to run Espresso : 

- Open **androidTest** folder from **src** directory
- Right click on **ArticleListActivityTest.class** and run the file using emulator or device 

### SonarQube

SonarQube is a tool that “provides the capability to not only show health of an application but also to highlight issues newly introduced. With a Quality Gate in place, you can fix the leak and therefore improve code quality systematically”.

Steps to Test:
- Download and run the **StartSonar.bat** file from the /bin folder to Start the Server.
> https://www.sonarqube.org/

- To run the sonar, Open **Android Studio Terminal** and paste the below command.
> gradlew clean sonarqube -Dsonar.host.url=[http://localhost:9000](http://localhost:9000) -Dsonar.login={Project Key} --info --stacktrace

- After successfully running sonarque, check the result on [http://localhost:9000](http://localhost:9000)

[Click here to see the sonar report of this project](https://drive.google.com/open?id=1aWqqHqkCfFUqGbKuA_m5Mrt34p36On0E)
