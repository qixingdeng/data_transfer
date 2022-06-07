package cn.cttic.roadtransapi.orm.roadway.dao;

import cn.cttic.roadtransapi.orm.roadway.domain.SmParamDetail2;
import cn.cttic.roadtransapi.orm.roadway.domain.SmParamDetail2Example;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SmParamDetail2Mapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SM_PARAM_DETAIL
     *
     * @mbggenerated Fri Aug 07 16:55:31 CST 2015
     */
    int countByExample(SmParamDetail2Example example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SM_PARAM_DETAIL
     *
     * @mbggenerated Fri Aug 07 16:55:31 CST 2015
     */
    int deleteByExample(SmParamDetail2Example example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SM_PARAM_DETAIL
     *
     * @mbggenerated Fri Aug 07 16:55:31 CST 2015
     */
    int insert(SmParamDetail2 record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SM_PARAM_DETAIL
     *
     * @mbggenerated Fri Aug 07 16:55:31 CST 2015
     */
    int insertSelective(SmParamDetail2 record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SM_PARAM_DETAIL
     *
     * @mbggenerated Fri Aug 07 16:55:31 CST 2015
     */
    List<SmParamDetail2> selectByExample(SmParamDetail2Example example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SM_PARAM_DETAIL
     *
     * @mbggenerated Fri Aug 07 16:55:31 CST 2015
     */
    int updateByExampleSelective(@Param("record") SmParamDetail2 record, @Param("example") SmParamDetail2Example example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SM_PARAM_DETAIL
     *
     * @mbggenerated Fri Aug 07 16:55:31 CST 2015
     */
    int updateByExample(@Param("record") SmParamDetail2 record, @Param("example") SmParamDetail2Example example);
}