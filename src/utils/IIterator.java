package utils;

public interface IIterator {
    public void first();
    public void next();
    public Comparable getElement();
    public boolean hasNext();
    public boolean isValid();
}
