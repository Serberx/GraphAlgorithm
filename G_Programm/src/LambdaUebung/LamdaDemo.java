package LambdaUebung;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BinaryOperator;

public class LamdaDemo {


    public static int performOperation(int a, int b, BinaryOperation bo) {
        return bo.operation(a, b);
    }


    public static void main(String[] args) {

        

        binaryOperationVariants();

//        ArrayList<Integer> al = new ArrayList<>(Arrays.asList(15, 13, 51, 13, 54, 23452, 245, 63, 57, 7345, 245, 43, 134));
//
//        for(Integer in : al){
//            System.out.print(in+", ");
//        }
//
//        al.sort(new Comparator<Integer>() {
//            public int compare(Integer l1, Integer l2) {
//                return l1-l2;
//            }
//        });
//
//        System.out.println();
//
//        for(Integer in2: al){
//            System.out.print(in2+", ");
//        }

        ArrayList<Integer> intList = new ArrayList<>(Arrays.asList(2,6,3,4,7,8,6,54));

        System.out.println("Unsortiert");
        for(Integer i:intList){
            System.out.print(i+",");
        }
        intList.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });
        System.out.println();
        System.out.println("Aufsteigend");
        for(Integer i:intList){
            System.out.print(i+",");
        }

        System.out.println();
        ArrayList<Integer> intList2 = new ArrayList<>(Arrays.asList(2,6,3,4,7,8,6,54));
        System.out.println("Unsortiert");
        for(Integer i:intList2){
            System.out.print(i+",");
        }
        System.out.println();
        intList2.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        System.out.println("Absteigend");
        for(Integer i:intList2){
            System.out.print(i+",");
        }


    }

    public static void binaryOperationVariants() {
        Addition add = new Addition();
        System.out.println("3+4="+performOperation(3, 4, add));
        System.out.println("5-3="+performOperation(5,3,new Subtraktion()));
        int ergebnis =  performOperation(9,3, new Addition(){
            @Override
            public int operation(int a, int b){
                return a/b;
            }
        });
        System.out.println("9/3="+ergebnis);

        int ergebnis1 = performOperation(6, 9, (int a, int b)->(a+b));
        System.out.println("6+9="+ergebnis1);

        int ergebnis2 = performOperation(4,5, (a,b)->(a*b));
        System.out.println("4*5="+ergebnis2);
    }
}
