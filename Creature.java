package gameinterfaces;

public class Creature {
	
	private String name;
	private String description;
	private int hitPoints;		
	private int damage;
	private Room room;
		
		
	public Creature(String na, String descript, int hp, int d) {
		 name = na;
		 description = descript;
		 hitPoints = hp;
		 damage = d;
		 room = null;
	}

	public void takeDamage(int damage) {
		damage = Math.abs(damage);
		hitPoints -= damage;

	

	}
	
	public void attack(Creature monster) {
		System.out.println(this.name + " attacks " + monster.name +  " dealing " + this.damage);
	
	}
	
	public boolean isAlive() {
		if (this.hitPoints > 0) {
			return true;
		}
		else {
			return false;
		}
				
	}
	
	public int getHitPoints() {
		return this.hitPoints;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getDamage() {
		return this.damage;
	}
	
	public String getDescription() {
		return this.description;
	}
//	setters: damage & hp
	
	public void setDamage(int d) {
		this.damage = d;
	}
	
	public void setHitPoints(int hp) {
		this.hitPoints = hp;
	}
	
	public void setRoom(Room room) {
		Room currentRoom = room;
	}
	
	
	public java.lang.String toString(){
		return (String.format("%10s |  %20s | HP: %03d | Damage: %02d", this.name, this.description, this.hitPoints, this.damage));
	}
	
}
