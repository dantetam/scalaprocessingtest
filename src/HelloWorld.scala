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
		size(1000,1000)
		}

	override def draw() =
		{
		background(255)
		fill(0)
		rect(500,500,100,100)
		}	

	override def keyPressed() =
		{

		}

}