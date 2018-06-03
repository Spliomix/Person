package XXXX;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;
import java.util.Set;
import java.util.TreeSet;


public class PersonMain {

	public static void main(String[] args) {
		Set<Fertigkeit> s = new TreeSet<>();
		Set<Fertigkeit> ex = new TreeSet<>();
		s.add(Fertigkeit.ENGLISCH);
		Person p1 = new Person("Max","Mustermann",50,100,100,s);
		s.clear();
		s.add(Fertigkeit.JAPANISCH);
		s.add(Fertigkeit.PROGRAMMIEREN);
		ex.add(Fertigkeit.PROGRAMMIEREN);
		ex.add(Fertigkeit.ENGLISCH);

		Person p2 = new ExpertIn("Rick","Sanchez",70,180,60,s,ex);
		p2.trainieren(Fertigkeit.PROGRAMMIEREN);
		p2.trainieren(Fertigkeit.ENGLISCH);
		p1.trainieren(Fertigkeit.ENGLISCH);
		System.out.println(p1);
		System.out.println(p2);
		p1.lernen(p2, Fertigkeit.PROGRAMMIEREN);
		p1.lernen(p2, Fertigkeit.GEOGRAFIE);
		System.out.println(p1);
		System.out.println(p2);
    /* OUTPUT:
		Person [vn=Max, nn=Mustermann, age=50, sz=100, wg=100.0, map={ENGLISCH=1}]
		Person [vn=Rick, nn=Sanchez, age=70, sz=180, wg=60.0, map={PROGRAMMIEREN=3, JAPANISCH=0}]
		Person [vn=Max, nn=Mustermann, age=50, sz=100, wg=100.0, map={ENGLISCH=1, PROGRAMMIEREN=0}]
		Person [vn=Rick, nn=Sanchez, age=70, sz=180, wg=60.0, map={PROGRAMMIEREN=3, ENGLISCH=0, JAPANISCH=0}]
		*/
	}

}
