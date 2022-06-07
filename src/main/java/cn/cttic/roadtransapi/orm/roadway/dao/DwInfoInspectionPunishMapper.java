package cn.cttic.roadtransapi.orm.roadway.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.cttic.roadtransapi.orm.roadway.domain.DwInfoInspectionPunish;
import cn.cttic.roadtransapi.orm.roadway.domain.DwInfoInspectionPunishExample;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

public interface DwInfoInspectionPunishMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table DW_INFO_INSPECTION_PUNISH
     *
     * @mbggenerated Mon Mar 16 14:45:00 CST 2015
     */
    int countByExample(DwInfoInspectionPunishExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table DW_INFO_INSPECTION_PUNISH
     *
     * @mbggenerated Mon Mar 16 14:45:00 CST 2015
     */
    int deleteByExample(DwInfoInspectionPunishExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table DW_INFO_INSPECTION_PUNISH
     *
     * @mbggenerated Mon Mar 16 14:45:00 CST 2015
     */
    int insert(DwInfoInspectionPunish record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table DW_INFO_INSPECTION_PUNISH
     *
     * @mbggenerated Mon Mar 16 14:45:00 CST 2015
     */
    int insertSelective(DwInfoInspectionPunish record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table DW_INFO_INSPECTION_PUNISH
     *
     * @mbggenerated Mon Mar 16 14:45:00 CST 2015
     */
    List<DwInfoInspectionPunish> selectByExample(DwInfoInspectionPunishExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table DW_INFO_INSPECTION_PUNISH
     *
     * @mbggenerated Mon Mar 16 14:45:00 CST 2015
     */
    int updateByExampleSelective(@Param("record") DwInfoInspectionPunish record, @Param("example") DwInfoInspectionPunishExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table DW_INFO_INSPECTION_PUNISH
     *
     * @mbggenerated Mon Mar 16 14:45:00 CST 2015
     */
    int updateByExample(@Param("record") DwInfoInspectionPunish record, @Param("example") DwInfoInspectionPunishExample example);
    
    PageList<DwInfoInspectionPunish> selectByExampleForPage(DwInfoInspectionPunishExample example,PageBounds pageBounds);
    
}