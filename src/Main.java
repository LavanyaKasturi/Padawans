import java.util.Date;
public class Main {

	public static void main(String[] args) {
		
		//You may test that your code works find here
		//Please check that your code works and has no 
		//compilation problems before to submit
		Student students[]=new Student[10];
		for(int i=0;i<10;i++)
		{
			students[i]=new Student(i,"Lav "+i,new Date(1996,07,1+i),50+i);
			
		}
		StudentGroup a=new StudentGroup(10);
		a.setStudents(students);
		Student temp=a.getStudent(2);
		System.out.println(temp.getFullName());
		System.out.println(a.getStudent(0));
		a.add(new Student(11,"Lavs "+11,new Date(1996,01,1+11),50+11),3);
		temp=a.getStudent(3);
		System.out.println(temp.getFullName());
		a.addFirst(new Student(11,"Lavi "+11,new Date(1996,02,1+11),60+11));
		System.out.println(a.getStudent(0));
		System.out.println(a.getStudent(1));
		System.out.println(a.getStudent(10));
		a.addLast(new Student(12,"Lave "+12,new Date(1996,04,1+10),63+12));
		System.out.println(a.getStudent(11));
		//System.out.println(a);
		System.out.println(a.getStudent(4));
		temp=a.getStudent(4);
		System.out.println();
		a.bubbleSort();
		a.print();
		System.out.println(temp.getFullName());
		
		a.print();
		a.remove(3);
		a.print();
		temp=a.getStudent(3);
		System.out.println(temp.getFullName());
		a.remove(a.getStudent(4));
		a.print();
System.out.println();
		a.removeFromIndex(4);
		a.print();
System.out.println();
		a.removeFromElement(new Student(0,"",new Date(0,0,0),0.0));
		a.print();
System.out.println();
		a.removeFromElement(a.getStudent(1));
		a.print();
		a.bubbleSort();
		a.print();
		Student temp1[]=a.getBetweenBirthDates(new Date(1995,07,1),new Date(2000,07,1+11));
		for(int i=0;i<temp1.length;i++)
		{
			System.out.println("Date:-"+temp1[i].toString());
		}
		System.out.println(a.getCurrentAgeByDate(4));

		//System.out.println(a.getStudent(3));
		//System.out.println(a);
		//System.out.println(a.remove(3));
		//System.out.println(a);
		
	}

}
