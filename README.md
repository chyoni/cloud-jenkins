# Thinkbig automation testing with Appium + Java + Cucumber
 
### About set up link
- Appium Desktop link - https://github.com/appium/appium-desktop/releases/tag/v1.22.3-4

- Appium Inspector link - https://github.com/appium/appium-inspector/releases
  * Mac에서 바로 안열리면 해당 경로가서 xattr -cr "/Applications/Appium Inspector.app" 입력

- JDK 11 link - https://www.openlogic.com/openjdk-downloads

- Mac JDK default path : /Library/Java/JavaVirtualMachines

- 참고 자료: 
  - https://www.swtestacademy.com/category/test-automation/mobile-automation/appium/
  - https://appium.io/docs/en/writing-running-appium/tutorial/swipe/android-simple/


### AppiumBy UiAutomator2 sample
  
  ```bash
  driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"라이브러리\")")).click();
  ```

### Tess4J OCR
  
  아래 버전은 다를 수 있음

  ```bash
  brew install tesseract
  
  1. cd /Users/username/.m2/repository/net/sourceforge/tess4j/tess4j/4.5.4/
  2. mkdir darwin
  3. jar uf tess4j-4.5.4.jar darwin/
  4. brew info tesseract (here you can find path to libtesseract.4.dylib)
  5. cp /usr/local/Cellar/tesseract/4.1.1/lib/libtesseract.4.dylib darwin/libtesseract.dylib
  6. jar uf tess4j-4.5.4.jar darwin/libtesseract.dylib
  7. jar tf tess4j-4.5.4.jar
  ```

  kor.traineddata를 /usr/local/share/tessdata 에 넣어야 함