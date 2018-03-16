
package com.working.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.working.entity.Work;
import com.working.service.WorkService;
import com.working.util.DateTimeUtils;
import com.working.util.MapAndBeanTransform;
import com.working.util.TableData;

/**
 * Work
 *
 * @author 惠新宇
 * @since 1.8
 * @version 2018年03月05日 惠新宇
 */
@RestController
@RequestMapping("/working/*")
public class WorkController {
    
    /** workService */
    @Autowired
    private WorkService workService;
    
    /**
     * 商品列表查询
     * 
     * @param request
     * @throws Exception e
     */
    @RequestMapping("/queryWorkList")
    @ResponseBody
    public TableData<Map<String, Object>> queryWorkList(HttpServletRequest request) {
        try {
            // 查询条件
            Work work = new Work();
            String state = request.getParameter("state");
            work.setState(state);
            String grade = request.getParameter("grade");
            work.setClassNum(grade);
            String subject = request.getParameter("subject");
            work.setSubNum(subject);
            String stuName = request.getParameter("stuName");
            work.setStuName(stuName);
            // 分页信息
            int pageNumber = NumberUtils.toInt(request.getParameter("pageNumber"), 1);
            int pageSize = NumberUtils.toInt(request.getParameter("pageSize"), 10);
            PageHelper.startPage(pageNumber, pageSize);
            PageHelper.orderBy("update_time desc");
            List<Work> workList = workService.selectList(work);
            PageInfo<Work> pageInfo = new PageInfo<Work>(workList);
            List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
            if (workList != null && workList.size() > 0) {
                for (Work workList2 : workList) {
                    Map<String, Object> map = MapAndBeanTransform.beanToMap(workList2);
                    String updateTime = DateTimeUtils.converTimestampToString(workList2.getUpdateTime(),
                        "yyyy-MM-dd HH:mm");
                    map.put("updateTime", updateTime);
                    list.add(map);
                }
            }
            return TableData.bulid(pageInfo.getTotal(), list);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return TableData.bulid(0, null);
    }
}
