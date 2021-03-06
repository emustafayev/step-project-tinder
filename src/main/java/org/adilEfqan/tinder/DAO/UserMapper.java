package org.adilEfqan.tinder.DAO;

import org.adilEfqan.tinder.Models.Gender;
import org.adilEfqan.tinder.Models.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface UserMapper{
    String getAll = "SELECT * FROM \"user\"";
    String getById = "SELECT * FROM \"user\" WHERE ID = #{id}";
    String deleteById = "DELETE from \"user\" WHERE ID = #{id}";
    String insert = "INSERT INTO \"user\" (USERNAME, PASSWORD, GENDER, IMAGEURL ) VALUES (#{username}, #{password}, #{gender}, #{imageURL})";
    String update = "UPDATE \"user\" SET USERNAME = #{username}, PASSWORD = #{password}, GENDER = #{gender}, IMAGEURL = #{imageURL}, LASTLOGIN=#{lastLogin,typeHandler=org.apache.ibatis.type.LocalDateTimeTypeHandler} WHERE ID = #{userID}";
    String getBY = "SELECT * FROM \"user\" WHERE USERNAME=#{username}";
    String getUserOneByOne = "SELECT ID,USERNAME,PASSWORD,GENDER,LASTLOGIN,IMAGEURL FROM \"user\" u WHERE u.ID NOT IN( select l.touser from liked l where l.\"user\" = #{userID}) and u.id != #{userID } limit 1";
    @Select(getAll)
    @Results(value = {
            @Result(property = "userID",column = "id"),
            @Result(property = "username",column = "username"),
            @Result(property = "password",column = "password"),
            @Result(property = "gender",column = "gender"),
            @Result(property = "imageURL",column = "imageURL")
    })
    List<User> getAll();

    @Select(getById)
    @Results(value = {
            @Result(property = "userID",column = "id",id = true),
            @Result(property = "username",column = "username"),
            @Result(property = "password",column = "password"),
            @Result(property = "gender",column = "gender",javaType = Gender.class),
            @Result(property = "lastLogin",column = "lastLogin",javaType = java.time.LocalDateTime.class, jdbcType = JdbcType.TIMESTAMP, typeHandler = org.apache.ibatis.type.LocalDateTimeTypeHandler.class),
            @Result(property = "imageURL",column = "imageURL")
    })
    User getById(String id);

    @Update({update})
    void update(User student);

    @Delete(deleteById)
    void deleteByID(String id);

    @Insert(insert)
    @Options(useGeneratedKeys = true, keyProperty = "userID")
    void insert(User user);

    @Select(getBY)
    @Results(value = {
            @Result(property = "userID",column = "id"),
            @Result(property = "username",column = "username"),
            @Result(property = "password",column = "password"),
            @Result(property = "gender",column = "gender",javaType = Gender.class),
            @Result(property = "lastLogin",column = "lastLogin",javaType = java.time.LocalDateTime.class, jdbcType = JdbcType.TIMESTAMP, typeHandler = org.apache.ibatis.type.LocalDateTimeTypeHandler.class),
            @Result(property = "imageURL",column = "imageURL")
    })
    User getBy(String username);


    @Select(getUserOneByOne)
    @Results(value = {
            @Result(property = "userID",column = "id"),
            @Result(property = "username",column = "username"),
            @Result(property = "password",column = "password"),
            @Result(property = "gender",column = "gender"),
            @Result(property = "lastLogin",column = "lastLogin",javaType = java.time.LocalDateTime.class, jdbcType = JdbcType.TIMESTAMP, typeHandler = org.apache.ibatis.type.LocalDateTimeTypeHandler.class),
            @Result(property = "imageURL",column = "imageURL")
    })
    User getUserOneByOne(String userID);


    @Select({"SELECT id,username,gender,imageurl,password, lastLogin FROM liked l\n" +
            "LEFT OUTER JOIN \"user\" u ON l.touser = u.id\n" +
            "WHERE l.\"user\" = #{userID} AND l.isliked=true;\n"})
    @Results(value = {
            @Result(property = "userID",column = "id"),
            @Result(property = "username",column = "username"),
            @Result(property = "password",column = "password"),
            @Result(property = "gender",column = "gender"),
            @Result(property = "imageURL",column = "imageURL"),
            @Result(property = "lastLogin",column = "lastLogin",javaType = java.time.LocalDateTime.class, jdbcType = JdbcType.TIMESTAMP, typeHandler = org.apache.ibatis.type.LocalDateTimeTypeHandler.class)
    })
    List<User> getLikedUser(String userID);

}
