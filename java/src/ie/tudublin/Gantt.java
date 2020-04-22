package ie.tudublin;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.data.Table;
import processing.data.TableRow;

public class Gantt extends PApplet
{
	ArrayList<Task> task = new ArrayList<Task>();
	ArrayList<Task> tasklist = new ArrayList<Task>();
	Task ct = null;
	
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

	float x1, x2, y1, y2;
	
	public void mousePressed()
	{
		println("Mouse pressed");
		x1 = mouseX;
		x2 = mouseY;
	}

	public void mouseDragged(int end, int start)
	{
		println("Mouse dragged");
		float x2 = pmouseX;
		float y2 = pmouseY;

		x1 = (int) map(x1, 0, width, 1, 30);
		x2 = (int) map(x2, 0, width, 1, 30);

		float x3 = x2 - x1;
		//float y3 = y2 - y1;

		if(end != 0)
		{
			int newEnd = end + (int)x3;
			ct.setEnd(newEnd);
		}

		if(start != 0)
		{
			int newStart = start + (int)x3;
			ct.setStart(newStart);
		}
		
	}

	public int getTask()
	{
		int end;
		int start;

		for(Task ct : tasklist)
		{
			start = ct.getStart();
			end = ct.getEnd();

			start = (int) map(start, 1, 30, 0, width);
			end = (int) map(end, 1, 30, 0, width);	


			if (mouseX >= start && mouseX <=  start - 20 && mouseY >= start && mouseY <=  start - 20)
			{
				return start;
			}
			if(mouseX <= end && mouseX >=  end - 20 && mouseY <= end && mouseY >=  end - 20)
			{
				return end;
			}
		}
		return -1;

	}

	
	public void draw()
	{			
		background(0);
		colorMode(HSB);
		displayTask();
		insertTask();
	}

}
