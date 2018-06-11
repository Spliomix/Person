package XXXX;


import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.*;

public class Person implements Comparable<Person>  {
	public Person(String vn, String zn, int alter, int size, double weight, Set<Fertigkeit> s) {
		super();
		//Throw bei leeren strings undso....
		if(alter>100 || alter <10)
			throw new IllegalArgumentException("Alter zu niedring oder zu hoch");
		if(size>250 || size <100)
			throw new IllegalArgumentException("Größe zu niedring oder zu hoch");
		if(weight>300 || weight <20)
			throw new IllegalArgumentException("Alter zu niedring oder zu hoch");
		if(vn.isEmpty() || zn.isEmpty() || vn == null || zn==null)
			throw new IllegalArgumentException("Name ist leer");

		//TreeSet<Fertigkeit> newSet = new TreeSet<Fertigkeit>(s);
		map=new HashMap<Fertigkeit, Integer>();
		Fertigkeit[] f=s.toArray(new Fertigkeit[s.size()]);
		for (int i=0;i<s.size();i++)
			map.put(f[i],0);

		this.vn = vn;
		this.zn = zn;
		this.alter = alter;
		this.size = size;
		this.weight = weight;
	}

	public Person(String vn, String zn, Set<Fertigkeit> s) {
		super();
		map=new HashMap<Fertigkeit, Integer>();
		Fertigkeit[] f=s.toArray(new Fertigkeit[s.size()]);
		for (int i=0;i<s.size();i++)
			map.put(f[i],0);
		this.vn = vn;
		this.zn = zn;
		this.alter = 25;
		this.size = 170;
		this.weight = 70;
	}
	
	
	private Map<Fertigkeit, Integer> map;
	private String vn;
	private String zn;
	private int alter;
	private int size;
	double weight;
	
	
	public Map<Fertigkeit, Integer> getMap(){
		return map;
	};
	
	boolean knwoFertigkeit(Fertigkeit f) {
		if(map.containsKey(f))return true;
		return false;
	}
	
	void erlernen(Fertigkeit f) {
		map.put(f, 0);
	}
	
	boolean aelterAls(Person person) {
		if(this.alter>person.getAlter())
			return true;
		return false;
	}
	
	boolean groesserAls(Person person) {
		if(this.size>person.getSize())
			return true;
		return false;
	}
	
	boolean schwererAls(Person person) {
		if(this.weight>person.getWeight())
			return true;
		return false;		
	}
	
	boolean lernen(Person p,Fertigkeit f) {
		if(map.containsKey(f))return false;
		for(Fertigkeit a : map.keySet()) {
			if(!p.knwoFertigkeit(a)) {
				p.erlernen(a);
				this.erlernen(f);
				return true;
			}
		}return false;
	}
	
	boolean trainieren(Fertigkeit f ) {
		if(map.containsKey(f)) {
			map.put(f,map.get(f)+1);
			return true;
		}
		return false;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Person person = (Person) o;
		return alter == person.alter;
	}

	@Override
	public int hashCode() {
		return Objects.hash(alter);
	}

	public String getVn() {
		return vn;
	}
	public String getZn() {
		return zn;
	}
	public int getAlter() {
		return alter;
	}
	public double getSize() {
		return size;
	}
	public double getWeight() {
		return weight;
	}



	@Override
	public String toString() {
		return "Person [vn=" + vn + ", zn=" + zn + ", alter=" + alter + ", size=" + size + ", weight=" + weight + ", map="+map+ "]";
	}

	@Override
	public int compareTo(Person o) {
		// TODO Auto-generated method stub
			return alter-o.alter;
	}
	
	

	public int compareSize(Person o) {	
			return size-o.size;
	}

	
	public int getBonus() {
		int bonus=0;
		for(Fertigkeit a : map.keySet()) {
			bonus=bonus+a.getBonus(map.get(a));
		}
		return bonus;
	}
	
	
}
	
	
	
	
	
	
