package model;
import java.util.Date;

//this is the member object, with almost all the fields that are in the DB.
//Any field that's not in the DB is for future implementation.
public class Member {
	private int posts;
	private int memberid;
	private String firstName;
	private String lastName;
	private String username;
	private String password;
	private String email;
	//valid is a placeholder boolean for now, since login function has not been implemented yet
	private boolean valid=true;
	private String moderator;
	private Date memSince;
	private int age;
	
	public int getAge(){
		return age;
	}
	public void setAge(int a){
		this.age=a;
	}
	public Date getMem() {
		return memSince;
	}

	public void setMem(Date d) {
		this.memSince = d;
	}

	public int getMemberid() {
		return memberid;
	}

	public int getPosts() {
		return posts;
	}

	public void setPosts(int numPosts) {
		this.posts = numPosts;
	}

	public void setMemberid(int memberid) {
		this.memberid = memberid;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	public boolean isValid(){
		return valid;
	}
	public void setValid(boolean v){
		this.valid=v;
	}

	public String isMod() {
		return moderator;
	}

	public void setMod(String newMod) {
		moderator = newMod;
	}

	@Override
	public String toString() {
		return "Member [userid=" + memberid + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", username=" + username
				+ ", password=" + password + ", email=" + email
				+ ", moderator=" + moderator + ", posts=" + posts + "]";
	}
}
