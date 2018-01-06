package com.zeervi.rader.mapper;

import java.util.List;

import com.zeervi.rader.pojo.Host;

public interface HostMapper extends SysMapper<Host>{
	List<Host> queryAllHost();
}
