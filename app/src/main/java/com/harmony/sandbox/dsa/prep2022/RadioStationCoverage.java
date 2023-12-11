package com.harmony.sandbox.dsa.prep2022;

import java.util.Set;
import java.util.HashSet;
import java.util.Map;
import java.util.List;

class RadioStationCoverage {
	Set<String> getRadioCoverage(Set<String> desiredStates, Map<String, Set<String>> radioStateCoverage) {
		Set<String> foundStations = new HashSet<>();
		while (Boolean.FALSE.equals(desiredStates.isEmpty())) {
			int covered = Integer.MAX_VALUE;
			String chosenStation = null;
			for (String station: radioStateCoverage.keySet()) {
				if (Boolean.FALSE.equals(foundStations.contains(station))) {
					Set<String> tempDesiredStates = new HashSet<>();
					tempDesiredStates.addAll(desiredStates);
					tempDesiredStates.removeAll(radioStateCoverage.get(station));
					if (tempDesiredStates.size() < covered) {
						covered = tempDesiredStates.size();
						chosenStation = station;
					}
				}
			}
			foundStations.add(chosenStation);
			desiredStates.removeAll(radioStateCoverage.get(chosenStation));
		}
		return foundStations;
	}

	public static void main (String[] args) {
		Set<String> desiredStates = new HashSet<>();
		desiredStates.addAll(List.of("mt", "wa", "or", "id", "nv", "ut", "ca", "az"));
		Map<String, Set<String>> radioStateCoverage = Map.of(
			"kone", Set.of("id", "nv", "ut"),
			"ktwo", Set.of("wa", "id", "mt"),
			"kthree", Set.of("or", "nv", "ca"),
			"kfour", Set.of("nv", "ut"),
			"kfive", Set.of("ca", "az")
		);
		RadioStationCoverage rcs = new RadioStationCoverage();
		
		System.out.println(rcs.getRadioCoverage(desiredStates, radioStateCoverage));
	}
}