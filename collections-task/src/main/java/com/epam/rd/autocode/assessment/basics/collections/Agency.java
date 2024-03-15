package com.epam.rd.autocode.assessment.basics.collections;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

import com.epam.rd.autocode.assessment.basics.entity.BodyType;
import com.epam.rd.autocode.assessment.basics.entity.Client;
import com.epam.rd.autocode.assessment.basics.entity.Order;
import com.epam.rd.autocode.assessment.basics.entity.Vehicle;

public class Agency implements Find, Sort {

	private List<Vehicle> vehicles;

	private List<Order> orders;

	public Agency() {
		vehicles = new ArrayList<>();
		orders = new ArrayList<>();
	}
	public void addVehicle(Vehicle vehicle) {
		vehicles.add(vehicle);
	}

	public void addOrder(Order order) {
		orders.add(order);
	}

	@Override
	public List<Vehicle> sortByID() {
		List<Vehicle> sortedVehicles = new ArrayList<>(vehicles);

		// Using the bubble sort algorithm to sort vehicles by ID
		int n = sortedVehicles.size();
		for (int i = 0; i < n - 1; i++) {
			for (int j = 0; j < n - i - 1; j++) {
				if (sortedVehicles.get(j).getId() > sortedVehicles.get(j + 1).getId()) {
					// Swap vehicles at index j and j+1
					Vehicle temp = sortedVehicles.get(j);
					sortedVehicles.set(j, sortedVehicles.get(j + 1));
					sortedVehicles.set(j + 1, temp);
				}
			}
		}

		return sortedVehicles;
	}

	@Override
	public List<Vehicle> sortByYearOfProduction() {
		List<Vehicle> sortedVehicles = new ArrayList<>(vehicles);
		// Using the bubble sort algorithm to sort vehicles by year of production
		int n = sortedVehicles.size();
		for (int i = 0; i < n - 1; i++) {
			for (int j = 0; j < n - i - 1; j++) {
				if (sortedVehicles.get(j).getYearOfProduction() > sortedVehicles.get(j + 1).getYearOfProduction()) {
					// Swap vehicles at index j and j+1
					Vehicle temp = sortedVehicles.get(j);
					sortedVehicles.set(j, sortedVehicles.get(j + 1));
					sortedVehicles.set(j + 1, temp);
				}
			}
		}
		return sortedVehicles;
	}

	@Override
	public List<Vehicle> sortByOdometer() {
		List<Vehicle> sortedVehicles = new ArrayList<>(vehicles);
		int n = sortedVehicles.size();

		for (int i = 0; i < n - 1; i++) {
			for (int j = 0; j < n - i - 1; j++) {
				if (sortedVehicles.get(j).getOdometer() > sortedVehicles.get(j + 1).getOdometer()) {
					// Swap vehicles at index j and j+1
					Vehicle temp = sortedVehicles.get(j);
					sortedVehicles.set(j, sortedVehicles.get(j + 1));
					sortedVehicles.set(j + 1, temp);
				}
			}
		}

		return sortedVehicles;
	}

	@Override
	public Set<String> findMakers() {
		Set<String> makers = new HashSet<>();
		for (Vehicle vehicle : vehicles) {
			makers.add(vehicle.getMake());
		}
		return makers;
	}

	@Override
	public Set<BodyType> findBodytypes() {
		Set<BodyType> bodyTypes = new HashSet<>();

		for (Vehicle vehicle : vehicles) {
			bodyTypes.add(vehicle.getBodyType());
		}

		return bodyTypes;	}

	@Override
	public Map<String, List<Vehicle>> findVehicleGrouppedByMake() {
		Map<String, List<Vehicle>> groupedVehicles = new HashMap<>();
		for (Vehicle vehicle : vehicles) {
			String make = vehicle.getMake();
			List<Vehicle> makeVehicles = groupedVehicles.get(make);

			if (makeVehicles == null) {
				makeVehicles = new ArrayList<>();
				groupedVehicles.put(make, makeVehicles);
			}
			makeVehicles.add(vehicle);
		}

		return groupedVehicles;
	}

	@Override
	public List<Client> findTopClientsByPrices(List<Client> clients, int maxCount) {
		Map<Long, BigDecimal> clientTotalPriceMap = new HashMap<>();
		List<Client> topClients = new ArrayList<>();

		for (Order order : orders) {
			long clientId = order.getClientId();
			BigDecimal totalPrice = clientTotalPriceMap.getOrDefault(clientId, BigDecimal.ZERO);
			totalPrice = totalPrice.add(order.getPrice());
			clientTotalPriceMap.put(clientId, totalPrice);
		}

		List<Map.Entry<Long, BigDecimal>> sortedEntries = new ArrayList<>(clientTotalPriceMap.entrySet());
		sortedEntries.sort((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()));

		for (Map.Entry<Long, BigDecimal> entry : sortedEntries) {
			if (topClients.size() < maxCount) {
				long clientId = entry.getKey();
				for (Client client : clients) {
					if (client.getId() == clientId) {
						topClients.add(client);
						break;
					}
				}
			} else {
				break;
			}
		}

		return topClients;
	}

	@Override
	public List<Client> findClientsWithAveragePriceNoLessThan(List<Client> clients, int average) {
		Map<Client, List<Order>> clientOrders = new HashMap<>();
		List<Client> result = new ArrayList<>();

		for (Client client : clients) {
			List<Order> clientOrderList = new ArrayList<>();

			for (Order order : orders) {
				if (order.getClientId() == client.getId()) {
					clientOrderList.add(order);
				}
			}

			if (!clientOrderList.isEmpty()) {
				BigDecimal totalAmount = BigDecimal.ZERO;

				for (Order order : clientOrderList) {
					totalAmount = totalAmount.add(order.getPrice());
				}

				BigDecimal averageAmount = totalAmount.divide(BigDecimal.valueOf(clientOrderList.size()));

				if (averageAmount.compareTo(BigDecimal.valueOf(average)) >= 0) {
					result.add(client);
				}
			}
		}

		return result;
	}

	@Override
	public List<Vehicle> findMostOrderedVehicles(int maxCount) {
		Map<Long, Integer> vehicleCountMap = new HashMap<>();
		List<Vehicle> mostOrderedVehicles = new ArrayList<>();

		for (Order order : orders) {
			long vehicleId = order.getVehicleId();
			vehicleCountMap.put(vehicleId, vehicleCountMap.getOrDefault(vehicleId, 0) + 1);
		}

		for (Map.Entry<Long, Integer> entry : vehicleCountMap.entrySet()) {
			if (mostOrderedVehicles.size() < maxCount) {
				long vehicleId = entry.getKey();
				Vehicle mostOrdered = null;

				for (Vehicle vehicle : vehicles) {
					if (vehicle.getId() == vehicleId) {
						mostOrdered = vehicle;
						break;
					}
				}

				if (mostOrdered != null) {
					mostOrderedVehicles.add(mostOrdered);
				}
			} else {
				break;
			}
		}

		return mostOrderedVehicles;
	}

}