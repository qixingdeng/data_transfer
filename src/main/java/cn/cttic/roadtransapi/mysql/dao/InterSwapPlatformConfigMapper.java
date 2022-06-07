package cn.cttic.roadtransapi.mysql.dao;

import cn.cttic.roadtransapi.mysql.domain.InterSwapPlatformConfig;
import cn.cttic.roadtransapi.mysql.domain.InterSwapPlatformConfigExample;
import cn.cttic.roadtransapi.mysql.domain.InterSwapPlatformConfigWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface InterSwapPlatformConfigMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table INTER_SWAP_PLATFORM_CONFIG
     *
     * @mbggenerated Tue Jun 09 15:44:54 CST 2015
     */
    int countByExample(InterSwapPlatformConfigExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table INTER_SWAP_PLATFORM_CONFIG
     *
     * @mbggenerated Tue Jun 09 15:44:54 CST 2015
     */
    int deleteByExample(InterSwapPlatformConfigExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table INTER_SWAP_PLATFORM_CONFIG
     *
     * @mbggenerated Tue Jun 09 15:44:54 CST 2015
     */
    int insert(InterSwapPlatformConfigWithBLOBs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table INTER_SWAP_PLATFORM_CONFIG
     *
     * @mbggenerated Tue Jun 09 15:44:54 CST 2015
     */
    int insertSelective(InterSwapPlatformConfigWithBLOBs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table INTER_SWAP_PLATFORM_CONFIG
     *
     * @mbggenerated Tue Jun 09 15:44:54 CST 2015
     */
    List<InterSwapPlatformConfigWithBLOBs> selectByExampleWithBLOBs(InterSwapPlatformConfigExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table INTER_SWAP_PLATFORM_CONFIG
     *
     * @mbggenerated Tue Jun 09 15:44:54 CST 2015
     */
    List<InterSwapPlatformConfig> selectByExample(InterSwapPlatformConfigExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table INTER_SWAP_PLATFORM_CONFIG
     *
     * @mbggenerated Tue Jun 09 15:44:54 CST 2015
     */
    int updateByExampleSelective(@Param("record") InterSwapPlatformConfigWithBLOBs record, @Param("example") InterSwapPlatformConfigExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table INTER_SWAP_PLATFORM_CONFIG
     *
     * @mbggenerated Tue Jun 09 15:44:54 CST 2015
     */
    int updateByExampleWithBLOBs(@Param("record") InterSwapPlatformConfigWithBLOBs record, @Param("example") InterSwapPlatformConfigExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table INTER_SWAP_PLATFORM_CONFIG
     *
     * @mbggenerated Tue Jun 09 15:44:54 CST 2015
     */
    int updateByExample(@Param("record") InterSwapPlatformConfig record, @Param("example") InterSwapPlatformConfigExample example);
}