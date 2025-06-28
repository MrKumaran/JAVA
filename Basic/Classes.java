package Learning.Basic;

// teaching

public class Classes {
    public static void main(String arg[]){
        smethd s1 = new smethd();
        smethd s2 = new smethd();
        smethd s3 = new smethd();
        smethd s4 = new smethd();
        smethd s5 = new smethd();
        s1.printI();
        s2.printI();
        s3.printI();
        s4.printI();
        s5.printI();

        s3.chargei();

        s1.printI();
        s2.printI();
        s3.printI();
        s4.printI();
        s5.printI();

        sme s40 = new sme();
    }

}

class smethd {
    static int i = 10;
    int p = 0;

     void printI(){
        System.out.println(i);
    }

     void chargei(){
        i = 9;
    }
}

class sme extends smethd{
    @Override
    void chargei(){
        i = 8;
    }

    void newFun(){

    }
}