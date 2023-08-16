package xyz.itwill10.dto;

import lombok.Builder;
import lombok.Data;

//[순서-7]
@Data
@Builder
public class RestMember {
	private String id;
	private String name;
	private String email;
}
