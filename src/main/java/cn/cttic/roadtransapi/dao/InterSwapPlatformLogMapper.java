package cn.cttic.roadtransapi.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.cttic.roadtransapi.domain.InterSwapPlatformLog;
import cn.cttic.roadtransapi.domain.InterSwapPlatformLogExample;
import cn.cttic.roadtransapi.domain.InterSwapPlatformLogWithBLOBs;

public interface InterSwapPlatformLogMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table INTER_SWAP_PLATFORM_LOG_201506
     *
     * @mbggenerated Fri May 29 16:51:44 CST 2015
     */
    int countByExample(InterSwapPlatformLogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table INTER_SWAP_PLATFORM_LOG_201506
     *
     * @mbggenerated Fri May 29 16:51:44 CST 2015
     */
    int deleteByExample(InterSwapPlatformLogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table INTER_SWAP_PLATFORM_LOG_201506
     *
     * @mbggenerated Fri May 29 16:51:44 CST 2015
     */
    int insert(InterSwapPlatformLogWithBLOBs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table INTER_SWAP_PLATFORM_LOG_201506
     *
     * @mbggenerated Fri May 29 16:51:44 CST 2015
     */
    int insertSelective(InterSwapPlatformLogWithBLOBs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table INTER_SWAP_PLATFORM_LOG_201506
     *
     * @mbggenerated Fri May 29 16:51:44 CST 2015
     */
    List<InterSwapPlatformLogWithBLOBs> selectByExampleWithBLOBs(InterSwapPlatformLogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table INTER_SWAP_PLATFORM_LOG_201506
     *
     * @mbggenerated Fri May 29 16:51:44 CST 2015
     */
    List<InterSwapPlatformLog> selectByExample(InterSwapPlatformLogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table INTER_SWAP_PLATFORM_LOG_201506
     *
     * @mbggenerated Fri May 29 16:51:44 CST 2015
     */
    int updateByExampleSelective(@Param("record") InterSwapPlatformLogWithBLOBs record, @Param("example") InterSwapPlatformLogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table INTER_SWAP_PLATFORM_LOG_201506
     *
     * @mbggenerated Fri May 29 16:51:44 CST 2015
     */
    int updateByExampleWithBLOBs(@Param("record") InterSwapPlatformLogWithBLOBs record, @Param("example") InterSwapPlatformLogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table INTER_SWAP_PLATFORM_LOG_201506
     *
     * @mbggenerated Fri May 29 16:51:44 CST 2015
     */
    int updateByExample(@Param("record") InterSwapPlatformLog record, @Param("example") InterSwapPlatformLogExample example);
}