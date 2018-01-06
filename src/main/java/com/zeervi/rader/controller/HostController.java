package com.zeervi.rader.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zeervi.rader.pojo.Host;
import com.zeervi.rader.service.HostService;
import com.zeervi.rader.vo.SysResult;

@RestController
@RequestMapping("host")
public class HostController {
	@Autowired
	private HostService hostService;

	@RequestMapping("add")
	public SysResult addHost(Host host) {
		try {
			hostService.saveHost(host);
			return SysResult.oK();
		} catch (Throwable t) {
			t.printStackTrace();
			return SysResult.build(201, t.getMessage());
		}
	}

	@RequestMapping("del/{id}")
	public SysResult delHost(@PathVariable Integer id) {
		try {
			hostService.deleteHost(id);
			return SysResult.oK();
		} catch (Throwable t) {
			t.printStackTrace();
			return SysResult.build(201, t.getMessage());
		}
	}

	@RequestMapping("query/all")
	public SysResult queryAllHost(@RequestParam(defaultValue = "1") Integer page,
			@RequestParam(defaultValue = "10") Integer rows) {
		try {
			return SysResult.oK(hostService.queryAllHost(page, rows));
		} catch (Throwable t) {
			t.printStackTrace();
			return SysResult.build(201, t.getMessage());
		}
	}

	@RequestMapping("query/{id}")
	public SysResult queryHostById(@PathVariable Integer id) {
		try {
			return SysResult.oK(hostService.queryById(id));
		} catch (Throwable t) {
			t.printStackTrace();
			return SysResult.build(201, t.getMessage());
		}
	}

	@RequestMapping("status/{id}/{status}")
	public SysResult changerStatus(Integer id, Integer status) {
		try {
			Host host = new Host();
			host.setId(id);
			host.setStatus(status);
			hostService.updateHost(host);
			return SysResult.oK();
		} catch (Throwable t) {
			t.printStackTrace();
			return SysResult.build(201, t.getMessage());
		}

	}
}
