package cn.xmkeshe.service;

import cn.xmkeshe.vo.Item;

import java.util.List;
import java.util.Map;

public interface IItemService {
    /**
     * 增加分类信息
     * @param vo 要执行增加的对象数据
     * @return 增加成功返回true，增加失败返回false
     * @throws Exception
     */
    public boolean add(Item vo)throws Exception;

    /**
     * 数据分页查询并且统计数据量
     * @param currentPage  当前页面
     * @param lineSize 每页显示记录数据
     * @return
     * @throws Exception
     */
    public Map<String ,Object> listSplit(int currentPage, int lineSize)throws Exception;
    public List<Item> list()throws Exception;
}
