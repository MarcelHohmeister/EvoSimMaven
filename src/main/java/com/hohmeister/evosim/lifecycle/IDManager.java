package com.hohmeister.evosim.lifecycle;

import java.util.ArrayDeque;
import java.util.Queue;

public class IDManager {
    private final Queue<Integer> queue = new ArrayDeque<>();
    private int nextID = 0;

    public int getID(){
        return queue.isEmpty() ? nextID++ : queue.remove();
    }

    public void returnID(final int id){
        queue.add(id);
    }
}
