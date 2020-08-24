package com.jeecgexcel.service.impl;

import com.jeecgexcel.dao.MyuserDao;
import com.jeecgexcel.dto.MyuserDTO;
import com.jeecgexcel.entity.Myuser;
import com.jeecgexcel.service.MyuserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * (Myuser)表服务实现类
 *
 * @author makejava
 * @since 2020-08-23 09:50:49
 */
@Slf4j
@Service("myuserService")
public class MyuserServiceImpl implements MyuserService {
    @Resource
    private MyuserDao myuserDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Myuser queryById(Integer id) {
        return this.myuserDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<Myuser> queryAllByLimit(int offset, int limit) {
        return this.myuserDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param myuser 实例对象
     * @return 实例对象
     */
    @Override
    public Myuser insert(Myuser myuser) {
        this.myuserDao.insert(myuser);
        return myuser;
    }

    /**
     * 修改数据
     *
     * @param myuser 实例对象
     * @return 实例对象
     */
    @Override
    public Myuser update(Myuser myuser) {
        this.myuserDao.update(myuser);
        return this.queryById(myuser.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.myuserDao.deleteById(id) > 0;
    }


    @Override
    public List<Map<String, Object>> queryByDay(String day) {
        List<Map<String, Object>> result = new ArrayList<>();
        List<MyuserDTO> myuserList = myuserDao.queryByDay(day);
        Map<String, List<Integer>> tmpMap = new HashMap<>();
        for (MyuserDTO myuser : myuserList) {
            Map<String, Object> maps = new HashMap<>();
            String carId = myuser.getCarId();
            if (tmpMap.get(carId) != null) {
                List<Integer> integerList = tmpMap.get(carId);
                int startHour = myuser.getStartTime();
                int endHour = myuser.getEndTime();
                if(myuser.getStartTime() != null) {
                    for (int m=startHour; m<=endHour; m++) {
                        System.out.println(m);
                        integerList.add(m);
                    }
                }
            } else {
                List<Integer> integerList = new ArrayList<>();
                maps.put("carId", carId);
                maps.put("num", myuser.getNum());
                maps.put("capacity", myuser.getCapacity());
                if(myuser.getStartTime() != null) {
                    int startHour = myuser.getStartTime();
                    int endHour = myuser.getEndTime();
                    for (int m=startHour; m<=endHour; m++) {
                        System.out.println(m);
                        integerList.add(m);
                    }
                }
                tmpMap.put(carId, integerList);
                maps.put("used", integerList);
            }
            if (maps.size() > 0) {
                result.add(maps);
            }
        }
        return result;
    }

    /**
     *
     *
     * @param month
     * @return
     */
    @Override
    public List<Map<String, Object>> queryByMonth(String month) {
        List<Map<String, Object>> result = new ArrayList<>();
        List<MyuserDTO> myuserList = myuserDao.queryByMonth(month);
        Map<String, HashSet<Integer>> tmpMap = new HashMap<>();
        for (MyuserDTO myuser : myuserList) {
            Map<String, Object> maps = new HashMap<>();
            String carId = myuser.getCarId();
            if (tmpMap.get(carId) != null) {
                HashSet<Integer> integerSet = tmpMap.get(carId);
                int startDay = myuser.getStartTime() <= getCurrentDay() ? getCurrentDay() : myuser.getStartTime();
                int endDay = myuser.getEndTime();
                if(myuser.getStartTime() != null) {
                    for (int m=startDay; m<=endDay; m++) {
                        System.out.println(m);
                        integerSet.add(m);
                    }
                }
            } else {
                HashSet<Integer> integerSet = new HashSet<>();
                maps.put("carId", carId);
                maps.put("num", myuser.getNum());
                maps.put("capacity", myuser.getCapacity());
                if(myuser.getStartTime() != null) {
                    int startDay = myuser.getStartTime() <= getCurrentDay() ? getCurrentDay() : myuser.getStartTime();
                    int endDay = myuser.getEndTime();
                    for (int m=startDay; m<=endDay; m++) {
                        System.out.println(m);
                        integerSet.add(m);
                    }
                }
                tmpMap.put(carId, integerSet);
                maps.put("used", integerSet);
            }
            if (maps.size() > 0) {
                result.add(maps);
            }
        }
        return result;
    }

    /**
     * 当前月份值
     *
     * @return
     */
    public int getCurrentMonth(){
        Calendar now = Calendar.getInstance();
        return now.get(Calendar.MONTH) + 1;
    }

    /**
     * 当前日期的值
     *
     * @return
     */
    public int getCurrentDay(){
        Calendar now = Calendar.getInstance();
        return now.get(Calendar.DAY_OF_MONTH);
    }

    public String getDateString(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd HH:mm:ss");
        return sdf.format(date);
    }
}