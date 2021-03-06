package cn.cttic.roadtransapi.orm.waterway.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.cttic.roadtransapi.orm.waterway.domain.ShipStatisInfo;
import cn.cttic.roadtransapi.orm.waterway.domain.ShipStatisInfoExample;
import cn.cttic.roadtransapi.orm.waterway.domain.ShipStatisInfoKey;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

public interface ShipStatisInfoMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SHIP_STATIS_INFO
     *
     * @mbggenerated Fri Mar 20 16:45:02 CST 2015
     */
    int countByExample(ShipStatisInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SHIP_STATIS_INFO
     *
     * @mbggenerated Fri Mar 20 16:45:02 CST 2015
     */
    int deleteByExample(ShipStatisInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SHIP_STATIS_INFO
     *
     * @mbggenerated Fri Mar 20 16:45:02 CST 2015
     */
    int deleteByPrimaryKey(ShipStatisInfoKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SHIP_STATIS_INFO
     *
     * @mbggenerated Fri Mar 20 16:45:02 CST 2015
     */
    int insert(ShipStatisInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SHIP_STATIS_INFO
     *
     * @mbggenerated Fri Mar 20 16:45:02 CST 2015
     */
    int insertSelective(ShipStatisInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SHIP_STATIS_INFO
     *
     * @mbggenerated Fri Mar 20 16:45:02 CST 2015
     */
    List<ShipStatisInfo> selectByExample(ShipStatisInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SHIP_STATIS_INFO
     *
     * @mbggenerated Fri Mar 20 16:45:02 CST 2015
     */
    ShipStatisInfo selectByPrimaryKey(ShipStatisInfoKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SHIP_STATIS_INFO
     *
     * @mbggenerated Fri Mar 20 16:45:02 CST 2015
     */
    int updateByExampleSelective(@Param("record") ShipStatisInfo record, @Param("example") ShipStatisInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SHIP_STATIS_INFO
     *
     * @mbggenerated Fri Mar 20 16:45:02 CST 2015
     */
    int updateByExample(@Param("record") ShipStatisInfo record, @Param("example") ShipStatisInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SHIP_STATIS_INFO
     *
     * @mbggenerated Fri Mar 20 16:45:02 CST 2015
     */
    int updateByPrimaryKeySelective(ShipStatisInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SHIP_STATIS_INFO
     *
     * @mbggenerated Fri Mar 20 16:45:02 CST 2015
     */
    int updateByPrimaryKey(ShipStatisInfo record);

	PageList<ShipStatisInfo> getShipStatisList(Map qryMap, PageBounds pb);
}