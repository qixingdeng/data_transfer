package cn.cttic.roadtransapi.orm.roadway.dao;

import cn.cttic.roadtransapi.orm.roadway.domain.RtBfB0107;
import cn.cttic.roadtransapi.orm.roadway.domain.RtBfB0107Example;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RtBfB0107Mapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RT_BF_B0107
     *
     * @mbggenerated Tue Sep 08 12:31:54 CST 2015
     */
    int countByExample(RtBfB0107Example example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RT_BF_B0107
     *
     * @mbggenerated Tue Sep 08 12:31:54 CST 2015
     */
    int deleteByExample(RtBfB0107Example example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RT_BF_B0107
     *
     * @mbggenerated Tue Sep 08 12:31:54 CST 2015
     */
    int insert(RtBfB0107 record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RT_BF_B0107
     *
     * @mbggenerated Tue Sep 08 12:31:54 CST 2015
     */
    int insertSelective(RtBfB0107 record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RT_BF_B0107
     *
     * @mbggenerated Tue Sep 08 12:31:54 CST 2015
     */
    List<RtBfB0107> selectByExample(RtBfB0107Example example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RT_BF_B0107
     *
     * @mbggenerated Tue Sep 08 12:31:54 CST 2015
     */
    int updateByExampleSelective(@Param("record") RtBfB0107 record, @Param("example") RtBfB0107Example example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RT_BF_B0107
     *
     * @mbggenerated Tue Sep 08 12:31:54 CST 2015
     */
    int updateByExample(@Param("record") RtBfB0107 record, @Param("example") RtBfB0107Example example);
}