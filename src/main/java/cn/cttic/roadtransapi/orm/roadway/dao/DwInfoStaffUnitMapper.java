package cn.cttic.roadtransapi.orm.roadway.dao;

import cn.cttic.roadtransapi.orm.roadway.domain.DwInfoStaffUnit;
import cn.cttic.roadtransapi.orm.roadway.domain.DwInfoStaffUnitExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DwInfoStaffUnitMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table DW_INFO_STAFF_UNIT
     *
     * @mbggenerated Fri Jul 24 08:19:14 CST 2015
     */
    int countByExample(DwInfoStaffUnitExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table DW_INFO_STAFF_UNIT
     *
     * @mbggenerated Fri Jul 24 08:19:14 CST 2015
     */
    int deleteByExample(DwInfoStaffUnitExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table DW_INFO_STAFF_UNIT
     *
     * @mbggenerated Fri Jul 24 08:19:14 CST 2015
     */
    int insert(DwInfoStaffUnit record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table DW_INFO_STAFF_UNIT
     *
     * @mbggenerated Fri Jul 24 08:19:14 CST 2015
     */
    int insertSelective(DwInfoStaffUnit record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table DW_INFO_STAFF_UNIT
     *
     * @mbggenerated Fri Jul 24 08:19:14 CST 2015
     */
    List<DwInfoStaffUnit> selectByExample(DwInfoStaffUnitExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table DW_INFO_STAFF_UNIT
     *
     * @mbggenerated Fri Jul 24 08:19:14 CST 2015
     */
    int updateByExampleSelective(@Param("record") DwInfoStaffUnit record, @Param("example") DwInfoStaffUnitExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table DW_INFO_STAFF_UNIT
     *
     * @mbggenerated Fri Jul 24 08:19:14 CST 2015
     */
    int updateByExample(@Param("record") DwInfoStaffUnit record, @Param("example") DwInfoStaffUnitExample example);
}