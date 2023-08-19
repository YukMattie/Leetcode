class TimeMap {

    // elements in treemap in a sorted order
    Map<String, TreeMap<Integer, String>> map;

    public TimeMap() {
        this.map = new HashMap<>(); 
    }
    
    public void set(String key, String value, int timestamp) {
        if(this.map.containsKey(key)){
            // map.get() is the treeMap
            // add the pair to the treeMap
            map.get(key).put(timestamp, value);
        }
        else{
            // create a new treeMap and put it as the value
            map.put(key, new TreeMap<>());
            map.get(key).put(timestamp, value);
        }  
    }
    
    public String get(String key, int timestamp) {
        TreeMap<Integer, String> tp = this.map.get(key);
        if(tp == null){
            return "";
        }else{
            // must use Integer here, because TreeMap is a data structure that relies on object-oriented principles, and it works with objects
            Integer floor =  tp.floorKey(timestamp);
            if(floor == null){
                return "";
            }
            else{
                return tp.get(floor);
            }
        }
        
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */