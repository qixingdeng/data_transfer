package cn.cttic.roadtransapi.orm.waterway.domain;

import java.util.Date;

public class ShipStatisInfo extends ShipStatisInfoKey {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column SHIP_STATIS_INFO.SHIP_TYPE
     *
     * @mbggenerated Fri Mar 20 16:45:02 CST 2015
     */
    private String shipType;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column SHIP_STATIS_INFO.SHIPS_CHN
     *
     * @mbggenerated Fri Mar 20 16:45:02 CST 2015
     */
    private Short shipsChn;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column SHIP_STATIS_INFO.SHIP_CAPACITY_CHN
     *
     * @mbggenerated Fri Mar 20 16:45:02 CST 2015
     */
    private Short shipCapacityChn;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column SHIP_STATIS_INFO.SHIP_SPACE_CHN
     *
     * @mbggenerated Fri Mar 20 16:45:02 CST 2015
     */
    private Short shipSpaceChn;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column SHIP_STATIS_INFO.CONVENIENCE_SHIPS
     *
     * @mbggenerated Fri Mar 20 16:45:02 CST 2015
     */
    private Short convenienceShips;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column SHIP_STATIS_INFO.CONVENIENCE_SHIP_CAPACITY
     *
     * @mbggenerated Fri Mar 20 16:45:02 CST 2015
     */
    private Short convenienceShipCapacity;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column SHIP_STATIS_INFO.CONVENIENCE_SHIP_SPACE
     *
     * @mbggenerated Fri Mar 20 16:45:02 CST 2015
     */
    private Short convenienceShipSpace;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column SHIP_STATIS_INFO.OPER_DATE
     *
     * @mbggenerated Fri Mar 20 16:45:02 CST 2015
     */
    private Date operDate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column SHIP_STATIS_INFO.NOTE
     *
     * @mbggenerated Fri Mar 20 16:45:02 CST 2015
     */
    private String note;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column SHIP_STATIS_INFO.SHIP_TYPE
     *
     * @return the value of SHIP_STATIS_INFO.SHIP_TYPE
     *
     * @mbggenerated Fri Mar 20 16:45:02 CST 2015
     */
    public String getShipType() {
        return shipType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column SHIP_STATIS_INFO.SHIP_TYPE
     *
     * @param shipType the value for SHIP_STATIS_INFO.SHIP_TYPE
     *
     * @mbggenerated Fri Mar 20 16:45:02 CST 2015
     */
    public void setShipType(String shipType) {
        this.shipType = shipType == null ? null : shipType.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column SHIP_STATIS_INFO.SHIPS_CHN
     *
     * @return the value of SHIP_STATIS_INFO.SHIPS_CHN
     *
     * @mbggenerated Fri Mar 20 16:45:02 CST 2015
     */
    public Short getShipsChn() {
        return shipsChn;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column SHIP_STATIS_INFO.SHIPS_CHN
     *
     * @param shipsChn the value for SHIP_STATIS_INFO.SHIPS_CHN
     *
     * @mbggenerated Fri Mar 20 16:45:02 CST 2015
     */
    public void setShipsChn(Short shipsChn) {
        this.shipsChn = shipsChn;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column SHIP_STATIS_INFO.SHIP_CAPACITY_CHN
     *
     * @return the value of SHIP_STATIS_INFO.SHIP_CAPACITY_CHN
     *
     * @mbggenerated Fri Mar 20 16:45:02 CST 2015
     */
    public Short getShipCapacityChn() {
        return shipCapacityChn;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column SHIP_STATIS_INFO.SHIP_CAPACITY_CHN
     *
     * @param shipCapacityChn the value for SHIP_STATIS_INFO.SHIP_CAPACITY_CHN
     *
     * @mbggenerated Fri Mar 20 16:45:02 CST 2015
     */
    public void setShipCapacityChn(Short shipCapacityChn) {
        this.shipCapacityChn = shipCapacityChn;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column SHIP_STATIS_INFO.SHIP_SPACE_CHN
     *
     * @return the value of SHIP_STATIS_INFO.SHIP_SPACE_CHN
     *
     * @mbggenerated Fri Mar 20 16:45:02 CST 2015
     */
    public Short getShipSpaceChn() {
        return shipSpaceChn;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column SHIP_STATIS_INFO.SHIP_SPACE_CHN
     *
     * @param shipSpaceChn the value for SHIP_STATIS_INFO.SHIP_SPACE_CHN
     *
     * @mbggenerated Fri Mar 20 16:45:02 CST 2015
     */
    public void setShipSpaceChn(Short shipSpaceChn) {
        this.shipSpaceChn = shipSpaceChn;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column SHIP_STATIS_INFO.CONVENIENCE_SHIPS
     *
     * @return the value of SHIP_STATIS_INFO.CONVENIENCE_SHIPS
     *
     * @mbggenerated Fri Mar 20 16:45:02 CST 2015
     */
    public Short getConvenienceShips() {
        return convenienceShips;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column SHIP_STATIS_INFO.CONVENIENCE_SHIPS
     *
     * @param convenienceShips the value for SHIP_STATIS_INFO.CONVENIENCE_SHIPS
     *
     * @mbggenerated Fri Mar 20 16:45:02 CST 2015
     */
    public void setConvenienceShips(Short convenienceShips) {
        this.convenienceShips = convenienceShips;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column SHIP_STATIS_INFO.CONVENIENCE_SHIP_CAPACITY
     *
     * @return the value of SHIP_STATIS_INFO.CONVENIENCE_SHIP_CAPACITY
     *
     * @mbggenerated Fri Mar 20 16:45:02 CST 2015
     */
    public Short getConvenienceShipCapacity() {
        return convenienceShipCapacity;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column SHIP_STATIS_INFO.CONVENIENCE_SHIP_CAPACITY
     *
     * @param convenienceShipCapacity the value for SHIP_STATIS_INFO.CONVENIENCE_SHIP_CAPACITY
     *
     * @mbggenerated Fri Mar 20 16:45:02 CST 2015
     */
    public void setConvenienceShipCapacity(Short convenienceShipCapacity) {
        this.convenienceShipCapacity = convenienceShipCapacity;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column SHIP_STATIS_INFO.CONVENIENCE_SHIP_SPACE
     *
     * @return the value of SHIP_STATIS_INFO.CONVENIENCE_SHIP_SPACE
     *
     * @mbggenerated Fri Mar 20 16:45:02 CST 2015
     */
    public Short getConvenienceShipSpace() {
        return convenienceShipSpace;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column SHIP_STATIS_INFO.CONVENIENCE_SHIP_SPACE
     *
     * @param convenienceShipSpace the value for SHIP_STATIS_INFO.CONVENIENCE_SHIP_SPACE
     *
     * @mbggenerated Fri Mar 20 16:45:02 CST 2015
     */
    public void setConvenienceShipSpace(Short convenienceShipSpace) {
        this.convenienceShipSpace = convenienceShipSpace;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column SHIP_STATIS_INFO.OPER_DATE
     *
     * @return the value of SHIP_STATIS_INFO.OPER_DATE
     *
     * @mbggenerated Fri Mar 20 16:45:02 CST 2015
     */
    public Date getOperDate() {
        return operDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column SHIP_STATIS_INFO.OPER_DATE
     *
     * @param operDate the value for SHIP_STATIS_INFO.OPER_DATE
     *
     * @mbggenerated Fri Mar 20 16:45:02 CST 2015
     */
    public void setOperDate(Date operDate) {
        this.operDate = operDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column SHIP_STATIS_INFO.NOTE
     *
     * @return the value of SHIP_STATIS_INFO.NOTE
     *
     * @mbggenerated Fri Mar 20 16:45:02 CST 2015
     */
    public String getNote() {
        return note;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column SHIP_STATIS_INFO.NOTE
     *
     * @param note the value for SHIP_STATIS_INFO.NOTE
     *
     * @mbggenerated Fri Mar 20 16:45:02 CST 2015
     */
    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }
}