package ie.tudublin;

import processing.core.PApplet;
import processing.data.TableRow;

public class Task {

    private String task;
    private int start;
    private int end;

    public void setTask(String task)
    {
        this.task = task;
    }

    public void setStart(int start)
    {
        this.start = start;
    }

    public void setEnd(int end)
    {
        this.end = end;
    }
    
    public String getTask(String task)
    {
        return task;
    }
    public int getStart(int start)
    {
        return start;
    }

    public int getEnd(int end)
    {
        return end;
    }

    public String toString()
    {
        return task + "\t" + start + "\t" + end;
    }

    public Task(String task, int start, int end)
    {
        this.task = task;
        this.start = start;
        this.end = end;
    }

    public Task(TableRow tr)
    {
        this(tr.getString("Task"), tr.getInt("Start"), tr.getInt("End"));
    }

    public void render(PApplet pa, int i)
    {
        float border = pa.width * 0.05f;
        float leftborder = pa.width * 0.3f;

        float y = PApplet.map(i, 0, 9,border, pa.height - border);
        pa.textAlign(PApplet.CENTER, PApplet.CENTER);
        pa.fill(225);
        pa.text(task, leftborder / 2, y);
        float x = PApplet.map(start, 0, 30, pa.width - border, leftborder);
        float endWidth = PApplet.map(end, 0, 30, pa.width - border, leftborder);

        pa.stroke(255);
        pa.fill(255);
        //pa.rect(start, x - leftborder, end, 5);
        pa.rect(x, x, endWidth, 20);

    }
}