package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			System.out.print("Número do Quarto: ");
			int number = sc.nextInt();
			System.out.print("Data de Entrada: ");
			Date checkIn = sdf.parse(sc.next());
			System.out.print("Data de Saída: ");
			Date checkOut = sdf.parse(sc.next());
			
			Reservation reservation = new Reservation(number, checkIn, checkOut);
			System.out.println("Reserva: " + reservation);
			
			System.out.println();
			System.out.println("Entre com os dados para atualização de reserva: ");
			System.out.print("Data de Entrada: ");
			checkIn = sdf.parse(sc.next());
			System.out.print("Data de Saída: ");
			checkOut = sdf.parse(sc.next());
			
			reservation.updateDates(checkIn, checkOut);
			System.out.println("Reserva: " + reservation);
		}
		catch(ParseException e) {
			System.out.println("Formato da Data Invalido!");
		}
		catch(DomainException e) {
			System.out.println("Erro in Reservation: " + e.getMessage());
		}
		catch(RuntimeException e) {
			System.out.println("Erro Inesperado! ");
		}
		sc.close();
			
		}
	}


