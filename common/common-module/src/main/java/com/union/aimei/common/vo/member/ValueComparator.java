package com.union.aimei.common.vo.member;

import java.util.*;
import java.util.Map.Entry;

/**
 * @author houji
 * @date 2018/3/2  18:35
 */
public class ValueComparator{
    public static void main(String[] args) {
        Map<Integer,Long> map = new HashMap<>(16);
        map.put(6,5L);
        map.put(5,6L);
        map.put(4,4L);
        map.put(0,3L);
        map.put(1,2L);
        map.put(3,1L);
        map.put(2,2L);

        //根据map中的key值排序

        sortMap(map);
    }

    public static List<Integer> sortMap(Map<Integer, Long> map){
        List<Integer> list = new ArrayList<>(10);
        //获取entrySet
        Set<Entry<Integer, Long>> mapEntries = map.entrySet();

        for(Entry<Integer, Long> entry : mapEntries){
            System.out.println("key:" +entry.getKey()+"   value:"+entry.getValue() );
        }

        //使用链表来对集合进行排序，使用LinkedList，利于插入元素
        List<Entry<Integer, Long>> result = new LinkedList<>(mapEntries);
        //自定义比较器来比较链表中的元素
        Collections.sort(result, new Comparator<Entry<Integer, Long>>() {
            //基于entry的值（Entry.getValue()），来排序链表
            @Override
            public int compare(Entry<Integer, Long> o1,
                               Entry<Integer, Long> o2) {

                return o1.getValue().compareTo(o2.getValue()) ;
            }

        });

        //将排好序的存入到LinkedHashMap(可保持顺序)中，需要存储键和值信息对到新的映射中。
        Map<Integer, Long> linkMap = new LinkedHashMap<>(16);
        for(Entry<Integer, Long> newEntry :result){
            linkMap.put(newEntry.getKey(), newEntry.getValue());
        }
        //根据entrySet()方法遍历linkMap
        for(Entry<Integer, Long> mapEntry : linkMap.entrySet()){
            list.add(mapEntry.getKey());
        }
        return list;
    }
}

