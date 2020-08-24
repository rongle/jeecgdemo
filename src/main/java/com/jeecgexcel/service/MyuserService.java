package com.jeecgexcel.service;

import com.jeecgexcel.entity.Myuser;

import java.util.List;
import java.util.Map;

/**
 * (Myuser)表服务接口
 *
 * @author makejava
 * @since 2020-08-23 15:02:51
 */
public interface MyuserService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Myuser queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Myuser> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param myuser 实例对象
     * @return 实例对象
     */
    Myuser insert(Myuser myuser);

    /**
     * 修改数据
     *
     * @param myuser 实例对象
     * @return 实例对象
     */
    Myuser update(Myuser myuser);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

    /**
     *
     * @param day
     * @return
     */
    List<Map<String, Object>> queryByDay(String day);

    /**
     *
     * @param month
     * @return
     */
    List<Map<String, Object>> queryByMonth(String month);
}