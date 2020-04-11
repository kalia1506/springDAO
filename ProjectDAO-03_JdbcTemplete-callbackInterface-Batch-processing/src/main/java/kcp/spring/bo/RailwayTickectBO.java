package kcp.spring.bo;

import lombok.Data;

@Data
public class RailwayTickectBO {
		private String passengerName;
		private int age;
		private String sourcePlace;
		private String destinationPlace;
		private double distance;
		private double ticketPrice;

}
