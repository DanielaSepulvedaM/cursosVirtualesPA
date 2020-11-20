package co.edu.ucentral.cursos.service;


import javax.persistence.EntityManager;

public abstract class DAO<T,K> {
    protected EntityManager _em;
    
    public DAO(){
    }
    
    public  EntityManager getEntityManager(){
        return this._em;
    }
    
    //find(K id):Busca una entidad utilizando su clave primaria devolviendo null ni se encuentra.
               //la debe implementar la subclase por que el metodo  find del entititymanager utiliza
               //como primer parametro la clase de la entida a buscar y Java no permite obtenerla a 
               //partir del tipo parametrico L
    public abstract T find(K id);//se encarga de encontrar una entidad dentro de 1 tabla
    
    /*
    public ArrayList<T> select(){
        _em.
    }
    */
    //create(T t):Hace persistente una entidad que se para como parametro y la devulve
                  //se devuelve una entidad gestionada.
    public T create(T t) {
        checkTransaction();
        _em.persist(t);
        _em.flush();
        _em.refresh(t);
        return t;
    }
    
    //update(T t): se actualiza el valor de una entidad en el contexto de persistencia, llamando 
                  //al metodo merge para segurarse de que la entidad se convierte en gestionada
                  //si la entidad ya esta gestionada no hace nada. Se devuelve la propia entidad 
                  //cuando termine la transaccion y el entity manager realice un flush el valor de 
                  //la entidad se volcara a la BD.
    public T update(T t) {
        checkTransaction();
        return (T) _em.merge(t);
    }
    
    //delete(T t): Se elimina una entidad de la BD llamando al metodo remove una vez nos hemos 
                 //asegurado de que la entidad esta gestionada llamando al metodo merge.
    public void delete(T t) {
        checkTransaction();
        t = _em.merge(t);
        _em.remove(t);
    }

    private void checkTransaction() {
        if (!_em.getTransaction().isActive())
            throw new RuntimeException("Transacción inactiva");
    }
}
