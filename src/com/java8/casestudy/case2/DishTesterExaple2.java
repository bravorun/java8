package com.java8.casestudy.case2;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.*;


public class DishTesterExaple2 {
	
	public  DishSelectedField getDishSelectedField(Dish d){
		return new DishSelectedField(d.getName(), d.getCalories());
	}
	public static void main(String[] args) {

		List<Dish> allDishes = getAllDishes();
		// Example: return the names of dishes that are low in calories (<400) sorted by number of calories
		System.out.println("*****Low Calories < 400*****");
		List <String> lowCallories=allDishes
				.stream()
				.filter(food->food.getCalories()<400)
				.map(food->food.getName())
				.collect(Collectors.toList());
		lowCallories.forEach(System.out::println);
		// Getting all veg dishes
		System.out.println("*****All Veg Dishes*****");
		List<Dish> vegFoods=
				allDishes
				.stream()
				.filter(dishes->dishes.isVegetarian())
				.collect(Collectors.toList());
		vegFoods.forEach(System.out::println);
		
		// Get list of All Dishes only containing name and calValue
		
		// create a List by selecting the first three dishes that have more than 300 calories
		
		
		/*
		 * allMatch, anyMatch,noneMatch, findFirst, findAny
		 */

		// find out whether the menu has a vegetarian option: anyMatch
		
		// find out whether the menu ishealthy :allMatch
		// (ie. all dishes are below 1000 calories):
		
		// noneMatch: opposite of allMatch

		// find if any food item is veg? findAny
		
		// Primitive stream specializations

		// IntStream,DoubleStream, and LongStream==> avoide boxing cost

		// get all the cal values of all food items
				
		// using primitive stream
		// find max cal values for all dishes, Optional
		/*
		 * What type of quaries Collect helps:Collectors.groupingBy(..)
		 * ------------------------------------- 
		 * 1. Dishes grouped by type 
		 * 2. Dishes grouped by caloric level 
		 * 3. Dishes grouped by type and then caloric level 
		 * 4. Count dishes in each groups 
		 * 5. Most caloric dishes by type 
		 * 6. Sum calories by type
		 */

		// Dishes grouped by type
		
		// Dishes grouped by calorific level
		/*
		 * if (dish.getCalories() <= 400)
				return CaloricLevel.DIET;
			else if (dish.getCalories() <= 700)
				return CaloricLevel.NORMAL;
			else
				return CaloricLevel.FAT;
		 * 
		 */

		// Dishes grouped by type and then caloric level
		allDishes.stream().collect(Collectors.groupingBy((Dish dish)-> {
				if (dish.getCalories() <= 400)
					return CaloricLevel.DIET;
				else if (dish.getCalories() <= 700)
					return CaloricLevel.NORMAL;
				else
					return CaloricLevel.FAT;
			
		}));
		
	}

	

	private static List<Dish> getAllDishes() {
		List<Dish> disheds = Arrays.asList(new Dish("pork", false, 800,
				Dish.Type.MEAT), new Dish("beef", false, 700, Dish.Type.MEAT),
				new Dish("chicken", false, 400, Dish.Type.MEAT), new Dish(
						"french fries", true, 530, Dish.Type.OTHER), new Dish(
						"rice", true, 350, Dish.Type.OTHER), new Dish(
						"season fruit", true, 120, Dish.Type.OTHER), new Dish(
						"pizza", true, 550, Dish.Type.OTHER), new Dish(
						"prawns", false, 300, Dish.Type.FISH), new Dish(
						"salmon", false, 450, Dish.Type.FISH));
		return disheds;
	}

}
