package cz.hamiweb.petclinic.services.map;

import cz.hamiweb.petclinic.model.BaseEntity;
import cz.hamiweb.petclinic.services.CrudService;

import java.util.*;

public abstract class AbstractMapService<T extends BaseEntity, ID extends Long> implements CrudService<T, ID> {

    protected Map<Long, T> map = new HashMap<>();

    public Set<T> findAll(){
        return new HashSet<>(map.values());
    }

    public T findById(ID id){
        return map.get(id);
    }

    public T save(T object){
        if(object != null){
            if(object.getId() == null){
                object.setId(getNextId());
            }
            map.put(object.getId(), object);
            return object;
        }else{
            throw new RuntimeException("Cannot save null object.");
        }
    }

    public void deleteById(ID id){
        map.remove(id);
    }

    public void delete(T object){
        map.entrySet().removeIf(entry -> entry.getValue().equals(object));
    }

    private Long getNextId(){
        if(map.isEmpty())
            return 1L;
        else
            return Collections.max(map.keySet()) + 1;
    }

}
