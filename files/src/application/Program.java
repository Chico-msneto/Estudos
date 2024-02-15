package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entitites.Product;


public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter a file path: ");
		String strPath = sc.nextLine();
		
		File path = new File(strPath);
		String sourceFolder = path.getParent();
		
		boolean success = new File(sourceFolder + "\\out").mkdir() ;
		String targetFile = sourceFolder + "\\out\\summary.csv";
		
		List<Product> products = new ArrayList<>();
		
		
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			String lines = br.readLine();
			while(lines != null) {
				String[] fields	= lines.split(",");		
				String name = fields[0];
				Double price = Double.parseDouble(fields[1]);
				int quantity = Integer.parseInt(fields[2]);
				products.add(new Product(name, price, quantity));
				lines = br.readLine();
			}
			try (BufferedWriter bw = new BufferedWriter(new FileWriter(targetFile))) {
				for (Product p : products) {
					bw.write(p.getName() + "," + String.format("%.2f", p.totalPrice()));
					bw.newLine();
				}
			}
			catch (IOException e) {
				System.out.println("Error: "+ e.getMessage());
			}
		System.out.println(targetFile + " Created!");
		}
		catch (IOException e) {
			System.out.println("Error: "+ e.getMessage());
		}	
		sc.close();
	}
}
