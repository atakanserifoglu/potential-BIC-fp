package com.potential.bic.fp;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.Transformer;

import com.potential.bic.fp.Calculator.Calculator;
import com.potential.bic.fp.EnvironmentalAssumption.fileHandler;
import com.potential.bic.fp.Timing.CounterThread;
import com.potential.bic.fp.Timing.SharedResource;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.FileHandler;

public class Main {
    public static void main(String[] args) {
        List<String> originalList = new ArrayList<>();
        originalList.add("1");
        originalList.add("2");
        originalList.add("3");

        System.out.println("Original List: " + originalList);

        List<Integer> transformedList = (List<Integer>) CollectionUtils.collect(
                originalList,
                new Transformer<String, Integer>() {
                    @Override
                    public Integer transform(String input) {
                        return Integer.parseInt(input);
                    }
                }
        );

        System.out.println("Transformed List: " + transformedList);

        //file manager
        try {
            fileHandler.saveFile("Data.txt", "Some content");
            fileHandler.saveFile("data.txt", "Different content");
        } catch (IOException e) {
            e.printStackTrace();
        }



        //timing

        SharedResource sharedResource = new SharedResource();
        int numberOfThreads = 10;

        for (int i = 0; i < numberOfThreads; i++) {
            new CounterThread(sharedResource).start();
        }

        try {
            Thread.sleep(2000); // Wait for all threads to finish
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Expected counter: " + numberOfThreads);
        System.out.println("Actual counter: " + sharedResource.getCounter());


        //calculator
        int x = 1;
        int y = 0; // Changed to 0 to illustrate the protection
        int ans = 0;

        if (y != 0) {
            ans = Calculator.div(x, y);
        } else {
            System.out.println("Cannot divide by zero.");
        }

        System.out.println("Result: " + ans);
    
    }
}
