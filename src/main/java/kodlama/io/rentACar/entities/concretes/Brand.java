package kodlama.io.rentACar.entities.concretes;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table (name="brands")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Brand {
	
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "yas")
	private int yas;
	
	@Column(name = "vites")
	private String vites;
	
	@Column(name = "Araba_rengi")
	private String renk;
	
	
	@Column(name= "Arac_durumu")
	private String aracDurumu;
  
	
	@Column(name= "kasa_tipi")
	private String kasaTipi;
	
	
	@Column(name= "fiyat")
	private int fiyat;
	
	@Column(name = "kilometre")
	private int kilometre;
	
	@Column(name= "motor_gücü")
	private int motorGucu;

  
}
