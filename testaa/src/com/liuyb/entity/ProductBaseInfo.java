package com.liuyb.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="product_base_info")
public class ProductBaseInfo {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="prod_serialno", length=32)
	private Integer prodSerialno;
	@Column(name="prod_code")
	private String prodCode;
	@Column(name="prod_name")
	private String prodName;
	@Column(name="prod_manager")
	private String prodManager;
	@Column(name="admin_name")
	private String adminName;
	@Column(name="prod_service_mode", length=32)
	private String prodServiceMode;
	
	public Integer getProdSerialno() {
		return prodSerialno;
	}
	public void setProdSerialno(Integer prodSerialno) {
		this.prodSerialno = prodSerialno;
	}
	public String getProdCode() {
		return prodCode;
	}
	public void setProdCode(String prodCode) {
		this.prodCode = prodCode;
	}
	public String getProdName() {
		return prodName;
	}
	public void setProdName(String prodName) {
		this.prodName = prodName;
	}
	public String getProdManager() {
		return prodManager;
	}
	public void setProdManager(String prodManager) {
		this.prodManager = prodManager;
	}
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	public String getProdServiceMode() {
		return prodServiceMode;
	}
	public void setProdServiceMode(String prodServiceMode) {
		this.prodServiceMode = prodServiceMode;
	}
	public ProductBaseInfo() {
		super();
	}
	
}
