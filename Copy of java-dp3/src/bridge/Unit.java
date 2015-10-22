package bridge;

public abstract class Unit {
protected Arms arms;
protected String name;
public Unit(String name, Arms arms) {
	
	
this.name = name;
this.arms = arms;
}
public String act(){
	return name+ ":"+arms.use();
	
	
}
	
	
	
}
