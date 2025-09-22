package com.yagmurbeyru.handler;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class Exception<E> {
	private String hostname;
	private String path;
	private Date createtTime;
	private E message;

}