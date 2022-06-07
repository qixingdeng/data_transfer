package cn.cttic.roadtransapi.dbmapper;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

public interface BaseMapper<Domain, Example> {
	PageList<Domain> selectByExampleForPage(Example example,PageBounds pageBounds);
}
