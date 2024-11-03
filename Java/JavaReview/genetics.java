package JavaReview;

/*
Fix the FavoriteClasses class to use generics for it's three variables, favorite1, favorite2, and favorite3,
it's constructor, and it's three functions to return each variable, as well as fixing r in the main section.

Then define a variable of the FavoriteClasses class and use "Hello", 67, 6.3 as the arguments for the constructor,
and when you define it use your favorite classes/types that go with the three arguments.

 */

import java.util.*;
public class genetics{
    public static class FavoriteClasses<type0,type1,type2>{
        type0 favorite1;
        type1 favorite2;
        type2 favorite3;
        FavoriteClasses(type0 fav1, type1 fav2, type2 fav3){
            this.favorite1=fav1;
            this.favorite2=fav2;
            this.favorite3=fav3;
        }
        type0 getFav1(){
            return(this.favorite1);
        }
        type1 getFav2(){
            return(this.favorite2);
        }
        type2 getFav3(){
            return(this.favorite3);
        }
    }
    public static void main(String[] args){
        List<Float> r=new ArrayList();
        r.add(6.3F);
        r.add(5.9F);
        FavoriteClasses<String,Integer,Float> a=new FavoriteClasses<String,Integer,Float>("Hello",67,r.get(0));
        System.out.println("My favorites are " + a.getFav1() + ", " + a.getFav2() + ", and " + a.getFav3() + ".");
    }
}
