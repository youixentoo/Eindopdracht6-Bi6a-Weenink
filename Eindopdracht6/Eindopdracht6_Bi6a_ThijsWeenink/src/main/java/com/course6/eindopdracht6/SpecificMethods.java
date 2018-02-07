/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.course6.eindopdracht6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Thijs Weenink
 * @version 1.0
 * <br>Some highly specific methods used in virusGUI.java and VirusLogic.java
 */
public class SpecificMethods {

    /**
     * Combineerd alle values uit de classificatie HaspMap tot 1 set, gebruikt voor sorteren
     * @param map De classificatie map
     * @param mapKeys De keys in de HashMap
     * @return De set met alle HashMap values
     */
    public static Set<String> combinedArrays(Map map, String[] mapKeys) {

        List<String> combined = new ArrayList<>();

        for (String key : mapKeys) {
            String[] valueArray = ((String) map.get(key)).substring(1).split(",");
            combined.addAll(Arrays.asList(valueArray));
        }

        Set<String> set = new LinkedHashSet(combined);

        return set;
    }
    
    /**
     * Sorteert de data die wordt gekozen door de radio buttons
     * @param data De data uit de JLists als array
     * @param option "VirusID, Classific of HostNumbers" als optie van de radio buttons
     * @param sortingReference De HashMap die als referentie wordt gebruikt
     * @return De gesorteerde set
     */
    public static Set<String> getSortedData(String[] data, String option, Map sortingReference){
        Set<String> sorted = null;
        if("VirusID".equals(option)){
            Arrays.sort(data);
            sorted = VirusLogic.getSetFromArray(data);
        }else if("Classific".equals(option)){
            String[] mapKeys = {"dsRNA", "dsDNA", "ssRNA", "ssDNA", "Retrovirus", "Satellite virus and Virophage", "Viroid", "Other"};
            Set sortedClassSet = SpecificMethods.combinedArrays(sortingReference, mapKeys);
            sorted = VirusLogic.intersectionOf2Lists(data, sortedClassSet);   
        }else if("HostNumbers".equals(option)){
            sorted = VirusLogic.intersectionOf2Lists(data, sortingReference.keySet());
        }
        return sorted;
    }
    
}
