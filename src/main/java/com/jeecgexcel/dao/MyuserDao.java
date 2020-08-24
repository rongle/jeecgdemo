package com.jeecgexcel.dao;

import com.jeecgexcel.dto.MyuserDTO;
import com.jeecgexcel.entity.Myuser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (Myuser)表数据库访问层
 *
 * @author makejava
 * @since 2020-08-23 15:02:17
 */
@Mapper
public interface MyuserDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Myuser queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Myuser> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param myuser 实例对象
     * @return 对象列表
     */
    List<Myuser> queryAll(Myuser myuser);

    /**
     * 新增数据
     *
     * @param myuser 实例对象
     * @return 影响行数
     */
    int insert(Myuser myuser);

    /**
     * 修改数据
     *
     * @param myuser 实例对象
     * @return 影响行数
     */
    int update(Myuser myuser);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

    /**
     *
     * @param day
     * @return
     */
    List<MyuserDTO> queryByDay(@Param("day") String day);

    /**
     *
     * @param month
     * @return
     */
    List<MyuserDTO> queryByMonth(@Param("month") String month);
}