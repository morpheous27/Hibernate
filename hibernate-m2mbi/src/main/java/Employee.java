import java.util.Set;

public class Employee {

	int id;
	String name;
	Set<Address> set;

	public Set<Address> getSet() {
		return set;
	}

	public void setSet(Set<Address> set) {
		this.set = set;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
