package com.harmony.sandbox.dsa.legacy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

class Knapsack {
	List<Item> bestFit(List<Item> items, List<Integer> capacities) {
		GridItem[][] grid = new GridItem[items.size()][capacities.size()];
		for (int row = 0; row < items.size(); row++) {
			for (int col = 0; col < capacities.size(); col++) {
				// for each row and col
				// initialise prev grid item, current items
				GridItem prevGridItem = null;
				List<Item> currentItems = new ArrayList<>();
				// get current item
				Item currentItem = items.get(row);
				
				// if a previous row exists, extract prev item, and filler items if capacity exists
				if (row > 0) {
					prevGridItem = grid[row - 1][col];
					//System.out.println(String.format("current item: %s", currentItem));
					// we have to exclude the first column because they have no cell in previous row to fill up spare capacity
					if (currentItem.weight() < capacities.get(col) && col > 0) {
						int spareCapacity = capacities.get(col) - currentItem.weight();
						// System.out.println(String.format("spare capacity: %s", spareCapacity));
						// minus one since the grid indexing is zero based
						List<Item> fillingItems = grid[row - 1][spareCapacity - 1].items();
						/*System.out.println(String.format("row, col: %s, %s", row, col));
						System.out.println(String.format("filling items, spare capacity: %s", fillingItems));*/
						currentItems.addAll(fillingItems);
						currentItems.add(currentItem);
					} else if (currentItem.weight() == capacities.get(col)) {
						currentItems.add(currentItem);
					}
				} else if (currentItem.weight() <= capacities.get(col)) {
					currentItems.add(currentItem);
				};
				
				
				GridItem currentGridItem = new GridItem(currentItems);
				// if no previous item, or current more valuable than previous, use current
				if (Objects.isNull(prevGridItem) || currentGridItem.totalCost() > prevGridItem.totalCost()) {
					grid[row][col] = currentGridItem;
				} else {
					grid[row][col] = prevGridItem;
				}
			}
		}
		for (GridItem[] row: grid) {
			System.out.println(Arrays.asList(row));
		}
		
		return grid[items.size() - 1][capacities.size() - 1].items();
	}
	
	public static void main(String[] args) {
		Knapsack ks = new Knapsack();
		List<Item> items = List.of(new Item("stereo",  3000, 4), new Item("laptop", 2000, 3), 
			new Item("guitar", 1500, 1), new Item("iphone", 2000, 1), new Item("mp3", 1000, 1));
		List<Integer> capacities = List.of(1, 2, 3, 4);
		System.out.println(ks.bestFit(items, capacities));
	}
	
	record Item(String name, Integer cost, Integer weight) {}
	
	record GridItem(List<Item> items) {
		int totalCost() {
			return items.stream().map(item -> item.cost()).reduce(0, Integer::sum);
		}
	}
}