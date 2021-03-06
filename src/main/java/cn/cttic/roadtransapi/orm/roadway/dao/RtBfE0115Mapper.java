package cn.cttic.roadtransapi.orm.roadway.dao;

import cn.cttic.roadtransapi.orm.roadway.domain.RtBfE0115;
import cn.cttic.roadtransapi.orm.roadway.domain.RtBfE0115Example;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RtBfE0115Mapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RT_BF_E0115
     *
     * @mbggenerated Tue Sep 08 12:31:54 CST 2015
     */
    int countByExample(RtBfE0115Example example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RT_BF_E0115
     *
     * @mbggenerated Tue Sep 08 12:31:54 CST 2015
     */
    int deleteByExample(RtBfE0115Example example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RT_BF_E0115
     *
     * @mbggenerated Tue Sep 08 12:31:54 CST 2015
     */
    int insert(RtBfE0115 record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RT_BF_E0115
     *
     * @mbggenerated Tue Sep 08 12:31:54 CST 2015
     */
    int insertSelective(RtBfE0115 record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RT_BF_E0115
     *
     * @mbggenerated Tue Sep 08 12:31:54 CST 2015
     */
    List<RtBfE0115> selectByExample(RtBfE0115Example example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RT_BF_E0115
     *
     * @mbggenerated Tue Sep 08 12:31:54 CST 2015
     */
    int updateByExampleSelective(@Param("record") RtBfE0115 record, @Param("example") RtBfE0115Example example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RT_BF_E0115
     *
     * @mbggenerated Tue Sep 08 12:31:54 CST 2015
     */
    int updateByExample(@Param("record") RtBfE0115 record, @Param("example") RtBfE0115Example example);
}