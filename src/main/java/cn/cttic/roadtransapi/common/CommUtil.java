/*
 * Project: RDTRANS
 * Copyright 2015 CTTIC
 * All right reserved.
 */
package cn.cttic.roadtransapi.common;

import java.io.BufferedReader;

/**
 * 建立日期 : 2015-7-27 上午11:07:49<br>
 * 作者 : liuzhenliang@cttic.cn<br>
 * 模块 : <br>
 * 描述 : <br>
 * 修改历史 <br>
 * 序号 日期 修改人 修改原因 <br>
 * 1 <br>
 * 2 <br>
 */
public class CommUtil
{
	public static String readFromFile(String fileName)
	{
		StringBuffer sb = new StringBuffer();
		String temStr = "";
		BufferedReader br = null;
		try
		{
			java.io.InputStreamReader re = new java.io.InputStreamReader(new java.io.FileInputStream(fileName), "UTF-8");
			br = new BufferedReader(re);
			int i = 0;
			while ((temStr = br.readLine()) != null)
			{
				i++;
				if (!temStr.trim().equals("")) // 不是空行
				{
					sb.append(temStr.trim());
				}
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			if (br != null)
			{
				try
				{
					br.close();
				}
				catch (Exception ex1)
				{
					ex1.printStackTrace();
				}
			}
		}

		return sb.toString();
	}
}
