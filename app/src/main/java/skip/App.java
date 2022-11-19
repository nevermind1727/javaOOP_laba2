package skip;

class Formula {
    private float x, y, z;
    private float alpha;

    public void set(float x, float y, float z){
        this.x = x;
        this.y = y;
        this.z = z;
    }
    public void run(){
        alpha = (float) (Math.log(Math.pow(y, -Math.sqrt(Math.abs(x)))) * (x - (y / 2)) + (Math.pow(Math.sin(1), 2) * Math.atan(z)));
    }
    public void print(){
        System.out.println("For x="+x+" y="+y+ " z="+z+ " alpha()="+alpha);
    }

    public float getAlpha() {
        return alpha;
    }
}

class Main {
  public static void main(String args[]) {
//      Formula form = new Formula();
//      form.set(-15.246f, 4.642f, 20.001f);
//      form.run();
//      form.print();
    Calculator calc = new Calculator(5, 0.1f, 0.3f, 0.002f);
    calc.set(0.0034f, 0.273f, 12.45f);
    calc.calculate();
    calc.print();
  }
}

class Calculator {
    private int size;
    private float xstep, ystep, zstep;
    private float xstart, ystart, zstart;
    private float[] arr;

    public Calculator(int size, float xstep, float ystep, float zstep) {
        this.size = size;
        this.xstep = xstep;
        this.ystep = ystep;
        this.zstep = zstep;
        this.arr = new float[size];
    }

    Formula form = new Formula();

    public void set(float a, float b, float c) {
      xstart = a;
      ystart = b;
      zstart = c;
    }

    void calculate() {
        for (int i = 0; i < size; i++) {
            form.set(xstart, ystart, zstart);
            form.run();
            arr[i] = form.getAlpha();
            xstart += xstep;
            ystart += ystep;
            zstart += zstep;
        }

    }

    void print() {
        for (int i = 0; i < size; i++) {
            System.out.println(i+"F(x, y, z)="+arr[i]);
        }
    }
}
