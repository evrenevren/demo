package com.demo.main.data.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@MappedSuperclass
@Data
public abstract class BaseEntity implements Serializable {

    @Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	private UUID id;

	@Basic
	@Version
	@Column(name = "update_date")
	private Date updateDate;

}
