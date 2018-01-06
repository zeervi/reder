package com.zeervi.rader.service;

import java.util.List;

import com.zeervi.rader.extend.SysException;
import com.zeervi.rader.pojo.Log;

public interface LogService {

	void saveLog(Log log) throws SysException;
	void deleteLog(Long id) throws SysException;
	void updateLog (Log log) throws SysException;
	Log queryById(Long id) throws SysException;
	List<Log> queryAllById(Integer page,Integer rows) throws SysException;
	
}
