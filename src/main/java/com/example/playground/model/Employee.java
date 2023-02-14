package com.example.playground.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;


@Getter
@Setter
@ToString
@RequiredArgsConstructor
@DynamicInsert
@Entity
public class Employee
{
	@Id
	@Column(name = "id", insertable = false, nullable = false)
	private long id;
	@Column(name = "name", nullable = false)
	private String name;
}
