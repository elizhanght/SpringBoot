/**
 */
package com.xunheyun.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xunheyun.mapper.FileMapper;
import com.xunheyun.mapper.PropertyMapper;
import com.xunheyun.service.IFileManageService;
import com.xunheyun.vo.Property;

/**
 * @author eli.zhang
 * @since 1.0
 */
@Service
public class FileManageServiceImpl implements IFileManageService {

	private Logger logger = Logger.getLogger(getClass());
	
	@Autowired
	private PropertyMapper propertyMapper;
	
	@Autowired
	private FileMapper fileMapper;
	
	
	@Override
	public void fileUpload(File file,int projectId) {
		
		Properties prop = new Properties();
		
		try {
			prop.load(new FileInputStream(file));
			
			Set<Object> keys = prop.keySet();
			
			// 创建文件
			com.xunheyun.vo.File pfile = new com.xunheyun.vo.File();
			pfile.setFile_name(file.getName());
			pfile.setProject_id(projectId);
			pfile.setFile_desc("上传的文件");
			fileMapper.insertFile(pfile);
			
			for (Iterator<Object> it = keys.iterator(); it.hasNext();)
			{
				String key = String.valueOf(it.next());
				String value = String.valueOf(prop.get(key));
				
				// 创建文件内的属性
				Property property = new Property();
				property.setPro_key(key);
				property.setPro_value(value);
				property.setFile_id(pfile.getFile_id());
				propertyMapper.insertProperty(property);
			}
			
		} catch (Exception e) {
			logger.error("解析文件异常!",e);
		}
	}

}
