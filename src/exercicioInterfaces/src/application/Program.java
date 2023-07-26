package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Contract;
import model.entities.Installment;
import model.service.ContractService;
import model.service.PaypalService;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner scanner = new Scanner(System.in);
		
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		System.out.println("Enter the contract details: ");
		System.out.print("Number: ");
		int number = scanner.nextInt();
		System.out.print("Data (dd/MM/yyyy): ");
		LocalDate date = LocalDate.parse(scanner.next(), fmt);
		System.out.print("Contract value: ");
		double contractValue = scanner.nextDouble();
		
		
		Contract obj = new Contract(number, date, contractValue);
		
		System.out.print("Enter the installments number: ");
		int n = scanner.nextInt();
		
		ContractService contractService = new ContractService(new PaypalService());
		
		contractService.processContract(obj, n);
		
		System.out.println("Installments: ");
		for(Installment installment : obj.getInstallments()) {
			System.out.println(installment);
		}
		
		scanner.close();

	}

}
