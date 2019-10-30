package com.imooc.o2o.web.energy;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
//import com.imooc.o2o.dto.ShopExecution;
//import com.imooc.o2o.entity.Area;
import com.imooc.o2o.entity.Mms301t0;
//import com.imooc.o2o.entity.Shop;
//import com.imooc.o2o.entity.ShopCategory;
//import com.imooc.o2o.service.AreaService;
import com.imooc.o2o.service.Mms301t0Service;
//import com.imooc.o2o.service.ShopCategoryService;
//import com.imooc.o2o.service.ShopService;
import com.imooc.o2o.util.HttpServletRequestUtil;

@Controller
@RequestMapping("/energy")
public class      Mms301t0ListController {
	/*
	 * @Autowired private AreaService areaService;
	 * 
	 * @Autowired private ShopCategoryService shopCategoryService;
	 * 
	 * @Autowired private ShopService shopService;
	 */

	@Autowired
	private Mms301t0Service mms301t0Service;

	@RequestMapping(value = "/listmms301t0info", method = RequestMethod.GET)
	@ResponseBody // 返回值为json
	private Map<String, Object> listMms301t0Info(HttpServletRequest request) {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		List<Mms301t0> mms301t0List = null;
		try {
			// 获取区域列表信息
			long mms301t0_id = 1;
			mms301t0List = mms301t0Service.getMms301t0List(mms301t0_id);
			modelMap.put("mms301t0List", mms301t0List);
			modelMap.put("success", true);
			return modelMap;
		} catch (Exception e) {
			modelMap.put("success", false);
			modelMap.put("errMsg", e.getMessage());
		}

		return modelMap;
	}
	
	
	@RequestMapping(value = "/listmms301t0info2", method = RequestMethod.GET)
	@ResponseBody // 返回值为json
	private Map<String, Object> listMms301t0Info2(HttpServletRequest request) {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		List<Mms301t0> mms301t0List2 = null;
		try {
			// 获取区域列表信息
			String fuel_no = "11";
			String kind = "0001";
			mms301t0List2 = mms301t0Service.getMms301t0List2(fuel_no,kind);
			modelMap.put("mms301t0List2", mms301t0List2);
			modelMap.put("success", true);
			return modelMap;
		} catch (Exception e) {
			modelMap.put("success", false);
			modelMap.put("errMsg", e.getMessage());
		}

		return modelMap;
	}

	
	
	@RequestMapping(value = "/listmms301t0info3", method = RequestMethod.GET)
	@ResponseBody // 返回值为json
	private Map<String, Object> listMms301t0Info3(HttpServletRequest request) {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		List<Mms301t0> mms301t0List3 = null;
		try {
			// 获取能源代号列表信息
			String fuel_no = HttpServletRequestUtil.getString(request,
					"fuel_no");
			//String fuel_no = "11";
			String kind = "0001";
			mms301t0List3 = mms301t0Service.getMms301t0List3(fuel_no,kind);
			modelMap.put("mms301t0List3", mms301t0List3);
			modelMap.put("success", true);
			return modelMap;
		} catch (Exception e) {
			modelMap.put("success", false);
			modelMap.put("errMsg", e.getMessage());
		}

		return modelMap;
	}
	
}
