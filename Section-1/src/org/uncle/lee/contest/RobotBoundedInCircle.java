package org.uncle.lee.contest;

public class RobotBoundedInCircle {
	public boolean isRobotBounded(String instructions) {
		int[] init = {0, 0};
		String doubleinstructions = instructions + instructions;
		String fourTimeinstructions = doubleinstructions + doubleinstructions;
		if (isInit(getPosition(init, instructions))){
			return true;
		}
		resetInit(init);
		if (isInit(getPosition(init, doubleinstructions))) {
			return true;
		}
		resetInit(init);
		if (isInit(getPosition(init, fourTimeinstructions))) {
			return true;
		}
		return false;
	}
	
	private void resetInit(int[] init) {
		init[0] = 0;
		init[1] = 0;
	}

	private boolean isInit(int[] position) {
		if (position[0] == 0 && position[1] == 0) {
			return true;
		}
		return false;
	}

	private int[] getPosition(int[] init, String instructions) {
		char[] instrcutionList = instructions.toCharArray();
		Degrees current = Degrees.N;
		
		for (char instrcution : instrcutionList) {
			if (instrcution == 'L' || instrcution == 'R') {
				current = getDegrees(current, instrcution);
			} else {
				handleG(init, current);
			}
		}
		return init;
	}
	
	private Degrees getDegrees(Degrees current, char instrcution) {
		Degrees res = current;
		switch (current) {
			case N:
				res = (instrcution == 'L') ? Degrees.W : Degrees.E;
				break;
			case S:
				res = (instrcution == 'L') ? Degrees.E : Degrees.W;
				break;
			case W:
				res = (instrcution == 'L') ? Degrees.S : Degrees.N;
				break;
			case E:
				res = (instrcution == 'L') ? Degrees.N : Degrees.S;
				break;
		}
		return res;
	}
	
	private void handleG(int[] init, Degrees current) {
		switch (current) {
			case N:
				init[1]++;
				break;
			case S:
				init[1]--;
				break;
			case W:
				init[0]--;
				break;
			case E:
				init[0]++;
				break;
		}
	}

	private enum Degrees {
		N, S, W, E
	}
	
	public static void main(String[] args) {
		RobotBoundedInCircle rb = new RobotBoundedInCircle();
		System.out.println(rb.isRobotBounded("GGLLGG"));
		System.out.println(rb.isRobotBounded("GG"));
		System.out.println(rb.isRobotBounded("GL"));
	}
}
