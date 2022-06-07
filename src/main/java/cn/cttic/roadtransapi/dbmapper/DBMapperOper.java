package cn.cttic.roadtransapi.dbmapper;

public interface DBMapperOper {

	public int countbyexample(Object example);

	public int deleteByExample(Object example);

	public int deleteByPrimaryKey(Object... PrimaryKey);

	public int insert(Object record);

	public int insertSelective(Object record);

	public Object selectByExample(Object example);

	public Object selectByPrimaryKey(Object... PrimaryKey);

	public int updateByExampleSelective(Object record, Object example);

	public int updateByExample(Object record, Object example);

	public int updateByPrimaryKeySelective(Object record);

	public int updateByPrimaryKey(Object record);

	public Object insertForObject(Object record, Object bean);

}
