package cn.cttic.roadtransapi.mysql.dao;

import cn.cttic.roadtransapi.mysql.domain.InterSpcAttr;
import cn.cttic.roadtransapi.mysql.domain.InterSpcAttrExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface InterSpcAttrMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table INTER_SPC_ATTR
     *
     * @mbggenerated Tue Jun 09 15:44:54 CST 2015
     */
    int countByExample(InterSpcAttrExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table INTER_SPC_ATTR
     *
     * @mbggenerated Tue Jun 09 15:44:54 CST 2015
     */
    int deleteByExample(InterSpcAttrExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table INTER_SPC_ATTR
     *
     * @mbggenerated Tue Jun 09 15:44:54 CST 2015
     */
    int insert(InterSpcAttr record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table INTER_SPC_ATTR
     *
     * @mbggenerated Tue Jun 09 15:44:54 CST 2015
     */
    int insertSelective(InterSpcAttr record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table INTER_SPC_ATTR
     *
     * @mbggenerated Tue Jun 09 15:44:54 CST 2015
     */
    List<InterSpcAttr> selectByExampleWithBLOBs(InterSpcAttrExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table INTER_SPC_ATTR
     *
     * @mbggenerated Tue Jun 09 15:44:54 CST 2015
     */
    List<InterSpcAttr> selectByExample(InterSpcAttrExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table INTER_SPC_ATTR
     *
     * @mbggenerated Tue Jun 09 15:44:54 CST 2015
     */
    int updateByExampleSelective(@Param("record") InterSpcAttr record, @Param("example") InterSpcAttrExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table INTER_SPC_ATTR
     *
     * @mbggenerated Tue Jun 09 15:44:54 CST 2015
     */
    int updateByExampleWithBLOBs(@Param("record") InterSpcAttr record, @Param("example") InterSpcAttrExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table INTER_SPC_ATTR
     *
     * @mbggenerated Tue Jun 09 15:44:54 CST 2015
     */
    int updateByExample(@Param("record") InterSpcAttr record, @Param("example") InterSpcAttrExample example);
}