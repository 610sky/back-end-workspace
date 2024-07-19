package com.kh.tmp.model.vo;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class Rent {
	public int rentNo;
	public int rentMemNo;
	public int rentBookNo;
	public Date rentDate;
}
