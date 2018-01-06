package com.zeervi.rader.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zeervi.rader.pojo.Log;
import com.zeervi.rader.service.LogService;
import com.zeervi.rader.vo.SysResult;

@RestController
@RequestMapping("log")
public class LogController {
	@Autowired
	private LogService logService;
	@RequestMapping("add")
	public SysResult saveLog(Log log){
		try{
			logService.saveLog(log);
			return SysResult.oK();
		}catch(Throwable t){
			t.printStackTrace();
			return SysResult.build(201, t.getMessage());
		}
	}
	
	@RequestMapping("delete")
	public SysResult delLog(Long id){
		try {
			logService.deleteLog(id);
			return SysResult.oK();
		} catch (Throwable t) {
			t.printStackTrace();
			return SysResult.build(201,t.getMessage());
		}
	}
	
	@RequestMapping("query/all")
	public SysResult queryLog(Integer page,Integer rows){
		try{
			return SysResult.oK(logService.queryAllById(page, rows));
		}catch(Throwable t){
			t.printStackTrace();
			return SysResult.build(201,t.getMessage());
		}
	}
	
}
