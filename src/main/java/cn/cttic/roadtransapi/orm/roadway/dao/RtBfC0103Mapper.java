package cn.cttic.roadtransapi.orm.roadway.dao;

import cn.cttic.roadtransapi.orm.roadway.domain.RtBfC0103;
import cn.cttic.roadtransapi.orm.roadway.domain.RtBfC0103Example;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RtBfC0103Mapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RT_BF_C0103
     *
     * @mbggenerated Mon Jun 15 16:31:19 CST 2015
     */
    int countByExample(RtBfC0103Example example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RT_BF_C0103
     *
     * @mbggenerated Mon Jun 15 16:31:19 CST 2015
     */
    int deleteByExample(RtBfC0103Example example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RT_BF_C0103
     *
     * @mbggenerated Mon Jun 15 16:31:19 CST 2015
     */
    int insert(RtBfC0103 record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RT_BF_C0103
     *
     * @mbggenerated Mon Jun 15 16:31:19 CST 2015
     */
    int insertSelective(RtBfC0103 record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RT_BF_C0103
     *
     * @mbggenerated Mon Jun 15 16:31:19 CST 2015
     */
    List<RtBfC0103> selectByExample(RtBfC0103Example example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RT_BF_C0103
     *
     * @mbggenerated Mon Jun 15 16:31:19 CST 2015
     */
    int updateByExampleSelective(@Param("record") RtBfC0103 record, @Param("example") RtBfC0103Example example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RT_BF_C0103
     *
     * @mbggenerated Mon Jun 15 16:31:19 CST 2015
     */
    int updateByExample(@Param("record") RtBfC0103 record, @Param("example") RtBfC0103Example example);
}