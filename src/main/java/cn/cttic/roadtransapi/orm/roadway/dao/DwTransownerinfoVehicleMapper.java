package cn.cttic.roadtransapi.orm.roadway.dao;

import cn.cttic.roadtransapi.orm.roadway.domain.DwTransownerinfoVehicle;
import cn.cttic.roadtransapi.orm.roadway.domain.DwTransownerinfoVehicleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DwTransownerinfoVehicleMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table DW_TRANSOWNERINFO_VEHICLE
     *
     * @mbggenerated Tue Jul 28 16:53:31 CST 2015
     */
    int countByExample(DwTransownerinfoVehicleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table DW_TRANSOWNERINFO_VEHICLE
     *
     * @mbggenerated Tue Jul 28 16:53:31 CST 2015
     */
    int deleteByExample(DwTransownerinfoVehicleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table DW_TRANSOWNERINFO_VEHICLE
     *
     * @mbggenerated Tue Jul 28 16:53:31 CST 2015
     */
    int insert(DwTransownerinfoVehicle record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table DW_TRANSOWNERINFO_VEHICLE
     *
     * @mbggenerated Tue Jul 28 16:53:31 CST 2015
     */
    int insertSelective(DwTransownerinfoVehicle record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table DW_TRANSOWNERINFO_VEHICLE
     *
     * @mbggenerated Tue Jul 28 16:53:31 CST 2015
     */
    List<DwTransownerinfoVehicle> selectByExample(DwTransownerinfoVehicleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table DW_TRANSOWNERINFO_VEHICLE
     *
     * @mbggenerated Tue Jul 28 16:53:31 CST 2015
     */
    int updateByExampleSelective(@Param("record") DwTransownerinfoVehicle record, @Param("example") DwTransownerinfoVehicleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table DW_TRANSOWNERINFO_VEHICLE
     *
     * @mbggenerated Tue Jul 28 16:53:31 CST 2015
     */
    int updateByExample(@Param("record") DwTransownerinfoVehicle record, @Param("example") DwTransownerinfoVehicleExample example);
}