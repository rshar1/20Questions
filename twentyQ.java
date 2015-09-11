import java.util.Scanner;

class twentyQ{

	public static Scanner sc = new Scanner(System.in);
	public static void main(String[]args){
		node currentNode = new node();
		boolean playAgain = true;
		while(playAgain){
			System.out.println("When you've thought of an object press any button");
			sc.nextLine();
			goThrough(currentNode);
			System.out.println("Would you like to play again?");
			playAgain = sc.nextLine().equals("yes");
		}
	}

	public static void goThrough(node currentNode){
		if(currentNode.hasChildren()){
			if(currentNode.hasQuestion()){
				String a= currentNode.ask(sc);
				if(a.equals("yes")){
					goThrough(currentNode.getYes());
				}
				else{
					goThrough(currentNode.getNo());
				}
			}

			
		}
		else if(currentNode.hasObject()){
			String ans = currentNode.ask(sc);
			if(ans.equals("no")){
				System.out.println("I couldnt figure it out!! :( ");
				currentNode.makeNewNode(sc);
			}
			else if(ans.equals("yes")){
				System.out.println("I win the game");
			}
		}
		else if(!currentNode.hasObject()){
			System.out.println("I couldn't figure it out!! ");
			currentNode.makeNewNode(sc);
		}

	

	}
}