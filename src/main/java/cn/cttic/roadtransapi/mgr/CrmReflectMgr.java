package cn.cttic.roadtransapi.mgr;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import cn.cttic.roadtransapi.code.InterStatusCode;
import cn.cttic.roadtransapi.common.IntfFieldConvterMeta;
import cn.cttic.roadtransapi.common.IntfFieldMeta;
import cn.cttic.roadtransapi.common.IntfFieldMetaArray;
import cn.cttic.roadtransapi.common.SortableField;
import cn.cttic.roadtransapi.common.SortableFieldList;

public class CrmReflectMgr  {

	private CrmReflectMgr() {

		init();
	}

	private void init() {
	}

	private SortableFieldList initFields(Class<?> type) {
		SortableFieldList list = new SortableFieldList(type);
		Field[] fields = type.getDeclaredFields();

		SortableField infoField = null;
		IntfFieldMeta meta = null;
		IntfFieldMetaArray metaArray = null;
		IntfFieldConvterMeta IntfFieldConvterMeta = null;
		for (Field field : fields) {
			infoField = new SortableField(field);
			meta = field.getAnnotation(IntfFieldMeta.class);
			if (meta != null) {
				infoField.setMeta(meta);
			}

			metaArray = field.getAnnotation(IntfFieldMetaArray.class);
			if (metaArray != null) {
				infoField.setMetaArray(metaArray);
			}
			
			IntfFieldConvterMeta = field.getAnnotation(IntfFieldConvterMeta.class);
			if (IntfFieldConvterMeta != null) {
				infoField.setIntfFieldConvterMeta(IntfFieldConvterMeta);
			}


			if (metaArray != null || meta != null) {
				list.add(infoField);
			}

		}

		list.InitFileldList();
		return list;
	}

	public static CrmReflectMgr getInstance() {
		if (uniqueInstance == null) {
			uniqueInstance = new CrmReflectMgr();
		}
		return uniqueInstance;
	}

	public SortableFieldList GetField(String name) {
		return SortableFieldList.get(name);
	}

	private static CrmReflectMgr uniqueInstance = null;

	private Map<String, SortableFieldList> SortableFieldList = new HashMap<String, SortableFieldList>();

	

}