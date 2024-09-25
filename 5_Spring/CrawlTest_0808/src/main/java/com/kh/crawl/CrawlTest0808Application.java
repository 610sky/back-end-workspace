package com.kh.crawl;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.openqa.selenium.support.ui.ExpectedConditions;

@SpringBootApplication
public class CrawlTest0808Application {

	public static void main(String[] args) throws InterruptedException {
		SpringApplication.run(CrawlTest0808Application.class, args);
			// 1. WebDriver와 ChromeDriver 설정
			// 프로젝트 폴더 기준으로 chromedirver.exe 파일의 위치를 작성
			System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
			
			ChromeOptions options = new ChromeOptions();
			options.addArguments("headless");
			WebDriver driver = new ChromeDriver(options);
			
			// 2. 웹 페이지 접속
			String baseUrl = "https://www.google.com/";
			driver.get(baseUrl);
			String searchKeyword="굽네치킨";
			
			WebElement search = driver.findElement(By.className("gLFyf"));
			// 원하는 값 입력하기
			search.sendKeys(searchKeyword);
			search.sendKeys(Keys.ENTER);
		
			WebElement tmp = driver.findElement(By.xpath("//*[@id=\"hdtb-sc\"]/div/div[1]/div[1]/div/div[2]/a"));
			
			tmp.click();
			
			WebElement tmp2 = driver.findElement(By.xpath("//*[@id=\"rso\"]/div/div/div[1]/div/div/div[1]/div[2]/h3/a/div/div/div/g-img"));
			tmp2.click();

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			WebElement popupElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"Sva75c\"]/div[2]/div[2]/div/div[2]/c-wiz/div/div[3]/div[1]/a")));
			
			WebElement imageElement = popupElement.findElement(By.tagName("img")); // 팝업 내에서 이미지 요소 찾기
            String imageSrc = imageElement.getAttribute("src"); // 이미지의 src 속성 값 가져오기
            System.out.println("Image URL: " + imageSrc);
            
            Thread.sleep(1000);
            
            driver.close();
		}
}
