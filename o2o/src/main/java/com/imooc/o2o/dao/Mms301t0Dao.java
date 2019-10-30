package com.imooc.o2o.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.imooc.o2o.entity.Mms301t0;

public interface Mms301t0Dao {
	/*
	 * List<Mms301t0> queryMms301t0List(@Param("mms301t0Condition") Mms301t0
	 * mms301t0Condition,
	 * 
	 * @Param("factno") int factno, @Param("yyyymmdd") int yyyymmdd);
	 */
	List<Mms301t0> queryMms301t0List(long mms301t0Id);
	
	List<Mms301t0> queryMms301t0List2(String fuel_no,String kind);
	
	List<Mms301t0> queryMms301t0List3(String fuel_no,String kind);

}
