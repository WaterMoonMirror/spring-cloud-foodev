package com.tkn.guavaldemo.list;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import javafx.scene.input.ScrollEvent;
import sun.security.provider.certpath.Vertex;

/**
 * @author: lizhu@wondesgroup.com
 * @date: 2021/7/12 15:38
 * @description: 新集合类型Table，它有两个支持所有类型的键：”行”和”列”
 */
public class TableTest {
    public static void main(String[] args) {
        Table<String, String, Double> weightedGraph = HashBasedTable.create();
        weightedGraph.put("v1","v2",23d);
        weightedGraph.put("v1","v3",33d);
        weightedGraph.put("v2","v2",44d);
        weightedGraph.put("v3","v2",22d);
        weightedGraph.put("v3","v1",55d);
        System.out.println("row: "+weightedGraph.row("v1"));
        System.out.println("column: "+weightedGraph.column("v2"));
        System.out.println("rowMap: "+weightedGraph.rowMap());
        System.out.println("columnKeySet: "+weightedGraph.columnKeySet());
        System.out.println("contains: "+weightedGraph.contains("v1","v2"));
        System.out.println("size: "+weightedGraph.size());
        System.out.println("values: "+weightedGraph.values());

    }
}
