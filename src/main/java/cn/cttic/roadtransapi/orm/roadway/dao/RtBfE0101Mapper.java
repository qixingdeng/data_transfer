package cn.cttic.roadtransapi.orm.roadway.dao;

import cn.cttic.roadtransapi.orm.roadway.domain.RtBfE0101;
import cn.cttic.roadtransapi.orm.roadway.domain.RtBfE0101Example;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RtBfE0101Mapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RT_BF_E0101
     *
     * @mbggenerated Mon Jun 15 16:31:19 CST 2015
     */
    int countByExample(RtBfE0101Example example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RT_BF_E0101
     *
     * @mbggenerated Mon Jun 15 16:31:19 CST 2015
     */
    int deleteByExample(RtBfE0101Example example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RT_BF_E0101
     *
     * @mbggenerated Mon Jun 15 16:31:19 CST 2015
     */
    int insert(RtBfE0101 record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RT_BF_E0101
     *
     * @mbggenerated Mon Jun 15 16:31:19 CST 2015
     */
    int insertSelective(RtBfE0101 record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RT_BF_E0101
     *
     * @mbggenerated Mon Jun 15 16:31:19 CST 2015
     */
    List<RtBfE0101> selectByExampleWithBLOBs(RtBfE0101Example example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RT_BF_E0101
     *
     * @mbggenerated Mon Jun 15 16:31:19 CST 2015
     */
    List<RtBfE0101> selectByExample(RtBfE0101Example example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RT_BF_E0101
     *
     * @mbggenerated Mon Jun 15 16:31:19 CST 2015
     */
    int updateByExampleSelective(@Param("record") RtBfE0101 record, @Param("example") RtBfE0101Example example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RT_BF_E0101
     *
     * @mbggenerated Mon Jun 15 16:31:19 CST 2015
     */
    int updateByExampleWithBLOBs(@Param("record") RtBfE0101 record, @Param("example") RtBfE0101Example example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RT_BF_E0101
     *
     * @mbggenerated Mon Jun 15 16:31:19 CST 2015
     */
    int updateByExample(@Param("record") RtBfE0101 record, @Param("example") RtBfE0101Example example);
}