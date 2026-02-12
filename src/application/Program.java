package application;

import entities.CarRental;
import entities.Vehicle;
import services.BrasilTaxService;
import services.RentalService;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class Program {
	static void main() {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
		
		try {
			
			System.out.println("Enter the data: ");
			System.out.print("Car model: ");
			String carModel = sc.nextLine();
			System.out.print("Date of start: ");
			LocalDateTime start = LocalDateTime.parse(sc.nextLine(), dtf);
			System.out.print("Date of finish: ");
			LocalDateTime finish = LocalDateTime.parse(sc.nextLine(), dtf);
			
			CarRental cr = new CarRental(start, finish, new Vehicle(carModel));
			
			System.out.println("Enter the price per hour: ");
			double pricePerHour = sc.nextDouble();
			System.out.println("Enter the price per day: ");
			double pricePerDay = sc.nextDouble();
			
			RentalService rentalService = new RentalService(pricePerHour, pricePerDay, new BrasilTaxService());
			
			rentalService.processsInvoice(cr);
			
			System.out.println("INVOICE: ");
			System.out.println("Basic payment: " + cr.getInvoice().getBasicPayment());
			System.out.println("Tax: " + cr.getInvoice().getTex());
			System.out.println("Total payment: " + cr.getInvoice().getTotalPayment());
		}
		catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
		finally {
			sc.close();
		}
	}
}
