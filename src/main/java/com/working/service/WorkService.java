
package com.working.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.working.dao.WorkDAO;
import com.working.entity.Work;
import com.working.util.UUIDUtil;

/**
 * WorkService
 *
 * @author 惠新宇
 * @since 1.8
 * @version 2018年03月05日 惠新宇
 */
@Service
public class WorkService {
    
    /** workMapper接口 */
    @Autowired
    private WorkDAO workMapper;
    
    /**
     * 保存
     * 
     * @param work
     */
    public void insert(Work work) throws Exception {
        work.setId(UUIDUtil.generateUUID());
        workMapper.insert(work);
    }
    
    /**
     * 批量保存
     * 
     * @param work
     */
    public void insertList(List<Work> workList) throws Exception {
        workMapper.insertList(workList);
    }
    
    /**
     * 通过主键删除单条记录
     * 
     * @param id 主键ID
     * @throws Exception 出错抛出异常
     */
    public void delete(String id) throws Exception {
        workMapper.delete(id);
    }
    
    /**
     * 更新
     * <p>
     * 通过主键更新记录
     * </p>
     * 
     * @param work
     * @throws Exception 出错抛出异常
     */
    public void update(Work work) throws Exception {
        workMapper.update(work);
    }
    
    /**
     * 更新非空字段
     * <p>
     * 通过主键更新记录
     * </p>
     * 
     * @param work
     * @throws Exception 出错抛出异常
     */
    public void updateIfNotNull(Work work) throws Exception {
        workMapper.updateIfNotNull(work);
    }
    
    /**
     * 通过主键获取单条记录
     * 
     * @param id 主键ID
     * @return 单条记录
     */
    public Work selectByPrimaryKey(String id) {
        return workMapper.selectByPrimaryKey(id);
    }
    
    /**
     * 通过自定义非空字段获取记录集
     * 
     * @param work
     */
    public List<Work> selectList(Work work) {
        return workMapper.selectList(work);
    }
    
}
