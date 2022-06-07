/*
 * Project: RDTRANS
 * Copyright 2015 CTTIC
 * All right reserved.
 */
package cn.cttic.roadtransapi.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.cttic.roadtransapi.mgr.DBMgr;

/**
 * 建立日期 : 2015-8-12 上午11:11:15<br>
 * 作者 : liuzhenliang@cttic.cn<br>
 * 模块 : <br>
 * 描述 : <br>
 * 修改历史 <br>
 * 序号 日期 修改人 修改原因 <br>
 * 1 <br>
 * 2 <br>
 */
@Controller
@RequestMapping(value = "/system")
public class SystemController
{

	@RequestMapping(params = "reload")
	public void reload()
	{
		Map<String, Object> retMap = new HashMap<String, Object>();
		DBMgr.reload();
	}
}
