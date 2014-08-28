import processing.core.PApplet;

object Fractals 
{
  	def main(args: Array[String]) = {
		PApplet.main(Array[String]("Fractals"))
	}
}

class Fractals extends PApplet
{
	var lines = List()
  
	override def setup()
	{
		size(1366,768)
		recursivePattern(1366/4,768/2 - 30,350,5)
	}
	
	override def draw()
	{
		for (i <- 0 until lines.size)
		{
		    var line = lines(i)
		    //TODO: Get the line's info and display it
		}
	}
  
	class Line(var x1: Float, var x2: Float, var y1: Float, var y2: Float)
	{
		
	}
	
	def recursivePattern(x: Int, y: Int, l: Int, times: Int)
	{
		//println("yea");
		if (times <= 0) return;
		if (times % 2 == 0) 
			makeT(x,y,l);
		else
			makeX(x,y,l);
		recursivePattern((x-(l/2)),y,l/2,times-1);
		recursivePattern((x+(l/2)),y,l/2,times-1);
		recursivePattern(x,(y-(l/2)),l/2,times-1);
		recursivePattern(x,(y+(l/2)),l/2,times-1);
	}
	
	def r2() = Math.pow(2.toFloat,0.5).toFloat
	
	def makeX(x: Float, y: Float, l: Float)
	{
		lines :+ new Line( x-(l*r2()/4),y-(l*r2()/4),x+(l*r2()/4),y+(l*r2()/4) );
		lines :+ new Line( x-(l*r2()/4),y+(l*r2()/4),x+(l*r2()/4),y-(l*r2()/4) );
	}
	
	def makeT(x: Float, y: Float, l: Float)
	{
		lines :+ new Line( x-(l/2),y,x+(l/2),y );
		lines :+ new Line( x,y-(l/2),x,y+(l/2) );
	}
	
}