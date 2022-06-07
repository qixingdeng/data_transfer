package cn.cttic.roadtransapi.orm.roadway.dao;

import cn.cttic.roadtransapi.orm.roadway.domain.RtBfA0104;
import cn.cttic.roadtransapi.orm.roadway.domain.RtBfA0104Example;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RtBfA0104Mapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RT_BF_A0104
     *
     * @mbggenerated Tue Sep 08 12:31:54 CST 2015
     */
    int countByExample(RtBfA0104Example example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RT_BF_A0104
     *
     * @mbggenerated Tue Sep 08 12:31:54 CST 2015
     */
    int deleteByExample(RtBfA0104Example example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RT_BF_A0104
     *
     * @mbggenerated Tue Sep 08 12:31:54 CST 2015
     */
    int insert(RtBfA0104 record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RT_BF_A0104
     *
     * @mbggenerated Tue Sep 08 12:31:54 CST 2015
     */
    int insertSelective(RtBfA0104 record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RT_BF_A0104
     *
     * @mbggenerated Tue Sep 08 12:31:54 CST 2015
     */
    List<RtBfA0104> selectByExample(RtBfA0104Example example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RT_BF_A0104
     *
     * @mbggenerated Tue Sep 08 12:31:54 CST 2015
     */
    int updateByExampleSelective(@Param("record") RtBfA0104 record, @Param("example") RtBfA0104Example example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RT_BF_A0104
     *
     * @mbggenerated Tue Sep 08 12:31:54 CST 2015
     */
    int updateByExample(@Param("record") RtBfA0104 record, @Param("example") RtBfA0104Example example);
}