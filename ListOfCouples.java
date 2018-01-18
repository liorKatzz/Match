package Match;

import java.util.ArrayList;

/**
 * Created by lior on 2/18/2017.
 * A class for creating an object that holds a an arrayList of couples and an expected successful matches from those
 * couples (a double). Every couple that enters, the success field is updated
 */
public class ListOfCouples {

    //The fields
    ArrayList<Couple> list;
    double es; //expected successes


    public ListOfCouples(){

        list = new ArrayList<>();

        es = 0;

    }

    //Setters

    //A method for adding a couple and updating the double
    double addCouple(Couple couple){

        list.add(couple);

        es += couple.power;

        return es;
    }

    //A method for the expected field, for special cases
    double setExpected(double d){
        es = d;
        return es;
    }



    /**
     * Given a person, check if that person is a part of any of the couples in the list.
     * The logic: go through every couple, if the person's id is either return true since the person is part of an
     * active couple. If the loop finishes then is not there and it's false
     */

    boolean isContain(Person person){

        for (Couple couple : list){

            if (couple.person1.id == person.id || couple.person2.id == person.id){
                return true;
            }
        }
        return false;
    }

    // Getters
    double getEs(){
        return es;
    }

    //A method to create a clone to the object
    ListOfCouples cloneIt(){
        ListOfCouples newList = new ListOfCouples();
        for (Couple couple : list){
            newList.addCouple(couple);
        }
        return newList;
    }


    // A method for deleting the couples that contained one of the person's couple
    void clear (Couple couple){
        for (int i = 0; i < list.size(); i++){
            Couple curr = list.get(i);
            if (couple.person1.id == curr.person1.id ||
                    couple.person2.id == curr.person2.id){
                list.remove(curr);
            }
        }
    }
}
