package kr.co.sist.domain;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PrdDomain {
	private String img, info;
	private int prd_code;
	private Date input_date;
}
