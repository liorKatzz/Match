package Match;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class test {

    public static void main(String args[]) throws Exception{


        //Guys:
        int[] test1 = {1, 2, 3, 4, 5, 6, 7, 7, 4, 1}; //average 4
        int[] test2 = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        int[] test3 = {2, 2, 2, 2, 2, 2, 2, 2, 2, 2};
        int[] test4 = {3, 3, 3, 3, 3, 3, 3, 3, 3, 3};
        ArrayList<int[]> results1 = new ArrayList<>();
        results1.add(test1);
        results1.add(test2);
        results1.add(test3);
        results1.add(test4);
        double[] weights1 = {0.5, 0.2, 0.2, 0.1};
        Person person1 = new Person("Arnold", true, results1, weights1); //It is a man

        int[] test5 = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        int[] test6 = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        int[] test7 = {2, 2, 2, 2, 2, 2, 2, 2, 2, 2};
        int[] test8 = {3, 3, 3, 3, 3, 3, 3, 3, 3, 3};
        ArrayList<int[]> results2 = new ArrayList<>();
        results2.add(test5);
        results2.add(test6);
        results2.add(test7);
        results2.add(test8);
        double[] weights2 = {0.25, 0.25, 0.25, 0.25};
        Person person2 = new Person("Moshe", true, results2, weights2);

        int[] test9 = {3, 3, 3, 3, 3, 1, 1, 1, 1, 1};
        int[] test10 = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        int[] test11 = {4, 4, 4, 4, 4, 2, 2, 2, 2, 2};
        int[] test12 = {3, 3, 3, 3, 3, 3, 3, 3, 3, 3};
        ArrayList<int[]> results3 = new ArrayList<>();
        results3.add(test9);
        results3.add(test10);
        results3.add(test11);
        results3.add(test12);
        double[] weights3 = {0.91, 0.03, 0.03, 0.03};
        Person person3 = new Person("Gadi", true, results3, weights3);

        //Girls:

        int[] test13 = {5, 5, 5, 5, 5, 5, 5, 5, 5, 5};
        int[] test14 = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        int[] test15 = {2, 2, 2, 2, 2, 2, 2, 2, 2, 2};
        int[] test16 = {3, 3, 3, 3, 3, 3, 3, 3, 3, 3};
        ArrayList<int[]> results4 = new ArrayList<>();
        results4.add(test13);
        results4.add(test14);
        results4.add(test15);
        results4.add(test16);
        double[] weights4 = {0.40, 0.2, 0.2, 0.2};
        Person person4 = new Person("Rina", false, results4, weights4);

        int[] test17 = {5, 5, 5, 5, 5, 5, 5, 5, 5, 5};
        int[] test18 = {4, 4, 4, 4, 4, 4, 4, 4, 4, 4};
        int[] test19 = {2, 2, 2, 2, 2, 2, 2, 2, 2, 2};
        int[] test20 = {3, 3, 3, 3, 3, 3, 3, 3, 3, 3};
        ArrayList<int[]> results5 = new ArrayList<>();
        results5.add(test17);
        results5.add(test18);
        results5.add(test19);
        results5.add(test20);
        double[] weights5 = {0.60, 0.2, 0.1, 0.1};
        Person person5 = new Person("Dina", false, results5, weights5);

        int[] test21 = {6, 6, 6, 6, 6, 6, 6, 6, 6, 6};
        int[] test22 = {1, 1, 1, 1, 1, 3, 3, 3, 3, 3};
        int[] test23 = {2, 2, 2, 2, 2, 2, 2, 2, 2, 2};
        int[] test24 = {3, 3, 3, 3, 3, 3, 3, 3, 3, 3};
        ArrayList<int[]> results6 = new ArrayList<>();
        results6.add(test21);
        results6.add(test22);
        results6.add(test23);
        results6.add(test24);
        double[] weights6 = {0.2, 0.2, 0.2, 0.4};
        Person person6 = new Person("Shlomit", false, results6, weights6);


        List<Person> personas = new LinkedList<>();
        personas.add(person1);
        personas.add(person2);
        personas.add(person3);
        personas.add(person4);
        personas.add(person5);
        personas.add(person6);


        Couple couple1 = new Couple(person1, person4);

        Couple couple2 = new Couple(person1, person5);

        Couple couple3 = new Couple(person1, person6);

        Couple couple4 = new Couple(person2, person4);

        Couple couple5 = new Couple(person2, person5);

        Couple couple6 = new Couple(person2, person6);

        Couple couple7 = new Couple(person3, person4);

        Couple couple8 = new Couple(person3, person5);

        Couple couple9 = new Couple(person3, person6);




        ArrayList<Couple> couples = new ArrayList<>(); //change to ordered list
        couples.add(couple9);
        couples.add(couple2);
        couples.add(couple3);
        couples.add(couple7);
        couples.add(couple8);
        couples.add(couple1);
        couples.add(couple6);
        couples.add(couple5);
        couples.add(couple4);


        ListOfCouples lcouples = new ListOfCouples(); //change to ordered list
        lcouples.addCouple(couple9);
        lcouples.addCouple(couple2);
        lcouples.addCouple(couple3);
        lcouples.addCouple(couple7);
        lcouples.addCouple(couple8);
        lcouples.addCouple(couple1);
        lcouples.addCouple(couple6);
        lcouples.addCouple(couple5);
        lcouples.addCouple(couple4);

        ArrayList<Couple> happyList = new ArrayList<>();


        System.out.println(couple1.person1.id + " and " + couple1.person2.id + " is: " + couple1.power);
        System.out.println(couple2.person1.id + " and " + couple2.person2.id + " is: " + couple2.power);
        System.out.println(couple3.person1.id + " and " + couple3.person2.id + " is: " + couple3.power);
        System.out.println(couple4.person1.id + " and " + couple4.person2.id + " is: " + couple4.power);
        System.out.println(couple5.person1.id + " and " + couple5.person2.id + " is: " + couple5.power);
        System.out.println(couple6.person1.id + " and " + couple6.person2.id + " is: " + couple6.power);
        System.out.println(couple7.person1.id + " and " + couple7.person2.id + " is: " + couple7.power);
        System.out.println(couple8.person1.id + " and " + couple8.person2.id + " is: " + couple8.power);
        System.out.println(couple9.person1.id + " and " + couple9.person2.id + " is: " + couple9.power);



        ArrayList<Couple> couples2 = new ArrayList<>();
        couples2.add(couple1);
        couples2.add(couple2);
        couples2.add(couple4);
        couples2.add(couple5);

        int[] counterArr = new int[9];

        for (int i = 0; i < 100000; i++){
            // ArrayList<Couple> copyCouples = Dynamic.copyCoupleArr(couples);
            //ArrayList<Couple> happyCopy = Dynamic.copyCoupleArr(happyList);
            ListOfCouples couplesl = lcouples.cloneIt();
            ListOfCouples res = FinalMatch.finalMatch2(couplesl);
            for (int j = 0; j < res.list.size(); j++){
                Couple currHappy = res.list.get(j);
                String currPerson1 = currHappy.person1.id;
                String currPerson2 = currHappy.person2.id;
                if (currPerson1 == "Arnold"){
                    if (currPerson2 == "Rina"){
                        counterArr[0]++;
                    }
                    if (currPerson2 == "Dina"){
                        counterArr[1]++;
                    }
                    if (currPerson2 == "Shlomit"){
                        counterArr[2]++;
                    }
                }
                if (currPerson1 == "Moshe"){
                    if (currPerson2 == "Rina"){
                        counterArr[3]++;
                    }
                    if (currPerson2 == "Dina"){
                        counterArr[4]++;
                    }
                    if (currPerson2 == "Shlomit"){
                        counterArr[5]++;
                    }
                }
                if (currPerson1 == "Gadi"){
                    if (currPerson2 == "Rina"){
                        counterArr[6]++;
                    }
                    if (currPerson2 == "Dina"){
                        counterArr[7]++;
                    }
                    if (currPerson2 == "Shlomit"){
                        counterArr[8]++;
                    }
                }
            }
        }
        for (int i = 0; i < counterArr.length; i++){
            System.out.println("Couple" + (i + 1) + " was matched " +
                    counterArr[i] + " times");
        }
        System.out.println("Success");
    }
}


