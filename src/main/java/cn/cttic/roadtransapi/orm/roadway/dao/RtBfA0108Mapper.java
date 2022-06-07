package cn.cttic.roadtransapi.orm.roadway.dao;

import cn.cttic.roadtransapi.orm.roadway.domain.RtBfA0108;
import cn.cttic.roadtransapi.orm.roadway.domain.RtBfA0108Example;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RtBfA0108Mapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RT_BF_A0108
     *
     * @mbggenerated Tue Sep 08 12:31:54 CST 2015
     */
    int countByExample(RtBfA0108Example example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RT_BF_A0108
     *
     * @mbggenerated Tue Sep 08 12:31:54 CST 2015
     */
    int deleteByExample(RtBfA0108Example example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RT_BF_A0108
     *
     * @mbggenerated Tue Sep 08 12:31:54 CST 2015
     */
    int insert(RtBfA0108 record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RT_BF_A0108
     *
     * @mbggenerated Tue Sep 08 12:31:54 CST 2015
     */
    int insertSelective(RtBfA0108 record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RT_BF_A0108
     *
     * @mbggenerated Tue Sep 08 12:31:54 CST 2015
     */
    List<RtBfA0108> selectByExample(RtBfA0108Example example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RT_BF_A0108
     *
     * @mbggenerated Tue Sep 08 12:31:54 CST 2015
     */
    int updateByExampleSelective(@Param("record") RtBfA0108 record, @Param("example") RtBfA0108Example example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RT_BF_A0108
     *
     * @mbggenerated Tue Sep 08 12:31:54 CST 2015
     */
    int updateByExample(@Param("record") RtBfA0108 record, @Param("example") RtBfA0108Example example);
}