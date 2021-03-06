package cn.cttic.roadtransapi.orm.roadway.dao;

import cn.cttic.roadtransapi.orm.roadway.domain.RtBfC0102;
import cn.cttic.roadtransapi.orm.roadway.domain.RtBfC0102Example;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RtBfC0102Mapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RT_BF_C0102
     *
     * @mbggenerated Mon Jun 15 16:31:19 CST 2015
     */
    int countByExample(RtBfC0102Example example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RT_BF_C0102
     *
     * @mbggenerated Mon Jun 15 16:31:19 CST 2015
     */
    int deleteByExample(RtBfC0102Example example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RT_BF_C0102
     *
     * @mbggenerated Mon Jun 15 16:31:19 CST 2015
     */
    int insert(RtBfC0102 record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RT_BF_C0102
     *
     * @mbggenerated Mon Jun 15 16:31:19 CST 2015
     */
    int insertSelective(RtBfC0102 record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RT_BF_C0102
     *
     * @mbggenerated Mon Jun 15 16:31:19 CST 2015
     */
    List<RtBfC0102> selectByExample(RtBfC0102Example example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RT_BF_C0102
     *
     * @mbggenerated Mon Jun 15 16:31:19 CST 2015
     */
    int updateByExampleSelective(@Param("record") RtBfC0102 record, @Param("example") RtBfC0102Example example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RT_BF_C0102
     *
     * @mbggenerated Mon Jun 15 16:31:19 CST 2015
     */
    int updateByExample(@Param("record") RtBfC0102 record, @Param("example") RtBfC0102Example example);
}