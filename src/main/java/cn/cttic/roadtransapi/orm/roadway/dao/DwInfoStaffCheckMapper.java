package cn.cttic.roadtransapi.orm.roadway.dao;

import cn.cttic.roadtransapi.orm.roadway.domain.DwInfoStaffCheck;
import cn.cttic.roadtransapi.orm.roadway.domain.DwInfoStaffCheckExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DwInfoStaffCheckMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table DW_INFO_SATFF_CHECK
     *
     * @mbggenerated Fri Jul 24 09:09:37 CST 2015
     */
    int countByExample(DwInfoStaffCheckExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table DW_INFO_SATFF_CHECK
     *
     * @mbggenerated Fri Jul 24 09:09:37 CST 2015
     */
    int deleteByExample(DwInfoStaffCheckExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table DW_INFO_SATFF_CHECK
     *
     * @mbggenerated Fri Jul 24 09:09:37 CST 2015
     */
    int insert(DwInfoStaffCheck record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table DW_INFO_SATFF_CHECK
     *
     * @mbggenerated Fri Jul 24 09:09:37 CST 2015
     */
    int insertSelective(DwInfoStaffCheck record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table DW_INFO_SATFF_CHECK
     *
     * @mbggenerated Fri Jul 24 09:09:37 CST 2015
     */
    List<DwInfoStaffCheck> selectByExample(DwInfoStaffCheckExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table DW_INFO_SATFF_CHECK
     *
     * @mbggenerated Fri Jul 24 09:09:37 CST 2015
     */
    int updateByExampleSelective(@Param("record") DwInfoStaffCheck record, @Param("example") DwInfoStaffCheckExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table DW_INFO_SATFF_CHECK
     *
     * @mbggenerated Fri Jul 24 09:09:37 CST 2015
     */
    int updateByExample(@Param("record") DwInfoStaffCheck record, @Param("example") DwInfoStaffCheckExample example);
}