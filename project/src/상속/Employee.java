package 상속;

public class Employee extends Person{
	int salary;
	String dept;
	
	Employee(){
		
	}

	public Employee(String name, int age, double height, double weight, int salary, String dept) {
		super(age, height, weight);
		super.name = name;
		// this.name = name; 과 같다
		this.salary = salary;
		this.dept = dept;
	}
	

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}
	
	@Override
	public String information() {
		return super.information()+" "+getSalary()+" "+getDept();
		// super.information(): getName()+" "+getAge()+" "+getHeight()+" "+getWeight()
	}
	
}
