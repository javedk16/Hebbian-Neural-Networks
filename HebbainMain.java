import java.util.*;

/**
 * Hebbian Neural Network
 * Authors:Mandar, Madhura, Javed.
 **/
 
 
class Dataset
{
	int x,y,out;
	Dataset(int a,int b,int c)
	{
		x = a;
		y = b;
		out = c;
	}
}

class Hebbian
{
	private double w1,w2,net;
	static final double alpha = 0.7;
	Random r = new Random();
	Hebbian()
	{
		w1 = r.nextInt(10);
		w2 = r.nextInt(10);
		net = 0.0;
	} 
	public void train(ArrayList<Dataset> d)
	{
		for(Dataset i:d)
		{
			w1 = w1 + alpha*i.x*i.out;
			w2 = w2 + alpha*i.y*i.out;		
		}
		
		System.out.println("FINAL WEIGHTS AFTER TRAINING: "+w1+"  "+w2);
	}
	
	public int test(int a, int b)
	{
		net = w1*a + w2*b;
		return bipolar(net);
	}
	
	public int bipolar(double a)
	{
		if(a>=0)
		return 1;
		else 
		return -1;
	}
}

class HebbianMain
{
	
	public static void main(String args[])
	{
		int x,y,output,n;
		ArrayList<Dataset> a = new ArrayList<Dataset>();
		Scanner sc = new Scanner(System.in);
		/*System.out.println("Enter number of records in dataset:");
		n=sc.nextInt();
		
		for(int i=0;i<n;i++)
		{
			System.out.println("Enter x"+(i+1));
			x=sc.nextInt();
			System.out.println("Enter y"+(i+1));
			y=sc.nextInt();
			System.out.println("Enter output"+(i+1));
			output=sc.nextInt();
			a.add(new Dataset(x,y,output));
		} */
		
		
		a.add(new Dataset(1,1,1));
		a.add(new Dataset(1,-1,1));
		a.add(new Dataset(-1,1,1));
		a.add(new Dataset(-1,-1,-1));
		
		Hebbian h = new Hebbian();
		h.train(a);
		
		System.out.println("Enter x:");
		x=sc.nextInt();
		System.out.println("Enter y:");
		y=sc.nextInt();
		
		System.out.println("OUTPUT:"+h.test(x,y));
		
	}
}
