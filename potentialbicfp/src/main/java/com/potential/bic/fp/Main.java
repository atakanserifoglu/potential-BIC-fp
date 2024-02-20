package com.potential.bic.fp;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.Transformer;

import com.potential.bic.fp.EnvironmentalAssumption.fileHandler;

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
        } catch (IOException e) {
            e.printStackTrace();
    }
}
