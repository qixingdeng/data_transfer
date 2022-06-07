package cn.cttic.roadtransapi.orm.roadway.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.cttic.roadtransapi.orm.roadway.domain.DwInfoVehicleAnnulcheck;
import cn.cttic.roadtransapi.orm.roadway.domain.DwInfoVehicleAnnulcheckExample;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

public interface DwInfoVehicleAnnulcheckMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table DW_INFO_VEHICLE_ANNULCHECK
     *
     * @mbggenerated Fri Jul 24 08:19:14 CST 2015
     */
    int countByExample(DwInfoVehicleAnnulcheckExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table DW_INFO_VEHICLE_ANNULCHECK
     *
     * @mbggenerated Fri Jul 24 08:19:14 CST 2015
     */
    int deleteByExample(DwInfoVehicleAnnulcheckExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table DW_INFO_VEHICLE_ANNULCHECK
     *
     * @mbggenerated Fri Jul 24 08:19:14 CST 2015
     */
    int insert(DwInfoVehicleAnnulcheck record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table DW_INFO_VEHICLE_ANNULCHECK
     *
     * @mbggenerated Fri Jul 24 08:19:14 CST 2015
     */
    int insertSelective(DwInfoVehicleAnnulcheck record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table DW_INFO_VEHICLE_ANNULCHECK
     *
     * @mbggenerated Fri Jul 24 08:19:14 CST 2015
     */
    List<DwInfoVehicleAnnulcheck> selectByExample(DwInfoVehicleAnnulcheckExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table DW_INFO_VEHICLE_ANNULCHECK
     *
     * @mbggenerated Fri Jul 24 08:19:14 CST 2015
     */
    int updateByExampleSelective(@Param("record") DwInfoVehicleAnnulcheck record, @Param("example") DwInfoVehicleAnnulcheckExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table DW_INFO_VEHICLE_ANNULCHECK
     *
     * @mbggenerated Fri Jul 24 08:19:14 CST 2015
     */
    int updateByExample(@Param("record") DwInfoVehicleAnnulcheck record, @Param("example") DwInfoVehicleAnnulcheckExample example);
    
    
    PageList<DwInfoVehicleAnnulcheck> selectByExampleForPage(DwInfoVehicleAnnulcheckExample example,PageBounds pageBounds);

    
}