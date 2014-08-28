import processing.core._;

object HelloWorld {

	/*def main(args: Array[String])
	{
		println("Hi")
	}*/
	def main(args: Array[String]) = {
		PApplet.main(Array[String]("HelloWorld"))
	}

}

class HelloWorld extends PApplet 
{
	override def setup() =
		{
		size(500,500)
		}

	override def draw() =
		{
		background(150,225,255)
		fill(0)
		noStroke()
		var rows, cols = 100
		for (i <- 0 until rows)
		{
			for (j <- 0 until cols)
			{
			    var widthBoxX: Float = this.width/rows;
			    var widthBoxY: Float = this.width/cols;
			    //println(i.toFloat/rows.toFloat)
			    fill(i.toFloat/rows.toFloat*(150/2)+j.toFloat/cols.toFloat*(150/2),
			        i.toFloat/rows.toFloat*(225/2)+j.toFloat/cols.toFloat*(225/2),
			        i.toFloat/rows.toFloat*(255/2)+j.toFloat/cols.toFloat*(255/2)
			        );
				rect(i*widthBoxX,j*widthBoxY,widthBoxX,widthBoxY)
			}
		}
		}	

	override def keyPressed() =
		{

		}

}