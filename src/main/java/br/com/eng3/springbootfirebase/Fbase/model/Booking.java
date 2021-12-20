package br.com.eng3.springbootfirebase.Fbase.model;
import java.util.Date;
import javax.persistence.Entity;

@Entity
public class Booking {
	private String userId;
	private String roomName;
	private Date startdate;
	private Date enddate;

	public Booking() {
		super();
	}

	public Date getStartDate() {
		return this.startdate;
	}

	public void setStartDate(Date startDate) {
		this.startdate = startDate;
	}

	public Date getEndDate() {
		return this.enddate; 
	}

	public void setEndDate(Date endDate) {
		this.enddate = endDate;
	}

	public String getRoomName() {
		return this.roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}
	
	public String getUserId() {
		return this.userId;
	}

	public Booking( String userId) {
		this.userId = userId;
	}
}