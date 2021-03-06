package cn.cttic.roadtransapi.orm.waterway.dao;


import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.cttic.roadtransapi.orm.waterway.domain.EntStatisInfo;
import cn.cttic.roadtransapi.orm.waterway.domain.EntStatisInfoExample;
import cn.cttic.roadtransapi.orm.waterway.domain.EntStatisInfoKey;

public interface EntStatisInfoMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ENT_STATIS_INFO
     *
     * @mbggenerated Fri Mar 20 16:45:02 CST 2015
     */
    int countByExample(EntStatisInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ENT_STATIS_INFO
     *
     * @mbggenerated Fri Mar 20 16:45:02 CST 2015
     */
    int deleteByExample(EntStatisInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ENT_STATIS_INFO
     *
     * @mbggenerated Fri Mar 20 16:45:02 CST 2015
     */
    int deleteByPrimaryKey(EntStatisInfoKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ENT_STATIS_INFO
     *
     * @mbggenerated Fri Mar 20 16:45:02 CST 2015
     */
    int insert(EntStatisInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ENT_STATIS_INFO
     *
     * @mbggenerated Fri Mar 20 16:45:02 CST 2015
     */
    int insertSelective(EntStatisInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ENT_STATIS_INFO
     *
     * @mbggenerated Fri Mar 20 16:45:02 CST 2015
     */
    List<EntStatisInfo> selectByExample(EntStatisInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ENT_STATIS_INFO
     *
     * @mbggenerated Fri Mar 20 16:45:02 CST 2015
     */
    EntStatisInfo selectByPrimaryKey(EntStatisInfoKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ENT_STATIS_INFO
     *
     * @mbggenerated Fri Mar 20 16:45:02 CST 2015
     */
    int updateByExampleSelective(@Param("record") EntStatisInfo record, @Param("example") EntStatisInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ENT_STATIS_INFO
     *
     * @mbggenerated Fri Mar 20 16:45:02 CST 2015
     */
    int updateByExample(@Param("record") EntStatisInfo record, @Param("example") EntStatisInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ENT_STATIS_INFO
     *
     * @mbggenerated Fri Mar 20 16:45:02 CST 2015
     */
    int updateByPrimaryKeySelective(EntStatisInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ENT_STATIS_INFO
     *
     * @mbggenerated Fri Mar 20 16:45:02 CST 2015
     */
    int updateByPrimaryKey(EntStatisInfo record);
}