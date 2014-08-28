import processing.core.PApplet;

object Fractals 
{
  	def main(args: Array[String]) = {
		PApplet.main(Array[String]("Fractals"))
	}
}

class Fractals extends PApplet
{
	var lines = List[Line]()
	
	override def setup()
	{
		size(1500,900)
		recursivePattern(width/2,height/2,450,6)
	}
	
	override def draw()
	{
		background(255)
		for (i <- 0 until lines.size)
		{
		    //println(i)
		    var line = lines(i)
		    //TODO: Get the line's info and display it
		    //println(line.x1)
			super.line(line.x1, line.y1, line.x2, line.y2)
		}
	}
  
	class Line(var a: Float, var b: Float, var c: Float, var d: Float)
	{
		var x1 = a
		var y1 = b
		var x2 = c
		var y2 = d
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
		lines = lines :+ new Line( x-(l*r2()/4),y-(l*r2()/4),x+(l*r2()/4),y+(l*r2()/4) );
		lines = lines :+ new Line( x-(l*r2()/4),y+(l*r2()/4),x+(l*r2()/4),y-(l*r2()/4) );
	}
	
	def makeT(x: Float, y: Float, l: Float)
	{
		lines = lines :+ new Line( x-(l/2),y,x+(l/2),y );
		lines = lines :+ new Line( x,y-(l/2),x,y+(l/2) );
	}
	
}