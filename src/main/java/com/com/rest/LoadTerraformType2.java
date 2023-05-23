package com.com.rest;

import com.google.common.collect.Lists;
import org.springframework.util.StringUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class LoadTerraformType2 {
    public static void main(String[] args) throws IOException {
        List<Terraform> list = new ArrayList<>();
        try {
            File file = new File("C:\\Users\\ravi\\IdeaProjects\\springbootservertemplate\\terraform2");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] elements = line.split(";");
                Terraform terraform = new Terraform(elements[0], StringUtils.isEmpty(elements[1]) ? "NO" : elements[1],
                        StringUtils.isEmpty(elements[2]) ? "NO" : elements[2],
                        StringUtils.isEmpty(elements[3]) ? "NO" : elements[3],
                        StringUtils.isEmpty(elements[4]) ? "NO" : elements[4],
                        StringUtils.isEmpty(elements[5]) ? "NO" : elements[5]);
                list.add(terraform);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        List<Integer> indexes = Lists.newArrayList();
        while (true) {
            Random rn = new Random();
            int index = rn.nextInt(list.size());
            if (indexes.size() == list.size()) {
                indexes = Lists.newArrayList();
                System.out.println("reset");
                System.out.println();
            }
            if (indexes.contains(index)) {
                continue;
            }
            indexes.add(index);
            //System.out.println(index);
            Terraform terraform = list.get(index);
            System.out.print(terraform.getFeature());
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            reader.readLine();
            System.out.println(terraform);
            System.out.println();
        }

    }
}


