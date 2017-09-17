import java.util.Date;
import java.util.Arrays;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;

/**
 * A fix-sized array of students
 * array length should always be equal to the number of stored elements
 * after the element was removed the size of the array should be equal to the number of stored elements
 * after the element was added the size of the array should be equal to the number of stored elements
 * null elements are not allowed to be stored in the array
 * 
 * You may add new methods, fields to this class, but DO NOT RENAME any given class, interface or method
 * DO NOT PUT any classes into packages
 *
 */
public class StudentGroup implements StudentArrayOperation {

	private Student[] students;
	
	/**
	 * DO NOT remove or change this constructor, it will be used during task check
	 * @param length
	 */
	public StudentGroup(int length) {
		this.students = new Student[length];
	}

	@Override
	public Student[] getStudents() {
		// Add your implementation here

		
		return this.students;
	}

	@Override
	public void setStudents(Student[] students) {
		// Add your implementation here
		if(this.students.length==0)
		{
			throw new IllegalArgumentException();
		}
		this.students=students;
	}

	@Override
	public Student getStudent(int index) {
		// Add your implementation here
		if(index<0||index>this.students.length)
		{
			throw new IllegalArgumentException();
		}
		return this.students[index];
	}

	@Override
	public void setStudent(Student student, int index) {
		// Add your implementation here
		if(index<0||index>this.students.length)
		{
			throw new IllegalArgumentException();
		}
		this.students[index]=student;
	}

	@Override
	public void addFirst(Student student) {
		// Add your implementation here
		if(student.getFullName().compareTo("")==0)
		{
			throw new IllegalArgumentException();
		}
		Student temp[]=new Student[this.students.length +1];
		temp[0]=student;
		System.arraycopy(this.students, 0, temp, 1, this.students.length);
		this.students = Arrays.copyOf(temp, this.students.length +1);
	}

	@Override
	public void addLast(Student student) {
		// Add your implementation here
		if(student.getFullName().compareTo("")==0)
		{
			throw new IllegalArgumentException();
		}
		this.students = Arrays.copyOf(students, this.students.length +1);
		this.students[this.students.length-1]=student;
	}

	@Override
	public void add(Student student, int index) {
		// Add your implementation here
		if(index<0||index>this.students.length||student==null)
		{
			throw new IllegalArgumentException();
		}
		this.students[index]=student;
	}

	@Override
	public void remove(int index) {
		// Add your implementation here
		if(index<0||index>this.students.length)
		{
			throw new IllegalArgumentException();
		}
		Student temp[]=new Student[index];
		Student temp1[]=new Student[this.students.length-(index+1)];
		System.arraycopy(this.students, 0, temp, 0, index-1);
		System.arraycopy(this.students, index+1, temp1, 0, this.students.length-(index+1));
		System.arraycopy(temp, 0, this.students, 0, index-1);
		System.arraycopy(temp1, 0, this.students, index, this.students.length-(index+1));
		this.students = Arrays.copyOf(this.students, this.students.length-1);
		
		
	}

	@Override
	public void remove(Student student) {
		// Add your implementation here
		if(student.getFullName().compareTo("")==0)
		{
			throw new IllegalArgumentException();
		}
		int remove=0;
		for(int i=0;i<students.length;i++)
		{
			
			if(students[i].compareTo(student)==0)
			{
				Student temp[]=new Student[i];
				Student temp1[]=new Student[this.students.length-(i+1)];
				System.arraycopy(this.students, 0, temp, 0, i-1);
				System.arraycopy(this.students, i+1, temp1, 0, this.students.length-(i+1));
				System.arraycopy(temp, 0, this.students, 0, i-1);
				System.arraycopy(temp1, 0, this.students, i, this.students.length-(i+1));
				this.students = Arrays.copyOf(this.students, this.students.length-1);
				remove=1;
			}
		}
		if(remove==0)
		{
			throw new IllegalArgumentException("Student Not exist");
		}	
	}

	@Override
	public void removeFromIndex(int index) {
		// Add your implementation here
		if(index<0||index>this.students.length)
		{
			throw new IllegalArgumentException();
		}
		this.students = Arrays.copyOf(this.students, index+1);
		
	}

	@Override
	public void removeFromElement(Student student) {
		if(student.getFullName().compareTo("")==0)
		{
			throw new IllegalArgumentException();
		}
		for(int i=0;i<students.length;i++)
		{
			if(students[i].compareTo(student)==0)
			{
				this.students = Arrays.copyOf(this.students,i+1);
				break;
			}
		}
	}

	@Override
	public void removeToIndex(int index) {
		// Add your implementation here
		if(index<0||index>this.students.length)
		{
			throw new IllegalArgumentException();
		}
		Student temp[]=new Student[this.students.length-(index)];
		System.arraycopy(this.students, index+1, temp, 0, this.students.length-(index+1));
		this.students = Arrays.copyOf(temp, this.students.length-(index+1));
	}

	@Override
	public void removeToElement(Student student) {
		// Add your implementation here
		if(student.getFullName().compareTo("")==0)
		{
			throw new IllegalArgumentException();
		}
		for(int i=0;i<students.length;i++)
		{
			if(students[i].compareTo(student)==0)
			{
				Student temp[]=new Student[this.students.length-(i)];
				System.arraycopy(this.students, i+1, temp, 0, this.students.length-(i+1));
				this.students = Arrays.copyOf(temp, this.students.length-(i+1));
			}
		}
	}

	@Override
	public void bubbleSort() {
		// Add your implementation here
		for(int i=0;i<students.length;i++)
		{
			for(int j=i+1;j<students.length;j++)
			{
				if(students[i].compareTo(students[j])>0)
				{
					Student temp=students[i];
					students[i]=students[j];
					students[j]=temp;
				}

			}
		}
		
	}

	@Override
	public Student[] getByBirthDate(Date date) {
		// Add your implementation here
		Student temp[]=new Student[this.students.length];
		int length=0;
		for(int i=0;i<students.length;i++)
		{
			if(students[i].getBirthDate().compareTo(date)==0)
			{
				temp[length++]=students[i];
			}
		}
		temp = Arrays.copyOf(temp,length);
		return temp;
	}

	@Override
	public Student[] getBetweenBirthDates(Date firstDate, Date lastDate) {
		// Add your implementation here
		Student temp[]=new Student[this.students.length];
		int length=0;
		for(int i=0;i<students.length;i++)
		{
			if(students[i].getBirthDate().compareTo(firstDate)>0&&students[i].getBirthDate().compareTo(lastDate)<0)
			{
				temp[length++]=students[i];
			}
		}
		temp = Arrays.copyOf(temp,length);
		return temp;
	}

	@Override
	public Student[] getNearBirthDate(Date date, int days) {
		// Add your implementation here
		return null;
	}

	@Override
	public int getCurrentAgeByDate(int indexOfStudent) {
		return 0;
	}

	@Override
	public Student[] getStudentsByAge(int age) {
		// Add your implementation here
		return null;
	}

	@Override
	public Student[] getStudentsWithMaxAvgMark() {
		// Add your implementation here
		return null;
	}

	@Override
	public Student getNextStudent(Student student) {
		Student temp_student=null;
		for(int i=0;i<students.length;i++)
		{
			if(this.students[i].compareTo(student)==0)
			{
				temp_student=this.students[i+1];
				break;
			}
		}
		return temp_student;
	}
	public void print()
	{
		for(int i=0;i<this.students.length;i++)
		{
			System.out.println(this.students[i].toString());
		}
	}
}
