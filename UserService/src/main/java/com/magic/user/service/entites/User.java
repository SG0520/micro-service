package com.magic.user.service.entites;

import java.util.ArrayList;
import java.util.List;

import com.magic.user.service.Vo.Rating;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity 
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="micro_users")

@Builder
public class User {
	
	@Id
	private String userId;
	private String name;
	private String email;
	
	@Transient
	@Builder.Default
	private  List<Rating>  ratings=new ArrayList<>(); 
	
	

}
