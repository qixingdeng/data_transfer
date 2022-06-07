package cn.cttic.roadtransapi.mysql.dao;

import cn.cttic.roadtransapi.mysql.domain.InterSpcSignature;
import cn.cttic.roadtransapi.mysql.domain.InterSpcSignatureExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface InterSpcSignatureMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table INTER_SPC_SIGNATURE
     *
     * @mbggenerated Tue Jun 09 15:44:54 CST 2015
     */
    int countByExample(InterSpcSignatureExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table INTER_SPC_SIGNATURE
     *
     * @mbggenerated Tue Jun 09 15:44:54 CST 2015
     */
    int deleteByExample(InterSpcSignatureExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table INTER_SPC_SIGNATURE
     *
     * @mbggenerated Tue Jun 09 15:44:54 CST 2015
     */
    int insert(InterSpcSignature record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table INTER_SPC_SIGNATURE
     *
     * @mbggenerated Tue Jun 09 15:44:54 CST 2015
     */
    int insertSelective(InterSpcSignature record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table INTER_SPC_SIGNATURE
     *
     * @mbggenerated Tue Jun 09 15:44:54 CST 2015
     */
    List<InterSpcSignature> selectByExample(InterSpcSignatureExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table INTER_SPC_SIGNATURE
     *
     * @mbggenerated Tue Jun 09 15:44:54 CST 2015
     */
    int updateByExampleSelective(@Param("record") InterSpcSignature record, @Param("example") InterSpcSignatureExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table INTER_SPC_SIGNATURE
     *
     * @mbggenerated Tue Jun 09 15:44:54 CST 2015
     */
    int updateByExample(@Param("record") InterSpcSignature record, @Param("example") InterSpcSignatureExample example);
}