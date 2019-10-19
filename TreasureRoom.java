package gameinterfaces;

public class TreasureRoom extends Room{

	private String treasure;
	
	public TreasureRoom(String descript, Monster monster, String treas) {
		super(2, descript, monster);
		treasure = treas;
	}
	
	
	
	@Override
	public void enter(Player player) {
		if(this.getMonster().isAlive() == true) {
			System.out.println("This room is " + this.getDescription() + " and has " + this.getMonster().getName());
		}
		if(this.isComplete() == true) {
			System.out.println("You explored the room and found the hidden treasure!");
		
			
		}
			
	}
	
	

}
