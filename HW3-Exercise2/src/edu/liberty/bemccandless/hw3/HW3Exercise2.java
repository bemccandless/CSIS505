package edu.liberty.bemccandless.hw3;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Works with lambdas and streams to transform, filter and sort a List of Invoices
 * 
 * @author bemccandless
 */
public class HW3Exercise2 {

    private static final String[] partDescriptions = {
        "Wrench", "Table Saw", "Work Bench", "Band Saw", "Drill Press", 
        "Router Table", "Miter Saw", "Hammer", "Jointer", "Planar"
    };
    private static final Random randomGenerator = new Random();
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        List<Invoice> invoices = new ArrayList<>();
        Stream.iterate(1, partNumber -> ++partNumber)
                .limit(10)
                .forEach(partNumber -> invoices.add(createInvoice(partNumber)));
        
        System.out.println("Sort invoices by part description");
        System.out.println("--------------------------------------");
        invoices.stream().sorted((i1, i2) -> i1.getPartDescription().compareTo(i2.getPartDescription()))
            .forEach(System.out::println);
        System.out.println("");
        
        System.out.println("Sort invoices by price");
        System.out.println("--------------------------------------");
        invoices.stream().sorted((i1, i2) -> Double.compare(i1.getPrice(), i2.getPrice()))
            .forEach(System.out::println);
        System.out.println("");
        
        System.out.println("Map invoices to part description and quantity, then sort by quantity");
        System.out.println("------------------------------------------------------------------------");
        Map<String, Integer> invoiceMap1 = invoices.stream()
                .collect(Collectors.toMap(Invoice::getPartDescription, Invoice::getQuantity));
        invoiceMap1.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .forEach(System.out::println);
        System.out.println("");
        
        System.out.println("Map invoices to part description and calculated invoice value, then sort by invoice value");
        System.out.println("------------------------------------------------------------------------------------------");
        Map<String, Double> invoiceMap2 = invoices.stream()
                .collect(Collectors.toMap(Invoice::getPartDescription, (i) -> i.getQuantity() * i.getPrice()));
        invoiceMap2.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .forEach(HW3Exercise2::printEntryCurrencyFormatted);
        System.out.println("");
        
        System.out.println("Map invoices to part description and calculated invoice value, filter between $200-$500 then sort by invoice value");
        System.out.println("-------------------------------------------------------------------------------------------------------------------");
        Map<String, Double> invoiceMap3 = invoices.stream()
                .collect(Collectors.toMap(Invoice::getPartDescription, (i) -> i.getQuantity() * i.getPrice()));
        invoiceMap3.entrySet().stream()
                .filter((e) -> e.getValue() >= 200 && e.getValue() < 500)
                .sorted(Map.Entry.comparingByValue())
                .forEach(HW3Exercise2::printEntryCurrencyFormatted);
        
    }
    
    /**
     * Creates a new random valued Invoice
     * 
     * @param partNumber
     * @return Invoice
     */
    private static Invoice createInvoice(int partNumber) {
        return new Invoice(
                    partNumber, 
                    partDescriptions[--partNumber], 
                    randomGenerator.nextInt(20), 
                    randomGenerator.nextInt(150) + randomGenerator.nextDouble()
                );
    }
    
    /**
     * Prints a Map Entry to the output stream
     * 
     * @param entry 
     */
    private static void printEntryCurrencyFormatted(Entry<String, Double> entry) {
        System.out.println(String.format("%s=%s", entry.getKey(), NumberFormat.getCurrencyInstance().format(entry.getValue())));
    }
}
