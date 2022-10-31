package com.codeInterview.Path1;

import com.offer.APathBase;

import java.util.LinkedList;
import java.util.Queue;

/*
【题目】
宠物、狗和猫的类如下：
【要求】
实现一种狗猫队列的结构，要求如下：
用户可以调用add方法将cat类或dog类的实例放入队列中；
用户可以调用pollAll方法，将队列中所有的实例按照进队列的先后顺序依次弹出；
用户可以调用pollDog方法，将队列中dog类的实例按照进队列的先后顺序依次弹出；
用户可以调用pollCat方法，将队列中cat类的实例按照进队列的先后顺序依次弹出；
用户可以调用isEmpty方法，检查队列中是否还有dog或cat的实例；
用户可以调用isDogEmpty方法，检查队列中是否有dog类的实例；
用户可以调用isCatEmpty方法，检查队列中是否有cat类的实例。
*/
public class Chapter1_4 extends APathBase {

    @Override
    public void Start() {
        Dog dog1 = new Dog("dog1");
        Dog dog2 = new Dog("dog2");
        Dog dog3 = new Dog("dog3");
        Dog dog4 = new Dog("dog4");

        Cat cat1 = new Cat("cat1");
        Cat cat2 = new Cat("cat2");
        Cat cat3 = new Cat("cat3");
        Cat cat4 = new Cat("cat4");

        DogCatQueue dogCatQueue = new DogCatQueue();
        dogCatQueue.add(dog1);
        dogCatQueue.add(cat1);
        dogCatQueue.add(dog2);
        dogCatQueue.add(cat2);
        dogCatQueue.add(dog1);
        dogCatQueue.add(dog3);

        dogCatQueue.pollDog().printName();
        dogCatQueue.pollCat().printName();
        dogCatQueue.pollAll().printName();
    }

}

class DogCatQueue{
    private Queue<PetEnterQueue> dogQueue;
    private Queue<PetEnterQueue> catQueue;
    private long count;

    public DogCatQueue(){
        this.dogQueue = new LinkedList<PetEnterQueue>();
        this.catQueue = new LinkedList<PetEnterQueue>();
        this.count = 0;
    }

    public void add(Pet pet){
        if(pet.getPetType().equals("dog")){
            this.dogQueue.add(new PetEnterQueue(pet, this.count++));
        } else if (pet.getPetType().equals("cat")) {
            this.catQueue.add(new PetEnterQueue(pet, this.count++));
        }else{
            throw new RuntimeException("err, not dog or cat");
        }
    }

    public Pet pollAll(){
        if(!this.dogQueue.isEmpty() && !this.catQueue.isEmpty()){
            if(this.dogQueue.peek().getCount() < this.catQueue.peek().getCount()){
                return this.dogQueue.poll().getPet();
            }else{
                return this.catQueue.poll().getPet();
            }
        } else if (!this.dogQueue.isEmpty()) {
            return this.dogQueue.poll().getPet();
        } else if (this.catQueue.isEmpty()) {
            return this.catQueue.poll().getPet();
        }else{
            throw new RuntimeException("err, queue is empty!");
        }
    }

    public Dog pollDog(){
        if(!this.isDogQueueEmpty()){
            return (Dog) this.dogQueue.poll().getPet();
        }else{
            throw new RuntimeException("Dog queue is empty!");
        }
    }

    public Cat pollCat(){
        if(!this.isCatQueueEmpty()){
            return (Cat) this.catQueue.poll().getPet();
        }else{
            throw new RuntimeException("Cat queue is empty!");
        }
    }

    public boolean isEmpty(){
        return this.dogQueue.isEmpty() && this.catQueue.isEmpty();
    }

    public boolean isDogQueueEmpty(){
        return this.dogQueue.isEmpty();
    }

    public boolean isCatQueueEmpty(){
        return this.catQueue.isEmpty();
    }
}

class PetEnterQueue{
    private Pet pet;
    private long count;

    public PetEnterQueue(Pet pet, long count){
        this.pet = pet;
        this.count = count;
    }

    public Pet getPet(){
        return this.pet;
    }

    public long getCount(){
        return this.count;
    }

    public String getEnterPetType(){
        return this.pet.getPetType();
    }
}

class Pet{
    private String type;
    private String name;
    public Pet(String type, String name){
        this.type = type;
        this.name = name;
    }

    public String getPetType(){
        return this.type;
    }

    public void printName(){
        System.out.println(this.name);
    }
}

class Dog extends Pet{
    public Dog(String name){
        super("dog", name);
    }
}

class Cat extends  Pet{
    public Cat(String name){
        super("cat", name);
    }
}