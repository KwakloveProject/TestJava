package kn.edu.seiralizable;

import java.io.Serializable;
import java.util.Objects;

public class User implements Comparable<User>, Serializable
{
	private String name;
	private String password;
	private String email;
	private int age;
	
	public User(String name, String password, String email, int age) 
	{
		super();
		this.name = name;
		this.password = password;
		this.email = email;
		this.age = age;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name) 
	{
		this.name = name;
	}

	public String getPassword() 
	{
		return password;
	}

	public void setPassword(String password) 
	{
		this.password = password;
	}

	public String getEmail() 
	{
		return email;
	}

	public void setEmail(String email) 
	{
		this.email = email;
	}

	public int getAge() 
	{
		return age;
	}

	public void setAge(int age) 
	{
		this.age = age;
	}

	@Override
	public int hashCode() {
		return Objects.hash(email);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User user = null;
		if(obj instanceof User) 
		{
			user = (User) obj;
		}
			return this.email.equals( user.email);
	}

	@Override
	public int compareTo(User o) 
	{
		return this.name.compareTo(o.name);
	}

	@Override
	public String toString() {
		return "이름=" + name + ", 비밀번호=" + password + ", 이메일=" + email + ", 나이=" + age ;
	}

}
