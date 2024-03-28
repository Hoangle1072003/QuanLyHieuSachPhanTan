package models;



import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Objects;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "TacGia")
public class TacGia {
	@Id
	private String idTacGia;
	private String tenTacGia;
	private Date ngaySinh;
	private int soLuongTacPham;
}
