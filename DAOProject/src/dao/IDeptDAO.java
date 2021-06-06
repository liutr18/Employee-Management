package dao;

import vo.Dept;

import java.util.List;
import java.util.Set;

public interface IDeptDAO extends IDAO<Integer, Dept>{
    @Override
    boolean doCreate(Dept vo) throws Exception;

    @Override
    boolean doUpdate(Dept vo) throws Exception;

    @Override
    boolean doRemoveBatch(Set<Integer> ids) throws Exception;

    @Override
    Dept findByEid(Integer id) throws Exception;

    @Override
    List<Dept> findAll() throws Exception;

    @Override
    List<Dept> findAllSplit(Integer currentPage, Integer lineSize, String column, String keyWord) throws Exception;

    @Override
    Integer getAllCount(String column, String keyWord) throws Exception;
}
