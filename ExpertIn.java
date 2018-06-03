package XXXX;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class ExpertIn extends Person{

	public ExpertIn(String vn, String zn,  int alter, int size, double weight, Set<Fertigkeit> s1, Set<Fertigkeit> s2) {
		super(vn, zn,alter, size, weight, s1);
		set=s2;
		// TODO Auto-generated constructor stub
	}

	Set<Fertigkeit> set = new TreeSet<>();
	@Override
	boolean trainieren(Fertigkeit f ) {
        if(map.containsKey(f)) {
            map.put(f,map.get(f)+3);
            return true;
        }
        return false;
	}
}
