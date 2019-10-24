package com.appmit.chapter3.q6_animal_shelter;

public class Question {

    public static void main(String[] args){

        AnimalQueue queue = new AnimalQueue();
        queue.enqueue(new Cat("Baffana"));
        queue.enqueue(new Dog("Diesel"));
        queue.enqueue(new Dog("Basjan"));
        queue.enqueue(new Cat("Candas"));
        queue.enqueue(new Dog("Giorgio"));
        queue.enqueue(new Cat("Pixie"));
        queue.enqueue(new Dog("Armani"));

        System.out.println(queue.dequeueAny().name);
        System.out.println(queue.dequeueAny().name);
        System.out.println(queue.dequeueAny().name);

        queue.enqueue(new Cat("Mowww"));
        queue.enqueue(new Dog("Gucci"));
        queue.enqueue(new Dog("Oliver"));

        while (queue.size() > 0){
            System.out.println(queue.dequeueAny().name);
        }

    }
}
