package com.bms.adventure.ml;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Set;
import java.util.TreeMap;

import com.bms.adventure.characters.Combatant.Status;

public class CombatAnalyzer {

	private String file = "src/main/resources/output/combat.txt";
	
	public static void main(String[] args) {
		CombatAnalyzer ca = new CombatAnalyzer();
		try {
			ca.analyze();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	private void analyze() throws Exception {
		BufferedReader reader = new BufferedReader(new FileReader(file)); 
		String s = null;
		HashMap<String, CombatStats> map = new HashMap<>();
		int cnt = 0;
		while ((s = reader.readLine()) != null) {
			cnt++;
//			System.out.println(s);
			String[] sa = s.split(":");
			for (int i=0; i<2; i++) {
				String[] pc1 = sa[i].split(",");
				String pc = pc1[0].trim();
				String stat = pc1[1].trim();
				String ac = pc1[2].trim();
				String hp = pc1[3].trim();
				CombatStats cs = calculateStats(map, pc, stat, ac, hp);
				cs.cnt = cnt;
				map.put(pc, cs);
			}
		}
		
		printMap(map);
	}
	
	private void printMap(HashMap<String, CombatStats> map) {
		String s = "%s [%s] ave AC: %4.1f, ave HP: %4.1f, #battles: %d%n";
		Set<String> keyset = map.keySet();
		for (String key: keyset) {
			CombatStats cs = map.get(key);
			String stats = getStatsString(cs);
			int acsum = cs.acsum;
			int hpsum = cs.hpsum;
			int cnt = cs.cnt;
			double ac = (double)acsum / cnt;
			double hp = (double)hpsum / cnt;
//			System.out.println(stats);
			String pc = String.format(s, key, stats, ac, hp, cnt);
			System.out.print(pc);
		}
	}
	
	private String getStatsString(CombatStats cs) {
		String s = "";
		StringBuilder stats = new StringBuilder();
		for (String key: cs.statusMap.keySet()) {
			stats.append(key).append(":").append(cs.statusMap.get(key)).append(", ");
		}
		s = stats.toString();
		return s;
	}
 	
	private CombatStats calculateStats(HashMap<String, CombatStats> map, String pc, String stat, String ac, String hp) {
		CombatStats cs = null;
		if (map.containsKey(pc)) {
			cs = map.get(pc);
		} else {
			cs = new CombatStats();
		}
		TreeMap<String, Integer> sm = cs.statusMap; 
		sm.put(stat, sm.get(stat) + 1);
		cs.acsum += Integer.valueOf(ac);
		cs.hpsum += Integer.valueOf(hp);
		return cs;
	}

	private class CombatStats {
		public CombatStats() {
			this.statusMap = new TreeMap<>();
			for (Status s: Status.values()) {
				statusMap.put(s.toString(), 0);
			}
		}
		TreeMap<String, Integer> statusMap;
		int acsum = 0;
		int hpsum = 0;
		int cnt = 0;
		
	}

}
