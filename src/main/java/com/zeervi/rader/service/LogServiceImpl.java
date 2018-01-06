package com.zeervi.rader.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zeervi.rader.extend.SysException;
import com.zeervi.rader.mapper.LogMapper;
import com.zeervi.rader.pojo.Log;

@Service
public class LogServiceImpl extends BaseService<Log> implements LogService {

	@Autowired
	private LogMapper logMapper;

	@Override
	public void saveLog(Log log) throws SysException {
		log.setCreated(new Date());
		int i = logMapper.insertSelective(log);
		if (i != 1) {
			throw new SysException("save log error");
		}
	}

	@Override
	public void deleteLog(Long id) throws SysException {
		Integer i = super.deleteById(id);
		if (i != 1) {
			throw new SysException("delete log error");
		}
	}

	@Override
	public void updateLog(Log log) throws SysException {
		Integer i = super.updateSelective(log);
		if (i != 1) {
			throw new SysException("update log error");
		}
	}

	@Override
	public Log queryById(Long id) throws SysException {
		Log log = super.queryById(id);
		if (log == null) {
			throw new SysException("query log error");
		}
		return log;
	}

	@Override
	public List<Log> queryAllById(Integer page, Integer rows) throws SysException {
		PageHelper.startPage(page, rows);
		List<Log> logs = super.queryAll();
		PageInfo<Log> info = new PageInfo<>(logs);
		if (info.getList() == null || info.getSize() < 0) {
			throw new SysException();
		}
		return info.getList();
	}

}
