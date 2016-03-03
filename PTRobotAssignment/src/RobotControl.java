
public class RobotControl {
	   private Robot r;
	   public RobotControl(Robot r)
	   {
	       this.r = r;
	   }

	   public void control(int barHeights[], int blockHeights[])
	   {

	     // Internally the Robot object maintains the value for Robot height(h), arm-width (w) and picker-depth (d).
	     // These values are displayed for your convenience
	     // These values are initialised as h=2 w=1 and d=0
	     // When you call the methods up() or down() h will be changed	
	     // When you call the methods extend() or contract() w will be changed	
	     // When you call the methods lower() or raise() d will be changed	


	     // sample  code to get you started
	     // Try running this program with obstacle 555555 and blocks of height 123 (default)
	     // It will work move topmost block part of the way 
	     // You are free to introduce any other variables



		     int h = 2;			// Initial height of arm 1
		     int w = 1;			// Initial width of arm 2  
		     int d = 0;			// Initial depth of arm 3

		     int sourceHt = 6;		// For Parts A and B 1+2+3 = 6 
		     int targetHt1 = 0;    	// Initially empty
		     int targetHt2 = 0;    	// Initially empty
		     int targetHt3 = 0;    	// Initially empty
		     int barHt = 3;	        // height of block just picked

	         int clearence = 10;  	// this causes unnecessary moves
	                                // you should be set considering the heights of bars, source, targets and current block 
	         
	         while ( h < clearence )
	         {
	        	  r.up();
	        	  h++;
	         }
	        
	         while ( w < 10 )
	         {
	        	 r.extend();
	        	 w++;
	         }
	         
	         while ( h - d > sourceHt + 1 )
	         {
	        	 r.lower();
	        	 d++;
	         }
	         
	         r.pick();
	         int blockHt = 3;       // currently the topmost block is of height 3 
	         sourceHt -= blockHt;   // after picking source height goes down by the block height    
	         
	         while ( d > 0 )
	         {
	        	 r.raise();
	        	 d--;
	         }
	         
	         int targetWidth = 3;	// as the topmost block is of height 3 it should be dropped in column 3 
	         while ( w > targetWidth)
	         {
	        	 r.contract();
	        	 w--;
	         }

	         while ( h - d - blockHt > targetHt3 + 1 )
	         {
	        	 r.lower();
	        	 d++;
	         }
	         
	         r.drop();
	         
	   }
}
