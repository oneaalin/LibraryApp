package repository.array;

import domain.Carte;
import repository.BibliotecaRepository;
import utils.ISet;
import utils.Set;

public class BibliotecaRepositoryArray implements BibliotecaRepository {

    private ISet set;

    public BibliotecaRepositoryArray(int capacity){set = new Set(capacity);}

    public Boolean saveObject(Object c){return set.addItem((Carte) c);}

    public Boolean deleteObject(int id){
        Carte c = (Carte)findObjectId(id);
        return set.deleteItem(id);
    }

    public Boolean updateObject(int key,Object c){
        return set.updateItem(key,(Carte)c);
    }

    public Object[] getAll(){
        if(set.count()>0){
            Object[] rez = set.getItems();
            return rez;
        }
        return null;
    }

    public int count(){return set.count();}

    @Override
    public Boolean existObject(int id) {
        Carte[] c = (Carte[])set.getItems();
        for(int i=0;i<c.length;i++)
            if(id==c[i].getId())
                return true;
        return false;
    }

    @Override
    public Object findObjectId(int id) {
        Object[] o = set.getItems();
        for(int i=0;i<o.length;i++)
            if(id == ((Carte) o[i]).getId())
                return o[i];
        return null;
    }
}
