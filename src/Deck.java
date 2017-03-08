
import java.util.Random;

public class Deck 
{
	private Card[] theCards;
	
	
	public Deck()
	{
		this.theCards = new Card[52];
		String[] suits = {"H","D","C","S"};
		String[] displayNames = {"2","3","4","5","6","7","8","9","10","J","Q","K","A"};
		int[] values = {2,3,4,5,6,7,8,9,10,10,10,10,11};
		int pos = 0;
		for(int i = 0; i < suits.length; i++)
		{
			for(int j = 0; j < displayNames.length; j++)
			{
				this.theCards[pos] = new Card(displayNames[j], suits[i], values[j]);
				pos++;
			}
		}
	}
	
	public void shuffle()
	{
		Random r = new Random();
		int pos1;
		int pos2;
		Card temp;
		for(int i = 0; i < 5000; i++)
		{
			pos1 = r.nextInt(this.theCards.length);
			pos2 = r.nextInt(this.theCards.length);
			temp = this.theCards[pos1];
			
			this.theCards[pos1] = this.theCards[pos2];
			this.theCards[pos2] = temp;
	
		}
	}

	public void playersHand()
	{
		Random r = new Random();
		int x,y;
		
		int[] num = new int[100];
		for(int i=0;i<=99;i++)
		{
			num[i]=-1;
		}
		num[0] = r.nextInt(this.theCards.length);
		num[1] = r.nextInt(this.theCards.length);
		x=this.theCards[num[0]].getCardValue();
		this.theCards[num[0]].display();
		y=this.theCards[num[1]].getCardValue();
		this.theCards[num[1]].display();
		int playersTotal = x + y;
		System.out.println(playersTotal);
		for (int i=2; ; i++ )
		{
		
			if(playersTotal < 21)
			{
			num[i] = r.nextInt(this.theCards.length);
			this.theCards[num[i]].display();
			//x=this.theCards[num[i]].getCardValue();
			//int k = num.length;
			playersTotal = 0;
			for(int j=0;j<=99;j++)
			{
				
				if(num[j]!=-1)
				{
					int d = this.theCards[num[j]].getCardValue();
					System.out.println("pick" + j+ "(" +d+ ")");
				
					playersTotal = playersTotal + this.theCards[num[j]].getCardValue();	
				}
			}
			System.out.println(playersTotal);
			}
			if (playersTotal> 21)
			{
				for(int j=0;j<100 ; j++)
				{
					if(num[j]!=-1)
					{
					int cardValue=this.theCards[num[j]].getCardValue();
					if(cardValue == 11)
					{
						this.theCards[num[j]].display();
						this.theCards[num[j]].setCardValue();
						this.theCards[num[j]].display();
						playersTotal = 0;
						for(j=0;j<=99;j++)
						{
							if(num[j]!=-1)
							{
							int d = this.theCards[num[j]].getCardValue();
							System.out.println("newpick" + j+ "(" +d+ ")");
							
							playersTotal = playersTotal + this.theCards[num[j]].getCardValue();	
							System.out.println(playersTotal);
							}
						
						}
						
						
						
					}
					
				
					}
					
				}
				if (playersTotal> 21)
				{
					System.out.println("player loses");
					return;
				}
				
				
			}

			if(playersTotal==21)
			{
				System.out.println("WINNER");
				return;
			}
				
		}
		}
	
	public void display()
	{
		for(int i = 0; i < this.theCards.length; i++)
		{
			
			//this.theCards[i].display();
		}
	}
}
