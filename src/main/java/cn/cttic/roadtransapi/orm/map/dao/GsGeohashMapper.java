package cn.cttic.roadtransapi.orm.map.dao;

import cn.cttic.roadtransapi.orm.map.domain.GsGeohash;
import cn.cttic.roadtransapi.orm.map.domain.GsGeohashExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GsGeohashMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table GS_GEOHASH
     *
     * @mbggenerated Tue Oct 27 11:27:44 CST 2015
     */
    int countByExample(GsGeohashExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table GS_GEOHASH
     *
     * @mbggenerated Tue Oct 27 11:27:44 CST 2015
     */
    int deleteByExample(GsGeohashExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table GS_GEOHASH
     *
     * @mbggenerated Tue Oct 27 11:27:44 CST 2015
     */
    int deleteByPrimaryKey(String geohash);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table GS_GEOHASH
     *
     * @mbggenerated Tue Oct 27 11:27:44 CST 2015
     */
    int insert(GsGeohash record);

    int insertList(List<GsGeohash> records);
    
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table GS_GEOHASH
     *
     * @mbggenerated Tue Oct 27 11:27:44 CST 2015
     */
    int insertSelective(GsGeohash record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table GS_GEOHASH
     *
     * @mbggenerated Tue Oct 27 11:27:44 CST 2015
     */
    List<GsGeohash> selectByExample(GsGeohashExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table GS_GEOHASH
     *
     * @mbggenerated Tue Oct 27 11:27:44 CST 2015
     */
    GsGeohash selectByPrimaryKey(String geohash);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table GS_GEOHASH
     *
     * @mbggenerated Tue Oct 27 11:27:44 CST 2015
     */
    int updateByExampleSelective(@Param("record") GsGeohash record, @Param("example") GsGeohashExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table GS_GEOHASH
     *
     * @mbggenerated Tue Oct 27 11:27:44 CST 2015
     */
    int updateByExample(@Param("record") GsGeohash record, @Param("example") GsGeohashExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table GS_GEOHASH
     *
     * @mbggenerated Tue Oct 27 11:27:44 CST 2015
     */
    int updateByPrimaryKeySelective(GsGeohash record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table GS_GEOHASH
     *
     * @mbggenerated Tue Oct 27 11:27:44 CST 2015
     */
    int updateByPrimaryKey(GsGeohash record);
}