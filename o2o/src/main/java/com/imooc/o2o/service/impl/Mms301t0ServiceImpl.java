package com.imooc.o2o.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

//import com.fasterxml.jackson.core.JsonParseException;
//import com.fasterxml.jackson.databind.JavaType;
//import com.fasterxml.jackson.databind.JsonMappingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.imooc.o2o.cache.JedisUtil;
//import com.imooc.o2o.dao.AreaDao;
import com.imooc.o2o.dao.Mms301t0Dao;
//import com.imooc.o2o.dto.AreaExecution;
//import com.imooc.o2o.entity.Area;
import com.imooc.o2o.entity.Mms301t0;
//import com.imooc.o2o.enums.AreaStateEnum;
//import com.imooc.o2o.service.AreaService;
import com.imooc.o2o.service.Mms301t0Service;

@Service
public class Mms301t0ServiceImpl implements Mms301t0Service {
	/*@Autowired
	private JedisUtil.Strings jedisStrings;
	@Autowired
	private JedisUtil.Keys jedisKeys;*/
	@Autowired
	private Mms301t0Dao mms301t0Dao;

	private static String AREALISTKEY = "arealist";

	public List<Mms301t0> getMms301t0List(long mms301t0Id){
		return mms301t0Dao.queryMms301t0List(mms301t0Id);
	}
	
	public List<Mms301t0> getMms301t0List2(String fuel_no,String kind){
		return mms301t0Dao.queryMms301t0List2(fuel_no,kind);
	}
	
	public List<Mms301t0> getMms301t0List3(String fuel_no,String kind){
		return mms301t0Dao.queryMms301t0List3(fuel_no,kind);
	}
}
