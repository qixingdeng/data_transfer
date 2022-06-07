package cn.cttic.roadtransapi.orm.roadway.dao;

import cn.cttic.roadtransapi.orm.roadway.domain.RtBfB0106;
import cn.cttic.roadtransapi.orm.roadway.domain.RtBfB0106Example;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RtBfB0106Mapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RT_BF_B0106
     *
     * @mbggenerated Tue Sep 08 12:31:54 CST 2015
     */
    int countByExample(RtBfB0106Example example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RT_BF_B0106
     *
     * @mbggenerated Tue Sep 08 12:31:54 CST 2015
     */
    int deleteByExample(RtBfB0106Example example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RT_BF_B0106
     *
     * @mbggenerated Tue Sep 08 12:31:54 CST 2015
     */
    int insert(RtBfB0106 record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RT_BF_B0106
     *
     * @mbggenerated Tue Sep 08 12:31:54 CST 2015
     */
    int insertSelective(RtBfB0106 record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RT_BF_B0106
     *
     * @mbggenerated Tue Sep 08 12:31:54 CST 2015
     */
    List<RtBfB0106> selectByExample(RtBfB0106Example example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RT_BF_B0106
     *
     * @mbggenerated Tue Sep 08 12:31:54 CST 2015
     */
    int updateByExampleSelective(@Param("record") RtBfB0106 record, @Param("example") RtBfB0106Example example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RT_BF_B0106
     *
     * @mbggenerated Tue Sep 08 12:31:54 CST 2015
     */
    int updateByExample(@Param("record") RtBfB0106 record, @Param("example") RtBfB0106Example example);
}