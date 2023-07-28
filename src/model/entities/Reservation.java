package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import model.exceptions.DomainException;

public class Reservation {

	private Integer roomNumber ;
	private Date checkIn ;
	private Date checkOut;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Reservation(Integer roomNumber, Date checkIn, Date checkOut)  {
		if  (!checkOut.after(checkIn)) {
			throw new DomainException(" A Data de Saída deve ser posterior a Data de Entrada:");
		}
		
		this.roomNumber = roomNumber;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}
	public Integer getRoomNumber() {
		return roomNumber;
	}
	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}
	public Date getCheckIn() {
		return checkIn;
	}
	
	public Date getCheckOut() {
		return checkOut;
	}
	
	public long duration() {
		long diff = checkOut.getTime() - checkIn.getTime();
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}
	public void updateDates(Date checkIn, Date checkOut) {
		Date now = new Date();
		if (checkIn.before(now) || checkOut.before(now)){
			throw new DomainException("As Datas para atualização deve ser datas futuras:") ;
		}
		if  (!checkOut.after(checkIn)) {
			throw new DomainException(" A data de Saída deve ser posterior a data de Entrada:");
		}
		this.checkIn = checkIn;
		this.checkOut = checkOut;

	}
	
	@Override
	public String toString() {
		return "Quarto: "
			+ roomNumber
			+ ", Entrada: "
			+ sdf.format(checkIn)
			+ ", Saída: "
			+ sdf.format(checkOut)
			+ ", "
			+ duration()
			+ " Noites";
			
	}
}
