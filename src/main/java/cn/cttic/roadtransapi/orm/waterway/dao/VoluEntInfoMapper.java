package cn.cttic.roadtransapi.orm.waterway.dao;

import cn.cttic.roadtransapi.orm.waterway.domain.VoluEntInfo;
import cn.cttic.roadtransapi.orm.waterway.domain.VoluEntInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface VoluEntInfoMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table VOLU_ENT_INFO
     *
     * @mbggenerated Fri Apr 10 09:51:42 CST 2015
     */
    int countByExample(VoluEntInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table VOLU_ENT_INFO
     *
     * @mbggenerated Fri Apr 10 09:51:42 CST 2015
     */
    int deleteByExample(VoluEntInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table VOLU_ENT_INFO
     *
     * @mbggenerated Fri Apr 10 09:51:42 CST 2015
     */
    int deleteByPrimaryKey(Long entRepoId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table VOLU_ENT_INFO
     *
     * @mbggenerated Fri Apr 10 09:51:42 CST 2015
     */
    int insert(VoluEntInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table VOLU_ENT_INFO
     *
     * @mbggenerated Fri Apr 10 09:51:42 CST 2015
     */
    int insertSelective(VoluEntInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table VOLU_ENT_INFO
     *
     * @mbggenerated Fri Apr 10 09:51:42 CST 2015
     */
    List<VoluEntInfo> selectByExample(VoluEntInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table VOLU_ENT_INFO
     *
     * @mbggenerated Fri Apr 10 09:51:42 CST 2015
     */
    VoluEntInfo selectByPrimaryKey(Long entRepoId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table VOLU_ENT_INFO
     *
     * @mbggenerated Fri Apr 10 09:51:42 CST 2015
     */
    int updateByExampleSelective(@Param("record") VoluEntInfo record, @Param("example") VoluEntInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table VOLU_ENT_INFO
     *
     * @mbggenerated Fri Apr 10 09:51:42 CST 2015
     */
    int updateByExample(@Param("record") VoluEntInfo record, @Param("example") VoluEntInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table VOLU_ENT_INFO
     *
     * @mbggenerated Fri Apr 10 09:51:42 CST 2015
     */
    int updateByPrimaryKeySelective(VoluEntInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table VOLU_ENT_INFO
     *
     * @mbggenerated Fri Apr 10 09:51:42 CST 2015
     */
    int updateByPrimaryKey(VoluEntInfo record);
}