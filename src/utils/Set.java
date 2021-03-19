package utils;

import domain.Carte;

import java.util.Iterator;

public class Set implements ISet {

    @SuppressWarnings("rawtypes")
    private Comparable[] tabel;
    private int size,capacity;

    public Set(int capacity){
        tabel = new Comparable[capacity];
        setSize(-1);
        setCapacity(capacity);
    }

    @Override
    @SuppressWarnings("rawtypes")
    public Boolean addItem(Comparable o) {
        if(existItem(((Carte)o).getId()))
            return false;
        size=size+1;
        if(size==capacity)
            return false;
        tabel[size]=o;
        return true;
    }

    @Override
    public Boolean deleteItem(int key) {
        int index = findObject(key);
        if((index<=size) && (index>-1)){
            for(int j=index;j<size;j++)
                tabel[j]=tabel[j+1];
            size=size-1;
            return true;
        }
        else
            return false;
    }

    @Override
    @SuppressWarnings("rawtypes")
    public Boolean updateItem(int key, Comparable o) {
        int index = findObject(key);
        if((index<=size) && (index>-1)){
            ((Carte)tabel[index]).setTitlu(((Carte)o).getTitlu());
            ((Carte)tabel[index]).setAutori(((Carte)o).getAutori());
            ((Carte)tabel[index]).setAnulAparitiei(((Carte)o).getAnulAparitiei());
            ((Carte)tabel[index]).setPret(((Carte)o).getPret());
            ((Carte)tabel[index]).setEditura(((Carte)o).getEditura());
            ((Carte)tabel[index]).setCota(((Carte)o).getCota());
            return true;
        }
        return false;
    }

    @Override
    @SuppressWarnings("rawtypes")
    public Comparable[] getItems() {
        if(size>=0){
            Comparable[] rez = new Comparable[size+1];
            IIterator it = this.getIterator();
            int index = 0;
            it.first();
            while(it.isValid()){
                rez[index++]=it.getElement();
                it.next();
            }
            return rez;
        }
        else
            return null;
    }

    public int getCapacity(){return capacity;}

    public void setCapacity(int capacity){this.capacity=capacity;}

    @Override
    public int count() {
        return size+1;
    }

    public void setSize(int size){this.size = size;}

    @Override
    public boolean isEmpty() {
        return (size == -1);
    }

    @Override
    public Boolean existItem(int key) {
        for(int i=0;i<size;i++){
            if(((Carte)tabel[i]).getId() == key)
                return true;
        }
        return false;
    }

    private int findObject(int key){
        for(int i=0;i<=size;i++)
            if(((Carte)tabel[i]).getId() == key)
                return i;
        return -1;
    }

    public IIterator getIterator(){
        return new Iterator();
    }

    public class Iterator implements IIterator{
        private int index; //current index

        public Iterator(){
            index=0;
            first();
        }

        public void first() {
            index=0;
        }

        public void next() {
            ++index;
        }

        @SuppressWarnings("rawtypes")
        public Comparable getElement() {
            return tabel[index];
        }

        public boolean hasNext() {

            if (index<count()-1)
                return true;
            return false;
        }

        public boolean isValid() {

            if ((index>=0) && (index<=count()-1))
                return true;
            return false;
        }

    }//class Iterator

}//class Set
