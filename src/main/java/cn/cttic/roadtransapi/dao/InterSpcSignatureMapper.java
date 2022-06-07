package cn.cttic.roadtransapi.dao;

import cn.cttic.roadtransapi.domain.InterSpcSignature;
import cn.cttic.roadtransapi.domain.InterSpcSignatureExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface InterSpcSignatureMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table INTER_SPC_SIGNATURE
     *
     * @mbggenerated Wed Mar 25 11:18:48 CST 2015
     */
    int countByExample(InterSpcSignatureExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table INTER_SPC_SIGNATURE
     *
     * @mbggenerated Wed Mar 25 11:18:48 CST 2015
     */
    int deleteByExample(InterSpcSignatureExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table INTER_SPC_SIGNATURE
     *
     * @mbggenerated Wed Mar 25 11:18:48 CST 2015
     */
    int insert(InterSpcSignature record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table INTER_SPC_SIGNATURE
     *
     * @mbggenerated Wed Mar 25 11:18:48 CST 2015
     */
    int insertSelective(InterSpcSignature record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table INTER_SPC_SIGNATURE
     *
     * @mbggenerated Wed Mar 25 11:18:48 CST 2015
     */
    List<InterSpcSignature> selectByExample(InterSpcSignatureExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table INTER_SPC_SIGNATURE
     *
     * @mbggenerated Wed Mar 25 11:18:48 CST 2015
     */
    int updateByExampleSelective(@Param("record") InterSpcSignature record, @Param("example") InterSpcSignatureExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table INTER_SPC_SIGNATURE
     *
     * @mbggenerated Wed Mar 25 11:18:48 CST 2015
     */
    int updateByExample(@Param("record") InterSpcSignature record, @Param("example") InterSpcSignatureExample example);
}