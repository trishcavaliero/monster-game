package gameinterfaces;

public class Room {

	private int roomIndex;
	private String description;
	private Monster monster;
	
	
	public Room(int rIndex, String descript, Monster mons) {
		roomIndex = rIndex;
		description = descript;
		monster = mons;	
	}
	
	
	
	public void enter(Player player) {
		if (monster.isAlive() == true) {
			System.out.println(player.getName() + ": This room is " + this.description + " and has " + this.getMonster().getName());
			}
		
	}
	
	public boolean isComplete() {
		if(monster.isAlive() == false) {
			return true;
		}
		else {
			return false;
		}
		
	}
	
	@Override
	public java.lang.String toString(){
		return String.format("Room index %2d, description %20s, monster name %20s", this.roomIndex, this.description, this.monster.getName());
	}
	
	public Monster getMonster() {
		return this.monster;
		
	}
	
	public String getDescription() {
		return this.description;
	}
	
	
	
}
	

