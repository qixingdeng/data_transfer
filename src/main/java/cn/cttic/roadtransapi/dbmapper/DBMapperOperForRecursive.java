package cn.cttic.roadtransapi.dbmapper;

public interface DBMapperOperForRecursive {

	public int insertForRecursive(Object record);

	public int insertSelectiveForRecursive(Object record);

	public int updateByPrimaryKeySelectiveForRecursive(Object record);

	public int updateByPrimaryKeyForRecursive(Object record);
}
