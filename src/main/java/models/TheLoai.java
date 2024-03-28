package models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "TheLoai")
public class TheLoai {
	@Id
	private String idTheLoai;
	private String tenTheLoai;
	private int soLuongSach;
	private String moTa;
}
