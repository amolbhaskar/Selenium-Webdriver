package Day11;

class Machine {
	public void start() {
		System.out.println("machine started");
	}
}

class Camera extends Machine{
	public void start(){
		System.out.println("camera started");
	}
	
	public void snap(){
		System.out.println("snap taken");
	}
}
public class Casting {

	public static void main(String[] args) {
		
		Machine machine1 = new Machine();
		Camera camera1 = new Camera();
		
		machine1.start();
		camera1.snap();
		camera1.start();
		
		System.out.println("======================");
		
		//upcasting
		Machine machine2 = camera1;  //or new Camera();
		machine2.start();
		
		System.out.println("======================");
		
		//downcasting
		Machine machine3 = new Camera();
		Camera camera2 = (Camera)machine3;
		camera2.snap();
		camera2.start();
	}

}
