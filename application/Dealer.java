package application;

class Dealer extends Player
{           public static int roll;
			String [] deck = new String[52];

	        public void ShuffleDeck(){
		    String [] suit = { "Clubs", "Diamonds", "Hearts", "Spades"}; 
		    String [] rank = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};

	    	//String [] deck = new String [suit.length * rank.length];
		
	    	for (int i = 0; i < suit.length; i++){
			    for (int j = 0; j < rank.length; j++){
				    deck [rank.length * i + j] = rank [j] + " of " + suit[i];
				    }
	    	}
	    	
	    	int N = deck.length;
	        for (int i = 0; i < N; i++){
		        int r = i + (int) (Math.random() * (N - i));
		        String t = deck[i];
		        deck[i] = deck[r];
		        deck[r] = t;}
	        }

            public String DrawCard(){
            int r = (int) (Math.random() * (52));
            String cardDrawn = deck[r];
            return cardDrawn;
            }
            
            public static int DiceRoll(){
            int roll = (int) (Math.random() * (6)+1);
            return roll;
            }
            
            public static int rouletteRoll(){
                int roll = (int) (Math.random() * (36)+1);
                return roll;
            }
}