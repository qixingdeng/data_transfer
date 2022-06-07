package cn.cttic.roadtransapi.orm.roadway.dao;

import cn.cttic.roadtransapi.orm.roadway.domain.RtBfE0102;
import cn.cttic.roadtransapi.orm.roadway.domain.RtBfE0102Example;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RtBfE0102Mapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RT_BF_E0102
     *
     * @mbggenerated Mon Jun 15 16:31:19 CST 2015
     */
    int countByExample(RtBfE0102Example example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RT_BF_E0102
     *
     * @mbggenerated Mon Jun 15 16:31:19 CST 2015
     */
    int deleteByExample(RtBfE0102Example example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RT_BF_E0102
     *
     * @mbggenerated Mon Jun 15 16:31:19 CST 2015
     */
    int insert(RtBfE0102 record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RT_BF_E0102
     *
     * @mbggenerated Mon Jun 15 16:31:19 CST 2015
     */
    int insertSelective(RtBfE0102 record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RT_BF_E0102
     *
     * @mbggenerated Mon Jun 15 16:31:19 CST 2015
     */
    List<RtBfE0102> selectByExample(RtBfE0102Example example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RT_BF_E0102
     *
     * @mbggenerated Mon Jun 15 16:31:19 CST 2015
     */
    int updateByExampleSelective(@Param("record") RtBfE0102 record, @Param("example") RtBfE0102Example example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RT_BF_E0102
     *
     * @mbggenerated Mon Jun 15 16:31:19 CST 2015
     */
    int updateByExample(@Param("record") RtBfE0102 record, @Param("example") RtBfE0102Example example);
}