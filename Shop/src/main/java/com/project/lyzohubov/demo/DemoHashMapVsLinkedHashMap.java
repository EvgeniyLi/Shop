package com.project.lyzohubov.demo;

import com.project.lyzohubov.entity.Laptop;
import com.project.lyzohubov.generation.HashCodeGeneratorLength;


import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;

public class DemoHashMapVsLinkedHashMap {

    public static void main(String[] args) {

        Laptop laptop1 = new Laptop(1, "Hp", new BigDecimal("55"), 12, 244);
        Laptop laptop2 = new Laptop(2, "Samsung", new BigDecimal("4"), 12, 33);
        Laptop laptop3 = new Laptop(2, "Lg", new BigDecimal("4"), 12, 33);

        HashCodeGeneratorLength wrap1 = new HashCodeGeneratorLength("abd");
        HashCodeGeneratorLength wrap2 = new HashCodeGeneratorLength("bdas");
        HashCodeGeneratorLength wrap3 = new HashCodeGeneratorLength("abs");
        HashCodeGeneratorLength wrap4 = new HashCodeGeneratorLength("df");
        HashCodeGeneratorLength wrap5 = new HashCodeGeneratorLength("sssss");

        HashMap<HashCodeGeneratorLength, Laptop> hashMap = new HashMap();
        hashMap.put(wrap1, laptop1);
        hashMap.put(wrap2, laptop2);
        hashMap.put(wrap3, laptop3);
        hashMap.put(wrap4, laptop3);
        hashMap.put(wrap5, laptop3);

        System.out.println("--------------------HashMap-------------------");

        Iterator iterator = hashMap.entrySet().iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println("------------------LinkedHashMap-------------------");

        LinkedHashMap<HashCodeGeneratorLength, Laptop> linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(wrap1, laptop1);
        linkedHashMap.put(wrap2, laptop2);
        linkedHashMap.put(wrap3, laptop3);
        linkedHashMap.put(wrap4, laptop3);
        linkedHashMap.put(wrap5, laptop3);

        Iterator iteratorlinkedHashMap = linkedHashMap.entrySet().iterator();
        while (iteratorlinkedHashMap.hasNext()) {
            System.out.println(iteratorlinkedHashMap.next());
        }
    }
}


