package day14;

class Name {
	String firstName;
	String lastName;

	Name(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public String toString() {
		return "[" + firstName + lastName + "]";
	}
	
	public int hashCode()
	{
		return this.firstName.hashCode() + this.lastName.hashCode();
	}
	
	public boolean equals(Object o)
	{
		boolean result = false;
		
		if(o!=null && o instanceof Name)
		{
			Name name = (Name)o;
			//if(this.firstName == name.firstName && this.lastName == name.lastName)
			if(firstName.equals(name.firstName) && lastName.equals(name.lastName))
			{
				result = true;
			}
		}
		
		return result;
		
	}
	
}
