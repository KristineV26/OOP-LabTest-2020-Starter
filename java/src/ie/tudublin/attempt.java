package ie.tudublin;

import processing.core.PApplet;

public class attempt extends PApplet{
    public void settings()
    {
        size(800, 600);
    }

    public void setup()
    {

    }
    
    public void draw()
	{
		background(0);
		float border = width * 0.05f;
		float leftborder = height * 0.3f;
		//to draw horizontal lines of the range from 1 to 30
		stroke(255);
		textAlign(CENTER, CENTER);

		for(int i = 1; i <= 30; i++)
		{
			float x = map(i, 1, 30, leftborder, width - border);
			line(x, border, x, height - border);

			fill(255);
			text(i, x, border / 2);
		}
		
		rect(0, 0, 100, 100);
	}
}