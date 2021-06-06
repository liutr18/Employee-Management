package service;

import vo.Dept;

import java.util.List;
import java.util.Set;

public interface IDeptService {
    public boolean insert(Dept vo) throws Exception;
    public boolean update(Dept vo) throws Exception;
    public boolean delete(Set<Integer> ids) throws  Exception;
    public Dept findByEid(Integer id) throws  Exception;
    public List<Dept> listAllDepts() throws Exception;
}
