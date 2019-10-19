package gameinterfaces;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

  


public class Game {

		private Player player;
		private Room[] dungeon;
		
	
		
		//create new file to write to
		
		
		
		public void play() {
			for(int i = 0; i < dungeon.length; i++) {
				dungeon[i].enter(player);
				Battle battle = new Battle(player, dungeon[i].getMonster());
				battle.run();
				if (player.isAlive() == false) {
					System.out.print("GAME OVER");
					break;
				}
				
				writeToFile("Game_Log.txt","Middle");	
			System.out.println("");
			System.out.println("******************************");
			System.out.println("******************************");
			System.out.println("******************************");
			System.out.println("");
 
			}
			writeToFile("Game_Log.txt","END");	
			if (dungeon[2].isComplete() == true) {
				System.out.println("You explored the room and found the hidden treasure!");			
			}
		}
				
		public Game() {
		
		createNewFile("Game_Log.txt");	
		
		String name = "";
		String description = "";
		int hp = 0;
		int damage = 0;
		int heal = 0;
		
			
		//Player info input		
			Scanner input = null;
			try
			{		 
				input = new Scanner(new File("PlayerInfo.txt"));	
				name = input.nextLine();
				description = input.nextLine();
				hp = input.nextInt();
				damage = input.nextInt();
				heal = input.nextInt();
			}
			 catch(FileNotFoundException e)
			{
				 System.err.println("FILE NOT FOUND!");
				 
				 
			 }
		player = new Player(name, description, hp, damage, heal);	
//		System.out.println(player.toString());


//		declare dungeon as array of 3 rooms
		
//		create monster 1
		
		Monster monster1 = new Monster("Orc", "covered in green blood", 20, 5 ,0 );	
		Monster monster2 = new Monster("Skeleton", "funny how it moves", 40, 10 ,10 );	
		Monster monster3 = new Monster("Fire Dragon", "fire breathing", 75, 20 ,30 );	
		
		dungeon = new Room[3];
		
		
		dungeon[0] = new Room(0, "a room with an unerable smell", monster1);
		dungeon[1] = new Room(1, "dark and cold", monster2);
		dungeon[2] = new TreasureRoom("a giant hall with something shiny on the other end", monster3, "a large pile of gold");
				
		
		}
		public static void writeToFile(String filename, String info){
//			PrintWriter strOut = null;
//			try
//			{
//				strOut = new PrintWriter(filename);
//				strOut.println(info);
//			}
//			catch(FileNotFoundException e) {
//				System.out.println("Inside write to file"+ e.getMessage());
//				
//			}
//			finally {
//				if (strOut != null){
//					strOut.close();
//				}
//			
//			}
			try(FileWriter fw = new FileWriter("myfile.txt", true);
				    BufferedWriter bw = new BufferedWriter(fw);
				    PrintWriter out = new PrintWriter(bw))
				{
				    out.println(info);
				    //more code
				} 
			catch (IOException e) 
				{
					System.out.println("Inside write to file"+ e.getMessage());
					//exception handling left as an exercise for the reader
				}
			
			
		}
	
		public static File createNewFile(String fileName){
			PrintWriter outStream =null;//use the PrintWriter to create our output stream
			File directory = new File(".");
			try {
				outStream = new PrintWriter(fileName);//create & connect the output stream to the file using the String fileName
				System.out.println("Successfully created the file "+fileName);	
				
				
			} catch (FileNotFoundException e) {
				e.printStackTrace();

				System.out.println("Inside createNewFile method problem creating the file "+fileName);
			}
			finally{
				if(outStream != null){//if not closed
					outStream.close(); //close it
				}
				System.out.println("All done with createNewFile method");
			}
			
			return directory;
			 
		} 
		
		public static void main(String[] args) throws IOException {
			writeToFile("Game_Log.txt","GAME");

			Game game = new Game();
			game.play();
			
		
	}


}
