package dao;

import vo.Employee;

import java.util.List;
import java.util.Set;

public interface IDAO<K,V> {
    public boolean doCreate(V vo) throws Exception;
    public boolean doUpdate(V vo) throws Exception;

    /**
     * Remove data massively in database
     */
    public boolean doRemoveBatch(Set<K> ids) throws Exception;

    public V findByEid(K id) throws  Exception;

    public List<V> findAll() throws Exception;

    /**
     * make a fuzzy query in current page
     * @param currentPage current page
     * @param lineSize number of data in every page
     * @param column query column
     * @param keyWord query keyWord
     * @return
     * @throws Exception
     */
    public List<V> findAllSplit(Integer currentPage,Integer lineSize,String column,String keyWord) throws Exception;

    /**
     * Count number of returned data of a fuzzy query
     * @param column query column
     * @param keyWord query keyWord
     * @return
     * @throws Exception
     */
    public K getAllCount(String column,String keyWord) throws  Exception;
}
