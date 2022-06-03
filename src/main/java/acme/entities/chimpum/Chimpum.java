package acme.entities.chimpum;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;

import acme.entities.item.Item;
import acme.framework.datatypes.Money;
import acme.framework.entities.AbstractEntity;
import acme.roles.Inventor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Chimpum extends AbstractEntity{

	@Column(unique=true)
	@NotBlank
	@Pattern(regexp = "^\\d{4}-\\d{2}-\\d{2}$")
	protected String code;
	
	@Temporal(TemporalType.TIMESTAMP)
	@NotNull
	@Past
	protected Date creationMoment;
	
	@NotBlank
	@Length(max = 100)
	protected String title;
	
	@NotBlank
	@Length(max = 255)
	protected String description;
	
	@Temporal(TemporalType.TIMESTAMP)
	@NotNull
	protected Date startsAt;
	
	@Temporal(TemporalType.TIMESTAMP)
	@NotNull
	protected Date finishesAt;
	
	@NotNull
	protected Money budget;
	
	@URL
	protected String link;
	
	@ManyToOne
	@Valid
	protected Item item;
	
	@ManyToOne
	@Valid
	protected Inventor inventor;
}
