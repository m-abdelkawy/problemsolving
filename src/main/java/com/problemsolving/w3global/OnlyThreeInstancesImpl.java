package com.problemsolving.w3global;

import java.util.Random;

public class OnlyThreeInstancesImpl implements OnlyThreeInstances {
    private static int counter = 0;

    private static OnlyThreeInstancesImpl[] instances = new OnlyThreeInstancesImpl[3];

    private OnlyThreeInstancesImpl() {
    }

    /**
     * return one of three instances with ids 0, 1, 2
     *
     * @param id the id of the instance
     * @return one of three instances with ids 0, 1, 2
     */
    public static OnlyThreeInstances getInstance(int id) throws Exception {
        if (id < instances.length) {
            if (instances[id] == null) {
                instances[id] = new OnlyThreeInstancesImpl();
            }
        } else {
            throw new Exception("Id values allowed are 0, 1, and 2 only");
        }
        return instances[id];
    }

    @Override
    public void handleRequest() {
    }

    public static void main(String[] args) {
        try {
            OnlyThreeInstances instance0 = getInstance(0);
            OnlyThreeInstances instance1 = getInstance(1);
            OnlyThreeInstances instance2 = getInstance(2);
            OnlyThreeInstances instance4 = getInstance(4);

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
