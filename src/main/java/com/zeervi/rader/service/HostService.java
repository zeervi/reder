package com.zeervi.rader.service;

import java.util.List;

import com.zeervi.rader.extend.SysException;
import com.zeervi.rader.pojo.Host;

public interface HostService {

	public void saveHost(Host host) throws SysException;

	public void deleteHost(Integer id) throws SysException;

	public Host queryById(Integer id) throws SysException;

	public List<Host> queryAllHost(Integer page,Integer rows) throws SysException;

	
	public void updateHost(Host host) throws SysException;
}
