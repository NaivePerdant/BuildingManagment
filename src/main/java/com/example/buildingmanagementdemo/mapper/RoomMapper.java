package com.example.buildingmanagementdemo.mapper;

import com.example.buildingmanagementdemo.model.Room;
import com.example.buildingmanagementdemo.model.RoomExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RoomMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rooms
     *
     * @mbg.generated Sun Jul 14 12:52:55 CST 2024
     */
    long countByExample(RoomExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rooms
     *
     * @mbg.generated Sun Jul 14 12:52:55 CST 2024
     */
    int deleteByExample(RoomExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rooms
     *
     * @mbg.generated Sun Jul 14 12:52:55 CST 2024
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rooms
     *
     * @mbg.generated Sun Jul 14 12:52:55 CST 2024
     */
    int insert(Room row);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rooms
     *
     * @mbg.generated Sun Jul 14 12:52:55 CST 2024
     */
    int insertSelective(Room row);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rooms
     *
     * @mbg.generated Sun Jul 14 12:52:55 CST 2024
     */
    List<Room> selectByExample(RoomExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rooms
     *
     * @mbg.generated Sun Jul 14 12:52:55 CST 2024
     */
    Room selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rooms
     *
     * @mbg.generated Sun Jul 14 12:52:55 CST 2024
     */
    int updateByExampleSelective(@Param("row") Room row, @Param("example") RoomExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rooms
     *
     * @mbg.generated Sun Jul 14 12:52:55 CST 2024
     */
    int updateByExample(@Param("row") Room row, @Param("example") RoomExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rooms
     *
     * @mbg.generated Sun Jul 14 12:52:55 CST 2024
     */
    int updateByPrimaryKeySelective(Room row);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rooms
     *
     * @mbg.generated Sun Jul 14 12:52:55 CST 2024
     */
    int updateByPrimaryKey(Room row);
}