import java.util.HashMap;

public class Demo <X>{

    public HashMap<X,Integer> createMap (X[] arr ){
        HashMap<X,Integer> map = new HashMap<>();
        for (X num : arr){
            if(map.containsKey(num)){
                map.put(num,map.get(num)+1);
            }else {
                map.put(num,1);
            }
        }
        return map;
    }

}
