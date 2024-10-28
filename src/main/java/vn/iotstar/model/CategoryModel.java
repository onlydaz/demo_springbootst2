package vn.iotstar.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data 
public class CategoryModel implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	private  Long id;
	@NotEmpty(message = "Không được bỏ trống")
	private String name;
	private String images;
	private int status;

	private Boolean isEdit=false;
}
