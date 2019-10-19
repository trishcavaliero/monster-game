package gameinterfaces;

public class Player extends Creature {

	private int healAmount;
	
	public Player(String na, String descript, int hp, int d, int heal) {
		super(na,descript,hp,  d);
		healAmount = heal;
		

	}
	
	public int getHealAmount() {
		return this.healAmount;
	}
	
	public void heal() {
		this.setHitPoints(this.getHitPoints() + this.healAmount);
		System.out.println(this.getName() + "is healed by" + this.healAmount);
	}

}
