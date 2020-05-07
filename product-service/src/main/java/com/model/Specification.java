package com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="Specification")
public class Specification {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator ="SPEC_SEQ")
	@SequenceGenerator(sequenceName = "SPEC_SEQ", allocationSize = 1, name = "SPEC_SEQ")
	@Column(name="SPEC_ID", unique = true, precision = 22)
	private Long specId;
	
	@Column(name="MODEL")
	private String model;
	
	@Column(name="COLOR")
	private String color;
	
	@Column(name="RAM")
	private String ram;
	
	@Column(name="PROCESSER_TYPE")
	private String processor;
	
	@Column(name="width")
	private Long width;
	
	@Column(name="Height")
	private Long height;
	
	@OneToOne
	@JoinColumn(name="PRODUCT_ID")
	private Product product;

	public Long getSpecId() {
		return specId;
	}

	public void setSpecId(Long specId) {
		this.specId = specId;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getRam() {
		return ram;
	}

	public void setRam(String ram) {
		this.ram = ram;
	}

	public String getProcessor() {
		return processor;
	}

	public void setProcessor(String processor) {
		this.processor = processor;
	}

	public Long getWidth() {
		return width;
	}

	public void setWidth(Long width) {
		this.width = width;
	}

	public Long getHeight() {
		return height;
	}

	public void setHeight(Long height) {
		this.height = height;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	@Override
	public String toString() {
		return "Specification [specId=" + specId + ", model=" + model + ", color=" + color + ", ram=" + ram
				+ ", processor=" + processor + ", width=" + width + ", height=" + height + ", product=" + product + "]";
	}
	
}
