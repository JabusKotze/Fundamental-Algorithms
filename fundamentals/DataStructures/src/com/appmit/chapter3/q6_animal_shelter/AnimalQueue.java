package com.appmit.chapter3.q6_animal_shelter;

import java.util.LinkedList;

public class AnimalQueue {

    LinkedList<Dog> dogs = new LinkedList<Dog>();
    LinkedList<Cat> cats = new LinkedList<Cat>();
    private int order = 0;

    public void enqueue(Animal animal){

        animal.setOrder(order);
        order++;

        if(animal instanceof Dog){
            dogs.addLast((Dog)animal);
        }else if(animal instanceof Cat){
            cats.addLast((Cat)animal);
        }
    }

    public Animal dequeueAny(){
        if(dogs.size() == 0){
            return dequeueCat();
        }else if(cats.size() == 0){
            return dequeueDog();
        }else{

            int orderDog = dogs.peekFirst().order;
            int orderCat = cats.peekFirst().order;

            if(orderCat > orderDog){
                return dequeueDog();
            }else{
                return dequeueCat();
            }
        }
    }

    public Animal dequeueCat(){
        return cats.poll();
    }

    public Animal dequeueDog(){
        return dogs.poll();
    }

    public int size(){
        return cats.size() + dogs.size();
    }

}
