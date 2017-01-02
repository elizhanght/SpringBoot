/**
 */
package com.xunheyun.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xunheyun.mapper.WarMapper;
import com.xunheyun.service.IWarService;
import com.xunheyun.vo.War;

/**
 * @author eli.zhang
 * @since 1.0
 */
@Service
public class WarServiceImpl implements IWarService {

	private Logger logger = Logger.getLogger(getClass());
	
	@Autowired
	private WarMapper warMapper;

	@Override
	public void saveUploadFile(War war) {
		
		warMapper.insertWar(war);
	}

	@Override
	public int deleteFileUploadFile(int fileId) {
		
		
		return 0;
	}

	@Override
	public List<War> list(int project_id) {
		
		return warMapper.list(project_id);
	}
	

}
