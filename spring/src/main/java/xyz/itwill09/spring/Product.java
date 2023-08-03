package xyz.itwill09.spring;

import lombok.AllArgsConstructor;
import lombok.Data;

//[순서-4] - 09.springMVC >> Product 클래스 생성

@AllArgsConstructor
@Data
public class Product {
	private int num;
	private String name;
}