package cn.cttic.roadtransapi.orm.roadway.dao;

import cn.cttic.roadtransapi.orm.roadway.domain.RtBfE0114;
import cn.cttic.roadtransapi.orm.roadway.domain.RtBfE0114Example;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RtBfE0114Mapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RT_BF_E0114
     *
     * @mbggenerated Tue Sep 08 12:31:54 CST 2015
     */
    int countByExample(RtBfE0114Example example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RT_BF_E0114
     *
     * @mbggenerated Tue Sep 08 12:31:54 CST 2015
     */
    int deleteByExample(RtBfE0114Example example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RT_BF_E0114
     *
     * @mbggenerated Tue Sep 08 12:31:54 CST 2015
     */
    int insert(RtBfE0114 record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RT_BF_E0114
     *
     * @mbggenerated Tue Sep 08 12:31:54 CST 2015
     */
    int insertSelective(RtBfE0114 record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RT_BF_E0114
     *
     * @mbggenerated Tue Sep 08 12:31:54 CST 2015
     */
    List<RtBfE0114> selectByExample(RtBfE0114Example example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RT_BF_E0114
     *
     * @mbggenerated Tue Sep 08 12:31:54 CST 2015
     */
    int updateByExampleSelective(@Param("record") RtBfE0114 record, @Param("example") RtBfE0114Example example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RT_BF_E0114
     *
     * @mbggenerated Tue Sep 08 12:31:54 CST 2015
     */
    int updateByExample(@Param("record") RtBfE0114 record, @Param("example") RtBfE0114Example example);
}