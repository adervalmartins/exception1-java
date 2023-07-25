package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {

		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Número do Quarto: ");
		int number = sc.nextInt();
		System.out.print("Data de Entrada: ");
		Date checkIn = sdf.parse(sc.next());
		System.out.print("Data de Saída: ");
		Date checkOut = sdf.parse(sc.next());
		
		if (!checkOut.after(checkIn)) {
			System.out.println("Erro Reservation! A data de Saída deve ser posterior a data de Entrada:");
		}
		else {
			Reservation reservation = new Reservation(number, checkIn, checkOut);
			System.out.println("Reserva: " + reservation);
			
			System.out.println();
			System.out.println("Entre com os dados para atualização de reserva: ");
			System.out.print("Data de Entrada: ");
			checkIn = sdf.parse(sc.next());
			System.out.print("Data de Saída: ");
			checkOut = sdf.parse(sc.next());
			
			Date now = new Date();
			if (checkIn.before(now) || checkOut.before(now)){
				System.out.println("Erro in Reservation! As datas para atualização deve ser datas futuras:");
			}
			else if  (!checkOut.after(checkIn)) {
				System.out.println("Erro Reservation! A data de Saída deve ser posterior a data de Entrada:");
			}
			else {
			reservation.updateDates(checkIn, checkOut);
			System.out.println("Reserva: " + reservation);
			}
		}

		sc.close();
	}

}
