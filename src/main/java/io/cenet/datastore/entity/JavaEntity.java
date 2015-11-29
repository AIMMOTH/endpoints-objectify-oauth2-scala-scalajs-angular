package io.cenet.datastore.entity;

import com.googlecode.objectify.annotation.Cache;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;

@Entity
@Cache
public class JavaEntity {

	@Id
	public String name;
	public long lastModified;
	
	public JavaEntity() {
		lastModified = System.currentTimeMillis();
	}
	
	public JavaEntity(String name) {
		this();
		this.name = name;
	}
}
