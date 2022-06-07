package cn.cttic.roadtransapi.orm.waterway.dao;

import cn.cttic.roadtransapi.orm.waterway.domain.MarketSituation;
import cn.cttic.roadtransapi.orm.waterway.domain.MarketSituationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MarketSituationMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table MARKET_SITUATION
     *
     * @mbggenerated Fri Apr 10 09:51:42 CST 2015
     */
    int countByExample(MarketSituationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table MARKET_SITUATION
     *
     * @mbggenerated Fri Apr 10 09:51:42 CST 2015
     */
    int deleteByExample(MarketSituationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table MARKET_SITUATION
     *
     * @mbggenerated Fri Apr 10 09:51:42 CST 2015
     */
    int deleteByPrimaryKey(Long entRepoId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table MARKET_SITUATION
     *
     * @mbggenerated Fri Apr 10 09:51:42 CST 2015
     */
    int insert(MarketSituation record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table MARKET_SITUATION
     *
     * @mbggenerated Fri Apr 10 09:51:42 CST 2015
     */
    int insertSelective(MarketSituation record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table MARKET_SITUATION
     *
     * @mbggenerated Fri Apr 10 09:51:42 CST 2015
     */
    List<MarketSituation> selectByExample(MarketSituationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table MARKET_SITUATION
     *
     * @mbggenerated Fri Apr 10 09:51:42 CST 2015
     */
    MarketSituation selectByPrimaryKey(Long entRepoId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table MARKET_SITUATION
     *
     * @mbggenerated Fri Apr 10 09:51:42 CST 2015
     */
    int updateByExampleSelective(@Param("record") MarketSituation record, @Param("example") MarketSituationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table MARKET_SITUATION
     *
     * @mbggenerated Fri Apr 10 09:51:42 CST 2015
     */
    int updateByExample(@Param("record") MarketSituation record, @Param("example") MarketSituationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table MARKET_SITUATION
     *
     * @mbggenerated Fri Apr 10 09:51:42 CST 2015
     */
    int updateByPrimaryKeySelective(MarketSituation record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table MARKET_SITUATION
     *
     * @mbggenerated Fri Apr 10 09:51:42 CST 2015
     */
    int updateByPrimaryKey(MarketSituation record);
}