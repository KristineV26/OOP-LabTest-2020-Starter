package ie.tudublin;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.data.Table;
import processing.data.TableRow;

public class Gantt extends PApplet
{
	ArrayList<Task> task = new ArrayList<Task>();
	ArrayList<Task> tasklist = new ArrayList<Task>();
	
	public void settings()
	{
		size(800, 600);
	}

	public void loadTasks()
	{
		Table t = loadTable("tasks.csv", "header");
		for(TableRow tr:t.rows())
		{
			Task k = new Task(tr);
			task.add(k);
		}
	}

	public void printTasks()
	{
		for(Task k:task)
		{
			println(k);
		}
	}

	public void setup() 
	{
		loadTasks();
		printTasks();
	}

	public void insertTask()
	{
		int i = 0;
		for(Task k: task)
		{
			k.render(this, i);
			i++;
		}
	}

	public void displayTask()
	{
		float border = width * 0.05f;
		float leftborder = width * 0.3f;
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
		

	}
	
	public void mousePressed()
	{
		println("Mouse pressed");	
	}

	public void mouseDragged()
	{
		println("Mouse dragged");
	}

	
	public void draw()
	{			
		background(0);
		colorMode(HSB);
		displayTask();
		insertTask();
	}

}
