package com.kh.api.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class ServiceInfo {
	private int siCode;
	private String serviceName;
	private String serviceJibun;
	private double serviceLat;
	private double serviceLng;
	private String servicePhone;
	private String serviceImg;
}
