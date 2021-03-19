package repository;

public interface IRepository {

    Boolean saveObject(Object o);
    Boolean deleteObject(int id);
    Boolean updateObject(int key,Object o);
    Object[] getAll();
    Boolean existObject(int id);
    Object findObjectId(int id);
    int count();

}
