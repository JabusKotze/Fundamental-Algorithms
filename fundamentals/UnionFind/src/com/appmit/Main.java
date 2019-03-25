package com.appmit;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("How many nodes should be present? press <enter>:");

        int N = scanner.nextInt();

	    UF unionFind = new UF(N);

	    QuickUnion quickUnion = new QuickUnion(N);

	    String quit = "n";

	    while(!quit.equals("Y")){
	        System.out.println("Union Coord 1:");
	        int p = scanner.nextInt();

            System.out.println("Union Coord 2:");
            int q = scanner.nextInt();

            System.out.println(p + " " + q);

            unionFind.union(p,q);
            quickUnion.union(p,q);

            System.out.println("Continue adding unions? Y/n: <enter>");
            scanner.nextLine();
            quit = scanner.nextLine();

            System.out.println(quit);

        }

	    while(true){
            System.out.println("Connected Coord 1:");
            int p = scanner.nextInt();

            System.out.println("Connected Coord 2:");
            int q = scanner.nextInt();

            System.out.println(unionFind.connected(p,q) ? "QF Yes": "QF No");

            System.out.println(quickUnion.connected(p,q) ? "QU Yes": "QU No");
        }

    }
}
