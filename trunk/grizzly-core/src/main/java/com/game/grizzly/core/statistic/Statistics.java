package com.game.grizzly.core.statistic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.game.grizzly.core.gameplace.player.Player;
import com.game.grizzly.core.skill.serves.ServeType;

public class Statistics {
	private Map<Player, Map<TargetType, Integer>> stat = new HashMap<Player, Map<TargetType, Integer>>();
	private Map<Player, Map<ServeType, StatData>> serves = new HashMap<Player, Map<ServeType, StatData>>();

	public void registerEvent(Player player, TargetType targetType) {
		Map<TargetType, Integer> targStat = stat.get(player);
		if (null == targStat) {
			targStat = new HashMap<TargetType, Integer>();
			targStat.put(targetType, 1);
		} else {
			Integer value = targStat.get(targetType);
			if (null == value) {
				targStat.put(targetType, 1);
			} else {
				targStat.put(targetType, value + 1);
			}
		}
		stat.put(player, targStat);
	}

	public void registerServe(Player player, ServeType serveType, boolean successful) {
		Map<ServeType, StatData> serve = serves.get(player);
		if (null == serve) {
			serve = new HashMap<ServeType, StatData>();
			StatData value = new StatData();
			if (successful) {
				value.successful = 1;
			} else {
				value.unsuccessful = 1;
			}
			serve.put(serveType, value);
		} else {
			StatData value = serve.get(serveType);
			if (null == value) {
				value = new StatData();
				if (successful) {
					value.successful = 1;
				} else {
					value.unsuccessful = 1;
				}
			} else {
				if (successful) {
					value.successful += 1;
				} else {
					value.unsuccessful += 1;
				}
			}
			serve.put(serveType, value);
		}
		serves.put(player, serve);
	}

	public Map<TargetType, Integer> getStatistic(Player player) {
		return stat.get(player);
	}

	/**
	 * @return Map where key is ServeType and value is array of two elements.
	 *         First - count of successful serves, second one - unsuccessful
	 */
	public Map<ServeType, List<Integer>> getServeStatistic(Player player) {
		Map<ServeType, StatData> data = serves.get(player);
		Map<ServeType, List<Integer>> retValue = new HashMap<ServeType, List<Integer>>();
		for (Entry<ServeType, StatData> entry : data.entrySet()) {
			retValue.put(entry.getKey(), entry.getValue().getAsArray());
		}
		return retValue;
	}

	private class StatData {
		int successful;
		int unsuccessful;

		List<Integer> getAsArray() {
			List<Integer> array = new ArrayList<Integer>(2);
			array.add(successful);
			array.add(unsuccessful);
			return array;
		}
	}
}
