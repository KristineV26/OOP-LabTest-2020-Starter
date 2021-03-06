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
    
    public String getTask()
    {
        return task;
    }
    public int getStart()
    {
        return start;
    }

    public int getEnd()
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
        float x = PApplet.map(start, 1, 30, leftborder, pa.width - border);
        float width = PApplet.map(end, 1, 30, leftborder, pa.width - border);

        pa.fill(PApplet.map(i, 0, 9, 0, 255), 255, 255);
        pa.noStroke();
        pa.rect(x, y, width - x, 20);

    }
}