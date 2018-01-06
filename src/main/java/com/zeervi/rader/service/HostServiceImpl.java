package com.zeervi.rader.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zeervi.rader.extend.SysException;
import com.zeervi.rader.mapper.HostMapper;
import com.zeervi.rader.pojo.Host;

@Service
public class HostServiceImpl extends BaseService<Host> implements HostService {

	@Autowired
	private HostMapper hostMapper;

	public void saveHost(Host host) throws SysException {
		host.setId(null);
		host.setCreated(new Date());
		host.setUpdated(host.getCreated());
		int i = hostMapper.insertSelective(host);
		if (i != 1) {
			throw new SysException("save host  error");
		}
	}

	public void deleteHost(Integer id) throws SysException {
		int i = super.deleteById(id);
		if (i != 1) {
			throw new SysException("id error by del");
		}
	}

	public Host queryById(Integer id) throws SysException {

		Host host = super.queryById(id);
		if (host == null) {
			throw new SysException("id error by query");
		}
		return host;
	}

	public List<Host> queryAllHost(Integer page, Integer rows) throws SysException {
		PageHelper.startPage(page, rows);
		List<Host> hosts = hostMapper.queryAllHost();
		PageInfo<Host> info = new PageInfo<>(hosts);
		if (hosts == null || hosts.size() < 0) {
			throw new SysException("query all host error");
		}
		return info.getList();
	}

	@Override
	public void updateHost(Host host) throws SysException {
		host.setUpdated(new Date());
		int i = super.updateSelective(host);
		if (i != 1) {
			throw new SysException("update host error");
		}
	}

}
