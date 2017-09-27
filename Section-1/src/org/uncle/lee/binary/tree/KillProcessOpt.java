package org.uncle.lee.binary.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.uncle.lee.log.LogUtils;

public class KillProcessOpt {
	private static final String TAG = "KillProcessOpt";
	
	public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
		Map<Integer, List<Integer>> map = new HashMap<>();
		
		for (int index = 0; index < pid.size(); index++) {
			if (map.containsKey(ppid.get(index))) {
				map.get(ppid.get(index)).add(pid.get(index));
			} else {
				List<Integer> numList = new ArrayList<>();
				numList.add(pid.get(index));
				map.put(ppid.get(index), numList);
			}
		}
		
		List<Integer> res = new ArrayList<>();
		getKillInteger(res, kill, map);
		return res;
	}

	private void getKillInteger(List<Integer> res, int kill, Map<Integer, List<Integer>> map) {
		res.add(kill);
		if (map.get(kill) != null) {
			for (Integer num : map.get(kill)) {
				getKillInteger(res, num, map);
			}
		}
	}
	
	public static void main(String[] args) {
		List<Integer> pid = new ArrayList<>();
		pid.add(1);
		pid.add(3);
		pid.add(10);
		pid.add(5);
		List<Integer> ppid = new ArrayList<>();
		ppid.add(3);
		ppid.add(0);
		ppid.add(5);
		ppid.add(3);
		KillProcessOpt killProcess = new KillProcessOpt();
		LogUtils.d(TAG, killProcess.killProcess(pid, ppid, 5));
	}
}
