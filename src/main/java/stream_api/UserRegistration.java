package stream_api;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserRegistration implements Serializable{

	private static final long serialVersionUID = 1293337135503757716L;

	private Long userId;
	
	//@NotEmpty
	//@NotEmpty(message="{NotEmpty.userRegistration.firstname}") //OK
	//@Size(min=4,max=15,message="Firstname should be of min {min} and max {max} characters")
	// @Pattern(regexp = "[^a-z]*")
	private String firstname;
	
	//@NotEmpty(message="{NotEmpty.userRegistration.lastname}") //OK
	//@Size(min=4,max=15,message="lastname should be of min {min} and max {max} characters")
	private String lastname;
	
	//@NotEmpty
	//@NotEmpty(message="{NotEmpty.userRegistration.email}") //OK
	//@Email
	private String email;
	
	//@Range(min = 4, max = 150) 
	//@Min(value = 4,message = "{age.user.only}")
	//@Positive
	private int age;
	
	//@NotNull(message = "{user.birthday.notNull}")
	//@Past
	//@DateTimeFormat(pattern = "dd/MM/yyyy")
	//@Past(message = "Date of birth must be a past date")
	//@Past(message = "{user.birthday.past}")
	//@PresentOrPast(message = "Date of birth must be past date")
	private Date dob;
	
	//@Max(value = 999999999, message = "invalid mobile no")
	// @Max(999999999) //ok
	// @Min(value = 1000000000, message = "invalid mobile no")
	private List<Long> mobileNos;
	
	//@Size(min = 5, max = 10)
	//@IsValidHubby
	private List<String> hubby;
	
}
//9121291212
//757 rs 
//2104602 - acc no
//www.youbradband.com
// punya193 - username
// mobile app - quick pay
