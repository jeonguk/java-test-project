package com.jeonguk;

import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;

@Slf4j
public class EnumTest {

	public static void main(String[] args) {
		final ImageInfo appCardImage = Arrays.stream(ImageInfo.values())
			.filter(f -> StringUtils.equals(f.getTyCd(), "AAA"))
			.findFirst()
			.orElseThrow(RuntimeException::new);

		final EnumTest.Images images = Images.builder().imgUrl_l(appCardImage.getImgUrl_l()).imgUrl_m(appCardImage.getImgUrl_m()).imgUrl_s(appCardImage.getImgUrl_s()).build();

		log.info("ImageInfo.values() {}", images);
	}


	@Builder
	@Data
	@NoArgsConstructor
	@AllArgsConstructor
	private static class Images {
		private String imgUrl_l;
		private String imgUrl_m;
		private String imgUrl_s;
	}
}

@Getter
enum ImageInfo {

	AAA("AAA", "AAA_l.png", "AAA_m.png", "AAA_s.png"),
	BBB("BBB", "BBB_l.png", "BBB_m.png", "BBB_s.png");

	private String tyCd;
	private String imgUrl_l;
	private String imgUrl_m;
	private String imgUrl_s;

	ImageInfo(String tyCd, String imgUrl_l, String imgUrl_m, String imgUrl_s) {
		this.tyCd = tyCd;
		this.imgUrl_l = imgUrl_l;
		this.imgUrl_m = imgUrl_m;
		this.imgUrl_s = imgUrl_s;
	}

}