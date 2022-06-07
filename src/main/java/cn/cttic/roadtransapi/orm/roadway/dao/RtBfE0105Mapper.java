package cn.cttic.roadtransapi.orm.roadway.dao;

import cn.cttic.roadtransapi.orm.roadway.domain.RtBfE0105;
import cn.cttic.roadtransapi.orm.roadway.domain.RtBfE0105Example;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RtBfE0105Mapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RT_BF_E0105
     *
     * @mbggenerated Tue Sep 08 12:31:54 CST 2015
     */
    int countByExample(RtBfE0105Example example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RT_BF_E0105
     *
     * @mbggenerated Tue Sep 08 12:31:54 CST 2015
     */
    int deleteByExample(RtBfE0105Example example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RT_BF_E0105
     *
     * @mbggenerated Tue Sep 08 12:31:54 CST 2015
     */
    int insert(RtBfE0105 record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RT_BF_E0105
     *
     * @mbggenerated Tue Sep 08 12:31:54 CST 2015
     */
    int insertSelective(RtBfE0105 record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RT_BF_E0105
     *
     * @mbggenerated Tue Sep 08 12:31:54 CST 2015
     */
    List<RtBfE0105> selectByExample(RtBfE0105Example example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RT_BF_E0105
     *
     * @mbggenerated Tue Sep 08 12:31:54 CST 2015
     */
    int updateByExampleSelective(@Param("record") RtBfE0105 record, @Param("example") RtBfE0105Example example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RT_BF_E0105
     *
     * @mbggenerated Tue Sep 08 12:31:54 CST 2015
     */
    int updateByExample(@Param("record") RtBfE0105 record, @Param("example") RtBfE0105Example example);
}