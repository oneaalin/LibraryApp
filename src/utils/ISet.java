package utils;

public interface ISet {
    Boolean addItem(Comparable o);
    Boolean deleteItem(int key);
    Boolean updateItem(int key,Comparable o);
    Comparable[] getItems();
    int count();
    boolean isEmpty();
    Boolean existItem(int key);
    IIterator getIterator();
}
