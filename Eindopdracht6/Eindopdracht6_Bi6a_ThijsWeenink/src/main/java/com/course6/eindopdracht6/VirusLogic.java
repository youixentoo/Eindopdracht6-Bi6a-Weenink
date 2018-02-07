/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.course6.eindopdracht6;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 *
 * @author Thijs Weenink
 * @version 1.1
 * <br>Most of the logic methods used in the virus application
 */
public class VirusLogic {

    /**
     * Maakt van een virus object ArrayList een HashMap van HostTaxID's en
     * HostLineage
     *
     * @param virusList De lijst met alle virus objecten
     * @return Een HashMap met alle HostTaxID's met als value de HostLineage
     */
    public static Map getHostInfo(List<Virus> virusList) {
        Map hostInfo = new HashMap();

        for (Virus v : virusList) {
            try {
                hostInfo.put(v.getHostTaxID(), v.getHostLineage());
            } catch (Exception ex) {
                continue;
            }
        }
        return hostInfo;
    }

    /**
     * Maakt van een set een array
     *
     * @param set De set
     * @return De array van de set
     */
    public static String[] getArrayFromSet(Set<String> set) {
        String[] array = set.toArray(new String[set.size()]);
        return array;
    }

    /**
     * Maakt van een array een set
     *
     * @param array De array
     * @return De set van de array
     */
    public static Set<String> getSetFromArray(String[] array) {
        Set<String> set = new LinkedHashSet<>(Arrays.asList(array));
        return set;
    }

    /**
     * Maakt van de virus object ArrayList een HashMap van HostTaxID als key en
     * de VirusTaxID's als value
     *
     * @param virusList De lijst met alle virus objecten
     * @return De HashMap met alle HostTaxID's met als value de VirusTaxID's.
     * Als er meerdere waardes zijn, zijn deze gesplitst op de ",".
     */
    public static Map getXtoVirusIdents(List<Virus> virusList) {
        Map hostVirusInfo = new HashMap();

        for (Virus v : virusList) {
            if (hostVirusInfo.containsKey(v.getHostTaxID())) {
                String value = (String) hostVirusInfo.get(v.getHostTaxID());
                value = value + "," + v.getVirusTaxID();
                hostVirusInfo.put(v.getHostTaxID(), value);
            } else {
                hostVirusInfo.put(v.getHostTaxID(), v.getVirusTaxID());
            }

        }

        return hostVirusInfo;
    }

    /**
     * Berekent de frequentie van items in een ArrayList
     *
     * @param list De lijst waarvan je de frequentie wilt weten van de items in
     * de lijst
     * @return Een HashMap met het item uit de lijst als key en de frequentie
     * als value
     */
    public static Map getFreq(List<String> list) {
        Map<String, Integer> result = new TreeMap<>();
//        System.out.println(map);
        for (String value : list) {
            Integer count = result.get(value);
            if (count == null) {
                result.put(value, 1);
            } else {
                result.put(value, count + 1);
            }
        }

        return result;
    }

    /**
     * Maakt een HashMap die gebruikt wordt voor het sorteren op classificatie
     *
     * @param virusList De lijst met alle virus objecten
     * @return Een Hashmap met alle VirusTaxID's die bij de classificatie horen.
     * Bij verder verwerken moet de eerste index worden verwijderd.
     */
    public static Map getVirusClass(List<Virus> virusList) {
        Map virusClass = new HashMap();
        virusClass.put("none", "");
        virusClass.put("dsRNA", "");
        virusClass.put("dsDNA", "");
        virusClass.put("ssRNA", "");
        virusClass.put("ssDNA", "");
        virusClass.put("Retrovirus", "");
        virusClass.put("Satellite virus and Virophage", "");
        virusClass.put("Viroid", "");
        virusClass.put("Other", "");

        Set tempSet = new HashSet();
        Set tmepset2 = new HashSet();

        for (Virus v : virusList) {
            String[] lineage = v.getVirusLineage().split("\\;");
            try {
                if (v.equals(v)) {
                    String value = (String) virusClass.get("none");
                    value = value + "," + v.getVirusTaxID();
                    virusClass.put("none", value);
                }
                if ("Viroids".equals(lineage[0])) {
                    String value = (String) virusClass.get("Viroid");
                    value = value + "," + v.getVirusTaxID();
                    virusClass.put("Viroid", value);
                } else {
                    if (" ssRNA viruses".equals(lineage[1])) {
                        String value = (String) virusClass.get("ssRNA");
                        value = value + "," + v.getVirusTaxID();
                        virusClass.put("ssRNA", value);
                    } else if (" ssDNA viruses".equals(lineage[1])) {
                        String value = (String) virusClass.get("ssDNA");
                        value = value + "," + v.getVirusTaxID();
                        virusClass.put("ssDNA", value);
                    } else if (" dsRNA viruses".equals(lineage[1])) {
                        String value = (String) virusClass.get("dsRNA");
                        value = value + "," + v.getVirusTaxID();
                        virusClass.put("dsRNA", value);
                    } else if (" dsDNA viruses".equals(lineage[1]) || " dsDNA viruses, no RNA stage".equals(lineage[1])) {
                        String value = (String) virusClass.get("dsDNA");
                        value = value + "," + v.getVirusTaxID();
                        virusClass.put("dsDNA", value);
                    } else if (" Retro-transcribing viruses".equals(lineage[1])) {
                        String value = (String) virusClass.get("Retrovirus");
                        value = value + "," + v.getVirusTaxID();
                        virusClass.put("Retrovirus", value);
                    } else if (" Satellites".equals(lineage[1]) || " unclassified virophages".equals(lineage[1])) {
                        String value = (String) virusClass.get("Satellite virus and Virophage");
                        value = value + "," + v.getVirusTaxID();
                        virusClass.put("Satellite virus and Virophage", value);
                    } else {
                        String value = (String) virusClass.get("Other");
                        value = value + "," + v.getVirusTaxID();
                        virusClass.put("Other", value);
                    }
                }
                tempSet.add(lineage[1]);
                tmepset2.add(lineage[0]);
            } catch (Exception exc) {
                //
            }

        }
        return virusClass;
    }

    /**
     * Geeft de overeenkomst tussen 2 arrays terug
     *
     * @param array1 Dit is de hoofd array, deze wordt gebruikt om te
     * vergelijken en deze volgorde wordt gebruikt
     * @param array2 Dit is de tweede array, deze wordt vergeleken en verliest
     * zijn volgorde
     * @return Een set met de overeenkomsten, op volgorde van de eerste array
     */
    public static Set intersectionOf2Lists(String[] array1, String[] array2) {
        Set setList1 = new LinkedHashSet(Arrays.asList(array1));
        Set setList2 = new LinkedHashSet(Arrays.asList(array2));

        Set intersection = new LinkedHashSet(setList1);
        intersection.retainAll(setList2);

//        System.out.println("Intersected: "+intersection.toString());
        return intersection;
    }

    /**
     * Geeft de overeenkomst tussen 2 lists terug
     *
     * @param list1 Dit is de hoofd list, deze wordt gebruikt om te vergelijken
     * en deze volgorde wordt gebruikt
     * @param list2 Dit is de tweede list, deze wordt vergeleken en verliest
     * zijn volgorde
     * @return Een set met de overeenkomsten, op volgorde van de eerste list
     */
    public static Set intersectionOf2Lists(List<String> list1, List<String> list2) {
        Set setList1 = new LinkedHashSet(list1);
        Set setList2 = new LinkedHashSet(list2);

        Set intersection = new LinkedHashSet(setList1);
        intersection.retainAll(setList2);

//        System.out.println("Intersected: "+intersection.toString());
        return intersection;
    }

    /**
     * Geeft de overeenkomst tussen 2 sets terug
     *
     * @param set1 Dit is de hoofd set, deze wordt gebruikt om te vergelijken en
     * deze volgorde wordt gebruikt
     * @param set2 Dit is de tweede set, deze wordt vergeleken en verliest zijn
     * volgorde
     * @return Een set met de overeenkomsten, op volgorde van de eerste set
     */
    public static Set intersectionOf2Lists(Set<String> set1, Set<String> set2) {
        Set intersection = new LinkedHashSet(set1);
        intersection.retainAll(set2);

//        System.out.println("Intersected: "+intersection.toString());
        return intersection;
    }

    /**
     * Geeft de overeenkomst tussen een array en een set terug
     *
     * @param array Dit is de array die wordt vergeleken en verliest zijn
     * volgorde
     * @param set Dit is de set die gebruikt wordt om te vergelijken en behoudt
     * zijn volgorde
     * @return Een set met de overeenkomsten, op volgorde van de set
     */
    public static Set intersectionOf2Lists(String[] array, Set set) {
        Set setList1 = new LinkedHashSet(Arrays.asList(array));

        Set intersection = new LinkedHashSet(set);
        intersection.retainAll(setList1);

        return intersection;
    }

    /**
     * Sorteert een HashMap op value, deze functie komt van stackoverflow af.
     * <a href="https://stackoverflow.com/a/2581754">link</a>
     *
     * @param map De map die gesorteerd moet worden
     * @return De gesorteerde map
     */
    public static <K, V extends Comparable<? super V>> Map<K, V>
            sortByValue(Map<K, V> map) {
        List<Map.Entry<K, V>> list = new LinkedList<>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<K, V>>() {
            public int compare(Map.Entry<K, V> o1, Map.Entry<K, V> o2) {
                return (o1.getValue()).compareTo(o2.getValue());
            }
        });

        Map<K, V> result = new LinkedHashMap<>();
        for (Map.Entry<K, V> entry : list) {
            result.put(entry.getKey(), entry.getValue());
        }
        return result;
    }

}
