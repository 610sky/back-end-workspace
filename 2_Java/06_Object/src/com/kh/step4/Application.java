package com.kh.step4;

import com.kh.step4.model.Car;

public class Application {

	public static void main(String[] args) {
		Car c = new Car();
		
//		c.color = "red";
//		c.gearType = "auto";
//		c.door = 4;
		Car car1 = new Car("white", "auto", 4);
		Car car2 = new Car("black", "manual");
		
		System.out.println(car1);
		System.out.println(car2);
	}

}
