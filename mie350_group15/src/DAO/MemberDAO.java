package DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

import model.Member;
import DbUtil.DbUtil;
public class MemberDAO {
	
	
	//This is the direct access object for the Member object, making the list of operations such as insert, edit, delete, and search 
	private Connection connection;
	public MemberDAO() {
		connection = DbUtil.getConnection();
	}
	public Connection getConnection(){
		return connection;
	}
	public void addMember(Member member) {
		/**
		 * This method adds a new student to the database.
		 */
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("insert into Member(ID,LastName,FirstName,email,age,passcode,postNumber,type) values (?, ?, ?, ?, ?, ?, ?, ?)");
			// Parameters start with 1
			//this add function is flawed, change later
			preparedStatement.setInt(1, member.getMemberid());
			preparedStatement.setString(2, member.getLastName());
			preparedStatement.setString(3, member.getFirstName());
			preparedStatement.setString(4, member.getEmail());
			preparedStatement.setInt(5, member.getAge());
			preparedStatement.setString(6, member.getPassword());
			preparedStatement.setInt(7, member.getPosts());
			preparedStatement.setString(8, member.isMod());
			
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deleteMember(int memberid) {
		/**
		 * This method deletes a student from the database.
		 */
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("delete from Member where ID=?");
			// Parameters start with 1
			preparedStatement.setInt(1, memberid);
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updateMember(Member member) {
		/**
		 * This method updates a student's information into the database.
		 */
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("update Member set LastName=?, FirstName=?, email=?, age=?, passcode=?, postNumber=?, type=?"
							+ " where ID=?");
			// Parameters start with 1
			//this method might also be flawed, fix later
			preparedStatement.setInt(1, member.getMemberid());
			preparedStatement.setString(2, member.getLastName());
			preparedStatement.setString(3, member.getFirstName());
			preparedStatement.setString(4, member.getEmail());
			preparedStatement.setInt(5, member.getAge());
			preparedStatement.setString(6, member.getPassword());
			preparedStatement.setInt(7, member.getPosts());
			preparedStatement.setString(8, member.isMod());
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Member> getAllMembers() {
		/**
		 * This method returns the list of all members in the form of a List
		 * object.
		 */
		List<Member> members = new ArrayList<Member>();
		try {
			Statement statement = connection.createStatement();
			// System.out.println("getting students from table");
			ResultSet rs = statement.executeQuery("select * from Member");
			while (rs.next()) {
				Member member = new Member();
				member.setMemberid(rs.getInt("ID"));
				member.setLastName(rs.getString("LastName"));
				member.setFirstName(rs.getString("FirstName"));
				member.setEmail(rs.getString("email"));
				member.setAge(rs.getInt("age"));
				member.setPassword(rs.getString("passcode"));
				member.setPosts(rs.getInt("postNumber"));
				member.setMod(rs.getString("type"));
				members.add(member);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return members;
	}

	public Member getMemberById(int memberid) {
		/**
		 * This method retrieves a student by their StudentID number.
		 * 
		 * Currently not used in the sample web app, but code is left here for
		 * your review.
		 */
		Member member = new Member();
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("select * from Member where ID=?");
			preparedStatement.setInt(1, memberid);
			ResultSet rs = preparedStatement.executeQuery();

			if (rs.next()) {
				member.setMemberid(rs.getInt("ID"));
				member.setLastName(rs.getString("LastName"));
				member.setFirstName(rs.getString("FirstName"));
				member.setEmail(rs.getString("email"));
				member.setAge(rs.getInt("age"));
				member.setPassword(rs.getString("passcode"));
				member.setPosts(rs.getInt("postNumber"));
				member.setMod(rs.getString("type"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return member;
	}

	public List<Member> getMemberByKeyword(String keyword) {
		/**
		 * This method retrieves a list of students that matches the keyword
		 * entered by the user.
		 */
		List<Member> members = new ArrayList<Member>();
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("select * from Member where FirstName LIKE ? OR LastName LIKE ? OR email LIKE ? OR age LIKE ?");

			preparedStatement.setString(1, "%" + keyword + "%");
			preparedStatement.setString(2, "%" + keyword + "%");
			preparedStatement.setString(3, "%" + keyword + "%");
			preparedStatement.setString(4, "%" + keyword + "%");
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				Member member = new Member();
				member.setMemberid(rs.getInt("ID"));
				member.setLastName(rs.getString("LastName"));
				member.setFirstName(rs.getString("FirstName"));
				member.setEmail(rs.getString("email"));
				member.setAge(rs.getInt("age"));
				member.setPassword(rs.getString("passcode"));
				member.setPosts(rs.getInt("postNumber"));
				member.setMod(rs.getString("type"));
				members.add(member);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return members;
	}
}
