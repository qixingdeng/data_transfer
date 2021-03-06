package cn.cttic.roadtransapi.orm.waterway.dao;

import cn.cttic.roadtransapi.orm.waterway.domain.VoluShip;
import cn.cttic.roadtransapi.orm.waterway.domain.VoluShipExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface VoluShipMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table VOLU_SHIP
     *
     * @mbggenerated Fri Apr 10 09:51:42 CST 2015
     */
    int countByExample(VoluShipExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table VOLU_SHIP
     *
     * @mbggenerated Fri Apr 10 09:51:42 CST 2015
     */
    int deleteByExample(VoluShipExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table VOLU_SHIP
     *
     * @mbggenerated Fri Apr 10 09:51:42 CST 2015
     */
    int deleteByPrimaryKey(Long subRepoId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table VOLU_SHIP
     *
     * @mbggenerated Fri Apr 10 09:51:42 CST 2015
     */
    int insert(VoluShip record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table VOLU_SHIP
     *
     * @mbggenerated Fri Apr 10 09:51:42 CST 2015
     */
    int insertSelective(VoluShip record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table VOLU_SHIP
     *
     * @mbggenerated Fri Apr 10 09:51:42 CST 2015
     */
    List<VoluShip> selectByExample(VoluShipExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table VOLU_SHIP
     *
     * @mbggenerated Fri Apr 10 09:51:42 CST 2015
     */
    VoluShip selectByPrimaryKey(Long subRepoId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table VOLU_SHIP
     *
     * @mbggenerated Fri Apr 10 09:51:42 CST 2015
     */
    int updateByExampleSelective(@Param("record") VoluShip record, @Param("example") VoluShipExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table VOLU_SHIP
     *
     * @mbggenerated Fri Apr 10 09:51:42 CST 2015
     */
    int updateByExample(@Param("record") VoluShip record, @Param("example") VoluShipExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table VOLU_SHIP
     *
     * @mbggenerated Fri Apr 10 09:51:42 CST 2015
     */
    int updateByPrimaryKeySelective(VoluShip record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table VOLU_SHIP
     *
     * @mbggenerated Fri Apr 10 09:51:42 CST 2015
     */
    int updateByPrimaryKey(VoluShip record);
}