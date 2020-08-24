package com.jeecgexcel.controller;

import com.jeecgexcel.entity.Myuser;
import com.jeecgexcel.service.MyuserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * (Myuser)表控制层
 *
 * @author makejava
 * @since 2020-08-23 09:50:49
 */
@RestController
@RequestMapping("myuser")
@Api(value = "车市")
public class MyuserController {
    /**
     * 服务对象
     */
    @Resource
    private MyuserService myuserService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @ApiOperation(value = "测试", notes = "测试")
    @GetMapping("selectOne")
    public Myuser selectOne(Integer id) {
        return this.myuserService.queryById(id);
    }

    @ApiOperation(value = "查询某一天", notes = "查询某一天")
    @GetMapping("/queryByDay")
    public List<Map<String, Object>> queryByDay(@RequestParam(name = "queryDay") String day) {
        return myuserService.queryByDay(day);
    }

    @ApiOperation(value = "查询某一天", notes = "查询某一天")
    @GetMapping("/queryByMonth")
    public List<Map<String, Object>> queryByMonth(@RequestParam(name = "queryMonth") String month) {
        return myuserService.queryByMonth(month);
    }
}