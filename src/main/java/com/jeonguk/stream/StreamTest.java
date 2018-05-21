package com.jeonguk.stream;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.util.*;

@Slf4j
public class StreamTest {

	public static void main(String[] args) {
		final Set<String> set = new HashSet<>();
		set.add("1");
		set.add("2");
		set.add("4");
		set.add("5");

		final List<Test> list = Arrays.asList(
				new Test("1", "test1"),
				new Test("2", "test2"),
				new Test("3", "test3"),
				new Test("4", "test4"),
				new Test("5", "test5"),
				new Test("6", "test6"),
				new Test("7", "test7"));

		final List<Test> testList = new ArrayList<>();
		list.stream().forEach(f -> {
			if (set.contains(f.getIdx())) {
				log.info("111111111");
				f.setUrl("image url");
			} else {
				f.setUrl(StringUtils.EMPTY);
				log.info("222222222");
			}
			testList.add(f);
		});

		log.info("testList {} ", testList);

	}

}

@NoArgsConstructor
@AllArgsConstructor
@Data
class Test {
	private String idx;
	private String url;
}
