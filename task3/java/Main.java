public class Main <T> {
    public static void main(String[] args) {
        Integer  a[]={1,3,2,2,2,4,4,1,2,3};
        Character b[] = {'s','s','a','f','f','a'};
        Demo<Integer> demo = new Demo<>();
        Demo<Character> demo1 = new Demo<>();
        System.out.println(demo.createMap(a));
        System.out.println(demo1.createMap(b));
    }
}
