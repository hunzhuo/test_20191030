package com.imooc.o2o.web.energy;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/energy",method={RequestMethod.GET})
/*主要用来解析路由并转发到相应的html中*/
public class  Mms301t0AdminController {
	/*
	 * @RequestMapping(value="/shopoperation") public String shopOperation(){
	 * //转发到店铺注册/编辑页面 return "shop/shopoperation"; }
	 */
	
	@RequestMapping(value="/mms301t0list")
	public String mms301t0List(){
		//转发至店铺列表页面
		return "energy/mms301t0";
	}
	
	@RequestMapping(value="/mms301t0list2")
	public String mms301t0List2(){
		//转发至店铺列表页面
		return "energy/mms301t0_2";
	}
	
	@RequestMapping(value="/mms301t0list3")
	public String mms301t0List3(){
		//转发至店铺列表页面
		return "energy/mms301t0_3";
	}
	
}
