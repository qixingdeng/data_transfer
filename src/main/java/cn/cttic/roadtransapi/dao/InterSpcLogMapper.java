package cn.cttic.roadtransapi.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.cttic.roadtransapi.domain.InterSpcLog;
import cn.cttic.roadtransapi.domain.InterSpcLogExample;
import cn.cttic.roadtransapi.domain.InterSpcLogWithBLOBs;

public interface InterSpcLogMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table INTER_SPC_LOG
     *
     * @mbggenerated Mon Jul 06 10:25:24 CST 2015
     */
    int countByExample(InterSpcLogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table INTER_SPC_LOG
     *
     * @mbggenerated Mon Jul 06 10:25:24 CST 2015
     */
    int deleteByExample(InterSpcLogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table INTER_SPC_LOG
     *
     * @mbggenerated Mon Jul 06 10:25:24 CST 2015
     */
    int insert(InterSpcLogWithBLOBs record);

    
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table INTER_SPC_LOG
     *
     * @mbggenerated Mon Jul 06 10:25:24 CST 2015
     */
    int insertSelective(InterSpcLogWithBLOBs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table INTER_SPC_LOG
     *
     * @mbggenerated Mon Jul 06 10:25:24 CST 2015
     */
    List<InterSpcLogWithBLOBs> selectByExampleWithBLOBs(InterSpcLogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table INTER_SPC_LOG
     *
     * @mbggenerated Mon Jul 06 10:25:24 CST 2015
     */
    List<InterSpcLog> selectByExample(InterSpcLogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table INTER_SPC_LOG
     *
     * @mbggenerated Mon Jul 06 10:25:24 CST 2015
     */
    int updateByExampleSelective(@Param("record") InterSpcLogWithBLOBs record, @Param("example") InterSpcLogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table INTER_SPC_LOG
     *
     * @mbggenerated Mon Jul 06 10:25:24 CST 2015
     */
    int updateByExampleWithBLOBs(@Param("record") InterSpcLogWithBLOBs record, @Param("example") InterSpcLogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table INTER_SPC_LOG
     *
     * @mbggenerated Mon Jul 06 10:25:24 CST 2015
     */
    int updateByExample(@Param("record") InterSpcLog record, @Param("example") InterSpcLogExample example);
    
    
    int countByExampleByname(@Param("curdate")String curdate);
    
    int createTableByname(@Param("curdate")String curdate);
    
    int insertSelectiveByname(@Param("curdate")String curdate , @Param("record") InterSpcLogWithBLOBs record);
}