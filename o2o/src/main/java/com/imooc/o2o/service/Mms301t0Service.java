package com.imooc.o2o.service;

//import java.io.File;
import java.io.IOException;
//import java.io.InputStream;
import java.util.List;

//import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
//import com.imooc.o2o.dto.ImageHolder;
//import com.imooc.o2o.dto.ShopExecution;
//import com.imooc.o2o.entity.Area;
import com.imooc.o2o.entity.Mms301t0;
//import com.imooc.o2o.entity.Shop;
//import com.imooc.o2o.exceptions.ShopOperationException;

public interface Mms301t0Service {
	
	List<Mms301t0> getMms301t0List(long mms301t0Id) throws JsonParseException, JsonMappingException,
	IOException;
	
	List<Mms301t0> getMms301t0List2(String fuel_no,String kind) throws JsonParseException, JsonMappingException,
	IOException;
	
	List<Mms301t0> getMms301t0List3(String fuel_no,String kind) throws JsonParseException, JsonMappingException,
	IOException;
	
}
