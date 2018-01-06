package com.zeervi.rader.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zeervi.rader.vo.SysResult;

@RestController
@RequestMapping("/rader")
public class RaderController {

	@RequestMapping("status")
	public String status() {
		return "ok";
	}

	@RequestMapping("service")
	public SysResult service() {
		return SysResult.oK();
	}

}
