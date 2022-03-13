class Student implements Comparable<Student> {
	int age;
	int id;
	String name;

	Student(int age, int id, String name){
		super();
		this.age = age;
		this.id = id;
		this.name = name;
	}

	// age에 대해 오름차순, age가 같으면 id에 대해 내림차순 하기
	@Override
	public int compareTo(Student s){
		return (this.age-s.age==0) ? s.id - this.id : this.age - s.age;
	}
}


