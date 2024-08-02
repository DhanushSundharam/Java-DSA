

class MapUsingHash{

    private Entity[] entities ;
    
    public MapUsingHash(){
        entities = new Entity[100] ;

    }

    public void put (String key , String value){
        int hash = Math.abs(key.hashCode() % entities.length);
        entities[hash] = new Entity(key, value);
    }
    
    public String get (String key){
        int hash = Math.abs(key.hashCode() % entities.length);
        if (entities[hash] != null && entities[hash].key.equals(key)){
            return entities[hash].value ;
        }
        return null ;
    }

    public void remove(String key){
        int hash = Math.abs(key.hashCode() % entities.length);

        if (entities[hash] != null && entities[hash].key.equals(key)){
        entities[hash] =  null ;
        }
    }


}

class Entity {
    String key ;
    String value ;

    public Entity(String key , String value){
        this.key = key ;
        this.value = value ;
    }
}



public class Main {

    public static void main(String[] args) {

        MapUsingHash map = new MapUsingHash() ;
        map.put("Mango", "King of fruit");
        map.put("Apple", "A sweeet red fruit");
        map.put("Litchi", "Kunal's fav fruit");

        System.out.println(map.get("Apple"));
        
    }

    
}