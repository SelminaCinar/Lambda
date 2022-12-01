import java.util.stream.IntStream;

public class Lambda05 {
    public static void main(String[] args) {
        System.out.println(topla(5));
        System.out.println(toplaCincix(5));
        System.out.println(toplaCift(4));

    }

        //TASK 01 --> Structured Programming ve Functional Programming ile 1'den x'e kadar (x dahil)
        // tamsayilari toplayan bir program create ediniz.

    //Structured
    public static int topla(int x) {
        int toplam =0;
        for(int i=0 ; i<=x ; i++ ) {
            toplam = toplam + i ;
        }
        return toplam;
    }

    // Functional
    public static int toplaCincix(int x) {  // List<Integer> x ---> x.stream().
        return IntStream. // int değerlerde bir akış sağlar
                range(1,x+1). // range(a,b) --> a dan b'ye kadar ( b dahil değil) int değerler akısa alındı
                sum();// akışdan gelen değerler toplandı
    }
    //TASK 02 --> 1'den x'e kadar cift tamsayilari toplayan bir program create ediniz.
    public static int toplaCift(int x) {
        return IntStream.
                rangeClosed(1,x).
                filter(Lambda01::ciftBul).
                sum();
    }
    //TASK 03 --> Ilk x pozitif cift sayiyi toplayan program  create ediniz.

    //1. way
    public static int ilkPztfCiftSayi(int x){
        return IntStream.
                rangeClosed(1,x*2).
                filter(Lambda01::ciftBul).
                sum();
    }

    //2/way
    public static int toplaIlkXCift(int x){
       return IntStream.iterate(2,t->t+2)//2den sonsuza kadar elemanlari 2 arttirarak akisa alir
               .limit(x)//x ile sinirliyorum
               .sum();//toplamini aliyorum
    }
}











