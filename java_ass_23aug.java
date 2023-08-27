//singelton class
class X{
    int x = 5;
    static X obj = null;
    private X(){}

    public static X getx(){

        if(obj == null)
            obj = new X();
        return obj;

    }
}
public class Main {
    public static void java_ass_23aug(String[] args){

        //System.out.println(X.getx().x);
        X x1 = X.getx();
        X x2 = X.getx();
        System.out.println(x1.hashCode());
        System.out.println(x2.hashCode());

    }
}
