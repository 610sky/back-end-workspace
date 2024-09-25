package com.kh.test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class test {
	public void test() {
		//webdriver 인스턴스 생성
		   WebDriver driver= new  ChromeDriver (); 
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds( 5 )); 
		  //웹 애플리케이션 열기
		   driver.get( "https://elenastepuro.github.io/test_env/index.html" ); 
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds( 5 )); 
		  //텍스트 상자에 데이터 입력
		   driver.findElement(By.id( "change_id" )).sendKeys( "test_id" );
		   System.out.println();
		  driver.findElement(By.id( "change_className" )).sendKeys( "test_class" ); 
		  driver.findElement(By.id( "Submit" )).click(); 
		  //driver.findElement(By.id("change_id")).sendKeys("updated_test_id"); 
		  //driver.findElement(By.id("change_className")).sendKeys("updated_test_class");
	}
}
