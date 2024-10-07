package Entity;

import java.util.List;

public interface Igeneric<T> {
    public T updateInfor(int id);
    public void sortObj();
    public List<T> findByName(String name);
    public T findById(int id);
}
