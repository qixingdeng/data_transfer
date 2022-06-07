/*
 * Project: RDTRANS
 * Copyright 2015 CTTIC
 * All right reserved.
 */
package cn.cttic.roadtransapi.orm.roadway.dao;

import cn.cttic.roadtransapi.orm.roadway.domain.DwBaseinfoLineOwner;
import cn.cttic.roadtransapi.orm.roadway.domain.DwBaseinfoLineOwnerExample;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

/**
 * 建立日期 : 2015-7-28 上午11:47:36<br>
 * 作者 : liuzhenliang@cttic.cn<br>
 * 模块 : <br>
 * 描述 : <br>
 * 修改历史 <br>
 * 序号 日期 修改人 修改原因 <br>
 * 1 <br>
 * 2 <br>
 */
public interface DwBaseinfoLineOwnerMapper
{
	PageList<DwBaseinfoLineOwner> selectByExampleForPage(DwBaseinfoLineOwnerExample example,PageBounds pageBounds);
}
