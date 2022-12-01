import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Lambda02 {

    public static void main(String[] args) {

        List<Integer> sayi = new ArrayList<>(Arrays.asList(4, 2, 6, 11, -5, 7, 3, 15));

        ciftKarePrint(sayi);
        System.out.println("\n **********");
        tekKupBirFazlaPrint(sayi);//1332 -124 344 28 3376
        System.out.println("\n **********");
        maxElBul(sayi);//Optional[15]
        System.out.println("\n **********");
        structuredMaxElBul(sayi);
        System.out.println("\n **********");
        maxCiftKare(sayi);
    }

    // Task-1 : Functional Programming ile listin cift elemanlarinin  karelerini
    // ayni satirda aralarina bosluk bırakarak print ediniz

    public static void ciftKarePrint(List<Integer> sayi){
        sayi.
                stream().
                filter(Lambda01::ciftBul).
                map(t->t*t).//16,4,36 -- Stream icerisindeki elemanlari baska degerlere donusturur.
                forEach(Lambda01::yazdir);
    }
    // Task-2 : Functional Programming ile listin tek elemanlarinin  kuplerinin
    // bir fazlasini ayni satirda aralarina bosluk birakarak print ediniz.

    public static void tekKupBirFazlaPrint(List<Integer> sayi){

        sayi.
                stream().
                filter(t->t%2!=0).//11,-5,7,3,15
                map(t->(t*t*t)+1).
                forEach(Lambda01::yazdir);

    }

    // Task-3 : Functional Programming ile listin cift elemanlarinin
// karekoklerini ayni satirda aralarina bosluk birakarak yazdiriniz

    public static void ciftKarekokPrint(List<Integer> sayi){
        sayi.stream().filter(Lambda01::ciftBul).map(Math::sqrt).forEach(t-> System.out.println(t+ " "));



    }

    // Task-4 : list'in en buyuk elemanini yazdiriniz

    public static void maxElBul(List<Integer> sayi){

       Optional<Integer> maxSayi = sayi.stream().
                reduce(Math::max);//eger benim resultim tek bir deger ise o zaman reduce terminal opr. kullanilir.

        System.out.println(maxSayi);
    }

    //Structured yapi ile cozelim

    public static void structuredMaxElBul(List<Integer> sayi){

        int max = Integer.MIN_VALUE;
        System.out.println("max = " + max);

        for (int i = 0; i <sayi.size() ; i++) {

            if(sayi.get(i)>max) max = sayi.get(i);
        }
        System.out.println("en buyuk sayi: " + max);
    }


    // Task-5 : List'in cift elemanlarin karelerinin en buyugunu print ediniz

    public static void maxCiftKare (List<Integer> sayi){

        System.out.println(sayi.stream().
                filter(Lambda01::ciftBul).
                map(a -> a * a).reduce(Integer::max));

    }
    // Task-6: List'teki tum elemanlarin toplamini yazdiriniz.Lambda Expression...
    public static void elTopla(List<Integer> sayi){
        int toplam = sayi. // (4, 2, 6, 11, -5, 7, 3, 15)
                stream().
                reduce(0,(a,b) -> a+b);
        System.out.println("toplam = " + toplam);
        /*
        * a ilk degerini her zaman atanan degerden (ilk parametre) alır,
            bu örnekte 0 oluyor
        * b degerini her zamana  stream()'dan akısdan alır
        * a ilk degerinden sonraki her değeri action(işlem)'dan alır

        */
    }
    // Task-7 : List'teki cift elemanlarin carpimini  yazdiriniz.
    public static void ciftCarp(List<Integer> sayi){
        System.out.println(sayi.
                stream().
                filter(Lambda01::ciftBul).
                reduce(Math::multiplyExact)); // method refrance

        System.out.println(sayi.
                stream().
                filter(Lambda01::ciftBul).
                reduce(1, (a, b) -> (a * b))); // lambda expression
    }

    // Task-8 : List'teki elemanlardan en kucugunu  print ediniz.
    public static void minBul(List<Integer> sayi) {
        //1.yol : method refrancew
        System.out.println(sayi.
                stream().
                reduce(Integer::min));  // Math::min
// 2. yol : method refrance
        System.out.println(sayi.
                stream().
                reduce(Lambda02::byMiracMin));
    }
    public static int byMiracMin(int a , int b) {

        return (a<b) ? a : b ;   // byMiracMin(4,9)
    }

    // Task-9 : List'teki 5'ten buyuk en kucuk tek sayiyi print ediniz.
    public static void bestenBykTekKck(List<Integer> sayi) {
        System.out.println(sayi.
                stream().
                filter(a -> (a > 5) && (a % 2 == 1)).
                reduce(Lambda02::byMiracMin));
    }
    // Task-10 : list'in cift  elemanlarinin karelerini  kucukten buyuge print ediniz.
    public static void ciftKareKbSortPrint(List<Integer> sayi) {
        sayi.
                stream().  // akışı başlattık
                filter(Lambda01::ciftBul). // akış içindeki çift sayıları aldım
                map(t->t*t). // sayıların karesi ile yeni bir akış oluşturdum
                sorted(). // akış içindeki sayıları natural-order olarak sıraladım
                forEach(Lambda01::yazdir); // akışdaki, sayıları ekrana yazdım
    }
}



