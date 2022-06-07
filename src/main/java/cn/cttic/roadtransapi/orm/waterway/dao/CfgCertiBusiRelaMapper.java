package cn.cttic.roadtransapi.orm.waterway.dao;

import cn.cttic.roadtransapi.orm.waterway.domain.CfgCertiBusiRela;
import cn.cttic.roadtransapi.orm.waterway.domain.CfgCertiBusiRelaExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CfgCertiBusiRelaMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table CFG_CERTI_BUSI_RELA
     *
     * @mbggenerated Mon Jun 29 16:21:54 CST 2015
     */
    int countByExample(CfgCertiBusiRelaExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table CFG_CERTI_BUSI_RELA
     *
     * @mbggenerated Mon Jun 29 16:21:54 CST 2015
     */
    int deleteByExample(CfgCertiBusiRelaExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table CFG_CERTI_BUSI_RELA
     *
     * @mbggenerated Mon Jun 29 16:21:54 CST 2015
     */
    int insert(CfgCertiBusiRela record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table CFG_CERTI_BUSI_RELA
     *
     * @mbggenerated Mon Jun 29 16:21:54 CST 2015
     */
    int insertSelective(CfgCertiBusiRela record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table CFG_CERTI_BUSI_RELA
     *
     * @mbggenerated Mon Jun 29 16:21:54 CST 2015
     */
    List<CfgCertiBusiRela> selectByExample(CfgCertiBusiRelaExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table CFG_CERTI_BUSI_RELA
     *
     * @mbggenerated Mon Jun 29 16:21:54 CST 2015
     */
    int updateByExampleSelective(@Param("record") CfgCertiBusiRela record, @Param("example") CfgCertiBusiRelaExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table CFG_CERTI_BUSI_RELA
     *
     * @mbggenerated Mon Jun 29 16:21:54 CST 2015
     */
    int updateByExample(@Param("record") CfgCertiBusiRela record, @Param("example") CfgCertiBusiRelaExample example);
}