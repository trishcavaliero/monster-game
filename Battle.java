package gameinterfaces;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

public class Battle {

	Player player;
	Monster monster;




	public Battle(Player player, Monster monster ) {
		this.player = player;
		this.monster = monster;
		writeToFile("Game_Log.txt", "Battle bewtween: " + player.getName() + " and " + monster.getName());




	}

	public void run(){
		//This method will let player and monster battle against each other until one of them dies. 
		System.out.println("Battle begins: " + player.getName() + " vs " + monster.getName());
		while(this.monster.isAlive() == true && this.player.isAlive() == true) {
			System.out.println(this.player.toString());
			System.out.println(this.monster.toString());
			System.out.println("Attack(a) or Heal(h): ");
			Scanner scnr = new Scanner(System.in);
			String choice = scnr.nextLine();
			choice.toLowerCase();
			char ch = choice.charAt(0);
			if (ch == 'a') { 
				player.attack(monster);
				monster.takeDamage(player.getDamage());
				writeToFile("Game_Log.txt", player.getName() + "attacks");
			}
			if (ch == 'h') {				
				player.heal();
				writeToFile("Game_Log.txt", player.getName() + "heals");
			}

			if(monster.isAlive() == true) {
				if (monster.getIsEnraged() == false) {
					if (monster.canEnrage() == true) {
						monster.enrage();
						writeToFile("Game_Log.txt", "MONSTER IS ENRAGED");
					}
				}

				monster.attack(player);	
				writeToFile("Game_Log.txt", monster.getName() + "attacks");
				player.takeDamage(monster.getDamage());

			}
		}
		if(monster.isAlive() == false) {
			System.out.println("Monster is killed");
			writeToFile("Game_Log.txt","Monster is killed");
		}	
		if(player.isAlive() == false) {
			System.out.println(player.getName() + " died :(");
			writeToFile("Game_Log.txt", player.getName() + "is killed");

		}


	}



	public void writeToFile(String filename, String info){
//		PrintWriter strOut = null;
//		try
//		{
//			strOut = new PrintWriter(filename);
//			strOut.println(info);
//		}
//		catch(FileNotFoundException e) {
//			System.out.println("Inside write to file"+ e.getMessage());
//
//		}
//		finally {
//			if (strOut != null){
//				strOut.close();
//			}
//
//		}
		try(FileWriter fw = new FileWriter("myfile.txt", true);
			    BufferedWriter bw = new BufferedWriter(fw);
			    PrintWriter out = new PrintWriter(bw))
			{
			    out.println(info);
			    
			} catch (IOException e) {
				System.out.println("Inside write to file"+ e.getMessage());
				//exception//exception handling left as an exercise for the reader
			}
		
		    //exception handling left as an exercise for the reader
		}
	}	

	

















