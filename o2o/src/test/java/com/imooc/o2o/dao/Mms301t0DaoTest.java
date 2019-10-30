package com.imooc.o2o.dao;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

//import com.imooc.o2o.entity.Area;
import com.imooc.o2o.entity.Mms301t0;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Mms301t0DaoTest{
	@Autowired
	private Mms301t0Dao mms301t0Dao;

	

	@Test
	public void testQueryMms301t0List() throws Exception {
		long mms301t0Id=1;
		List<Mms301t0> queryMms301t0List = mms301t0Dao.queryMms301t0List(mms301t0Id);
		System.out.println("count:"+queryMms301t0List.size());
		//assertEquals(2, queryMms301t0List.size());
	}

}
