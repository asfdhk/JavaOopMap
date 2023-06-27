import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        int a[] = {1,1,2,4,5,6,6,6,6,5,1};
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int num : a){
            if (map.containsKey(num)){
                map.put(num,map.get(num) +1);
            }else {
                map.put(num,1);
            }
        }
        System.out.println(map);
    }
}
