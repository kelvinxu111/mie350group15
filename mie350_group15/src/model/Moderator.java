package model;
import java.util.Date;

//this creates the moderator object that is intended to administer normal members
public class Moderator extends Member{
	private Date modSince;
	private int usersBanned;
	
	public int getBanned(){
		return usersBanned;
	}
	public void setusersBanned(int b){
		this.usersBanned=b;
	}
	public Date getMsince(){
		return modSince;
	}
	public void setMsince(Date d){
		this.modSince=d;
	}
}
