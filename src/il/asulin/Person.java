package il.asulin;

public class Person {

	/****************Attributes************/
	private String name;
	private int age;
	
	/*****************Constructors
	 * @throws CompanyException *******************/
	public Person(String name, int age) throws CompanyException {
		setName(name);
		setAge(age);
	}
	
	/**************Setters & Getters ******************/
	public String getName() {
		return name;
	}

	public void setName(String name) throws CompanyException {
		if(name.equals(""))
			throw new CompanyException("Empty name");
		this.name = name;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) throws CompanyException {
		if(age < 20 || age > 60)
			throw new CompanyException("Invalid Age, should be (20-60)");
		this.age = age;
	}
	
	/*******toString & HashCode & Equals **************/
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (age != other.age)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	
	
	
}
