package com.game.grizzly.core.statistic;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.game.grizzly.core.gameplace.player.Player;
import com.game.grizzly.core.skill.serves.ServeType;
import com.game.grizzly.core.skill.strike.StrikeType;

public class Statistics {
	private Map<Player, Map<TargetType, Integer>> stat = new HashMap<Player, Map<TargetType, Integer>>();
	private Map<Player, Map<ServeType, StatData>> serves = new HashMap<Player, Map<ServeType, StatData>>();
	private Map<Player, Map<StrikeType, StatData>> strikes = new HashMap<Player, Map<StrikeType, StatData>>();

	/**
	 * General statistics functional
	 */
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

	public Map<TargetType, Integer> getStatistic(Player player) {
		return stat.get(player);
	}

	/**
	 * Serves statistics functional
	 */
	public void registerServe(Player player, ServeType serveType, boolean successful) {
		Map<ServeType, StatData> serve = serves.get(player);
		if (null == serve) {
			serve = new HashMap<ServeType, StatData>();
			StatData value = new StatData();
			if (successful) {
				value.addData(ResultType.WITH_GOAL);
			} else {
				value.addData(ResultType.WITHOUT_GOAL);
			}
			serve.put(serveType, value);
		} else {
			StatData value = serve.get(serveType);
			if (null == value) {
				value = new StatData();
				if (successful) {
					value.addData(ResultType.WITH_GOAL);
				} else {
					value.addData(ResultType.WITHOUT_GOAL);
				}
			} else {
				if (successful) {
					value.addData(ResultType.WITH_GOAL);
				} else {
					value.addData(ResultType.WITHOUT_GOAL);
				}
			}
			serve.put(serveType, value);
		}
		serves.put(player, serve);
	}

	public Map<ServeType, Map<ResultType, Integer>> getServeStatistic(Player player) {
		Map<ServeType, Map<ResultType, Integer>> result = new HashMap<ServeType, Map<ResultType, Integer>>();
		Map<ServeType, StatData> data = serves.get(player);
		for (Entry<ServeType, StatData> entry : data.entrySet()) {
			result.put(entry.getKey(), entry.getValue().getData());
		}
		return result;
	}

	/**
	 * Strikes statistics functional
	 */
	public void registerStrike(Player player, StrikeType serveType, boolean successful) {
		Map<StrikeType, StatData> strike = strikes.get(player);
		if (null == strike) {
			strike = new HashMap<StrikeType, StatData>();
			StatData value = new StatData();
			if (successful) {
				value.addData(ResultType.WITH_GOAL);
			} else {
				value.addData(ResultType.WITHOUT_GOAL);
			}
			strike.put(serveType, value);
		} else {
			StatData value = strike.get(serveType);
			if (null == value) {
				value = new StatData();
				if (successful) {
					value.addData(ResultType.WITH_GOAL);
				} else {
					value.addData(ResultType.WITHOUT_GOAL);
				}
			} else {
				if (successful) {
					value.addData(ResultType.WITH_GOAL);
				} else {
					value.addData(ResultType.WITHOUT_GOAL);
				}
			}
			strike.put(serveType, value);
		}
		strikes.put(player, strike);
	}

	public Map<StrikeType, Map<ResultType, Integer>> getStrikesStatistic(Player player) {
		Map<StrikeType, Map<ResultType, Integer>> result = new HashMap<StrikeType, Map<ResultType, Integer>>();
		Map<StrikeType, StatData> data = strikes.get(player);
		for (Entry<StrikeType, StatData> entry : data.entrySet()) {
			result.put(entry.getKey(), entry.getValue().getData());
		}
		return result;
	}

	private class StatData {
		private Map<ResultType, Integer> data = new HashMap<ResultType, Integer>();

		void addData(ResultType resultType) {
			Integer value = data.get(resultType);
			if (null == value) {
				value = 0;
			}
			data.put(resultType, ++value);
		}

		Map<ResultType, Integer> getData() {
			return data;
		}
	}

	static enum ResultType {
		WITH_GOAL, WITHOUT_GOAL;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("\n-- General statistics --\n");
		for (Player player : stat.keySet()) {
			sb.append(player.getName());
			sb.append(" - > ");
			sb.append(getStatistic(player));
			sb.append("\n");
		}
		sb.append("-- Serves statistics --\n");
		for (Player player : serves.keySet()) {
			sb.append(player.getName());
			sb.append(" - > ");
			sb.append(getServeStatistic(player));
			sb.append("\n");
		}
		sb.append("-- Strikes statistics --\n");
		for (Player player : strikes.keySet()) {
			sb.append(player.getName());
			sb.append(" - > ");
			sb.append(getStrikesStatistic(player));
			sb.append("\n");
		}
		return sb.toString();
	}
}
