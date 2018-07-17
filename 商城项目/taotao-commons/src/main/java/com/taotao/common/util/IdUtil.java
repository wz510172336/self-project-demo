package com.taotao.common.util;

import java.util.Random;

import org.junit.Test;

public class IdUtil {
	@Test
public static long getIdUtil(){
	long currentTimeMillis=System.currentTimeMillis();
	Random random=new Random();
	int i=random.nextInt(99);
	String str=currentTimeMillis+String.format("%02d",  i);
	long itemId=Long.parseLong(str);
	return itemId;


}
}
