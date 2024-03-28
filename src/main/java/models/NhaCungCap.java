package models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "NhaCungCap")
public class NhaCungCap {
	@Id
	private String idNhaCungCap;
	private String tenNhaCungCap;
	private String diaChi;
	private String soDienThoai;
}
