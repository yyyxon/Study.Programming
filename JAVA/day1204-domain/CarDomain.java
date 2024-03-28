package kr.co.sist.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CarDomain {
	private String car_year, car_option, car_img, hiredate;
	private int price, cc;
}
