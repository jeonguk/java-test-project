package com.jeonguk.enummap;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.EnumMap;
import java.util.Map;

@Slf4j
public class EnumMapMain {

	enum Days {
		SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY
	}

	enum Status {
		ACTIVE, INACTIVE
	}

	public static void main(String[] args) {
		final EnumMap<Days, String> enumMap = new EnumMap<>(Days.class);
		enumMap.put(Days.SUNDAY, "Its Sunday!!");
		enumMap.put(Days.MONDAY, "Its Monday!!");
		enumMap.put(Days.TUESDAY, "Its Tuesday!!");
		enumMap.put(Days.WEDNESDAY, "Its Wednesday!!");
		enumMap.put(Days.THURSDAY, "Its Thursday!!");
		enumMap.put(Days.FRIDAY, "Its Friday!!");
		enumMap.put(Days.SATURDAY, "Its Saturday!!");

		for (final Map.Entry<Days, String> entry : enumMap.entrySet()) {
			log.info(" Key -> {}", entry.getKey().SUNDAY);
			log.info(" Key -> {}", entry.getKey());
			log.info(" Value -> {}", entry.getValue());
		}

		final EnumMap<Status, Project> projectEnumMap = new EnumMap<>(Status.class);
		projectEnumMap.put(Status.ACTIVE, new Project(100, "Customer Management System", "Customer Management System"));
		projectEnumMap.put(Status.INACTIVE,
			new Project(200, "Employee Management System", "Employee Management System"));

		for (final  Map.Entry<Status, Project> entry : projectEnumMap.entrySet()) {
			final Status projectStatus = entry.getKey();
			log.info(" Key -> {}", projectStatus.name());
			final Project project = entry.getValue();
			log.info(" Value -> {}", project.toString());
		}
	}
}

@Data
@NoArgsConstructor
@AllArgsConstructor
class Project {
	private int id;
	private String name;
	private String desc;
}